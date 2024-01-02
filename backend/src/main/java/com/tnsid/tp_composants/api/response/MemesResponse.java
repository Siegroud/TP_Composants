package com.tnsid.tp_composants.api.response;

import com.tnsid.tp_composants.api.dto.MemeDto;
import com.tnsid.tp_composants.constant.TagEnum;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class MemesResponse {

    private List<MemeDto> memes;

    private Map<TagEnum, Long> countByTag;
}
