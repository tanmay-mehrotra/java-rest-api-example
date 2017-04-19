package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clicks")
public class Click {

	@Id
	@Column(name="id")
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int clickId;
	
	@Column(name="impression_id")
	private int impressionId;
	
	public int getClickId() {
		return clickId;
	}
	public void setClickId(int clickId) {
		this.clickId = clickId;
	}
	public int getImpressionId() {
		return impressionId;
	}
	public void setImpressionId(int impressionId) {
		this.impressionId = impressionId;
	}
}
