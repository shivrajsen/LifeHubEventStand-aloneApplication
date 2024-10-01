package com.mindprove.lifehubevent.util;

public class ValidationUtil {
	// int static userId=0;
	public static boolean validateUserId(int userId) {
		// int userId= userId;
		return userId > 0;

	}

	public static boolean validateGroupId(int groupId) {
		return groupId > 0;
		
	}

	public static boolean validateActiveIndicator(String activeIndicator) {
		
		return activeIndicator.equals("Y") || activeIndicator.equals("N");
		
	}

	public static void validateEventEndDateString() {

	}

	public static boolean validateeventStatusIndicator(String statusIndicator) {
		return statusIndicator.equals("Y") || statusIndicator.equals("N");
	}

}
