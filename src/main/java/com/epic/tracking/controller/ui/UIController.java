package com.epic.tracking.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {
    @GetMapping("/index")
    public String home() {
        return "index";
    }
}
