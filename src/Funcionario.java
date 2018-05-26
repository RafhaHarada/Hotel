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
    int atual = 0;

    public void cadastrar() {
        solicitarInformacao(atual);
        atual++;
    }

    public void menuFuncionarios() {
        int menuFuncionarios = Integer.parseInt(
                JOptionPane.showInputDialog(null,
                        "1 - Cadastrar funcionários"
                        + "\n2 - Editar funcionários"
                        + "\n3 - Listar funcionários"
                        + "\n4 - Pesquisar pelo nome"
                        + "\n5 - Pesquisar pelo cargo"
                        + "\n6 - Finalizar", "",
                        JOptionPane.QUESTION_MESSAGE));

        while (menuFuncionarios != 6) {
            switch (menuFuncionarios) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    Editar();
                    break;
                case 3:
                    Listar();
                    break;
                case 4:
                    PesquisarPeloNome();
                    break;
                case 5:
                    PesquisarPeloCargo();
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
            menuFuncionarios = Integer.parseInt(
                    JOptionPane.showInputDialog(null,
                            "1 - Cadastrar funcionários"
                            + "\n2 - Editar funcionários"
                            + "\n3 - Listar funcionários"
                            + "\n4 - Pesquisar pelo nome"
                            + "\n5 - Pesquisar pelo cargo"
                            + "\n6 - Finalizar", "",
                            JOptionPane.QUESTION_MESSAGE));
            ;
        }
    }

    public void Editar() {
        String procurar = (String) JOptionPane.showInputDialog("Informe o nome  para editar");
        for (int i = 0; i < atual; i++) {
            if (nomes[i].equals(procurar)) {
                solicitarInformacao(i);
                return;
            }
        }
    }

    public void Listar() {
        String texto = "";
        for (int i = 0; i < atual; i++) {
            texto += "Nome : " + nomes[i]
                    + "\nIdade : " + idades[i]
                    + "\nSexo : " + sexos[i]
                    + "\nCargo : " + cargos[i]
                    + "\nCarga Horária : " + cargasHorarias[i]
                    + "\nSalário : " + salarios[i]
                    + "\nDesempenho : " + desempenhos[i];

        }
        JOptionPane.showMessageDialog(null, texto);
    }

    public void PesquisarPeloNome() {
        String buscar = (String) JOptionPane.showInputDialog("Digite o nome do funcionário para pesquisar :");
        for (int i = 0; i < atual; i++) {
            if (nomes[i].contains(buscar)) {
                apresentarInformacao(i);
            }
        }
    }

    public void PesquisarPeloCargo() {
        String buscar = (String) JOptionPane.showInputDialog("Digite o cargo para pesquisar funcionários :");
        for (int i = 0; i < atual; i++) {
            if (cargos[i].contains(buscar)) {
                apresentarInformacao(i);
            }
        }
    }

    public void apresentarInformacao(int posicao) {
        JOptionPane.showMessageDialog(null,
                "Nome: " + nomes[posicao]
                + "\nIdade: " + idades[posicao]
                + "\nSexo: " + sexos[posicao]
                + "\nCargo: " + cargos[posicao]
                + "\nCarga Horária: " + cargasHorarias[posicao]
                + "\nSalário: " + salarios[posicao]
                + "\nDesempenho: " + desempenhos[posicao]);

    }

    /**
     *
     * @param posicao
     */
        
        public void solicitarInformacao(int posicao) {
        int numCadastros = Integer.parseInt(JOptionPane.showInputDialog(
            "Infrome o número de funcionários que deseje cadastrar : "));
        int cadastros = 0;
        while (numCadastros <0){
        nomes[posicao] = JOptionPane.showInputDialog(
                "Digite o nome do funcionário :");
        idades[posicao] = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe o sexo deste funcionário : "));
        sexos[posicao] = JOptionPane.showInputDialog(
                nomes[posicao] + " digite o seu sexo").charAt(0);
        cargos[posicao] = JOptionPane.showInputDialog(
                "Digite o cargo que este funcionário exerce :");
        cargasHorarias[posicao] = Integer.parseInt(JOptionPane.showInputDialog(
                "Digite a carga horária deste funcionário :"));
        salarios[atual] = Double.parseDouble(JOptionPane.showInputDialog(
                "Digite o salário deste funcionário :"));
        desempenhos[atual] = JOptionPane.showInputDialog(
                "Descreva o desemepenho deste funcionário :");

        double menorSalario = Double.MAX_VALUE;

        double maiorSalario = Double.MIN_VALUE;

        for (int i = 0; i > 2; i++) {

            if (salarios[posicao] < menorSalario) {
                menorSalario = salarios[posicao];
            }
            if (salarios[posicao] > maiorSalario) {
                maiorSalario = salarios[posicao];
              }
            }

        }

    }

}
