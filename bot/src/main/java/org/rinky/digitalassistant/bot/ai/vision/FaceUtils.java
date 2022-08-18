package org.rinky.digitalassistant.bot.ai.vision;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.rinky.digitalassistant.bot.ai.AIConfig;
import org.rinky.digitalassistant.bot.model.FaceObj;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.FaceAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.ImageAnnotatorSettings;
import com.google.cloud.vision.v1.Likelihood;
import com.google.protobuf.ByteString;

public class FaceUtils {
	public static FaceObj detectFaces(String filePath) throws Exception, IOException {
		FileInputStream credentialsStream = new FileInputStream(AIConfig.getTokenFile());
		GoogleCredentials credentials = GoogleCredentials.fromStream(credentialsStream);
		FixedCredentialsProvider credentialsProvider = FixedCredentialsProvider.create(credentials);
		ImageAnnotatorSettings annotatorSettings = ImageAnnotatorSettings.newBuilder()
				.setCredentialsProvider(credentialsProvider).build();
		List<AnnotateImageRequest> requests = new ArrayList<>();
		ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));
		Image img = Image.newBuilder().setContent(imgBytes).build();
		Feature feat = Feature.newBuilder().setType(Type.FACE_DETECTION).build();
		AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
		requests.add(request);
		FaceObj fo = new FaceObj();
		try (ImageAnnotatorClient client = ImageAnnotatorClient.create(annotatorSettings)) {
			BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
			List<AnnotateImageResponse> responses = response.getResponsesList();
			for (AnnotateImageResponse res : responses) {
				if (res.hasError()) {
					System.out.printf("Error: %s\n", res.getError().getMessage());
					return fo;
				}
				for (FaceAnnotation a : res.getFaceAnnotationsList()) {
					if(a.getAngerLikelihood().equals(Likelihood.LIKELY)||a.getAngerLikelihood().equals(Likelihood.VERY_LIKELY)) {
						fo.setAngry(true);
					}
					if(a.getJoyLikelihood().equals(Likelihood.LIKELY)||a.getJoyLikelihood().equals(Likelihood.VERY_LIKELY)) {
						fo.setJoy(true);
					}
					if(a.getSorrowLikelihood().equals(Likelihood.LIKELY)||a.getSorrowLikelihood().equals(Likelihood.VERY_LIKELY)) {
						fo.setIssorrow(true);
					}
					if(a.getSurpriseLikelihood().equals(Likelihood.LIKELY)||a.getSurpriseLikelihood().equals(Likelihood.VERY_LIKELY)) {
						fo.setSurprised(true);
					}
					if(a.getHeadwearLikelihood().equals(Likelihood.LIKELY)||a.getHeadwearLikelihood().equals(Likelihood.VERY_LIKELY)) {
						fo.setSurprised(true);
					}
					fo.setTiltAngle(a.getTiltAngle());
					fo.setPanAngle(a.getPanAngle());
					fo.setPanAngle(a.getPanAngle());
					fo.setRollAngle(a.getRollAngle());
				}
			}
		}
		return fo;
	}
}
