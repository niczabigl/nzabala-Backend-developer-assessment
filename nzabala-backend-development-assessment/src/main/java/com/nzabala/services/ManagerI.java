package com.nzabala.services;

import java.util.ArrayList;

public interface ManagerI {
	
	public void getDataSource();
	public ArrayList<?> filterDataById(String id);
	public ArrayList<?> filterDataByName(String name);
	
}
