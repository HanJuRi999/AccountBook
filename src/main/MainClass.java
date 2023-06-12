package main;

import java.util.Scanner;

import dao.MoneyDao;
import file.FileProc;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		MoneyDao dao = new MoneyDao();
		FileProc fp = new FileProc("accountbook");
		
		// 가계부 메뉴
		
		
		while(true) {
			System.out.println("");
			System.out.println("Account Book Menu ======================= ");
			System.out.println("1. 가계부 추가");
			System.out.println("2. 가계부 삭제");
			System.out.println("3. 가계부 검색");
			System.out.println("4. 가계부 수정");
			System.out.println("5. 월별 결산");
			System.out.println("6. 월간 검색");
			System.out.println("7. 불러오기");
			System.out.println("8. 전체 결산");
			System.out.println("9. 파일 저장");
			System.out.println("10. 종료");
			
			System.out.println("어떤 작업을 하시겠습니까? (1 ~ 10) >> ");
			int menuNumber = sc.nextInt();
			
			switch(menuNumber) {
			case 1:
				dao.insert();
				break;
			case 2:
				dao.delete();
				break;
			case 3:
				dao.select();
				break;
			case 4:
				dao.update();
				break;
			case 5:
				dao.month();
				break;
			case 6:
				dao.week();
				break;
			case 7:
				fp.read();
				break;
			case 8:
				dao.allDataPrint();
				break;
			case 9:
				fp.write();
				break;
			case 10:
				System.out.println("작업을 종료합니다.");
				break;
			}
		}

	}

}
