package org.casestudy.clientprojectmanagement.Controllers;

import org.casestudy.clientprojectmanagement.Entities.ClientProject;
import org.casestudy.clientprojectmanagement.Services.ClientProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client-projects")
@CrossOrigin
public class ClientProjectController {

    @Autowired
    ClientProjectService projectService;

    @PostMapping("/new-project")
    public void addNewProject(@RequestBody ClientProject project) {
        projectService.addNewProject(project);
    }

    @GetMapping("/list-all-projects")
    public List<ClientProject> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/project/{id}")
    public ClientProject getAClientProject(@PathVariable(name = "id") String id) {
        return projectService.getAClientProject(id);
    }

    @GetMapping("/project/get-all-by-client-id/{clientId}")
    public List<ClientProject> getAllClientProjects(@PathVariable(name = "clientId") String clientId) {
        return projectService.getAllClientProjects(clientId);
    }

    @PutMapping("/update-project/{id}")
    public ClientProject updateClientProject(@PathVariable(name = "id") String id, @RequestBody ClientProject project) {
        return projectService.updateClientProject(id, project);
    }

    @DeleteMapping("/remove-project/{id}")
    public void removeProject(@PathVariable(name = "id") String id) {
        projectService.removeProject(id);
    }

}
