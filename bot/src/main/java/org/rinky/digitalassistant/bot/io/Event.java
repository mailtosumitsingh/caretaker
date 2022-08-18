package org.rinky.digitalassistant.bot.io;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.rinky.digitalassistant.bot.ai.spi.HashMapConverter;

import com.google.common.collect.Maps;

@Entity
@Table(name = "events")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="event_time")
	private final long eventTime;
	@Column(name="event_type")
	@Enumerated(EnumType.STRING)
	private EventType eventType;

	public enum EventType {
		LeftMouseClick, Keyboard, Word, ButtonClick,ScreenShot
	}

    @Convert(converter = HashMapConverter.class)
	private Map<String, Object> data = Maps.newHashMap();
	{
		this.eventTime = System.currentTimeMillis();
	}

	public Long getId() {
		return id;
	}

	
	public EventType getEventType() {
		return eventType;
	}


	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public long getEventTime() {
		return eventTime;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public void setData(String name, Object data) {
		this.data.put(name, data);
	}

}
