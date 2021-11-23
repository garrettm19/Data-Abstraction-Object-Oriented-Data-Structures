/**
 *
 * @author Mason Garrett
 */
package extraCreditAssg_garrettm19;

public class City {
    
    String cityName;
    boolean mark;
    
    /** (WORKING)
     * Initializes a City with cityName and marks the
     * City as unvisited.
     * @param cityName The name of the city to create
     */
    public City(String cityName) {
        this.cityName = cityName;
        this.mark = false;
    }	
	
    /** (WORKING)
     * Gets the name of the City
     * @return The city name
     */
    public String getName() {
	return this.cityName;
    }
	
    /** (WORKING)
     * Determines if a City has been visited
     * @return True if the city has been visited
     *         and false otherwise
     */
    public boolean isVisited() {
        return this.mark == true;
    }
	
    /** (WORKING)
     * Marks the City as having been visited
     */
    public void visit() {
        this.mark = true;
    }
	

    /** (WORKING)
     * Clears the visited mark so the city will
     * be marked as unvisited.
     */
    public void clear() {
        this.mark = false;
    }

    /** (WORKING)
     * Overridden equals method determines if the
     * current City name is equal to obj
     * @param obj The object to be compared to this City
     * @return True if this city name matches the city name
     *         in obj, and false otherwise
     */
    @Override
    public boolean equals(Object obj) {
	City compare = (City)obj;
        return (this.cityName == null ? compare.cityName == null : this.cityName.equals(compare.cityName));
    }
	

    /** (WORKING)
     * Overrridden toString method
     * @return The name of the city
     */
    @Override
    public String toString() {
        String thisString = this.cityName;
    	return thisString;
    }
}    

