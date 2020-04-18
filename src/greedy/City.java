package greedy;
import java.awt.Point;

/**
 * @author Angela Wang, Rakesh Gururaj
 *
 */
public class City {
	private String cityName;
	private int cityId;
	private boolean isVisited;
	private Point xCoordPoint;
	private Point yCoordPoint;
	
	/**
	 * @param cityName
	 * @param cityId
	 * @param isVisited
	 */
	public City(String cityName, int cityId, boolean isVisited) {
		//super();
		this.cityName = cityName;
		this.cityId = cityId;
		this.isVisited = isVisited;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "City{" + "cityName:" + cityName + "cityId:" + cityId + "isVisited:" + isVisited + "}";
	}

	/**
	 * @param cityName
	 * @param cityId
	 * @param isVisited
	 * @param xCoordPoint
	 * @param yCoordPoint
	 */
	public City(String cityName, int cityId, boolean isVisited, Point xCoordPoint, Point yCoordPoint) {
		//super();
		this.cityName = cityName;
		this.cityId = cityId;
		this.isVisited = isVisited;
		this.xCoordPoint = xCoordPoint;
		this.yCoordPoint = yCoordPoint;
	}

	/**
	 * @param cityName
	 */
	public City(String cityName) {
		//super();
		this.cityName = cityName;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the cityId
	 */
	public int getCityId() {
		return cityId;
	}

	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	/**
	 * @return the isVisited
	 */
	public boolean isVisited() {
		return isVisited;
	}

	/**
	 * @param isVisited the isVisited to set
	 */
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	
	
	
	
}
