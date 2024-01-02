package com.tnsid.tp_composants.api.request;

import com.tnsid.tp_composants.constant.TagEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemeUpdateRequest {

    private String title;

    private String description;

    private TagEnum tag;
}
