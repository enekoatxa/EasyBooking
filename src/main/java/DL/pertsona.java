package DL;

import javax.jdo.annotations.*;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.SUBCLASS_TABLE)
public abstract class pertsona 
{
	@PrimaryKey
	private String nan;
	private String izena;
	@NotPersistent
	private String abizena;
	@NotPersistent
	private int adina;
	
	public String getNan() {
		return nan;
	}
	public void setNan(String nan) {
		this.nan = nan;
	}
	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	public String getAbizena() {
		return abizena;
	}
	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}
	public int getAdina() {
		return adina;
	}
	public void setAdina(int adina) {
		this.adina = adina;
	}
	
}

	
