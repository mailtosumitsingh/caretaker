package org.rinky.digitalassistant.bot.ai;

import java.io.FileInputStream;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class TxlateUtils {
	public static String txlate(String what, String from, String to) throws Exception{
    FileInputStream credentialsStream = new FileInputStream(AIConfig.getTokenFile());
    GoogleCredentials credentials = GoogleCredentials.fromStream(credentialsStream);
    Translate translate = TranslateOptions.newBuilder().setCredentials(credentials).build().getService();
    String text = what;
    Translation translation =   translate.translate( text, TranslateOption.sourceLanguage(from), TranslateOption.targetLanguage(to));
    return translation.getTranslatedText();
  }
}