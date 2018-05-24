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
    }
    public void listar(){
        
    }
    public void buscarPeloMes(){
        
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
        
    }
}
