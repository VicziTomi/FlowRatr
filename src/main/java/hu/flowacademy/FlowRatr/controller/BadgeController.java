package hu.flowacademy.FlowRatr.controller;

import hu.flowacademy.FlowRatr.domain.Badge;
import hu.flowacademy.FlowRatr.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/badge")
public class BadgeController {

    @Autowired
    private BadgeService badgeService;

    @PostMapping("/add")
    public ResponseEntity<Badge> addBadge(@RequestBody Badge badge) {
        return ResponseEntity.ok(badgeService.save(badge));
    }

    @PutMapping("/update")
    public ResponseEntity<Badge> modBadge(@RequestBody Badge badge) {
        return ResponseEntity.ok(badgeService.update(badge));
    }

}
