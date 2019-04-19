package com.vv.domain;

import java.io.Serializable;

public class Participant implements Serializable{

	private String tea_id;		//参与者工号
	private String part_user;	//参与者
	private String education;	//学历
	private String rating;		//职称
	private String unit;		//单位
	private String effect;		//贡献
	

	public String getTea_id() {
		return tea_id;
	}
	public void setTea_id(String tea_id) {
		this.tea_id = tea_id;
	}
	public String getPart_user() {
		return part_user;
	}
	public void setPart_user(String part_user) {
		this.part_user = part_user;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	
	
}
