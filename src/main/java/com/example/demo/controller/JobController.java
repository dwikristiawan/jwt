package com.example.demo.controller;

import com.example.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/job")
public class JobController {
    @Autowired
    JobService jobService;
    @GetMapping("/list")
    ResponseEntity<String> getJobList(){
        return jobService.getJobList();
    }
    @GetMapping("/list/{id}")
    ResponseEntity<String> getJobDetail(@PathVariable("id") String id){
        return jobService.getJobDetail(id);
    }
}
