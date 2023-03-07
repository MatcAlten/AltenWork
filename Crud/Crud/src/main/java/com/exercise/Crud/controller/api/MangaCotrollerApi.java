package com.exercise.Crud.controller.api;

import com.exercise.Crud.model.Manga;
import com.exercise.Crud.repository.iMangaRepo;
import com.exercise.Crud.service.DbMangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class MangaCotrollerApi {

    @Autowired
    @Qualifier("mainMangaService")
    private DbMangaService dbMangaService;

    public MangaCotrollerApi() {

    }

    @Autowired
    private iMangaRepo iMangaRepo;


    @GetMapping("/getAllManga")
    public Iterable<Manga> getAllManga() {

        return dbMangaService.getAllManga();
    }


    @GetMapping("/getMangaById/{id}")
    public ResponseEntity<Manga> getMangaById(@PathVariable Integer id) {

       Optional<Manga> manga = dbMangaService.getMangaById(id);

       if (manga.isPresent()) {
           return new ResponseEntity<>(manga.get(), HttpStatus.OK);
       }

       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/addManga")
    public Manga addManga(@RequestBody Manga manga) {

        return dbMangaService.addManga(manga);
    }


    @PostMapping("/updateMangaById/{id}")
    public Manga updateMangaById(@PathVariable Integer id, @RequestBody Manga newMangaData){

        Optional<Manga> mangaData = dbMangaService.updateMangaById(id, newMangaData);

        if (mangaData.isEmpty()) {

          throw  new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
        return mangaData.get();

    }


    @DeleteMapping("/deleteMangaById/{id}")
    public ResponseEntity<HttpStatus> deleteMangaById(@PathVariable Integer id) {

        iMangaRepo.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
