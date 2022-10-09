import java.util.*;

public class IceCreamTruck {

    private static ArrayList<Employee> employees = new ArrayList<Employee>();

    public static ArrayList<Flavor> flavors = new ArrayList<Flavor>();

    // array
    public static Employee truckDriver[] = new Employee[1];

    public static Employee cashier[] = new Employee[1];

    // scanner initialized

    private static Scanner userInput = new Scanner(System.in);

    private static Cashbox cashbox = new Cashbox();

    private static double expectedSales = 0;






    public static void checkCashBox(){
        // totalIceCreamBought wholesaleprice
        double totalIceCreamBought = 0;
        double amountOfIceCreamSold = 0;

        for (Flavor flav : flavors){
            totalIceCreamBought += flav.getAmountOfStartingScoops() * flav.getWholesaleCost();
            amountOfIceCreamSold += (flav.getAmountOfStartingScoops() - flav.getAmountOfScoops()) * flav.getCostPerScoop();
        }
        double profit = amountOfIceCreamSold - totalIceCreamBought;
        System.out.println("Here is the Cashbox Receipt.");
        System.out.printf("We started with $ %1.2f worth of ice cream on this ice cream truck. %n", totalIceCreamBought);
        System.out.printf("We sold a total of $ %1.2f worth of Ice cream today. %n", amountOfIceCreamSold);
        System.out.printf("As a result of today's sales, we expect to make $ %1.2f. If this number does not match the previous figure, someone is getting fired!!! %n", expectedSales);
        System.out.printf("we started with $ %1.2f at the beginning of the shift. We now have $ %1.2f, and we have a profit of $ %1.2f. %n", cashbox.getStartCash(), cashbox.getCashInTruck(), profit);

    }
    public static void makeSale() {
        System.out.println("Which flavor does the customer want?");
        int count = 0;
        for (Flavor flav : flavors) {
            System.out.println(count + "." + flav.getName());
            count++;
        }
        int number = userInput.nextInt();

        if (number < flavors.size()) {
            System.out.println("How many scoops do they want");

            int numOfScoopsRequested = userInput.nextInt();

            int amountLeft = flavors.get(number).getAmountOfStartingScoops() - numOfScoopsRequested;

            flavors.get(number).setAmountOfScoops(amountLeft);

            System.out.printf("This is going to cost $ %1.2f ", flavors.get(number).getCostPerScoop() * numOfScoopsRequested);

            expectedSales +=  flavors.get(number).getCostPerScoop() * numOfScoopsRequested;

            cashbox.setCashInTruck(cashbox.getCashInTruck() + flavors.get(number).getCostPerScoop() * numOfScoopsRequested);


            System.out.println("Thank you.");

        }

    }

    public static void addNewFlavor() {
        System.out.println(" So... you would like to add a new ice cream flavor? Please enter the name of the flavor");
        String flavName = userInput.nextLine();
        System.out.println(" How much is the wholesale cost (per scoop)?");
        double wholesale = userInput.nextDouble();
        System.out.println(
                "With this in mind, how much do you want to charge for this flavor (per scoop)? It should be a little higher than the wholesale price because you want to make a profit.");
        double cost = userInput.nextDouble();

        // calls constructor with specified values
        flavors.add(new Flavor(flavName, cost, wholesale));

        System.out.println(flavName + " added");

    }

    public static void startRoute() {
        System.out.println("Select an Employee by inputting a number. Here is a list of employees.");

        Boolean invalid = true;
        int count = 0;
        for (Employee emp : employees) {
            System.out.println(count + "." + emp.getName());
            count++;
        }

        int number = userInput.nextInt();

        do {
            if (employees.get(number).getCanAccessRegister() && employees.get(number).getCanDriveTruck()) {
                // i.setDriver(employees.get(number));
                truckDriver[0] = employees.get(number);
                cashier[0] = employees.get(number);

                System.out.println(cashier[0].getName() + " is both your cashier and driver.");

                invalid = false;

                break;

            }

            else if (employees.get(number).getCanAccessRegister() && !employees.get(number).getCanDriveTruck()) {
                cashier[0] = employees.get(number);
                System.out.println(cashier[0].getName() + " is your cashier.");
                System.out.println(
                        "Even though this employee is able to access the register, they are not able to drive. Choose another employee that is able to drive.");

                boolean driverChosen = false;
                while ((!driverChosen) && truckDriver[0] == null) {
                    System.out.println("Now choose someone who can drive.");
                    count = 0;
                    for (Employee emp : employees) {
                        System.out.println(count + "." + emp.getName());
                        count++;
                    }

                    number = userInput.nextInt();

                    if (employees.get(number).getCanDriveTruck()) {
                        truckDriver[0] = employees.get(number);
                        System.out.println(truckDriver[0].getName() + " is your driver.");

                        driverChosen = true;
                        invalid = false;
                        ;

                    }

                }

                break;

            }

            else if (!employees.get(number).getCanAccessRegister() && employees.get(number).getCanDriveTruck()) {
                truckDriver[0] = employees.get(number);
                System.out.println(truckDriver[0].getName() + " is your driver.");
                System.out.println(
                        "Even though this employee is able to be a drive, they are not able to access the register. Choose another employee that has access to the register.");

                boolean cashierChosen = false;

                while (!cashierChosen && cashier[0] == null) {
                    System.out.println("Now choose someone who can access the register.");
                    count = 0;
                    for (Employee emp : employees) {
                        System.out.println(count + "." + emp.getName());
                        count++;
                    }

                    number = userInput.nextInt();

                    if (employees.get(number).getCanAccessRegister()) {
                        cashier[0] = employees.get(number);
                        System.out.println(cashier[0].getName() + " is your cashier.");

                        cashierChosen = true;
                        invalid = false;
                    }
                }
                break;

            }

            else if (!employees.get(number).getCanAccessRegister() && !employees.get(number).getCanDriveTruck()) {
                System.out.println(
                        "This employee can neither drive nor access the register. Choose another employee.");

                do {
                    System.out.println("Now choose an employee.");
                    count = 0;
                    for (Employee emp : employees) {
                        System.out.println(count + "." + emp.getName());
                        count++;
                    }

                    number = userInput.nextInt();

                    if (employees.get(number).getCanAccessRegister()) {
                        cashier[0] = employees.get(number);
                        System.out.println(cashier[0].getName() + " is your cashier.");
                        if (truckDriver[0] == null) {
                            System.out.println("You still need a driver.");
                        }

                    }

                    if (employees.get(number).getCanDriveTruck()) {
                        truckDriver[0] = employees.get(number);
                        System.out.println(truckDriver[0].getName() + " is your driver.");
                        if (cashier[0] == null) {
                            System.out.println("You still need a cashier.");
                        }

                    }
                } while (truckDriver[0] == null || cashier[0] == null);

                break;

            }

        } while (!invalid);

        System.out.println("Cool. Let's start the ride. This ice cream truck is in route with "
                + truckDriver[0].getName() + " as your driver and " + cashier[0].getName() + " as your cashier.");
        System.out.println("Oh look, we have a customer! ");

    }

