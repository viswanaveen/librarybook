package com.naveen.librarybook.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.naveen.librarybook.model.Book;
import com.naveen.librarybook.model.Library;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class BookServiceTest {


    @Mock
    private BookService bookService;

    @Before
    public void setup(){
        // With this call to initMocks we tell Mockito to process the annotations
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAllBooksTest(){
        // given
        Date date = new Date();
        Library bookcategory = new Library("BookCategory 1");
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book(1,"Autor 1", "Language 1", "ISBN 1", date.toString(), "Publisher 1", 150L, 1.054, bookcategory));
        bookList.add(new Book(2,"Autor 2", "Language 2", "ISBN 2", date.toString(), "Publisher 2", 160L, 1.344, bookcategory));
        bookList.add(new Book(3,"Autor 3", "Language 3", "ISBN 3", date.toString(), "Publisher 3", 170L, 1.94, bookcategory));

        // when
        when(bookService.findAllBooks()).thenReturn(bookList);

        // assert
        List<Book> result = bookService.findAllBooks();
        assertEquals(3, result.size());

        assertThat(result.get(0).getName()).isEqualTo("Autor 1");
        assertThat(result.get(0).getAuthor()).isEqualTo("Language 1");
        assertThat(result.get(0).getLanguage()).isEqualTo("ISBN 1");



    }

    @Test
    public void findBookByIdTest(){
        // given
        Date date = new Date();
        Library bookcategory = new Library("BookCategory 1");
        Book book = new Book( 1,"Autor 1", "Language 1", "ISBN 1", date.toString(), "Publisher 1", 150L, 1.054, bookcategory);

        // when
        when(bookService.findBookById(1)).thenReturn(book);

        // assert
        Book result = bookService.findBookById(1);
        assertThat(result.getName()).isEqualTo("Autor 1");
        assertThat(result.getAuthor()).isEqualTo("Language 1");
        assertThat(result.getLanguage()).isEqualTo("ISBN 1");



    }

    @Test
    public void createBookTest() {
        // given
        Date date = new Date();
        Library bookcategory = new Library("BookCategory 1");
        Book bookRequest = new Book( 1,"Autor 1", "Language 1", "ISBN 1",date.toString(), "Publisher 1", 150L, 1.054, bookcategory);
        Book book = new Book( 1,"Autor 1", "Language 1", "ISBN 1", date.toString(), "Publisher 1", 150L, 1.054, bookcategory);

        // when
        when(bookService.addBook(bookRequest)).thenReturn(book);

        // assert
        Book result = bookService.addBook(bookRequest);
        assertThat(result.getName()).isEqualTo("Autor 1");
        assertThat(result.getAuthor()).isEqualTo("Language 1");
        assertThat(result.getLanguage()).isEqualTo("ISBN 1");


    }

    @Test
    public void updateBookTest() {
        // given
        Date date = new Date();
        Library bookcategory = new Library("BookCategory 1");
        Book bookRequest = new Book( 1,"Autor 1", "Language 1", "ISBN 1",date.toString(), "Publisher 1", 150L, 1.054, bookcategory);
        Book book = new Book( 1,"Autor 1", "Language 1", "ISBN 1", date.toString(), "Publisher 1", 150L, 1.054, bookcategory);

        // when
        when(bookService.updateBook(1, bookRequest)).thenReturn(book);

        // assert
        Book result = bookService.updateBook(1, bookRequest);
        assertThat(result.getName()).isEqualTo("Autor 1");
        assertThat(result.getAuthor()).isEqualTo("Language 1");
        assertThat(result.getLanguage()).isEqualTo("ISBN 1");
        
    }

    @Test
    public void deleteBookTest() {
        // given
        Date date = new Date();
        Library bookcategory = new Library("BookCategory 1");
        Book book = new Book( 1,"Autor 1", "Language 1", "ISBN 1", date.toString(), "Publisher 1", 150L, 1.054, bookcategory);

        // when
        when(bookService.deleteBook(book.getId())).thenReturn(true);

        // assert
        Boolean result = bookService.deleteBook(book.getId());
        assertThat(result).isEqualTo(true);
    }

}
