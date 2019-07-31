package com.hcl.productdb.entity;
 
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Table(name="product_details")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="productId")
public class ProductVersion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6460211118375582536L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_price")
	private Double productPrice;
	
	@Column(name="product_description")
	private String productDescription;
	
	@Column(name="product_version")
	private Float productVersion;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="product_id")
	private Product productId;
	
	

}
