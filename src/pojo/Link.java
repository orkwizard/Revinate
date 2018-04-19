package pojo;

import java.io.Serializable;

public class Link implements Serializable {

	private String rel;
	private String href;
	private boolean templated;
	
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public boolean isTemplated() {
		return templated;
	}
	public void setTemplated(boolean templated) {
		this.templated = templated;
	}
	@Override
	public String toString() {
		return "Link [rel=" + rel + ", href=" + href + ", templated=" + templated + "]";
	}
	
	
	
	
}
