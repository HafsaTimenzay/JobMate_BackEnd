package com.example.JobMatee.repository;
import com.example.JobMatee.model.Job;
import java.util.List;

import com.example.JobMatee.model.JobSubType;
import com.example.JobMatee.model.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface JobRepository extends JpaRepository<Job, Long> {

//    @Query("SELECT j FROM Job j WHERE " +
//            "(LOWER(j.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR :keyword IS NULL) AND " +
//            "(LOWER(j.location) LIKE LOWER(CONCAT('%', :location, '%')) OR :location IS NULL) AND " +
//            "(LOWER(j.category) LIKE LOWER(CONCAT('%', :category, '%')) OR :category IS NULL) AND " +
//            "(LOWER(j.type) = LOWER(:type) OR :type IS NULL) AND " +
//            "(j.salary BETWEEN :minSalary AND :maxSalary OR (:minSalary IS NULL AND :maxSalary IS NULL)) AND " +
//            "(j.remote = :remote OR :remote IS NULL)")
////    List<Job> findByCriteria(String keyword, String location, String category, String type, Double minSalary, Double maxSalary, Boolean remote);
//    List<Job> findByType(JobType type); // Find jobs by type
//    List<Job> findByTypeAndSubType(JobType type, JobSubType subType);

//    Job createJob(Job job);
//    List<Job> getAllJobs();
}

