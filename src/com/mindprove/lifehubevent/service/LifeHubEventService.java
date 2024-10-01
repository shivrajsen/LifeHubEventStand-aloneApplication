package com.mindprove.lifehubevent.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.mindprove.lifehubevent.dto.EventDTO;

import com.mindprove.lifehubevent.util.DButil;
import com.mindprove.lifehubevent.util.UserScanner;
import com.mindprove.lifehubevent.util.ValidationUtil;

public class LifeHubEventService {
	private static Connection con;

	public static void createLifeHubEvent() throws SQLException {

		EventDTO eventDTO = UserScanner.userget();

		int userId = eventDTO.getUserId();
		int groupId = eventDTO.getGroupId();
		String eventType = eventDTO.getEventType();
		String activeIndicator = eventDTO.getActiveIndicator();
		String eventStartDateString = eventDTO.getEventStartDateString();
		String eventEndDateString = eventDTO.getEventEndDateString();
		String eventStatusIndicator = eventDTO.getEventStatusIndicator();

		SimpleDateFormat simpleDateFormat = null;
		Date eventStartDate = null;

		try {

			simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

			eventStartDate = simpleDateFormat.parse(eventStartDateString);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Date eventEndDate = null;

		try {

			eventEndDate = simpleDateFormat.parse(eventEndDateString);

		} catch (ParseException e) {

			e.printStackTrace();
		}

		// String eventStatusIndicator = eventDTO.getEventStatusIndicator();
		int createdBy = userId;
		Date createdDate = new Date();

		try {

			Connection con = DButil.getConnection();
			Long eventId = DButil.generateEventId();
			PreparedStatement preparedStatement1 = con.prepareStatement(
					"insert into GA_LIFEHUB_EVENTSS(USER_ID,GRP_ID,EVENT_TYPE,EVENT_ID,ACTIVE_IN,EVENT_START_DT,EVENT_END_DT,EVENT_STATUS_IN,CREATE_BY,CREATE_TS) values(?,?,?,?,?,?,?,?,?,?)");
			preparedStatement1.setInt(1, userId);
			preparedStatement1.setInt(2, groupId);
			preparedStatement1.setString(3, eventType);
			preparedStatement1.setLong(4, eventId);
			preparedStatement1.setString(5, activeIndicator);

			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat();
//			Date date = sdf.parse(eventStartDate);

			preparedStatement1.setDate(6, new java.sql.Date(eventStartDate.getTime()));
			preparedStatement1.setDate(7, new java.sql.Date(eventEndDate.getTime()));
			preparedStatement1.setString(8, eventStatusIndicator);
			preparedStatement1.setInt(9, createdBy);
			preparedStatement1.setTimestamp(10, new Timestamp(createdDate.getTime()));

			int row = preparedStatement1.executeUpdate();
			if (row > 0) {
				System.out.println("Event Created Successfully");
			} else {
				System.out.println("Event Not Created");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void deleteLifeHubEvent() throws SQLException {

		Long eventId = UserScanner.deleteScanner();

		try {

			Connection con = DButil.getConnection();

			PreparedStatement preparedStatement = con
					.prepareStatement("delete from GA_LIFEHUB_EVENTSS where EVENT_ID = ?");
			preparedStatement.setLong(1, eventId);

			int row = preparedStatement.executeUpdate();
			if (row > 0) {
				System.out.println("Event Deleted Successfully");
			} else {
				System.out.println("Event Deleted Unsuccessfull");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("-----------");

		}

	}

	public static void viewLifeHubEvent() throws SQLException {

		Long eventId = UserScanner.viewScanner();

		try {

			Connection con = DButil.getConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("select * from  GA_LIFEHUB_EVENTSS where EVENT_ID = ?");
			preparedStatement.setLong(1, eventId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				System.out.println("User Id: " + resultSet.getString(1));
				System.out.println("Group Id: " + resultSet.getString(2));
				System.out.println("Event Type: " + resultSet.getString(3));
				System.out.println("Event Id: " + resultSet.getString(4));
				System.out.println("Active Indicator: " + resultSet.getString(5));
				System.out.println("Event Start Date: " + resultSet.getString(6));
				System.out.println("Event End Date: " + resultSet.getString(7));
				System.out.println("Event Status Indicator: " + resultSet.getString(8));
				System.out.println("-------------------------------------------------------");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (NullPointerException e) {
			System.out.println("-----------");

		}
	}

	public static void updateLifeHubEvent() throws SQLException {
		Long eventId = UserScanner.updateScanner();
		EventDTO eventDTO = UserScanner.userget();

		int userId = eventDTO.getUserId();
		int groupId = eventDTO.getGroupId();
		String eventType = eventDTO.getEventType();
		String activeIndicator = eventDTO.getActiveIndicator();
		String eventStartDateString = eventDTO.getEventStartDateString();
		String eventEndDateString = eventDTO.getEventEndDateString();
		String eventStatusIndicator = eventDTO.getEventStatusIndicator();

		SimpleDateFormat simpleDateFormat = null;
		Date eventStartDate = null;

		try {

			simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

			eventStartDate = simpleDateFormat.parse(eventStartDateString);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Date eventEndDate = null;

		try {

			eventEndDate = simpleDateFormat.parse(eventEndDateString);

		} catch (ParseException e) {

			e.printStackTrace();
		}

		// String eventStatusIndicator = eventDTO.getEventStatusIndicator();
		int createdBy = userId;
		Date createdDate = new Date();
		

		try {

			Connection con = DButil.getConnection();
			String updateQuery = "UPDATE GA_LIFEHUB_EVENTSS SET USER_ID = ?, GRP_ID = ?, EVENT_TYPE = ?, ACTIVE_IN = ?, EVENT_START_DT = ?, EVENT_END_DT = ?, EVENT_STATUS_IN = ?, CREATE_BY = ?, CREATE_TS = ? WHERE EVENT_ID = ?";
			PreparedStatement preparedStatement = con.prepareStatement(updateQuery);

			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, groupId);
			preparedStatement.setString(3, eventType);
			preparedStatement.setString(4, activeIndicator);
			preparedStatement.setDate(5, new java.sql.Date(eventStartDate.getTime()));
			preparedStatement.setDate(6, new java.sql.Date(eventEndDate.getTime()));
			preparedStatement.setString(7, eventStatusIndicator);
			preparedStatement.setInt(8, createdBy);
			preparedStatement.setTimestamp(9, new Timestamp(createdDate.getTime()));
			preparedStatement.setLong(10, eventId);

			int rowsUpdated = preparedStatement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Event updated successfully.");
			} else {
				System.out.println("No event found with the given ID.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}

}
