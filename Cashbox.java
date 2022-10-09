import java.util.*;
public class Cashbox{
    private double startingCash;
    private double totalIceCreamBought;
    private double dollarAmountOfIceCreamSold;
    private double expectedSalesFromMissingInventory;
    private double cashInTruck;
    private double profit;

    // scanner Object to get user inputs
    Scanner input = new Scanner(System.in);

    public Cashbox(){
        this.startingCash = 0;
        this.totalIceCreamBought = 0;
        this.dollarAmountOfIceCreamSold = 0;
        this.expectedSalesFromMissingInventory = 0;

        this.profit= 0;
    }

    // getters
    public void getCash(){
        System.out.println("Welcome to your Ice Cream Truck!");
        System.out.println("How much money would you like to give your truck to start?");
        double cash= input.nextDouble();


        while (cash <= 100){
            System.out.println("You cannot start an ice cream truck without sufficient funds. You must start with at lest $101. Try Again!");
            cash = input.nextDouble();

        }

        System.out.println("Cash accepted.");

        setStartingCash(cash);
        setCashInTruck(cash);



    }

    public double getStartCash(){
        return this.startingCash;
    }

    public double getTotalIceCreamBought(){
        return totalIceCreamBought;
    }

    public double getDollarAmountOfIceCreamSold(){
        return dollarAmountOfIceCreamSold;
    }

    public double getExpectedSalesFromMissingInventory(){
        return expectedSalesFromMissingInventory;
    }

    public double getCashInTruck(){
      return this.cashInTruck;
    }


    public double getProfit(){
        return profit;
    }
    // setters


    public void setTotalIceCreamBought( double newTotal){

        this.totalIceCreamBought= newTotal;
    }

    public void setDollarAmountOfIceCreamSold( double newDollarAmount){
        this.dollarAmountOfIceCreamSold = newDollarAmount;
    }

    public void setExpectedSalesFromMissingInventory(double newExpectedSales){
        this.expectedSalesFromMissingInventory = newExpectedSales;
    }

    public void setCashInTruck(double newCash){
        this.cashInTruck = newCash;
    }
    public void setProfit(double newProfit){
        this.profit = newProfit;
    }

    public void setStartingCash( double newAmount){
        this.startingCash = newAmount;
    }

}
