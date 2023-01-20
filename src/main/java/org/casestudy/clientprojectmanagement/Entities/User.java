package org.casestudy.clientprojectmanagement.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "first_name", nullable = false, length = 1000)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 1000)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false, length = 1000)
    private String email;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;

}
