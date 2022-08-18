package org.rinky.digitalassistant.bot.ai;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.language.v1.AnalyzeEntitiesRequest;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Document.Type;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.LanguageServiceSettings;
import com.google.cloud.language.v1.Sentiment;
import com.google.cloud.speech.v1p1beta1.SpeechSettings;

import java.io.FileInputStream;

public class NLPUtils {
  public static void main(String... args) throws Exception {
    FileInputStream credentialsStream = new FileInputStream("C:/projects/robotics.json");
    GoogleCredentials credentials = GoogleCredentials.fromStream(credentialsStream);
    FixedCredentialsProvider credentialsProvider = FixedCredentialsProvider.create(credentials);

    LanguageServiceSettings languageServiceSettings =
            LanguageServiceSettings .newBuilder()
                    .setCredentialsProvider(credentialsProvider)
                    .build();
    try (LanguageServiceClient language = LanguageServiceClient.create(languageServiceSettings)) {

      // The text to analyze
      String text = "this looks ok to me";
      Document doc = Document.newBuilder()
          .setContent(text).setType(Type.PLAIN_TEXT).build();

      // Detects the sentiment of the text
      Sentiment sentiment = language.analyzeSentiment(doc).getDocumentSentiment();
      System.out.printf("Text: %s%n", text);
      System.out.printf("Sentiment: %s, %s%n", sentiment.getScore(), sentiment.getMagnitude());
    }
  }
}