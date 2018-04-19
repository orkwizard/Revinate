package pojo;

import java.io.Serializable;

import pojo.arrays.Links;

public class Content implements Serializable {

	private String name;
	private String slug;
	private String logo;
	private String url;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private String tripAdvisorId;
	private String revinatePurchaseUri;
	private String revinateLoginUri;
	private String accountType;
	private Links links;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTripAdvisorId() {
		return tripAdvisorId;
	}
	public void setTripAdvisorId(String tripAdvisorId) {
		this.tripAdvisorId = tripAdvisorId;
	}
	public String getRevinatePurchaseUri() {
		return revinatePurchaseUri;
	}
	public void setRevinatePurchaseUri(String revinatePurchaseUri) {
		this.revinatePurchaseUri = revinatePurchaseUri;
	}
	public String getRevinateLoginUri() {
		return revinateLoginUri;
	}
	public void setRevinateLoginUri(String revinateLoginUri) {
		this.revinateLoginUri = revinateLoginUri;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Links getLinks() {
		return links;
	}
	public void setLinks(Links links) {
		this.links = links;
	}
	@Override
	public String toString() {
		return "Content [name=" + name + ", slug=" + slug + ", logo=" + logo + ", url=" + url + ", address1=" + address1
				+ ", address2=" + address2 + ", city=" + city + ", state=" + state + ", postalCode=" + postalCode
				+ ", country=" + country + ", tripAdvisorId=" + tripAdvisorId + ", revinatePurchaseUri="
				+ revinatePurchaseUri + ", revinateLoginUri=" + revinateLoginUri + ", accountType=" + accountType
				+ ", links=" + links + "]";
	}
	
	
	
	
	
	
}
