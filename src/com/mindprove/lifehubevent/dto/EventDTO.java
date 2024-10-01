package com.mindprove.lifehubevent.dto;

import java.sql.Date;

public class EventDTO {
	private int userId;
	private int groupId;
	private String eventType;
	private String activeIndicator;
	private String eventStartDateString;
	private String eventEndDateString;
	private String eventStatusIndicator;
	private Long eventId;

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
		// System.out.println("vadfkjhgafjgafjdgdfdkjgfahjfgafhghas");
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getActiveIndicator() {
		return activeIndicator;
	}

	public void setActiveIndicator(String activeIndicator) {
		this.activeIndicator = activeIndicator;
	}

	public String getEventStartDateString() {
		return eventStartDateString;
	}

	public void setEventStartDateString(String eventStartDateString2) {
		this.eventStartDateString = eventStartDateString2;
	}

	public String getEventEndDateString() {
		return eventEndDateString;
	}

	public void setEventEndDateString(String eventEndDateString) {
		this.eventEndDateString = eventEndDateString;
	}

	public String getEventStatusIndicator() {
		return eventStatusIndicator;
	}

	public void setEventStatusIndicator(String eventStatusIndicator) {
		this.eventStatusIndicator = eventStatusIndicator;
	}

}
