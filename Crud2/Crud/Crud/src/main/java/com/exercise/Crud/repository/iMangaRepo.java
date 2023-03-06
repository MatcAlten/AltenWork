package com.exercise.Crud.repository;

import com.exercise.Crud.model.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iMangaRepo extends JpaRepository <Manga, Integer> {
}
