package singleton;

import java.util.ArrayList;
import java.util.List;

import dto.MoneyDto;

public class SingletonClass {

	private static SingletonClass sc = null;
	public List<MoneyDto> accountList = null;
	
	private SingletonClass() {
		accountList = new ArrayList<MoneyDto>();
	}
	
	public static SingletonClass getInstance() {
		if(sc == null) {
			sc = new SingletonClass();
		}
		return sc;
	}
}
