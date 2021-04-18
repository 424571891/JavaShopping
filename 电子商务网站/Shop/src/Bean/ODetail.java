package Bean;

public class ODetail {
	private String ODno;
	private String Ono;
	private String Gno;
	private int ODnum;
	private double ODprice;
	
	public ODetail() {
		
	}

	public ODetail(String oDno, String ono, String gno, int oDnum, double oDprice) {
		super();
		ODno = oDno;
		Ono = ono;
		Gno = gno;
		ODnum = oDnum;
		ODprice = oDprice;
	}

	public String getODno() {
		return ODno;
	}

	public void setODno(String oDno) {
		ODno = oDno;
	}

	public String getOno() {
		return Ono;
	}

	public void setOno(String ono) {
		Ono = ono;
	}

	public String getGno() {
		return Gno;
	}

	public void setGno(String gno) {
		Gno = gno;
	}

	public int getODnum() {
		return ODnum;
	}

	public void setODnum(int oDnum) {
		ODnum = oDnum;
	}

	public double getODprice() {
		return ODprice;
	}

	public void setODprice(double oDprice) {
		ODprice = oDprice;
	}
	
	
	
}
