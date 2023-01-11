package org.casestudy.clientprojectmanagement.Controllers;

import org.casestudy.clientprojectmanagement.Entities.ClientAgreementFile;
import org.casestudy.clientprojectmanagement.Messages.ResponseMessage;
import org.casestudy.clientprojectmanagement.Services.ClientAgreementFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/client-agreement-file")
@CrossOrigin
public class ClientAgreementFileController {

    @Autowired
    ClientAgreementFileService clientAgreementFileService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> addAgreementFile(@RequestParam("agreementFile")MultipartFile agreementFile) {
        String message = "";

        try {
            clientAgreementFileService.addAgreementFile(agreementFile);

            message = "Uploaded the file successfully: " + agreementFile.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + agreementFile.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getAgreementFile(@PathVariable String id) {
        ClientAgreementFile agreementFile = clientAgreementFileService.getAgreementFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
                        + agreementFile.getName() + "\"")
                .body(agreementFile.getData());
    }

}
