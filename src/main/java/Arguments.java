import org.apache.commons.cli.*;

public class Arguments extends Options {
    private String ipAddress;
    private int port;

    public Arguments() {
        Option pOption = new Option("p", true, "port to connect to PS3 with.");
        pOption.setRequired(true);

        Option iOption = new Option("i", true, "ip address to connect to PS3 with.");
        iOption.setRequired(true);

        addOption(pOption);
        addOption(iOption);

    }

    public static Arguments from(String[] args) throws ParseException {
        Arguments arguments = new Arguments();

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(arguments, args);

        arguments.port = Integer.parseInt(cmd.getOptionValue("p"));
        arguments.ipAddress = cmd.getOptionValue("i");

        return arguments;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public int getPort() {
        return port;
    }
}
