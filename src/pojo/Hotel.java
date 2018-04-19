package pojo;

import java.io.Serializable;

import pojo.arrays.Contents;
import pojo.arrays.Links;

public class Hotel implements Serializable {

	private Links links;
	private Contents content;
	private Page page;
	
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Links getLinks() {
		return links;
	}
	public void setLinks(Links links) {
		this.links = links;
	}
	public Contents getContent() {
		return content;
	}
	public void setContent(Contents content) {
		this.content = content;
	}
	
	
	
	@Override
	public String toString() {
		return "Hotels [links=" + links.toString() + ", content=" + content.toString() + " , Page:" + page.toString()  +"]";
	}
	
	
	
}
