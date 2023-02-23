
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
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append("("+email+")");
        String s = sb.toString();
        return s;
    }
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        
        if((o == null) || !(o instanceof Customer)){
            return false;
        }

        Customer c = (Customer) o;
        return email.equals(c.email);

    }
}
