package com.aluracursos.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obtenerTraduccion(String texto) {
        OpenAiService service = new OpenAiService("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");

        CompletionRequest requisicion = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduce a español el siguiente texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var respuesta = service.createCompletion(requisicion);
        return respuesta.getChoices().get(0).getText();
    }
}
