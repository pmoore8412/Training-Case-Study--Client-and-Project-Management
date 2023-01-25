package org.casestudy.clientprojectmanagement.EmailServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/contact-us")
public class EmailController {

    @Autowired
    EmailServiceImpl emailService;

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody EmailDetails details) {
        return emailService.sendEmail(details);
    }

}
