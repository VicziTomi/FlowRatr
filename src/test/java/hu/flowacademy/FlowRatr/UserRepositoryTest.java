package hu.flowacademy.FlowRatr;

import hu.flowacademy.FlowRatr.domain.User;
import hu.flowacademy.FlowRatr.repository.UserRespository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class    UserRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRespository userRespository;

    @Test
    public void whenFindByUsername_thenReturnUser() {
        User userToBeFound = new User("testUser", "Test juzer", "pwd", "kiscica");
        entityManager.persist(userToBeFound);
        entityManager.flush();
        User userFound = userRespository.findByUsername(userToBeFound.getUsername());
        assertThat(userFound.getUsername()).isEqualTo(userToBeFound.getUsername());
    }

}
