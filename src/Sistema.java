
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rafael Alipio Harada
 */
public class Sistema {

    Funcionario funcionario = new Funcionario();
    Quarto quarto = new Quarto();
    Hospede hospede = new Hospede();
    Custos custos = new Custos();
    Receita receita = new Receita();
    Hotel hotel = new Hotel();

    public void apresentarMenu() {
        JOptionPane.showMessageDialog(null, null, "Administration Hotel", JOptionPane.PLAIN_MESSAGE, new ImageIcon(
                Sistema.class.getResource("/imagens/logo.gif"))
        );
        JOptionPane.showMessageDialog(null, "                       Seja Bem Vindo Ao\n                     Administration   Hotel\n", "Administration Hotel", JOptionPane.PLAIN_MESSAGE);

        hotel.Inicializacao();

        Object[] options = {"Hotel","Funcionários", "Quartos", "Hospedes", "Custos", "Receita", "Sair"};
        int menu = 0;

        while (menu != 6) {

            if (Hotel.sair == 1) {
                menu = 6;
            } else {
                menu = JOptionPane.showOptionDialog(
                        null,
                        "Administração Hoteleira\n\n"
                        + "Selecione uma das opções abaixo:",
                        "Administração Hoteleira",
                        0,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]
                );
            }
            switch (menu) {
                case 0:
                    hotel.menu();
                    break;
                case 1:
                    funcionario.menu();
                    break;
                case 2:
                    quarto.menu();
                    break;
                case 3:
                    hospede.menu();
                    break;
                case 4:
                    custos.menu();
                    break;
                case 5:
                    receita.menu();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "O sistema está sendo fechado...", "Fechando Sistema", JOptionPane.WARNING_MESSAGE);
                    return;
            }
        }
    }
}
