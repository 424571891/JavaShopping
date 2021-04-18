package Bean;

public class Stock {
	private String Gno;//主码1：n (n端为主码)
	private String Sno;
	private int STnum;
	private int STsales_num;
	
	public Stock() {
		
	}

	public Stock(String gno, String sno, int sTnum, int sTsales_num) {
		super();
		Gno = gno;
		Sno = sno;
		STnum = sTnum;
		STsales_num = sTsales_num;
	}

	public String getGno() {
		return Gno;
	}

	public void setGno(String gno) {
		Gno = gno;
	}

	public String getSno() {
		return Sno;
	}

	public void setSno(String sno) {
		Sno = sno;
	}

	public int getSTnum() {
		return STnum;
	}

	public void setSTnum(int sTnum) {
		STnum = sTnum;
	}

	public int getSTsales_num() {
		return STsales_num;
	}

	public void setSTsales_num(int sTsales_num) {
		STsales_num = sTsales_num;
	}
	
	
	
	
}
