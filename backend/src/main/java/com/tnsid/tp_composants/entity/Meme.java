package com.tnsid.tp_composants.entity;


import com.tnsid.tp_composants.constant.TagEnum;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("memes")
public class Meme {

    @Id
    private ObjectId id;

    private String title;

    private String link;

    private String description;

    private TagEnum tag;
}
