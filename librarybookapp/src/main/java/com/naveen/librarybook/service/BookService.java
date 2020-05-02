package com.naveen.librarybook.service;

import com.naveen.librarybook.exception.ResourceNotFoundException;
import com.naveen.librarybook.model.Book;
import com.naveen.librarybook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(Integer bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "ID", bookId));
    }

    public Book addBook(Book bookRequest) {
        return bookRepository.save(bookRequest);
    }

    public Book updateBook(Integer bookId, Book bookRequest) {
        return bookRepository.findById(bookId).map(book -> {
            book.setName(bookRequest.getName());
            book.setAuthor(bookRequest.getAuthor());
            book.setIsbn(bookRequest.getIsbn());
            book.setLanguage(bookRequest.getLanguage());
            book.setLength(bookRequest.getLength());
            book.setPublisher(bookRequest.getPublisher());
           // book.setReleaseDate(bookRequest.getReleaseDate());
            book.setWeight(bookRequest.getWeight());
            book.setLibrary(bookRequest.getLibrary());
            return bookRepository.save(book);
        }).orElseThrow(() -> new ResourceNotFoundException("Mission", "id", bookId));
    }

    public Boolean deleteBook(Integer bookId) {
        return bookRepository.findById(bookId).map(book -> {
            bookRepository.delete(book);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException("Book", "id", bookId));
    }
}
