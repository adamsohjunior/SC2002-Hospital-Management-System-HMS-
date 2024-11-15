package view;

import java.util.ArrayList;

public class DisplayInbox implements DisplayInfo {
    public static void display(ArrayList<String> inbox) {
        System.out.println("================================ Inbox =================================");
        System.out.println("** You have " + inbox.size() + " messages **");
        
        for (int i = 0; i < inbox.size(); i++) {
            System.out.println("+ " + inbox.get(i));
        }
        System.out.println("========================================================================");
    }
}
