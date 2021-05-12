package sockets.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class client {


    public static void main(String[] args) {

        final String HOST = "127.0.0.1";
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;

        try {

            Socket sc = new Socket(HOST, PUERTO); // crea el socket

            in = new DataInputStream(sc.getInputStream()); // Para recibir los mensajes del servidor
            out = new DataOutputStream(sc.getOutputStream()); // Para envar los mensajes al servidor

            out.writeUTF("Hola Mundo desde el cliente!"); // envia el mensaje al cliente
            String mensaje = in.readUTF(); // Lee el mensaje de respuesta del servidor

            System.out.println(mensaje);
            sc.close(); // cierra la coneccion

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
