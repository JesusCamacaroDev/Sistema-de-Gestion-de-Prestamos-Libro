package com.sistema_de_gestion_de_prestamos_libros.controller;

import com.sistema_de_gestion_de_prestamos_libros.model.Book;
import com.sistema_de_gestion_de_prestamos_libros.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookRepository.save(book));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
//        return bookRepository.findById(id)
//                .map(book -> {
//                    book.setTitle(bookDetails.getTitle());
//                    book.setAuthor(bookDetails.getAuthor());
//                    return ResponseEntity.ok(bookRepository.save(book));
//                }).orElse(ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
//        return bookRepository.findById(id)
//                .map(book -> {bookRepository.delete(book);
//                    return ResponseEntity.ok().<Void>build();}).orElse(ResponseEntity.notFound().build());
//    }
}
