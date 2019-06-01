/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

/**
 *
 * @author dam03
 */
public class Cliente {
    String nombre,apellidos,direccion,telefono;
    int edad,codigo;

    public Cliente(String nombre, String apellidos, String direccion, String telefono, int edad, int codigo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.edad = edad;
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", telefono=" + telefono + ", edad=" + edad + ", codigo=" + codigo + '}';
    }

  
}
