/**
 *
 * @author Mason Garrett
 */
package assg7_garrettm19;

public class Event {
    
    private char eventType;
    private int eventTime;
    private int changeTime;
    
    
    public Event() {
    this.eventType = ' ';
    this.eventTime = 0;
    this.changeTime = 0;
    }
    /*
     * Parameterized constructor that assigns the arrival time and type.
     *
     * @param eventTime The time of the current event.
     * @param changeTime The time of the changing of the events.
     */
    public Event(char eventType, int eventTime) {
    this.eventType = eventType;
    this.eventTime = eventTime;
    }
    
    /*
     * Parameterized constructor that assigns the departure time and type.
     *
     * @param eventTime The time of the current event.
     */
    public Event(char eventType, int eventTime, int changeTime) {
        this.eventType = 'A';
        this.eventTime = eventTime;
        this.changeTime = changeTime;
    }
    
    /*
     * Gets the type of the current event.
     *
     * @return eventType The variable for the type of event.
     */
    public char getEventType() {
        return this.eventType;
    }
    
    /*
     * Gets the event time of the current event.
     *
     * @return eventTime The variable for the event time.
     */
    public int getEventTime() {
        return this.eventTime;
    }
    
    /*
     * Gets the change time of the current event.
     *
     * @return changeTime The variable for the change time of the event.
     */
    public int getChangeTime() {
        return this.changeTime;
    }
    
    /*
     * Compares the current object to the user input object's event type.
     *
     * @param userInput This is an object of the user requested event to compare.
     * @return 1 Returned number if the events are equal.
     * @return -1 Returned number if the first event is smaller.
     * @return 0 Default return statement
     */
    public int compareTo(Event userInput) {
        if (this.getEventTime() == userInput.getEventTime()) {
            return 1;
        }
        else if (this.getEventTime() < userInput.getEventTime()) {
            return -1;
        }
        else {
            return 0;       
        }
    }
}
