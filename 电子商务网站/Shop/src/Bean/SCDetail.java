package Bean;

public class SCDetail {
	private String SCDno;
	private String SCno;
	private String Gno;
	private int SCDnum;
	private Goods goods;
	
	
	public SCDetail() {
		
	}

	public SCDetail(String sCDno, String sCno, String gno, int sCDnum) {
		super();
		SCDno = sCDno;
		SCno = sCno;
		Gno = gno;
		SCDnum = sCDnum;
	}

	public String getSCDno() {
		return SCDno;
	}

	public void setSCDno(String sCDno) {
		SCDno = sCDno;
	}

	public String getSCno() {
		return SCno;
	}

	public void setSCno(String sCno) {
		SCno = sCno;
	}

	public String getGno() {
		return Gno;
	}

	public void setGno(String gno) {
		Gno = gno;
	}

	public int getSCDnum() {
		return SCDnum;
	}

	public void setSCDnum(int sCDnum) {
		SCDnum = sCDnum;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
	
}
