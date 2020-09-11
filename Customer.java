/**
 * The customer Class represents a customer that will dine at the Restaurant
 * @author Michael Hom
 * @id: 112536073
 * Recitation 09
 */
public class Customer implements Comparable<Customer> {
    static int totalCustomers;
    int orderNumber;
    String food;
    int priceOfFood;
    int timeArrived;
    int timeToServe;
    int totalTime;

    /**
     *This is a getter method that gets the total time of the customer
     * @return totalTime
     */
    public int getTotalTime() {
        totalTime = timeArrived * 5 + timeToServe;
        return totalTime;
    }

    /**
     * This is a setter method that sets the total time of the customer
     * @param totalTime
     */
    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    /**
     * This is a getter method that gets the arrivalTime of the customer
     * @return timeArrived
     */
    public int getTimeArrived() {
        return timeArrived;
    }

    /**
     * This is a setter method that sets the arrivalTime of the customer
     * @param timeArrived
     */
    public void setTimeArrived(int timeArrived) {
        this.timeArrived = timeArrived;
    }

    /**
     * This is a getter method that sets the timeToServe of a the customer
     * @return timeToServe
     */
    public int getTimeToServe() {
        return timeToServe;
    }

    /**
     * This is a setter method that sets the time to serve of the customer
     * @param timeToServe
     */
    public void setTimeToServe(int timeToServe) {
        this.timeToServe = timeToServe;
    }

    /**
     * This is a getter method that gets the food of the customer
     * @return food
     */
    public String getFood() {
        return food;
    }

    /**
     * This is a setter method that sets the food of the customer
     * @param food
     */
    public void setFood(String food) {
        this.food = food;
    }

    /**
     * This is a getter method that gets the price of the food for the customer
     * @return priceOfFood
     */
    public int getPriceOfFood() {
        return priceOfFood;
    }

    /**
     * This is a setter method that sets the price of the food for the customer
     * @param priceOfFood
     */
    public void setPriceOfFood(int priceOfFood) {
        this.priceOfFood = priceOfFood;
    }

    /**
     * This is a getter method that gets the order number of the customer
     * @return orderNumber
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * This is a setter method that sets the order number of the customer
     * @param orderNumber
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * This is a getter method that gets the total customers
     * @return totalCustomers
     */
    public static int getTotalCustomers() {
        return totalCustomers;
    }

    /**
     * This is a setter method that sets the total customers of the restaurant
     * @param totalCustomers
     */
    public static void setTotalCustomers(int totalCustomers) {
        Customer.totalCustomers = totalCustomers;
    }

    /**
     * This is the default constructor that creates a Customer object
     */
    public Customer() {

    }

    /**
     * This method returns a string representation of each customer
     * @return
     */
    public String toString() {
        return "[#" + orderNumber + ", " + food + ", " + timeToServe + "]";
    }

    /**
     * This method is overriding the Comparable interface's compareTo method to sort the customers
     * by the total time
     * @param o
     * @return
     */
    @Override
    public int compareTo(Customer o) {
        int total1 = 0;
        int total2 = 0;
        total1 = this.getTimeArrived() + this.getTimeToServe();
        total2 = o.getTimeArrived() + o.getTimeToServe();

        return Integer.compare(total1, total2);
    }
}

