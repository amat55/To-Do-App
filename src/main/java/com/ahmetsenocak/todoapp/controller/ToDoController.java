package com.ahmetsenocak.todoapp.controller;

import com.ahmetsenocak.todoapp.TodoService;
import com.ahmetsenocak.todoapp.toDo.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ToDoController {


    private TodoService todoService;

    public ToDoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }


    @RequestMapping("listToDos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUsername("in28minutes");
        model.addAttribute("todos", todos);

        return "listToDos";
    }


    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodo() {
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(@RequestParam String description, ModelMap modelMap) {
        String name = (String) modelMap.get("name");
        todoService.addTodo(name, description, LocalDate.now().plusYears(1), false);
        return "redirect:listToDos";
    }
}


/*
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>


\META-INF\resources\webjars\bootstrap\5.1.3\css\bootstrap.min-jsf.css
\META-INF\resources\webjars\bootstrap\5.1.3\js\bootstrap.min.js
\META-INF\resources\webjars\jquery\3.6.0\jquery.min.js
 */
