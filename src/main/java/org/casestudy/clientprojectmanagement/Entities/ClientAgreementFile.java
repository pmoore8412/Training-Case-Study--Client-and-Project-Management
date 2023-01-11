package org.casestudy.clientprojectmanagement.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "client_agreement_files")
@Getter
@Setter
@NoArgsConstructor
public class ClientAgreementFile {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    private String type;

    @Lob
    private byte[] data;

    public ClientAgreementFile(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }
}
