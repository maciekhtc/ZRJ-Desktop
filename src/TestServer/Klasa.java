/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestServer;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Maciej
 */
public class Klasa {
    public static void main(String args[]) {
        NewJFrame frame = new NewJFrame();
        frame.setVisible(true);
        listenSocket(frame.getArea());
    }

    public static void listenSocket(JTextArea area) {
        try {
            ServerSocket server = new ServerSocket(8000);
            Socket gniazdo = server.accept();
            InputStream in = gniazdo.getInputStream();
            Scanner sc = new Scanner(in);
            String line;
            while (true) {
                line = sc.nextLine();
                area.append(line+"\r\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(Klasa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchElementException ex) {
            //brak linijki do odczytu
        }
    }

}
