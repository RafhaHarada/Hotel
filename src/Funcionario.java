import static java.lang.Character.toString;
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
    
    String[] nomes = new String[1000];
    int[] idades = new int[1000];
    char[] sexos = new char[1000];
    String[] cargos = new String[1000];
    int[] cargasHorarias = new int[1000];
    double[] salarios = new double[1000];
    String[] desempenhos = new String[1000];
    int atual = 0;

    
      public void cadastrar() {        solicitarInformacao(atual);
        atual++;
    }
	
	public void menuFuncionarios(){
		int menufuncionarios = Integer.parseInt(
			JOptionPane.showInputDialog(
				"1 - Cadastrar funcionários" 
			       +"\n2 - Editar funcionários"
			       +"\n3 - Listar funcionários"
			       +"\n4 - Pesquisar pelo nome"
			       +"\n5 - Pesquisar pelo cargo"
			       +"\n6 - Finalizar"));
		while (menuFuncionarios != 6 ){
			switch (menuFuncionarios){
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
					PesquisarPeloNome();
					break;
				case 5:
					BuscarPeloCargo();
					break;
					
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida");
			}
			menuFuncionarios = Integer.parseInt(JOptionPane.showInputDialog(
				"1 - Cadastrar funcionários"
			       +"\n2 - Editar funcionários"
			       +"\n3 - Listar funcionários"
         		       +"\n4 - Pesquisar pelo nome"
			       +"\n5 - Pesquisar pelo cargo"
			       +"\n6 - Finalizar"));
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
        
    
      public void PesquisarPeloNome() {
           String buscar = (String) JOptionPane.showInputDialog("Digite o nome do funcionário para pesquisar :");
        for (int i = 0; i <atual; i++){
            if (nomes[i].contains(buscar)) {
                apresentarInformacao(i);
            }
        }
       }
      
      public void PesquisarPeloCargo() {
          String buscar = (String) JOptionPane.showInputDialog("Digite o cargo para pesquisar funcionários :");
        for  (int i = 0; i <atual; i++){
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
      
    
    public void solicitarInformacao(int atual1) {
        nomes[atual] =JOptionPane.showInputDialog("Digite o nome do funcionário :");
        idades[atual] = Integer.parseInt(JOptionPane.showInputDialog(" Informe a idade deste funcionátio :"));
        String string = " Informe o sexo deste funcionário :";
		sexos[atual] =JOptionPane.showInputDialog(stringCharacter.toString());
        cargos[atual] =JOptionPane.showInputDialog("Digite o cargo que este funcionário exerce :");
        cargasHorarias[atual] = Integer.parseInt(JOptionPane.showInputDialog("Digite a carga horária deste funcionário :"));    
        salarios[atual] = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário deste funcionário :"));
        desempenhos[atual] = JOptionPane.showInputDialog (" Descreva o desemepenho deste funcionário :");

    
    double menorSalario = Double.MAX_VALUE;
   
    double maiorSalario = Double.MIN_VALUE;
    
    
    for (int i =0; i > 2; i++ ){
            int posicao = 0;
         if (salarios[posicao] <menorSalario){
        menorSalario = salarios[posicao];
    }
          if (salarios[posicao] >maiorSalario){
        maiorSalario = salarios[posicao];
    }
    }
	    
	  
    
    
    
    
} 

 
    }
