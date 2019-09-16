
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando Alberto
 */
public class Cliente {

    static String ip;
    static int numsocket;
    static Socket socket;
    
    public static void main(String[] args) throws Exception{
        try{
        if(args[0]!=null){
            ip= args[0];
        }else{
            System.out.println("Escriba una ip valida");
            System.exit(0);
        }
        }catch(Exception e){System.out.println("Escriba una ip valida");
            System.exit(0);}
        try{
        if(args[1]!=null){
            try {
                numsocket= Integer.parseInt(args[1]);
            } catch (Exception e) {System.out.println("Escriba un socket valido");
            System.exit(1);}
        }else{
            System.out.println("Escriba un socket valido");
            System.exit(2);
        }
        }catch(Exception e){System.out.println("Escriba un socket valido");
            System.exit(2);}
        try{
        socket= new Socket(ip, numsocket);
        }catch(Exception e){System.out.println("Hubo un eror al crear el socket");System.exit(3);}
        PrintWriter escritor=new PrintWriter(socket.getOutputStream(),true);
        BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String datos;
        String datosEntrada;
        Scanner scanner=new Scanner(System.in);
        while(true) {
            if(!(datos=scanner.nextLine()).isEmpty()){
                escritor.println(datos);
                datosEntrada=lector.readLine();
                System.out.println(datosEntrada);
            }else{
                System.out.println("Escriba un mensaje valido");
            }
        }
    }
    
}
