package com.example.To_do_application.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.To_do_application.models.TodoItem;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long>{
    
}
