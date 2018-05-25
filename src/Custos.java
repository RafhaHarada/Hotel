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
    
    public class menu{
        private Custos custos = new Custos();
        private int menuGastos(){
        int menuCustos = 
            JOptionPane.showOptionDialog(null, "MENU DOS CUSTOS", "CustosHotel", 0, 0, 
            null, new Object[]{
                "Cadastrar", "Editar", "Listar", "buscarPelo Mes", "Sair"
            }, "Cadastrar");
            return menuCustos;
    }
    public void organizarMenu(){
        int menuCustos = menuGastos();
        while (menuCustos != 4) {
            switch (menuCustos) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    editar();
                    break;
                case 3:
                    listar();
                    break;
                case 4:
                    buscarPeloMes();
                    break;
            }
            menuCustos = menuGastos();
        }
    
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
                "Digite o número equivalente ao mês que deseja editar os gastos com Água." 
                + "\nExemplo: Se deseja editar o mês de Outubro digite 10"
        ));
        
        energiaCustos[mes-1] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Digite o número equivalente ao mês que deseja editar os gastos com Energia." 
                + "\nExemplo: Se deseja editar o mês de Outubro digite 10"
        ));
        
        gastosComMantimentos[mes-1] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Digite o número equivalente ao mês que deseja editar os gastos com Mantimentos." 
                + "\nExemplo: Se deseja editar o mês de Outubro digite 10"
        ));
        
        gastosComManutencoes[mes-1] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Digite o número equivalente ao mês que deseja editar os gastos com Manutenção." 
                + "\nExemplo: Se deseja editar o mês de Outubro digite 10"
        ));
        
        gastosComFuncionarios[mes-1] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Digite o número equivalente ao mês que deseja editar os gastos com Funcionários." 
                + "\nExemplo: Se deseja editar o mês de Outubro digite 10"
        ));
        
        gastosComLimpezas[mes-1] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Digite o número equivalente ao mês que deseja editar os gastos com Limpeza." 
                + "\nExemplo: Se deseja editar o mês de Outubro digite 10"
        ));
        
        gastosComTelefoneEInternets[mes-1] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Digite o número equivalente ao mês que deseja editar os gastos com Telefone e Internet." 
                + "\nExemplo: Se deseja editar o mês de Outubro digite 10"
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
                "Digite o número equivalente ao mês que deseja visualizar." 
                + "\nExemplo: Se desejar visualizar o mês de Fevereiro digite 2"
        ));
        
               apresentarInformacao(mesDesejado-1);
               
        }
    
    public void apresentarInformacao(int posicao){
        JOptionPane.showMessageDialog(null, 
                "Água: " + aguaCustos[posicao]
                + "\nEnergia: " + energiaCustos[posicao]
                + "\nMantimentos: " + gastosComMantimentos[posicao]
                + "\nManutenção: " + gastosComManutencoes[posicao]
                + "\nFuncionários: " + gastosComFuncionarios[posicao]
                + "\nLimpeza: " + gastosComLimpezas[posicao]
                + "\nTelefone e Internet: " + gastosComTelefoneEInternets[posicao]
        );
    }
            
    public void solicitarInformacao(int posicao){
        aguaCustos[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe o valor gasto com água", 
                    aguaCustos[posicao] != 0 ? aguaCustos[posicao] : 0)
                .replace(" ", "").replace("RS", "")
                .replace(".", "").replace(",", ".")
        );
        energiaCustos[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe o valor gasto com energia",
                     energiaCustos[posicao] != 0 ? energiaCustos[posicao] : 0)
                .replace(" ", "").replace("RS", "")
                .replace(".", "").replace(",", ".")
        );
        gastosComMantimentos[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe o valor gasto com mantimentos",
                     gastosComMantimentos[posicao] != 0 ? gastosComMantimentos[posicao] : 0)
                .replace(" ", "").replace("RS", "")
                .replace(".", "").replace(",", ".")
        );
        gastosComManutencoes[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe o valor gasto com manutenção",
                     gastosComManutencoes[posicao] != 0 ? gastosComManutencoes[posicao] : 0)
                .replace(" ", "").replace("RS", "")
                .replace(".", "").replace(",", ".")
        );
        gastosComFuncionarios[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe o valor gasto com fucionários",
                     gastosComFuncionarios[posicao] != 0 ? gastosComFuncionarios[posicao] : 0)
                .replace(" ", "").replace("RS", "")
                .replace(".", "").replace(",", ".")
        );
        gastosComLimpezas[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe o valor gasto com limpeza",
                     gastosComLimpezas[posicao] != 0 ? gastosComLimpezas[posicao] : 0)
                .replace(" ", "").replace("RS", "")
                .replace(".", "").replace(",", ".")
        );
        gastosComTelefoneEInternets[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe o valor gasto com telefone e internet",
                     gastosComTelefoneEInternets[posicao] != 0 ? gastosComTelefoneEInternets[posicao] : 0)
                .replace(" ", "").replace("RS", "")
                .replace(".", "").replace(",", ".")
        );
        
        }
    }
}
