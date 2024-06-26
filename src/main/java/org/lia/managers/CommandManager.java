package org.lia.managers;

import org.lia.commands.*;
import org.lia.models.Product;
import org.lia.tools.ReplaceProductCommand;
import org.lia.tools.Response;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.PortUnreachableException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**CommandManager class. Provides operations with commands*/
public class CommandManager {

    private Map<String, Command> commandsManager = new HashMap<>();
    private DatagramSocket ds;
    private DatagramPacket dp;
    private InetAddress host;
    private int port;


    /**Constructor. Loading of available commands*/
    public CommandManager() {

        commandsManager.put("help", new HelpCommand(this));
        commandsManager.put("add", new AddCommand());
        commandsManager.put("info", new InfoCommand());
        commandsManager.put("show", new ShowCommand());
        commandsManager.put("update", new UpdateCommand(this));
        commandsManager.put("remove_by_id", new RemoveByIdCommand());
        commandsManager.put("clear", new ClearCommand());
        commandsManager.put("exit", new ExitCommand(this));
        commandsManager.put("remove_head", new RemoveHeadCommand());
        commandsManager.put("add_if_max", new AddIfMaxCommand());
        commandsManager.put("remove_lower", new RemoveLowerCommand());
        commandsManager.put("min_by_id", new MinByIdCommand());
        commandsManager.put("count_by_part_number", new CountByPartNumberCommand());
        commandsManager.put("print_field_ascending_manufacturer", new PrintFieldAscendingManufacturerCommand());
        commandsManager.put("execute_script_file_name", new ExecuteScriptFileNameCommand(this));
        commandsManager.put("get_by_id", new GetByIdCommand());

        try {
            ds = new DatagramSocket();
            host = InetAddress.getLocalHost();
            port = 6789;
            ds.connect(host, port);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**Execution of a line (line could be readen from file)*/
    public void executeCommand(String line) {
        String[] tokens = line.split(" ");
        Command command = commandsManager.get(tokens[0]);
        try {
            command.execute(tokens);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            if (tokens[0].equals("update")) {
                ReplaceProductCommand replaceProductCommand = new ReplaceProductCommand(command.product, getProductById("get_product_by_id " + tokens[1]));
                oos.writeObject(replaceProductCommand);
                ds.send(new DatagramPacket(baos.toByteArray(), baos.size(), host, port));
                byte[] secondaryBuffer = new byte[1 << 16 - 1];
                DatagramPacket packetFromServer = new DatagramPacket(secondaryBuffer, 1 << 16 - 1);
                ds.receive(packetFromServer);
                secondaryBuffer = packetFromServer.getData();
                try {
                    ByteArrayInputStream bos = new ByteArrayInputStream(secondaryBuffer);
                    ObjectInputStream objectOutputStream = new ObjectInputStream(bos);
                    Response response = (Response) objectOutputStream.readObject();
                    response.getAnswer().forEach(System.out::println);
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else if (!tokens[0].equals("help") & !tokens[0].equals("execute_script_file_name")) {
                oos.writeObject(command);
                ds.send(new DatagramPacket(baos.toByteArray(), baos.size(), host, port));
                byte[] secondaryBuffer = new byte[1 << 17 - 1];
                DatagramPacket packetFromServer = new DatagramPacket(secondaryBuffer, 1 << 17 - 1);
                ds.receive(packetFromServer);
                secondaryBuffer = packetFromServer.getData();
                try {
                    ByteArrayInputStream bos = new ByteArrayInputStream(secondaryBuffer);
                    ObjectInputStream objectOutputStream = new ObjectInputStream(bos);
                    Response response = (Response) objectOutputStream.readObject();
                    response.getAnswer().forEach(System.out::println);
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e);
            System.out.println("Incorrect command. Use help to see a list of available commands");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Incorrect number of arguments, please try again");
        } catch (PortUnreachableException e) {
            System.out.println("Server is currently unavailable, please try later");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public Product getProductById(String line) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            Command command = new GetByIdCommand();
            command.execute(line.split(" "));
            oos.writeObject(command);
            ds.send(new DatagramPacket(baos.toByteArray(), baos.size(), host, port));
            byte[] secondaryBuffer = new byte[1 << 16 - 1];
            DatagramPacket packetFromServer = new DatagramPacket(secondaryBuffer, 1 << 16 - 1);
            ds.receive(packetFromServer);
            secondaryBuffer = packetFromServer.getData();
            try {
                ByteArrayInputStream bos = new ByteArrayInputStream(secondaryBuffer);
                ObjectInputStream objectOutputStream = new ObjectInputStream(bos);
                Response response = (Response) objectOutputStream.readObject();
                return response.getProduct();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (NullPointerException e) {
            System.out.println(e);
            System.out.println("Incorrect command. Use help to see a list of available commands");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Incorrect number of arguments, please try again");
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    public void executeFromCommandLine() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> ");
        while(sc.hasNext()) {
            String line = sc.nextLine();
            executeCommand(line);
            System.out.print("> ");
        }
    }

    public Map<String, Command> getCommandsList() {
        return commandsManager;
    }


}