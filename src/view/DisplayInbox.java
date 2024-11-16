package view;

import java.util.ArrayList;

/**
 * DisplayInbox class for display
 */
public class DisplayInbox implements DisplayInfo {
    /**
     * static method to display inbox
     * 
     * @param inbox list of all the messages 
     */
    public static void display(ArrayList<String> inbox) {
        System.out.println("================================ Inbox =================================");
        System.out.println("** You have " + inbox.size() + " messages **");
        
        for (int i = 0; i < inbox.size(); i++) {
            System.out.println("+ " + inbox.get(i));
        }
        System.out.println("========================================================================");
    }
}
