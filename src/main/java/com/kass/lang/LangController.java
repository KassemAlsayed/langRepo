package com.kass.lang;

import com.kass.lang.domain.Language;
import com.kass.lang.service.LanguageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import java.util.List;

/**
 * Created by kass on 2017-10-10.
 */
@RestController
public class LangController {
    // GET /languages
    // GET /languages/id
    // GET /languages/?name=name
    // POST /languages
    // DELETE /languages/id
    // DELETE /languages/?name=cc
    // PUT /languages

    private static final Logger logger = LoggerFactory.getLogger(LangController.class);


    @Autowired
    LanguageService langService;

    @RequestMapping(method = RequestMethod.GET, value = "/languages")
    public Iterable<Language> getAllLanguages(@Context HttpServletRequest request,
                                              @Context HttpServletResponse resposne) {
        logger.info("{} {}", request.getMethod(), request.getRequestURI());

        resposne.setHeader("Access-Control-Allow-Origin", "*");

        return langService.getAllLanguages();
    }

    @RequestMapping("/languages/{id}")
    public Language getLanguage(@PathVariable int id,
                                @Context HttpServletRequest request,
                                @Context HttpServletResponse resposne) {
        logger.info("{} {}", request.getMethod(), request.getRequestURI());

        resposne.setHeader("Access-Control-Allow-Origin", "*");

        return langService.getLanguage(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/languages/")
    public Language findByLanguageName(@RequestParam(value = "name") String name,
                                       @Context HttpServletRequest request,
                                       @Context HttpServletResponse resposne) {
        logger.info("{} {}", request.getMethod(), request.getRequestURI());

        return langService.findByLanguageName(name);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/languages/{id}")
    public void deleteLanguage(@PathVariable int id,
                               @Context HttpServletRequest request,
                               @Context HttpServletResponse resposne) {
        logger.info("{} {}", request.getMethod(), request.getRequestURI());

        resposne.setHeader("Access-Control-Allow-Origin", "*");
        langService.deleteLanguage(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/languages/")
    public void deleteLanguageByName(@RequestParam(value = "name") String name,
                                     @Context HttpServletRequest request,
                                     @Context HttpServletResponse resposne) {
        logger.info("{} {}", request.getMethod(), request.getRequestURI());

        langService.deleteLanguageByName(name);
    }

    /*
        {
            "name": "Java",
            "icon": "javaIcon",
            "comment": "this is java comment"
        }
     */
    @RequestMapping(method = RequestMethod.POST, value = "/languages",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Language addLanguage(@RequestBody Language lang,
                                @Context HttpServletRequest request,
                                @Context HttpServletResponse resposne) {
        logger.info("{} {} Lang: {}", request.getMethod(), request.getRequestURI(), lang);

        resposne.setHeader("Access-Control-Allow-Origin", "*");

        langService.addLanguage(lang);
        return langService.getLanguage(lang.getId());
    }

    /*
        {
            "name": "Java",
            "icon": "javaIcon",
            "comment": "this is java comment"
        }
     */
    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/languages",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Language updateLanguage(@RequestBody Language lang,
                                   @Context HttpServletRequest request,
                                   @Context HttpServletResponse resposne) {

        logger.info("{} {} Lang: {}", request.getMethod(), request.getRequestURI(), lang);
        resposne.setHeader("Access-Control-Allow-Origin", "*");

        langService.updateLanguage(lang);
        return langService.getLanguage(lang.getId());

    }
}
