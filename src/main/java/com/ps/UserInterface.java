package com.ps;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private boolean order;
    private static Scanner scanner = new Scanner(System.in);

    public void display(){
       init();

        int mainMenuCommand;

        do{
            System.out.println("Welcome to DELI-cious");
            System.out.println("1) New Order");
            System.out.println("2) Exit");

            System.out.println("Please choose an option: ");

            mainMenuCommand = scanner.nextInt();

             switch (mainMenuCommand){

                 case 1:
                     handleNewOrder();

                     break;

                 case 2:
                     System.out.println("Exiting.....");

                     break;

                 default:
                     System.out.println("Invalid input. Please try again.");

                     break;



             }

        } while ( mainMenuCommand != 2);
    }

    private void init(){
//        this.order = OrderFileManager.saveOrder();
       // this.order = new Order("2024-05-24", "Dan", "Kelly", new ArrayList<>());
    }

    private void handleNewOrder(){
        int command;

        do{
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");


            command = scanner.nextInt();
            scanner.nextLine();

            switch (command){
                case 1:
                    addSandwich();
                    break;
                case 2:
                    addDrink();
                    break;
                case 3:
                    addChips();
                    break;
                case 4:
                    checkout();
                    break;
                case 0:
                    cancelOrder();
                    break;

            }
        } while (command != 4 && command != 0);
    }


    private void addSandwich(){
      int command;

      do {
          System.out.println("Select your bread");
          System.out.println("1) White");
          System.out.println("2) Wheat");
          System.out.println("3) Rye");
          System.out.println("4) Wrap");

          command = scanner.nextInt();
//          scanner.nextLine();

          switch (command){
              case 1:
                  System.out.println("What size would you like?");
                  System.out.println("1) 4' ");
                  System.out.println("2) 8' ");
                  System.out.println("2) 12' ");

                  scanner.nextLine();

                  do {
                      System.out.println("What meat toppings would you like to add?");
                      System.out.println("1) Steak");
                      System.out.println("2) Ham");
                      System.out.println("3) Salami");
                      System.out.println("4) Roast Beef");
                      System.out.println("5) Chicken");
                      System.out.println("6) Bacon");

                      System.out.println("Would you like extra meat for an additional cost? 1) Yes 2) No");

                      command = scanner.nextInt();
                      scanner.nextLine();




                  }  while (command != 1);


          }

//          o Toppings: - the user should be able to add extras of each topping
//§ Meat:
//§ Cheese:
//§ Other toppings:
//§ Select sauces:
//          o Would you like the sandwich toasted?
      } while (command != 1);
    }

    private void addDrink(){
        System.out.println("Added Drink");
    }

    private void addChips(){
        System.out.println("Add chips");
    }

    private void checkout(){
        System.out.println("checking customer out");
    }

    private void cancelOrder(){
        System.out.println(" Order is cancelled");
    }


}
