package org.lia;

import org.lia.managers.CommandManager;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CommandManager commandManager = new CommandManager();
        commandManager.executeFromCommandLine();

    }
}