import javax.xml.crypto.Data;
import java.io.*;
import java.net.*;

public class client {
    public static void main(String args[])
            throws Exception
    {
        // create client socket
        Socket s = new Socket("localhost", 888);

        //kirim data ke server
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        //membaca data yang datang dari server
        BufferedReader br = new BufferedReader(new InputStreamReader(
                s.getInputStream()
        ));

        //membaca data yang masuk dari keyboard
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
        String str, str1;

        //ulang terus sampai client tidak menekan exit
        while(!(str = kb.readLine()).equals("exit")) {

            //kirim ke server
            dos.writeBytes(str + "\n");

            //menerima dari server
            str1 = br.readLine();

            System.out.println(str1);
        }

        //menutup koneksi
        dos.close();
        br.close();
        kb.close();
        s.close();
    }
}
