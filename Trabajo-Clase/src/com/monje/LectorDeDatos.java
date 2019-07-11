package com.monje;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LectorDeDatos {

    //los metodos estaticos no estan ligados a objetos, sino a las clases
    public static int solicitarEntero(String mensaje){
        Scanner lector = new Scanner(System.in);
        System.out.print(mensaje);

        try {
            int numero = lector.nextInt();
            return numero;
        }catch (InputMismatchException e){
            System.out.println("El dato ingresado no es valido");
            return solicitarEntero(mensaje);
        }
    }

    public static double solicitarDoble (String texto){
        Scanner lector = new Scanner(System.in);
        System.out.print(texto);

        try {
            double numeroDouble = lector.nextDouble();
            return numeroDouble;
        }catch (InputMismatchException e){
            System.out.println("El dato ingresado no es valido");
            return solicitarDoble(texto);
        }
    }
}
