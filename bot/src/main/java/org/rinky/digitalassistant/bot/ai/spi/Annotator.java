package org.rinky.digitalassistant.bot.ai.spi;

import java.util.List;

public abstract class Annotator<T> {
	
	public void init(Context ctx) {
		
	}
	public abstract List<Tag> annotate(Context ctx,T f) ;
	
}
