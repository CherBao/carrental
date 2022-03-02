package com.baoxue.carrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class HealthController {

    @RequestMapping(value = "/")
    public String healthCheck() {
        return "welcome";
    }
}
