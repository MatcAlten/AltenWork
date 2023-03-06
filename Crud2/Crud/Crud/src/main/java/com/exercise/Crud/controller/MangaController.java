package com.exercise.Crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//Controller utilizzato attualmente come demo per delle future View
@Controller
public class MangaController {

    @RequestMapping("/home")
    public String home(){

        return "home";
    }

    @RequestMapping("/manga")
    @ResponseBody
    public String manga(){

        return "MANGAMANGAMANGAMANGAMANGAMANGAMANGAMANGA";
    }

}
