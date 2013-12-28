package carrental.model;

public class ReportEntry {
	private String VehicleType;
	private int TotalNumOfVehicles;
	private int TotalNumOfVehiclesRent;
	private int TotalRentEarned;

	public ReportEntry() {
		super();
	}

	public String getVehicleType() {
		return VehicleType;
	}

	public void setVehicleType(String vehicleType) {
		VehicleType = vehicleType;
	}

	public int getTotalNumOfVehicles() {
		return TotalNumOfVehicles;
	}

	public void setTotalNumOfVehicles(int totalNumOfVehicles) {
		TotalNumOfVehicles = totalNumOfVehicles;
	}

	public int getTotalNumOfVehiclesRent() {
		return TotalNumOfVehiclesRent;
	}

	public void setTotalNumOfVehiclesRent(int totalNumOfVehiclesRent) {
		TotalNumOfVehiclesRent = totalNumOfVehiclesRent;
	}

	public int getTotalRentEarned() {
		return TotalRentEarned;
	}

	public void setTotalRentEarned(int totalRentEarned) {
		TotalRentEarned = totalRentEarned;
	}

	public ReportEntry(String vehicleType, int totalNumOfVehicles,
			int totalNumOfVehiclesRent, int totalRentEarned) {
		super();
		VehicleType = vehicleType;
		TotalNumOfVehicles = totalNumOfVehicles;
		TotalNumOfVehiclesRent = totalNumOfVehiclesRent;
		TotalRentEarned = totalRentEarned;
	}

	@Override
	public String toString() {
		return "ReportEntry [VehicleType=" + VehicleType
				+ ", TotalNumOfVehicles=" + TotalNumOfVehicles
				+ ", TotalNumOfVehiclesRent=" + TotalNumOfVehiclesRent
				+ ", TotalRentEarned=" + TotalRentEarned + "]";
	}

	
}
