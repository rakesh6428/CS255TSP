package cs255tsp;
import java.awt.Point;

public class City {
	private String cityNameString;
	private int cityId;
	private boolean isVisited;
	private Point xCoordPoint;
	private Point yCoordPoint;
	/**
	 * @param cityNameString
	 * @param cityId
	 * @param isVisited
	 * @param xCoordPoint
	 * @param yCoordPoint
	 */
	public City(String cityNameString, int cityId, boolean isVisited, Point xCoordPoint, Point yCoordPoint) {
		super();
		this.cityNameString = cityNameString;
		this.cityId = cityId;
		this.isVisited = isVisited;
		this.xCoordPoint = xCoordPoint;
		this.yCoordPoint = yCoordPoint;
	}
	
	
}
