package com.booleanuk.api.repository;

import com.booleanuk.api.models.Author;

import java.util.ArrayList;

public class AuthorsRepository {

    private ArrayList<Author> authors;

    public AuthorsRepository() {
        this.authors = new ArrayList<>();

        this.authors.add(new Author("JRR Tolkien", "jrr@tolkien.com"));
        this.authors.add(new Author("Charles Dickens", "charles@bleakhouse.com"));
    }

    public ArrayList<Author> getAll(){
        return this.authors;
    }

    public Author getOne(int id) {
        for (Author author : this.authors) {
            if (author.getId() == id) {
                return author;
            }
        }
        return null;
    }

    public Author createOne(Author author){
        this.authors.add(author);

        return author;
    }

    public Author updateOne(int id, Author author){

        for(Author a : authors){
            if (author.getId() == id){
                a.setName(author.getName());
                a.setEmail(author.getEmail());

                return author;
            }
        }
        return null;
    }

    public Author removeOne(int id){
        for (Author a : authors){
            if(a.getId() == id){
                authors.remove(a);

                return a;
            }
        }
        return null;
    }



}
