import javax.management.ConstructorParameters;

public class Employee{

    // employee permissions
    private boolean canAccessRegister;
    private boolean canDriveTruck;
    private String name;

    // employee status
    String status;
   

    // constructor
    public Employee (String name, boolean canAccessRegister, boolean canDriveTruck) {
        status = ("hired");
        this.name = name;
        this.canAccessRegister = canAccessRegister;
        this.canDriveTruck = canDriveTruck;
    }
    
    // getters
    public String getStatus(){
        return this.status;
    }
    
    public boolean getCanAccessRegister(){
        return this.canAccessRegister;
    }

    public boolean getCanDriveTruck(){
        return this.canDriveTruck;
    }

    public String getName(){
        return this.name;
    }


    // setters

    public void setName(String newName){
           
        this.name = newName;
        
    }
    public void setStatus(String newStatus){
        this.status = newStatus;
        System.out.println("You are " + this.status);
    }

    public void setRegisterPermission(boolean bool){
        
        this.canAccessRegister = bool;
        
    }

    public void setDrivingPermission(boolean bool){
        this.canDriveTruck = bool;
    }

    

   

}