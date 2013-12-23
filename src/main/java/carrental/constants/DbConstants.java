package carrental.constants;

public class DbConstants {

	public static final String ADD_BOOKING_RENTAL_VEHICLE="insert into vehicle_booking" +
	"(customer_name,vehicle_category,vehicle_reg_no," +
	"booked_from,booked_to, total_rent, payment_status) values(?,?,?,?,?,?,?)";
	public static final String ADD_VEHICLE="insert into vehicles" +
	"(registration_no,fuel_type,manufacturer,mileage," +
	"category,daily_rent, description) values(?,?,?,?,?,?,?)";
	public static final String GET_CATEGORY="select registration_no,category,daily_rent from vehicles";
	public static final String GET_FUEL_TYPE="select fuel_type from vehicles";
	public static final String GET_REG_NO="select registration_no from vehicles where category=?";
	public static final String GET_RENT="select daily_rent from vehicles where registration_no=?";
	public static final String GET_REPORT="Select Data1.category as 'Vehicle Type'," +
	"carsNum as 'Total No of Vehicles', " +
	"rentNum as 'Total No of Vehicles Rented', " +
	"total as'Total Rent Earned' " +
	"From " +
	"(Select category, " +
	"Count(*) as carsNum " +
	"From vehicles " +
	"Group by category) as Data1 " +
	"Join " +
	"(Select b.vehicle_category as category, " +
	"Count(*) as rentNum, " +
	"Sum(b.total_rent) as total " +
	"From vehicle_booking b " +
	"Group by b.vehicle_category) as Data2 " +
	"On Data1.category = Data2.category;";

}
