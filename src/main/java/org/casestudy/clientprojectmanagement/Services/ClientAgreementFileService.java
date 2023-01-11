package org.casestudy.clientprojectmanagement.Services;

import org.casestudy.clientprojectmanagement.Entities.ClientAgreementFile;
import org.casestudy.clientprojectmanagement.Repositories.ClientAgreementFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class ClientAgreementFileService {

    @Autowired
    ClientAgreementFileRepository clientAgreementFileRepository;

    public ClientAgreementFile addAgreementFile(MultipartFile agreementFile) throws IOException {
        String fileName = StringUtils.cleanPath(agreementFile.getOriginalFilename());
        ClientAgreementFile clientAgreementFile =
                new ClientAgreementFile(fileName, agreementFile.getContentType(),agreementFile.getBytes());

        return clientAgreementFileRepository.save(clientAgreementFile);
    }

    public ClientAgreementFile getAgreementFile(String id) {
        return clientAgreementFileRepository.findById(id).get();
    }

    public Stream<ClientAgreementFile> getAllAgreementFiles() {
        return clientAgreementFileRepository.findAll().stream();
    }
}
