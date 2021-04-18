package Bean;

public class Goods {
	
	private String Gno;
	private String Gname;
	private String Gtype;
	private String Gconcrete_type;
	private double Gprice;
	private String Gmessage;
	private String Gimage;
	
	
	public Goods() {
		
	}
	
	public Goods(String gno, String gname, String gtype, String gconcrete_type, double gprice, String gmessage,
			String gimage) {
		super();
		Gno = gno;
		Gname = gname;
		Gtype = gtype;
		Gconcrete_type = gconcrete_type;
		Gprice = gprice;
		Gmessage = gmessage;
		Gimage = gimage;
	}


	public String getGno() {
		return Gno;
	}
	public void setGno(String gno) {
		Gno = gno;
	}
	public String getGname() {
		return Gname;
	}
	public void setGname(String gname) {
		Gname = gname;
	}
	public String getGtype() {
		return Gtype;
	}
	public void setGtype(String gtype) {
		Gtype = gtype;
	}
	public String getGconcrete_type() {
		return Gconcrete_type;
	}
	public void setGconcrete_type(String gconcrete_type) {
		Gconcrete_type = gconcrete_type;
	}
	public double getGprice() {
		return Gprice;
	}
	public void setGprice(double gprice) {
		Gprice = gprice;
	}
	public String getGmessage() {
		return Gmessage;
	}
	public void setGmessage(String gmessage) {
		Gmessage = gmessage;
	}
	public String getGimage() {
		return Gimage;
	}
	public void setGimage(String gimage) {
		Gimage = gimage;
	}
	
	
	
}
