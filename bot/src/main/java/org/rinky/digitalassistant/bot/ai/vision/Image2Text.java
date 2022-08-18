package org.rinky.digitalassistant.bot.ai.vision;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Polygon;
import org.rinky.digitalassistant.bot.ai.AIConfig;
import org.rinky.digitalassistant.bot.model.TextObj;

import com.google.api.client.util.Sets;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.BoundingPoly;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.ImageAnnotatorSettings;
import com.google.cloud.vision.v1.Vertex;
import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;

public class Image2Text {

	public static List<TextObj> getText(String filePath) throws Exception, IOException {
		List<TextObj>  textObjs = Lists.newLinkedList();
		FileInputStream credentialsStream = new FileInputStream(AIConfig.getTokenFile());
		GoogleCredentials credentials = GoogleCredentials.fromStream(credentialsStream);
		FixedCredentialsProvider credentialsProvider = FixedCredentialsProvider.create(credentials);
		ImageAnnotatorSettings annotatorSettings = ImageAnnotatorSettings.newBuilder()
				.setCredentialsProvider(credentialsProvider).build();
		List<AnnotateImageRequest> requests = new ArrayList<>();
		ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));
		Image img = Image.newBuilder().setContent(imgBytes).build();
		Feature feat = Feature.newBuilder().setType(Type.TEXT_DETECTION).build();
		AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
		requests.add(request);

		try (ImageAnnotatorClient client = ImageAnnotatorClient.create(annotatorSettings)) {
			BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
			List<AnnotateImageResponse> responses = response.getResponsesList();

			for (AnnotateImageResponse res : responses) {
				if (res.hasError()) {
					System.out.printf("Error: %s\n", res.getError().getMessage());
					return null;
				}
				for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
					System.out.printf("Text: %s\n", annotation.getDescription());
					System.out.printf("Position : %s\n", annotation.getBoundingPoly());
					TextObj to = new TextObj();
					BoundingPoly bp = annotation.getBoundingPoly();
					List<Coordinate> coors = Lists.newLinkedList();
					for(Vertex v : bp.getVerticesList()) {
						Coordinate c = new Coordinate();
						c.x = v.getX();
						c.y = v.getY();
						coors.add(c);
					}
					//to.setPoly(AIConfig.getGeomFactory().createPolygon(coors.toArray(new Coordinate[0])));
					to.setTxt(annotation.getDescription());
					to.setId(UUID.randomUUID().toString());
				    textObjs.add(to);
				}
			}
		}
		return textObjs;
	}
	public static List<TextObj> filter(List<TextObj> tos,List<Polygon> mypolys) throws Exception, IOException {
		   List<TextObj> filtered = Lists.newLinkedList();
		   Set<String> ids  = Sets.newHashSet();
		   for(Polygon p: mypolys) {
			   for(TextObj tt: tos) {
				   if(tt.getPoly().contains(p)||p.contains(tt.getPoly())||p.overlaps(tt.getPoly())||tt.getPoly().overlaps(p)) {
					   ids.add(tt.getId());
				   }
			   }
		   }
		for(TextObj tt: tos) {
			   if(ids.contains(tt.getId())) {
				   filtered.add(tt);
				   filtered.remove(tt.getId());//add only once
			   }
		   }
		   return filtered;
	}

}
