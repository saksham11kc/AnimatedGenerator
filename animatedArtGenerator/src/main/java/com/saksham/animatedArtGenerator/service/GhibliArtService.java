package com.saksham.animatedArtGenerator.service;

import com.saksham.animatedArtGenerator.client.StabilityAIClient;
import com.saksham.animatedArtGenerator.dto.TextToImageRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GhibliArtService {
    private final StabilityAIClient stabilityAIClient;
    private final String apiKey;

    public GhibliArtService(StabilityAIClient stabilityAIClient, @Value("${stability.api.key}") String apiKey) {
        this.stabilityAIClient = stabilityAIClient;
        this.apiKey = apiKey;
    }

    public byte[] createGhibliArt(MultipartFile image ,String prompt) {

        String finalPrompt = prompt + ", in sceneric animated style";
        String engineId = "stable-diffusion-v1-6";
        String stylePreset = "anime";

        return stabilityAIClient.generateImageFromImage(
                "Bearer "+apiKey,
                engineId,
                image,
                finalPrompt,
                stylePreset
        );

    }


    public byte[] createGhibliArtFromText (String prompt , String style){
        String finalPrompt = prompt + ", in sceneric animated style";
        String engineId = "stable-diffusion-v1-6";
        String stylePreset = style.equals("general") ? "anime" : style.replace("_" ,"-");
        TextToImageRequest requestPayload = new TextToImageRequest(finalPrompt , stylePreset);
        return stabilityAIClient.generateImageFromText("Bearer "+apiKey, engineId, requestPayload);
    }
}
