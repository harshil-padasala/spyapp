package code.app.spy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping
    public String redirectToSpyIndex() {
        return "redirect:/spy/index";
    }

}
