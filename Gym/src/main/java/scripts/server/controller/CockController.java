package scripts.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CockController {

    @GetMapping("/cock")
    public String getCock() {
        return "page";
    }

}
