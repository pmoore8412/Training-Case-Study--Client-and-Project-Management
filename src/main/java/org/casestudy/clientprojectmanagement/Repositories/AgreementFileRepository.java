package org.casestudy.clientprojectmanagement.Repositories;

import org.casestudy.clientprojectmanagement.Entities.AgreementFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgreementFileRepository extends JpaRepository<AgreementFile, String> {
}
