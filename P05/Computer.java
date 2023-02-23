//Written by Jesse McNary 1001942779
import java.util.ArrayList;

public class Computer{
    
    private String name;
    private String model;
    private ArrayList<Option> options = new ArrayList<>();

    public Computer(String name, String model){
        
        this.name = name;
        this.model = model;
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
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(""+name);

        for(Option i: options){
            sb.append("\n\t"+i);
        }
        String concatString = sb.toString();
        return concatString;
    }
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