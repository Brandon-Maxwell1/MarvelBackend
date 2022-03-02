package com.bmaxwell.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import org.hibernate.annotations.Type;


@Entity
@Table (name="heroprofiles")
public class heroProfiles {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	@Column
	private String name;
	@Column
	private String description;
	@Lob
	@Column(name = "thumbnailpath")
	@Type(type = "org.hibernate.type.BinaryType")
	private byte[] thumbnailpath;
	
	
	public int getId() {
		return userid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public byte[] getThumbnailpath() {
		return thumbnailpath;
	}
	
	public void setThumbnailpath(byte[] thumbnailpath) {
		this.thumbnailpath = thumbnailpath;
	}
	
}
