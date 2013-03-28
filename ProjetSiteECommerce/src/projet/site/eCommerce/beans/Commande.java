package projet.site.eCommerce.beans;

import java.io.Serializable;
import java.sql.Date;

public class Commande implements Serializable{
	private int idCmd;
	private Date dateCmd;
	private double totalCmd;
	private String statutCmd;
	
	public Commande(){}

	public int getIdCmd() {
		return idCmd;
	}

	public void setIdCmd(int idCmd) {
		this.idCmd = idCmd;
	}

	public Date getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

	public double getTotalCmd() {
		return totalCmd;
	}

	public void setTotalCmd(double totalCmd) {
		this.totalCmd = totalCmd;
	}

	public String getStatutCmd() {
		return statutCmd;
	}

	public void setStatutCmd(String statutCmd) {
		this.statutCmd = statutCmd;
	}
	

}
