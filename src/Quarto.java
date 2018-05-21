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
    public static void main(String[] args) {
        int j = 0;
        int i = 0;
        String quartosMAX[] = new String[1000];
        for (int k = 0; k < quartosMAX.length; k++) {
            quartosMAX[k] = "";
        }
        while(j != 3){
            j = Integer.parseInt(JOptionPane.showInputDialog(null, "Para cadastrar digite 1.\nPara visualizar algum quarto digite 2.\nDigite 3 para sair"));
            if(j == 1){
                JOptionPane.showMessageDialog(null, "Você selecionou \"Quarto\"\nNesta opção você registra um quarto!","Cadastro Quarto",JOptionPane.INFORMATION_MESSAGE);
                double tamanho = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o tamanho do Quarto:","Cadastro Quarto",JOptionPane.QUESTION_MESSAGE));
                Object[] camas = {"Escolha Uma Das Opções Abaixo","SOLTEIRO","CASAL","DUPLO SOLTEIRO","FAMILIA"};
                String quartoCamas = JOptionPane.showInputDialog(null, 
                    "Classificação por pessoa de Quartos:\n" +
                    "\n-SOLTEIRO: Quarto com uma cama de solteiro" +
                    "\n-CASAL: Quarto com uma cama de casal" +
                    "\n-DUPLO SOLTEIRO: Quarto com duas camas de solteiros" +
                    "\n-FAMILIA: Quarto com uma camas de casal e uma beliche para dois",
                    "Cadastro do Quarto",
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    camas, 
                    camas[0]).toString();
                    Object[] tipo = {"Escolha Uma Das Opções Abaixo","STANDARD","SUITE","EXECUTIVO","DELUXE"};
                String quartoTipo = JOptionPane.showInputDialog(null, 
                    "Tipos de Quartos:\n" +
                    "\n-STANDARD: Quarto com mobilia comum e serviços básicos "+
                    "\n-SUITE: Standard com banheiro e maior qualidade de mobilia e serviços"+
                    "\n-EXECUTIVO: Suite com sala e maior qualidade de mobilia e serviços"+
                    "\n-DELUXE: Executivo com cozinha e maior qualidade de mobilia e serviços",
                    "Cadastro do Quarto",
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    tipo, 
                    tipo[0]).toString();
                int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número do Quarto","Cadastro Quarto",JOptionPane.QUESTION_MESSAGE));
                    Object[] estrelasAvaliacao = {"Escolha Uma Das Opções Abaixo","★☆☆☆☆","★★☆☆☆","★★★☆☆","★★★★☆","★★★★★"};
                String quartoAvaliacao = JOptionPane.showInputDialog(null, 
                        "Por favor coloque a avaliação atual do quarto:",
                        "Cadastro do Hotel", 
                        JOptionPane.QUESTION_MESSAGE, 
                        null, 
                        estrelasAvaliacao, 
                        estrelasAvaliacao[0])
                        .toString();
                int quartoAndar = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o andar em que o quarto está:","Cadastro Quarto",JOptionPane.QUESTION_MESSAGE));
                double preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o preço/noite do quarto","Cadastro Quarto",JOptionPane.QUESTION_MESSAGE));

                String text =   "Tamanho: " + String.format("%.2f m²\n", tamanho) +
                            "Tipo de Quarto: " + quartoCamas + "\n" +
                            "Tipo de Recinto: " + quartoTipo + "\n" +
                            "Número: " + numero + "\n" +
                            "Avaliacao: " + quartoAvaliacao + "\n" +
                            "Andar: " + quartoAndar + "º Andar\n" +
                            "Preco: R$" + String.format("%.2f", preco);
                quartosMAX[i] = text;
                i++;
            }
            if (j == 2) {
                int r = 0;
                r = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero do quarto que deseja visualizar."))-1;
                if(quartosMAX[r].equals("")){
                    JOptionPane.showMessageDialog(null, "Você ainda não cadastrou esse quarto!");
                }
                else{
                    JOptionPane.showMessageDialog(null, quartosMAX[r]);
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Você saiu!", "Fazendo logout...", JOptionPane.WARNING_MESSAGE);
    }
}
