package com.phonebook.models;

public class Contact { 
    private String name;
    private String lastname;
    private String phone;
    private String email;
    private String city;
    private String descritption;

    // П всегда приват!
    // вместо void в setter пишем имя класса Contact  - выделяем void -> command R

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public Contact setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Contact setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }

    public Contact setCity(String city) {
        this.city = city;
        return this;
    }

    public Contact setDescritption(String descritption) {
        this.descritption = descritption;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getDescritption() {
        return descritption;
    }
}