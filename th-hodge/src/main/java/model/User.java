package model;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	@JsonProperty("name") // 重命名
	private String username;
	@JsonIgnore
	private String password;
	@JsonFormat(pattern = "yyyy:MM:dd HH:mm:ss" )
	private Date date;
	@JsonFormat(pattern = "yyyy:MM:dd HH:mm:ss" )
	private Timestamp timestamp;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "username : " + username + ", password : " + password 
				+ ", date : " + date + ", timestamp : " + timestamp;
	}

}
