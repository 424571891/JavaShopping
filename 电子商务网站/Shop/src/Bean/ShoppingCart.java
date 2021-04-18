package Bean;

public class ShoppingCart {
	private String SCno;
	private String Cno;
	
	public ShoppingCart() {
		
	}

	public ShoppingCart(String sCno, String cno) {
		super();
		SCno = sCno;
		Cno = cno;
	}

	public String getSCno() {
		return SCno;
	}

	public void setSCno(String sCno) {
		SCno = sCno;
	}

	public String getCno() {
		return Cno;
	}

	public void setCno(String cno) {
		Cno = cno;
	}
	
	
	
}
