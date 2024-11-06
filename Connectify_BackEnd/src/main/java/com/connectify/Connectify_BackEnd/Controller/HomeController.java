package com.connectify.Connectify_BackEnd.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home1")
    public String homeControllerHandler()
    {
        return "This is Controller1";
    }

    @GetMapping("/home2")
    public String homeControllerHandler2()
    {
        return "This is Controller2";
    }
}
