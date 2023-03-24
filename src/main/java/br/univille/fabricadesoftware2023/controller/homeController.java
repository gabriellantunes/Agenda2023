package br.univille.fabricadesoftware2023.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class homeController {
  
    @GetMapping
    @ResponseBody
    public ModelAndView index() {
        return new ModelAndView("home/index");
    }
}
