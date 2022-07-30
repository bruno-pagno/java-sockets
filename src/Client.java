import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5555);
        System.out.println("Connection stablished. You can now send messages");
        Scanner scanner = new Scanner(System.in);

        String userInput = null;
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        do {
            System.out.print("> ");
            userInput = scanner.nextLine();
            output.writeUTF(userInput);
        } while (!userInput.equals("bye"));

        System.out.println("end of communication");
        output.close();
        socket.close();
    }
}
