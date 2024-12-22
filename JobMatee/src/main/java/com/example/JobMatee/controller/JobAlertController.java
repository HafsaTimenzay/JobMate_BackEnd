package com.example.JobMatee.controller;

import com.example.JobMatee.model.JobAlert;
import com.example.JobMatee.service.JobAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-alerts")
public class JobAlertController {

    @Autowired
    private JobAlertService jobAlertService;

    /**
     * Get job alerts for a candidate.
     */
    @GetMapping("/{candidateId}")
    public ResponseEntity<List<JobAlert>> getJobAlerts(@PathVariable Long candidateId) {
        List<JobAlert> alerts = jobAlertService.getJobAlertsForCandidate(candidateId);
        return ResponseEntity.ok(alerts);
    }

    /**
     * Mark a job alert as seen.
     */
    @PutMapping("/{alertId}/mark-seen")
    public ResponseEntity<String> markJobAlertAsSeen(@PathVariable Long alertId) {
        jobAlertService.markJobAlertAsSeen(alertId);
        return ResponseEntity.ok("Job alert marked as seen");
    }
}

