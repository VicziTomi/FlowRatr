package hu.flowacademy.FlowRatr.repository;

import hu.flowacademy.FlowRatr.domain.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Long> {
}
