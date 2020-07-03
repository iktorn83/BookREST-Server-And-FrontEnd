package com.wiktorkowalczyk.bookrest.Controller;

import com.wiktorkowalczyk.bookrest.Util.BookRepository;
import com.wiktorkowalczyk.bookrest.Model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Books> getAll() {
        return bookRepository.findAll();
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public Books addBook(@RequestBody Books newBook) {
        bookRepository.save(newBook);
        return newBook;
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    public Books updateBook(@PathVariable long id, @RequestBody Books newBook) {
        bookRepository.findById(id).map(book -> {
            book.setAuthor((newBook.getAuthor()));
            book.setName(newBook.getName());
            book.setYear(newBook.getYear());
            return bookRepository.save(book);
        });
        return bookRepository.getOne(id);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public Boolean deleteBook(@PathVariable long id) {
        bookRepository.deleteById(id);
        return bookRepository.existsById(id);
    }
}
