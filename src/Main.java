import java.util.Scanner;
import java.util.ArrayList;

class Contact{
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final String institution;
    private final String city;

    protected Contact(String firstName, String lastName, String phoneNumber , String institution , String city){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.institution = institution;
        this.city = city;
    }
    protected void display(){
        System.out.println("First Name : " + firstName);
        System.out.println("Last Name : " + lastName);
        System.out.println("Phone Number : " + phoneNumber);
        System.out.println("Institution : " + institution);
        System.out.println("City : " + city);
    }
    protected String getFirstName(){
        return firstName;
    }
    protected String getLastName(){
        return lastName;
    }
    protected String getPhoneNumber(){
        return phoneNumber;
    }
    protected String getInstitution(){
        return institution;
    }
    protected String getCity(){
        return city;
    }
}

public class Main {

    private static void menu(){
        System.out.println("\n1. Insert");
        System.out.println("2. Sort");
        System.out.println("3. Display");
        System.out.println("4. Exit");
        System.out.print(">> ");
    }
    private static void sorting() {
        System.out.println("\n1. By First Name");
        System.out.println("2. By Last Name");
        System.out.println("3. By Phone Number");
        System.out.println("4. By Institution");
        System.out.println("5. By City");
        System.out.print(">>");
    }
    private static void insert(ArrayList<Contact> contacts){
        Scanner scanner = new Scanner(System.in);
        String firstName , lastName , city , phoneNumber, institution;
        System.out.print("First Name : ");
        firstName = scanner.nextLine();
        System.out.print("Last Name : ");
        lastName = scanner.nextLine();
        System.out.print("Phone Number : ");
        phoneNumber = scanner.nextLine();
        System.out.print("Institution: ");
        institution = scanner.nextLine();
        System.out.print("City : ");
        city = scanner.nextLine();
        Contact contact = new Contact(firstName, lastName, phoneNumber, institution, city);
        contacts.add(contact);
    }
    private static void display(ArrayList<Contact> contacts){
        System.out.println();
        for (Contact c : contacts) {
            c.display();
            System.out.println();
        }
    }
    private static void heapSort(ArrayList<Contact> contacts, int parameter) {
        int n = contacts.size();
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(contacts, n, i, parameter);
        for (int i = n - 1; i > 0; i--) {
            Contact temp = contacts.get(0);
            contacts.set(0, contacts.get(i));
            contacts.set(i, temp);
            heapify(contacts, i, 0, parameter);
        }
    }
    private static void heapify(ArrayList<Contact> contacts, int n, int i , int parameter) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        switch (parameter) {
            case 1 -> {
                if (left < n && contacts.get(left).getFirstName().compareTo(contacts.get(largest).getFirstName()) > 0)
                    largest = left;
                if (right < n && contacts.get(right).getFirstName().compareTo(contacts.get(largest).getFirstName()) > 0)
                    largest = right;
            }case 2 -> {
                if (left < n && contacts.get(left).getLastName().compareTo(contacts.get(largest).getLastName()) > 0)
                    largest = left;
                if (right < n && contacts.get(right).getLastName().compareTo(contacts.get(largest).getLastName()) > 0)
                    largest = right;
            }case 3 -> {
                if (left < n && contacts.get(left).getPhoneNumber().compareTo(contacts.get(largest).getPhoneNumber()) > 0)
                    largest = left;
                if (right < n && contacts.get(right).getPhoneNumber().compareTo(contacts.get(largest).getPhoneNumber()) > 0)
                    largest = right;
            }case 4 -> {
                if (left < n && contacts.get(left).getInstitution().compareTo(contacts.get(largest).getInstitution()) > 0)
                    largest = left;
                if (right < n && contacts.get(right).getInstitution().compareTo(contacts.get(largest).getInstitution()) > 0)
                    largest = right;
            }case 5 -> {
                if (left < n && contacts.get(left).getCity().compareTo(contacts.get(largest).getCity()) > 0)
                    largest = left;
                if (right < n && contacts.get(right).getCity().compareTo(contacts.get(largest).getCity()) > 0)
                    largest = right;
            }default -> {}
        }

        if (largest != i) {
            Contact swap = contacts.get(i);
            contacts.set(i, contacts.get(largest));
            contacts.set(largest, swap);
            heapify(contacts, n, largest, parameter);
        }
    }

    public static void main(String[] args) {
        ArrayList<Contact> contacts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        do{
            menu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if(choice == 1){
                insert(contacts);
            } else if (choice == 2){
                sorting();
                int sortBy = scanner.nextInt();
                heapSort(contacts,sortBy);
            } else if(choice == 3){
                display(contacts);
            } else if(choice == 4){
                System.exit(0);
            } else {
                System.out.println("Invalid choice!");
            }
        }while (true);
    }
}