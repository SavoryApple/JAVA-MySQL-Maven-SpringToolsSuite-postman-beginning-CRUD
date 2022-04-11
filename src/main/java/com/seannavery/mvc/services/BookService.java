package com.seannavery.mvc.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.seannavery.mvc.models.Book;
import com.seannavery.mvc.repositories.BookRepository;
@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    
    //deletes a book
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
    
    // updates a book
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Book bookToUpdate = this.findBook(id);   	
    	bookToUpdate.setTitle(title);
    	bookToUpdate.setDescription(desc);
    	bookToUpdate.setLanguage(lang);
    	bookToUpdate.setNumberOfPages(numOfPages);
    	bookRepository.save(bookToUpdate);
        return bookToUpdate;
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
}
