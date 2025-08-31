import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Home {
    Scanner sc = new Scanner(System.in);
    int id;

        boolean login(Account a) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus", "root", "");
        PreparedStatement pst =conn.prepareStatement("select count(*) from users where user_id=? and password=?");
        System.out.print("Enter id: ");
        int z=sc.nextInt();
        pst.setInt(1, z);
        System.out.println("Enter password");
        pst.setString(2, sc.next());
        ResultSet l = pst.executeQuery();
        l.next();
        int p = l.getInt(1);
        id = z;
        if(p>0)
            return true;
        else
            return false;
    }

    boolean register(Account a) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus", "root", "");
        PreparedStatement pst = conn.prepareStatement("insert into users values (?,?,?,?)");
        System.out.print("Enter name: ");
        pst.setString(2, sc.next());
        System.out.print("Create password: ");
        pst.setString(4, sc.next());
        System.out.print("Enter number: ");
        pst.setString(3, sc.next());
        BufferedReader br = new BufferedReader(new FileReader("id.txt"));
        int f = Integer.parseInt(br.readLine());
        ++f;
        BufferedWriter bw = new BufferedWriter(new FileWriter("id.txt"));
        String s = "" + f;
        bw.write(s);
        bw.flush();
        br.close();
        bw.close();
        id = f;
        System.out.println("your user id: " + id);
        pst.setInt(1, f);
        int l = pst.executeUpdate();

        if (l > 0)
            return true;
        else
            return false;
    }
    
    void Home(Account a, Menu m, Home h,data d,operation o) throws IOException, SQLException {
        boolean hcc = true;
        while (hcc) {
            m.home_page();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:o.book(d,h);
                    break;
                case 2:
                    o.calcle();
                    break;
                case 3:
                    System.out.print("From: ");
                    String from = sc.next();
                    System.out.println("To: ");
                    String to = sc.next();
                    o.CurrentBookine(from, to);
                    break;
                case 4:
                    hcc = false;
                    break;
                case 5:
                    System.exit(0);
                    break;            
                default:System.out.println("Enter valid option!");
                    break;
            }
        }
    }
}
