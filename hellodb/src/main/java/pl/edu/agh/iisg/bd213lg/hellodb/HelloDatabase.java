package pl.edu.agh.iisg.bd213lg.hellodb;

public class HelloDatabase {

    private String name;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    
    public void sayHello() {
    	System.out.println("Hello, " + name);
    }
    
}