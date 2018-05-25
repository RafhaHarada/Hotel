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
    double[] receitasAnuais = new double[5];
    double[] lucrosMensais = new double[12];
    double[] lucrosAnuais = new double[5];
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
        String texto = "";
        for(int i = 0; i < atual; i ++){
            texto +=  ganhosComQuartos[i] + ganhosComComidaEBebidas[i] 
                    + ganhosComConveniencias[i] + ganhosComServicosExtras[i]
                    + ganhosComAlugueis[i] + ganhosComEventos[i];
                    
        }
        JOptionPane.showMessageDialog(null, texto);
    }
    public void buscarPeloMes(){
        int mesDesejado = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Informe o número do mês que deseja visualizar"
        ));
        apresentarInformacao(mesDesejado-1);
    }
    public void receitaAnual(){
        double total = 0;
        for(int i = 0; i < ganhosComQuartos.length; i++){
         
            total += ganhosComQuartos[i] + ganhosComComidaEBebidas[i] 
                    + ganhosComConveniencias[i] + ganhosComServicosExtras[i] 
                    + ganhosComAlugueis[i] + ganhosComEventos[i];
        }
                JOptionPane.showMessageDialog(null, "A receita anual é de: R$" + total);
        
    }
    public void lucroECrescimentoMensal(){
        double lucroMes = 0;
        int mes = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Informe o mês que deseja visualizar o lucro"));
            lucroMes += ganhosComQuartos[mes-1] + ganhosComComidaEBebidas[mes-1] 
                    + ganhosComConveniencias[mes-1] + ganhosComServicosExtras[mes-1]
                    + ganhosComAlugueis[mes-1] + ganhosComEventos[mes-1]
                    - Custos.aguaCustos[mes-1] - Custos.energiaCustos[mes-1]
                    - Custos.gastosComMantimentos[mes-1] - Custos.gastosComManutencoes[mes-1]
                    - Custos.gastosComFuncionarios[mes-1] - Custos.gastosComLimpezas[mes-1]
                    - Custos.gastosComTelefoneEInternets[mes-1];
            
        JOptionPane.showMessageDialog(null, "O lucro do mês foi de: R$" + lucroMes);
    }
       
    public void lucroAnual(){
        double lucro = 0;
        for(int i = 0; i < ganhosComQuartos.length; i++){
            
            lucro += ganhosComQuartos[i] + ganhosComComidaEBebidas[i] 
                    + ganhosComConveniencias[i] + ganhosComServicosExtras[i]
                    + ganhosComAlugueis[i] + ganhosComEventos[i] 
                    - Custos.aguaCustos[i] - Custos.energiaCustos[i] 
                    - Custos.gastosComMantimentos[i] - Custos.gastosComManutencoes[i] 
                    - Custos.gastosComFuncionarios[i] - Custos.gastosComLimpezas[i] 
                    - Custos.gastosComTelefoneEInternets[i];
        }
        JOptionPane.showMessageDialog(null, "O lucro anual é de: R$" + lucro);
        
        if(lucro > 0){
            JOptionPane.showMessageDialog(null, "O balanço das contas foi positivo");
            
        }else if(lucro == 0){
            JOptionPane.showMessageDialog(null, "O balanço das contas foi neutro");
            
        }else if(lucro < 0){
            JOptionPane.showMessageDialog(null, "O balanço das contas foi negativo");
            
        }
        
    }
    public void apresentarInformacao(int posicao){
            JOptionPane.showMessageDialog(null, 
                "Quartos: " + ganhosComQuartos[posicao]
                + "\nComida e bebidas: " + ganhosComComidaEBebidas[posicao]
                + "\nConveniências: " + ganhosComConveniencias[posicao]
                + "\nServiços extras prestado: " + ganhosComServicosExtras[posicao]
                + "\nAluguéis: " + ganhosComAlugueis[posicao]
                + "\nEventos: " + ganhosComEventos[posicao]);
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
                "Informe o total ganho com eventos",
                ganhosComEventos[posicao] != 0 ? ganhosComEventos[posicao] : 0)
                .replace(" ", "").replace("R$", "")
                .replace(".", "").replace(",", ".")
        );
    }
}
