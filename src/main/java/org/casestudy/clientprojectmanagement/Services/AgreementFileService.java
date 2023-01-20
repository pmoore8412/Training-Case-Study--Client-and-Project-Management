package org.casestudy.clientprojectmanagement.Services;

import org.casestudy.clientprojectmanagement.Entities.AgreementFile;
import org.casestudy.clientprojectmanagement.Repositories.AgreementFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class AgreementFileService {

    @Autowired
    AgreementFileRepository agreementFileRepository;

    public AgreementFile store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        AgreementFile agreementFile = new AgreementFile(fileName, file.getContentType(), file.getBytes());

        return agreementFileRepository.save(agreementFile);
    }

    public AgreementFile getFile(String id) {
        return agreementFileRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No file found with id: " + id));
    }

    public Stream<AgreementFile> getAllFiles() {
        return agreementFileRepository.findAll().stream();
    }

}
