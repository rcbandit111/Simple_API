package org.datalis.rest.api.server.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Product implements Serializable {
 
	private static final long serialVersionUID = -4849448978483136332L;

	@XmlElement(name = "parent_object")
	public String parentObject;
	
	@XmlElement(name = "products")
	public List<String> products;
	
	@XmlElement(name = "name")
	public String name;
		
	@XmlElement(name = "price")
	public String price;

	public String getParentObject() {
		return parentObject;
	}

	public void setParentObject(String parentObject) {
		this.parentObject = parentObject;
	}

	public List<String> getProducts() {
		return products;
	}

	public void setProducts(List<String> products) {
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
