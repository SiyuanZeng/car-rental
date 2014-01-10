package carrental.model;

public class TaskReviewStatus {

	private int id;
	private int taskId;
	private String name;
	private int tenMinutes;
	private int oneWeek;
	private int oneMonth ;
	private int twoMonth;
	private int twenntyFourHours;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTenMinutes() {
		return tenMinutes;
	}
	public void setTenMinutes(int tenMinutes) {
		this.tenMinutes = tenMinutes;
	}
	public int getOneWeek() {
		return oneWeek;
	}
	public void setOneWeek(int oneWeek) {
		this.oneWeek = oneWeek;
	}
	public int getOneMonth() {
		return oneMonth;
	}
	public void setOneMonth(int oneMonth) {
		this.oneMonth = oneMonth;
	}
	public int getTwoMonth() {
		return twoMonth;
	}
	public void setTwoMonth(int twoMonth) {
		this.twoMonth = twoMonth;
	}
	public int getTwenntyFourHours() {
		return twenntyFourHours;
	}
	public void setTwenntyFourHours(int twenntyFourHours) {
		this.twenntyFourHours = twenntyFourHours;
	}

	@Override
	public String toString() {
		return "TaskReviewStatus [id=" + id + ", taskId=" + taskId
				+ ", tenMinutes=" + tenMinutes + ", oneWeek=" + oneWeek
				+ ", oneMonth=" + oneMonth + ", twoMonth=" + twoMonth
				+ ", twenntyFourHours=" + twenntyFourHours + "]";
	}




}
