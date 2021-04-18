package Bean;

public class Shop {
	private String Sno;
	private String Sname;
	private String Stype;
	private String Saddress;
	
	public Shop() {
		
	}

	public Shop(String sno, String sname, String stype, String saddress) {
		super();
		Sno = sno;
		Sname = sname;
		Stype = stype;
		Saddress = saddress;
	}

	public String getSno() {
		return Sno;
	}

	public void setSno(String sno) {
		Sno = sno;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public String getStype() {
		return Stype;
	}

	public void setStype(String stype) {
		Stype = stype;
	}

	public String getSaddress() {
		return Saddress;
	}

	public void setSaddress(String saddress) {
		Saddress = saddress;
	}
	
	
}
