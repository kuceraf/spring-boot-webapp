package cz.fku.controller;

import cz.fku.model.GreetingTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Filip on 18.02.2017.
 */

//handler classe and handler method for /greeting to DispatcherServlet.
@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET, value = "/greeting", produces={"application/json"})
    public GreetingTO greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new GreetingTO(counter.incrementAndGet(),
                String.format(template, name));
    }
}
