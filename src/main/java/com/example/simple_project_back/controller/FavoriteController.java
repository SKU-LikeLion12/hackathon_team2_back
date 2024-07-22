package com.example.simple_project_back.controller;


import com.example.simple_project_back.DTO.FavoriteDTO;
import com.example.simple_project_back.DTO.WellnessDTO;
import com.example.simple_project_back.domain.Favorite;
import com.example.simple_project_back.domain.Wellness;
import com.example.simple_project_back.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FavoriteController {
    private final FavoriteService favoriteService;

    @PostMapping("/favorite/add")
    public ResponseEntity<String> addFavorite(@RequestBody FavoriteDTO.FavoriteRequest request) {

        try{
            if(favoriteService.toggleFavorite(request) == 1){
                return ResponseEntity.status(HttpStatus.CREATED).body("success");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error");

        }
        return ResponseEntity.status((HttpStatus.OK)).body("success");

    }


    @GetMapping("/favorite/myPage")
    public List<WellnessDTO.WellnessResponse> getFavoriteMyPage(@RequestBody FavoriteDTO.FavoriteMemberRequest request){
        List<WellnessDTO.WellnessResponse> responses = new ArrayList<>();
        for(Favorite f : favoriteService.getFavoriteByUserId( request)){
            responses.add(new WellnessDTO.WellnessResponse(f.getWellness()));
        }
        return responses;
    }


}
