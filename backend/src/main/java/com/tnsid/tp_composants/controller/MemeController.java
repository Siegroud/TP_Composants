package com.tnsid.tp_composants.controller;

import com.tnsid.tp_composants.api.dto.MemeDto;
import com.tnsid.tp_composants.api.request.MemeCreationRequest;
import com.tnsid.tp_composants.api.request.MemeUpdateRequest;
import com.tnsid.tp_composants.api.response.MemesResponse;
import com.tnsid.tp_composants.constant.TagEnum;
import com.tnsid.tp_composants.entity.Meme;
import com.tnsid.tp_composants.mapper.MemeMapper;
import com.tnsid.tp_composants.service.MemeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memes")
@Slf4j
@RequiredArgsConstructor
@Tag(
        name = "Meme controller",
        description = "APIS used to manage memes"
)
public class MemeController {

    private final MemeService memeService;

    private final MemeMapper memeMapper;

    @GetMapping
    @Operation(
            summary = "Get all memes",
            description = "Get every memes that matches provided filters.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Response in case of success",
                            content = @Content(mediaType = "application/json", schema = @Schema(allOf = MemesResponse.class))
                    ),
            }
    )
    public ResponseEntity<MemesResponse> getAllMemes(
            @Parameter(description = "A list of meme tags to filter on. The filter will not be applied if non privided.")
            @RequestParam(required = false)
            List<TagEnum> tags
    ){
        final List<Meme> memes = memeService.getAll(tags);
        final MemesResponse response = memeMapper.toResponse(memes);

        return ResponseEntity.ok(response);
    }


    @GetMapping("/{memeId}")
    @Operation(
            summary = "Get a meme by id",
            description = "Get the meme with the provided id.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Response in case of success",
                            content = @Content(mediaType = "application/json", schema = @Schema(allOf = MemeDto.class))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "No meme is matching the provided id"
                    )
            }
    )
    public ResponseEntity<MemeDto> getMeme(
            @Parameter(description = "The id of the meme", example = "")
            @PathVariable
            String memeId
    ){
        final Meme  meme = memeService.getById(memeId);

        return meme != null
                ? ResponseEntity.ok(memeMapper.toDto(meme))
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(
            summary = "Create a meme",
            description = "Create a meme from the provided data",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Response if the meme has been successfully created",
                            content = @Content(mediaType = "application/json", schema = @Schema(allOf = MemeDto.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Response if the provided data is not valid",
                            content = @Content(mediaType = "application/json")
                    )
            }
    )
    public ResponseEntity<MemeDto> createMeme(@Valid @RequestBody MemeCreationRequest request){
        final Meme meme = memeService.create(request);
        final MemeDto dto = memeMapper.toDto(meme);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }


    @PutMapping("/{memeId}")
    @GetMapping("/{memeId}")
    @Operation(
            summary = "Update a meme by id",
            description = "Update the meme with the provided id.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Response in case of success",
                            content = @Content(mediaType = "application/json", schema = @Schema(allOf = MemeDto.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Response if the provided data is not valid",
                            content = @Content(mediaType = "application/json")
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "No meme is matching the provided id."
                    )
            }
    )
    public ResponseEntity<MemeDto> updateMeme(
            @PathVariable
            @Parameter(description = "The id of the meme")
            String memeId,

            @Valid
            @RequestBody
            MemeUpdateRequest request
    ){
        final Meme meme = memeService.update(memeId,request);

        return meme != null
                ? ResponseEntity.ok(memeMapper.toDto(meme))
                : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{memeId}")
    @GetMapping("/{memeId}")
    @Operation(
            summary = "Delete a meme by id",
            description = "Delete the meme with the provided id.",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Response if the meme has been successfully deleted"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "No meme is matching the provided id."
                    )
            }
    )
    public ResponseEntity<Void> deleteMeme(
            @Parameter(description = "The id of the meme to delete")
            @PathVariable
            String memeId
    ) {
        memeService.delete(memeId);

        return ResponseEntity.accepted().build();
    }


}
