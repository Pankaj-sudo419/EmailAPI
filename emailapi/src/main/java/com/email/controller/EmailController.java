package com.email.controller;

import com.email.model.EmailRequest;
import com.email.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class EmailController {
    @Autowired
    private EmailService emailService;
    @RequestMapping("/welcome")
    public String welcome(){
        return "Hello world";
    }
    @RequestMapping(value = "/sendMail",method = RequestMethod.POST)
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){

        System.out.println(request);
        boolean result =  this.emailService.sendEmail(request.getSubject(),request.getMessage(),request.getTo());
        if(result){
            return ResponseEntity.ok("Email send...");
        }
        else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email Not send");
        }
    }
}
