/**
 *
 * @author Mason Garrett
 */
package assg7_garrettm19;

import java.util.*;
import java.io.*;

public class Simulation {
    
    static String filename = "input.txt";
    
    public static void main(String[] args) {
        EventList eventlist = new EventList();
        eventlist.simulateEvents(filename);
        
    }

}
