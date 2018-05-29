
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafael Alipio Harada
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Object[] itens = {"1","2","3"};
        JOptionPane.showOptionDialog(null, "1- coisaz\n2- outro\n3- Bka", "asd", 0, JOptionPane.INFORMATION_MESSAGE, null, itens, itens[0]);
        Object[] itens2 = {"dadasdads","2","3"};
        JOptionPane.showOptionDialog(null, "1- coisaz\n2- outro\n3- Bka", "asd", 0, JOptionPane.INFORMATION_MESSAGE, null, itens2, itens2[0]);
    
        Sistema sistema = new Sistema();
        sistema.apresentarMenu();
    }
    
}
