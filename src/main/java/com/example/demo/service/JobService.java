package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface JobService {
    ResponseEntity<String> getJobList();
    ResponseEntity<String> getJobDetail(String id);
}
