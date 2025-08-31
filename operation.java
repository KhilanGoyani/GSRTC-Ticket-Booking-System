import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class operation {
    static String route_name[][];
    static int route_km[][];
    static String[][] detail;
    LocalDate date0 = LocalDate.now();
    LocalTime time0 = LocalTime.now();
    static String pnr1="G178890";
    static int pnr2;
    static int tktno=1440;
    int km;
    double prise;
    Scanner sc = new Scanner(System.in);
    data d;

    operation(data d) {
        this.d = d;
        route_name = d.Route;
        route_km = d.km;
        detail = d.detail;
try {
    BufferedReader br = new BufferedReader(new FileReader("pnr.txt"));
    pnr2 = Integer.parseInt(br.readLine());
    br.close();
} catch (Exception e) {
}    }

void book(data d, Home hm) throws IOException, SQLException {
    try {
        BufferedReader br = new BufferedReader(new FileReader("pnr.txt"));
        pnr2 = Integer.parseInt(br.readLine());
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter("pnr.txt"));
        pnr2++;
        bw.write("" + pnr2);
        bw.close();
    } catch (Exception e) {
    } 
        System.out.print("From: ");
            String from = sc.next();
        System.out.println("To: ");
            String to = sc.next();
            boolean v1 = false;
            boolean v2 = false;
            int r = 0;
            int a = 0;
            int b = 0;
            for (int i = 0; i < route_name.length; i++) {
                v1=v2=false;
                for (int j = 0; j < route_name[i].length; j++) {
                    if (from.equalsIgnoreCase(route_name[i][j])) {
                        v1 = true;
                        a = j + 1;
                    }
                    if(v1)
                    if (to.equalsIgnoreCase(route_name[i][j])) {
                        v2 = true;
                        b= j + 1;
                    }
                    if(v1&&v2)
                        r =  (i + 1);
                }
            }
            if (b > a) {
                Bus obj=null;
                System.out.println("Enter month (AUG/SPT)");
                String m = sc.next();
                System.out.println("Enter date");
                int q = sc.nextInt();
                System.out.println("Enter no fo seat: ");
                int s = sc.nextInt();
                String h[]=new String[s];
                while (s != 0) {
                    obj = d.printSeat(r, b, a, m + q);
                    s--;
                    System.out.println("Enter Seat No: ");
                    h[s] = sc.next();
                    for (int u = a - 1; u < b; u++) {

                        if (obj.Seat[Integer.parseInt(h[s])][u].equals("0"))
                            obj.Seat[Integer.parseInt(h[s])][u] = "" + 1;
                    }
                }
                if (obj != null) {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("data/R_" + r + "_" + m + "_" + q + "_.txt"));
                    for (int z = 0; z < obj.route.length; z++) {
                        bw.write(obj.route[z] + ",");
                    }
                    bw.write(obj.route[obj.route.length - 1]);
                    bw.newLine();
                    for (int z = 0; z < obj.Seat.length-1; z++) {
                        bw.write((z+1)+ " ");
                        for (int u = 0; u < obj.Seat[z].length - 1; u++) {
                            bw.write(obj.Seat[z][u] + ",");
                        }
                        bw.write(obj.Seat[z][obj.Seat[z].length-1]);
                        bw.newLine();
                    }
                    bw.close();
                    int km = d.km[r-1][b]-d.km[r-1][a];
                    double price = 0;
                    if (km <= 100)
                    price = km * 1;
                    else if (km <= 250 && km > 100)
                    price = km * 0.90;
                    else if (km > 250 && km <= 400)
                    price = km * 0.80;
                    else if (km > 400 && km <= 600)
                    price = km * 0.70;
                    else if (km > 600 && km <= 800)
                    price = km * 0.65;
                    else
                        price = km * 0.60;
                    
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus", "root", "");
                PreparedStatement pst = conn.prepareStatement("insert into transaction values(?,?,?,?,?,?,?)");
                pst.setInt(1,hm.id);
                pst.setInt(2, r);
                pst.setString(3, from);
                pst.setString(4, to);
                pst.setString(5, m + q);
                pst.setString(7, pnr1+pnr2);
                String vi="";
                for (int g = 0; g < h.length;g++)
                    vi += h[g]+" ";
                pst.setString(6, vi);
                pst.executeUpdate();
                System.out.println("Booking sucessful");
                System.out.println("From: " + from + " --> To: " + to);
                System.out.println("Date: " + m + " +d");
                System.out.println(price + "$");
                System.out.println("PNR: "+pnr1+(pnr2++));
                }
            }
            else 
            System.out.println("No route found");
        
    }

    void calcle() throws SQLException, IOException {
        System.out.println("Enter PNR");
        String cp = sc.next();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus", "root", "");
        ResultSet y = con.createStatement().executeQuery("select count(*) from transaction where pnr='" + cp + "'");
        y.next();
        if (y.getInt(1) > 0) {
            ResultSet r = con.createStatement().executeQuery("select * from transaction where pnr='" + cp + "'");
            r.next();
            int rn = r.getInt(2);
            String from = r.getString(3);
            String to = r.getString(4);
            String date = r.getString(5);
            String[] seat = r.getString(6).split(" ");
            int[] se = new int[seat.length];
            for (int i = 0; i < seat.length; i++)
                se[i] = Integer.parseInt(seat[i]);

            int f = 0, t = 0;
            Bus b = d.search(rn, date);
            for (int i = 0; i < b.route.length; i++) {
                if (b.route[i].equalsIgnoreCase(from))
                    f = i;
                if (b.route[i].equalsIgnoreCase(to))
                    t = i;
            }
            for (int j = 0; j < se.length; j++) {
                for (int c = f; c <= t; c++) {
                    b.Seat[se[j]][c] = "" + 0;
                }
            }
            String m = date.substring(0, 3);
                String q = date.substring(3, date.length());
                BufferedWriter bw = new BufferedWriter(new FileWriter("data/R_" + rn + "_" + m + "_" + q + "_.txt"));
                for (int z = 0; z < b.route.length - 1; z++) {
                    bw.write(b.route[z] + ",");
                }
                bw.write(b.route[b.route.length - 1]);
                bw.newLine();
                for (int z = 0; z < b.Seat.length; z++) {
                    bw.write((z + 1) + " ");
                    for (int u = 0; u < b.Seat[z].length - 1; u++) {
                            bw.write(b.Seat[z][u] + ",");
                        }
                        bw.write(b.Seat[z][b.Seat[z].length - 1]);
                        bw.newLine();
                    }
                
                bw.close();
        }
        else
            System.out.println("Invalid PNR");


    }
    
    
    
    void CurrentBookine(String pickup, String drop) {
        String travel_bus="", depot_name="";

        for (int i = 0; i < route_name.length; i++) {
            boolean validity1 = false;
            boolean validity2 = false;
            int a = 0, b = 0;

            for (int j = 0; j < route_name[i].length; j++) {
                if (route_name[i][j].equals(pickup)) {
                    validity1 = true;
                    a = j;
                }
                if (route_name[i][j].equals(drop)) {
                    validity2 = true;
                    b = j;
                }
            }
            if (validity1 == true && validity2 == true) {
                if (route_km[i][a] > route_km[i][b]) {
                    km = route_km[i][a] - route_km[i][b];
                    travel_bus = detail[i][2];
                    depot_name = route_name[i][0].toUpperCase() + " DEPOT";
                } else {
                    km = route_km[i][b] - route_km[i][a];
                    travel_bus = detail[i][2];
                    depot_name = route_name[i][route_name[i].length - 1].toUpperCase() + " DEPOT";
                }
                break;
            }
        }
        for (int i = 0; i < route_name.length; i++) {
            int a = 0, b = 0;
            boolean validity1 = false;
            boolean validity2 = false;
            for (int j = 0; j < route_name[i].length; j++) {
                if (route_name[i][j].equals(pickup)) {
                    validity1 = true;
                    a = j;
                }
                if (route_name[i][j].equals(drop)) {
                    validity2 = true;
                    b = j;
                }
            }
            if (validity1 == true && validity2 == true) {
                if (route_km[i][a] > route_km[i][b]) {
                    if (km > (route_km[i][a] - route_km[i][b])) {
                        km = route_km[i][a] - route_km[i][b];
                        travel_bus = detail[i][2];
                        depot_name = route_name[i][0].toUpperCase() + " DEPOT";
                    }
                } else {
                    if (km > route_km[i][b] - route_km[i][a]) {
                        km = route_km[i][b] - route_km[i][a];
                        travel_bus = detail[i][2];
                        depot_name = route_name[i][route_name[i].length - 1].toUpperCase() + " DEPOT";
                    }
                }
            }
        }
        time0 = LocalTime.now();
        String time1 = "" + time0;
        String time2 = "";
        for (int i = 0; i < 8; i++)
            time2 = time2 + time1.charAt(i);
        if (km <= 100)
            prise = km * 1;
        else if (km <= 250 && km > 100)
            prise = km * 0.95;
        else if (km > 250 && km <= 400)
            prise = km * 0.90;
        else if (km > 400 && km <= 600)
            prise = km * 0.80;
        else if (km > 600 && km <= 800)
            prise = km * 0.75;
        else
            prise = km * 0.70;
        System.out.println();
        if (km != 0) {
            System.out.println("            GSRTC             ");
            centerprinter(depot_name);
            System.out.println("NO:00" + tktno + "            " + travel_bus);
            System.out.println(date0 + "            " + time2);
            tktno++;
            String destination = pickup + " -- " + drop;
            centerprinter(destination);
            System.out.println("   TOT. DISTANCE :   " + km + " KMS");
            km = 0;
            System.out.println("TCLL:0.00   INS:0.00   HR:0.00");
            System.out.println("          " + (int) prise + " RUPEES");
        } else
            new BUS12().bookticket(pickup, drop);
    }

    void centerprinter(String p) {
        int co = 30 - p.length();
        co /= 2;
        for (int i = 0; i < co; i++)
            System.out.print(" ");
        System.out.println(p.toUpperCase());
    }

    void histry() {
        
    }
}
