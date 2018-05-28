
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

    String quartosMAX[] = new String[0];
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
    Object[] estrelasAvaliacao = {"★☆☆☆☆", "★★☆☆☆", "★★★☆☆", "★★★★☆", "★★★★★"};
    Object[] andares = new Object[0];
    static int adicionador = 0;
    String avaliacaoHotel = "";

    public void menu() {

        if (tamanho.length == 0) {
            quartosMAX = new String[Hotel.hotelQuartos];
            quartoAvaliacao = new String[Hotel.hotelQuartos];
            hospede = new String[Hotel.hotelQuartos];
            quartoAndar = new int[Hotel.hotelAndares];
            numero = new int[Hotel.hotelQuartos];
            quartoTipo = new int[Hotel.hotelQuartos];
            quartoCamas = new int[Hotel.hotelQuartos];
            tamanho = new double[Hotel.hotelQuartos];
            preco = new double[Hotel.hotelQuartos];
            andares = new Object[Hotel.hotelAndares];
            avaliacaoHotel = Hotel.hotelAvaliacao;
            Hospede hospede = new Hospede();
            hospede.atualizacaoHospede();
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
                while (precoTipo[i] <= 0) {
                    try {
                        precoTipo[i] = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Tipos de Quartos:\n"
                                + "\n-STANDARD: Quarto com mobilia comum e serviços básicos "
                                + "\n-SUITE: Standard com banheiro e maior qualidade de mobilia e serviços"
                                + "\n-EXECUTIVO: Suite com sala e maior qualidade de mobilia e serviços"
                                + "\n-DELUXE: Executivo com cozinha e maior qualidade de mobilia e serviços\n"
                                + "\nInsira o preço a ser cobrado dos tipos " + tipo[i].toString(),
                                "Valor por Tipo",
                                JOptionPane.QUESTION_MESSAGE));
                        if (precoTipo[i] <= 0) {
                            JOptionPane.showMessageDialog(null, "Valor inválido!\nUse valores acima de 0.", "Ops...", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro de entrada", "ERRO 001", JOptionPane.ERROR_MESSAGE);
                        precoTipo[i] = 0;
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                while (precoCama[i] <= 0) {
                    try {
                        precoCama[i] = Double.parseDouble(JOptionPane.showInputDialog(null,
                                "Classificação por pessoa de Quartos:\n"
                                + "\n-SOLTEIRO: Quarto com uma cama de solteiro"
                                + "\n-CASAL: Quarto com uma cama de casal"
                                + "\n-DUPLO SOLTEIRO: Quarto com duas camas de solteiros"
                                + "\n-FAMILIA: Quarto com uma camas de casal e uma beliche para dois\n"
                                + "\nInsira o preço a ser cobrado das camas " + camas[i].toString(),
                                "Valor por Camas",
                                JOptionPane.QUESTION_MESSAGE).replace(",", "."));
                        if (precoCama[i] <= 0) {
                            JOptionPane.showMessageDialog(null, "Valor inválido!\nUse valores acima de 0.", "Ops...", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro de entrada", "ERRO 001", JOptionPane.ERROR_MESSAGE);
                        precoCama[i] = 0;
                    }
                }

            }
            for (int i = 0; i < numero.length; i++) {
                numero[i] = 0;
            }
            for (int i = 0; i < quartoAvaliacao.length; i++) {
                quartoAvaliacao[i] = "";
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
        int contador = 0;
        if (adicionador != 0) {
            int busca = 0;
            while (busca <= 0 || busca > numero.length) {
                try {
                    busca = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha o quarto a ser buscado.", "Editar", JOptionPane.QUESTION_MESSAGE));
                while (busca <= 0 || busca > numero.length) {
                    JOptionPane.showMessageDialog(null, "O número inserido ultrapassa os limites inseridos", "Ops...", JOptionPane.WARNING_MESSAGE);
                    busca = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha novamente o quarto a ser buscado.", "Editar", JOptionPane.QUESTION_MESSAGE));
                }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro de entrada", "ERRO 001", JOptionPane.ERROR_MESSAGE);
                    busca = 0;
                }
            }
            for (int i = 0; i < numero.length; i++) {
                if (numero[i] == busca) {
                    infoQuarto(i);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "O quarto inserido não foi cadastrado", "Ops...", JOptionPane.WARNING_MESSAGE);

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
            String escolha = "";
            while (escolha.equals("")) {
                try {
                    escolha = JOptionPane.showInputDialog(null, "Escolha o quarto a ser editado.", "Editar", JOptionPane.QUESTION_MESSAGE, null, auxiliar, auxiliar[0]).toString();
                    for (int i = 0; i < numero.length; i++) {
                        if (numero[i] == Integer.parseInt(escolha)) {
                            solicitacaoQuarto(i);
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Escolha uma das opções para continuar!", "ERRO 002", JOptionPane.ERROR_MESSAGE);
                    escolha = "";
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
                if (numero[i] != 0) {
                    texto += "Quarto nº" + numero[i] + "\n";
                }
            }
            JOptionPane.showMessageDialog(null, "Os quartos cadastrados são:\n" + texto, "Quartos Cadastrados", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum quarto está cadastrado.", "Ops...", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void naoCadastradosQuarto() {
        if (adicionador != 0) {
            String texto = "";
            for (int i = 0; i < numero.length; i++) {
                texto += "Quarto nº" + (i + 1) + "\n";

            }
            for (int i = 0; i < quartosMAX.length; i++) {
                if (numero[i] != 0) {
                    texto = texto.replace(("Quarto nº" + numero[i] + "\n"), "");
                }
            }
            if (adicionador == Hotel.hotelQuartos) {
                JOptionPane.showMessageDialog(null, "Você já cadastrou o número máximo de quartos.", "Ops...", JOptionPane.WARNING_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(null, "Os quartos não cadastrados são:\n" + texto, "Quartos Não Cadastrados", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum quarto está cadastrado.", "Ops...", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void solicitacaoQuarto(int posicao) {
        int erro = 0;
        while (tamanho[posicao] <= 8) {
            try {
                tamanho[posicao] = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o tamanho do Quarto:", "Cadastro Quarto", JOptionPane.QUESTION_MESSAGE));
                while (tamanho[posicao] <= 8) {
                    JOptionPane.showMessageDialog(null, "Insira um tamanho maior que 8m²", "Ops...", JOptionPane.WARNING_MESSAGE);
                    tamanho[posicao] = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite novamente o tamanho do Quarto:", "Cadastro Quarto", JOptionPane.QUESTION_MESSAGE).replace(",", "."));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro de entrada", "ERRO 001", JOptionPane.ERROR_MESSAGE);
                tamanho[posicao] = 0;
            }
        }
        while (quartoCamas[posicao] >= 0 && quartoCamas[posicao] <= 3) {
            try {
                quartoTipo[posicao] = JOptionPane.showOptionDialog(null,
                        "Tipos de Quartos:\n"
                        + "\n-STANDARD: Quarto com mobilia comum e serviços básicos "
                        + "\n-SUITE: Standard com banheiro e maior qualidade de mobilia e serviços"
                        + "\n-EXECUTIVO: Suite com sala e maior qualidade de mobilia e serviços"
                        + "\n-DELUXE: Executivo com cozinha e maior qualidade de mobilia e serviços",
                        "Cadastro do Quarto",
                        0,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        tipo,
                        tipo[0]);
                if (quartoCamas[posicao] >= 0 && quartoCamas[posicao] <= 3) {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Escolha uma das opções para continuar!", "ERRO 002", JOptionPane.ERROR_MESSAGE);
            }
        }

        preco[posicao] = precoTipo[quartoTipo[posicao]];
        while (quartoCamas[posicao] >= 0 && quartoCamas[posicao] <= 3) {
            try {
                quartoCamas[posicao] = JOptionPane.showOptionDialog(null,
                        "Classifique o quarto por pessoa:"
                        + "\nOBS:Classificação por pessoa de Quartos:\n"
                        + "\n-SOLTEIRO: Quarto com uma cama de solteiro"
                        + "\n-CASAL: Quarto com uma cama de casal"
                        + "\n-DUPLO SOLTEIRO: Quarto com duas camas de solteiros"
                        + "\n-FAMILIA: Quarto com uma camas de casal e uma beliche para dois\n",
                        "Cadastro do Quarto",
                        0,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        camas,
                        camas[0]);
                if (quartoCamas[posicao] >= 0 && quartoCamas[posicao] <= 3) {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Escolha uma das opções para continuar!", "ERRO 002", JOptionPane.ERROR_MESSAGE);
            }

        }

        preco[posicao] *= precoCama[quartoCamas[posicao]];

        if (adicionador == quartosMAX.length) {
            JOptionPane.showMessageDialog(null, "Você não pode trocar o número do quarto!", "Ops..", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                numero[posicao] = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número do Quarto", "Cadastro Quarto", JOptionPane.QUESTION_MESSAGE));
                for (int i = 0; i < numero.length; i++) {
                    if (numero[posicao] == numero[i] && posicao != i) {
                        erro = 1;
                        break;
                    }
                }
                while (numero[posicao] <= 0 || numero[posicao] > quartosMAX.length || erro == 1) {
                    int contador = erro;
                    if (numero[posicao] <= 0 || numero[posicao] > quartosMAX.length) {
                        JOptionPane.showMessageDialog(null, "O número inserido não é válido.\nInsira um número entre 1 e " + Hotel.hotelQuartos + ".", "Ops...", JOptionPane.WARNING_MESSAGE);
                        numero[posicao] = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite novamente o número do Quarto", "Cadastro Quarto", JOptionPane.QUESTION_MESSAGE));
                        contador++;
                    }
                    for (int i = 0; i < numero.length; i++) {
                        if (numero[posicao] == numero[i] && posicao != i) {
                            JOptionPane.showMessageDialog(null, "Este quarto já está cadastrado.", "Ops...", JOptionPane.WARNING_MESSAGE);
                            numero[posicao] = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite novamente outro número do Quarto", "Cadastro Quarto", JOptionPane.QUESTION_MESSAGE));
                            contador++;
                            break;
                        }
                    }
                    if (contador == erro) {
                        break;
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro de entrada", "ERRO 001", JOptionPane.ERROR_MESSAGE);
                numero[posicao] = 0;
            }
        }
        quartoAvaliacao[posicao] = "";
        while (quartoAvaliacao[posicao].equals("")) {
            try {
                quartoAvaliacao[posicao] = JOptionPane.showInputDialog(null,
                        "Por favor coloque a avaliação atual do quarto:",
                        "Cadastro do Hotel",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        estrelasAvaliacao,
                        estrelasAvaliacao[0]).toString();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Escolha uma das opções para continuar!", "ERRO 002", JOptionPane.ERROR_MESSAGE);
                quartoAvaliacao[posicao] = "";
            }
        }

        for (int i = 0; i < andares.length; i++) {
            andares[i] = (i + 1) + "º Andar";

        }
        quartoAndar[posicao] = -1;
        while (quartoAndar[posicao] < 0 || quartoAndar[posicao] > Hotel.hotelAndares) {
            try {
                quartoAndar[posicao] = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o andar em que o quarto está:", "Cadastro Quarto", JOptionPane.QUESTION_MESSAGE, null, andares, andares[0]).toString().replace("º Andar", "")) - 1;
                while (quartoAndar[posicao] < 0 || quartoAndar[posicao] > Hotel.hotelAndares) {
                    JOptionPane.showMessageDialog(null, "O número inserido não é válido.\nInsira um número entre 1 e " + Hotel.hotelAndares + ".", "Ops...", JOptionPane.WARNING_MESSAGE);
                    quartoAndar[posicao] = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite novamente o andar em que o quarto está:", "Cadastro Quarto", JOptionPane.QUESTION_MESSAGE));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro de entrada", "ERRO 001", JOptionPane.ERROR_MESSAGE);
                quartoAndar[posicao] = -1;
            }
        }

    }

    public void infoQuarto(int posicao) {
        if (adicionador != 0) {

            int status = 0;

            for (int i = 0; i < Hospede.quartos.length; i++) {
                if (Hospede.quartos[i] == posicao) {
                    if (Hospede.status[i] == 1) {
                        status = 1;
                    }
                }

            }
            if (status != 0) {
                JOptionPane.showMessageDialog(null,
                        "\nStatus: Ocupado"
                        + "\nNome do Hospede: " + Hospede.nomes[status]
                        + "\nNúmero do quarto: " + Hospede.quartos[status]
                        + "\nTipo do Quarto: " + tipo[quartoTipo[posicao]]
                        + " para " + camas[quartoCamas[posicao]]
                        + "Andar: " + andares[quartoAndar[posicao]]
                        + "\nEstrelas do Quarto: " + quartoAvaliacao[posicao]
                        + "\nDesocupação:" + Hospede.checkout[status],
                        "Informações do Quarto " + numero[posicao],
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "\nStatus: Desocupado"
                        + "\nNúmero do quarto: " + numero[posicao]
                        + "\nTipo do Quarto: " + tipo[quartoTipo[posicao]]
                        + " para " + camas[quartoCamas[posicao]]
                        + "\nAndar: " + andares[quartoAndar[posicao]]
                        + "\nEstrelas do Quarto: " + quartoAvaliacao[posicao]
                        + "\nPreço: R$" + String.format("%.2f", preco[posicao]),
                        "Informações do Quarto " + numero[posicao],
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum quarto está cadastrado.\nCadastre um quarto para buscar.", "Ops...", JOptionPane.WARNING_MESSAGE);
        }

    }
}
