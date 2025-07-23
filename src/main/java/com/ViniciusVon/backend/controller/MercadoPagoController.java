package com.ViniciusVon.backend.controller;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.*;
import com.mercadopago.resources.preference.Preference;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.client.preference.PreferenceClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/mercadopago")
public class MercadoPagoController {

    @Value("${mercadopago.access.token}")
    private String accessToken;

    @PostMapping
    public String criarPreferencia() throws Exception {
        // Configura o token do Mercado Pago
        MercadoPagoConfig.setAccessToken(accessToken);

        // Criação do item
        PreferenceItemRequest item = PreferenceItemRequest.builder()
                .title("Mentoria Vanessa von Glehn")
                .quantity(1)
                .unitPrice(new BigDecimal("499.00"))
                .build();

        // URLs de retorno
        PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest.builder()
                .success("https://seusite.com/sucesso")
                .failure("https://seusite.com/erro")
                .pending("https://seusite.com/pendente")
                .build();

        // Criação da preferência
        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .items(List.of(item))
                .backUrls(backUrls)
                .autoReturn("approved")
                .build();

        // Cliente de preferências
        PreferenceClient client = new PreferenceClient();
        Preference preference = client.create(preferenceRequest);

        return preference.getInitPoint(); // Retorna o link para o frontend
    }
}
