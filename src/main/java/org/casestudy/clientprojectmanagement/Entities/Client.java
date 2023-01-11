package org.casestudy.clientprojectmanagement.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "client_name", unique = true, nullable = false, length = 1000)
    private String clientName;

    @Column(name = "client_description", length = 10000)
    private String clientDescription;


}
