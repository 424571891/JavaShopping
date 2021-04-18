package Bean;

public class Customer {
	
	private String Cno;
	private String Cpassword;
	private String Cname;
	private String Csex;// VARCHAR(5) CHECK(Csex IN('男','女')),
	private String Ctel;// VARCHAR(15),
	private String Caddress;// VARCHAR(100) ,
	private Double Cbalance;// Float(2) NOT NULL CHECK(Cbalance >= 0)
	 
	public Customer() {
		 
	}
	
	public Customer(String cno, String cpassword, String cname, String csex, String ctel, String caddress,
			Double cbalance) {
		super();
		Cno = cno;
		Cpassword = cpassword;
		Cname = cname;
		Csex = csex;
		Ctel = ctel;
		Caddress = caddress;
		Cbalance = cbalance;
	}

	public String getCno() {
		return Cno;
	}

	public void setCno(String cno) {
		Cno = cno;
	}

	public String getCpassword() {
		return Cpassword;
	}

	public void setCpassword(String cpassword) {
		Cpassword = cpassword;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	public String getCsex() {
		return Csex;
	}

	public void setCsex(String csex) {
		Csex = csex;
	}

	public String getCtel() {
		return Ctel;
	}

	public void setCtel(String ctel) {
		Ctel = ctel;
	}

	public String getCaddress() {
		return Caddress;
	}

	public void setCaddress(String caddress) {
		Caddress = caddress;
	}

	public Double getCbalance() {
		return Cbalance;
	}

	public void setCbalance(Double cbalance) {
		Cbalance = cbalance;
	}
	 
}
