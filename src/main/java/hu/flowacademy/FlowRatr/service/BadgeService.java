package hu.flowacademy.FlowRatr.service;

import hu.flowacademy.FlowRatr.domain.Badge;
import hu.flowacademy.FlowRatr.domain.User;
import hu.flowacademy.FlowRatr.exception.ValidationErrorException;
import hu.flowacademy.FlowRatr.repository.BadgeRepository;
import hu.flowacademy.FlowRatr.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BadgeService {

    @Autowired
    private BadgeRepository badgeRepository;

    @Autowired
    private UserService userService;

    public Badge save(Badge badge) {
        List<Badge> allBadges = badgeRepository.findAll();
        for (Badge b: allBadges) {
            if (badge.getName().equals(b.getName())) {
                throw new ValidationErrorException();
            }
        }
        return badgeRepository.save(badge);
    }

    public Badge update(Badge badge) {
        if (badgeRepository.existsById(badge.getId())) {
            return badgeRepository.save(badge);
        }
        throw new ValidationErrorException();
    }

    public Badge getBadge(Long id) {
        return badgeRepository.getOne(id);
    }

    public List<Badge> getAllBadge() {
        return badgeRepository.findAll();
    }

    public void giveBadge(String username, Long id) {
        User u = userService.getUser(username);
        Badge b = badgeRepository.getOne(id);

        u.addBadge(b);
        b.addUser(u);
        userService.update(u);


    }

    public void giveBadge2(User user, Long id) {
        user.addBadge(badgeRepository.getOne(id));
    }
}
