package com.ps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OrderFileManager {

    public static Order getOrder(Order order){
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OrderFileWriter.csv"));

            bufferedWriter.write(String.format("%s|%s|%s\n",
                    order.getDate(),
                    order.getCustomerName(),
                   order.getProduts(),
                   order.getServerName()
                    ));

            for (Products products : order.getProduts()){
                bufferedWriter.write(String.format("%s|%s",
                       products.getPrice()));
            }
            bufferedWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
