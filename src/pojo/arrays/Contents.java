package pojo.arrays;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import pojo.Content;

public class Contents implements Serializable {

	private ArrayList<Content> content;

	
	public ArrayList<Content> getContent() {
		return content;
	}

	public void setContent(ArrayList<Content> content) {
		this.content = content;
	}

	@Override
	public String toString() {
		
		Iterator<Content> iterator = content.iterator();
		StringBuilder sb = new StringBuilder();
		while(iterator.hasNext())
			sb.append(iterator.next().toString());
		
		return "Contents [content=" + sb.toString()  + "]";
	}
	
	
	
}
