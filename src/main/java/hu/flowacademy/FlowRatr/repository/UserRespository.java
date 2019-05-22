package hu.flowacademy.FlowRatr.repository;

import hu.flowacademy.FlowRatr.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<User, String> {

    public User findByUsername(String username);
}
