package com.ps;

import java.util.Scanner;

public class UserInterface {

    private Order order;
    private static Scanner scanner = new Scanner(System.in);

    public void display(){
//        init();

        int mainMenuCommand;

        do{
            System.out.println("Welcome to DELI-cious");
            System.out.println("1) New Order");
            System.out.println("2) Exit");

            System.out.println("Please choose an option: ");

            mainMenuCommand = scanner.nextInt();

             switch (mainMenuCommand){

                 case 1:

                     System.out.println("1) Add Sandwich");
                     System.out.println("2) Add Drink");
                     System.out.println("3) Add Chips");
                     System.out.println("4) Checkout");
                     System.out.println("0) Cancel Order");


                     int command;

                     command = scanner.nextInt();


                 case 2:
                     System.out.println("Exiting.....");






             }



        } while ( mainMenuCommand != 2);
    }

//    private void init(String orderId){
//        this.order = OrderFileManager.getOrder(orderId);
//    }
}
