import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class dbCreator {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus", "root", "");
        Statement st = conn.createStatement();
        st.executeUpdate("CREATE TABLE bus_details (bus_id	INT,bus_no	VARCHAR(512),Driver_name VARCHAR(512),Conductor_name VARCHAR(512),Stations VARCHAR(512),kms	VARCHAR(512));");
        st.executeUpdate(
                " INSERT INTO bus_details (bus_id, bus_no, Driver_name, Conductor_name, Stations, kms) VALUES('1', 'GJ18Z6633', 'D1', 'C1', 'Kutch,Banaskantha,Sabarkantha,Aravalli,Mahisagar,Dahod,ChotaUdaipur,Narmada,Tapi,Dang,Valsad', '0,268,441,521,586,707,798,894,1013,1082,1193'),('2', 'GJ18Z5500', 'D2', 'C2', 'Kutch,Patan,Mehsana,Gandhinagar,Ahmedabad,Kheda,Panchmahal,Dahod', '0,287,342,401,421,459,572,655'),('3', 'GJ18Z2520', 'D3', 'C3', 'Kutch,Gandhidham,Morbi,Rajkot,Amreli,Bhavnagar', '0,126,250,316,427,546'),('4', 'GJ18Z2233', 'D4', 'C4', 'Kutch,Gandhidham,Morbi,Jamnagar,Porbandar', '0,126,250,353,427'),('5', 'GJ18Z4411', 'D5', 'C5', 'DevbhoomiDwarka,Jamnagar,Rajkot,Amreli,Botad,Ahmedabad,Anand,Vaodara,Bharuch', '0,89,180,291,384,535,612,656,738,814,852,886,942'),('6', 'GJ18Z2510', 'D6', 'C6', 'DevbhoomiDwarka,Porbandar,Junagadh,Girsomnath,Amreli,Bhavnagar,Botad,Ahmedabad,Gandhinagar,Sabarkantha', '0,79,184,291,399,518,619,769,789,891'),('7', 'GJ18Z4545', 'D7', 'C7', 'Bhavnagar,Botad,Ahmedabad,Kheda,Snand,Vadodara,Bharuch,Surat,Bardoli,Navsari,Valsad', '0,101,252,290,330,377,456,532,570,604,660'),('8', 'GJ18Z9696', 'D8', 'C8', 'Sabarkantha,Gandhinagar,Shmedabad,Kheda,Anand,Vadodara,Narmada,Tapi,Dang,Valsad', '0,102,122,160,200,247,339,458,527,638'),('9', 'GJ18Z2323', 'D9', 'C9', 'Banaskantha,Mehsana,Gandhinagar,Ahmedabad,Kheda,Panchmahal,Vadodara,Narmada,Surat', '0,142,219,239,277,390,476,568,706'),('10', 'GJ18Z2525', 'D10', 'C10', 'Patan,Surendranagar,Botad,Bhavnagar', '0,170,256,357'),('11', 'GJ18Z5220', 'D11', 'C11', 'Surat,Bharuch,Narmada,ChotaUdaipur,Panchmahal,Mahisagar', '0,76,151,247,347,404'),('12', 'GJ18Z6263', 'D12', 'C12', 'Valsad,Navsari,Tapi,Narmada,Vadodara', '0,56,157,276,368'),('13', 'GJ18Z8598', 'D13', 'C13', 'Kutch,Patan,Surendranagar,Morbi,Rajkot,Amreli,GirSomnath', '0,287,457,584,650,761,869');");
        st.executeUpdate(
                "CREATE TABLE USERS (user_id INT,name VARCHAR(512),number VARCHAR(512),PASSWORD VARCHAR(512));");
        st.executeUpdate(
                "CREATE TABLE TRANSACTION (user_id INT,bus_id INT,fromS VARCHAR(30),TOS varchar(30),tdate DATE,seats VARCHAR(100))");
        st.executeUpdate(
                "CREATE TABLE cancle (user_id INT,bus_id INT,froms VARCHAR(30),TOs varchar(30),cdate DATE,cseats VARCHAR(100),refund varchar(30));");
    }
}
