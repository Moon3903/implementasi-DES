import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.IOException;


public class Main {
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_RESET = "\u001B[0m";

  public static void main(String[] args) throws IOException {
// Step 1 : Create a socket to listen at port 1234
    DatagramSocket ds = new DatagramSocket(1234);
    byte[] receive = new byte[65535];
    DesController desController = new DesController();
    RSA rsa = new RSA();

    DatagramPacket DpReceive;

    ClientThread clientThread = new ClientThread();

    clientThread.start();

    while (true) {
      // Step 2 : create a DatgramPacket to receive the data.
      DpReceive = new DatagramPacket(receive, receive.length);

      // Step 3 : revieve the data in byte buffer.
      ds.receive(DpReceive);

      System.out.println("received " + data(receive));
      System.out.println("Client:-" + desController.decryptDes(rsa.decryptString(data(receive))));

      // Clear the buffer after every message.
      receive = new byte[65535];
    }
//    INIBUATTESTINK
//    AABB0918AABB0918
//    BB0918AABB0918BB
  }

  // A utility method to convert the byte array
  // data into a string representation.
  public static StringBuilder data(byte[] a)
  {
    if (a == null)
      return null;
    StringBuilder ret = new StringBuilder();
    int i = 0;
    while (a[i] != 0)
    {
      ret.append((char) a[i]);
      i++;
    }
    return ret;
  }
}