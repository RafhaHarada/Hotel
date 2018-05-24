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
  
  public void menuHospedes(){
        int menuHospedes = Integer.parseInt(
            JOptionPane.showInputDialog(
                "1 - Cadastrar hóspedes"
               +"\n2 - Editar hóspedes"
               +"\n3 - Listar hóspedes"
               +"\n4 - Pesquisar por nome"
               +"\n5 - Pesquisar por check-in"
               +"\n6 - Pesquisar por check-out"
               +"\n7 - Finalizar"));
        
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
    
  
       public void PesquisarPorCheckOut(){
        String pesquisar =(String) JOptionPane.showInputDialog(" Digite a data de check-out para pesquisar :");
          for (int i = 0; i <atual; i++){
              if ((""+checkout[i]).contains(pesquisar)) {
                  apresentarInformacao(i);
              }
          }
         }
  
    public void apresentarInformacao(int posicao) {
     JOptionPane.showMessageDialog(null,
                "Nome: " + nomes[posicao]
                + "\nIdade: " + idades[posicao]
                + "\nSexo: " + sexos[posicao]
                + "\nCheck-in: " + checkin[posicao]
                + "\nCheck-out: " + checkout[posicao]
                + "\nNº do quarto: " + quartos[posicao]
                + "\nReceita: " + receita[posicao]);
        
       }      }

    public void solicitarInformacao(int posicao) {
    nomes[posicao] = (String) JOptionPane.showInputDialog("Informe o nome do funcionário :");
    idades[posicao] = Integer.parseInt((String) JOptionPane.showInputDialog("Digite a idade deste funcionário: "));
    String string = " Informe o sexo deste funcionário: ";
    sexos[posicao] =JOptionPane.showInputDialog(stringCharacter.toString());
    checkin[posicao] = Integer.parseInt(JOptionPane.showInputDialog("Digite a data de check-in deste hóspede: "));
    checkout[posicao] = Integer.parseInt(JOptionPane.showInputDialog("Digite a data de check-out deste hóspede: "));
    quartos[posicao] = Integer.parseInt(JOptionPane.showInputDialog("informe o quarto em que este hóspede alugou: "));
    receita[posicao] = Double.parseDouble(JOptionPane.showInputDialog("Informe a receita deste hóspede"));

    
   
        
    }

}

            

