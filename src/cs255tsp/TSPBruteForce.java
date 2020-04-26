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
	private List<City> citiesSelected;
	private List<TSPRoute> tspAllPossibleRoutes = new ArrayList<TSPRoute>();
	private double distanceMatrix[][] = new double[22][22];
	private double shortestTSPDistance = Double.MAX_VALUE;
	private TSPRoute shortestTSPRoute;
	City city = new City();

	/**
	 * @param numberofCities
	 * @param startingCity
	 * @param citiesSelectedCities
	 */
	public TSPBruteForce(int numberofCities, City startingCity, List<City> citiesSelected, double[][] distanceMatrix) {
		// super();
		this.numberofCities = numberofCities;
		this.startingCity = startingCity;
		this.citiesSelected = citiesSelected;
		this.distanceMatrix = distanceMatrix;
		long numberOfRoutes = calculatePermutationRoutes(numberofCities);
		System.out.println("The number of routes that a Salesman can travel from " + startingCity + " is: " + numberOfRoutes);
		findAllPathsofTSP(new TSPRoute(), citiesSelected);
		calculateBestRouteTSP(startingCity, tspAllPossibleRoutes, distanceMatrix);
		System.out.println("The Shortest Distance in Brute Force approach is: " + shortestTSPDistance);
		System.out.println("The shortest Path in Brute Force approach is: " + shortestTSPRoute.toString());
	}

	/*
	 * This Section is Commented out since, this functionality is moved to
	 * ReadCities Class --> insertCities() Method. For Future reference, we might
	 * use this block for the application. void initialiseCities(City
	 * startingCity,List<String> citiesSelectedUI) { citiesSelected = new
	 * ArrayList<City>(); startingCity.setVisited(true); boolean isVisited = false;
	 * for(int i=0;i<citiesSelectedUI.size();i++) { citiesSelected.add(new
	 * City(citiesSelectedUI.get(i), i, isVisited)); } }
	 * System.out.println("i:"+tspRoute.getTravelRoute().get(i).getCityId()+"   -- CityName: "+tspRoute.getTravelRoute().get(i).getCityName());
	 *	System.out.println("i+1:"+tspRoute.getTravelRoute().get(i+1).getCityId()+"   -- CityName: "+tspRoute.getTravelRoute().get(i+1).getCityName());
	 *System.out.println("i-1:"+tspRoute.getTravelRoute().get(i).getCityId());
	 *routeCost = routeCost + distanceMatrix[tspRoute.getTravelRoute().get(i).getCityId() - 1][tspRoute.getTravelRoute().get(i + 1).getCityId() - 1];
	 * 
	 * 
	 */

	/**
	 * @param numberofCities
	 * @return the number of permutations of choosing a route.
	 */
	int calculatePermutationRoutes(int numberofCities) {
		return numberofCities == 0 || numberofCities == 1 ? 1
				: numberofCities * calculatePermutationRoutes(numberofCities - 1);
	}

	/**
	 * @param tspRoute
	 * @param citiesSelectedUI This method is to find all the paths involved in
	 *                         brute force approach. It will output all the paths
	 *                         which is equal to the number of routes returned from
	 *                         calculatePermutationRoutes method.
	 */
	void findAllPathsofTSP(TSPRoute tspRoute, List<City> citiesSelectedUI) {
		if (!citiesSelectedUI.isEmpty()) {
			for (int i = 0; i < citiesSelectedUI.size(); i++) {
				City currentCity = citiesSelectedUI.remove(0);

				TSPRoute newTravelRoute = new TSPRoute();
				for (City city : tspRoute.getTravelRoute()) {
					newTravelRoute.getTravelRoute().add(city);
				}
				newTravelRoute.getTravelRoute().add(currentCity);
				findAllPathsofTSP(newTravelRoute, citiesSelectedUI);
				citiesSelectedUI.add(currentCity);
			}
		} else {
			tspAllPossibleRoutes.add(tspRoute);
		}
	}

	/**
	 * @param startingCity
	 * @param tspAllPossibleRoutes
	 * @param distanceMatrix       
	 * This method need is to calculate the best route
	 *	from brute force approach paths.
	 */
	void calculateBestRouteTSP(City startingCity, List<TSPRoute> tspAllPossibleRoutes, double[][] distanceMatrix) {
		for (TSPRoute tspRoute : tspAllPossibleRoutes) {
			tspRoute.getTravelRoute().add(0, startingCity);
			tspRoute.getTravelRoute().add(startingCity);
			double thisRouteCost = calculateRouteCost(tspRoute, distanceMatrix);
			if (thisRouteCost < shortestTSPDistance) {
				shortestTSPDistance = thisRouteCost;
				shortestTSPRoute = tspRoute;
			}
		}
	}

	/**
	 * @param tspRoute
	 * @param distanceMatrix
	 * @return cost of the route
	 * This method calculates the cost of each route and supplies the value
	 *         to calculateBestRouteTSP for finding the best route
	 */
	double calculateRouteCost(TSPRoute tspRoute, double[][] distanceMatrix) {
		double routeCost = 0;
		//System.out.println("Size:"+tspRoute.getTravelRoute().size());
		for (int i = 0; i < tspRoute.getTravelRoute().size() - 1; i++) {
			routeCost = routeCost + distanceMatrix[tspRoute.getTravelRoute().get(i).getCityId()][tspRoute.getTravelRoute().get(i + 1).getCityId()];
		}
		return routeCost;
	}
}
