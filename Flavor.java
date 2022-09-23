public class Flavor{

    private double costPerScoop;
    private double wholesaleCostPerScoop;
    private int amountOfScoops;
    private int amountOfStartingScoops;
    private String name;
    

    public Flavor(String name, double costPerScoop, double wholesaleCostPerScoop){
        this.amountOfStartingScoops = 30;
        this.costPerScoop = costPerScoop;
        this.wholesaleCostPerScoop = wholesaleCostPerScoop;
        this.amountOfScoops= this.amountOfStartingScoops;
        this.name = name;
    }

    // getters

    public double getCostPerScoop(){
    
        return this.costPerScoop;
    }

    public double getWholesaleCost(){
        return this.wholesaleCostPerScoop;
    }

    public int getAmountOfStartingScoops(){
        return this.amountOfStartingScoops;
    }

    public int getAmountOfScoops(){
        return this.amountOfScoops;
    }

    public String getName(){
        return this.name;
    }

    // setters

    public void setCostPerScoop(double newCost){
        this.costPerScoop = newCost;
    }

    public void setWholesaleCost(double newCost){
        this.wholesaleCostPerScoop = newCost;
    }

    public void setAmountOfScoops(int amount){
        this.amountOfScoops = amount;
    }

    public void setAmountOfStartingScoops(int amount){
        this.amountOfStartingScoops = amount;
    }

    public void buyIceCream(){
        this.amountOfScoops--;


    }
}