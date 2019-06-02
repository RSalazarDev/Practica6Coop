/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dam03
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Cliente> cli = new ArrayList<Cliente>();
        ArrayList<CuentaBancaria> cue = new ArrayList<CuentaBancaria>();
        ArrayList<String> tran = new ArrayList<String>();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bienvenido elija la opción \n 1.Crear Cliente \n 2.Crear Cuenta"
                + " \n 3.Ingresar Dinero \n 4.Retirar Dinero \n 5.Modificar Datos Cliente \n 6.Transferir \n 7.Ultimos movimientos");
        int opcion = teclado.nextInt();
        
        if (opcion == 1){
            System.out.println("Escriba un nombre");
            String nombre = teclado.nextLine();
            System.out.println("Escriba un apellido");
            String apellido = teclado.nextLine();
            System.out.println("Escriba una direccion");
            String direccion = teclado.nextLine();
            System.out.println("Escriba un telefono");
            String telefono = teclado.nextLine();
            System.out.println("Escriba una edad");
            int edad = teclado.nextInt();
            System.out.println("Escriba un codigo");
            int codigo = teclado.nextInt();
            
            
            Cliente client = new Cliente(nombre,apellido,direccion,telefono,edad,codigo);
            cli.add(client);
            
        }
        else if (opcion == 2){
            System.out.println("Escriba un nombre de cuenta");
            String nombreC = teclado.nextLine();
            System.out.println("Escriba un saldo");
            int saldo = teclado.nextInt();
            System.out.println("Escriba un codigo identificador");
            String identificador = teclado.nextLine();
            System.out.println("Escriba una cuenta");
            String cuenta = teclado.nextLine();
            
            CuentaBancaria cuenta = new CuentaBancaria(nombreC,saldo,identificador,cuenta);
            cue.add(cuenta);
        }
        else if (opcion == 3){
            if (cue.size()==0){
                System.out.println("No se ha podido ya que no hay cuentas creadas");
            }else{
                System.out.println("Escriba el nombre de la cuenta");
                String nombreCu = teclado.nextLine();
                System.out.println("Escriba la cantidad");
                int cantidad = teclado.nextInt();
                
                //Recorremos el array de cuentas
                for( int i = 0 ; i < cue.size() ; i++ ){
                    
                CuentaBancaria tmp = cue.get(i);
                //Si coincide con la escrita le añadimos el saldo;
                if (nombreCu.equals(tmp.getNombreC)){
                    //Metodo de la clase CuentaBancaria
                    tmp.ingresarSaldo(cantidad);
                    cue.add(i, tmp);
                    System.out.println("Ingresado con éxito");
                }
        
                }
                
                //Si ninguna coincide salimos
       
            }
        }
        

        else if (opcion == 4){
                if (cue.size()==0){
                System.out.println("No se ha podido ya que no hay cuentas creadas");
            }else{
                System.out.println("Escriba el nombre de la cuenta");
                String nombreCu = teclado.nextLine();
                System.out.println("Escriba la cantidad a retirar");
                int cantidad = teclado.nextInt();
                
                //Recorremos el array de cuentas
                for( int i = 0 ; i < cue.size() ; i++ ){
                    
                CuentaBancaria tmp = cue.get(i);
                //Si coincide con la escrita le añadimos el saldo;
                if (nombreCu.equals(tmp.getNombre)){
                    //Metodo de la clase CuentaBancaria
                    tmp.retirarSaldo(cantidad);
                    cue.add(i, tmp);
                    System.out.println("Retirado con éxito");
                }
        
                }
                
                //Si ninguna coincide salimos
       
            }
        }else if (opcion == 5){
            System.out.println("Escriba el nombre del cliente");
            String nombrCliente = teclado.nextLine();
            
                for( int i = 0 ; i < cli.size() ; i++ ){
                    
                Cliente tmp = cli.get(i);
                //Si coincide con la escrita le añadimos el saldo;
                if (nombreCliente.equals(tmp.getNombre)){
                    
                    //Metodo de la clase Cliente
                    
                    System.out.println("Escriba una nueva direccion y teléfono");
                    String direccion = teclado.nextLine();
                    System.out.println("Escribe un nuevo telefono");
                    String telef = teclado.nextLine();
                    tmp.setDireccion(direccion);
                    tmp.setTelefono(telef);
                    cue.add(i, tmp);
                    System.out.println("Modificado con éxito");
                }
        
                }

        }else if (opcion == 6){
            System.out.println("Escriba el nombre de la cuenta origen:");
            String cuentaOrigen = teclado.nextLine();
            System.out.println("Cuenta destino :");
            String cuentaDestino = teclado.nextLine();
            System.out.println("Saldo a transferir");
            int saldo = teclado.nextInt();
            
            for( int i = 0 ; i < cue.size() ; i++ ){
                    
                CuentaBancaria tmp = cue.get(i);
                //Si coincide con la escrita le añadimos el saldo;
                if (cuentaOrigen.equals(tmp.getNombre) && (tmp.tieneSaldo(saldo)==true)){
                    
                    tmp.setSaldo(tmp.getSaldo - saldo);
                    
                    
                }else if (cuentaDestino.equals(tmp.getNombre)){
                    tmp.setSaldo(tmp.getSaldo + saldo);
                }
        
                }
            
            tran.add("Cuenta " + cuentaOrigen + " Destino " + cuentaDestino + " Saldo " + saldo);
            
        }else if (opcion == 7){
            for (int i = 0 ; i < tran.size(); i++){
                System.out.println(tran.get(i).toString());
            }
        }
        
        
    }
    
}
