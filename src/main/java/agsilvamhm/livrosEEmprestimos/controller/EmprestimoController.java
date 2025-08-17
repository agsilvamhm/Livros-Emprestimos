package agsilvamhm.livrosEEmprestimos.controller;

import agsilvamhm.livrosEEmprestimos.dto.request.EmprestimoRequestDto;
import agsilvamhm.livrosEEmprestimos.model.Emprestimo;
import agsilvamhm.livrosEEmprestimos.service.EmprestimoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping("/emprestimos")
    public Emprestimo novoEmprestimo(@Valid @RequestBody EmprestimoRequestDto dto){
        return emprestimoService.save(dto);
    }
}
