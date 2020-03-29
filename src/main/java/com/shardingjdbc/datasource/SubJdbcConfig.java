package com.shardingjdbc.datasource;

/**
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class SubJdbcConfig implements java.io.Serializable {

	private String name;

	private String url;

	private String user;
	private String password;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String uniqueResourceName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUniqueResourceName() {
		return uniqueResourceName;
	}

	public void setUniqueResourceName(String uniqueResourceName) {
		this.uniqueResourceName = uniqueResourceName;
	}

	@Override
	public String toString() {
		return "SubJdbcConfig{" +
				"name='" + name + '\'' +
				", url='" + url + '\'' +
				", uniqueResourceName='" + uniqueResourceName + '\'' +
				'}';
	}
}
