package carrental.constants;

public class DbConstants {

	public static final String ADD_BOOKING_RENTAL_VEHICLE="insert into vehicle_booking" + "(customer_name,vehicle_category,vehicle_reg_no," + "booked_from,booked_to, total_rent, payment_status) values(?,?,?,?,?,?,?)";
	public static final String INSERT_VEHICLE="insert into vehicles(registration_no,fuel_type,manufacturer,mileage,category,daily_rent, description) values(?,?,?,?,?,?,?)";
	public static final String INSERT_TASK="insert into task (category_id,name,deadline,start_time,time,happy_time,end_time,description) values(?,?,?,?,?,?,?,?)";
	public static final String INSERT_TASK_REVIEW_STATUS="insert into task_review_status (id,10_minutes,24_hours,1_week,1_month,2_month) values(?,?,?,?,?,?)";
	public static final String INSERT_CATEGORY="insert into category (id,name) values(?,?)";
	public static final String INSERT_VOCABULARY="insert into vocabulary (category_id,word,etymology,subject_form,adverb_form,verb_form,adjective_form,noun_form,synonym,antonym,note,example,personal_experience,writing,memory_tag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String INSERT_VOCABULARY_CATEGORY="insert into vocabulary_category (category) values(?)";
	public static final String INSERT_VOCABULARY_VOCABULARY_CATEGORY_MAPS="insert into vocabulary_vocabulary_category_maps (category_1,category_2,category_3,category_4) values(?,?,?,?)";


	public static final String GET_CATEGORY="select registration_no,category,daily_rent from vehicles";
	public static final String GET_FUEL_TYPE="select fuel_type from vehicles";
	public static final String GET_REG_NO="select registration_no from vehicles where category=?";
	public static final String GET_RENT="select daily_rent from vehicles where registration_no=?";
	public static final String GET_REPORT=
	"Select Data1.category as 'Vehicle Type'," +
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

	public static final String SELECT_CATEGORY="select id, name from category";
	public static final String SELECT_CATEGORY_BY_ID="select name from category where id=?";
	public static final String SELECT_CATEGORY_BY_NAME="select id from category where name=?";
	public static final String SELECT_TASK="select * from task";
	public static final String SELECT_TASK_BY_ID="select * from task where id = ?";
	public static final String SELECT_TASK_REVIEW_STATUS_BY_ID="select * from task_review_status where id = ?";
	public static final String SELECT_VOCABULARY="select * from vocabulary";
	public static final String SELECT_CATEGORY_FOR_VOCABULARY="select * from vocabulary_vocabulary_category_maps where id =?";
	public static final String SELECT_VOCABULARY_CATEGORY="select * from vocabulary_category";
	public static final String SELECT_VOCABULARY_VOCABULARY_CATEGORY_MAPS="select * from vocabulary_vocabulary_category_maps";


	public static final String UPDATE_TASK="UPDATE task SET name=?, category_id=?, time=?, deadline=?, start_time=?,happy_time=?,end_time=?,description=? WHERE id = ?";
	public static final String UPDATE_TASK_REVIEW_STATUS="UPDATE task_review_status SET 10_minutes=?, 24_hours=?, 1_week=?, 1_month=?,2_month=? WHERE id = ?";


	public static final String DELETE_TASK="DELETE from task WHERE id = ?";
}
