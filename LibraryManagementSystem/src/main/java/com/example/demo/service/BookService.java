package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.UserRepository;
@Service
public class BookService {

	@Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;
    
    public List<Book> findAll(){
    	return bookRepository.findAll();
    }
    
    public Book findById(long id) {
    	return bookRepository.findById(id).orElse(null);
    }
    
    public Book save(Book book) {
    	return bookRepository.save(book);
    }
    
    public void deleteById(long id) {
    	bookRepository.deleteById(id);
    }

    public Book borrowBook(long bookId,long userId) {
    	Book book=findById(bookId);
    	User user=userRepository.findById(userId).orElse(null);
    	if (book != null && !book.isBorrowed() && user != null) {
            book.setBorrowedBy(user);
            book.setBorrowed(true);
            return save(book);
        }
        // Handle errors (e.g., book not found, book already borrowed, user not found)
        return null;
    }
    public Book returnBook(Long bookId) {
        Book book = findById(bookId);
        if (book != null && book.isBorrowed()) {
            book.setBorrowedBy(null);
            book.setBorrowed(false);
            return save(book);
        }
        // Handle errors (e.g., book not found, book not borrowed)
        return null;
    }
    
    
}