package carrental.model;

import java.util.Date;
import java.util.List;

public class Task {
	private int id;
	private String name;
	private Category category;
	private Date deadline;
	private int time;
	private String description;
	private List<Task> subtasks;

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

	public List<Task> getSubtasks() {
		return subtasks;
	}

	public void setSubtasks(List<Task> subtasks) {
		this.subtasks = subtasks;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", category="
				+ category.getName() + ", deadline=" + deadline + ", time="
				+ time + ", description=" + description + ", subtasks="
				+ subtasks + "]";
	}

}
