package org.casestudy.clientprojectmanagement.Controllers;

import org.casestudy.clientprojectmanagement.Entities.AgreementFile;
import org.casestudy.clientprojectmanagement.Message.ResponseFile;
import org.casestudy.clientprojectmanagement.Message.ResponseMessage;
import org.casestudy.clientprojectmanagement.Services.AgreementFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/agreement-file")
@CrossOrigin
public class AgreementFileController {

    @Autowired
    AgreementFileService agreementFileService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file")MultipartFile file) {
        String message = "";

        try {
            agreementFileService.store(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = agreementFileService.getAllFiles().map(agreementFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(agreementFile.getId())
                    .toUriString();

            return new ResponseFile(agreementFile.getName(),
                    fileDownloadUri,
                    agreementFile.getType(),
                    agreementFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        AgreementFile agreementFile = agreementFileService.getFile(id);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + agreementFile.getName() + "\"")
                .body(agreementFile.getData());
    }
}
