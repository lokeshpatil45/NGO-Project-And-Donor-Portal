package Getter_Setter;


public class Projects {
	static int pid;
	static String title;
	static String description;
	static String goalAmount;
	static String startDate;
	public static int getPid() {
		return pid;
	}
	public static void setPid(int pid) {
		Projects.pid = pid;
	}
	public static String getTitle() {
		return title;
	}
	public static void setTitle(String title) {
		Projects.title = title;
	}
	public static String getDescription() {
		return description;
	}
	public static void setDescription(String description) {
		Projects.description = description;
	}
	public static String getGoalAmount() {
		return goalAmount;
	}
	public static void setGoalAmount(String goalAmount) {
		Projects.goalAmount = goalAmount;
	}
	public static String getStartDate() {
		return startDate;
	}
	public static void setStartDate(String startDate) {
		Projects.startDate = startDate;
	}
	
}
