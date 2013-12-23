package carrental.model;

/**
 * @author M1017325
 * 
 */

public class Vehicle {
	private String registrationNumber;
	private String fuelType;
	private Integer mileage;
	private String category;
	private Integer dailyRent;
	// hidden value
	private String secretValue;
	private String description;
	private String manufacturer;

	public String getSecretValue() {
		return secretValue;
	}

	public void setSecretValue(String secretValue) {
		this.secretValue = secretValue;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getDailyRent() {
		return dailyRent;
	}

	public void setDailyRent(Integer dailyRent) {
		this.dailyRent = dailyRent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((dailyRent == null) ? 0 : dailyRent.hashCode());
		result = prime * result
				+ ((fuelType == null) ? 0 : fuelType.hashCode());
		result = prime * result + ((mileage == null) ? 0 : mileage.hashCode());
		result = prime
				* result
				+ ((registrationNumber == null) ? 0 : registrationNumber
						.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Vehicle)) {
			return false;
		}
		Vehicle other = (Vehicle) obj;
		if (category == null) {
			if (other.category != null) {
				return false;
			}
		} else if (!category.equals(other.category)) {
			return false;
		}
		if (dailyRent == null) {
			if (other.dailyRent != null) {
				return false;
			}
		} else if (!dailyRent.equals(other.dailyRent)) {
			return false;
		}
		if (fuelType == null) {
			if (other.fuelType != null) {
				return false;
			}
		} else if (!fuelType.equals(other.fuelType)) {
			return false;
		}
		if (mileage == null) {
			if (other.mileage != null) {
				return false;
			}
		} else if (!mileage.equals(other.mileage)) {
			return false;
		}
		if (registrationNumber == null) {
			if (other.registrationNumber != null) {
				return false;
			}
		} else if (!registrationNumber.equals(other.registrationNumber)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vehicle [category=" + category + ", dailyRent=" + dailyRent
				+ ", fuelType=" + fuelType + ", mileage=" + mileage
				+ ", registrationNumber=" + registrationNumber + "]";
	}

}
