package utils;

import model.Customer;
import model.Interaction;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtils {

    public void saveCustomerToFile(Customer customer){
        try{
            FileWriter fileWriter = new FileWriter("leads.csv");
            fileWriter.write(customer.toString());

        }catch (IOException e){
            System.out.println("Error occurred while writing customer to the file.");
            e.printStackTrace();
        }

        System.out.println("saved! ");
    }

    public void saveInteractionsToFile(ArrayList<Interaction> interactions){
        // csv file 로 저장

        //file open

        //file append interaction

        System.out.println("저장했음  ! ");
    }
}
