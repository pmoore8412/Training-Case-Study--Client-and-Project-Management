package org.casestudy.clientprojectmanagement.Repositories;

import org.casestudy.clientprojectmanagement.Entities.ClientAgreementFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientAgreementFileRepository extends JpaRepository<ClientAgreementFile, String> {
}
