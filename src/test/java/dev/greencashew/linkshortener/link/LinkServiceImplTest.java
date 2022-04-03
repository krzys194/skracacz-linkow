package dev.greencashew.linkshortener.link;

import dev.greencashew.linkshortener.controller.LinkDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkServiceImplTest {
    @Test
    void shouldThrowExceptionWhenLinkIsDuplicated() throws LinkAlreadyExistsExeption {
        // given
        LinkDto firstDto = new LinkDto("test", "test@emil.com", "http://gooogle.pl", null, 0);
        LinkDto secondDto = new LinkDto("test", "haker@emil.com", "http://gooogle.pl", null, 0);
        LinkService service = new LinkServiceImpl();
        service.createLink(firstDto);
        // when
        LinkAlreadyExistsExeption thrown = assertThrows(
                LinkAlreadyExistsExeption.class,
                () -> service.createLink(secondDto),
                "Expected doThing() to throw, but it didn't"
        );
    }
}