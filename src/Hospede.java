
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sara
 */
public class Hospede {
  //TODO Nome
    //TODO Idade
    //TODO Sexo
    //TODO Check-in
    //TODO Check-out
    //TODO Quarto
    //TODO Receita Cliente

    static String[] nomes = new String[0];
    int[] idades = new int[0];
    char[] sexos = new char[0];
    int[] checkin = new int[0];
    static int[] checkout = new int[0];
    static int[] quartos = new int[0];
    static int[] status = new int[0];
    double[] receita = new double[0];

    int atual = 0;
    private int menuHospedes;

    public void Cadastrar() {
        if (atual == 0) {
            for (int i = 0; i < status.length; i++) {
                status[i] = 0;
            }
        }
        solicitarInformacao(atual);
        atual++;
    }

    public void menu() {
        Object[] options = {"Cadastrar Hóspedes", "Editar Hóspedes", "Listar Hóspedes", "Pesquisar por nome", "Pesquisar por Check-In", "Pesquisar por Check-Out", "Finalizar"};
            int menu = 0;
    
            while (menu != 7) {
                menu = JOptionPane.showOptionDialog(
                        null,
                        "Administração Hoteleira\n\n"
                        + "Selecione uma das opções abaixo:",
                        "Administração da Biblioteca de Hóspedes",
                        0,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[7]
                );
    
            while (menuHospedes != 7) {
                switch (menuHospedes) {
                    case 1:
                        Cadastrar();
                        break;
                    case 2:
                        Editar();
                        break;
                    case 3:
                        Listar();
                        break;
                    case 4:
                        PesquisarPorNome();
                        break;
                    case 5:
                        PesquisarPorCheckIn();
                        break;
                    case 6:
                        PesquisarPorCheckOut();
                        break;
                    case 7:
                        return;
    
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida");
                }
            }
        }
    }
        public void atualizacaoHospede(){
            nomes = new String[Hotel.hotelQuartos];
            idades = new int[Hotel.hotelQuartos];
            sexos = new char[Hotel.hotelQuartos];
            checkin = new int[Hotel.hotelQuartos];
            checkout = new int[Hotel.hotelQuartos];
            quartos = new int[Hotel.hotelQuartos];
            status = new int[Hotel.hotelQuartos];
            receita = new double[Hotel.hotelQuartos];
        if ( atual == 0){
            for (int i = 0; i < status.length; i++){
                status [i] = 0;
            }
        }
    }

    public void Editar() {
        String procurar = (String) JOptionPane.showInputDialog("Digite o nome do hóspede para editar :");
        for (int i = 0; i < atual; i++) {
            if (nomes[i].contains(procurar)) {
                solicitarInformacao(i);
                return;
            }
        }
    }

    public void Listar() {
        String texto = "";
        for (int i = 0; i < atual; i++) {
            texto += "Nome : "             + nomes[i]
                    + "\nIdade : "         + idades[i]
                    + "\nSexo : "          + sexos[i]
                    + "\nCheck-in : "      + checkin[i]
                    + "\nCheck-out : "     + checkout[i]
                    + "\nSQuarto : "       + quartos[i]
                    + "\nReceita : "       + receita[i];
        }
    }

    public void PesquisarPorNome() {
        String pesquisar = (String) JOptionPane.showInputDialog(" Digite o nome do hóspede para pesquisar :");
        for (int i = 0; i < atual; i++) {
            if (nomes[i].contains(pesquisar)) {
                apresentarInformacao(i);
            }
        }
    }

    public void PesquisarPorCheckIn() {
        String pesquisar = (String) JOptionPane.showInputDialog(" Digite o nome do hóspede para pesquisar :");
        for (int i = 0; i < atual; i++) {
            if (("" + checkin[i]).contains(pesquisar)) {
                apresentarInformacao(i);
            }
        }
    }

    public void PesquisarPorCheckOut() {
        String pesquisar = (String) JOptionPane.showInputDialog(" Digite a data de check-out para pesquisar :");
        for (int i = 0; i < atual; i++) {
            if (("" + checkout[i]).contains(pesquisar)) {
                apresentarInformacao(i);
            }
        }
    }

    public void editarQuarto() {
        if (Quarto.adicionador != 0) {
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum quarto está cadastrado.\nCadastre um quarto para editar.", "Ops...", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void apresentarInformacao(int posicao) {
        JOptionPane.showMessageDialog(null,
                "Nome: "                   + nomes[posicao]
                + "\nIdade: "              + idades[posicao]
                + "\nSexo: "               + sexos[posicao]
                + "\nCheck-in: "           + checkin[posicao]
                + "\nCheck-out: "          + checkout[posicao]
                + "\nNº do quarto: "       + quartos[posicao]
                + "\nReceita: "            + receita[posicao]);

    }

    public void solicitarInformacao(int posicao) {
        nomes[posicao] = (String) JOptionPane.showInputDialog(
                "Informe o nome do funcionário :");
        idades[posicao] = Integer.parseInt((String) JOptionPane.showInputDialog(
                "Digite a idade deste funcionário: "));
        checkin[posicao] = Integer.parseInt(JOptionPane.showInputDialog(
                "Digite a data de check-in deste hóspede: "));
        checkout[posicao] = Integer.parseInt(JOptionPane.showInputDialog(
                "Digite a data de check-out deste hóspede: "));
        quartos[posicao] = Integer.parseInt(JOptionPane.showInputDialog(
                "informe o quarto em que este hóspede alugou: "));
        receita[posicao] = Double.parseDouble(JOptionPane.showInputDialog(
                "Informe a receita deste hóspede"));

        status[posicao] = 1;

    }

}
