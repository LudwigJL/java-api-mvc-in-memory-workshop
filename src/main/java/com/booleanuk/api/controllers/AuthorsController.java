package com.booleanuk.api.controllers;

import com.booleanuk.api.models.Author;
import com.booleanuk.api.repository.AuthorsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("authors")
public class AuthorsController {
    private AuthorsRepository theAuthors;

    public AuthorsController(){
        this.theAuthors = new AuthorsRepository();
    }

    @GetMapping
    public ArrayList<Author> getAllAuthors(){
        return this.theAuthors.getAll();
    }

    @GetMapping("/{id}")
    public Author getOne(@PathVariable(name = "id") int id) {
        return this.theAuthors.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author create(@RequestBody Author author){
        return this.theAuthors.createOne(author);
    }

    @PutMapping("{id}")
    public Author update(@PathVariable int id, @RequestBody Author insertAuthor){
        return this.theAuthors.updateOne(id, insertAuthor);

    }

    @DeleteMapping("{id}")
    public Author remove(@PathVariable int id){
        return this.theAuthors.removeOne(id);
    }


}
