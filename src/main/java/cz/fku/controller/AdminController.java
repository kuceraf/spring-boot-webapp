package cz.fku.controller;

import org.apache.log4j.spi.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * Created by Filip on 25.02.2017.
 */

@RestController
@RequestMapping("/admin")
public class AdminController {
    Logger logger = Logger.getLogger("AdminController");
    @RequestMapping(method = RequestMethod.POST, value = "/movies")
    public String createMovie(@RequestBody String movie)
    {
        logger.info("Adding movie");
        return "created";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{movie}", produces={"application/json"})
    public String getMovie(@PathVariable String movie)
    {
        logger.info("Getting movie" + movie);
        return movie;
    }
}
