import java.util.*;
public class Contact {

    public static int personCount = 0;

    Person[] contacts = new Person[100];

    public Contact() {
        contacts[personCount++] = new Person("Ali", 321456);
        contacts[personCount++] = new Person("Hamza", 321965);
        contacts[personCount++] = new Person("Ahmed", 326598);
    }

    public void addPerson() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the Contact to add ");
        String name1 = sc.nextLine();
        System.out.println("Enter the Number of the Contact to add ");
        int num1 = sc.nextInt();
        contacts[personCount++] = new Person(name1, num1);
        System.out.println("Contact Added successfully ...");
    }

    public Person getContacts(int index) {
        return contacts[index];
    }

    public void displayContacts() {
        for (int i = 0; i < personCount; i++) {
            System.out.println(contacts[i]);
        }
    }
}