package org.casestudy.clientprojectmanagement.Controllers;

import org.casestudy.clientprojectmanagement.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

}
