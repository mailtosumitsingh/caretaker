package org.rinky.digitalassistant.bot.ai.spi;

import java.util.Map;

import com.google.common.collect.Maps;

public class Context {
	Map<String, Object> data = Maps.newHashMap();
	String workingDir ;
	
	public String getWorkingDir() {
		return workingDir;
	}

	public void setWorkingDir(String workingDir) {
		this.workingDir = workingDir;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
