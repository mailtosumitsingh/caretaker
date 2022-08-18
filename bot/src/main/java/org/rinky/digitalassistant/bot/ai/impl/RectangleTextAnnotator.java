package org.rinky.digitalassistant.bot.ai.impl;

import java.util.List;

import org.rinky.digitalassistant.bot.ai.spi.Annotator;
import org.rinky.digitalassistant.bot.ai.spi.Context;
import org.rinky.digitalassistant.bot.ai.spi.Tag;
import org.sikuli.script.Image;

public class RectangleTextAnnotator extends Annotator<Image> {
	public void init(Context ctx) {
	super.init(ctx);	
	}
	public  List<Tag> annotate(Context ctx,Image f) {
		return null;
	}
}
