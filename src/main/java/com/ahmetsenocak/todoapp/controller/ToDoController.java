package com.ahmetsenocak.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToDoController {

    @RequestMapping("list-todos")
    public String listAllTodos() {
        return "listToDos";
    }
}
