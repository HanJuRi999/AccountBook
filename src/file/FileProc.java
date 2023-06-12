package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import dto.MoneyDto;
import singleton.SingletonClass;

public class FileProc {

	private File file = null;
	
	public FileProc(String fileName) {
		file = new File("d:\\tmp\\" + fileName +".txt");
		
		try {
			if(file.createNewFile()) {
				System.out.println("가계부를 생성하였습니다.");
			} else {
				System.out.println("가계부 작성을 시작합니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void write() {
		SingletonClass s = SingletonClass.getInstance();
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			for (int i = 0; i < s.accountList.size(); i++) {
				MoneyDto dto = s.accountList.get(i);
				pw.println(dto.Print());
			}
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("작업을 저장하였습니다.");
	}
	
	public void read() {
		SingletonClass s = SingletonClass.getInstance();
		try {
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				String str = "";
				while((str = br.readLine()) != null) {
					System.out.println(str);
					
					String split[] = str.split(" : ");
					
					MoneyDto dto = new MoneyDto(split[0], split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), split[4]);
					
					s.accountList.add(dto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
