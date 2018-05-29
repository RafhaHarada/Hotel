
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
public class Funcionario {
    //TODO Nome
    //TODO Idade
    //TODO Sexo
    //TODO Cargo
    //TODO Carga horária
    //TODO Salário
    //TODO Desempenho

    int cadastrosAtual = 0;
    String[] nomes = new String[1000];
    int[] idades = new int[1000];
    char[] sexos = new char[1000];
    String[] cargos = new String[1000];
    int[] cargasHorarias = new int[1000];
    double[] salarios = new double[1000];
    String[] desempenhos = new String[1000];
    Object[] options = {"Cadastrar","Editar","Listar","Pesquisar pelo nome","Pesquisar pelo cargo","Voltar"};
    int atual = 0;

    public void cadastrar() {
        solicitarInformacao(atual);
        atual++;
    }

    public void menu() {
        int menu = JOptionPane.showOptionDialog(null,
                        "Escolha referente a tarefa que deseje executar:\n",
                        "Funcionários",
                        0,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]
                        );

        while (menu != 6) {
            switch (menu) {
                case 0:
                    cadastrar();
                    break;
                case 1:
                    Editar();
                    break;
                case 2:
                    Listar();
                    break;
                case 3:
                    PesquisarPeloNome();
                    break;
                case 4:
                    PesquisarPeloCargo();
                    break;
                case 5:
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
            menu = JOptionPane.showOptionDialog(null,
                        "Escolha referente a tarefa que deseje executar:\n",
                        "Funcionários",
                        0,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]
                        );

        }
    }

    public void Editar() {
        String procurar = JOptionPane.showInputDialog(
                "Informe o nome  para editar");
        for (int i = 0; i < atual; i++) {
            if (nomes[i].equals(procurar)) {
                solicitarInformacao(i);
                return;
            }
        }
    }

    public void Listar() {
        String texto = "";
        if (atual > 0) {
            for (int posicao = 0; posicao < atual; posicao++) {
                texto += "Acompanhe abaixo a listagem dos funcionários:"
                        + "\n"
                        + "\nNome : " + nomes[posicao]
                        + "\nIdade : " + idades[posicao] + " anos"
                        + "\nSexo : " + sexos[posicao]
                        + "\nCargo : " + cargos[posicao]
                        + "\nCarga Horária : " + cargasHorarias[posicao] + " horas"
                        + "\nSalário : R$" + String.format("%.2f", salarios[posicao])
                        + "\nDesempenho : " + desempenhos[posicao]
                        + "\n";
            }
        } else {
            texto = "Nenhum funcionário está cadastrado!";
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    public void PesquisarPeloNome() {
        String buscar = JOptionPane.showInputDialog(
                "Digite o nome do funcionário para pesquisar :");
        for (int i = 0; i < atual; i++) {
            if (nomes[i].contains(buscar)) {
                apresentarInformacao(i);
            }
        }
    }

    public void PesquisarPeloCargo() {
        String buscar = JOptionPane.showInputDialog(
                "Digite o cargo para pesquisar funcionários :");
        for (int i = 0; i < atual; i++) {
            if (cargos[i].contains(buscar)) {
                apresentarInformacao(i);
            }
        }
    }

    public void apresentarInformacao(int posicao) {
        JOptionPane.showMessageDialog(null,
                "Acompanhe abaixo as informações sobre os funcionários:"
                + "\n"
                + "\nNome: " + nomes[posicao]
                + "\nIdade: " + idades[posicao]
                + "\nSexo: " + sexos[posicao]
                + "\nCargo: " + cargos[posicao]
                + "\nCarga Horária: " + cargasHorarias[posicao]
                + "\nSalário: " + salarios[posicao]
                + "\nDesempenho: " + desempenhos[posicao]
                + "\n");

    }

    public void solicitarInformacao(int posicao) {
        int numCadastros = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe o número de funcionários que deseja cadastrar:"
        ));
        for (int i = 0; i < numCadastros; i++) {
            nomes[posicao] = JOptionPane.showInputDialog(
                    "Digite o nome do funcionário :");
            idades[posicao] = Integer.parseInt(JOptionPane.showInputDialog(
                    "Informe a idade deste funcionário :"));
            sexos[posicao] = JOptionPane.showInputDialog(
                    "Digite o sexo deste funcionário :"
                            + "\n"
                            + "\nSe o funcionário for do sexo Feminino digite 'F'"
                            + "\nmas se o funcionário for do sexo masculino  digite 'M'"
                            + "\n").charAt(0);
            cargos[posicao] = JOptionPane.showInputDialog(
                    "Digite o cargo que este funcionário exerce :");
            cargasHorarias[posicao] = Integer.parseInt(JOptionPane.showInputDialog(
                    "Digite a carga horária deste funcionário :"));
            salarios[posicao] = Double.parseDouble(JOptionPane.showInputDialog(
                    "Digite o salário deste funcionário :",
                    salarios[posicao] != 0 ? salarios[posicao] : 0)
                    .replace(" ", "").replace("R$", "")
                    .replace(".", "").replace(",", ".")
            );
            desempenhos[atual] = JOptionPane.showInputDialog(
                    "Descreva o desempenho deste funcionário :");
        }
        
    }
    
}
