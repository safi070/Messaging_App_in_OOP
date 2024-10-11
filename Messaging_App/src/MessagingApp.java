import java.util.*;

public class MessagingApp {
    Message[][] messages = new Message[100][100];
    Contact contacts;

    public MessagingApp() {
        contacts = new Contact(); // Initialize the contacts object
        initializeMessages();
    }

    public void initializeMessages() {
        Message msg1 = new Message("Ali", "Sheraz", "Hi, How are you ?");
        Message msg2 = new Message("Ali", "Ahmed", "The great gatsby ");
        Message msg3 = new Message("Hamza", "Sheraz", "A pine of woods");
        Message msg4 = new Message("Ahmed", "Sheraz", "Hi, How are you ?");

        messages[0][0] = msg1;
        messages[0][1] = msg2;
        messages[1][0] = msg3;
        messages[2][0] = msg4;
    }

    public void sendMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name for sender of the Message ");
        String sender = sc.nextLine();
        System.out.println("Enter Name for Receiver of the Message ");
        String receiver = sc.nextLine();
        System.out.println("Enter the content of the message ");
        String content = sc.nextLine();

        Message msg = new Message(sender, receiver, content);
        for (int i = 0; i < contacts.personCount; i++) {
            if (contacts.getContacts(i).getName().equals(receiver)) {
                for (int j = 0; j < messages[i].length; j++) {
                    if (messages[i][j] == null) {
                        messages[i][j] = msg;
                        break;
                    }
                }
            }
        }
    }

    public void displayMessages() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the person to display its messages "); // receiver name
        String name = sc.nextLine();
        for (int i = 0; i < contacts.personCount; i++) {
            if (contacts.getContacts(i).getName().equals(name)) {
                for (int j = 0; j < messages[i].length; j++) {
                    if (messages[i][j] != null) {
                        System.out.println("From : " + messages[i][j].getSenderName() + "  At Time : " + messages[i][j].getTimeStamp());
                        System.out.println(messages[i][j].getMessageContent() + "\n");
                    }
                }
            }
        }
    }

    public void searchMessages() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Name of the name of contact for search "); // receiver name
        String name = sc.nextLine();
        System.out.println("Enter the keyword you want to search  ");
        String keyword = sc.nextLine();

        for (int i = 0; i < contacts.personCount; i++) {
            if (contacts.getContacts(i).getName().equals(name)) {
                for (int j = 0; j < messages[i].length; j++) {
                    if (messages[i][j] != null && messages[i][j].getMessageContent().contains(keyword)) {
                        System.out.println("Message Found   From Sender " + messages[i][j].getSenderName());
                        System.out.println(messages[i][j].getMessageId());
                        System.out.println(messages[i][j].getMessageContent());
                    }
                }
            }
        }
    }


    public void seeUnseenMessages() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the person to see unseen messages ");
        String name = sc.nextLine();
        boolean unseenMessageFound = false;
        for (int i = 0; i < contacts.personCount; i++) {
            if (contacts.getContacts(i).getName().equals(name)) {
                for (int j = 0; j < messages[i].length; j++) {
                    if (messages[i][j] != null && !messages[i][j].isSeen()) {
                        System.out.println("From : " + messages[i][j].getSenderName() + "  At Time : " + messages[i][j].getTimeStamp());
                        System.out.println(messages[i][j].getMessageContent() + "\n");
                        messages[i][j].setSeen(true);
                        unseenMessageFound = true;
                    }
                }
            }
        }
        if (!unseenMessageFound) {
            System.out.println("No unseen messages found for " + name);
        }
    }
}