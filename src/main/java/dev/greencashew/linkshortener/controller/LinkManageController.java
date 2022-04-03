package dev.greencashew.linkshortener.controller;

import dev.greencashew.linkshortener.CreateLinkDto;
import dev.greencashew.linkshortener.link.LinkAlreadyExistsExeption;
import dev.greencashew.linkshortener.link.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/links")
class LinkManageController {

    //    ALT + ENTER
    private final LinkService service;

    @Autowired
    LinkManageController(LinkService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> createLink(@RequestBody CreateLinkDto link) {
        try {
            LinkDto linkDto = link.toDto();
            return ResponseEntity
                    .created(URI.create(linkDto.getShortenedLink()))
                    .body(service.createLink(linkDto));
        } catch (LinkAlreadyExistsExeption e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new ExceptionResponse(e.getMessage()));
        }
    }
}
