package com.sistema_de_gestion_de_prestamos_libros.controller;

import com.sistema_de_gestion_de_prestamos_libros.dto.LoanRequest;
import com.sistema_de_gestion_de_prestamos_libros.model.Book;
import com.sistema_de_gestion_de_prestamos_libros.model.Loan;
import com.sistema_de_gestion_de_prestamos_libros.services.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    /*Diferencia Conceptual
    Una vez corregido a ResponseEntity, la diferencia entre los dos métodos es el nivel de control sobre la respuesta HTTP:
            1. public List<Book> getAllBook() (Retorno directo):
                ◦  Simplicidad: Solo devuelves los datos. Spring se encarga de convertirlos a JSON.
                ◦  Estado HTTP Fijo: Spring asignará automáticamente el código 200 OK siempre que no haya errores.
                ◦  Uso: Ideal para prototipos rápidos o endpoints donde la lógica es muy simple y siempre exitosa.

            2. public ResponseEntity<List<Book>> getAllBook() (Con envoltorio):
                ◦  Control Total: Devuelves un objeto que representa toda la respuesta HTTP (Cuerpo, Código de Estado y Cabeceras).
                ◦  Flexibilidad: Puedes decidir qué código devolver. Por ejemplo:
                ▪  return ResponseEntity.ok(lista) -> 200 OK
                ▪  return ResponseEntity.noContent().build() -> 204 No Content (si la lista está vacía).
                ▪  return ResponseEntity.status(418).body(...) -> Código personalizado.
                ◦  Cabeceras: Puedes añadir headers personalizados (ej. metadatos de paginación).
                ◦  Uso: Es el estándar profesional para APIs REST robustas. */
    /*
    @PostMapping("/book")
    public Book addBook(@RequestBody Book book){
        return libraryService.saveBook(book);


    @GetMapping("/loans/user/{id}")
    public List<Loan> userLoans(@PathVariable Long id){
        return libraryService.getLoanByUser(id);
    }

    @PostMapping("/loans")
    public Loan addLoan(@RequestBody LoanRequest loanRequest){
        return libraryService.createLoan(loanRequest.getBookId(), loanRequest.getUserId());
    }

    @GetMapping("/book")
    /*public List<Book> getAllBook(){
        return libraryService.getAllBooks();
    }
    */

    @GetMapping("/book")
    public ResponseEntity<List<Book>> getAllBook(){
        return ResponseEntity.ok(libraryService.getAllBooks());
    }

    @PostMapping("/book")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return ResponseEntity.ok(libraryService.saveBook(book));
    }

    @GetMapping("/loans/user/{id}")
    public ResponseEntity<List<Loan>> userLoans(@PathVariable Long id){
        return ResponseEntity.ok(libraryService.getLoanByUser(id));
    }

    @PostMapping("/loans")
    public ResponseEntity<Loan> addLoan(@RequestBody LoanRequest loanRequest){
        return ResponseEntity.ok(libraryService.createLoan(loanRequest.getBookId(), loanRequest.getUserId()));
    }
}
