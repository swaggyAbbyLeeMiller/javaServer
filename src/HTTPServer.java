import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class HTTPServer {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Finding connection on port 8080");

        while (true){
            try (Socket socket = server.accept()){
                Date today = new Date();
                String response = "HTTP1.1 200 OK\r\n\r\n" + today;
                socket.getOutputStream().write(response.getBytes("UTF-8"));
            }
        }

    }
}
