package cs255tsp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Angela Wang, Rakesh Gururaj
 *
 */
public class TSPBruteForce {
	private int numberofCities;
	private City startingCity;
	private List<String> citiesSelectedUI = new ArrayList<String>();
	private List<City> citiesSelected;
	private List<TSPRoute> tspAllPossibleRoutes = new ArrayList<TSPRoute>();
	/**
	 * @param numberofCities
	 * @param startingCity
	 * @param citiesSelectedCities
	 */
	public TSPBruteForce(int numberofCities, City startingCity,List<String> citiesSelectedUI) {
		//super();
		this.numberofCities = numberofCities;
		this.startingCity = startingCity;
		this.citiesSelectedUI = citiesSelectedUI;
		initialiseCities(startingCity, citiesSelectedUI);
	}
	
	void initialiseCities(City startingCity,List<String> citiesSelectedUI) {
		citiesSelected = new ArrayList<City>();
		startingCity.setVisited(true);
		boolean isVisited = false;
		for(int i=1;i<=citiesSelectedUI.size();i++) {
			citiesSelected.add(new City(citiesSelectedUI.get(i), i, isVisited));
		}
	}
	
	/**
	 * @param numberofCities
	 * @return the number of permutations of choosing a route.
	 */
	int calculatePermutationRoutes(int numberofCities) {
		return numberofCities == 0 ||numberofCities==1 ? 1 : numberofCities * calculatePermutationRoutes(numberofCities-1);
	}
	
	/**
	 * @param tspRoute
	 * @param citiesSelectedUI
	 * This method is to find all the paths involved in brute force approach.
	 * It will output all the paths which is equal to the number of routes returned from calculatePermutationRoutes method.
	 */
	void findAllPathsofTSP(TSPRoute tspRoute,List<String> citiesSelectedUI){
		//initialiseCities(startingCity, citiesSelectedUI);
		if(!citiesSelectedUI.isEmpty()) {
			for(int i = 0;i<citiesSelectedUI.size();i++) {
				String currentCity = citiesSelectedUI.remove(i);
				tspRoute.getTravelRoute().add(new City(currentCity));
				findAllPathsofTSP(tspRoute, citiesSelectedUI);
				citiesSelectedUI.add(currentCity);
			}
		}
		else {
			tspAllPossibleRoutes.add(tspRoute);
		}
	}
	
	/**
	 * @param startingCity
	 * @param tspAllPossibleRoutes
	 * @param distanceMatrix
	 * This method need is to calculate the best route from brute force approach paths.
	 */
	void calculateBestRouteTSP(City startingCity,List<TSPRoute> tspAllPossibleRoutes, double[][] distanceMatrix) {
		for (TSPRoute tspRoute : tspAllPossibleRoutes) {
			tspRoute.getTravelRoute().add(0,startingCity);
			tspRoute.getTravelRoute().add(startingCity);
			//calculateRouteCost(tspRoute,distanceMatrix);
		}
	}
	
	
	
}
