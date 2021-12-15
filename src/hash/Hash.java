/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

/**
 *
 * @author viane
 */
public class Hash {
    public int dato;
    public String datos,Nombre,sueldo;
    public int estado; //0 = Vacío, 1 = Eliminado, 2 = Ocupado

    public static int funcion(int n, int m) {
        return ((n + 1) % m);
    }
    
    public static void insertaHash(Hash[] h, int m, int n, String nombre,String suel) {
        boolean i = false;
        int j = funcion(n, m);
        do {
            if (h[j].estado == 0 || h[j].estado == 1) {
                h[j].dato = n;
                h[j].estado = 2;
                h[j].datos="\nNumero de trabajador:\t"+n+"\nNombre:\t"+nombre+"\nSalario:\t"+suel;
                i = true;
            } else {
                j++;
            }
        } while (j < m && !i);
        if (i) {
            javax.swing.JOptionPane.showMessageDialog(null, "¡Elemento insertado con éxito!");
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "¡Tabla llena!");
        }
    }
        public static String buscaHash(Hash[] h, int m, int n) {
        int j = funcion(n, m);
        while (j < m) {
            if (h[j].estado == 0) {
                return "-1";
            } else if (h[j].dato == n) {
                if (h[j].estado == 1) {
                    return "-1";
                } else {
                   return h[j].datos;
                    
                }
            } else {
                j++;
            }
        }
        return "-1";
    }
    public static int eliminaHash(Hash[] h, int m, int n) {
        String i = buscaHash(h, m, n);
        int j=funcion(n,m);
        Boolean v=false;
        if (i == "-1") {
            return -1;
        } else {
            do{
                if(h[j].dato!=n)
                {
                j++;
                }else{
                    v=true;
                }
            }while(!v);
            h[j].estado = 1;
            return 1;
        }
    }
    
    
    public static String mostrarTabla(Hash[] h){
        String contenido="";
        for(int i=0;i<h.length;i++)
        {
            if(h[i].estado==2)
            contenido=contenido+h[i].datos+"\n";
        }
        return contenido;
    }

    
}
