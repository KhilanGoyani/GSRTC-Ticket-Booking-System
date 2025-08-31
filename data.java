import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class data {
    //conv into BST
    String[][] Route;
    int[][] km;
    String[] Deport;
    String[][] detail;


    data(Connection conn) throws IOException, SQLException {
        loadLL();
        loadArray( conn);
    }
    
    class Node {
        Node next;
        Bus b;

        Node(Bus b) {
            this.b = b;
            this.next = null;
        }
    }

    Node first = null;

    void addfirst(Bus obj) {
        Node n = new Node(obj);
        if (first == null) {
            first = n;
        } else {
            n.next = first;
            first = n;
        }
    }

    Bus search(int r, String date) {
        Node temp = first;
        while (temp != null) {
            if (temp.b.Route == r && temp.b.date.equals(date))
                return temp.b;
            temp = temp.next;

        }
        return null;
    }

    void loadArray(Connection conn) throws IOException, SQLException {
        BufferedReader brn = new BufferedReader(new FileReader("RouteName.txt"));
        BufferedReader brk = new BufferedReader(new FileReader("RouteKm.txt"));
        BufferedReader brd = new BufferedReader(new FileReader("DeportName.txt"));
        String n = brn.readLine();
        Route = new String[Integer.parseInt(n)][];
        n = brn.readLine();
        int i=0;
        while (n != null) {
            Route[i++] = n.split(",");
            n = brn.readLine();
        }
        brn.close();
        n = brk.readLine();
        km = new int[Integer.parseInt(n)][];
        n = brk.readLine();
        i = 0;
        String temp[];
        while (n != null) {
            temp = n.split(",");
            km[i] = new int[temp.length];
            for (int y = 0; y < km[i].length; y++)
                km[i][y] = Integer.parseInt(temp[y]);
            i++;
            n = brk.readLine();
        }
        brk.close();
        n = brd.readLine();
        Deport = new String[Integer.parseInt(n)];
        i = 0;
        n = brd.readLine();
        while (n != null) {
            Deport[i++] = n;
            n = brd.readLine();
        }
        brd.close();
        detail = new String[13][4];
        ResultSet rs = conn.createStatement()
                .executeQuery("select Driver_name,Conductor_name,bus_no,bus_id from bus_details");
        i=0;
        while (rs.next()) {
            detail[i][0]=rs.getString(1);
            detail[i][1]=rs.getString(2);
            detail[i][2]=rs.getString(3);
            detail[i][3] = "" + rs.getInt(4);
            i++;
        }

    }

    void loadLL() throws IOException {
        String name[];
       File f=new File("data");
       File[] ff = f.listFiles();
       for (int i = 0; i < ff.length; i++) {
           BufferedReader br = new BufferedReader(new FileReader(ff[i]));
           String[] j = br.readLine().split(",");
           String[][] a = new String[30][j.length];
           String temp[];
           for (int k = 0; k < 30; k++) {
               temp = br.readLine().split(" ")[1].split(",");
               a[k] = temp;
           }
           name = ff[i].getName().split("_");
           addfirst(new Bus(Integer.parseInt(name[1]), name[2] + name[3], j, a));
            br.close();
           }
       }

    void print() {
        Node temp = first;
        while (temp != null) {
            System.out.print("Route No: " + temp.b.Route + " ");
            for(int i=0;i<temp.b.route.length-1;i++)
                System.out.print(temp.b.route[i]+" -> ");
                System.out.print(temp.b.route[temp.b.route.length-1]);
        }
    }

    Bus printSeat(int r, int b, int a, String date) {
        Node temp = first;
        while (temp != null) {
            if(temp.b.Route==r)
            if (temp.b.date.equals(date)) {
                for (int y = 0; y < temp.b.Seat.length; y++) {
                    boolean g = true;
                    for (int j = a - 1; j < b; j++) {
                        if (temp.b.Seat[y][j].equals("1"))
                            g = false;
                    }
                    if (g)
                        System.out.println(y + 1);
                    else
                        System.out.println("*");

                }
                return temp.b;
            }
        temp = temp.next;
    }
    return null;
    }

    int findRoute(String from, String to) {
        int p = 0;

        return p;
    }
}
class Bus {
    int Route;
    String date;
    String[] route;
    String[][] Seat;
    public Bus(int Route, String date, String[] route, String[][] seat) {
        this.Route = Route;
        this.date = date;
        this.route = route;
        this.Seat = seat;
    }
}