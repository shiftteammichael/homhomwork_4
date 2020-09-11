import java.lang.reflect.Array;
/**
 * The DiningSimulator class contains the main method that will be used to run the simulation
 * @author Michael Hom
 * @id 112536073
 * Recitation 09
 */

import java.util.ArrayList;
import java.util.Scanner;
public class DiningSimulator {
    ArrayList<Restaurant> restaurants=new ArrayList<Restaurant>();
    private int chefs;
    private int duration;
    private double arrivalProb;
    private int maxCustomerSize;
    private int numRestaurants;
    private int customersLost;
    private int totalServiceTime;
    private int customersServed;
    private int profit;
    private int customerNum;
    private double average;

    /**
     * This is a helper method that is used to generate a random number between
     * both the minimum and maximum values
     * @param minVal
     * @param maxVal
     * @return
     */
    private int randInt(int minVal, int maxVal) {
        if (minVal > maxVal) {
            throw new IllegalArgumentException("Invalid Range");
        }
        return (int) (Math.random() * ((maxVal - minVal))) + minVal;

    }

    /**
     * This is a method that returns true if the arrival Probability is less
     * than the random number and false if it is less than
     * @return
     */
    private boolean probability(){
        return (Math.random()<arrivalProb);
    }

    /**
     * This helper method takes the user input and adds the number of Restaurants
     * in the array List
     * @param number
     * @return restaurants
     */
    private ArrayList<Restaurant>restaurantAdd(int number){

        for(int i=1;i<=number;i++){
            restaurants.add(new Restaurant(i));
        }
        return restaurants;
    }

    /**
     * This helper method decrements the customer's total time by 5
     * for every simulation
     * @param Restaurants
     */
    private void minusFive(ArrayList<Restaurant>Restaurants){
        for(int i=0;i<Restaurants.size();i++){
            Restaurants.get(i).minusFive();
                }

    }

    /**
     * This method determines where the customer goes to randomly and
     * sets the food,price, and total time to serve
     * @param counter
     */
    private void enqueue(int counter) {
        int customertoServe = 0;
        while (customertoServe < 3) {
            if (this.probability() == true) {
                for (int i = 0; i < restaurants.size(); i++) {
                    int restNum = this.randInt(1, restaurants.size() + 1);
                    if (restNum == restaurants.get(i).getNum()) {
                        customerNum++;
                        System.out.println("Customer " + customerNum + " has entered Restaurant " + restNum);
                        if (restaurants.get(i).size() == maxCustomerSize) {
                            System.out.println("Customer #"+restaurants.get(i).getTheCurrentCustomer().getOrderNumber()+" cannot be seated! They have left the restaurant!");
                            customersLost++;
                            customertoServe++;
                        } else {
                            int randomVal = randInt(1, 6);
                            String food="";
                            String food1="";
                            int price=0;
                            int time=0;
                            if(randomVal==1){
                                food="CB";
                                price=15;
                                time=25;
                            }
                            if(randomVal==2){
                                food="S";
                                price=25;
                                time=25;
                            }
                            if(randomVal==3){
                                food="GC";
                                price=10;
                                time=15;
                            }
                            if(randomVal==4){
                                food="CT";
                                price=10;
                                time=25;
                            }
                            if(randomVal==5){
                                food="CW";
                                price=20;
                                time=30;
                            }
                            if(chefs>3){
                                time-= (5*(chefs-3));
                            }
                            else if(chefs>=1 && chefs<3){
                                time+=(5*(chefs-3));
                            }
                            if(food.equalsIgnoreCase("cb")){
                                food1="Cheese Burger";
                            }
                            if(food.equalsIgnoreCase("ct")){
                                food1="Chicken Tenders";
                            }
                            if(food.equalsIgnoreCase("cw")){
                                food1="Chicken Wings";
                            }
                            if(food.equalsIgnoreCase("gc")){
                                food1="Grilled Cheese";
                            }
                            if(food.equalsIgnoreCase("s")){
                                food1="Steak";
                            }
                            Customer c=new Customer();
                            System.out.println("Customer #"+ customerNum+" has been seated with the order "+ food1);
                            c.setFood(food);
                            c.setPriceOfFood(price);
                            c.setTimeToServe(time+15);
                            restaurants.get(i).enqueue(c);
                            c.setOrderNumber(customerNum);
                            totalServiceTime += restaurants.get(i).getTheCurrentCustomer().getTimeToServe();
                            customersServed++;
                            customertoServe++;
                        }
                    }
                }
            }
            else{
                    customertoServe++;
                }
            }
        }

    /**
     * This method checks to see if the total time of the customer is 0
     * and dequeue it from the Restaurant
     * @throws Exception
     */
    private void dequeue() throws Exception{
        int i=0,j=0;
        while(i<restaurants.size()){
            while(j<restaurants.get(i).size()){
                if(restaurants.get(i).peek().getTimeToServe()==0){
                    Customer bruh=restaurants.get(i).dequeue();
                    System.out.println(bruh.getOrderNumber());
                    System.out.println("Customer #"+bruh.getOrderNumber()+" has enjoyed their food! $"+bruh.getPriceOfFood()+ " profit");
                    profit+=bruh.getPriceOfFood();
            }
                j++;
        }
            i++;
        }
    }

    /**
     * This method returns a string representation of the dining simulator
     */
    private void toStrings(){
        for(int i=0; i<restaurants.size();i++){
            System.out.println("R"+restaurants.get(i).getNum()+":"+restaurants.get(i).toString());
        }
    }

    /**
     * This method runs the simulator and calculates the average time the customer spent
     * @param in
     * @return average
     * @throws Exception
     */
    public double simulate(Scanner in) throws Exception {

        System.out.println("Enter the number of restaurants: ");
        int rest = in.nextInt();
        restaurants = restaurantAdd(rest);
        System.out.println("Enter the maximum number of customers a restaurant can serve: ");
        maxCustomerSize = in.nextInt();
        System.out.println("Enter the arrival probability of a customer: ");
        arrivalProb = in.nextDouble();
        System.out.println("Enter the number of chefs:");
        chefs = in.nextInt();
        System.out.println("Enter the number of simulation units: ");
        duration = in.nextInt();
        int counter = 1;
        for (int i = 1; i <= duration; i++) {
            {
                this.enqueue(counter);
                if (counter > 1) {
                    this.dequeue();
                    System.out.println("Time: " + counter);
                    this.minusFive(restaurants);
                }
                this.toStrings();
                counter++;
            }
        }
            average = (double) totalServiceTime / (double) customersServed;

            System.out.println("Total customer time:" + totalServiceTime + " minutes");
            System.out.println("Total customers served: " + customersServed);
            System.out.println(average);
            System.out.println("Average customer time lapse: " + average + " minutes per order");
            System.out.println("Total Profit: $" + profit);
            System.out.println("Customers that left: " + customersLost);
            return average;
        }

    /**
     * This is the main method which prompts the user for the input required to start the simulation
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        while (true) {

                DiningSimulator yer = new DiningSimulator();
                yer.simulate(in);
                System.out.println("Do you want to try another simulation? (y/n): ");
                in.nextLine();
                String answer = in.nextLine();
                if (answer.equalsIgnoreCase("N")) {
                    System.exit(0);
                    System.out.println("Program terminating normally");

                }
            }

        }
    }




