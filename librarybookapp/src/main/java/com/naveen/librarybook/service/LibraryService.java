package com.naveen.librarybook.service;

import com.naveen.librarybook.exception.ResourceNotFoundException;
import com.naveen.librarybook.model.Library;
import com.naveen.librarybook.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;


    public List<Library> findAllLibraries() {
        return libraryRepository.findAll();
    }

    public Library findLibraryId(Integer bookCategoryId) {
        return libraryRepository.findById(bookCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException("BookCategory", "ID", bookCategoryId));
    }

    public Library addLibrary(Library libraryRequest) {
        return libraryRepository.save(libraryRequest);
    }

    public Library updateLibrary(Integer libraryId, Library libraryRequest) {
        return libraryRepository.findById(libraryId).map(library -> {
            library.setName(libraryRequest.getName());
            return libraryRepository.save(library);
        }).orElseThrow(() -> new ResourceNotFoundException("Mission", "id", libraryId));
    }

    public Boolean deleteBookCategory(Integer libraryId) {
        return libraryRepository.findById(libraryId).map(library -> {
            libraryRepository.delete(library);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException("BookCategory", "id", libraryId));

    }
}
