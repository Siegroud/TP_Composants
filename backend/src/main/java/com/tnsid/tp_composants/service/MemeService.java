package com.tnsid.tp_composants.service;

import com.tnsid.tp_composants.api.request.MemeCreationRequest;
import com.tnsid.tp_composants.api.request.MemeUpdateRequest;
import com.tnsid.tp_composants.constant.TagEnum;
import com.tnsid.tp_composants.entity.Meme;
import com.tnsid.tp_composants.mapper.MemeMapper;
import com.tnsid.tp_composants.repository.MemeRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemeService {

    private final MemeRepository memeRepository;

    /**
     * Creates an {@link Meme} from a request
     *
     * @param request   The request containing {@link Meme}'s data
     * @return          The created {@link Meme}
     */
    public Meme create(MemeCreationRequest request){
        final Meme meme = Meme.builder()
                .title(request.getTitle())
                .link(request.getLink())
                .description(request.getDescription())
                .tag(request.getTag())
                .build();
        return memeRepository.insert(meme);
    }


    /**
     * Gets every known {@link Meme}
     *
     * @param tags  A list of tags to filter on. Ignore if null or empty provided.
     * @return      A list of known {@link Meme}s
     */
    public List<Meme> getAll(List<TagEnum> tags){
        if (CollectionUtils.isEmpty(tags)){
            return memeRepository.findAll();
        } else {
            return memeRepository.findAllByTagIn(tags);
        }
    }

    /**
     * Gets a {@link Meme} from its id
     *
     * @param memeId    The id of the desired {@link Meme}
     * @return          The matching {@link Meme} or null if it doesn't exist
     */
    public Meme getById(String memeId){
        return memeRepository.findById(new ObjectId(memeId)).orElse(null);
    }

    /**
     * Updates a {@link Meme} from a request
     *
     * @param memeId    The id of the {@link Meme} to update
     * @param request   The request containing {@link Meme}'s data to update
     * @return          The updated {@link Meme}
     */
    public Meme update(String memeId, MemeUpdateRequest request){
        return memeRepository.findById(new ObjectId(memeId))
                .map(meme -> {
                    meme.setTitle(request.getTitle());
                    meme.setDescription(request.getDescription());
                    meme.setTag(request.getTag());

                    return memeRepository.save(meme);
                })
                .orElse(null);
    }


    /**
     * Deletes the {@link Meme} with the provided id
     *
     * @param memeId    The id of the {@link Meme} to delete
     */
    public void delete(String memeId){ memeRepository.deleteById(new ObjectId(memeId));}




}
