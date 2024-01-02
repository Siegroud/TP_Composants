package com.tnsid.tp_composants.repository;

import com.tnsid.tp_composants.constant.TagEnum;
import com.tnsid.tp_composants.entity.Meme;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MemeRepository extends MongoRepository<Meme, ObjectId> {
    List<Meme> findByTitle(String title);

    Meme findById(String id);

    List<Meme> findAllByTagIn(Iterable<TagEnum> tags);
}
