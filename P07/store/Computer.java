//Written by Jesse McNary 1001942779
package store;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Computer{
    
    private String name;
    private String model;
    private ArrayList<Option> options = new ArrayList<>();

    public Computer(String name, String model){
        
        this.name = name;
        this.model = model;
    }
    public void save(BufferedWriter bw) throws IOException{
        bw.write(name + '\n');
        bw.write(model + '\n');
        System.out.println(options.size());
        bw.write("" + options.size() + '\n');
        for(Option i : options){
            i.save(bw);
        }
    }
    
    public Computer(BufferedReader br) throws IOException{
        name = br.readLine();
        model = br.readLine();
        int size = Integer.parseInt(br.readLine());
        while(size-- > 0){
            options.add(new Option(br));
        }

    }

    public void addOption(Option option){
        options.add(option);

    }
    public long cost(){
        long totalCost = 0;
        for(Option i:options){
            totalCost = totalCost + i.cost; 
        }
        return totalCost;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(""+name + " ("+model+")");

        for(Option i: options){
            sb.append("\n\t"+i);
        }
        String concatString = sb.toString();
        
        return concatString;
    }
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        
        if((o == null) || !(o instanceof Computer)){
            return false;
        }

        Computer a = (Computer) o;
        // if(name.equals(a.name) && model.equals(a.model)){
        if(this.toString().equals(a.toString())){
            return true;
        }else{return false;}
    }




}