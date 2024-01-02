package com.tnsid.tp_composants.api.request;

import com.tnsid.tp_composants.constant.TagEnum;
import lombok.Data;

@Data
public class MemeCreationRequest {
    private String title;

    private String link;

    private String description;

    private TagEnum tag;
}
