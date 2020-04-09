package cs255tsp;

import java.util.ArrayList;
import java.util.List;

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
	
}
