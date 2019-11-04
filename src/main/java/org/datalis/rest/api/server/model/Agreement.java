package org.datalis.rest.api.server.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "agreement")
@XmlAccessorType(XmlAccessType.FIELD)
public class Agreement implements Serializable {

	private static final long serialVersionUID = -1758207026453357160L;

	@XmlElement(name = "name")
	public String name;
	
	@XmlElement(name = "signed_by")
	public String signedBy;
	
	@XmlElement(name = "products")
	public List<Product> products;
	
	public Agreement() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSignedBy() {
		return signedBy;
	}

	public void setSignedBy(String signedBy) {
		this.signedBy = signedBy;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
