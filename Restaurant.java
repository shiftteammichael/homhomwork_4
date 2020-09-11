/**
 * The Restaurant class functions as a queue and uses an ArrayList of Customer objects and seat them
 * @author Michael Hom
 * @id 112536073
 * Recitation 09
 */

import java.util.ArrayList;
import java.util.Collections;

public class Restaurant {
    int size=0;;
    ArrayList<Customer> yo;
    int num;

    /**
     * This is the constructor that creates a new Array List
     */
    public Restaurant(){
      yo =new ArrayList<Customer>();
    }

    /**
     * This getter method gets the number of customers in the restaurant
     * @return num
     */
    public int getNum() {
        return num;
    }

    /**
     * This setter method sets the number of customers in the restaurant
     * @param num
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * This is a constructor to create how many restaurants will be created by the user
     * @param num
     */
    public Restaurant(int num){
        yo =new ArrayList<Customer>();
        this.num=num;
    }

    /**
     * This method adds a new customer to the restaurant and sorts it using the comparable interface
     * @param c
     */
    public void enqueue(Customer c){
        if(size==0){
            size++;
            yo.add(c);
        }
        else {
            size++;
            yo.add(c);
            Collections.sort(yo);
        }
    }

    /**
     * This is a helper method that decrements the total time by 5 for
     * each customer every simulation
     */
    public void minusFive(){
            for(int j=0; j<yo.size();j++) {
                if (yo.get(j).getTimeToServe() > 0) {
                    int time=yo.get(j).getTimeToServe();
                   yo.get(j).setTimeToServe(time-5);
                }
        }
    }

    /**
     * This is a getter method that gets the current customer in the restaurant
     * @return
     */
    public Customer getTheCurrentCustomer(){
        return yo.get(yo.size()-1);
    }

    /**
     * This method returns but does not remove the first customer in the restaurant
     * @return
     */
    public Customer peek(){
        return (Customer) yo.get(0);
    }

    /**
     * This method removes and returns the first customer in the restaurant
     * @return
     * @throws Exception
     */
    public Customer dequeue() throws Exception {
        if(this.isEmpty()){
            throw new Exception("The Restaurant is empty! You can't dequeue!");
        }

            size--;
            return (Customer) yo.remove(0);

    }

    /**
     * This is a method that returns the number of customers in the restaurant
     * @return size
     */
    public int size(){
        return size;
    }

    /**
     * This method checks to see if the restaurant is empty
     * @return
     */
    public boolean isEmpty(){
        if(yo.size()==0){
            return true;
        }
        return false;
    }

    /**
     * This method returns a string representation of the Restaurant object
     * @return
     */
    public String toString(){

        String totalCustomers="";
        for(int i=0;i<size;i++){
            totalCustomers+=yo.get(i).toString()+",";
        }
        return "{ "+totalCustomers+" }";
    }
}
