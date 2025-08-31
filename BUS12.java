

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

class BUS12 {
    Scanner sc = new Scanner(System.in);
    LocalDate date0 = LocalDate.now();
    LocalTime time0 = LocalTime.now();
    String[][] route_name = {
            { "kutch", "banaskantha", "sabarkantha", "aravalli", "mahisagar", "dahod", "chota_udaipur", "narmada",
                    "tapi", "dang", "valsad" },
            { "kutch", "patan", "mehsana", "gandhinagar", "ahmedabad", "kheda", "panchmahal", "dahod" },
            { "kutch", "gandhidham", "morbi", "rajkot", "amreli", "bhavnagar" },
            { "kutch", "gandhidham", "morbi", "jamnagar", "porbandar" },
            { "devbhoomi_dwarka", "jamnagar", "rajkot", "amreli", "botad", "ahmedabad", "anand", "vaodara", "bharuch",
                    "surat", "bardoli", "navsari", "valsad" },
            { "devbhoomi_dwarka", "porbandar", "junagadh", "girsomnath", "amreli", "bhavnagar", "botad", "ahmedabad",
                    "gandhinagar", "sabarkantha" },
            { "bhavnagar", "botad", "ahmedabad", "kheda", "anand", "vadodara", "bharuch", "surat", "bardoli", "navsari",
                    "valsad" },
            { "sabarkantha", "gandhinagar", "ahmedabad", "kheda", "anand", "vadodara", "narmada", "tapi", "dang",
                    "valsad" },
            { "banaskantha", "mehsana", "gandhinagar", "ahmedabad", "kheda", "panchmahal", "vadodara", "narmada",
                    "surat" },
            { "patan", "surendranagar", "botad", "bhavnagar" },
            { "surat", "bharuch", "narmada", "chota_udaipur", "panchmahal", "mahisagar" },
            { "valsad", "navsari", "tapi", "narmada", "vadodara" },
            { "kutch", "patan", "surendranagar", "morbi", "rajkot", "amreli", "gir_somnath" } };
    int[][] route_km = { { 0, 268, 441, 521, 586, 707, 798, 894, 1013, 1082, 1193 },
            { 0, 287, 342, 401, 421, 459, 572, 655 }, { 0, 126, 250, 316, 427, 546 }, { 0, 126, 250, 353, 427 },
            { 0, 89, 180, 291, 384, 535, 612, 656, 738, 814, 852, 886, 942 },
            { 0, 79, 184, 291, 399, 518, 619, 769, 789, 891 }, { 0, 101, 252, 290, 330, 377, 456, 532, 570, 604, 660 },
            { 0, 102, 122, 160, 200, 247, 339, 458, 527, 638 }, { 0, 142, 219, 239, 277, 390, 476, 568, 706 },
            { 0, 170, 256, 357 }, { 0, 76, 151, 247, 347, 404 }, { 0, 56, 157, 276, 368 },
            { 0, 287, 457, 584, 650, 761, 869 } };
    String[][] detail = { { "Driver1", "condutor1", "GJ18Z1234", "1", "EXPRESS", "D89TYU4GH4" },
            { "Driver2", "condutor2", "GJ18Z4567", "2", "EXPRESS", "GH8J5I456R" },
            { "Driver3", "condutor3", "GJ18Z7895", "3", "EXPRESS", "TR5H65G5FH" },
            { "Driver4", "condutor4", "GJ18Z7946", "4", "EXPRESS", "GNF34T514G" },
            { "Driver5", "condutor5", "GJ18Z1346", "5", "EXPRESS", "TV4154G5T7" },
            { "Driver6", "condutor6", "GJ18Z1441", "6", "EXPRESS", "V43RD2H435" },
            { "Driver7", "condutor7", "GJ18Z8989", "7", "EXPRESS", "31V42F8TY8" },
            { "Driver8", "condutor8", "GJ18Z6565", "8", "EXPRESS", "7RV1T8D54Y" },
            { "Driver9", "condutor9", "GJ18Z3663", "9", "EXPRESS", "VNTBD54CVS" },
            { "Driver10", "condutor10", "GJ18Z3232", "10", "EXPRESS", "H8CBDG4V78" },
            { "Driver11", "condutor11", "GJ18Z7878", "11", "EXPRESS", "NTBCF4VB5P" },
            { "Driver12", "condutor12", "GJ18Z5225", "12", "EXPRESS", "U4I51JNHB" },
            { "Driver13", "Conductor13", "GJ189999", "13", "EXPRESS", "U4BNY5H7T9" } };
    int[][] base_timing = { { 100, 400, 600 }, { 120, 360, 540 }, { 100, 220, 540 }, { 60, 240, 600 }, { 60, 420, 720 },
            { 300, 720 }, { 0, 600, 900 }, { 180, 720, 900 }, { 360, 660, 960 }, { 420, 960 }, { 0, 420, 720 },
            { 420, 720 }, { 180, 540, 810 } };
    int[][] base_route_time = { { 0, 370, 660, 780, 880, 1060, 1200, 1341, 1500, 1630, 1710 },
            { 0, 420, 510, 600, 630, 690, 860, 980 }, { 0, 190, 375, 475, 640, 820 }, { 0, 190, 375, 530, 640 },
            { 0, 130, 270, 430, 575, 800, 915, 985, 1100, 1220, 1280, 1300, 1355 },
            { 0, 120, 270, 430, 600, 775, 930, 1000, 1040, 1200 },
            { 0, 150, 378, 435, 500, 560, 680, 800, 850, 900, 990 }, { 0, 250, 180, 240, 300, 370, 510, 680, 790, 960 },
            { 0, 210, 330, 360, 415, 580, 715, 852, 1060 }, { 0, 250, 384, 530 }, { 0, 115, 230, 375, 525, 600 },
            { 0, 75, 230, 415, 550 }, { 0, 415, 870, 975, 1140, 1300 } };
    String[][][][][][] seat_position;
    String[] seat = { " ", "1", "", "2", "    ", "3", "", "4", "", "5", "\n ", "6", "", "7", "    ", "8", "", "9", "10",
            "\n", "11", "12", "   ", "13", "14", "15", "\n", "16", "17", "   ", "18", "19", "20", "\n", "21", "22",
            "   ", "23", "24", "25", "\n", "26", "27", "   ", "28", "29", "30", "\n", "31", "32", "   ", "33", "34",
            "35", "\n", "36", "37", "   ", "38", "39", "40", "\n", "41", "42", "   ", "43", "44", "45", "\n", "46",
            "47", "   ", "48", "49", "50", "\n" };
    String seat_h = "";
    String sn = "";
    int account_no;
    String[][] base_Customer_data = { { "vasu", "vasu123", "8866945457", "vasu@mail.com", "1234" },
            { "prince", "prince123", "9879320827", "prince@mail.com", "1234" },
            { "rucht", "rucit123", "8780670455", "ruchit@mail.com", "1234" },
            { "tirth", "tirth123", "9106120041", "tirth@mail.com", "1234" },
            { "parixit", "parixit123", "9979586050", "parixit@mail.com", "1234" },
            { "krunal", "krunal123", "9586709827", "krunal@mail.com", "1234" },
            { "jay", "jay123", "7874535058", "jay@mail.com", "1234" },
            { "utsav", "utsav123", "9426346806", "utsav@mail.com", "1234" }, { "1", "1", "1", "1", "1" } };
    String[][] Customer_data;
    String[][] temp_Customer_data;
    int nPNR = 143;
    String PNR = "G178890";
    boolean homeloop = true;
    boolean valid_acc = true;
    int km, nsn;
    double prize;
    int ticket_no = 8472;
    int a, b, c;
    String travel_bus;
    String depot_name = " ";
    String[][] temp_histry;
    String[][] histry;
    String[][] base_histry = { { "Customer id", "From", "To", "PNR", "TRIPCODE", "Monile no", "Class", "Seat no",
            "Persons", "money", "date", "conformation" } };
    String xyz = "" + date0;
    int m0 = s_to_i("" + xyz.charAt(5) + xyz.charAt(6));
    int d0 = s_to_i("" + xyz.charAt(8) + xyz.charAt(9));

