package com.example.sistemaBiblioteca.Repository;

import com.example.sistemaBiblioteca.Model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository <Emprestimo, Integer> {
}
