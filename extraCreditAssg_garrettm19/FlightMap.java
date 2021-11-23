/**
 *
 * @author Mason Garrett
 */
package extraCreditAssg_garrettm19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class FlightMap implements FlightMapInterface {
    
    private int aCityMarker;
    private int adjCityMarker;
    private int total;
    private City displayCity;
    private LinkedList<City> Cities; 
    private LinkedList<City>[] Paths;
    
    public FlightMap() {
        this.Cities = null;
        this.Paths = null;
    }
	
    @Override  // (WORKING)
    public void loadFlightMap(String cityFileName, String flightFileName) throws FileNotFoundException {
        Scanner inputStreamCity = null, inputStreamFlight = null;
        
        try {
            inputStreamCity = new Scanner(new File(cityFileName));
            inputStreamFlight = new Scanner(new File(flightFileName)); 
        }
        catch (FileNotFoundException e) {
            System.out.println("Error reading the files.");
            System.exit(1);
        }
        this.Cities = new LinkedList<>();
        while (inputStreamCity.hasNextLine()){
            City newCity = new City(inputStreamCity.nextLine());
            this.Cities.add(newCity);
        }
        inputStreamCity.close();
        total = this.Cities.size();
        this.Paths = new LinkedList[total];
        for (int i = 0; i < total; i++) {
            this.Paths[i] = new LinkedList<>();
        }
        while (inputStreamFlight.hasNextLine()) {
            City adjCity = new City(inputStreamFlight.next());
            City adjCity2 = new City(inputStreamFlight.next());
            insertAdjacent(adjCity, adjCity2);
        }
        inputStreamFlight.close();   
    }

    @Override // (WORKING)
    public void insertAdjacent(City aCity, City adjCity) {
        
        aCityMarker = this.Cities.indexOf(aCity);
        adjCityMarker = this.Cities.indexOf(adjCity);
        
        if (this.Paths[aCityMarker].contains(adjCity)) {
        }
        else {
            this.Paths[aCityMarker].add(adjCity); 
        }
        
        if (this.Paths[adjCityMarker].contains(aCity)) {        
        } 
        else {
            this.Paths[adjCityMarker].add(aCity);
        }
        
        aCityMarker = 0;
        adjCityMarker = 0;
    }

    @Override // (WORKING)
    public void displayFlightMap() {
        int pathSize;
        
        for (int i = 0; i < total; i++) {
            
            City currentCity = this.Cities.get(i);
            pathSize = this.Paths[i].size();
            System.out.print("The city " + currentCity.toString() + " serves the following cities: ");
           
            for (int z = 0; z < pathSize; z++) {
                displayCity = this.Paths[i].get(z);
                if (pathSize == 1) {
                    System.out.println(displayCity.toString() + " only.");
                    break;
                }
                if (1 == pathSize - z) {
                    System.out.println("and " + displayCity.toString() + ".");
                }
                else {
                    System.out.print(displayCity.toString() + ", ");
                }
            }
        }
        displayCity = null;
        System.out.println("");
    }

    @Override // (WORKING)
    public void displayAllCities() {
        
        System.out.println("The following cities are served by the airline: ");
        for (int i = 0; i < total; i++) {
            displayCity = this.Cities.get(i);
            if (1 == total - i) {
                System.out.println("and " + displayCity.toString() + ".");
            }
            else {
            System.out.print(displayCity.toString() + ", ");
            }
        }
        displayCity = null;
        System.out.println("");
    }

    @Override // (SHOULD BE WORKING)
    public void displayAdjacentCities(City aCity) {
        int pathSize;
        
        aCityMarker = this.Cities.indexOf(aCity);
        pathSize = this.Paths[aCityMarker].size();
        System.out.println("The following cities are adjacent to " + aCity + ":");
        for (int i = 0; i < pathSize; i++) {
            displayCity = this.Paths[aCityMarker].get(i);
            if (pathSize == 1) {
                System.out.println(displayCity.toString() + " only.");
                break;
            }
            if (1 == pathSize - i) {
                System.out.println("and " + displayCity.toString() + ".");
            }
            else {
                System.out.print(displayCity.toString() + ", ");
            }
        }
        aCityMarker = 0;
        displayCity = null;
        System.out.println("");
    }

    @Override // (SHOULD BE WORKING)
    public void markVisited(City aCity) {
        
        for (int i = 0; i < total; i++) {
            
            City markVisited = this.Cities.get(i);
            if (aCity.equals(markVisited)) {
                markVisited.visit();
                return;
            }
        }
    }

    @Override // (SHOULD BE WORKING)
    public void unVisitAll() {
        
        for (int i = 0; i < total; i++ ) {
            
            City unVisit = this.Cities.get(i);
            unVisit.clear();
        }   
    }
    
    @Override // (SHOULD BE WORKING)
    public boolean isVisited(City aCity) {
	
        for (int i = 0; i < total; i++) {
            
            City checkVisited = this.Cities.get(i);
            if (checkVisited.equals(aCity)) {
                return checkVisited.isVisited();
            }
        }
        return false;
    }

    @Override // (SHOULD BE WORKING)
    public City getNextCity(City aCity) {
        int pathSize;
        
        aCityMarker = this.Cities.indexOf(aCity);
        pathSize = this.Paths[aCityMarker].size();
        
        for (int i = 0; i < pathSize; i++) {
            displayCity = this.Paths[aCityMarker].get(i);
            if (!displayCity.isVisited()) {
                return displayCity;
            }
        }
        aCityMarker = 0;
        displayCity = null;
        return null;
    }

    @Override // (SHOULD BE WORKING)
    public boolean servesCity(City aCity) {
        return this.Cities.contains(aCity);
    }
    
    @Override // (MAYBE WORKING)
    public LinkedList<City> getPath(City originCity, City destinationCity) {
	
        
        Stack<City> stack = new Stack<>();
        LinkedList<City> path = new LinkedList<>();
        City topCity, nextCity = null, tempCity;
        
        this.unVisitAll(); 
        stack.push(originCity); //pushes the first city into the stack
        this.markVisited(originCity);
        
        topCity = stack.peek(); //saves the top city
        while (!stack.isEmpty() && !(topCity.equals(destinationCity))) { //while the stack is not empty and the topcity is not equal to the destination city
            nextCity = this.getNextCity(topCity);
            
            if (this.getNextCity(topCity) == null) {
                stack.pop();
            }
            else { 
                stack.push(nextCity);
                this.markVisited(nextCity);
            }
            topCity = stack.peek();
        }
        
        if (stack.isEmpty()) {
            return null;
        }
        else {
            while(!stack.isEmpty()) {
                tempCity = stack.pop();
                path.push(tempCity);
            }
            return path;
        }
    }
}
