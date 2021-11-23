/**
 *
 * @author Mason Garrett
 */
package extraCreditAssg_garrettm19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class DeterminePaths {

    final static String cityFileName = "cityFile.txt";
    final static String flightFileName = "flightFile.txt";
    final static String requestFileName = "requestFile.txt";
    private static LinkedList<City> begin = new LinkedList<>();
    private static LinkedList<City> end = new LinkedList<>();
    
    public static void loadRequestFile(String requestFileName) throws FileNotFoundException {
        Scanner inputStreamRequest = null;
        
        try {
            inputStreamRequest = new Scanner(new File(requestFileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("Error reading the request file.");
            System.exit(1);
        }
        while (inputStreamRequest.hasNextLine()) {
            City start = new City(inputStreamRequest.next());
            City destination = new City(inputStreamRequest.next());
            begin.add(start);
            end.add(destination);
        }
        inputStreamRequest.close();
    }
    
    public static void main(String[] args) throws FileNotFoundException {

        FlightMap test = new FlightMap();
        test.loadFlightMap(cityFileName, flightFileName);
        loadRequestFile(requestFileName);
        int beginTotal, endTotal;
        City start, destination, print;
        LinkedList<City> solution;
        
        beginTotal = begin.size();
        endTotal = end.size();
        
        for (int i = 0; i < endTotal; i++) {
            start = begin.get(i);
            destination = end.get(i);
            if (!test.servesCity(start)) {
                if (!test.servesCity(destination)) {
                    System.out.println("The airline does not serve " + start + " and " + destination + ".");
                }
                else {
                    System.out.println("The airline does not serve " + start + ".");
                }
            } 
            else if (!test.servesCity(destination)) {
                System.out.println("The airline does not serve " + destination + ".");
            } 
            else {
                solution = test.getPath(start, destination);
                if (solution == null) {
                    System.out.println("No sequence of flights exist between cities " + start + " and " + destination + ".");
                }
                else {
                    System.out.println("The following sequence of flights exist between cities " + start + " and " + destination + ":");
                    for (int z = 0; z < solution.size(); z++) {
                        print = solution.get(z);
                        System.out.print(print);
                        if (1 != solution.size() - z)
                        System.out.print(" to ");
                    }
                    System.out.println("");
                }
            }
        }
    }
}
