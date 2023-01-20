package org.casestudy.clientprojectmanagement.Repositories;

import org.casestudy.clientprojectmanagement.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
