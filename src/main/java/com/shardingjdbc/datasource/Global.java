package com.shardingjdbc.datasource;

public class Global {
	private int reapTimeout;
	private int poolSize;
	private String defaultDatasource;

	private String master;
	private String slave;

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public String getSlave() {
		return slave;
	}

	public void setSlave(String slave) {
		this.slave = slave;
	}

	private String driverClassName;
	private int minIdle;
	private int maxActive;
	private int maxWait;
	private int minEictableIdleTimeMillis;
	
	public int getReapTimeout() {
		return reapTimeout;
	}
	public void setReapTimeout(int reapTimeout) {
		this.reapTimeout = reapTimeout;
	}
	public int getPoolSize() {
		return poolSize;
	}
	public void setPoolSize(int poolSize) {
		this.poolSize = poolSize;
	}
	public String getDefaultDatasource() {
		return defaultDatasource;
	}
	public void setDefaultDatasource(String defaultDatasource) {
		this.defaultDatasource = defaultDatasource;
	}
 
	public int getMinIdle() {
		return minIdle;
	}
	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}
	public int getMaxWait() {
		return maxWait;
	}
	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}
	public int getMinEictableIdleTimeMillis() {
		return minEictableIdleTimeMillis;
	}
	public void setMinEictableIdleTimeMillis(int minEictableIdleTimeMillis) {
		this.minEictableIdleTimeMillis = minEictableIdleTimeMillis;
	}
	public int getMaxActive() {
		return maxActive;
	}
	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}
	
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	
	public String getDriverClassName() {
		return driverClassName;
	}
}
