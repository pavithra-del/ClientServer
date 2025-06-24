import java.io.*;
import java.net.*;

public class SocketHTTPClient1 {
    public static void main(String[] args) {
        try {
            
            Socket socket = new Socket("www.martinbroadhurst.com", 80);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("GET / HTTP/1.1");
            out.println("Host: www.martinbroadhurst.com");
            out.println("User-Agent: JavaSocketClient/1.0");
            out.println("Connection: close"); 
            out.println();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            boolean isBody = false;

            System.out.println("----- HTTP Response Start -----");
            while ((line = in.readLine()) != null) {
                if (line.isEmpty()) {
                    isBody = true;
                    System.out.println("----- Body Start -----");
                    continue;
                }
                if (!isBody) {
                    System.out.println("Header: " + line);
                } else {
                    System.out.println(line);
                }
            }
            System.out.println("----- HTTP Response End -----");

            in.close();
            out.close();
            socket.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
