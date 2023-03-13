package store;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Store {
    public Store(String name) {
        this.name = name;
    }
    public String name() {
        return this.name;
    }
    public void save(BufferedWriter bw) throws IOException{
        bw.write(name + '\n');
        if(customers.size()!=0){
            bw.write("" + customers.size() + '\n');
            for(Customer i : customers){
                i.save(bw);
            }
        }
        if(options.size() != 0){
            bw.write("" + options.size() + '\n');
            for(Option j : options){
                j.save(bw);
            }
        }
        if(computers.size() != 0){
            bw.write("" +computers.size() + '\n');
            for(Computer k : computers){
                k.save(bw);
            }
        }
    }    
    
    public Store(BufferedReader br) throws IOException{
        name = br.readLine();
        
        int size = Integer.parseInt(br.readLine());
        while(size-- > 0) customers.add(new Customer(br));

        int sizeTwo = Integer.parseInt(br.readLine());
        while(sizeTwo-- > 0) options.add(new Option(br));

        int sizeThree = Integer.parseInt(br.readLine());
        while(sizeThree-- > 0) computers.add(new Computer(br));

    }
    
    // ///////////////////////////////////////////////////////////
    // Customers
    
    public void add(Customer customer) {
        if(!customers.contains(customer)) customers.add(customer);
    }
    public Object[] customers() {
        return this.customers.toArray();
    }
    
    
    // ///////////////////////////////////////////////////////////
    //Options
    
    public void add(Option option) {
        if(!options.contains(option)) options.add(option);
    }
    public Object[] options() {
        return this.options.toArray();
    }
    
    // // ///////////////////////////////////////////////////////////
    // // Computers
    
    public void add(Computer computer) {
        if(!computers.contains(computer)) computers.add(computer);
    }
    public Object[] computers() {
        return this.computers.toArray();
    }
    
    // // ///////////////////////////////////////////////////////////
    // // Orders
    
    public void add(Order order){
        if(!orders.contains(order)) orders.add(order);
    }
    public Object[] orders() {
        return this.orders.toArray();
    }
    

    // // ///////////////////////////////////////////////////////////
    // // Fields
    
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Option> options = new ArrayList<>();
    private ArrayList<Computer> computers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
}
