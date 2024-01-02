package com.tnsid.tp_composants.mapper;

import com.tnsid.tp_composants.api.dto.MemeDto;
import com.tnsid.tp_composants.api.response.MemesResponse;
import com.tnsid.tp_composants.constant.TagEnum;
import com.tnsid.tp_composants.entity.Meme;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MemeMapper {

    public MemeDto toDto(Meme meme){
        return MemeDto.builder()
                .id(meme.getId().toHexString())
                .title(meme.getTitle())
                .link(meme.getLink())
                .description(meme.getDescription())
                .tag(meme.getTag())
                .build();
    }

    public MemesResponse toResponse(List<Meme> memes){
        final Map<TagEnum,Long> countByTag = memes.stream()
                .collect(Collectors.groupingBy(Meme::getTag, Collectors.counting()));

        final List<MemeDto> dtos = memes.stream()
                .map(this::toDto)
                .toList();

        return MemesResponse.builder()
                .memes(dtos)
                .countByTag(countByTag)
                .build();
    }
}
