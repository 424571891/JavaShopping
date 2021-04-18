package Bean;

public class Merchant {
	
	private String Mno;
	private String Mpassword;
	private String Mname;
	private String Mtel;
	
	public Merchant() {
		
	}

	public Merchant(String mno, String mpassword, String mname, String mtel) {
		super();
		Mno = mno;
		Mpassword = mpassword;
		Mname = mname;
		Mtel = mtel;
	}

	public String getMno() {
		return Mno;
	}

	public void setMno(String mno) {
		Mno = mno;
	}

	public String getMpassword() {
		return Mpassword;
	}

	public void setMpassword(String mpassword) {
		Mpassword = mpassword;
	}

	public String getMname() {
		return Mname;
	}

	public void setMname(String mname) {
		Mname = mname;
	}

	public String getMtel() {
		return Mtel;
	}

	public void setMtel(String mtel) {
		Mtel = mtel;
	}
	
	
}
