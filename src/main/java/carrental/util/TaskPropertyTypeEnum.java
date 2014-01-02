package carrental.util;

enum TaskPropertyTypeEnum {
	NAME("Name") {
		public String getTypeString() {
			return "Name";
		}
	},
	DEADLINE("Deadline") {
		public String getTypeString() {
			return "Deadline";
		}
	},
	TIME("Time") {
		public String getTypeString() {
			return "Time";
		}
	},
	DESCRIPTION("Description") {
		public String getTypeString() {
			return "Time";
		}
	},
	CATEGORY("Category") {
		public String getTypeString() {
			return "Time";
		}
	};

	TaskPropertyTypeEnum(String taskPropertyType) {
		this.taskPropertyType = taskPropertyType;
	}

	private String taskPropertyType;

	public String getTaskPropertyType() {
		return taskPropertyType;
	}

	public String getTypeString() {
		return "B";
	}
}
