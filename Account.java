import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Account {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus", "root", "");
        Scanner sc = new Scanner(System.in);
        Menu m = new Menu();
        Home h = new Home();
        data d = new data(conn);
        operation o = new operation(d);
        Account a = new Account();
        boolean acc = true;
        while (acc) {
            boolean valid_acc = false;
            m.Account_page();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    valid_acc = h.login(a);
                    if (!valid_acc)
                        System.out.println("failed to login");
                    break;
                case 2:
                    valid_acc = h.register(a);
                    if (!valid_acc)
                        System.out.println("failed to register");
                    break;
                default:
                    System.out.println("Enter valid option");
                    break;
            }
            if (valid_acc) {
                h.Home(a,m,h,d,o);
            }
                
        }
    }
}
