package project.declaration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import project.HttpEndpoint;

@Controller
public class ErrorController {

    @GetMapping(HttpEndpoint.ACCESS_DENIED)
    public String accessDenied() {
        return HttpEndpoint.ACCESS_DENIED_VIEW;
    }
}
