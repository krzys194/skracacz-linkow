package dev.greencashew.linkshortener.link;

import dev.greencashew.linkshortener.controller.LinkDto;

public interface LinkService {
    LinkDto createLink(LinkDto dto);

    LinkDto getLink(String id);
}
