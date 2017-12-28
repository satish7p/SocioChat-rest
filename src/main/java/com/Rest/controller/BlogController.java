package com.Rest.controller;

import java.util.ArrayList;

//import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sociochat.sociochatbackend.Dao.BlogDao;
import com.sociochat.sociochatbackend.model.Blog;
	
@RestController
public class BlogController {

	@Autowired
  BlogDao blogdao;
 
	@RequestMapping(value="/addBlog")
  public ResponseEntity<String> saveblog(@RequestBody Blog b)
  {
    if(blogdao.addBlog(b))
    {
	    System.out.println(b);
      return new ResponseEntity<String>("blog added",HttpStatus.OK);
    }
    else
    {
	   return new ResponseEntity<String>(" error blog added",HttpStatus.INTERNAL_SERVER_ERROR);	
    }
  }
	@RequestMapping(value="/getAllBlogs")
	public ResponseEntity<ArrayList<Blog>> getAllBlogs()
	{
		ArrayList listBlogs = (ArrayList)blogdao.getAllBlogs();
		return new ResponseEntity<ArrayList<Blog>>(listBlogs,HttpStatus.OK);
	}
	@PostMapping(value="/updateBlog")
	public  ResponseEntity<String> updateBlog(@RequestBody Blog blog)
	{
		Blog tempBlog=blogdao.getBlog(blog.getBlogId());
		
		
		
		tempBlog.setBlogName(blog.getBlogName());
		tempBlog.setBlogContent(blog.getBlogContent());
		if(blogdao.updateBlog(tempBlog))
		{
			return new ResponseEntity<String>("Blog Update",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Error in Blog updation",HttpStatus.SERVICE_UNAVAILABLE);
			
		}
	}
	@PostMapping(value = "deleteBlog")
	public ResponseEntity<String> deleteBlog(@RequestBody Blog blog)
	{
		Blog tempblog=blogdao.getBlog(blog.getBlogId());
		if(blogdao.deleteBlog(tempblog))
		{
			return new ResponseEntity<String>("Blog Deleted",HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>("Error in blog deletion",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}


}













































































































































































































































































































































































































