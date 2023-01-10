package org.casestudy.clientprojectmanagement.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.util.UUID;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true, nullable = false)
    private UUID id;

    @Column(name = "client_name", unique = true, nullable = false, length = 1000)
    private String clientName;

    @Column(name = "client_description", length = 10000)
    private String clientDescription;

    @Column(name = "client_agreement", updatable = false)
    private File clientAgreement;

}
