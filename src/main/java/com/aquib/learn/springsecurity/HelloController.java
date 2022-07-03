package com.aquib.learn.springsecurity;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

   @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/login/")
    public String login(@RequestBody LoginRequest loginRequest){
       log.info("INFO LOG");
       log.trace("TRACE LOG");
       log.debug("DEBUG LOG");
       return "Login request";
    }

    @PostMapping("/signUp/")
    public String signUp(@RequestBody SignupRequest signupRequest){
        System.out.println(signupRequest);

        Authentication authentication = new UsernamePasswordAuthenticationToken("","");
        return "Login request";
    }


    @GetMapping("/user")
    public String userLogin(){
        MDC.put("userId","user1");
        log.info("INFO LOG");
        log.trace("TRACE LOG");
        log.debug("DEBUG LOG");
       return "<h1>Hello User.</h1>";
    }


    @GetMapping("/admin")
    public String adminLogin(){
        return "<h1>Hello Admin.</h1>";
    }
}