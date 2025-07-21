package com.ViniciusVon.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ProjetoController {

    @GetMapping("/api/projetos")
    public List<Map<String, String>> getProjetos() {
        return List.of(
                Map.of(
                        "titulo", "Projeto 1",
                        "descricao", "Este é o projeto 1",
                        "imagem", "/imagens/projeto1.png"
                ),
                Map.of(
                        "titulo", "Projeto 2",
                        "descricao", "Este é o projeto 2",
                        "imagem", "/imagens/projeto2.png"
                ),
                Map.of(
                        "titulo", "Projeto 3",
                        "descricao", "Este é o projeto 3",
                        "imagem", "/imagens/projeto3.png"
                )
        );
    }
}