    void seat_set() {
        seat_position = new String[route_name.length][][][][][];
        for (int i = 0; i < route_name.length; i++) {
            seat_position[i] = new String[base_timing[i].length][][][][];
            for (int j = 0; j < base_timing[i].length; j++) {
                seat_position[i][j] = new String[route_name[i].length][][][];
                for (int k = 0; k < route_name[i].length; k++) {
                    seat_position[i][j][k] = new String[3][][];
                    for (int l = 0; l < seat_position[i][j][k].length; l++) {
                        if (l == 1)
                            seat_position[i][j][k][l] = new String[31][];
                        else if (l == 2)
                            seat_position[i][j][k][l] = new String[29][];
                        else
                            seat_position[i][j][k][l] = new String[31][];
                        for (int m = 0; m < seat_position[i][j][k][l].length; m++) {
                            seat_position[i][j][k][l][m] = new String[seat.length];
                            for (int n = 0; n < seat.length; n++) {
                                seat_position[i][j][k][l][m][n] = seat[n];
                            }
                        }
                    }
                }
            }
        }
    }

    void centerprinter(String p) {
        int co = 30 - p.length();
        co /= 2;
        for (int i = 0; i < co; i++)
            System.out.print(" ");
        System.out.println(p.toUpperCase());
    }

    BUS12() {
        Customer_data = new String[base_Customer_data.length][5];
        temp_Customer_data = new String[base_Customer_data.length][5];
        for (int i = 0; i < base_Customer_data.length; i++) {
            for (int j = 0; j < 5; j++) {
                Customer_data[i][j] = temp_Customer_data[i][j];
                temp_Customer_data[i][j] = temp_Customer_data[i][j];
            }
        }
        Customer_data = new String[base_Customer_data.length][];
        temp_Customer_data = new String[base_Customer_data.length][];
        for (int i = 0; i < base_Customer_data.length; i++) {
            Customer_data[i] = new String[base_Customer_data[i].length];
            temp_Customer_data[i] = new String[base_Customer_data[i].length];
            for (int j = 0; j < base_Customer_data[i].length; j++) {
                Customer_data[i][j] = base_Customer_data[i][j];
                temp_Customer_data[i][j] = base_Customer_data[i][j];
            }
        }
        histry = new String[base_histry.length][12];
        temp_histry = new String[base_histry.length][12];
        for (int i = 0; i < base_histry.length; i++) {
            for (int j = 0; j < base_histry[i].length; j++) {
                histry[i][j] = base_histry[i][j];
                temp_histry[i][j] = base_histry[i][j];
            }
        }
    }

