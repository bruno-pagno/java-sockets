import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;

    Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    private Socket acceptConnections() throws IOException {
        return this.serverSocket.accept();
    }

    private void listenForMessages(Socket socket) throws IOException {
        DataInputStream input = new DataInputStream(socket.getInputStream());
        String receivedMessage = input.readUTF();
        System.out.println("Received message: " + receivedMessage);
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(5555);
        Socket socket = server.acceptConnections();
        server.listenForMessages(socket);
    }
}