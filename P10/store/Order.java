//Written by Jesse McNary 1001942779
package store;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Order{
    private static long nextOrderNumber = 0;
    private long orderNumber;

    private Customer customer;
    private ArrayList<Computer> computers = new ArrayList<>();

    public Order(Customer customer){
        orderNumber = nextOrderNumber++;
        this.customer = customer;
    }
    
    public void addComputer(Computer computer){
        
        computers.add(computer);

    }
    public Order(BufferedWriter bw){
    
    }

    public long cost(){
        long thisCost = 0;
        
        for(Computer c : this.computers){
            thisCost += c.cost();
        }
        
        return thisCost;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nOrder " + orderNumber + " for " + customer + "\n" + "Cost = $" + cost() + "\n");
        
        for(Computer i: computers){
            sb.append(i);
        }

        String concatString = sb.toString();
        return concatString;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        
        if((o == null) || !(o instanceof Order)){
            return false;
        }

        Order a = (Order) o;
        boolean isSame = false;
        // if(name.equals(a.name) && model.equals(a.model)){
        if(this.customer == a.customer){
            isSame = true;
        }else{
            
            return false;
        }
        isSame = (this.computers).equals(a.computers);
        return isSame;

    }








}
