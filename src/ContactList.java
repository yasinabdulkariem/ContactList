// Yasin Abdulkariem

import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    private ArrayList<Person> contacts;
    private Scanner s;

    public ContactList(){
        contacts = new ArrayList<>();
        s = new Scanner(System.in);
    }

    public void intructions(){
        System.out.println("Welcome to your Contact List");
        System.out.println("Please pick from the following menu options\n");
        System.out.println("Menu:");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search By Phone Number");
        System.out.println("0. Exit");
    }
    public ArrayList<Person> getContacts(){
        return contacts;
    }
    public void addContact(){
        System.out.println("Select a type of Contact to add: \\n1.Student \\n2.Religon");
        int type = s.nextInt();
        s.nextLine();
        String first = "";
        String last = "";
        String phone = "";
        System.out.println("Please Fill in the Following Information.");
        System.out.println("First Name:");
        first = s.nextLine();
        System.out.println("Last Name:");
        last = s.nextLine();
        System.out.println("Phone Number:");
        phone = s.nextLine();
        if(type == 1){
            int grade = 0;
            System.out.println("Grade:");
            grade = s.nextInt();
            Student a = new Student(first, last, phone, grade);
            contacts.add(a);
        }
        else if(type == 2){
            String religon = "";
            System.out.println("Religon:");
            religon = s.nextLine();
            Religon a = new Religon(first, last, phone, religon);
            contacts.add(a);
        }
    }
    public void listStudents(){
        for (Person s: contacts){
            if (s instanceof Student){
                System.out.println(s);
            }
        }
    }

    public void printContacts(){
        for (Person s: contacts){
            System.out.println(s.toString());
        }
    }
    public void sort(int sortBy){
        for (int i = 0; i < contacts.size() - 1; i++){
            for (int j = 0; j < contacts.size() - i - 1; j++){
                Person c1 = contacts.get(j);
                Person c2 = contacts.get(j + 1);

                int comparison = 0;
                if (sortBy == 0){
                    comparison = c1.getFirstName().compareTo(c2.getFirstName());
                }
                else if (sortBy == 1){
                    comparison = c1.getLastName().compareTo(c2.getLastName());
                }
                else if (sortBy == 2){
                    comparison = c1.getPhoneNumber().compareTo(c2.getPhoneNumber());
                }
            }
        }
    }

    public Person searchByFirstName(String firstName){
        for (Person s: contacts){
            if (s.getFirstName().equals(firstName)){
                return s;
            }
        }
        return null;
    }
    public Person searchByLastName(String lastName){
        for (Person s: contacts){
            if (s.getLastName().equals(lastName)){
                return s;
            }
        }
        return null;
    }
    public Person searchByPhoneNumber(String phoneNumber){
        for (Person s: contacts){
            if (s.getPhoneNumber().equals(phoneNumber)){
                return s;
            }
        }
        return null;
    }

    public void run(){
       intructions();
       int console = 10;
       while (console != 10){
           console = s.nextInt();
           s.nextLine();
           if (console == 1){
               addContact();
           }
           else if(console == 2){
               sort(0);
               printContacts();
           }
           else if(console == 3){
               sort(1);
               printContacts();
           }
           else if(console == 4){
               sort(2);
               printContacts();
           }
           else if(console == 5){
               listStudents();
           }
           else if(console == 6){
               System.out.println("Enter Name: ");
               String name = s.nextLine();
               Person a = searchByFirstName(name);
               if (a == null){
                   System.out.println(name + " is not in the list");
               }
               else{
                   System.out.println(a);
               }
           }
           else if(console == 7){
               System.out.println("Enter Name: ");
               String name = s.nextLine();
               Person a = searchByLastName(name);
               if (a == null){
                   System.out.println(name + " is not in the list");
               }
               else{
                   System.out.println(a);
               }
           }
           else if(console == 8){
               System.out.println("Enter Name: ");
               String number = s.nextLine();
               Person a = searchByPhoneNumber(number);
               if (a == null){
                   System.out.println(number + " is not in the list");
               }
               else{
                   System.out.println(a);
               }
           }
       }
    }

    public static void main(String[] args){
        ContactList contactList = new ContactList();
        contactList.run();
    }
}
