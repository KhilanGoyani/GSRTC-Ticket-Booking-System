import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

class FilesCreator{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("RouteName.txt"));
        br.readLine();
        String h=br.readLine();
        int y=1;
        while (h != null) {
            String[] g = h.split(",");
            String seat = "";
            for (int i = 0; i < g.length-1; i++)
                seat += "0,";
            seat += "0";
            for (int j = 20; j <= 31; j++) {
                BufferedWriter bw = new BufferedWriter(new FileWriter("data/R_" + y + "_AUG_" + j + "_.txt"));
                bw.write(h);
                bw.newLine();
                for (int k = 1; k <= 30; k++){
                    bw.write("" + k + " " + seat);
                    bw.newLine();
                }
                bw.flush();
                bw.close();
            }
            for (int j = 1; j <= 20; j++) {
                BufferedWriter bw = new BufferedWriter(new FileWriter("data/R_" + y + "_SPT_" + j + "_.txt"));
                bw.write(h);
                bw.newLine();
                for (int k = 1; k <= 30; k++){
                    bw.write("" + k + " " + seat);
                    bw.newLine();
                }
                bw.flush();
                bw.close();
            }
            y++;
            h = br.readLine();
            
        }

    }
}