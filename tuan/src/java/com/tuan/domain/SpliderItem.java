/**
 * 
 */
package com.tuan.domain;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * @author sunquanzhi
 *
 */
@Entity
@Table(name="tuan_splider_item")
public class SpliderItem {

	private Integer id;
	
	private Integer cityId;
	
	private String parserName;
	
	private Integer flag;
	
	private String url;
	
	private Integer fromId;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "city_id")
	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@Column(name = "parser_name")
	public String getParserName() {
		return parserName;
	}

	public void setParserName(String parserName) {
		this.parserName = parserName;
	}
	@Column(name = "flag")
	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	@Column(name = "url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	@Column(name = "from_id")
	public Integer getFromId() {
		return fromId;
	}

	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}
	
	@Transient
	public String getCityName() {
		for (Map.Entry<String, Integer> entry : Constants.CITY_ID.entrySet()) {
			if (entry.getValue().equals(cityId)) {
//				System.out.println(entry.getKey()+":"+cityId);
				return entry.getKey();
			}
		}
		return "";
	}
	
	@Transient
	public String getFromName() {
		for (Map.Entry<String, Integer> entry : Constants.FROM_ID.entrySet()) {
			if (entry.getValue().equals(fromId)) {
				return entry.getKey();
			}
		}
		return "";
	}
	
	@Transient
	public String getZhParserName() {
		for (Map.Entry<String, String> entry : Constants.FROM_PARSER.entrySet()) {
			if (entry.getValue().equals(parserName)) {
				return entry.getKey();
			}
		}
		return "";
	}
}
