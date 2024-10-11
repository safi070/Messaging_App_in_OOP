//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MessagingApp messagingApp = new MessagingApp();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("1. Add contact");
            System.out.println("2. Display messages");
            System.out.println("3. Send messages");
            System.out.println("4. Search messages");
            System.out.println("5. See Unseen messages");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    messagingApp.contacts.addPerson();
                    break;
                case 2:
                    messagingApp.displayMessages();
                    break;
                case 3:
                    messagingApp.sendMessage();
                    break;
                case 4:
                    messagingApp.searchMessages();
                    break;
                case 5:
                    messagingApp.seeUnseenMessages();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}