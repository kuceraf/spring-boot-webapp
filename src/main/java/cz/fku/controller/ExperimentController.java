package cz.fku.controller;

import cz.fku.exception.CustomException;
import cz.fku.model.GreetingTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * Created by Filip on 19.02.2017.
 */
@Controller
public class ExperimentController {
    @Autowired
    private ApplicationContext context;


    @RequestMapping("/httperror")
    public ResponseEntity<String> httpError() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");
        return new ResponseEntity<String>("BAD_REQUEST", responseHeaders, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(path = "/exception/{id}", produces = "application/json")
    public ResponseEntity<String> exception(@PathVariable Long id) throws Exception {
//        kdyz klient do hlavicky requestu nastavi:
//        Accept = text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
//        pouzije se DefaultErrorViewResolver (ktery nenalezne zadne chybove html view)

//        kdyz klient do hlavicky requestu nastavi:
//        Accept = application/json

//        Při vyhození výjímky se snaží Tomcat najít error page a když jí nenajde zavolá /error, kde je jako handler BasicErrorController
//        , který se přes registrovaná errorViewResolvers, snaží najít View pro vykreslení chyby

//        V ServerCustomization se nastavi tomcatu error page
        throw new CustomException("Entity with id " + id + " not found");
    }
}
