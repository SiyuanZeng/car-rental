package carrental.model;

import java.util.Date;
import java.util.List;

import org.joda.time.LocalTime;

public class Task {
	private int id;
	private String name;
	private Category category;
	private Date deadline;
	private LocalTime startTime;
	private int time;
	private LocalTime happyTime;
	private LocalTime endTime;
	private String description;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
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
