package dev.greencashew.linkshortener.link;

public class LinkAlreadyExistsExeption extends RuntimeException {
    public LinkAlreadyExistsExeption(String id) {
        super("Link id "+id+" already exists.");
    }
}
