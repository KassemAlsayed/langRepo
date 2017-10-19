package com.kass.lang;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kass on 2017-10-08.
 */

@Controller
public class MVCcont {

    @RequestMapping("/welcome")
    public ModelAndView helloWorld() {

        String message = "Welcom from Kass - coming from MVCont.java";
        return new ModelAndView("welcome", "message", message);
    }
}