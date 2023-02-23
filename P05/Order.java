//Written by Jesse McNary 1001942779
import java.util.ArrayList;

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
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order" + orderNumber + "for" + customer + "\n");
        
        for(Computer i: computers){
            sb.append(i);
        }

        String concatString = sb.toString();
        return concatString;
    }
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        
        if((o == null) || !(o instanceof Order)){
            return false;
        }

        Order a = (Order) o;
        // if(name.equals(a.name) && model.equals(a.model)){
        
        
        boolean isSame = true;
        int size = a.computer.size();
        
        for(i = 0; i < size; i++){
            if (!(computers.get(i) ==a.computers.get(i))){
                isSame = false;
            }
        }
        if(!(this.customer == a.customer && isSame)){
           isSame = false; 
        }
        return isSame;

    }








}
