import java.net.ServerSocket;
import java.io.*;
import java.net.*;

public class server {
    public static void main(String args[])
            throws Exception
    {
        //create server socket
        ServerSocket ss = new ServerSocket(888);

        //koneksi ke client socket
        Socket s = ss.accept();
        System.out.println("Berhasil koneksi");

        //mengirimkan data ke client
        PrintStream ps = new PrintStream(s.getOutputStream());

        //membaca data dari client
        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(
                                s.getInputStream()
                        )
                );

        // membaca input dari keyboard
        BufferedReader kb = new BufferedReader(
                new InputStreamReader(System.in)
        );

        //server berjalan terus
        while (true) {
            String str, str1;

            //lanjut jika client tidk memasukkan NULL data
            while((str = br.readLine()) != null) {
                System.out.println(str);
                str1 = kb.readLine();

                //send to client
                ps.println(str1);
            }

            //matikan koneksi
            ps.close();
            br.close();
            kb.close();
            ss.close();
            s.close();

            //matikan aplikasi
            System.exit(0);
        }
    }
}
