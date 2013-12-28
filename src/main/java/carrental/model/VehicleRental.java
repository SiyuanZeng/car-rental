package carrental.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author M1017325
 * 
 */

public class VehicleRental implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String customerName;
	private String category;
	private String registrationNumber;
	private Date bookedFrom;
	private Date bookedTo;
	private Integer totalRent;
	private String paymentStatus;

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName
	 *            the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * @param registrationNumber
	 *            the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
	 * @return the bookedFrom
	 */
	public Date getBookedFrom() {
		return bookedFrom;
	}

	/**
	 * @param bookedFrom
	 *            the bookedFrom to set
	 */
	public void setBookedFrom(Date bookedFrom) {
		this.bookedFrom = bookedFrom;
	}

	/**
	 * @return the bookedTo
	 */
	public Date getBookedTo() {
		return bookedTo;
	}

	/**
	 * @param bookedTo
	 *            the bookedTo to set
	 */
	public void setBookedTo(Date bookedTo) {
		this.bookedTo = bookedTo;
	}

	/**
	 * @return the paymentStatus
	 */
	public String getPaymentStatus() {
		return paymentStatus;
	}

	/**
	 * @param paymentStatus
	 *            the paymentStatus to set
	 */
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	/**
	 * @return the totalRent
	 */
	public Integer getTotalRent() {
		return totalRent;
	}

	/**
	 * @param totalRent
	 *            the totalRent to set
	 */
	public void setTotalRent(Integer totalRent) {
		this.totalRent = totalRent;
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
				+ ((bookedFrom == null) ? 0 : bookedFrom.hashCode());
		result = prime * result
				+ ((bookedTo == null) ? 0 : bookedTo.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result
				+ ((paymentStatus == null) ? 0 : paymentStatus.hashCode());
		result = prime
				* result
				+ ((registrationNumber == null) ? 0 : registrationNumber
						.hashCode());
		result = prime * result
				+ ((totalRent == null) ? 0 : totalRent.hashCode());
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
		if (!(obj instanceof VehicleRental)) {
			return false;
		}
		VehicleRental other = (VehicleRental) obj;
		if (bookedFrom == null) {
			if (other.bookedFrom != null) {
				return false;
			}
		} else if (!bookedFrom.equals(other.bookedFrom)) {
			return false;
		}
		if (bookedTo == null) {
			if (other.bookedTo != null) {
				return false;
			}
		} else if (!bookedTo.equals(other.bookedTo)) {
			return false;
		}
		if (category == null) {
			if (other.category != null) {
				return false;
			}
		} else if (!category.equals(other.category)) {
			return false;
		}
		if (customerName == null) {
			if (other.customerName != null) {
				return false;
			}
		} else if (!customerName.equals(other.customerName)) {
			return false;
		}
		if (paymentStatus == null) {
			if (other.paymentStatus != null) {
				return false;
			}
		} else if (!paymentStatus.equals(other.paymentStatus)) {
			return false;
		}
		if (registrationNumber == null) {
			if (other.registrationNumber != null) {
				return false;
			}
		} else if (!registrationNumber.equals(other.registrationNumber)) {
			return false;
		}
		if (totalRent == null) {
			if (other.totalRent != null) {
				return false;
			}
		} else if (!totalRent.equals(other.totalRent)) {
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
		return "RentalVehicle [bookedFrom=" + bookedFrom + ", bookedTo="
				+ bookedTo + ", category=" + category + ", customerName="
				+ customerName + ", paymentStatus=" + paymentStatus
				+ ", registrationNumber=" + registrationNumber + ", totalRent="
				+ totalRent + "]";
	}

}
