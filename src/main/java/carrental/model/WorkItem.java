package carrental.model;

public class WorkItem {

	protected int id;
	protected String name;

	private int categoryId;

	public WorkItem() {
		super();
	}

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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "WorkItem [id=" + id + ", name=" + name + ", categoryId="
				+ categoryId + "]";
	}
}
