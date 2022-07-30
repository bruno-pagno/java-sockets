import java.io.DataInputStream;
import java.io.EOFException;
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

        String receivedMessage = null;
        do {
            try {
                receivedMessage = input.readUTF();
                System.out.println("Received message: " + receivedMessage);
            } catch (EOFException eof) {
                System.out.println("Error: client disconnected");
                System.exit(1);
            }
        } while (!receivedMessage.equals("bye"));
        input.close();
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(5555);
        System.out.println("Server is up. Waiting for connection");
        Socket socket = server.acceptConnections();
        System.out.println("Connection stablished. Waiting for messages");
        server.listenForMessages(socket);
        System.out.println("end of communication");
        socket.close();
    }
}