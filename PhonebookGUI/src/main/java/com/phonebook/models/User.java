package com.phonebook.models;


// создаем объект и добавляем геттер и сеттеры, циклим на самих себя же
// внимание на каждую П и ее тип!!!
public class User {
    private String email;
    private String password;

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password =password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}