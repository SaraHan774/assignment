import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManager {

    private ArrayList<Customer> customers = new ArrayList<>();

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomerById(String customerId){
        for (int i = 0; i < customers.size(); i++) {
            if(customerId.equals(customers.get(i).getId())){
                return customers.get(i);
            }
        }
        return null;
    }

    public boolean addCustomer(Customer customer){
        return customers.add(customer);
    }

    public boolean updateCustomer(String customerId){
        Customer customer = null;
        for (int i = 0; i < customers.size(); i++) {
            if(customerId.equals(customers.get(i).getId())){
                customer = customers.get(i);
            }
        }

        if(customer == null){
            return false;
        }

        printCustomerUpdateManual();

        Scanner s = new Scanner(System.in);
        boolean isDone = false;

        while(!isDone){
            String target = s.nextLine();

            switch (target){
                case "name" : {
                    System.out.println("enter new name : ");
                    String newName = new Scanner(System.in).nextLine();
                    customer.setName(newName);
                    break;
                }
                case "dob" : {
                    System.out.println("enter new date of birth : ");
                    String newDob = new Scanner(System.in).nextLine();
                    customer.setDateOfBirth(newDob);
                    break;
                }
                case "gender" : {
                    System.out.println("enter new gender : ");
                    String newGender = new Scanner(System.in).nextLine();
                    customer.setGender(newGender);
                    break;
                }
                case "phone" : {
                    System.out.println("enter new phone number : ");
                    String newPhone = new Scanner(System.in).nextLine();
                    customer.setPhoneNumber(newPhone);
                    break;
                }
                case "email" : {
                    System.out.println("enter new email : ");
                    String newEmail = new Scanner(System.in).nextLine();
                    customer.setEmail(newEmail);
                    break;
                }
                case "addr" : {
                    System.out.println("enter new address : ");
                    String newAddr = new Scanner(System.in).nextLine();
                    customer.setAddress(newAddr);
                    break;
                }
                case "0" : {
                    isDone = true;
                    break;
                }
                default : {
                    System.out.println("Wrong Input !");
                    printCustomerUpdateManual();
                    break;
                }
            }
        }
        return true;
    }

    public boolean deleteCustomer(String customerId){
        for (int i = 0; i < customers.size(); i++) {
            if(customerId.equals(customers.get(i).getId())){
                // id 와 일치하는 고객을 리스트에서 삭제한다.
                return customers.remove(customers.get(i));
            }
        }
        return false;
    }

    public void printAllCustomers(){
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i));
        }
    }

    private void printCustomerUpdateManual(){
        System.out.println("Which information would you like to update?");
        System.out.println("OPTIONS : [name, dob (YY/MM/DD), gender, phone, email, addr]");
        System.out.println("Enter '0' when update is complete.");
    }
}