
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

    public String toString(){
        return (name + "(" + email + ")");
    }

    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        else{
            return false;
        }
    }



}