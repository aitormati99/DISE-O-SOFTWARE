package cliente.main;


import cliente.controller.Controller;
import servidor.façada.IFaçada;

import java.rmi.RemoteException;


public class Main {

    //private static Controller controller;

    public static void main(String [] args) throws RemoteException
    {
        //controller= new Controller(args);
        new Controller(args);
    }

}