    int s_to_i(String n) {
        int x = 0;
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '0')
                x = x * 10 + 0;
            else if (n.charAt(i) == '1')
                x = x * 10 + 1;
            else if (n.charAt(i) == '2')
                x = x * 10 + 2;
            else if (n.charAt(i) == '3')
                x = x * 10 + 3;
            else if (n.charAt(i) == '4')
                x = x * 10 + 4;
            else if (n.charAt(i) == '5')
                x = x * 10 + 5;
            else if (n.charAt(i) == '6')
                x = x * 10 + 6;
            else if (n.charAt(i) == '7')
                x = x * 10 + 7;
            else if (n.charAt(i) == '8')
                x = x * 10 + 8;
            else if (n.charAt(i) == '9')
                x = x * 10 + 9;
        }
        return x;
    }

    int s_to_i() {
        int x = 0;
        String n = sc.next();
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '0')
                x = x * 10 + 0;
            else if (n.charAt(i) == '1')
                x = x * 10 + 1;
            else if (n.charAt(i) == '2')
                x = x * 10 + 2;
            else if (n.charAt(i) == '3')
                x = x * 10 + 3;
            else if (n.charAt(i) == '4')
                x = x * 10 + 4;
            else if (n.charAt(i) == '5')
                x = x * 10 + 5;
            else if (n.charAt(i) == '6')
                x = x * 10 + 6;
            else if (n.charAt(i) == '7')
                x = x * 10 + 7;
            else if (n.charAt(i) == '8')
                x = x * 10 + 8;
            else if (n.charAt(i) == '9')
                x = x * 10 + 9;
            else if (n.equalsIgnoreCase("back"))
                x = -1;
            else if (n.equalsIgnoreCase("exit"))
                x = -2;
            else {
                System.out.println("Enter only number.");
                break;
            }
        }
        return x;
    }

    void Account_page() {
        System.out.println(" _________________________________________ ");
        System.out.println("|  _____________________________________  |");
        System.out.println("| |                  |                  | |");
        System.out.println("| |   Enter 1for     |    Enter 2 for   | |");
        System.out.println("| |      Login       |       Signup     | |");
        System.out.println("| |__________________|__________________| |");
        System.out.println("| |                  |                  | |");
        System.out.println("| |   Enter 3 for    |   Enter 4 for    | |");
        System.out.println("| | Forgot Password  |       EXIT       | |");
        System.out.println("| |__________________|__________________| |");
        System.out.println("|_________________________________________|\n");
        System.out.print("Enter No: ");
    }

    void Account_find() {

        System.out.println();
        Account_page();
        boolean loop = true;
        boolean loop1 = true;
        boolean b = true;
        boolean back = false;
        int p = s_to_i();
        switch (p) {
            case 0:
                valid_acc = false;
                Account_find();
                break;
            case -1:
                valid_acc = false;
                break;
            case -2:
                valid_acc = false;
                break;
            case 1:
                for (; loop1;) {
                    b = false;
                    System.out.print("Enter User-id or Number or Email-id: ");
                    String user_name = sc.next();
                    if (user_name.equals("back")) {
                        back = true;
                        loop = false;
                        loop1 = false;
                    } else if (user_name.equalsIgnoreCase("exit")) {
                        loop = false;
                        loop1 = false;
                        valid_acc = false;
                    } else {
                        for (int k = 0; k < Customer_data.length; k++) {
                            if (Customer_data[k][1].equals(user_name) || Customer_data[k][2].equals(user_name)
                                    || Customer_data[k][3].equals(user_name)) {
                                for (; loop;) {
                                    System.out.print("Enter password: ");
                                    String P12 = sc.next();
                                    if (P12.equals("back")) {
                                        loop = false;
                                        loop1 = false;
                                        back = true;
                                        b = true;
                                    } else if (P12.equalsIgnoreCase("exit")) {
                                        loop = false;
                                        loop1 = false;
                                        valid_acc = false;
                                        b = true;
                                    } else if (P12.equals(Customer_data[k][4])) {
                                        account_no = k;
                                        loop1 = false;
                                        loop = false;
                                        b = true;
                                        System.out.println();
                                        System.out.println("Login Sucessfully");
                                    } else {
                                        System.out.println("Incorrect password!");
                                    }
                                }
                            }
                        }
                        if (!b)
                            System.out.println("No Accuont found");
                    }
                }
                if (back)
                    Account_find();
                break;
            case 2:
                String new_name = "";
                String new_no = "";
                String new_id = "";
                String new_1 = "";
                String new_2 = "";
                String new_mail = "";
                boolean back3 = false;
                System.out.print("Enter name: ");
                new_name = sc.next();
                if (new_name.equalsIgnoreCase("back"))
                    back3 = true;
                else if (new_name.equalsIgnoreCase("exit"))
                    valid_acc = false;
                else {
                    boolean l7 = true;
                    for (; l7;) {
                        System.out.print("Enter mobile number: ");
                        new_no = sc.next();
                        if (new_no.equalsIgnoreCase("back")) {
                            back3 = true;
                            l7 = false;
                        }
                        if (new_no.equalsIgnoreCase("exit")) {
                            valid_acc = false;
                            l7 = false;
                        } else {
                            if (new_no.length() == 10) {
                                boolean nol = false;
                                for (int i = 0; i < new_no.length(); i++) {
                                    if (new_no.charAt(i) >= '0' && new_no.charAt(i) <= '9') {
                                    } else
                                        nol = true;
                                }
                                if (nol == true)
                                    System.out.println("mobile number should have Only numbers");
                                else {
                                    boolean ml = true;
                                    boolean mv = false;
                                    for (; ml;) {
                                        System.out.print("Enter mail-id: ");
                                        new_mail = sc.next();
                                        for (int i = 0; i < new_mail.length() - 1; i++) {
                                            if (new_mail.charAt(i) == '@') {
                                                mv = true;
                                                ml = false;
                                            }
                                        }
                                        if (new_mail.equalsIgnoreCase("back")) {
                                            l7 = false;
                                            back3 = true;
                                        } else if (new_mail.equalsIgnoreCase("exit")) {
                                            l7 = false;
                                            valid_acc = false;
                                        }
                                        if (!mv)
                                            System.out.println("Enter valid mail-id");
                                        else
                                            ml = false;
                                    }
                                    if (mv) {
                                        new_id = new_name + new_no.charAt(0) + new_no.charAt(4) + new_no.charAt(9);
                                        System.out.println("Your Userid: " + new_id);
                                        boolean ll1 = true;
                                        boolean ll2 = true;
                                        System.out.println("NOTE : Password length should be 4");
                                        for (; ll1;) {
                                            System.out.print("Create password: ");
                                            new_1 = sc.next();
                                            if (new_1.length() == 4) {
                                                ll1 = false;
                                            } else
                                                System.out.println("NOTE : Password length should be 4");
                                            if (new_1.equalsIgnoreCase("back")) {
                                                ll1 = false;
                                                ll2 = false;
                                                l7 = false;
                                                back3 = true;
                                            } else if (new_1.equalsIgnoreCase("exit")) {
                                                ll1 = false;
                                                ll2 = false;
                                                l7 = false;
                                                valid_acc = false;
                                            }
                                        }
                                        for (; ll2;) {
                                            System.out.print("Confirm Password: ");
                                            new_2 = sc.next();
                                            if (new_2.equalsIgnoreCase("back")) {
                                                ll1 = false;
                                                ll2 = false;
                                                l7 = false;
                                                back3 = true;
                                            } else if (new_2.equalsIgnoreCase("exit")) {
                                                ll1 = false;
                                                ll2 = false;
                                                l7 = false;
                                                valid_acc = false;
                                            } else {
                                                if (new_1.equals(new_2)) {
                                                    System.out.println("Your Acount created.");
                                                    l7 = false;
                                                    ll1 = false;
                                                    ll2 = false;
                                                    temp_Customer_data = new String[Customer_data.length + 1][5];
                                                    for (int i = 0; i < Customer_data.length; i++) {
                                                        temp_Customer_data[i] = new String[Customer_data[i].length];
                                                        for (int j = 0; j < temp_Customer_data[i].length; j++) {
                                                            temp_Customer_data[i][j] = Customer_data[i][j];
                                                        }
                                                    }
                                                    temp_Customer_data[temp_Customer_data.length - 1][0] = new_name;
                                                    temp_Customer_data[temp_Customer_data.length - 1][1] = new_id;
                                                    temp_Customer_data[temp_Customer_data.length - 1][2] = new_no;
                                                    temp_Customer_data[temp_Customer_data.length - 1][3] = new_mail;
                                                    temp_Customer_data[temp_Customer_data.length - 1][4] = new_1;
                                                    Customer_data = new String[temp_Customer_data.length][];
                                                    for (int i = 0; i < Customer_data.length; i++) {
                                                        Customer_data[i] = new String[temp_Customer_data[i].length];
                                                        for (int j = 0; j < temp_Customer_data[i].length; j++)
                                                            Customer_data[i][j] = temp_Customer_data[i][j];
                                                    }
                                                } else
                                                    System.out.println("Both password should be same");
                                                System.out.println();
                                            }
                                        }
                                    }
                                }
                            } else
                                System.out.println("Number length should be 10");
                        }
                    }
                }
                if (back3)
                    Account_find();
                break;
            case 3:
                boolean dsf = true;
                boolean loopx = true;
                boolean bn = false;
                boolean back2 = false;
                for (; dsf;) {
                    bn = false;
                    System.out.print("Enter User-id: ");
                    String user_name2 = sc.next();
                    if (user_name2.equals("back")) {
                        back2 = true;
                        dsf = false;
                    } else {
                        for (int k = 0; k < Customer_data.length; k++) {
                            if (Customer_data[k][1].equals(user_name2)) {
                                for (; loopx;) {
                                    System.out.print("Enter Mobile No or Email-id: ");
                                    String varification_detail = sc.next();
                                    if (varification_detail.equals("back")) {
                                        dsf = false;
                                        loopx = false;
                                        back2 = true;
                                        bn = true;
                                    } else if (varification_detail.equals(Customer_data[k][2])
                                            || varification_detail.equals(Customer_data[k][3])) {
                                        boolean loop3 = true;
                                        for (; loop3;) {
                                            System.out.println("Enter new Password: ");
                                            Customer_data[k][4] = sc.next();
                                            if (Customer_data[k][4].length() != 4) {
                                                System.out.println("Password length should be 4");
                                            } else if (Customer_data[k][4].equals("back"))
                                                System.out.println("Password can not \"back\".");
                                            else {
                                                account_no = k;
                                                dsf = false;
                                                loopx = false;
                                                bn = true;
                                                loop3 = false;
                                                valid_acc = true;
                                                System.out.println("");
                                                System.out.println("Password changed Sucessfully");
                                            }
                                        }
                                    } else {
                                        System.out.println("Incorrect Varification Detail.");
                                    }
                                }
                            }
                        }
                        if (!bn)
                            System.out.println("No Accuont found!");
                    }
                }
                if (back2)
                    Account_find();
                break;
            case 4:
                valid_acc = false;
                homeloop = false;
                valid_acc = false;
                break;
            default:
                if (p != 0)
                    System.out.println("Invalid option");
                Account_find();
                break;
        }
        if (valid_acc)
            home();

    }

    void home_page() {
        System.out.println(" ____________________________________________________");
        System.out.println("|                                                    |");
        System.out.println("|  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  |");
        System.out.println("|    ___________     ____________     ___________    |");
        System.out.println("|   |           |   |            |   |           |   |");
        System.out.println("|   |  Enter 1  |   |   Enter 2  |   |  Enter 3  |   |");
        System.out.println("|   |    for    |   |     for    |   |    for    |   |");
        System.out.println("|   |  booking  |   |cancellation|   | Track Bus |   |");
        System.out.println("|   |___________|   |____________|   |___________|   |");
        System.out.println("|                                                    |");
        System.out.println("|  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  |");
        System.out.println("|   _____________________    _____________________   |");
        System.out.println("|  |                     |  |                     |  |");
        System.out.println("|  |    Enter 4  for     |  |     Enter 5 for     |  |");
        System.out.println("|  |     view Ticket     |  |      Time Table     |  |");
        System.out.println("|  |_____________________|  |_____________________|  |");
        System.out.println("|   _____________________    _____________________   |");
        System.out.println("|  |                     |  |                     |  |");
        System.out.println("|  |    Enter 6  for     |  |     Enter 7 for     |  |");
        System.out.println("|  |   Current Booking   |  |      view histry    |  |");
        System.out.println("|  |_____________________|  |_____________________|  |");
        System.out.println("|   _____________________    _____________________   |");
        System.out.println("|  |                     |  |                     |  |");
        System.out.println("|  |     Enter 8  for    |  |     Enter 9 for     |  |");
        System.out.println("|  |         Back        |  |         Exit        |  |");
        System.out.println("|  |_____________________|  |_____________________|  |");
        System.out.println("|                                                    |");
        System.out.println("| ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ |");
        System.out.println("|____________________________________________________|");
    }

    void home() {
        home_page();
        System.out.println("");
        System.out.print("Enter No:");
        int p = s_to_i();
        switch (p) {
            case 0:
                break;
            case -1:
                homeloop = false;
                break;
            case 1:
                booking();
                break;
            case 2:
                cancellation();
                break;
            case 3:
                track();
                break;
            case 4:
                viewticket();
                break;
            case 5:
                timetable();
                break;
            case 6:
                System.out.print("From: ");
                String pickup = sc.next();
                if (pickup.equalsIgnoreCase("exit")) {
                    homeloop = false;
                } else if (pickup.equalsIgnoreCase("back")) {
                } else {
                    System.out.print("To: ");
                    String drop = sc.next();
                    if (drop.equalsIgnoreCase("exit")) {
                        homeloop = false;
                    } else if (drop.equals("back")) {
                    } else {
                        bookticket(pickup, drop);
                    }
                }
                break;
            case 7:
                view();
                break;
            case 8:
                Account_find();
                break;
            case 9:
                homeloop = false;
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
        if (homeloop)
            home();
    }

    void booking() {
        int count = 1;
        boolean p1 = true;
        boolean p2 = true;
        String From = "";
        String To = "";
        for (; p1;) {
            System.out.print("From: ");
            From = sc.next().toLowerCase();
            for (int i = 0; i < route_name.length; i++) {
                for (int j = 0; j < route_name[i].length; j++) {
                    if (From.equalsIgnoreCase(route_name[i][j]))
                        p1 = false;
                }
            }
            if (From.equalsIgnoreCase("back") || From.equalsIgnoreCase("exit"))
                p1 = false;
            if (p1)
                System.out.println("No station found");
        }
        if (From.equalsIgnoreCase("back")) {
        } else if (From.equalsIgnoreCase("exit")) {
            homeloop = false;
        } else {
            for (; p2;) {
                System.out.print("To: ");
                To = sc.next().toLowerCase();
                for (int i = 0; i < route_name.length; i++) {
                    for (int j = 0; j < route_name[i].length; j++) {
                        if (To.equalsIgnoreCase(route_name[i][j]))
                            p2 = false;
                    }
                }
                if (To.equalsIgnoreCase("back") || To.equalsIgnoreCase("exit"))
                    p2 = false;
                if (p2)
                    System.out.println("No station found");
            }
            if (To.equalsIgnoreCase("back")) {
            } else if (To.equalsIgnoreCase("exit"))
                homeloop = false;
            else {
                int bn = 0;
                count = 1;
                int m = 0;
                int d = 0;
                sn = "";
                seat_h = "";
                boolean lp1 = true;
                boolean lp2 = true;
                for (; lp1;) {
                    System.out.println("Enter month");
                    m = s_to_i();
                    if (m > 0 && m <= 3)
                        lp1 = false;
                    else if (m == -1 || m == -2) {
                    } else
                        System.out.println("You can not book ticket before 2 months");
                }
                if (m == -2)
                    homeloop = false;
                else if (m == -1) {
                } else {
                    for (; lp2;) {
                        System.out.println("Enter date");
                        d = s_to_i();
                        if (d == -1 || d == -2)
                            lp2 = false;
                        else if (d == -2)
                            homeloop = false;
                        else if (m == m0 && d < d0)
                            System.out.println("You can not book in past");
                        else if (d >= -2) {
                            if (m == 1) {
                                if (d <= 31) {
                                    lp2 = false;
                                }
                            } else if (m == 2) {

                                if (d <= 29) {
                                    lp2 = false;
                                }
                            } else if (m == 3) {
                                if (d <= 31) {
                                    lp2 = false;
                                }
                            }
                        }
                        if (lp2)
                            System.out.println("Enter valid date");
                    }
                    if (d > 0) {
                        for (int i = 0; i < route_name.length; i++) {
                            boolean validity1 = false;
                            boolean validity2 = false;
                            for (int j = 0; j < route_name[i].length; j++) {
                                if (route_name[i][j].equals(From)) {
                                    validity1 = true;
                                    a = j;
                                }
                                if (route_name[i][j].equals(To)) {
                                    validity2 = true;
                                    b = j;
                                    c = i;
                                }
                            }
                            if (validity1 == true && validity2 == true) {
                                if (a < b) {
                                    km = route_km[i][b] - route_km[i][a];
                                    if (km <= 100)
                                        prize = km * 1;
                                    else if (km <= 250 && km > 100)
                                        prize = km * 0.90;
                                    else if (km > 250 && km <= 400)
                                        prize = km * 0.80;
                                    else if (km > 400 && km <= 600)
                                        prize = km * 0.70;
                                    else if (km > 600 && km <= 800)
                                        prize = km * 0.65;
                                    else
                                        prize = km * 0.60;
                                    for (int l = 0; l < base_timing[i].length; l++) {
                                        System.out.println("Bus " + count++);
                                        System.out.println(" ________________________________________");
                                        System.out.print("|" + detail[i][4]);
                                        int spc = detail[i][4].length() + 4;
                                        if ((int) prize < 10)
                                            spc += 1;
                                        else if ((int) prize >= 10 && (int) prize < 100)
                                            spc += 2;
                                        else if ((int) prize >= 100 && (int) prize < 1000)
                                            spc += 3;
                                        else
                                            spc += 4;
                                        for (int x = 0; x < 40 - spc; x++)
                                            System.out.print(" ");
                                        System.out.println("INR " + (int) prize + "|");
                                        System.out.print("|" + route_name[i][0] + " - "
                                                + route_name[i][route_name[i].length - 1]);
                                        for (int h = 4 + route_name[i][0].length()
                                                + route_name[i][route_name[i].length - 1].length(); h < 41; h++)
                                            System.out.print(" ");
                                        System.out.print("|\n|");
                                        time_printer(base_timing[i][l] + base_route_time[i][a]);
                                        System.out.print(" ------");
                                        time_printer(base_route_time[i][b] - base_route_time[i][a]);
                                        System.out.print("------ ");
                                        time_printer(base_timing[i][l] + base_route_time[i][b]);
                                        System.out.print("  |");
                                        System.out.println();
                                        System.out.print("|Tripcode : " + detail[0][5]);
                                        for (int h = 12 + detail[0][5].length(); h < 41; h++)
                                            System.out.print(" ");
                                        System.out.println("|\n|________________________________________|");
                                    }
                                }
                                if (count != 1) {
                                    boolean lp = true;
                                    for (; lp;) {
                                        System.out.print("Enter bus No: ");
                                        bn = s_to_i();
                                        if (bn >= 1 && bn <= count)
                                            lp = false;
                                        if (bn == -1 || bn == -2)
                                            lp = false;
                                        if (bn == -2)
                                            homeloop = false;
                                    }
                                    break;
                                }
                            }
                        }
                        if (count == 1)
                            System.out.println("Sorry, no bus service is available for your selection");
                        if (bn > 0) {
                            seat(c, --bn, a, b, --m, --d);

                            if (count != 1) {
                                temp_histry = new String[histry.length + 1][12];
                                for (int i = 0; i < histry.length; i++) {
                                    for (int j = 0; j < histry[i].length; j++)
                                        temp_histry[i][j] = histry[i][j];
                                }
                                temp_histry[temp_histry.length - 1][0] = Customer_data[account_no][1];
                                temp_histry[temp_histry.length - 1][1] = From;
                                temp_histry[temp_histry.length - 1][2] = To;
                                temp_histry[temp_histry.length - 1][3] = PNR + nPNR++;
                                temp_histry[temp_histry.length - 1][4] = detail[c][5];
                                temp_histry[temp_histry.length - 1][5] = Customer_data[account_no][2];
                                temp_histry[temp_histry.length - 1][6] = detail[c][4];
                                temp_histry[temp_histry.length - 1][7] = seat_h;
                                temp_histry[temp_histry.length - 1][8] = sn;
                                temp_histry[temp_histry.length - 1][9] = "" + (int) prize * nsn;
                                temp_histry[temp_histry.length - 1][10] = "" + ++d + " / " + ++m + " / 2024";
                                temp_histry[temp_histry.length - 1][11] = "  ";
                                histry = new String[temp_histry.length][12];
                                for (int i = 0; i < temp_histry.length; i++) {
                                    for (int j = 0; j < histry[i].length; j++)
                                        histry[i][j] = temp_histry[i][j];
                                }
                                System.out.println();
                                System.out.println("     Ticket details");
                                System.out.println();
                                System.out.println("PNR No: " + histry[histry.length - 1][3]);
                                System.out.println("Tripe code: " + histry[histry.length - 1][4]);
                                System.out.println("Class: " + histry[histry.length - 1][6]);
                                System.out.println("Date: " + histry[histry.length - 1][10]);
                                System.out.println("From: " + histry[histry.length - 1][1]);
                                System.out.println("To: " + histry[histry.length - 1][2]);
                                System.out.println("Seat No: " + histry[histry.length - 1][7]);
                                System.out.println("Passengers: " + histry[histry.length - 1][8]);
                                System.out.println("Total money: " + histry[histry.length - 1][9]);
                            }
                        }
                    }
                }
            }
        }

    }

    void seat(int c, int n, int a, int b, int m, int d) {
        boolean l1 = true;
        boolean l2 = true;
        int ts = 0;
        boolean sa = false;
        for (; l1;) {
            System.out.print("Enter total No. of Passangers: ");
            ts = s_to_i();
            if (ts == 0)
                System.out.println("No. of passengers can not be Zero");
            else if (ts > 6)
                System.out.println("No. of passengers can not be grather than 6");
            else if (ts == -1 || ts == -2)
                l1 = false;
            else if (ts == -2)
                homeloop = false;
            else if (ts < -2)
                System.out.println("Enter valid passangers");
            else
                l1 = false;
            sn = sn + ts;
            nsn = ts;
        }
        if (ts > 0) {
            int x = a;
            int y = b;
            boolean tsa = true;
            int ta = 0;
            String l = "";
            seat_h = "";
            for (int i = 1; i <= ts && tsa; i++) {
                l2 = true;
                for (; l2;) {
                    boolean cnf = false;
                    ta = -19;
                    for (int v = 0; v < seat_position[c][n][a][m][d].length; v++) {
                        sa = false;
                        x = a;
                        for (x = a; x < y; x++) {
                            if (seat_position[c][n][x][m][d][v].equals("*"))
                                sa = true;
                        }
                        if (sa)
                            System.out.print("  *");
                        else {
                            System.out.print(seat_position[c][n][a][m][d][v] + " ");
                            ta++;
                        }
                    }
                    if (ts < ta) {
                        System.out.println("Enter passoenger " + i + " seat no:");
                        String psn = sc.next();
                        if (!psn.equals("*")) {
                            l = "";
                            for (int v = 0; v < seat_position[c][n][a][m][d].length; v++) {
                                x = a;
                                for (x = a; x < y; x++) {
                                    if (seat_position[c][n][x][m][d][v].equals(psn)) {
                                        l = seat_position[c][n][x][m][d][v];
                                        seat_position[c][n][x][m][d][v] = "*";
                                        cnf = true;
                                        l2 = false;
                                        break;
                                    }
                                }
                            }
                            if (!cnf)
                                System.out.println("No seat found");
                            else
                                System.out.println("Seat selacted");
                        } else
                            System.out.println("Enter valid seat no");
                    } else {
                        tsa = false;
                        System.out.println("Abailable seats are less then requested seats.");
                        seat(c, n, a, b, m, d);
                        break;
                    }
                }
                if (i < ts)
                    seat_h = seat_h + l + ", ";
                else
                    seat_h = seat_h + l;
            }
        }
    }

    void time_printer(int m) {
        if (m >= 1440)
            m = m - 1440;
        int h = m / 60;
        m = m % 60;
        if (h < 10) {
            if (m < 10)
                System.out.print("0" + h + ":0" + m + ":00");
            else
                System.out.print("0" + h + ":" + m + ":00");
        } else {
            if (m < 10)
                System.out.print(h + ":0" + m + ":00");
            else
                System.out.print(h + ":" + m + ":00");
        }

    }

    void cancellation() {
        boolean l1 = true;
        boolean l2 = true;
        boolean back = false;
        boolean t = false;
        boolean z = false;
        String p = "";
        String m = "";
        for (; l1;) {
            System.out.print("Enter PNR no:");
            p = sc.next();
            if (p.equals("back")) {
                back = true;
                l1 = false;
            } else {
                for (int i = 0; i < histry.length; i++) {
                    if (p.equals(histry[i][3])) {
                        for (; l2;) {
                            t = true;
                            System.out.print("Enter mobile no:");
                            m = sc.next();
                            if (m.equalsIgnoreCase("back")) {
                                l1 = false;
                                l2 = false;
                                back = true;
                            } else {

                                l1 = false;
                                l2 = false;
                                z = true;
                                System.out.println();
                                System.out.println("Ticket Cancelled.");
                                System.out.println();
                                histry[i][11] = "\n TICKET CANCELLED";
                            }
                        }
                    }
                }
            }
            if (!t)
                System.out.println("Invalid PNR No.");
            else if (!z)
                System.out.println("Invalid mobile No.");
        }
    }

    void track() {
        boolean lp = true;
        for (; lp;) {
            System.out.print("Enter PNR No.:");
            String p = sc.next();
            if (p.equalsIgnoreCase("back") || p.equalsIgnoreCase("exit"))
                lp = false;
            else if (p.equalsIgnoreCase("exit"))
                homeloop = false;
            else {
                for (int i = 0; i < histry.length; i++) {
                    if (p.equals(histry[i][3])) {
                        for (int j = 0; j < detail.length; j++) {
                            if (histry[i][4].equals(detail[j][5])) {
                                System.out.println("     Tracking Information");
                                System.out.println();
                                System.out.println("Vehicle No: " + detail[j][2]);
                                System.out.println("Route : " + route_name[j][0] + " - "
                                        + route_name[j][route_name[j].length - 1]);
                                System.out.println("Driver name: " + detail[i][0]);
                                System.out.println("Conductor name: " + detail[i][1]);
                                System.out.println("TRIPCODE: " + detail[i][5]);
                                System.out.println("Enter any for back");
                                sc.next();
                                lp = false;
                            }
                        }
                    }
                }
            }
        }
    }

    void viewticket() {
        System.out.println("    Track Ticket");
        System.out.print("Enter PNR No: ");
        String pnr = sc.next();
        for (int i = 0; i < histry.length; i++) {
            if (histry[i][3].equals(pnr)) {
                System.out.println("     Ticket details");
                System.out.println("PNR No: " + histry[i][3]);
                System.out.println("Tripe code: " + histry[i][4]);
                System.out.println("Class: " + histry[i][6]);
                System.out.println("From: " + histry[i][1]);
                System.out.println("To: " + histry[i][3]);
                System.out.println("Seat No: " + histry[i][7]);
                System.out.println("Passengers: " + histry[i][8]);
                System.out.println("Total money: " + histry[i][9]);
                System.out.println(histry[i][11]);
            }
        }
        System.out.println("Enter any for back");
        sc.next();
    }

    void timetable() {
        boolean p1 = true;
        boolean p2 = true;
        String From = "";
        String To = "";
        for (; p1;) {
            System.out.print("From: ");
            From = sc.next().toLowerCase();
            for (int i = 0; i < route_name.length; i++) {
                for (int j = 0; j < route_name[i].length; j++) {
                    if (From.equals(route_name[i][j]))
                        p1 = false;
                }
            }
            if (From.equalsIgnoreCase("back") || From.equalsIgnoreCase("exit"))
                p1 = false;
            if (p1)
                System.out.println("No station found");
        }
        if (From.equalsIgnoreCase("back")) {
        } else if (From.equalsIgnoreCase("exit")) {
            homeloop = false;
        } else {
            for (; p2;) {
                System.out.print("To: ");
                To = sc.next().toLowerCase();
                for (int i = 0; i < route_name.length; i++) {
                    for (int j = 0; j < route_name[i].length; j++) {
                        if (To.equals(route_name[i][j]))
                            p2 = false;
                    }
                }
                if (To.equalsIgnoreCase("back") || To.equalsIgnoreCase("exit"))
                    p2 = false;
                if (p2)
                    System.out.println("No station found");
            }
            if (To.equalsIgnoreCase("back")) {
            } else if (To.equalsIgnoreCase("exit"))
                homeloop = false;
            else {
                int count = 1;
                int m = 0;
                int d = 0;
                sn = "";
                seat_h = "";
                boolean lp1 = true;
                boolean lp2 = true;
                for (; lp1;) {
                    System.out.println("Enter month");
                    m = s_to_i();
                    if (m > 0 && m <= 3)
                        lp1 = false;
                    else if (m == -1 || m == -2) {
                    } else
                        System.out.println("You can not book ticket before 2 months");
                }
                if (m == -2)
                    homeloop = false;
                else if (m == -1) {
                } else {
                    for (; lp2;) {
                        System.out.println("Enter date");
                        d = s_to_i();
                        if (d == -1 || d == -2)
                            lp2 = false;
                        else if (d == -2)
                            homeloop = false;
                        else if (m == m0 && d < d0)
                            System.out.println("You can not book in past");
                        else if (d >= -2) {
                            if (m == 1) {
                                if (d <= 31) {
                                    lp2 = false;
                                }
                            } else if (m == 2) {
                                if (d <= 29) {
                                    lp2 = false;
                                }
                            } else if (m == 3) {
                                if (d <= 31) {
                                    lp2 = false;
                                }
                            }
                        }
                        if (lp2)
                            System.out.println("Enter valid date");
                    }
                    if (d > 0) {
                        for (int i = 0; i < route_name.length; i++) {
                            boolean validity1 = false;
                            boolean validity2 = false;
                            for (int j = 0; j < route_name[i].length; j++) {
                                if (route_name[i][j].equals(From)) {
                                    validity1 = true;
                                    a = j;
                                }
                                if (route_name[i][j].equals(To)) {
                                    validity2 = true;
                                    b = j;
                                    c = i;
                                }
                            }
                            if (validity1 == true && validity2 == true) {
                                if (a < b) {
                                    km = route_km[i][b] - route_km[i][a];
                                    if (km <= 100)
                                        prize = km * 1;
                                    else if (km <= 250 && km > 100)
                                        prize = km * 0.90;
                                    else if (km > 250 && km <= 400)
                                        prize = km * 0.80;
                                    else if (km > 400 && km <= 600)
                                        prize = km * 0.70;
                                    else if (km > 600 && km <= 800)
                                        prize = km * 0.65;
                                    else
                                        prize = km * 0.60;
                                    for (int l = 0; l < base_timing[i].length; l++) {
                                        System.out.println("Bus " + count++);
                                        System.out.println(" ________________________________________");
                                        System.out.print("|" + detail[i][4]);
                                        int spc = detail[i][4].length() + 4;
                                        if ((int) prize < 10)
                                            spc += 1;
                                        else if ((int) prize >= 10 && (int) prize < 100)
                                            spc += 2;
                                        else if ((int) prize >= 100 && (int) prize < 1000)
                                            spc += 3;
                                        else
                                            spc += 4;
                                        for (int x = 0; x < 40 - spc; x++)
                                            System.out.print(" ");
                                        System.out.println("INR " + (int) prize + "|");
                                        System.out.print("|" + route_name[i][0] + " - "
                                                + route_name[i][route_name[i].length - 1]);
                                        for (int h = 4 + route_name[i][0].length()
                                                + route_name[i][route_name.length - 1].length(); h < 41; h++)
                                            System.out.print(" ");
                                        System.out.print("|\n|");
                                        time_printer(base_timing[i][l] + base_route_time[i][a]);
                                        System.out.print("  ------");
                                        time_printer(base_route_time[i][b] - base_route_time[i][a]);
                                        System.out.print("------ ");
                                        time_printer(base_timing[i][l] + base_route_time[i][b]);
                                        System.out.print(" |");
                                        System.out.println();
                                        System.out.print("|Tripcode : " + detail[0][5]);
                                        for (int h = 12 + detail[0][5].length(); h < 41; h++)
                                            System.out.print(" ");
                                        System.out.println("|\n|________________________________________|");
                                    }
                                }
                                break;
                            }
                        }
                    }
                    if (count == 1)
                        System.out.println("Sorry, no bus service is available for your selection");
                }
            }
        }
        System.out.println("Enter any for back");
        sc.next();
    }

    void bookticket(String pickup, String drop) {
        for (int i = 0; i < route_name.length; i++) {
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
            prize = km * 1;
        else if (km <= 250 && km > 100)
            prize = km * 0.95;
        else if (km > 250 && km <= 400)
            prize = km * 0.90;
        else if (km > 400 && km <= 600)
            prize = km * 0.80;
        else if (km > 600 && km <= 800)
            prize = km * 0.75;
        else
            prize = km * 0.70;
        System.out.println();
        if (km != 0) {
            System.out.println("            GSRTC             ");
            centerprinter(depot_name);
            System.out.println("NO:00" + ticket_no + "            " + travel_bus);
            System.out.println(date0 + "            " + time2);
            ticket_no++;
            String destination = pickup + " -- " + drop;
            centerprinter(destination);
            System.out.println("   TOT. DISTANCE :   " + km + " KMS");
            km = 0;
            System.out.println("TCLL:0.00   INS:0.00   HR:0.00");
            System.out.println("          " + (int) prize + " RUPEES");
        } else
            System.out.println("No such route found for " + pickup + " to " + drop);
        System.out.println("\nEnter any for back");
        sc.next();
    }

    void view() {
        System.out.println("     Transaction History");
        boolean v = false;
        for (int i = 0; i < histry.length; i++) {
            if (Customer_data[account_no][2].equals(histry[i][5])) {
                v = true;
                System.out.println();
                System.out.println("PNR No: " + histry[i][3]);
                System.out.println("Tripe code: " + histry[i][4]);
                System.out.println("Class: " + histry[i][6]);
                System.out.println("From: " + histry[i][1]);
                System.out.println("To: " + histry[i][3]);
                System.out.println("Seat No: " + histry[i][7]);
                System.out.println("Passengers: " + histry[i][8]);
                System.out.println("Total money: " + histry[i][9]);
                System.out.println(histry[i][11]);
                System.out.println("\nEnter any for back");
                sc.next();
            }
        }
        if (!v)
            System.out.println("No transaction found");
        System.out.println("Enter any for back ");
        sc.next();
    }
    public static void main(String[] args) {
        System.out.println();
        System.out.println("      Welcome To GSRTC");
        BUS12 obj = new BUS12();
        obj.seat_set();
        obj.Account_find();
    }
}