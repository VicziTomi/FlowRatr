package hu.flowacademy.FlowRatr.service;

import hu.flowacademy.FlowRatr.domain.User;
import javax.transaction.Transactional;
import hu.flowacademy.FlowRatr.exception.ValidationErrorException;
import hu.flowacademy.FlowRatr.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRespository userRespository;

    public User save(User user) {
        List<User> allUser = userRespository.findAll();
        for (User u: allUser) {
            if (user.getUsername().equals(u.getUsername())) {
                throw new ValidationErrorException();
            }
        }
        return userRespository.save(user);
    }

    public User update(User user) {
        if (userRespository.existsById(user.getUsername())) {
            return userRespository.save(user);
        }
        throw new ValidationErrorException();
    }

    public User getUser(String username) {
        return userRespository.findByUsername(username);
    }

    public List<User> getAllUser() {
        return userRespository.findAll();
    }

}
