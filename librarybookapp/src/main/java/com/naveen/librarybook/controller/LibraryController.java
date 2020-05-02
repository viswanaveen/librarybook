package com.naveen.librarybook.controller;

import com.naveen.librarybook.model.Library;
import com.naveen.librarybook.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/libraries")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;


    @GetMapping
    public ResponseEntity<List<Library>> getAllLibrary() {
        return new ResponseEntity<>(libraryService.findAllLibraries(), HttpStatus.OK);
    }

    @GetMapping("/{libraryId}")
    public ResponseEntity<Library> getBookCategoryById(@PathVariable Integer libraryId) {
        return new ResponseEntity<>(libraryService.findLibraryId(libraryId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Library> createLibrary(@RequestBody Library libraryRequest) {
        return new ResponseEntity<>(libraryService.addLibrary(libraryRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{libraryId}")
    public ResponseEntity<Library> updateLibrary(@PathVariable Integer libraryId, @Valid @RequestBody Library libraryRequest) {
        return new ResponseEntity<>(libraryService.updateLibrary(libraryId, libraryRequest), HttpStatus.OK);
    }


    @DeleteMapping("/{libraryId}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable Integer libraryId) {
        libraryService.deleteBookCategory(libraryId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
