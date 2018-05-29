
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
public class Hotel {

    static int hotelAndares = 0;
    static int hotelQuartos = 0;
    static int sair = 0;
    static String hotelAvaliacao = "";
    String telefoneHotel = "";
    String anterior = "";
    String hotelNome = "";
    String endereco = "";
    String email = "";
    Object[] estrelasAvaliacao = {"★☆☆☆☆", "★★☆☆☆", "★★★☆☆", "★★★★☆", "★★★★★"};
    Object[] options = {"Editar","Informações","Voltar"};
    int i = 0;

    public void menu(){
        int menu = JOptionPane.showOptionDialog(null,
                    "Editar - Edita as informações não físicas do hotel.\n"
                    + "Informações - Apresenta as informações do hotel.\n"
                    + "Voltar - Volta ao menu anterior.\n",
                    "Menu de Hotel",
                    0,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
        while (menu != 2) {
            switch (menu) {
                case 0:
                    Editar();
                    break;
                case 1:
                    Informacao();
                    break;
                case 2:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida", "Error 001", JOptionPane.ERROR_MESSAGE);
            }
            menu = JOptionPane.showOptionDialog(null,
                    "Editar - Edita as informações não físicas do hotel.\n"
                    + "Informações - Apresenta as informações do hotel.\n"
                    + "Voltar - Volta ao menu anterior.\n",
                    "Menu de Hotel",
                    0,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
        }
    }
    
    public void Inicializacao() {
        Solicitar();
        while (hotelAndares <= 0 && sair == 0) {
            try {
                hotelAndares = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Por favor insira a quantidade de andares do " + hotelNome + ":",
                        "Cadastro do Hotel",
                        JOptionPane.QUESTION_MESSAGE));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro de entrada", "ERRO 001", JOptionPane.ERROR_MESSAGE);
                hotelAndares = 0;
            }
        }
        while (hotelQuartos <= 0 && sair == 0) {
            try {
                hotelQuartos = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Por favor insira a quantidade de quartos do " + hotelNome + ":",
                        "Cadastro do Hotel",
                        JOptionPane.QUESTION_MESSAGE));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro de entrada", "ERRO 001", JOptionPane.ERROR_MESSAGE);
                hotelQuartos = 0;
            }
        }
    }

    public void Solicitar() {
        while (hotelNome.equals("") && sair == 0 || !anterior.equals("sair") && !anterior.equals("")) {
            try {
                anterior = hotelNome;
                hotelNome = JOptionPane.showInputDialog(null,
                        "Primeiramente, cadastraremos seu hotel.\nPor favor insira o nome do Hotel",
                        "Cadastro do Hotel",
                        JOptionPane.QUESTION_MESSAGE)
                        .trim();
                if (hotelNome.equalsIgnoreCase("sair")) {
                    sair++;
                    hotelNome = anterior;
                    anterior = "sair";
                }
                anterior = hotelNome;
                if (!anterior.equals("")) {
                    break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Insira para continuar.\nOu insira \"Sair\" para fechar o sistema", "Ops...", JOptionPane.WARNING_MESSAGE);
                hotelNome = "";
            }
        }
        
        while (endereco.equals("") && sair == 0 || !anterior.equals("sair") && !anterior.equals("")) {
            try {
                anterior = endereco;
                endereco = JOptionPane.showInputDialog(null,
                        "Por favor insira o endereço do " + hotelNome + ":",
                        "Cadastro do Hotel",
                        JOptionPane.QUESTION_MESSAGE)
                        .trim();
                if (endereco.equalsIgnoreCase("sair")) {
                    sair++;
                    endereco = anterior;
                    anterior = "sair";
                }
                anterior = endereco;
                if (!anterior.equals("")) {
                    break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Insira para continuar.\nOu insira \"Sair\" para fechar o sistema", "Ops...", JOptionPane.WARNING_MESSAGE);
                endereco = "";
            }
        }
        while (telefoneHotel.equals("") && sair == 0 || !anterior.equals("sair") && !anterior.equals("")) {
            try {
                anterior = "" + telefoneHotel;
                telefoneHotel = JOptionPane.showInputDialog(null,
                        "Por favor insira o telefone do " + hotelNome + ":",
                        "Cadastro do Hotel",
                        JOptionPane.QUESTION_MESSAGE)
                        .trim()
                        .replace("+","")
                        .replace("-","")
                        .replace(".","")
                        .replace("(","")
                        .replace(")","");
                if (telefoneHotel.equals("sair")) {
                    sair++;
                    telefoneHotel = anterior;
                    anterior = "sair";
                }
                anterior = "" + telefoneHotel;
                if (!anterior.equals("")) {
                    break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Insira para continuar.\nOu insira \"7247\" para fechar o sistema", "Ops...", JOptionPane.WARNING_MESSAGE);
                telefoneHotel = "";
            }
        }
        while (email.equals("") && sair == 0 || !anterior.equals("sair") && !anterior.equals("")) {
            try {
                anterior = email;
                email = JOptionPane.showInputDialog(null,
                        "Por favor insira o email do " + hotelNome + ":",
                        "Cadastro do Hotel",
                        JOptionPane.QUESTION_MESSAGE)
                        .trim();
                if (email.equalsIgnoreCase("sair")) {
                    sair++;
                    email = anterior;
                    anterior = "sair";
                }
                anterior = email;
                if (!anterior.equals("")) {
                    break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Insira para continuar.\nOu insira \"Sair\" para fechar o sistema", "Ops...", JOptionPane.WARNING_MESSAGE);
                email = "";
            }
        }
        while (hotelAvaliacao.equals("") && sair == 0 || !anterior.equals("sair") && !anterior.equals("")) {
            try {
                anterior = hotelAvaliacao;
                hotelAvaliacao = JOptionPane.showInputDialog(null,
                        "Por favor coloque a avaliação atual do " + hotelNome + ":",
                        "Cadastro do Hotel",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        estrelasAvaliacao,
                        estrelasAvaliacao[0]).toString();
                if (hotelAvaliacao.equalsIgnoreCase("sair")) {
                    sair++;
                    hotelAvaliacao = anterior;
                    anterior = "sair";
                }
                anterior = hotelAvaliacao;
                if (!anterior.equals("")) {
                    break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Insira para continuar.\nOu insira \"Sair\" para fechar o sistema", "Ops...", JOptionPane.WARNING_MESSAGE);
                hotelAvaliacao = "";
            }
        }
    }

    public void Editar() {
        sair = 2;
        anterior = ".";
        Solicitar();
    }

    public void Informacao() {
        JOptionPane.showMessageDialog(null,
                "\nNome: " + hotelNome
                + "\nTelefone: " + telefoneHotel
                + "\nEndereco: " + endereco
                + "\nEmail: " + email
                + "\nAvaliacao: " + hotelAvaliacao
                + "\nAndares: " + hotelAndares
                + "\nQuartos: " + hotelQuartos,
         "Informações do Hotel",
         JOptionPane.INFORMATION_MESSAGE);
    }
}
