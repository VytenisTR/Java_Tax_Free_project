package project.declaration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import project.HttpEndpoint;

@Controller
public class LoginController {

    @GetMapping(HttpEndpoint.LOGIN)
    public String loginPage() {
        return HttpEndpoint.LOGIN_VIEW;
    }
}
