package com.exercise.Crud.controller;

import com.exercise.Crud.model.Manga;
import com.exercise.Crud.repository.MangaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MangaCotroller {

    @Autowired
    private MangaRepo mangaRepo;


    @GetMapping("/getAllManga")
    public ResponseEntity<List<Manga>> getAllManga() {
        try{
            List<Manga> mangaList = new ArrayList<>();
            mangaRepo.findAll().forEach(mangaList::add);

            if (mangaList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
              return new ResponseEntity<>(mangaList, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/getMangaById/{id}")
    public ResponseEntity<Manga> getMangaById(@PathVariable Integer id) {
       Optional<Manga> mangaData = mangaRepo.findById(id);

       if (mangaData.isPresent()) {
           return new ResponseEntity<>(mangaData.get(), HttpStatus.OK);
       }

       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/addManga")
    public ResponseEntity<Manga> addManga(@RequestBody Manga manga) {
        Manga mangaObj = mangaRepo.save(manga);

        return new ResponseEntity<>(mangaObj, HttpStatus.OK);
    }


    @PostMapping("/updateMangaById/{id}")
    public ResponseEntity<Manga> updateMangaById(@PathVariable Integer id, @RequestBody Manga newMangaData){
        Optional<Manga> oldMangaData = mangaRepo.findById(id);

        if (oldMangaData.isPresent()) {
            Manga updatedMangaData = oldMangaData.get();
            updatedMangaData.setTitle(newMangaData.getTitle());
            updatedMangaData.setAuthor(newMangaData.getAuthor());

            Manga  mangaObj = mangaRepo.save(updatedMangaData);
             return new ResponseEntity<>(mangaObj, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/deleteMangaById/{id}")
    public ResponseEntity<HttpStatus> deleteMangaById(@PathVariable Integer id) {
        mangaRepo.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
