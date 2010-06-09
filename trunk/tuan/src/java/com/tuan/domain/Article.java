package com.tuan.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tuan_article")
public class Article {

	private Integer id;
	
	private Integer categoryId;
	
	private Integer cityId;
	
	private String name;
	
	private Date endTime;
	
	private String content;
	
	private Integer fromId;
	
	private String originalPrice;
	
	private String nowPrice;
	
	private String discount;
	
	private String saveMoney;
	
	private String url;
	
	private Integer voteNum;
	
	private Integer olderNum;
	
	private String imgurl;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "category_id")
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	@Column(name = "city_id")
	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "end_time")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	@Column(name = "content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	@Column(name = "from_id")
	public Integer getFromId() {
		return fromId;
	}

	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}
	@Column(name = "ori_price")
	public String getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}
	@Column(name = "now_price")
	public String getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(String nowPrice) {
		this.nowPrice = nowPrice;
	}
	@Column(name = "discount")
	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}
	@Column(name = "save_money")
	public String getSaveMoney() {
		return saveMoney;
	}

	public void setSaveMoney(String saveMoney) {
		this.saveMoney = saveMoney;
	}
	@Column(name = "a_url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	@Column(name = "vote_num")
	public Integer getVoteNum() {
		return voteNum;
	}

	public void setVoteNum(Integer voteNum) {
		this.voteNum = voteNum;
	}
	@Column(name = "older_num")
	public Integer getOlderNum() {
		return olderNum;
	}

	public void setOlderNum(Integer olderNum) {
		this.olderNum = olderNum;
	}
	@Column(name = "img_url")
	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	
}
