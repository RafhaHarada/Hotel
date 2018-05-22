import javax.swing.JOptionPane;

/**
 * @author Cidmar
 */
public class Custos {

    double[] aguaCustos = new double[12];
    double[] energiaCustos = new double[12];
    double[] gastosComMantimentos = new double[12];
    double[] gastosComManutencoes = new double[12];
    double[] gastosComFuncionarios = new double[12];
    double[] gastosComLimpezas = new double[12];
    double[] gastosComTelefoneEInternets = new double[12];
    int atual = 0;
    
    public void menuDosCustos(){
        int menuCustos = Integer.parseInt(
            JOptionPane.showInputDialog(
                "1- Cadastrar custos" +
                "\n2- Editar custos" +
                "\n3- Listar custos" +
                "\n4- Buscar pelo mês" +
                "\n5- Finalizar"
        ));
        
    }

    public void cadastrar() {
       solicitarInformacao(atual);
       atual++;
    }
    
    public void editar(){
        int mes = Integer.parseInt(
            JOptionPane.showInputDialog(
                "Digite o número equivalente ao mês que deseja editar." 
                + "\nExemplo: Se quiser editar os custos do mês de Janeiro, digite 1"
        ));
        
        aguaCustos[mes-1] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Digite o número equivalente ao mês que deseja editar." 
                + "\nExemplo: Se deseja editar o ~ês de Outubro digite 10"
        ));
            
        
    }
    public void listar(){
        String texto = "";
        for(int i =0; i < atual; i++){
            texto+= "Água: " + aguaCustos[i]
                + "\nEnergia: " + energiaCustos[i]
                + "\nMantimentos: " + gastosComMantimentos[i] 
                + "\nManutenção: " + gastosComManutencoes[i]
                + "\nFucionários: " + gastosComFuncionarios[i]
                + "\nLimpeza: " + gastosComLimpezas[i]
                + "\nTelefone e internet: " + gastosComTelefoneEInternets[i];
                
        }
        JOptionPane.showMessageDialog(null, texto);
    }
    public void buscarPeloMes(){
        int mesDesejado = Integer.parseInt(
            JOptionPane.showInputDialog(
                "Digite o número equivalente ao mês que deseja visualizar(1 ao 12)." 
                + "\nExemplo: Se desejar visualizar o mês de Fevereiro digite 2"
        ));
    }
            
    public void solicitarInformacao(int posicao){
        aguaCustos[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe o valor gasto com água"
        ));
        energiaCustos[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe o valor gasto com energia"
        ));
        gastosComMantimentos[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe o valor gasto com mantimentos"
        ));
        gastosComManutencoes[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe o valor gasto com manutenção"
        ));
        gastosComFuncionarios[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe o valor gasto com fucionários"
        ));
        gastosComLimpezas[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe o valor gasto com limpeza"
        ));
        gastosComTelefoneEInternets[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe o valor gasto com telefone e internet"
        ));
        

    }
}
