package com.example.JobMatee.repository;
import com.example.JobMatee.model.Job;
import java.util.List;

import com.example.JobMatee.model.JobSubType;
import com.example.JobMatee.model.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
//    List<Job> findByType(JobType type); // Find jobs by type
//    List<Job> findByTypeAndSubType(JobType type, JobSubType subType);

//    Job createJob(Job job);
//    List<Job> getAllJobs();
}

