package org.casestudy.clientprojectmanagement.Services;

import org.casestudy.clientprojectmanagement.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

}
