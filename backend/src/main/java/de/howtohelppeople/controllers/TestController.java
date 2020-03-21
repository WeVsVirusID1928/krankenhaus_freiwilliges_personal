package de.howtohelppeople.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> onResRequest() {
        return ResponseEntity.ok("{\"test\": \"ok\"}");
    }
}
