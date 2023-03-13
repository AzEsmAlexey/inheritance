package ru.netology.repository;

public class NotFoundException extends RuntimeException {

    public NotFoundException(int id) {
        super("Item with id: " + id + " not found");
    }
}
