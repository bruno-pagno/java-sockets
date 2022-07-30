import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5555);
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        output.writeUTF("hello world");
    }
}
