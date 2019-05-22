package hu.flowacademy.FlowRatr.service;

import hu.flowacademy.FlowRatr.domain.Badge;
import hu.flowacademy.FlowRatr.exception.ValidationErrorException;
import hu.flowacademy.FlowRatr.repository.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BadgeService {

    @Autowired
    private BadgeRepository badgeRepository;

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
}
