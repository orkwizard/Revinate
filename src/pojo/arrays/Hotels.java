package pojo.arrays;

import java.io.Serializable;

import pojo.Hotel;

public class Hotels implements Serializable {

	private Hotel hotel;

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "Hotels [hotel=" + hotel.toString() + "]";
	}
	
	
	
}
