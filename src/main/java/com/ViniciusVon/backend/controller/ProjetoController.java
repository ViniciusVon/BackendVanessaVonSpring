package com.ViniciusVon.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class ProjetoController {

    @GetMapping("/api/projetos")
    public List<Map<String, String>> getProjetos() {
        return List.of(
                Map.of(
                        "titulo", "Casa Cor",
                        "descricao", "A CASACOR é a principal mostra de arquitetura, design de interiores e paisagismo das Américas. Reúne anualmente profissionais renomados que apresentam ambientes sofisticados, inovadores e cheios de personalidade. É um espaço onde tendências se encontram e a criatividade ganha forma.",
                        "imagem", "/imagens/projeto1.png"
                ),
                Map.of(
                        "titulo", "Decor Year Book",
                        "descricao", "O Decor Year Book é uma publicação anual que reúne os principais projetos e profissionais do design, arquitetura e decoração. Serve como referência de tendências e inspiração para o setor, destacando o que há de mais relevante e criativo no mercado.",
                        "imagem", "/imagens/projeto2.png"
                ),
                Map.of(
                        "titulo", "Clientes",
                        "descricao", "Clientes que confiam no trabalho da arquiteta para transformar seus espaços com criatividade, funcionalidade e estética. Cada projeto é desenvolvido de forma personalizada, respeitando os desejos e necessidades de quem sonha com um ambiente único e bem planejado.",
                        "imagem", "/imagens/projeto3.png"
                )
        );
    }
}
