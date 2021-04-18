package Bean;

import java.sql.Timestamp;

public class Order {
	private String Ono;
	private String Cno;
	private Timestamp Otime_create;
	private Timestamp Otime_complete;
	private String Ostatus;
	private Double Oprice;
	
	public Order() {
		
	}

	public Order(String ono, String cno, Timestamp otime_create, Timestamp otime_complete, String ostatus,
			Double oprice) {
		super();
		Ono = ono;
		Cno = cno;
		Otime_create = otime_create;
		Otime_complete = otime_complete;
		Ostatus = ostatus;
		Oprice = oprice;
	}

	public String getOno() {
		return Ono;
	}

	public void setOno(String ono) {
		Ono = ono;
	}

	public String getCno() {
		return Cno;
	}

	public void setCno(String cno) {
		Cno = cno;
	}

	public Timestamp getOtime_create() {
		return Otime_create;
	}

	public void setOtime_create(Timestamp otime_create) {
		Otime_create = otime_create;
	}

	public Timestamp getOtime_complete() {
		return Otime_complete;
	}

	public void setOtime_complete(Timestamp otime_complete) {
		Otime_complete = otime_complete;
	}

	public String getOstatus() {
		return Ostatus;
	}

	public void setOstatus(String ostatus) {
		Ostatus = ostatus;
	}

	public Double getOprice() {
		return Oprice;
	}

	public void setOprice(Double oprice) {
		Oprice = oprice;
	}
	
	
	
}
