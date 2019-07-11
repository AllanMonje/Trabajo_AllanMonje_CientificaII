package com.monje;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Cuenta> cuentas = new ArrayList();
        Scanner lector = new Scanner(System.in);
        System.out.println("*************************");
        System.out.println("\tBienvenido");
        System.out.println("*************************");
        while (true){
            System.out.println("1.  Crear una cuenta");
            System.out.println("2.  Depositar");
            System.out.println("3.  Retirar");
            System.out.println("4.  Mostrar informacion de una cuenta");
            System.out.println("5.  Mostrar cuentas");
            System.out.println("6.  Salir");
            int opcion = LectorDeDatos.solicitarEntero("Ingrese una opcion:");
           // int opcion = lector.nextInt();
            switch (opcion){
                case 1:
                    int r=0;
                    while (r==0) {
                        System.out.println("** Creando una cuenta **");
                        Random rand = new Random();
                        int numeroCuenta = rand.nextInt(1000);
                        System.out.println("Su numero de cuenta sera: " + numeroCuenta);
                        System.out.println("Especifique el tipo de cuenta que desea crear");
                        System.out.println("\t1.Cuenta de ahorro");
                        System.out.println("\t2.Cuenta a largo plazo");
                        int tipoCuenta = LectorDeDatos.solicitarEntero("Ingrese una opcion:");
                        //System.out.print("Ingrese el saldo inicial: ");
                        //double saldo = lector.nextDouble();
                        double saldo = LectorDeDatos.solicitarDoble("Ingrese el saldo inicial:");
                        if (tipoCuenta == 1) {
                            CuentaAhorro nuevaCuenta = new CuentaAhorro();
                            nuevaCuenta.numCuenta = numeroCuenta;
                            nuevaCuenta.saldo = saldo;
                            cuentas.add(nuevaCuenta);
                        } else if (tipoCuenta == 2) {
                            CuentaLargoPlazo nuevaCuenta = new CuentaLargoPlazo();
                            nuevaCuenta.numCuenta = numeroCuenta;
                            nuevaCuenta.saldo = saldo;
                            cuentas.add(nuevaCuenta);
                        } else {
                            System.out.println("Tipo de cuenta no existe");
                        }
                        System.out.println("La cuenta ha sido creada!");
                        System.out.println("¿Desea crear otra cuenta? SI(0) NO(-1)");
                        r = lector.nextInt();
                    }
                    break;
                case 2:
                    int i=0;
                    while (i == 0) {
                    System.out.println("** Depositos **");
                        int cuentaDepositar = LectorDeDatos.solicitarEntero("Ingrese el numero de cuenta a depositar:");
                    for (Cuenta c: cuentas) {
                        if (cuentaDepositar ==c.numCuenta){
                            double deposito = LectorDeDatos.solicitarDoble("Ingrese el monto:");

                            c.depositar(deposito);
                            System.out.println("Saldo actual: "+c.saldo);
                        }else if (cuentaDepositar !=c.numCuenta){
                            System.out.println("Cuenta inexistente");
                        }

                    }
                    System.out.println("¿Desea continuar realizando Depositos? SI(0) NO(-1)");
                    i = lector.nextInt();
            }
                    break;
                case 3:
                    int q=0;
                    while (q == 0) {
                        System.out.println("** Retiros **");
                        int cuentaRetirar = LectorDeDatos.solicitarEntero("Ingrese el numero de cuenta:");
                        for (Cuenta c : cuentas) {
                            if (cuentaRetirar == c.numCuenta) {
                                double montoRetiro = LectorDeDatos.solicitarDoble("Ingrese el monto a retirar:");

                                c.retirar(montoRetiro);
                                System.out.println("Saldo actual: " + c.saldo);
                            } else if (cuentaRetirar != c.numCuenta) {
                                System.out.println("Cuenta inexistente");
                            }

                        }
                        System.out.println("¿Desea continuar realizando Retiros? SI(0) NO(-1)");
                        q = lector.nextInt();
                    }
                    break;
                case 4:
                    int f=0;
                    while (f == 0) {
                        System.out.println("** Informacion de tu cuenta **");
                        int cuentaInfo= LectorDeDatos.solicitarEntero("Ingrese el numero de Cuenta:");
                        for (Cuenta c : cuentas) {
                            if (cuentaInfo == c.numCuenta) {
                                System.out.println("Numero de cuenta: " + c.numCuenta);
                                System.out.println("Saldo actual: " + c.saldo);
                            } else if (cuentaInfo != c.numCuenta){
                                System.out.println("Cuenta inexistente");
                            }

                        }
                        System.out.println("¿Desea continuar ver informacion de otra cuenta? SI(0) NO(-1)");
                        f = lector.nextInt();
                    }
                    break;
                case 5:
                    // numero de cuenta -  tipo de cuenta
                    if (cuentas.isEmpty()){
                        System.out.println("--No hay cuentas--");
                    }else{
                        System.out.println("**Mostrando cuentas**");
                    }

                    for (Cuenta c :cuentas){
                        String tipo ="";
                        if (c instanceof CuentaAhorro)
                            tipo = "Cuenta de ahorro";
                        else if (c instanceof CuentaLargoPlazo)
                            tipo = "Cuenta a largo plazo";
                        System.out.println("Numero de cuenta: "+ c.numCuenta +" - "+ tipo);
                    }
                    break;
                case 6:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
            if (opcion == 6){
                break;
            }
        }
    }

}
