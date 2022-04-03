package FileIO;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class fileIO {

    public static void WriteToFile(String txtToWrite){
        try {
            File f = new File("Files//OrderNumFile.txt");
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
            byte[] strToBytes = txtToWrite.getBytes();

            dos.writeUTF(txtToWrite);

            dos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String ReadFromFile(){
        String strText = "";

        DataInputStream dis = null;
        try {
            
            File f = new File("Files//OrderNumFile.txt");
            dis = new DataInputStream(new BufferedInputStream(new FileInputStream(f)));
            strText = dis.readUTF();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strText;
    }
}
