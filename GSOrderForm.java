import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class GSOrderForm {
    public static void main(String args[]) throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        int cookieCost = 5;

        Hashtable<String, String> cookie1 = new Hashtable<String, String>();
        cookie1.put("cookie", "Thanks-A-Lot");

        Hashtable<String, String> cookie2 = new Hashtable<String, String>();
        cookie2.put("cookie", "Girl Scout S'mores");

        Hashtable<String, String> cookie3 = new Hashtable<String, String>();
        cookie3.put("cookie", "Lemonades");

        Hashtable<String, String> cookie4 = new Hashtable<String, String>();
        cookie4.put("cookie", "Shortbread");

        Hashtable<String, String> cookie5 = new Hashtable<String, String>();
        cookie5.put("cookie", "Thin Mints");

        Hashtable<String, String> cookie6 = new Hashtable<String, String>();
        cookie6.put("cookie", "Peanut Butter Patties");

        Hashtable<String, String> cookie7 = new Hashtable<String, String>();
        cookie7.put("cookie", "Caramel deLites");

        Hashtable<String, String> cookie8 = new Hashtable<String, String>();
        cookie8.put("cookie", "Peanut Butter Sandwhich");

        List<String> GSCookieList = new ArrayList<>();
        GSCookieList.add(cookie1.get("cookie"));
        GSCookieList.add(cookie2.get("cookie"));
        GSCookieList.add(cookie3.get("cookie"));
        GSCookieList.add(cookie4.get("cookie"));
        GSCookieList.add(cookie5.get("cookie"));
        GSCookieList.add(cookie6.get("cookie"));
        GSCookieList.add(cookie7.get("cookie"));
        GSCookieList.add(cookie8.get("cookie"));

        System.out.println("Wellcome to Virtual Girl Scout Cookie Sales!");
        System.out.println("Here are our products!");
        for (String cookie : GSCookieList) {
            System.out.println(cookie);
        }
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String orderCookies;
            System.out.println("Whould you like to buy cookies? [y]es or [n]o");
            orderCookies = scanner.nextLine();

            if (orderCookies.equals("n")) {
                break;
            }

            String cookieChoice;
            System.out.println("What cookies would you like to buy?");
            cookieChoice = scanner.nextLine();

            if (GSCookieList.contains(cookieChoice)) {

                int cookieAmount;
                System.out.println("How many cookies would you like to buy?");
                cookieAmount = scanner.nextInt();

                String lastName;
                System.out.println("What is your last name?");
                lastName = scanner.nextLine();

                String weirdBug; // wierdest bug I have ever encountered
                weirdBug = scanner.nextLine();

                String address;
                System.out.println("What is your address?");
                address = scanner.nextLine();

                String email;
                System.out.println("What is your email?");
                email = scanner.nextLine();

                int cookieTotalAmount = cookieCost * cookieAmount;
                System.out.println("Great! Your total is $" + cookieTotalAmount + "!");
                System.out.println("Come back soon!");

                try {
                    fw = new FileWriter("Transactions.txt", true);
                    bw = new BufferedWriter(fw);
                    pw = new PrintWriter(bw);

                    pw.println(weirdBug + lastName + " | " + address + " | " + email + " | " + cookieChoice + " | "
                            + cookieAmount + " $" + cookieTotalAmount);

                    pw.flush();

                } finally {
                    try {
                        pw.close();
                        bw.close();
                        fw.close();
                    } catch (IOException io) {
                    }
                }
            }
        }
    }
}