package org.rinky.digitalassistant.bot.model;

public class FaceObj {
	private String emotion;
	private float panAngle;
	private float rollAngle;
	private float tiltAngle;
	
	private boolean isAngry;
	private boolean isJoy;
	private boolean isSurprised;
	
	private boolean roolAngle;
	
	private boolean hasHeadWear;
	
	
	public boolean isHasHeadWear() {
		return hasHeadWear;
	}
	public void setHasHeadWear(boolean hasHeadWear) {
		this.hasHeadWear = hasHeadWear;
	}
	public boolean isRoolAngle() {
		return roolAngle;
	}
	public void setRoolAngle(boolean roolAngle) {
		this.roolAngle = roolAngle;
	}
	public String getEmotion() {
		return emotion;
	}
	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}
	public float getPanAngle() {
		return panAngle;
	}
	public void setPanAngle(float panAngle) {
		this.panAngle = panAngle;
	}
	public float getRollAngle() {
		return rollAngle;
	}
	public void setRollAngle(float rollAngle) {
		this.rollAngle = rollAngle;
	}
	public float getTiltAngle() {
		return tiltAngle;
	}
	public void setTiltAngle(float tiltAngle) {
		this.tiltAngle = tiltAngle;
	}
	public boolean isAngry() {
		return isAngry;
	}
	public void setAngry(boolean isAngry) {
		this.isAngry = isAngry;
	}
	public boolean isJoy() {
		return isJoy;
	}
	public void setJoy(boolean isJoy) {
		this.isJoy = isJoy;
	}
	public boolean isSurprised() {
		return isSurprised;
	}
	public void setSurprised(boolean isSurprised) {
		this.isSurprised = isSurprised;
	}
	public boolean isIssorrow() {
		return issorrow;
	}
	public void setIssorrow(boolean issorrow) {
		this.issorrow = issorrow;
	}
	private boolean issorrow;
	
}
