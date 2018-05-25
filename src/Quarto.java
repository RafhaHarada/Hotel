
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
public class Quarto {

    static String quartosMAX[] = new String[0];
    String quartoAvaliacao[] = new String[0];
    String hospede[] = new String[0];
    int quartoAndar[] = new int[0];
    int numero[] = new int[0];
    int quartoTipo[] = new int[0];
    int precoTipo[] = new int[4];
    int quartoCamas[] = new int[0];
    double precoCama[] = new double[4];
    double tamanho[] = new double[0];
    double preco[] = new double[0];
    Object[] options = {"Cadastrar Quarto", "Cadastrados", "Não Cadastrados", "Buscar Quarto", "Editar Quarto", "Voltar"};
    Object[] camas = {"SOLTEIRO", "CASAL", "DUPLO SOLTEIRO", "FAMILIA"};
    Object[] tipo = {"STANDARD", "SUITE", "EXECUTIVO", "DELUXE"};
    Object[] estrelasAvaliacao = {"Escolha Uma Das Opções Abaixo", "★☆☆☆☆", "★★☆☆☆", "★★★☆☆", "★★★★☆", "★★★★★"};
    Object[] andares = new Object[0];
    static int adicionador = 0;

    public void menu() {

        if (tamanho.length == 0) {
            tamanho = new double[Hotel.hotelQuartos];
            quartoTipo = new int[Hotel.hotelQuartos];
            quartoAvaliacao = new String[Hotel.hotelQuartos];
            quartosMAX = new String[Hotel.hotelQuartos];
            preco = new double[Hotel.hotelQuartos];
            andares = new String[Hotel.hotelAndares];
        }

        int menuQuarto = JOptionPane.showOptionDialog(null,
                "Cadastrar Quarto - Cadastrar um novo quarto.\n"
                + "Cadastrados - Listar os quartos cadastrados e status atualmente.\n"
                + "Não Cadastrados - Listar os quartos não cadastrados.\n"
                + "Buscar Quarto - Procura um quarto especifico e mostra suas informações.\n"
                + "Editar Quarto - Edita as informações de um quarto especifico.\n"
                + "Voltar - Volta ao menu anterior.\n",
                "Menu de Quartos",
                0,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        while (menuQuarto != 6) {
            switch (menuQuarto) {
                case 0:
                    cadastrarQuarto();
                    break;
                case 1:
                    cadastradosQuarto();
                    break;
                case 2:
                    naoCadastradosQuarto();
                    break;
                case 3:
                    buscarQuarto();
                    break;
                case 4:
                    editarQuarto();
                    break;
                case 5:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida", "Error 001", JOptionPane.ERROR_MESSAGE);
            }
            menuQuarto = JOptionPane.showOptionDialog(null,
                    "Cadastrar Quarto - Cadastrar um novo quarto.\n"
                    + "Cadastrados - Listar os quartos cadastrados e status atualmente.\n"
                    + "Não Cadastrados - Listar os quartos não cadastrados.\n"
                    + "Buscar Quarto - Procura um quarto especifico e mostra suas informações.\n"
                    + "Editar Quarto - Edita as informações de um quarto especifico.\n"
                    + "Voltar - Volta ao menu anterior.\n",
                    "Menu de Quartos",
                    0,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
        }
    }

    public void cadastrarQuarto() {
        if (adicionador == 0) {
            JOptionPane.showMessageDialog(null,
                    "Antes de Cadastrar os quartos, é necessário atribuir os preços.\n"
                    + "Lembrando que preço irá ser calculado baseado nos tipos e camas.\n"
                    + "Os tipos levam os verdadeiros preços, enquanto as camas são um\n"
                    + "fator de multiplicação, como no exemplo abaixo:"
                    + "Preço do Quarto = 120*1,5 = R$180,00\nOnde 120 seria o Tipo e 1,5 a cama.\n",
                    "Informação",
                    JOptionPane.INFORMATION_MESSAGE
            );
            for (int i = 0; i < 4; i++) {
                precoTipo[i] = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Tipos de Quartos:\n"
                        + "\n-STANDARD: Quarto com mobilia comum e serviços básicos "
                        + "\n-SUITE: Standard com banheiro e maior qualidade de mobilia e serviços"
                        + "\n-EXECUTIVO: Suite com sala e maior qualidade de mobilia e serviços"
                        + "\n-DELUXE: Executivo com cozinha e maior qualidade de mobilia e serviços\n"
                        + "\nInsira o preço a ser cobrado dos tipos " + tipo[i].toString(),
                        "Valor por Tipo",
                        JOptionPane.QUESTION_MESSAGE));
            }
            for (int i = 0; i < 4; i++) {
                precoCama[i] = Double.parseDouble(JOptionPane.showInputDialog(null,
                        "Classificação por pessoa de Quartos:\n"
                        + "\n-SOLTEIRO: Quarto com uma cama de solteiro"
                        + "\n-CASAL: Quarto com uma cama de casal"
                        + "\n-DUPLO SOLTEIRO: Quarto com duas camas de solteiros"
                        + "\n-FAMILIA: Quarto com uma camas de casal e uma beliche para dois\n"
                        + "\nInsira o preço a ser cobrado das camas " + camas[i].toString(),
                        "Valor por Camas",
                        JOptionPane.QUESTION_MESSAGE));
            }
        }
        if (adicionador == Hotel.hotelQuartos) {
            JOptionPane.showMessageDialog(null, "Você já cadastrou o número máximo de quartos.", "Ops...", JOptionPane.WARNING_MESSAGE);
        } else {
            solicitacaoQuarto(adicionador);
            adicionador++;
        }
    }

