package org.casestudy.clientprojectmanagement.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "client_name", unique = true, nullable = false, length = 1000)
    private String clientName;

    @Column(name = "client_description", length = 10000)
    private String clientDescription;

    @Column(name = "agreement_file", length = 1000)
    private String agreementFile;


}
