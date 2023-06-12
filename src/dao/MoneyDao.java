package dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import dto.MoneyDto;
import singleton.SingletonClass;

public class MoneyDao {

	private Scanner sc = new Scanner(System.in);
	
	public MoneyDao() {
		
	}
	
	public void insert() {
		// TODO : insert()
		System.out.println("데이터를 추가합니다.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("날짜(0000/00/00) = ");
		String date = "";
		try {
			date = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("용도 = ");
		String title = "";
		try {
			title = br1.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("수입(1)/지출(2) = ");
		int incExp = sc.nextInt();
		
		System.out.println("금액 = ");
		int money = sc.nextInt();
		
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("내용 = ");
		String memo = "";
		try {
			memo = br2.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		SingletonClass s = SingletonClass.getInstance();
		s.accountList.add(new MoneyDto(date, title, incExp, money, memo));
	}
	
	public void delete() {
		// TODO : delete()
		
		BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("삭제할 날짜(0000/00/00) >> ");
		String date = "";
		try {
			date = br3.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int index = search(date);
		if(index == -1) {
			System.out.println("검색하신 정보가 없습니다.");
		} else {
			SingletonClass s = SingletonClass.getInstance();
			s.accountList.remove(index);
			
			System.out.println("정보를 삭제하였습니다.");
		}
		
	}
	
	public void select() {
		// TODO : select()
		
		BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("찾으실 날짜(0000/00/00) >> ");
		String date = "";
		try {
			date = br4.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		SingletonClass s = SingletonClass.getInstance();
		
		List<MoneyDto> findDateList = new ArrayList<MoneyDto>();
		for (int i = 0; i < s.accountList.size(); i++) {
			MoneyDto dto = s.accountList.get(i);
			if(date.equals(dto.getDate())) {
				findDateList.add(dto);
			}
		}
		if(findDateList.size() == 0) {
			System.out.println("검색하신 정보가 없습니다.");
			return;
		}
		
		System.out.println("[검색결과]\n");
		for (int i = 0; i < findDateList.size(); i++) {
			MoneyDto dto = findDateList.get(i);
			System.out.println(dto.toString());
		}
	}
	
	public int search(String date) {
		SingletonClass s = SingletonClass.getInstance();
		
		int index = -1;
		for(int i = 0; i < s.accountList.size(); i++) {
			MoneyDto dto = s.accountList.get(i);
			if(date.equals(dto.getDate())) {
				index = i;
				break;
			}
		}
		return index;
		
	}
	
	public void update() {
		// TODO : update()
		BufferedReader br5 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("수정하실 날짜(0000/00/00) >> ");
		String date = "";
		try {
			date = br5.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int index = search(date);
		if(index == -1) {
			System.out.println("검색하신 정보가 없습니다.");
			return;
		}
		
		// 수정할 내용
		BufferedReader br6 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("용도 = ");
		String title = "";
		try {
			title = br6.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("수입(1)/지출(2) = ");
		int incExp = sc.nextInt();
		
		System.out.println("금액 = ");
		int money = sc.nextInt();
		
		BufferedReader br7 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("내용 = ");
		String memo = "";
		try {
			memo = br7.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		SingletonClass s = SingletonClass.getInstance();
		MoneyDto dto = s.accountList.get(index);
		dto.setTitle(title);
		dto.setIncExp(incExp);
		dto.setMoney(money);
		dto.setMemo(memo);
		
		System.out.println("수정을 완료하였습니다.");
		
	}
	
	public void month() {
		// TODO : month()

		BufferedReader br8 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("결산하실 기간(월)이 포함된 날짜(0000/00/00) >> ");
		String date = "";
		try {
			date = br8.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int index = search(date);
		if(index == -1) {
			System.out.println("검색하신 정보가 없습니다.");
			return;
		}
				
		SingletonClass s = SingletonClass.getInstance();
		
		String split[] = date.split("/");	// 입력받은 데이터 자르기
		String spl1 = split[0];
		String spl2 = split[1];
		String spl3 = split[2];
		
		// System.out.println(spl1);
		// System.out.println(spl2);
		// System.out.println(spl3);
		// System.out.println();
				
		for (int i = 0; i < s.accountList.size(); i++) {			
			String account[] = s.accountList.get(i).Print().split("/");	// 저장된 전체 데이터에서 자르기
				String acc1 = account[0];							// 현재는 입력받은 데이터와 값은 값이 나옴
				String acc2 = account[1];
				String acc3 = account[2];	
			
			String account2[] = s.accountList.get(i).Print().split(" : ");	// 저장된 전체 데이터에서 자르기
				String acct1 = account2[0];	// date						// 현재는 입력받은 데이터와 값은 값이 나옴
				String acct2 = account2[1]; // title
				int acct3 = Integer.parseInt(account2[2]);	// incExp
				int acct4 = Integer.parseInt(account2[3]);	// money
				String acct5 = account2[4];	// memo
				
			try {										
				// 전체 자르기한 것과 입력받은 데이터의 년도, 월이 같은 것을 출력
				if(spl1.equals(acc1) && spl2.equals(acc2)) {						
						
							switch(acct3) {
							case 1: {
								int income = 0;								
								income += income + acct4;								
								System.out.println("");
								System.out.println(spl2 + "월 결산 : " + "수입 = " + income);							
								break;
							}
							case 2: {
								int expense = 0;
								expense += expense + acct4;									
								System.out.println(spl2 + "월 결산 : " + "지출 = " + expense);
								break;
							}
							}							
						 
					} else if (!spl1.equals(acc1) || !spl2.equals(acc2)) {
							break;
				} 
								
			} catch (Exception e) {			
				e.printStackTrace();
			}
		}
	}
	
	
	public void week() {
		// TODO : week()
		
		BufferedReader br9 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("검색하실 기간(월)이 포함된 날짜(0000/00/00) >> ");
		String date = "";
		try {
			date = br9.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int index = search(date);
		if(index == -1) {
			System.out.println("검색하신 정보가 없습니다.");
			return;
		}
				
		SingletonClass s = SingletonClass.getInstance();
		
		String split[] = date.split("/");	// 입력받은 데이터 자르기
		String spl1 = split[0];
		String spl2 = split[1];
		String spl3 = split[2];
		
		// System.out.println(spl1);
		// System.out.println(spl2);
		// System.out.println(spl3);
		// System.out.println();
				
		for (int i = 0; i < s.accountList.size(); i++) {			
			String account[] = s.accountList.get(i).Print().split("/");	// 저장된 전체 데이터에서 자르기
			String acc1 = account[0];							// 현재는 입력받은 데이터와 값은 값이 나옴
			String acc2 = account[1];
			String acc3 = account[2];
									
			try {	// 전체 자르기한 것과 입력받은 데이터의 년도, 월이 같은 것을 출력
				if(spl1.equals(acc1) && spl2.equals(acc2)) {					
						System.out.println(s.accountList.get(i).Print());
						System.out.println();
						// System.out.println(acc1);
						// System.out.println(acc2);	
						// System.out.println(acc3);						
					} else if (!spl1.equals(acc1) || !spl2.equals(acc2)) {
						break;
					}
					System.out.println();
							
			} catch (Exception e) {			
				e.printStackTrace();
			}
		
		}
	}
	
	public void allDataPrint() {
		// TODO : allDataPrint()
		SingletonClass s = SingletonClass.getInstance();
		
		if(s.accountList.isEmpty() ) {
			System.out.println("데이터가 없습니다.");
			return;
		}
		
		for (int i = 0; i < s.accountList.size(); i++) {
			System.out.println(s.accountList.get(i).toString());
		}
	}
}
