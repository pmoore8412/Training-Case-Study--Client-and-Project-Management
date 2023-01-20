package org.casestudy.clientprojectmanagement.Services;

import org.casestudy.clientprojectmanagement.Entities.ClientProject;
import org.casestudy.clientprojectmanagement.Repositories.ClientProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientProjectService {

    @Autowired
    ClientProjectRepository projectRepository;

    public void addNewProject(ClientProject project) {

        projectRepository.save(project);

    }

    public List<ClientProject> getAllProjects() {
        return projectRepository.findAll().stream().collect(Collectors.toList());
    }

    public ClientProject getAClientProject(String id) {

        return projectRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No project found with id: " + id));

    }

    public List<ClientProject> getAllClientProjects(String clientId) {

        return projectRepository.findByClientId(clientId).stream().collect(Collectors.toList());

    }

    public ClientProject updateClientProject(String id, ClientProject project) {

        Optional<ClientProject> updateProject = projectRepository.findById(id);

        if(updateProject.isPresent()) {
            updateProject.get().setProjectLead(project.getProjectLead());
            updateProject.get().setProjectLeadEmail(project.getProjectLeadEmail());
            updateProject.get().setProjectDescription(project.getProjectDescription());
            project = updateProject.get();
        }

        return projectRepository.save(project);

    }

    public void removeProject(String id) {

        ClientProject project = projectRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No project found with id: " + id));

        projectRepository.delete(project);
    }

}
