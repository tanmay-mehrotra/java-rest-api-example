package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Impressions")
public class Impression {
	
	@Id
	@Column(name="id")
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int impressionId;
	
	@Column(name="ad_id")
	private int adId;
	
	@Column(name="browser_info")
	private String browserInfo;
	
	@Column(name="tracking_info")
	private String trackingInfo;

	public int getImpressionId() {
		return impressionId;
	}

	public void setImpressionId(int impressionId) {
		this.impressionId = impressionId;
	}

	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}

	public String getBrowserInfo() {
		return browserInfo;
	}

	public void setBrowserInfo(String browserInfo) {
		this.browserInfo = browserInfo;
	}

	public String getTrackingInfo() {
		return trackingInfo;
	}

	public void setTrackingInfo(String trackingInfo) {
		this.trackingInfo = trackingInfo;
	}
}