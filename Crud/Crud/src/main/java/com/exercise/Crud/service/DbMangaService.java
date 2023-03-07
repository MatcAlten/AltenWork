package com.exercise.Crud.service;

import com.exercise.Crud.model.Manga;
import com.exercise.Crud.repository.iMangaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("mainMangaService")
public class DbMangaService implements iMangaService {

    @Autowired
    private iMangaRepo mangaRepo;


    @Override
    public Iterable<Manga> getAllManga() {
        return mangaRepo.findAll();
    }

    @Override
    public Optional<Manga> getMangaById(Integer id) {

        return mangaRepo.findById(id);
    }

    @Override
    public Manga addManga(Manga manga) {

        return mangaRepo.save(manga);
    }

    @Override
    public Optional<Manga> updateMangaById(Integer id, Manga manga) {

        Optional<Manga>foundManga = mangaRepo.findById(id);

        if (foundManga.isEmpty()) {
            return Optional.empty();
        } foundManga.get().setTitle(manga.getTitle());
          foundManga.get().setAuthor(manga.getAuthor());
          mangaRepo.save(foundManga.get());

        return foundManga;
    }

    @Override
    public Boolean deleteMangaById(Integer id) {

        Optional<Manga>findManga = mangaRepo.findById(id);

        if (findManga.isEmpty()) {
            return false;
        }

        mangaRepo.delete(findManga.get());

        return true;
    }
}
