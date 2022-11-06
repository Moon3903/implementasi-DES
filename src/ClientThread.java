import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientThread extends Thread {
  public void run() {
    try {
      this.client();
    } catch(IOException e) {
      System.out.println(e);
    }
  }
  public void client() throws IOException {
    Scanner sc = new Scanner(System.in);

    DesController desController = new DesController();

    // Step 1:Create the socket object for
    // carrying the data.
    DatagramSocket ds = new DatagramSocket();

    InetAddress ip = InetAddress.getByName("192.168.88.138");
    byte buf[] = null;

    // loop while user not enters "bye"
    while (true) {
      String inp = desController.encrypDes(new StringBuilder(sc.nextLine()));
      System.out.println("Sending " + inp);

      // convert the String input into the byte array.
      buf = inp.getBytes();

      // Step 2 : Create the datagramPacket for sending
      // the data.
      DatagramPacket DpSend =
          new DatagramPacket(buf, buf.length, ip, 1234);

      // Step 3 : invoke the send call to actually send
      // the data.
      ds.send(DpSend);

      // break the loop if user enters "bye"
      if (inp.equals("bye")) {
        break;
      }
    }
  }
}
