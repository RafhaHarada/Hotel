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
    
    String[] nomes = new String[1000];
    int[] idades = new int[1000];
    char[] sexos = new char[1000];
    int[] checkin = new int[1000];
    int[] checkout = new int[1000];
    int[] quartos = new int[1000];
    double[] receita = new double[1000];
    
    int atual = 0;
    
    public void Cadastrar(){
        solicitarInformacao(atual);
        atual++;
    }
    
    public void Editar(){
        String procurar = (String) JOptionPane.showInputDialog("Digite o nome do hóspede para editar :");
        for (int i = 0; i < atual; i++) {
             if (nomes[i].contains(procurar)) {
                solicitarInformacao(i);
                return;
            }
        }
    }
            
    public void PesquisarPorNome(){
        String pesquisar = (String) JOptionPane.showInputDialog(" Digite o nome do hóspede para pesquisar :");
        for (int i = 0; i <atual; i++){
            if (nomes[i].contains(pesquisar)) {
                apresentarInformacao(i);
            }
        }
       }
    
     public void PesquisarPorCheckIn(){
      String pesquisar =(String) JOptionPane.showInputDialog(" Digite o nome do hóspede para pesquisar :");
        for (int i = 0; i <atual; i++){
            if ((""+checkin[i]).contains(pesquisar)) {
                apresentarInformacao(i);
            }
        }
       }
    
    public void apresentarInformacao(int posicao) {}

    public void solicitarInformacao(int posicao) {
    nomes[posicao] = (String) JOptionPane.showInputDialog("Informe o nome do funcionário :");
    idades[posicao] = Integer.parseInt((String) JOptionPane.showInputDialog("Digite a idade deste funcionário: "));
    sexos[posicao] = (char) JOptionpane.show}
    
   
        
    }

}

            

