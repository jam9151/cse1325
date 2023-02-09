//Written by Jesse McNary 1001942779
import java.util.ArrayList;
import java.util.Scanner;


public class Store{
    public static void main(String[] args){
        ArrayList<Product> products = new ArrayList<Product>();
        ArrayList<Product> shoppingCart = new ArrayList<Product>();
    
        //Taxfree items
        Taxfree milk = new Taxfree("Milk", 5.50);
        Taxfree cheese = new Taxfree("Cheese", 3.25);
        Taxfree almonds = new Taxfree("Almond", 1.25);
        Taxfree bread = new Taxfree("Bread", 2.99);

        products.add(milk);
        products.add(cheese);
        products.add(almonds);
        products.add(bread);
        // System.out.println(products);


        //Taxed Items
        Taxed mnm = new Taxed("M&Ms", 4.25);
        Taxed cookies = new Taxed("Cookies", 6.75);
        Taxed iceCream = new Taxed("Ice Cream", 6.20);
        Taxed lollipop = new Taxed("Lollipop", 1.99);

        products.add(mnm);
        products.add(cookies);
        products.add(iceCream);
        products.add(lollipop);

        System.out.println(products);


        Scanner userChoice = new Scanner(System.in);
        boolean isTrue = false;
        //Shopping cart
        while(isTrue == false){
            double totalPrice = 0.0;
            System.out.println("\n========================\n  Welcome to the Store\n========================");
            
            for(int i = 0; i < products.size(); i++){
        
                System.out.println(i+") "+products.get(i)+" \t\t\t\t$ " + products.get(i).price());
                
            }
            System.out.println("\nCurrent Order\n-------------");
            
            if(shoppingCart.size() != 0){
                for(int j = 0; j < shoppingCart.size(); j++){
                    System.out.println(shoppingCart.get(j)+"  \t\t\t\t$ " + shoppingCart.get(j).price());
                    for(int k = 0; k < shoppingCart.size(); k++){
                        totalPrice = totalPrice + shoppingCart.get(k).price();

                    }

                }
                System.out.println("Total Price: $" + totalPrice);
            }else{
                System.out.println("\nThere is nothing in your cart.");

            }
            System.out.println("Buy which product?");
            int choice = userChoice.nextInt();
                
            if(choice < 0 || choice > (products.size()-1) ){
                throw new IllegalArgumentException("Choice must be in the bounds of 0 to "+ products.size());
            }
            
            try{
               shoppingCart.add(products.get(choice)); 
            }catch(Exception e){
                System.err.println(e.getMessage());
                System.exit(-1);
            }
        
            // shoppingCart.add(products.get(choice));           
        }

    }

}
