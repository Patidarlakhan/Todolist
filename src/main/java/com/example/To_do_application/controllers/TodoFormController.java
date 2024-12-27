package com.example.To_do_application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.example.To_do_application.models.TodoItem;
import com.example.To_do_application.services.TodoItemService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class TodoFormController {

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/create-todo")
    public String showCreateForm(TodoItem todoItem) {
        return "new-todo-item";
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem) {
        //TODO: process POST request
        TodoItem item = new TodoItem();
        item.setDescription(todoItem.getDescription());
        item.setIsComplete(todoItem.getIsComplete());
        todoItemService.save(item);
        
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id, Model model) {
        TodoItem todoItem = todoItemService
                .getById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        todoItemService.delete(todoItem);
        return "redirect:/";
    }
    
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        TodoItem todoItem = todoItemService
                .getById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));
        model.addAttribute("todo", todoItem);
        return "edit-todo-item";
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable Long id,@Valid TodoItem todoItem,BindingResult result, Model model) {
        TodoItem Item = todoItemService
                .getById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));
        Item.setIsComplete(todoItem.getIsComplete());
        Item.setDescription(todoItem.getDescription());
        todoItemService.save(Item);
        return "redirect:/";
    }

}
