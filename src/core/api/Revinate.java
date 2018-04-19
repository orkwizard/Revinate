package core.api;

import java.net.URI;
import java.security.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoField;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import core.Net;
import core.crypto.utils.EncryptionUtil;
import pojo.Hotel;
import pojo.arrays.Hotels;

public class Revinate {

	static final String xporter_user = "X-Revinate-Porter-Username";
	static final String xporter_timestap = "X-Revinate-Porter-Timestamp";
	static final String xporter_apikey ="X-Revinate-Porter-Key";
	static final String xporter_encoded ="X-Revinate-Porter-Encoded";
	
	static final String endpoint 	="https://porter.revinate.com";
	static final String api_user 	="api@sunset.com.mx";
	static final String api_key		="ac5c9d5828c1fbefe6090277c106c027";
	static final String api_secret	="488589fb7d831ba79fa27b489efa0745b813c41f10fed42d64f8bf1c0ddaba4e";
	
	
	String encoded;
	String timestamp;
	HashMap<String,String> params;
	
	Gson gson;
	
	
	public Revinate() {
		super();		
		gson = new Gson();
	}

	public String getTimestamp() {
		return ""+Instant.now().getEpochSecond();
	}

	public String getEncoded() {
		return encoded;
	}

	public void setEncoded(String encoded) {
		this.encoded = encoded;
	}

	private String generateHMAC(String ts) {
		String value;	
		value = EncryptionUtil.calculateHMAC(api_secret, api_user,ts);
		return value;
	}
	
	private void generateParams() {
		params = new HashMap<>();
		String ts = getTimestamp();
		params.put(xporter_user, api_user);
		params.put(xporter_timestap,ts);
		timestamp = ts;
		params.put(xporter_apikey,api_key);
		setEncoded(generateHMAC(ts));
		params.put(xporter_encoded,getEncoded());
		
		
	}
	

	public Hotel getHotels() {
		Hotel hotel = new Hotel();
		String ep = endpoint +"/hotels";	
		generateParams();
		
		String json;
		try {
			json = Net.get(ep,params);
			System.out.println(json);
			
			
			hotel = gson.fromJson(json, Hotel.class);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hotel;
	}
	
	
	@Override
	public String toString() {
		return "Revinate [username=" + api_user + ", apikey=" + api_key + ", encoded=" + encoded + ", timestamp="
				+ timestamp + "]";
	}

	public static void main(String[] args) {
		Revinate revinate = new Revinate();
		Hotel hotels = revinate.getHotels();
		System.out.println(hotels.toString());
		
	}
	
}
