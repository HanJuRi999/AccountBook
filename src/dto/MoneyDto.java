package dto;

public class MoneyDto {

	private String date;
	private String title;
	private int incExp;
	private int money;
	private String memo;
	
	public MoneyDto() {
		
	}

	public MoneyDto(String date, String title, int incExp, int money, String memo) {
		super();
		this.date = date;
		this.title = title;
		this.incExp = incExp;
		this.money = money;
		this.memo = memo;
	}

	// 무엇을 수정할지 결정 후...
	public MoneyDto(String title, int incExp, int money, String memo) {
		super();
		this.title = title;
		this.incExp = incExp;
		this.money = money;
		this.memo = memo;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIncExp() {
		return incExp;
	}

	public void setIncExp(int incExp) {
		this.incExp = incExp;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "[연월일 : " + date + " 용도 : " + title + " 수입(1), 지출(2) : " + incExp + " 금액 : " + money + " 내용 : "
				+ memo + "]";
	}
	
	public String Print() {
		return date + "/"  + " : " + title + " : " + incExp + " : " + money + " : " + memo;
	}

	public void split(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
}
