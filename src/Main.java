
import java.util.Scanner;

public class Main {

    private static int customerId = 0;
    private static int interactionId = 0;

    private static SalesPeople salesPeople = new SalesPeople();
    private static CustomerManager customerManager = new CustomerManager();

    public static void main(String[] args) {
        // User input 받는 곳
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'man' to see the manual!");
        FileUtils fileUtils = new FileUtils();

        while(true){
            String input = scanner.nextLine();

            switch (input){
                case "man" : {
                    printManual();
                    break;
                }
                // operations for leads (customers)
                case "10" : {
                    addCustomer();
                    break;
                }
                case "20" : {
                    String customerId = enterCustomerIdPrompt();
                    updateCustomer(customerId);
                    break;
                }
                case "30" : {
                    String customerId = enterCustomerIdPrompt();
                    deleteCustomer(customerId);
                    break;
                }
                case "40" : {
                    printCustomer();
                    break;
                }
                // Operations for customer interactions
                case "1" : {
                    addInteractionInfo();
                    break;
                }
                case "2" : {
                    String interactionId = enterInteractionIdPrompt();
                    updateInteractionInfo(interactionId);
                    break;
                }
                case "3" : {
                    String interactionId = enterInteractionIdPrompt();
                    deleteInteractionInfo(interactionId);
                    break;
                }
                case "4" : {
                    printAllInteractions();
                    break;
                }
                case "0" : {
                    System.out.println("Good bye ... ");

                    System.exit(0);
                }
                default:
                    break;
            }
        }
    }

    private static void printManual(){
        System.out.println("[Manual]\n" +
                "===MANAGE CUSTOMERS===\n" +
                "10 : Enter customer info\n" +
                "20 : Update customer info\n" +
                "30 : Delete customer info\n" +
                "40 : Print all customers\n\n" +
                "===MANAGE SALES INTERACTIONS===\n" +
                "1 : Add interaction info\n" +
                "2 : Update interaction info by id\n" +
                "3 : Delete interaction info by id\n" +
                "4 : Print all interactions\n" +
                "0 : Exit this program\n");
    }

    private static String enterCustomerIdPrompt(){
        System.out.print("Enter customer id : ");
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    private static String enterInteractionIdPrompt(){
        System.out.print("Enter Interaction Id : ");
        Scanner interactionIdInput = new Scanner(System.in);
        return interactionIdInput.nextLine();
    }


    /* Customer 관련된 메서드 */
    public static void addCustomer(){

        Customer customer = createCustomerObject();

        if(customerManager.addCustomer(customer)){
            // ArrayList.add returns true if the item was added successfully
            System.out.println("Add customer successful! \n" + customer);
        }else{
            System.out.println("Add customer failed!");
        }
    }

    private static void deleteCustomer(String customerId) {
        boolean isDeleted = customerManager.deleteCustomer(customerId);
        if(isDeleted){
            System.out.println("deleted customer " + customerId + " successfully");
        }else{
            System.out.println("delete customer failed!");
        }
    }

    private static void updateCustomer(String customerId) {

        boolean isUpdated = customerManager.updateCustomer(customerId);

        if(isUpdated){
            System.out.println("update customer successful!");
        }else{
            System.out.println("update customer failed.");
        }
    }

    private static void printCustomer() {
        customerManager.printAllCustomers();
    }

    private static Customer createCustomerObject(){
        Scanner customerInfoInput = new Scanner(System.in);
        Customer customer = new Customer();

        System.out.println("Enter customer info");

        customer.setId(String.format("lead_%03d", customerId++));

        System.out.print("name : "); //use print function to disable new line
        String name = customerInfoInput.nextLine();
        customer.setName(name);

        System.out.print("Date of Birth (YY/MM/DD) : ");
        String dateOfBirth = customerInfoInput.nextLine();
        customer.setDateOfBirth(dateOfBirth);

        System.out.print("Gender (Male - 0, Female - 1) : ");
        String gender = customerInfoInput.nextLine();
        customer.setGender(gender);

        System.out.print("Phone Number : ");
        String phoneNumber = customerInfoInput.nextLine();
        customer.setPhoneNumber(phoneNumber);

        System.out.print("Email : ");
        String email = customerInfoInput.nextLine();
        customer.setEmail(email);

        System.out.print("Address : ");
        String address = customerInfoInput.nextLine();
        customer.setAddress(address);

        return customer;
    }


    /* Interaction 관련된 메서드 */
    private static void addInteractionInfo() {
        Interaction interaction = createInteractionObject();

        boolean isAdded = salesPeople.addInteraction(interaction);
        if(isAdded){
            System.out.println("Interaction added successfully!\n" + interaction);
        }else{
            System.out.println("Interaction add failed !");
        }
    }

    private static void deleteInteractionInfo(String interactionId) {
        boolean isDeleted = salesPeople.deleteInteraction(interactionId);
        if(isDeleted){
            System.out.println("delete interaction information successful!");
        }else{
            System.out.println("delete interaction information failed.");
        }
    }

    private static void updateInteractionInfo(String interactionId) {
        boolean isUpdated = salesPeople.updateInteraction(interactionId);
        if(isUpdated){
            System.out.println("update interaction information successful!");
        }else{
            System.out.println("update interaction information failed.");
        }
    }

    private static void printAllInteractions() {
        salesPeople.printAllInteractions();
    }

    private static Interaction createInteractionObject(){
        Scanner interactionInfoInput = new Scanner(System.in);
        Interaction interaction = new Interaction();
        interaction.setId(String.format("inter_%03d", interactionId++));

        System.out.print("Date of interaction (YY/MM/DD) : ");
        String dateOfInteraction = interactionInfoInput.nextLine();
        interaction.setDateOfInteraction(dateOfInteraction);

        System.out.print("Customer ID : ");
        String customerId = interactionInfoInput.nextLine();
        Customer customer = customerManager.getCustomerById(customerId);

        if(customer == null){
            while(customer == null){
                System.out.println("wrong customer id, please try again!");
                customerId = interactionInfoInput.nextLine();
                customer = customerManager.getCustomerById(customerId);
            }
        }
        interaction.setCustomer(customer);

        System.out.print("Interaction Method (SNS / email / telephone / face to face) : ");
        String method = interactionInfoInput.nextLine();
        interaction.setInteractionMethod(method);

        System.out.print("Potential (P - positive, NEG - negative, NEU - neutral) : ");
        String potential = interactionInfoInput.nextLine();
        interaction.setPotential(potential);

        return interaction;
    }

}
