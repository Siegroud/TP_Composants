package com.tnsid.tp_composants.api.dto;


import com.tnsid.tp_composants.constant.TagEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemeDto {

    @Schema(
            description = "Unique identifier for the meme",
            example = "68546413545eerf87687"
    )
    private String id;


    @Schema(
            description="The title of the meme",
            example= "Loss"
    )
    private String title;

    @Schema(
            description = "Picture's url for the meme",
            example = "https://tenor.com/eVbyRDZgcAJ.gif"
    )
    private String link;

    @Schema(
            description = "A text that describes the meme",
            example = "Beautiful man looking a the camera"
    )
    private String description;

    @Schema(
            description = "Tag that describes the type of meme",
            example = "DANK"
    )
    private TagEnum tag;

}
