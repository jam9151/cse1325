//Written by Jesse McNary 1001942779
public class Taxed extends Product{
    
    private static double tax = 0.1;

    public Taxed(String name, double cost){
        super(name, cost);
    }

    public static void setTaxRate(double salesTax){
        tax = salesTax;
    }

    @Override
    public double price(){
        return this.cost + (this.cost * tax);
    }




}
