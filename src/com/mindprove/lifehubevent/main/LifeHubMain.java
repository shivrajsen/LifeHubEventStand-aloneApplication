package com.mindprove.lifehubevent.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.mindprove.lifehubevent.service.LifeHubEventService;

public class LifeHubMain {

	public static void main(String[] args) throws SQLException {
		boolean flag = true;
		while (flag) {
			System.out.println("Welcome to GA Portal");
			System.out.println("Please Select One Option");
			System.out.println("Operations : Write Number to perform Operations");
			System.out.println("1 : Create Event");
			System.out.println("2 : Update Event");
			System.out.println("3 : Delete Event");
			System.out.println("4 : View Events");
			System.out.println("5 : Quit");
			Scanner sc = new Scanner(System.in);
			int operationNumber = sc.nextInt();
			if (operationNumber == 5) {
				System.out.println("Thank you (<'.'>) close The EVENT ");
				break;

			}
			if (operationNumber == 1) {
				LifeHubEventService.createLifeHubEvent();
			}
			if (operationNumber == 2) {
				LifeHubEventService.updateLifeHubEvent();

			}
			if (operationNumber == 3) {
				LifeHubEventService.deleteLifeHubEvent();
			}

			if (operationNumber == 4) {
				LifeHubEventService.viewLifeHubEvent();
			}
		}
	}
}
