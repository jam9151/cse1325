//Written by Jesse McNary 1001942779

public class Taxfree extends Product{
    public Taxfree(String name, double cost){
        super(name, cost);
        

    }
    @Override
    public double price(){
        return this.cost;
    }

}
