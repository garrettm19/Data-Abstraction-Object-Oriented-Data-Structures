/**
 *
 * @author Mason Garrett
 */
package assg7_garrettm19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EventList {
    private int currentTime = 1;
    private int eventCounter = 0;
    private double waitTotal = 0;
    private double waitAvg = 0;
    
    private LinkedList<Event> eventList;
    private Queue<Event> bankQueue;
    
    public EventList() {
        this.eventList = new LinkedList<Event>();
        this.bankQueue = new LinkedList<Event>();
    }
    
    /*
     * Reads the input file and starts the loop to begin the simulation. Also outputs the final statistics for the input file.
     */
    public void simulateEvents(String input) {
        Scanner inputStream = null;
        Event tempEvent, temp = null;
        
        try {
            inputStream = new Scanner(new File(input));
        }
        catch(FileNotFoundException e) {
            System.out.println("Error openning the file " + input);
            System.exit(1);
        }
        
        temp = new Event('A', inputStream.nextInt(), inputStream.nextInt());
        inputStream.nextLine();
        this.eventList.add(temp);
        
        System.out.println("Simulation Begins");
        while(!this.eventList.isEmpty()) {
            tempEvent = this.eventList.element();
            
            if(tempEvent.getEventType() == 'A') {
                this.processArrival(tempEvent, inputStream);
            }
            else {
                this.processDeparture(tempEvent);
            }
        }
        
        waitAvg = waitTotal / eventCounter;

        System.out.println("Final Statistics:                       ");
        System.out.println("");
        System.out.println("Total number of people processed:       " + eventCounter);
        System.out.println("Average amount of time spent waiting:   " + waitAvg);
        
        inputStream.close();
    } 
    
    /*
     * Processes the arrival events and outputs the time of the arrival.
     */
    private void processArrival(Event tempEvent, Scanner inputStream) {
        boolean atFront = this.bankQueue.isEmpty();
        Event nextEvent = null;
        
        System.out.println("Processing an Arrival Event at time:    " + tempEvent.getEventTime());
        
        this.eventList.remove(tempEvent);
        this.bankQueue.add(tempEvent);
        
        if(atFront) {
            this.eventList.add(new Event('D', tempEvent.getEventTime() + tempEvent.getChangeTime()));
        }
        
        if(inputStream.hasNextLine()) {
            nextEvent = new Event('A', inputStream.nextInt(), inputStream.nextInt());
            if(nextEvent.compareTo(nextEvent) == 1) {
                if(nextEvent.compareTo(eventList.element()) <= 0) {
                    this.eventList.addFirst(nextEvent);
                }
                else {
                    this.eventList.addLast(nextEvent);
                }
            }
        }
        currentTime = tempEvent.getEventTime();
    }
    
    /*
     * Processes the departure events and outputs the time of the departure. (not working)
     */
    private void processDeparture(Event tempEvent) {
        Event departure = null;
        
        System.out.println("Processing a Departure Event at time:   " + tempEvent.getEventTime());
        eventCounter++;
        
        this.bankQueue.poll();
        this.eventList.remove(tempEvent);
        
        if(!bankQueue.isEmpty()) {
            waitTotal += (tempEvent.getEventTime() - this.bankQueue.element().getEventTime());
            departure = new Event('D', tempEvent.getEventTime() + this.bankQueue.element().getChangeTime());
            if(!eventList.isEmpty()) {
                if(departure.getEventTime() < (currentTime)) {
                    this.eventList.addFirst(departure);
                }
                else {
                    this.eventList.addLast(departure);  
                }
            }
        }
        currentTime = tempEvent.getEventTime();
    }
    
    /*
     * Inserts a new event into the front of the event list.
     */
    private void insert(Event newEvent) {
        this.eventList.add(newEvent);
    }
    
    /*
     * Removes the first element in the event list.
     */
    private void remove() {
        this.eventList.poll();
    }
    
    /*
     * Retrieves the front element in the event list.
     */
    private void retrieve() {
        this.eventList.element();
    }
}