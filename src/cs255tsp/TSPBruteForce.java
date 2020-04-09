package cs255tsp;

import java.util.ArrayList;
import java.util.List;

public class TSPBruteForce {
	private int numberofCities;
	private City startingCity;
	private List<String> citiesSelectedUI = new ArrayList<String>();
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
	}
	
	void initialiseCities(City startingCity,List<String> citiesSelectedUI) {
		List<City> citiesSelected = new ArrayList<City>();
		startingCity.setVisited(true);
		boolean isVisited = false;
		for(int i=1;i<=citiesSelectedUI.size();i++) {
			citiesSelected.add(new City(citiesSelectedUI.get(i), i, isVisited));
		}
	}
	
}
