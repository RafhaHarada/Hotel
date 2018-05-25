import javax.swing.JOptionPane;

/**
 * @author Cidmar
 */
public class Receita {
    double[] ganhosComQuartos = new double[12];
    double[] ganhosComComidaEBebidas = new double[12];
    double[] ganhosComConveniencias = new double[12];
    double[] ganhosComServicosExtras = new double[12];
    double[] ganhosComAlugueis = new double[12];
    double[] ganhosComEventos = new double[12];
    double[] porcentagensDeCrescimentoMensais = new double[12];
    double[] receitasAnuais = new double[10];
    double[] lucroMensal = new double[12];
    double[] lucroAnual = new double[10];
    int atual = 0;
    
    public void cadastrar(){
        solicitarInformacao(atual);
        atual++;
        
    }
    
    public void editar(){
        int mes = Integer.parseInt(
                JOptionPane.showInputDialog(
                    "Informe o número do mês que deseja editar"
    ));
        ganhosComQuartos[mes-1] = Double.parseDouble(
                JOptionPane.showInputDialog(
                    "Informe o número do mês que deseja editar os ganhos com quartos"
    ));
        ganhosComComidaEBebidas[mes-1] = Double.parseDouble(
                JOptionPane.showInputDialog(
                    "Informe o número do mês que deseja editar os ganhos com comida e bebidas"
    ));
        ganhosComConveniencias[mes-1] = Double.parseDouble(
                JOptionPane.showInputDialog(
                    "Informe o número do mês que deseja editar os ganhos com conveniências"
    ));
        ganhosComServicosExtras[mes-1] = Double.parseDouble(
                JOptionPane.showInputDialog(
                    "Informe o número do mês que deseja editar os ganhos com serviços extras prestados"
    ));
        ganhosComAlugueis[mes-1] = Double.parseDouble(
                JOptionPane.showInputDialog(
                    "Informe o número do mês que deseja editar os ganhos com aluguéis"
    ));
        ganhosComEventos[mes-1] = Double.parseDouble(
                JOptionPane.showInputDialog(
                    "Informe o número do mês que deseja editar os ganhos com eventos"
    ));
        
    }
    
    public void listar(){
        
    }
    public void buscarPeloMes(){
        
    }
    public void receitaAnual(){
        double total = 0;
        for(int i = 0; i < ganhosComQuartos.length; i++){
            for(int j = 0; j < ganhosComComidaEBebidas.length; j++)
                for(int k = 0; k < ganhosComConveniencias.length; k++)
                    for(int l = 0; l < ganhosComServicosExtras.length; l++)
                        for(int m = 0; m < ganhosComAlugueis.length; m++)
                            for(int n = 0; n < ganhosComEventos.length; n++)
            total += ganhosComQuartos[i] + ganhosComComidaEBebidas[j] 
                    + ganhosComConveniencias[k] + ganhosComServicosExtras[l] 
                    + ganhosComAlugueis[m] + ganhosComEventos[n];
        }
        JOptionPane.showMessageDialog(null, "A receita anual é de: R$" + total );
        
    }
    public void crescimentoELucroMensal(){
        
    }
    public void totalDeReceitaELucroAnual(){
        
    }
    public void apresentarInformacao(int posicao){
        
    }
    public void solicitarInformacao(int posicao){
        ganhosComQuartos[posicao] = Double.parseDouble(
        JOptionPane.showInputDialog(
                "Informe o total ganho com quartos no mês", 
                ganhosComQuartos[posicao] != 0 ? ganhosComQuartos[posicao] : 0)
                .replace(" ", "").replace("R$", "")
                .replace(".", "").replace(",", ".")
        );
        ganhosComComidaEBebidas[posicao] = Double.parseDouble(
        JOptionPane.showInputDialog(
                "Informe o total ganho com Comida e Bebidas",
                ganhosComComidaEBebidas[posicao] != 0 ? ganhosComComidaEBebidas[posicao] : 0)
                .replace(" ", "").replace("(R$)", "")
                .replace(".", "").replace(",", ".")
        );
        ganhosComConveniencias[posicao] = Double.parseDouble(
        JOptionPane.showInputDialog(
                "Informe o total ganho com conveniências", 
                ganhosComConveniencias[posicao] != 0 ? ganhosComConveniencias[posicao] : 0)
                .replace(" ", "").replace("R$", "")
                .replace(".", "").replace(",", ".")
        );
        ganhosComServicosExtras[posicao] = Double.parseDouble(
        JOptionPane.showInputDialog(
                "Informe o total ganho com serviços extras prestados",
                ganhosComServicosExtras[posicao] != 0 ? ganhosComServicosExtras[posicao] : 0)
                .replace(" ", "").replace("R$", "")
                .replace(".", "").replace(",", ".")
        );
        ganhosComAlugueis[posicao] = Double.parseDouble(
        JOptionPane.showInputDialog(
                "Informe o total ganho com aluguéis",
                ganhosComAlugueis[posicao] != 0 ? ganhosComAlugueis[posicao] : 0)
                .replace(" ", "").replace("R$", "")
                .replace(".", "").replace(",", ".")
        );
        ganhosComEventos[posicao] = Double.parseDouble(
        JOptionPane.showInputDialog(
                "Informe o total ganho com aluguéis",
                ganhosComEventos[posicao] != 0 ? ganhosComEventos[posicao] : 0)
                .replace(" ", "").replace("R$", "")
                .replace(".", "").replace(",", ".")
        );
    }
}
