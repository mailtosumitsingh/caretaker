package org.rinky.digitalassistant.bot.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.rinky.digitalassistant.bot.StaticUtil;
import org.rinky.digitalassistant.bot.ai.spi.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventBus {
	@Autowired EventRepository repository;
	public void send(Event evt)  {
		try {
			repository.save(evt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
