package cs255tsp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Angela Wang, Rakesh Gururaj
 *
 */
public class TSPRoute {
	private final City startingCity;
	private City currentCity;
	private List<City> travelRoute = new ArrayList<City>();
	/**
	 * Initialize the startingCity to null when the TSP route constructor is called from driver class
	 */
	public TSPRoute() {
		this.startingCity = null;
	}
	/**
	 * @param startingCity
	 */
	public TSPRoute(City startingCity) {
		//super();
		this.startingCity = startingCity;
		this.currentCity = startingCity;
		this.travelRoute.add(startingCity);
	}
	/**
	 * @return the currentCity
	 */
	public City getCurrentCity() {
		return currentCity;
	}
	/**
	 * @param currentCity the currentCity to set
	 */
	public void setCurrentCity(City currentCity) {
		this.currentCity = currentCity;
	}
	/**
	 * @return the startingCity
	 */
	public City getStartingCity() {
		return startingCity;
	}
	/**
	 * @return the travelRoute
	 */
	public List<City> getTravelRoute() {
		return travelRoute;
	}
	/**
	 * @param travelRoute the travelRoute to set
	 */
	public void setTravelRoute(List<City> travelRoute) {
		this.travelRoute = travelRoute;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String route = "";
		if(!travelRoute.isEmpty()) {
			for (City city : travelRoute) {
				route = route + city.getCityName()+ " --> ";
			}
			route = route.substring(0,route.length()-5);
		}
		return "TSPRoute{"+ route + "}";
	}
	
	
	
	
}
