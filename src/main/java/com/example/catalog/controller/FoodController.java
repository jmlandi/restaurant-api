package com.example.catalog.controller;

import com.example.catalog.food.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){
        return repository.findAll().stream().map(FoodResponseDTO::new).toList();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<String> saveFood(@RequestBody FoodRequestDTO data){
        Food food = new Food(data);
        repository.save(food);
        return new ResponseEntity<>("Created", HttpStatusCode.valueOf(201));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping
    public ResponseEntity<String> deleteFood(@RequestParam String id){
        Food food = repository.getReferenceById(id);
        repository.delete(food);
        return new ResponseEntity<>("Deleted", HttpStatusCode.valueOf(200));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping
    public ResponseEntity<String> updateFood(@RequestBody FoodUpdateDTO data){
        Food food = repository.getReferenceById(data.id());
        food.setTitle(data.title());
        food.setImage(data.image());
        food.setPrice(data.price());
        repository.save(food);
        return new ResponseEntity<>("Updated", HttpStatusCode.valueOf(200));
    }

}
