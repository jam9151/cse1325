//Written by Jesse McNary 1001942779
package store;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Customer{
    
    
    private String name;
    private String email;

    public Customer(String name, String email){
        this.name = name;
        if((email.contains(".") && email.contains("@")) == false){
            throw new IllegalArgumentException("Customer Email Invalid");
        }
        this.email = email; 
    }
    
    
    public void save(BufferedWriter bw) throws IOException{
        bw.write(name + '\n');
        bw.write(email + '\n');
    }

    public Customer(BufferedReader br) throws IOException{
        name = br.readLine();
        email = br.readLine();
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" ("+email+")");
        String s = sb.toString();
        return s;
    }
     @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        
        if (this.getClass() != o.getClass()){
            return false;
        }

        if((o == null) || !(o instanceof Customer)){
            return false;
        }

        Customer c = (Customer) o;
        return email.equals(c.email);

    }
}
