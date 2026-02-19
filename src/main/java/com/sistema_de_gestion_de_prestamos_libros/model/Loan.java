package com.sistema_de_gestion_de_prestamos_libros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate fechaInit;
    private LocalDate fechaDev;

    // RELACIONES

    /**
     * The book associated with this loan.
     */
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    /**
     * The user who borrowed the book.
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public void setFechaInit(LocalDate now) {
    }
}
