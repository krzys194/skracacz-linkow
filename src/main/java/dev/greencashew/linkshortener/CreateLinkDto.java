package dev.greencashew.linkshortener;

import dev.greencashew.linkshortener.controller.LinkDto;

import java.time.LocalDate;

public record CreateLinkDto(String id,
                            String email,
                            String targetUrl,
                            LocalDate expirationDate) {

    public LinkDto toDto(){
        return new LinkDto(
                id,
                email,
                targetUrl,
                expirationDate,
                0
        );
    }
}
