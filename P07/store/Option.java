//Written by Jesse McNary 1001942779
package store;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Option{
    protected String name;
    protected long cost;

    public Option(String name, long cost){
        
        this.name = name;

        if(cost < 0){
            throw new IllegalArgumentException("The Cost must be a positive number or 0");
        }
        this.cost = cost;
    }
    
    public void save(BufferedWriter bw) throws IOException{
        bw.write(name + '\n');
        bw.write("" + cost + '\n');
    }

    public Option(BufferedReader br) throws IOException{
        name = br.readLine();
        cost = Long.parseLong(br.readLine());

    }

    public long cost(){
        return (cost / 100);
    }
    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" ($"+cost+")");
        
        String s = sb.toString();
        return s;
    }
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        
        if((o == null) || !(o instanceof Option)){
            return false;
        }

        Option a = (Option) o;
        if(name.equals(a.name) && cost == a.cost){
            return true;
        }else{return false;}
        // return email.equals(c.email);

    }
}