    // public static void get Cust

    public static void addNewDriver() {
        System.out.println(" So... you would like to add a new driver? What is the name of the employee?");
        String employeeName = userInput.nextLine();

        System.out.println("Got it! The employee's name is " + employeeName);

        Boolean invalid = false;
        Boolean hasAccessToRegister = false;

        do {
            try {
                System.out.println("True or false: You want this employee to have access to the register?");
                hasAccessToRegister = userInput.nextBoolean();
                if (hasAccessToRegister == true) {
                    System.out.println(employeeName + " now has access to the register.");
                    break;
                } else if (hasAccessToRegister == false) {
                    System.out.println(employeeName + " does not have the permissions to access the register.");
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
                invalid = true;
                userInput.nextLine();
            }

        }

        while (invalid);

        Boolean incorrectInput = false;
        Boolean ableToDrive = false;

        do {
            try {
                System.out.println("True or false: This employee to have permission to drive?");
                ableToDrive = userInput.nextBoolean();
                if (ableToDrive == true) {
                    System.out.println(employeeName + " now has the permissions to drive.");
                    break;
                } else if (ableToDrive == false) {
                    System.out.println(employeeName + " does not have the permissions to drive.");
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
                invalid = true;
                userInput.nextLine();
            }

        }

        while (incorrectInput);
        // calls constructor with specified values
        employees.add(new Employee(employeeName, hasAccessToRegister, ableToDrive));

        System.out.println(employeeName + " is added to the employee list.");
    }

    public static void chooseOption() {

        System.out.println("What do you want to do? Enter a number.You must enter a valid integer. Here are your options:");
        System.out.println("What would you like to do? Please enter a number that corresponds with your choice.");
        System.out.println("1: Add Flavor");
        System.out.println("2: Add a new driver");
        System.out.println("3: Start a route");
        System.out.println("4: Check Cash Box");
        System.out.println("Enter any other number to quit");
        int number = userInput.nextInt();
        userInput.nextLine();

        if (number == 1) {
            addNewFlavor();
            chooseOption();

        }

        else if (number == 2) {
            addNewDriver();
            chooseOption();
        }

        else if (number == 3) {
            startRoute();
            makeSale();



            boolean quit = false;

            System.out.println("Do they want any more ice cream?");

            do {

                String answer = userInput.nextLine();


                if (answer.toLowerCase().equals("yes")) {
                    System.out.print("ok.");
                    makeSale();
                    System.out.println("Do they want any more ice cream?");
                } else if(answer.toLowerCase().equals("no")){
                    System.out.println("Here's your change. Have a good day!");

                    quit = true;
                }

            } while (!quit);

            chooseOption();

        }

        else if (number == 4) {
            checkCashBox();
        } else if (number >= 5) {
            System.out.println("Let's run the final report.");
            System.out.println("Truck Driver: "+ truckDriver[0]);
            System.out.println("Cashier: "+ cashier[0]);
            checkCashBox();


            System.exit(0);

        }

    }

    public static void main(String[] args) {

        // IceCreamTruck i= new IceCreamTruck();
        // starter flavors added
        flavors.add(new Flavor("Chocolate", 1.50, 1.00));
        flavors.add(new Flavor("Vanilla", 1.50, 0.50));
        flavors.add(new Flavor("Strawberry", 1.50, 1.00));

        // employees
        employees.add(new Employee("Stacy", true, true));
        employees.add(new Employee("Joe", false, true));
        employees.add(new Employee("Mabeline", false, false));
        employees.add(new Employee("Billy", true, false));


        cashbox.getCash();
        System.out.println(
                "Here are the flavors that we currently offer: Vanilla, Chocolate, and Strawberry. Would you like to add any additional flavors? Please answer yes or no.");
        String response = userInput.nextLine();
        if (response.toLowerCase().equals("yes")) {
            addNewFlavor();
            chooseOption();
        } else if (response.toLowerCase().equals("no")) {
            chooseOption();
        }

    }
}
