package com.Rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import  com.sociochat.sociochatbackend.Dao.JobDao;
import  com.sociochat.sociochatbackend.model.JobDetail;


@RestController
public class JobController {

	@Autowired
    JobDao jobdao;
   
	@PostMapping(value="/addjob")
    public ResponseEntity<String> saveblog(@RequestBody JobDetail b)
    {
      if(jobdao.addJob(b))
      {
	    System.out.println(b);
        return new ResponseEntity<String>("Job added",HttpStatus.OK);
      }
      else
      {
	   return new ResponseEntity<String>(" error job added",HttpStatus.INTERNAL_SERVER_ERROR);	
      }
    }
}
