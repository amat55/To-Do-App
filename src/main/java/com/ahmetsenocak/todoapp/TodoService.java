package com.ahmetsenocak.todoapp;

import com.ahmetsenocak.todoapp.toDo.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {


    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 3;

    static {
        todos.add(new Todo(1, "in28minutes", "Learn AWS",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2, "in28minutes", "Learn DevOps",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(3, "in28minutes", "Learn Full Stack Development",
                LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }

    public void addTodo(String name, String description,
                        LocalDate targetDate, boolean isDone) {

        Todo todo = new Todo(++todosCount, name, description, targetDate, isDone);
        todos.add(todo);
    }
}
