package org.casestudy.clientprojectmanagement.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientProject {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "project_name", length = 1000)
    private String projectName;

    @Column(name = "project_description", length = 10000)
    private String projectDescription;

    @Column(name = "project_lead", length = 1000)
    private String projectLead;

    @Column(name = "lead_email", length = 1000)
    private String projectLeadEmail;

    @Column(name = "client_id", length = 1000)
    private String clientId;

}
