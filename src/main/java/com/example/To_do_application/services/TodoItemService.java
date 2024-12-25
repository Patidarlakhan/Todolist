package com.example.To_do_application.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.To_do_application.models.TodoItem;
import com.example.To_do_application.repositories.TodoItemRepository;

import jakarta.websocket.server.ServerEndpoint;

@Service
public class TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    public Iterable<TodoItem> getAll(){
        return todoItemRepository.findAll();
    }

    public Optional<TodoItem> getById(Long Id){
        return todoItemRepository.findById(Id);
    }

    public TodoItem saveAll(TodoItem todoItems){
        if(todoItems.getId()== null){
            todoItems.setCreatedAt(Instant.now());
        }
        todoItems.setUpdatedAt(Instant.now());
        return todoItemRepository.save(todoItems);
    }

    public  void delete(TodoItem todoItem){
        todoItemRepository.delete(todoItem);
    }
}
