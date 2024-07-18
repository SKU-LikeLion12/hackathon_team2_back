package com.example.simple_project_back.service;

import com.example.simple_project_back.domain.Wellness;
import com.example.simple_project_back.repository.WellnessInterface;
import com.example.simple_project_back.repository.WellnessRepository;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class WellnessService {

    private final WellnessInterface wellnessInterface;


    @Transactional
    public Wellness SaveWellness(String Location, String Thema, String Title) {
        Wellness wellness = new Wellness(Location, Thema, Title);
        wellnessInterface.SaveWellness(wellness);
        return wellness;
    }

    public Wellness FindByLocation(String Location) {
        Wellness wellness = wellnessInterface.FindByLocation(Location);
        return wellnessInterface.FindByLocation(wellness.getLocation());
    }

    public Wellness FindByThema(String Thema) {
        Wellness wellenss = wellnessInterface.FindByThema(Thema);
        return wellnessInterface.FindByThema(wellenss.getThema());
    }

    public Wellness FindByTitle(String Title) {
        Wellness wellness = wellnessInterface.FindByTitle(Title);
        return wellnessInterface.FindByTitle(wellness.getTitle());
    }

    public Wellness FindByFavorite(Long favoriteCnt) {
        Wellness wellness = wellnessInterface.FindByFavorite(favoriteCnt);
        return wellnessInterface.FindByFavorite(wellness.getFavoriteCount());
    }

    public Wellness FindWellness(Long WellnessId) {
        return wellnessInterface.FindById(WellnessId);
    }

}
