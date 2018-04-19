package core;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.event.ListSelectionEvent;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.http.NameValuePair;


public class Net {
	
	public Net() {
		super();
	}
	
	public static String get(String endpoint,HashMap<String,String> params) throws Exception {
		
		CloseableHttpClient client = HttpClients.custom().build();	
		HttpUriRequest request = RequestBuilder.get().setUri(endpoint)
				.setHeader(HttpHeaders.CONTENT_TYPE, "application/json").build();	
		Iterator<Entry<String,String>> iterator =  params.entrySet().iterator();	
		while(iterator.hasNext()) {
			Entry<String,String> e = iterator.next();
			request.addHeader(e.getKey(),e.getValue().toString());	
		}
		CloseableHttpResponse response = client.execute(request);

		return  EntityUtils.toString(response.getEntity());
		
	}
	
}
