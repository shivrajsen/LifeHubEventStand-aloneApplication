package com.mindprove.lifehubevent.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DButil {
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/GAPORTAL";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			System.err.println("SQL Exception: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println("Driver Class Not Found: " + e.getMessage());
		}
		return con;

	}
	//static Connection con = null;

    public static Long generateEventId() {
        Long eventId = null;
        Statement statement = null;
        ResultSet rs = null;
        Connection con = getConnection();

        try {
           

          
            statement = con.createStatement();
            rs = statement.executeQuery("SELECT MAX(event_id) FROM GA_LIFEHUB_EVENTSS");

            Long maxEventId = 1L; // Default value
            if (rs.next()) {
                maxEventId = rs.getLong(1);
            }
            eventId = ++maxEventId;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        } finally {
            // Close resources to prevent leaks
            try {
                if (rs != null) rs.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return eventId;
    }
	

}
