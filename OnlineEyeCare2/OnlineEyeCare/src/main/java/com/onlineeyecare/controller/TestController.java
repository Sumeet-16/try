package com.onlineeyecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineeyecare.dto.TestModule;
import com.onlineeyecare.exceptions.TestIdNotFoundException;
import com.onlineeyecare.service.ITestService;


@RestController
@RequestMapping("/v1")
public class TestController {
	
	@Autowired
	public ITestService tservice;
	
     @GetMapping("/alltests")
     public List<TestModule> viewAllTests(){
    	 return tservice.viewAllTests();
     }
 
     @PostMapping("/test/add")
     public TestModule add(@RequestBody TestModule test)  {
		return tservice.addTest(test);
     }

 	
    @DeleteMapping("/test/remove/{testId}")
    public TestModule removeTest(@PathVariable int testId) throws TestIdNotFoundException  {
		return tservice.removeTest(testId);
    }
   
    @PutMapping("/test/update")
    public TestModule updateTest(@RequestBody TestModule test) {
    	return tservice.updateTest(test);
    }
  
    
    @GetMapping("/test/viewtest/{testid}")  
    private TestModule viewTest(@PathVariable("testid") int testid) throws TestIdNotFoundException   
    {  
    return tservice.viewTest(testid);
    }
}
