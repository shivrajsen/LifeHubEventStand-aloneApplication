package com.mindprove.lifehubevent.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.mindprove.lifehubevent.dto.EventDTO;

public class UserScanner 
{
	
	public static EventDTO userget()
	{
	Scanner sc = new Scanner(System.in);
	System.out.println(" Enter User Id ");

	EventDTO eventDTO = new EventDTO();
	// eventDTO.setUserId(0);
	int userId = 0;

	try {
		userId = sc.nextInt();
		// boolean v = ValidationUtil.getUserId(userId);
		boolean isValidUserId = ValidationUtil.validateUserId(userId);
		if (!isValidUserId) {
			System.out.println("Invalid User ID. Please correct Enter User ID.");
			userget();
		}
		eventDTO.setUserId(userId);
	} catch (InputMismatchException nb) {
		System.out.println("Invalid User ID. Please Try Again.");
		userget();
	} catch (Exception nb) {
		System.out.println("Invalid User ID. Please Try Again.");
		userget();
	}

	System.out.println("Enter Group Id");
	int groupId = 0;
	try {
		groupId = sc.nextInt();
		// boolean v = ValidationUtil.getUserId(userId);
		boolean isValidUserId = ValidationUtil.validateGroupId(groupId);
		if (!isValidUserId) {
			System.out.println("Invalid Group ID. Please correct Enter Group ID.");
			userget();
		}
		eventDTO.setGroupId(groupId);
	} catch (InputMismatchException nb) {
		System.out.println("Invalid Group ID. Please Try Again.");
		userget();
	}

	catch (Exception nb) {
		System.out.println("Invalid Group ID. Please Try Again.");
		userget();
	}

	String eventType = null;// = sc.next();

	boolean validEventType = false;

	while (!validEventType) {
		System.out.println("Enter Event Type:");
		System.out.println("Event types are: ");

		System.out.println("Operations : Write Number to perform Operations");
		System.out.println(":-----------------------: ");
		System.out.println(" 1 : Pregnancy");
		System.out.println(" 2 : Accident");
		System.out.println(" 3 : Cancer");
		System.out.println(" 4 : Natural Disaster");
		System.out.println(" 5 : Mental Health");

		System.out.println(":-----------------------: ");

		eventType = sc.next();

		eventDTO.setEventType(eventType);
		switch (eventType) {
		case "1":
			eventType = "P";
			validEventType = true;
			break;
		case "2":
			eventType = "A";
			validEventType = true;
			break;
		case "3":
			eventType = "C";
			validEventType = true;
			break;
		case "4":
			eventType = "M";
			validEventType = true;
			break;
		case "5":
			eventType = "N";
			validEventType = true;
			break;
		default:
			System.out.println("Please enter a correct option.");
			break;
		}
	}

	System.out.println("Please Enter Active Indicator");
	System.out.println("Please Enter Active Indicator (Y for Active, N for Inactive):");
	String activeIndicator = sc.next();

	boolean isValidActive = ValidationUtil.validateActiveIndicator(activeIndicator);
	if (!isValidActive) {
		System.out.println("Invalid input. Please enter A or Z. PleaseTry Again");
		userget();
	}
	eventDTO.setActiveIndicator(activeIndicator);
	System.out.println("Enter Event Start Date Please Enter Date in format MM/dd/YYYY");
	//SimpleDateFormat simpleDateFormat = null;
	//Date eventStartDate = null;
	String eventStartDateString = sc.next();
	eventDTO.setEventStartDateString(eventStartDateString);

	
	System.out.println("Please Enter Event End Date Please Enter Date in format MM/dd/YYYY");
	String eventEndDateString = sc.next();

	
	eventDTO.setEventEndDateString(eventEndDateString);
	
	//System.out.println(eventEndDate);
	System.out.println("Please Enter Event Status Indicator");
	System.out.println("Please Enter Event Status Indicator (Y for Yes, N for No):");

	String eventStatusIndicator = sc.next();
	boolean active = ValidationUtil.validateeventStatusIndicator(eventStatusIndicator);
	if (!active) {
		System.out.println("Invalid input. Please enter Y or N.. Please Try Again .");
		userget();
	}
	eventDTO.setEventStatusIndicator(eventStatusIndicator);
	int createdBy = userId;
	Date createdDate = new Date();
	return eventDTO;
	}

	public static Long deleteScanner()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Event ID");
		EventDTO eventDTO = new EventDTO();
		Long eventId = null;
		try {
			eventId = sc.nextLong();
			
		} catch (InputMismatchException e) {
			System.out.println("Enter the currect Event type : ");
			deleteScanner();
		}
		return eventId;
	}
	
	public static Long viewScanner()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Event ID");
		Long eventId = null;
		try {
			eventId = sc.nextLong();
		} catch (InputMismatchException e) {
			System.out.println("inccurect Event id please try again :");
			viewScanner();

		}
		return eventId;
	}
	public static Long updateScanner()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Event ID");
		Long eventId = null;
		try {
			eventId = sc.nextLong();
		} catch (InputMismatchException e) {
			System.out.println("inccurect Event id please try again :");
			updateScanner();
		}
		return eventId ;
		
	}
	
	
	
	
}