    public void buscarQuarto() {
        String texto = "";
        if (adicionador != 0) {
            int busca = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha o quarto a ser editado.", "Editar", JOptionPane.QUESTION_MESSAGE));
            for (int i = 0; i < numero.length; i++) {
                if (numero[i] == busca) {
                    solicitacaoQuarto(i);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum quarto está cadastrado.", "Ops...", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void editarQuarto() {
        if (adicionador != 0) {
            Object auxiliar[] = new Object[adicionador];
            for (int i = 0; i < adicionador; i++) {
                auxiliar[i] = numero[i];
            }
            String escolha = JOptionPane.showInputDialog(null, "Escolha o quarto a ser editado.", "Editar", JOptionPane.QUESTION_MESSAGE, null, auxiliar, auxiliar[0]).toString();
            for (int i = 0; i < numero.length; i++) {
                if (numero[i] == Integer.parseInt(escolha)) {
                    solicitacaoQuarto(i);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum quarto está cadastrado.\nCadastre um quarto para editar.", "Ops...", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void cadastradosQuarto() {
        if (adicionador != 0) {
            String texto = "";
            for (int i = 0; i < numero.length; i++) {

                texto += "Quarto nº" + numero[i] + "\n";

            }
            JOptionPane.showMessageDialog(null, "Os quartos cadastrados são:\n" + texto, "Quartos Cadastrados", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum quarto está cadastrado.", "Ops...", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void naoCadastradosQuarto() {
        if (adicionador != 0) {
            String texto = "";
            for (int i = 1; i <= numero.length; i++) {
                for (int j = 0; j < numero.length; j++) {
                    if (i != numero[j]) {
                        texto += "Quarto nº" + i + "\n";
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Os quartos não cadastrados são:\n" + texto, "Quartos Não Cadastrados", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum quarto está cadastrado.", "Ops...", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void solicitacaoQuarto(int posicao) {
        tamanho[posicao] = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o tamanho do Quarto:", "Cadastro Quarto", JOptionPane.QUESTION_MESSAGE));
        while (tamanho[adicionador] <= 8) {
            JOptionPane.showMessageDialog(null, "Insira um tamanho maior que 8m²", "Ops...", JOptionPane.WARNING_MESSAGE);
            tamanho[adicionador] = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite novamente o tamanho do Quarto:", "Cadastro Quarto", JOptionPane.QUESTION_MESSAGE).replace(",", "."));
        }
        quartoTipo[posicao] = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Tipos de Quartos:\n"
                + "\n-STANDARD: Quarto com mobilia comum e serviços básicos "
                + "\n-SUITE: Standard com banheiro e maior qualidade de mobilia e serviços"
                + "\n-EXECUTIVO: Suite com sala e maior qualidade de mobilia e serviços"
                + "\n-DELUXE: Executivo com cozinha e maior qualidade de mobilia e serviços",
                "Cadastro do Quarto",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tipo,
                tipo[0])
                .toString());
        while (posicao > 3 && posicao < 0) {
            quartoTipo[posicao] = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Tipos de Quartos:\n"
                    + "\n-STANDARD: Quarto com mobilia comum e serviços básicos "
                    + "\n-SUITE: Standard com banheiro e maior qualidade de mobilia e serviços"
                    + "\n-EXECUTIVO: Suite com sala e maior qualidade de mobilia e serviços"
                    + "\n-DELUXE: Executivo com cozinha e maior qualidade de mobilia e serviços",
                    "Cadastro do Quarto",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    tipo,
                    tipo[0])
                    .toString());
        }
        preco[posicao] = precoTipo[quartoTipo[posicao]];
        quartoCamas[posicao] = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Classifique o quarto por pessoa:"
                + "\nOBS:Classificação por pessoa de Quartos:\n"
                + "\n-SOLTEIRO: Quarto com uma cama de solteiro"
                + "\n-CASAL: Quarto com uma cama de casal"
                + "\n-DUPLO SOLTEIRO: Quarto com duas camas de solteiros"
                + "\n-FAMILIA: Quarto com uma camas de casal e uma beliche para dois\n",
                "Cadastro do Quarto",
                JOptionPane.QUESTION_MESSAGE,
                null,
                camas,
                camas[0]).toString());

        preco[posicao] *= precoCama[quartoCamas[posicao]];

        while (posicao > 3 && posicao < 0) {
            quartoCamas[posicao] = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Classifique o quarto por pessoa:"
                    + "\nOBS:Classificação por pessoa de Quartos:\n"
                    + "\n-SOLTEIRO: Quarto com uma cama de solteiro"
                    + "\n-CASAL: Quarto com uma cama de casal"
                    + "\n-DUPLO SOLTEIRO: Quarto com duas camas de solteiros"
                    + "\n-FAMILIA: Quarto com uma camas de casal e uma beliche para dois\n",
                    "Cadastro do Quarto",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    camas,
                    camas[0]).toString());
        }
        numero[posicao] = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número do Quarto", "Cadastro Quarto", JOptionPane.QUESTION_MESSAGE));
        while (numero[posicao] <= 0 || numero[posicao] > quartosMAX.length) {
            int count = 0;
            int anterior = count;
            for (int i = 0; i < numero.length; i++) {
                if (numero[posicao] == numero[i]) {
                    JOptionPane.showMessageDialog(null, "Nenhum quarto está cadastrado.", "Ops...", JOptionPane.WARNING_MESSAGE);
                    numero[posicao] = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite novamente o número do Quarto", "Cadastro Quarto", JOptionPane.QUESTION_MESSAGE));
                    count++;
                }
            }
            if (numero[posicao] <= 0 || numero[posicao] > quartosMAX.length) {
                JOptionPane.showMessageDialog(null, "O número inserido não é válido.\nInsira um número entre 1 e " + Hotel.hotelQuartos + ".", "Ops...", JOptionPane.WARNING_MESSAGE);
                numero[posicao] = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite novamente o número do Quarto", "Cadastro Quarto", JOptionPane.QUESTION_MESSAGE));
                count++;
            }
            if (count == anterior) {
                break;
            }
        }
        quartoAvaliacao[posicao] = JOptionPane.showInputDialog(null,
                "Por favor coloque a avaliação atual do quarto:",
                "Cadastro do Hotel",
                JOptionPane.QUESTION_MESSAGE,
                null,
                estrelasAvaliacao,
                estrelasAvaliacao[0])
                .toString();

        for (int i = 0; i < andares.length; i++) {
            andares[i] = (i + 1) + "º Andar";

        }
        quartoAndar[posicao] = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o andar em que o quarto está:", "Cadastro Quarto", JOptionPane.QUESTION_MESSAGE, null, andares, andares[0]).toString());
        while (quartoAndar[posicao] < 0 || quartoAndar[posicao] > Hotel.hotelAndares) {
            JOptionPane.showMessageDialog(null, "O número inserido não é válido.\nInsira um número entre 1 e " + Hotel.hotelAndares + ".", "Ops...", JOptionPane.WARNING_MESSAGE);
            quartoAndar[posicao] = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite novamente o andar em que o quarto está:", "Cadastro Quarto", JOptionPane.QUESTION_MESSAGE));
        }

    }

    private void infoQuarto() {
        if (adicionador != 0) {
            Object auxiliar[] = new Object[adicionador];
            for (int i = 0; i < adicionador; i++) {
                auxiliar[i] = numero[i];
            }
            String escolha = JOptionPane.showInputDialog(null, "Escolha o quarto a ser editado.", "Editar", JOptionPane.QUESTION_MESSAGE, null, auxiliar, auxiliar[0]).toString();
            for (int i = 0; i < numero.length; i++) {
                if (escolha.equals(Hospede.quartos[i])) {
                    if (Hospede.status[i] == 1) {
                        JOptionPane.showMessageDialog(null,
                                "\nStatus: Ocupado"
                                + "\nNome do Hospede: " + Hospede.nomes[i]
                                + "\nNúmero do quarto: " + Hospede.quartos[i]
                                + "\nTipo do Quarto: " + tipo[quartoTipo[i]]
                                + " para " + camas[quartoCamas[i]]
                                + "Andar: " + andares[i]
                                + "\nDesocupação:" + Hospede.checkout[i],
                                "Informações do Quarto" + escolha.toString(),
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "\nStatus: Desocupado"
                                + "\nNúmero do quarto: " + Hospede.quartos[i]
                                + "\nTipo do Quarto: " + tipo[quartoTipo[i]]
                                + " para " + camas[quartoCamas[i]]
                                + "Andar: " + andares[i]
                                + "\nPreço: R$" + String.format("%.2f", preco[i]),
                                "Informações do Quarto" + escolha.toString(),
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum quarto está cadastrado.\nCadastre um quarto para editar.", "Ops...", JOptionPane.WARNING_MESSAGE);
        }

    }
}
