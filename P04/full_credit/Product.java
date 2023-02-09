//Written by Jesse McNary 1001942779


public abstract class Product{
    
    
    protected double cost;
    protected String name;

    public Product(String name, double cost){
        
        if(cost > 0){
        this.name = name;
        this.cost = cost;
        }
        else{
            throw new RuntimeException("Error: Cost must be a positive number." + cost);
            //System.exit(-1);
        }
        
    }

    public abstract double price();

    @Override
    public String toString(){
        return(""+ name + "  ($"+cost+")");

    }








}
