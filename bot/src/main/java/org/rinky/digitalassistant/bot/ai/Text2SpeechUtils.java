package org.rinky.digitalassistant.bot.ai;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.texttospeech.v1beta1.AudioConfig;
import com.google.cloud.texttospeech.v1beta1.AudioEncoding;
import com.google.cloud.texttospeech.v1beta1.SsmlVoiceGender;
import com.google.cloud.texttospeech.v1beta1.SynthesisInput;
import com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechResponse;
import com.google.cloud.texttospeech.v1beta1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1beta1.TextToSpeechSettings;
import com.google.cloud.texttospeech.v1beta1.VoiceSelectionParams;
import com.google.protobuf.ByteString;

public class Text2SpeechUtils {

	public static String synthesizeText(String text,String fname) throws Exception {
		FileInputStream credentialsStream = new FileInputStream(AIConfig.getTokenFile());
		GoogleCredentials credentials = GoogleCredentials.fromStream(credentialsStream);
		FixedCredentialsProvider credentialsProvider = FixedCredentialsProvider.create(credentials);
		TextToSpeechSettings text2Speech = TextToSpeechSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
		try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create(text2Speech)) {
			SynthesisInput input = SynthesisInput.newBuilder().setText(text).build();
			VoiceSelectionParams voice = VoiceSelectionParams.newBuilder().setLanguageCode("en-US")	.setSsmlGender(SsmlVoiceGender.FEMALE).build();
			AudioConfig audioConfig = AudioConfig.newBuilder().setAudioEncoding(AudioEncoding.LINEAR16) .build();
			SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);
			ByteString audioContents = response.getAudioContent();
			String fileName = fname;
			try (OutputStream out = new FileOutputStream ( fileName ) ) {
				out.write(audioContents.toByteArray());
				System.out.println("Audio content written to file \""+fileName+"\"");
				return fileName;
			}catch(Exception exp) {
				return null;
			}
		}
	}
}
