package com.codecool.web.repository;

    import com.codecool.web.model.User;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    Optional<User> findByActivationCode(String activationCode);

    Optional<User> findById(Integer userID);
}
