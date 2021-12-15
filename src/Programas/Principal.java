/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programas;

import hash.Hash;
import javax.swing.JTextArea;

/**
 *
 * @author JGA_G
 */
public class Principal {
    public static void main(String[] args) {
        try {
            int i, n, resp;
            String nom;
            String sue;
            int m = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese el numeros de empleados a registrar"));
            Hash[] h = new Hash[m];
            for (i = 0; i < m; i++) {
                h[i] = new Hash();
                h[i].estado = 0;
            }
            do {
                resp = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Registro de empleados\nElige una Opcion "
                        + "\n1.Insertar\n2.Buscar\n3.Eliminar\n4.Mostrar empleados\n5.Salir"));
                switch (resp) {
                    case 1:
                        n = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese el número de empleado a registrar:"));
                        nom =(javax.swing.JOptionPane.showInputDialog("Ingrese el nombre del empleado"));
                        sue=(javax.swing.JOptionPane.showInputDialog("Ingrese el salario del empleado"));
                        Hash.insertaHash(h, m, n,nom,sue);
                        break;
                    case 2:
                        n = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese el número de empleado a buscar"));
                        String buscar = Hash.buscaHash(h, m, n);
                        if (buscar == "-1") {
                            javax.swing.JOptionPane.showMessageDialog(null, "Numero de empleado no encontrado");
                        } else {
                            javax.swing.JOptionPane.showMessageDialog(null, new JTextArea(buscar));
                        }
                        break;
                    case 3:
                        n = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese el número de empleado a ser eliminado"));
                        i = Hash.eliminaHash(h, m, n);
                        if (i == -1) {
                            javax.swing.JOptionPane.showMessageDialog(null, "Número de empleado no encontrado");
                        } else {
                            javax.swing.JOptionPane.showMessageDialog(null, "Número de empleado eliminado con éxito");
                        }
                        break;
                    case 4:
                        javax.swing.JOptionPane.showMessageDialog(null,new JTextArea(Hash.mostrarTabla(h)));
                        break;
                    case 5:
                        System.exit(0);
                    default:
                }
            } while (resp != 5);
        } catch (NumberFormatException nfe) {
            javax.swing.JOptionPane.showMessageDialog(null, "Está Saliendo del Programa");
        } catch (OutOfMemoryError ome) {
            javax.swing.JOptionPane.showMessageDialog(null, "No Hay Espacio");
        }
    }
}
