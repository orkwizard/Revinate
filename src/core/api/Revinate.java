package core.api;

import java.net.URI;
import java.security.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoField;
import java.util.HashMap;

import core.Net;
import core.crypto.utils.EncryptionUtil;

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
	
	
	public Revinate() {
		super();		
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
	

	public String getHotelSets() throws Exception {
		String ep = endpoint +"/hotels";	
		generateParams();
		
		
		
		System.out.println(Net.get(ep,params));
		return null;
	}
	
	
	@Override
	public String toString() {
		return "Revinate [username=" + api_user + ", apikey=" + api_key + ", encoded=" + encoded + ", timestamp="
				+ timestamp + "]";
	}

	public static void main(String[] args) {
		Revinate revinate = new Revinate();
		try {
			System.out.println(revinate.getHotelSets());
			System.out.println(revinate.toString());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
}
