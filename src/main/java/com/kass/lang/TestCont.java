package com.kass.lang;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kass on 2017-10-08.
 */
@RestController
public class TestCont {

    @RequestMapping("/hello")
    public String sauHello(){
        return "Hello";
    }
}
