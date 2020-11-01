import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;

import javax.net.SocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            Arguments arguments = Arguments.from(args);

            Socket socket = SocketFactory.getDefault().createSocket(arguments.getIpAddress(), arguments.getPort());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("connection closed by remote host.");

        } catch (IOException i) {
            System.out.println("failure processing connection: " + i.getMessage());

        } catch (ParseException e) {
            new HelpFormatter().printHelp( "java -jar Tael.jar -i <IP_ADDRESS> -p <PORT>", new Arguments());
        }
    }
}
