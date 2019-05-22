package hu.flowacademy.FlowRatr;

import hu.flowacademy.FlowRatr.domain.User;
import hu.flowacademy.FlowRatr.repository.UserRespository;
import hu.flowacademy.FlowRatr.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.*;


@RunWith(SpringRunner.class)
public class UserServiceTest {

    @TestConfiguration
    static class UserServiceTestConfiguration {

        @Bean
        public UserService userService() {
            return new UserService();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRespository userRespository;

    @Before
    public void setup() {
        User userToBeSaved = new User("Karcsi", "Kis Karcsi", "jelszo", "nyugdijas");
        Mockito.when(userRespository.save(any(User.class))).thenReturn(userToBeSaved);
        Mockito.when(userRespository.findByUsername(userToBeSaved.getUsername())).thenReturn(userToBeSaved);
    }

    @Test
    public void whenUserSaved_thenReturnUserToBeSaved() {
        User userSaved = new User("Karcsi", "Kis Karcsi", "jelszo", "nyugdijas");
        User userToBeSaved = userRespository.save(userSaved);
        assertThat(userSaved).isEqualTo(userToBeSaved);

    }

    @Test
    public void whenUserNameToBeFound_thenReturnUserToBeSaved() {
        String usernameToBeFound = "Karcsi";
        User userToBeFound = userService.getUser(usernameToBeFound);
        assertThat(userToBeFound.getUsername()).isEqualTo(usernameToBeFound);
    }

}
