# CS255TSP
Traveling Salesman Problem is that given a set of cities and the distance between every pair of cities, the problem is to find the shortest possible route that visits every city exactly once and returns to the starting point. To summarize, the problem is to find the shortest path go through each vertex once and then return back to start vertex in the graph and It can be seen as a minimum weight Hamiltonian Cycle problem. We are focused on solving the problem using 3 different approaches: Brute force, Dynamic Programming, Greedy. Later, we shall be analyzing the performance metric in terms of running time and space involved in the above-mentioned approaches.

Directions to run the .jar file:
1.	Download the datasets (WG – 22 and WG – 11) into a local folder.
2.	Download the executable file (from GitHub) into a local folder.
3.	Open Terminal and navigate to the directory where the executable is downloaded.
4.	Type the below command press the “Enter/Return” button
java -jar cs255TSP.jar
		where cs255TSP is the name of the file.
5.	Enter the complete path of the file name that contains the cities list along with the file name.
Ex: /Volumes/XXXX/CS255/FinalProject/Dataset/Germany_Cities_11.txt
6.	Enter the complete path of the file name that contains the distance matrix along with the file name.
Ex: /Volumes/XXXX/CS255/FinalProject/Dataset/Distance_Matrix_11.txt
7.	Enter the choice of algorithm that solves the TSP
a.	1  Brute Force approach
b.	2  Greedy approach
c.	3  Dynamic Programming approach
8.	Enter the Starting city for tour
Note: The starting city is used only for Brute force approach, for other approaches, by default the tour starts from 1st town (Aachen).
