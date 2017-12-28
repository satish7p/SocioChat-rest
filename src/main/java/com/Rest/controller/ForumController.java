package com.Rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import  com.sociochat.sociochatbackend.Dao.ForumDao;
import  com.sociochat.sociochatbackend.model.Forum;



@RestController
public class ForumController {
	@Autowired
   ForumDao forumdao;
   
	@PostMapping(value="/addforum")
    public ResponseEntity<String> saveblog(@RequestBody Forum b)
    {
      if(forumdao.addForum(b))
      {
	    System.out.println(b);
        return new ResponseEntity<String>("Forum added",HttpStatus.OK);
      }
      else
      {
	   return new ResponseEntity<String>(" error Forum added",HttpStatus.INTERNAL_SERVER_ERROR);	
      }
    }
}