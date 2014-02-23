package carrental.model;

import java.util.Date;

import org.joda.time.LocalTime;

public class Task extends WorkItem {
	private TaskCategory category;
	private Date deadline;
	private LocalTime startTime;
	private Integer time;
	private LocalTime happyTime;
	private LocalTime endTime;
	private String description;


	public TaskCategory getTaskCategory() {
		return category;
	}

	public void setTaskCategory(TaskCategory category) {
		this.category = category;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getHappyTime() {
		return happyTime;
	}

	public void setHappyTime(LocalTime happyTime) {
		this.happyTime = happyTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", category=" + category.getName()
				+ ", deadline=" + deadline + ", startTime=" + startTime
				+ ", time=" + time + ", happyTime=" + happyTime + ", endTime="
				+ endTime + ", description=" + description + "]";
	}



}
