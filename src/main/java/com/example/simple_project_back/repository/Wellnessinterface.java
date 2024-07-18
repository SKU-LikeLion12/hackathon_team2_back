package com.example.simple_project_back.repository;

import com.example.simple_project_back.domain.Wellness;

import java.util.List;

public interface WellnessInterface {

    public Wellness SaveWellness(Wellness wellness);

    public void DeleteWellness(Wellness wellness);

    public Wellness FindByLocation(String location);

    public Wellness FindByThema(String thema);

    public Wellness FindByTitle(String title);

    List<Wellness> FindByFavorite(String favoriteCnt);

    List<Wellness> FindAllWellness();
}
