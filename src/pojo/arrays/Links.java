package pojo.arrays;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import pojo.Link;


public class Links implements Serializable{

	private ArrayList<Link> links;
	
	
	public ArrayList<Link> getLinks() {
		return links;
	}
	public void setLinks(ArrayList<Link> links) {
		this.links = links;
	}
	@Override
	public String toString() {
		
		StringBuilder sblinks = new StringBuilder(); 
		Iterator<Link> iterator = links.iterator();
		
		while(iterator.hasNext())
			sblinks.append(iterator.next().toString());
		
		
		return "Links [links=" + sblinks + "]";
	}
	
	
	
	
}
