package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


public class TSPDp {
	
	private int numberofCities;
	private City startingCity;
	private Map<Integer,City> cityInfo;
	private double[][] distanceMatrix; 
	private double[][] dp; //dp[i][j]min length among the set and the last visited city in set is j
	private int[][] route; //record path and route[i][j]=k means k is the last city before visit j among the seti
	private double min = Double.MAX_VALUE;
	public TSPDp(int numberofCities, double[][] distanceMatrix,Map<Integer,City> cityInfo,City startingCity) {
		this.numberofCities = numberofCities;
		this.distanceMatrix = distanceMatrix;
		this.startingCity = startingCity;
		this.cityInfo = cityInfo;
		dp = new double[1 << numberofCities][numberofCities]; //use binary bit to represent city
		route = new int[1 << numberofCities][numberofCities];
	}
	
	public double calRouteDp() {
		int startId = startingCity.getCityId();
		//initialize dp and path
		for(int i=0;i<(1<<numberofCities);i++ ) {
			Arrays.fill(dp[i], Double.MAX_VALUE);
		}
		//if the subset is empty, then let dp[0][i] be the directly distance between start city and i
		for(int i=0;i<numberofCities;i++) {
			if(i== startId) {
				dp[0][i] = 0;
			}
			dp[0][i] = distanceMatrix[i][startId];
		}
		
		for(int i=1;i<(1<<numberofCities);i++) {
			for(int j=0;j<numberofCities;j++) {
				if((i&(1<<j))>0) { //node j in set i
					int preSet = i - (1<<j); //set without node i
					if(preSet==0) {//only contain j
						dp[i][j] = distanceMatrix[startId][j];
						continue;
					}else { //set contains other cities and update min length
						for(int k=0;k<numberofCities;k++) {
							if(dp[preSet][k]< Double.MAX_VALUE && (dp[preSet][k]+distanceMatrix[k][j])<dp[i][j]) {
								dp[i][j]=dp[preSet][k]+distanceMatrix[k][j];
								route[i][j]=k;
							}
						}
					}
				}
			}
		}

			
		return dp[(1 << numberofCities) - 1][startId];
	}
	
	public String buildRoute() {
		Queue<City> order = new LinkedList<>();
		int combination = (1 << numberofCities) - 1;
		int last = startingCity.getCityId();
		while(combination>0) {
			City lastCity = new City(cityInfo.get(last).getCityName(),last,true);
			
			order.add(lastCity);
			int temp = combination;
			combination = combination - (1 <<last);
			last = route[temp][last];
		}
		
		StringBuilder sb = new StringBuilder();
	
		while(!order.isEmpty()) {
			City preCity = order.poll();
			sb.append(preCity.getCityName());
			sb.append(" - ");
		}
		sb.append(startingCity.getCityName());
		return sb.toString();
	}
}
