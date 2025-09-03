package agsilvamhm.livrosEEmprestimos.adapter.input.controller;

import agsilvamhm.livrosEEmprestimos.adapter.input.request.EmprestimoRequestDto;
import agsilvamhm.livrosEEmprestimos.core.domain.model.Emprestimo;
import agsilvamhm.livrosEEmprestimos.core.usecase.EmprestimoCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmprestimoController {

    @Autowired
    private EmprestimoCase emprestimoService;

    @PostMapping("/emprestimos")
    public Emprestimo novoEmprestimo(@Valid @RequestBody EmprestimoRequestDto dto){
        return emprestimoService.save(dto);
    }
}
