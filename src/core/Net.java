package core;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Net {
	
	public Net() {
		super();
	}
	
	public static String get(String endpoint,HashMap<String,String> params) throws Exception {
		String result="";
		URIBuilder uri = new URIBuilder(endpoint);
		Iterator<Entry<String,String>> iterator =  params.entrySet().iterator();
		
		while(iterator.hasNext()) {
			Entry<String,String> e = iterator.next();
			uri.setParameter(e.getKey(),e.getValue());
		}
		CloseableHttpClient httpclient = HttpClients.createDefault();
		System.out.println(uri.toString());
		HttpGet httpget = new HttpGet(uri.build());
		
		ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

			@Override
			public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
				// TODO Auto-generated method stub
				HttpEntity entity = response.getEntity();
				return entity != null ? EntityUtils.toString(entity) : null;
			}	
		};			
		result = httpclient.execute(httpget,responseHandler);
		return result;
	}
	
	
	
	
}
