package com.rami.controller;


import com.rami.User;
import com.rami.exception.RestServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private Logger LOG = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/insertuser", method = RequestMethod.POST)
    public ResponseEntity<String> insertUser(@RequestBody final User user) {
        LOG.info("Inserting User {}",user);

        if(!user.getEmail().contains("@")) { //simulate error
            throw new RestServiceException("User email format is invalid");
        }

        return new ResponseEntity<>(HttpStatus.ACCEPTED.getReasonPhrase(),HttpStatus.ACCEPTED);
    }
}
