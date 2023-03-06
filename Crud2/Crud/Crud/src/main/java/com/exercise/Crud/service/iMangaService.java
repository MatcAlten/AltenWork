package com.exercise.Crud.service;

import com.exercise.Crud.model.Manga;

import java.util.Optional;

public interface iMangaService {

    public Iterable<Manga>  getAllManga();

    public Optional<Manga> getMangaById(Integer id);

    public Manga addManga(Manga manga);

    public Optional<Manga> updateMangaById(Integer id,Manga manga);

    public Boolean deleteMangaById(Integer id);

}
