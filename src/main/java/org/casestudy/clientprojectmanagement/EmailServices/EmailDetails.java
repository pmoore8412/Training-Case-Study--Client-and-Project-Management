package org.casestudy.clientprojectmanagement.EmailServices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {

    private String sender;
    private String subject;
    private String message;

}
