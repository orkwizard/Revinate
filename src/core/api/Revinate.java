package core.api;

import java.security.Timestamp;
import java.time.Instant;
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
	static final String api_token	 ="ac5c9d5828c1fbefe6090277c106c027";
	static final String api_secret	="488589fb7d831ba79fa27b489efa0745b813c41f10fed42d64f8bf1c0ddaba4e";
	
	
	String encoded;
	long timestamp;
	HashMap<String,String> params;
	
	
	public Revinate() {
		super();		
	}


	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getEncoded() {
		return encoded;
	}

	public void setEncoded(String encoded) {
		this.encoded = encoded;
	}
	
	public long getEpoch() {
		return Instant.now().getEpochSecond();
	}
	
	private String generateHMAC() {
		String value;	
		timestamp = Instant.now().getEpochSecond();
		value = EncryptionUtil.calculateHMAC(api_secret, api_user, timestamp);
		return value;
	}
	
	private void generateParams() {
		params = new HashMap<>();
		params.put(xporter_user, api_user);
		params.put(xporter_timestap,""+timestamp);
		params.put(xporter_apikey,api_token);
		params.put(xporter_encoded, generateHMAC());
		
		
	}
	

	public String getHotelSets() throws Exception {
		String ep = endpoint +"//hotelsets";	
		generateParams();
		//System.out.println(toString());
		
		System.out.println(Net.get(ep,params));
		
		return null;
	}
	
	
	@Override
	public String toString() {
		return "Revinate [username=" + api_user + ", apikey=" + api_token + ", encoded=" + encoded + ", timestamp="
				+ timestamp + "]";
	}

	public static void main(String[] args) {
		Revinate revinate = new Revinate();
		revinate.setEncoded(revinate.generateHMAC());
		
		try {
			
			System.out.println(revinate.getHotelSets());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
}
