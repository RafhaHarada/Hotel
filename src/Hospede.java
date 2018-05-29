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
    String[] checkin = new String[0];
    static String[] checkout = new String[0];
    static int[] quartos = new int[0];
    static int[] status = new int[0];
    double[] receita = new double[0];

    int atual = 0;
   
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
        atualizacaoHospede();
        Object[] options = {"Cadastrar", "Editar", "Listar", 
            "\nPesquisar por nome", "Pesquisar por Check-In", "Pesquisar por Check-Out", "Voltar"};
            int menu = 0;
    
            while (menu != 6) {
                menu = JOptionPane.showOptionDialog(
                        null,
                        "Administração Hoteleira\n\n"
                        + "Selecione uma das opções abaixo:",
                        "Administração da Biblioteca de Hóspedes",
                        0,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[6]
                );
                switch (menu) {
                    case 0:
                        Cadastrar();
                        break;
                    case 1:
                        Editar();
                        break;
                    case 2:
                        Listar();
                        break;
                    case 3:
                        PesquisarPorNome();
                        break;
                    case 4:
                        PesquisarPorCheckIn();
                        break;
                    case 5:
                        PesquisarPorCheckOut();
                        break;
                    case 6:
                        return;
    
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida");
                }
            
        }
    }
        public void atualizacaoHospede(){
            nomes = new String[Hotel.hotelQuartos];
            idades = new int[Hotel.hotelQuartos];
            sexos = new char[Hotel.hotelQuartos];
            checkin = new String[Hotel.hotelQuartos];
            checkout = new String[Hotel.hotelQuartos];
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
        String procurar = JOptionPane.showInputDialog("Digite o nome do hóspede para editar :");
        for (int i = 0; i < atual; i++) {
            if (nomes[i].contains(procurar)) {
                solicitarInformacao(i);
                return;
            }
        }
    }

    public void Listar() {
        String texto = "";
        if (atual > 0){
        for (int posicao = 0; posicao < atual; posicao++) {
            texto +=    "Acompanhe abaixo a listagem dos hóspedes :"
                    + "\n"
                    + "\nNome : "                        + nomes[posicao]
                    + "\nIdade : "                       + idades[posicao]
                    + "\nSexo : "                        + sexos[posicao]
                    + "\nCheck-in : "                    + checkin[posicao]
                    + "\nCheck-out : "                   + checkout[posicao]
                    + "\nQuarto : "                      + quartos[posicao]
                    + "\nReceita : "                     + receita[posicao]
                    + "\n";
                }
            } else {
                texto = "Nenhum hóspede está cadastrado!";
            }
                    JOptionPane.showMessageDialog(null, texto);
        }

    public void PesquisarPorNome() {
        String pesquisar = JOptionPane.showInputDialog(" Digite o nome do hóspede para pesquisar :");
        for (int i = 0; i < atual; i++) {
            if (nomes[i].contains(pesquisar)) {
                apresentarInformacao(i);
            }
        }
    }

    public void PesquisarPorCheckIn() {
        String pesquisar = JOptionPane.showInputDialog(" Digite o nome do hóspede para pesquisar :");
        for (int i = 0; i < atual; i++) {
            if ((checkin[i]).contains(pesquisar)) {
                apresentarInformacao(i);
            }
        }
    }

    public void PesquisarPorCheckOut() {
        String pesquisar = JOptionPane.showInputDialog(" Digite a data de check-out para pesquisar :");
        for (int i = 0; i < atual; i++) {
            if ((checkout[i]).contains(pesquisar)) {
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
                "Acompanhe abaixo as informações sobre os hóspedes:"
                + "\n"
                + "\nNome: "                        + nomes[posicao]
                + "\nIdade: "                       + idades[posicao]
                + "\nSexo: "                        + sexos[posicao]
                + "\nCheck-in: "                    + checkin[posicao]
                + "\nCheck-out: "                   + checkout[posicao]
                + "\nNº do quarto: "                + quartos[posicao]
                + "\nReceita: "                     + receita[posicao]
                + "\n");

    }

    public void solicitarInformacao(int posicao) {
        int numCadastros = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe o número de hóspedes que deseja cadastrar:"
        ));
		for (int i = 0; i<numCadastros ; i++){
        nomes[posicao] = JOptionPane.showInputDialog(
                "Informe o nome do hóspede :");
        idades[posicao] = Integer.parseInt(JOptionPane.showInputDialog(
                "Digite a idade deste hóspede: "));
        sexos[posicao] = JOptionPane.showInputDialog(
                "Digite o sexo deste hóspede :").charAt(0);
        checkin[posicao] = JOptionPane.showInputDialog(
                "Digite a data de check-in deste hóspede: "
                +"\n"
                +"ATENÇÃO!" 
                +"\n"
                +"Quando for digitar a data de Check-In certifique-se que a data se encaixa nos padrões abaixo:"
                +"\n1 - " +"Se o dia conter apenas um dígito, como por exemplo se o dia for '1' ou '2' ou '9'"
                +"\nacrescente um 0 a frente como no exemplo a seguir: Se o dia for '2' digite '02'"
                +"\n"
                +"\n2 - " +"NÃO digite o nome do mês, DIGITE o número referente ao mês. Como por exemplo: No lugar"
                +"\nde 'Fevereiro' escreva '02'"
                +"\n"
                +"\n3 - " +"Se o número referente ao mês for um número menor que 10, que contém apenas um dígito"
                +"\ncomo por exemplo, 'Fevereiro' que é '2' então escreva '02'"
                +"\n"
                ).replace("-","/").replace("/","");
        checkout[posicao] = JOptionPane.showInputDialog(
                "Digite a data de check-out deste hóspede: "
                +"\n"
                +"ATENÇÃO!"
                +"\n"
                +"Quando for digitar a data de Check-Out certifique-se que a data se encaixa nos padrões abaixo:"
                +"\n1 - " +"Se o dia conter apenas um dígito, como por exemplo se o dia for '1' ou '2' ou '9'"
                +"\nacrescente um 0 a frente como no exemplo a seguir: Se o dia for '2' digite '02'"
                +"\n"
                +"\n2 - " +"NÃO digite o nome do mês, DIGITE o número referente ao mês. Como por exemplo: No lugar"
                +"\nde 'Fevereiro' escreva '02'"
                +"\n"
                +"\n3 - " +"Se o número referente ao mês for um número menor que 10, que contém apenas um dígito"
                +"\ncomo por exemplo, 'Fevereiro' que é '2' então escreva '02'"
                +"\n"
                ).replace("-","/").replace("/","");
        quartos[posicao] = Integer.parseInt(JOptionPane.showInputDialog(
                "informe o quarto em que este hóspede alugou: "));
        receita[posicao] = Double.parseDouble(JOptionPane.showInputDialog(
                "Informe a receita deste hóspede"));

        status[posicao] = 1;
        }
    }

}