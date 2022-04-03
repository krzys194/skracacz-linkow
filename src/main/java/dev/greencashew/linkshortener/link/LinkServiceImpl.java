package dev.greencashew.linkshortener.link;

import dev.greencashew.linkshortener.controller.LinkDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LinkServiceImpl implements LinkService {

    private final Map<String, LinkDto> repository = new HashMap<>();


    @Override
    public LinkDto createLink(LinkDto dto) {
        if(repository.containsKey(dto.id()))
        {
            throw  new LinkAlreadyExistsExeption(dto.id());
        }
       repository.put(dto.id(), dto);
        return dto;
    }

    @Override
    public LinkDto getLink(String id) {
        return repository.get(id);
    }
}
