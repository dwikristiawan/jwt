package com.example.demo.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JobService implements com.example.demo.service.JobService {
    @Autowired
    RestTemplate restTemplate;
    final String URL="http://dev3.dansmultipro.co.id/api/";
    @Override
    public ResponseEntity<String> getJobList() {
        ResponseEntity<String>response=restTemplate.getForEntity(URL+"/recruitment/positions.json",String.class);
        return response;

    }

    @Override
    public ResponseEntity<String> getJobDetail(String id) {
        ResponseEntity<String>response=restTemplate.getForEntity(URL+"/recruitment/positions/"+id,String.class);
        return response;
    }
}
