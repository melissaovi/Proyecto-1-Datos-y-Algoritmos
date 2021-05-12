package sockets.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        ServerSocket server = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        final int PUERTO = 5000;

        try {
            server = new ServerSocket(PUERTO); // Crea uel socket
            System.out.println("Servidor iniciado");

            while (true) {

                sc = server.accept(); // Acepta al cliente
                in = new DataInputStream(sc.getInputStream()); // con esto recibe datos del cliente
                out = new DataOutputStream(sc.getOutputStream()); // con esto envia datos al cliente

                String mensaje = in.readUTF(); // guarda el mensaje del cliente en la variable mensaje
                System.out.println(mensaje);

                out.writeUTF("¡Hola Mundo desde el servidor!"); // Envia un mensaje al cliente

                sc.close(); // cierra la coneccion con el cliente
                System.out.println("Cliente desconectado");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
