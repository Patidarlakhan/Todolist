package com.example.To_do_application.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.To_do_application.models.TodoItem;
import com.example.To_do_application.services.TodoItemService;

@Controller
public class HomeController {
    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("")
    public ModelAndView Index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemService.getAll());
        return modelAndView;
    }
}
