package org.casestudy.clientprojectmanagement.Repositories;

import org.casestudy.clientprojectmanagement.Entities.ClientProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientProjectRepository extends JpaRepository<ClientProject, String> {

    List<ClientProject> findByClientId(String clientId);
    void deleteAllByClientId(String clientId);

}
