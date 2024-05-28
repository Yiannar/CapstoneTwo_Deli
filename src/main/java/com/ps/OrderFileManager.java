package com.ps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OrderFileManager {

    public static void saveOrder(Order order) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OrderFileWriter.csv"))) {

            bufferedWriter.write(String.format("%s|%s|%s\n",
                    order.getDate(),
                    order.getCustomerName(),
                    order.getServerName()
            ));

            for (Products product : order.getProducts()) {
                bufferedWriter.write(String.format("%f|", product.getPrice()));
            }
            bufferedWriter.newLine();


        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
