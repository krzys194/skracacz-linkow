package dev.greencashew.linkshortener.controller;

import dev.greencashew.linkshortener.CreateLinkDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/links")
@RestController

public class LinkManageController {
    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    LinkDto createLink(@RequestBody CreateLinkDto link){
        return link.toDto();
    }
}
