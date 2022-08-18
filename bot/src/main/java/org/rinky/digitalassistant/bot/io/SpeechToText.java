package org.rinky.digitalassistant.bot.io;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.rinky.digitalassistant.bot.ai.AIConfig;
import org.springframework.stereotype.Component;

// Imports the Google Cloud client library
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.speech.v1p1beta1.RecognitionAudio;
import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
import com.google.cloud.speech.v1p1beta1.RecognizeResponse;
import com.google.cloud.speech.v1p1beta1.SpeechClient;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionResult;
import com.google.cloud.speech.v1p1beta1.SpeechSettings;
import com.google.protobuf.ByteString;
@Component
public class SpeechToText {

	public static String convert(String audioFile) throws Exception {
        FileInputStream credentialsStream = new FileInputStream(AIConfig.getTokenFile());
        GoogleCredentials credentials = GoogleCredentials.fromStream(credentialsStream);
        FixedCredentialsProvider credentialsProvider = FixedCredentialsProvider.create(credentials);
        SpeechSettings speechSettings =  SpeechSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
        try (SpeechClient speechClient = SpeechClient.create(speechSettings)) {
            Path path = Paths.get(audioFile);
            byte[] data = Files.readAllBytes(path);
            ByteString audioBytes = ByteString.copyFrom(data);
            RecognitionConfig config = RecognitionConfig.newBuilder()
                      //.setEncoding(AudioEncoding.LINEAR16)
                     .setSampleRateHertz(16000)
                    .setLanguageCode("en-US")
                    .build();
            RecognitionAudio audio = RecognitionAudio.newBuilder()
                    .setContent(audioBytes)
                    .build();

            RecognizeResponse response = speechClient.recognize(config, audio);
            List<SpeechRecognitionResult> results = response.getResultsList();
            for (SpeechRecognitionResult result : results) {
                SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
                System.out.printf("Transcription: %s%n", alternative.getTranscript());
                return alternative.getTranscript();
            }
        }
        return "";
    }
}