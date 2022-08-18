package org.rinky.digitalassistant.bot.ai.vision;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.rinky.digitalassistant.bot.ai.AIConfig;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.ImageAnnotatorSettings;
import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;

public class DetectThingsUtils {
	
	public static List<String> detectObjects(String fileName) throws Exception {
		FileInputStream credentialsStream = new FileInputStream(AIConfig.getTokenFile());
		GoogleCredentials credentials = GoogleCredentials.fromStream(credentialsStream);
		FixedCredentialsProvider credentialsProvider = FixedCredentialsProvider.create(credentials);
		ImageAnnotatorSettings annotatorSettings = ImageAnnotatorSettings.newBuilder()
				.setCredentialsProvider(credentialsProvider).build();
		try (ImageAnnotatorClient vision = ImageAnnotatorClient.create(annotatorSettings)) {
			Path path = Paths.get(fileName);
			byte[] data = Files.readAllBytes(path);
			ByteString imgBytes = ByteString.copyFrom(data);
			List<AnnotateImageRequest> requests = new ArrayList<>();
			Image img = Image.newBuilder().setContent(imgBytes).build();
			Feature feat = Feature.newBuilder().setType(Type.LABEL_DETECTION).build();
			AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
			requests.add(request);
			BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
			List<AnnotateImageResponse> responses = response.getResponsesList();
			for (AnnotateImageResponse res : responses) {
				if (res.hasError()) {
					System.out.printf("Error: %s\n", res.getError().getMessage());
					return null;
				}
				List<String> annots = Lists.newLinkedList();
				for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
					annotation.getAllFields().forEach((k, v) -> System.out.printf("%s : %s\n", k, v.toString()));
					if(annotation.getScore()>.6) {
						annots.add(annotation.getDescription());
					}
				}
				return annots;
			}
		}
		return null;
	}
}