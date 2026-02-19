package com.sistema_de_gestion_de_prestamos_libros.controller;

import com.sistema_de_gestion_de_prestamos_libros.model.Loan;
import com.sistema_de_gestion_de_prestamos_libros.repository.LoanRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/loans")

public class LoanControllers {

    private final LoanRepository loanRepository;

    public LoanControllers(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @PostMapping
    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
}

    @GetMapping
    public List<Loan> getLoansById() {
    return loanRepository.findAll();}
}
