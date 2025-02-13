package com.example.sistemaBiblioteca.Service;

import com.example.sistemaBiblioteca.Model.Emprestimo;
import com.example.sistemaBiblioteca.Repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {

    @Autowired
    EmprestimoRepository emprestimoRepository;

    public Emprestimo criarEmprestimo (Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo atualizarEmprestimo (Integer id, Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    public void deletarEmprestimo (Integer id) {
        emprestimoRepository.deleteById(id);
    }

    public Emprestimo buscarEmprestimo (Integer id) {
        return emprestimoRepository.findById(id).get();
    }
}
