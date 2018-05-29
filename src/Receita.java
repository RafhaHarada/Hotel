import javax.swing.JOptionPane;

/**
 * @author Cidmar
 */
public class Receita {
    
    String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
    double[] ganhosComQuartos = new double[12];
    double[] ganhosComComidaEBebidas = new double[12];
    double[] ganhosComConveniencias = new double[12];
    double[] ganhosComServicosExtras = new double[12];
    double[] ganhosComAlugueis = new double[12];
    double[] ganhosComEventos = new double[12];
    double[] porcentagensDeCrescimentoMensais = new double[12];
    double[] receitasAnuais = new double[10];
    double[] lucrosMensais = new double[12];
    double[] lucrosAnuais = new double[10];
    int atual = 0;
    
    public void menu(){
    Object[] options = {"Cadastrar", "Editar", "Listar","Receita Anual","Lucro Anual", "Voltar"};
        int menu = 0;

        while (menu != 6) {
            menu = JOptionPane.showOptionDialog(
                    null,
                    "Tabela de receitas"
                    + "Selecione uma das opções abaixo:",
                    "Administração das Receitas",
                    0,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            switch (menu) {
                case 0:
                    cadastrar();
                    break;
                case 1:
                    editar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    receitaAnual();
                    break;
                case 4:
                    lucroAnual();
                    break;
                case 5:
                    return;
                default:
                    return;
            }}}
    
    public void cadastrar(){
        solicitarInformacao(atual);
        atual++;
        
    }
    
    public void editar(){
        Object[] receitas = new Object[atual];
        for (int i = 0; i < atual; i++) {
            receitas[i] = meses[i];
        }

        int posicao = JOptionPane.showOptionDialog(null,
                atual > 0 ? "Selecione o mês para editar"
                        : "Nenhum mês cadastrado",
                "Aviso",
                0, JOptionPane.QUESTION_MESSAGE, null, receitas, "");
        if (posicao != JOptionPane.CLOSED_OPTION) {
            solicitarInformacao(posicao);
            
        }
}
    
    public void listar(){
        Object[] receitas = new Object[atual];
        for (int i = 0; i < atual; i++) {
            receitas[i] = meses[i];
        }
        

        int posicao = JOptionPane.showOptionDialog(null,
                atual > 0 ? "Selecione o mês que deseja visualizar"
                        : "Nenhum mês cadastrado",
                "Aviso",
                0, JOptionPane.QUESTION_MESSAGE, null, receitas, "");
        if (posicao != JOptionPane.CLOSED_OPTION) {
             apresentarInformacao(posicao);
            
        }

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
       
    public void lucroAnual(){
        double lucro = 0;
        for(int i = 0; i < ganhosComQuartos.length; i++){
            
            lucro += ganhosComQuartos[i] + ganhosComComidaEBebidas[i] 
                    + ganhosComConveniencias[i] + ganhosComServicosExtras[i]
                    + ganhosComAlugueis[i] + ganhosComEventos[i] 
                    - Custos.aguaCustos[i] - Custos.energiaCustos[i] 
                    - Custos.gastosComMantimentos[i] - Custos.gastosComManutencoes[i] 
                    - Custos.gastosComFuncionarios[i] - Custos.gastosComLimpezas[i] 
                    - Custos.gastosComTelefoneEInternets[i] - Custos.gastosComMarketings[i];
            
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
            double totalMes = 0;
            double lucroMes = 0;
            
            totalMes += ganhosComQuartos[posicao] + ganhosComComidaEBebidas[posicao] 
                    + ganhosComConveniencias[posicao] + ganhosComServicosExtras[posicao]
                    + ganhosComAlugueis[posicao] + ganhosComEventos[posicao];
            
            lucroMes += ganhosComQuartos[posicao] + ganhosComComidaEBebidas[posicao] 
                    + ganhosComConveniencias[posicao] + ganhosComServicosExtras[posicao]
                    + ganhosComAlugueis[posicao] + ganhosComEventos[posicao]
                    - Custos.aguaCustos[posicao] - Custos.energiaCustos[posicao]
                    - Custos.gastosComMantimentos[posicao] - Custos.gastosComManutencoes[posicao]
                    - Custos.gastosComFuncionarios[posicao] - Custos.gastosComLimpezas[posicao]
                    - Custos.gastosComTelefoneEInternets[posicao] - Custos.gastosComMarketings[posicao];
            lucrosMensais[posicao] = lucroMes;
            
            double margemDeLucro = lucroMes / totalMes * 100;
            
            JOptionPane.showMessageDialog(null,
                    "Lista das receitas"
                    + "Quartos: R$" + String.format("%.2f", ganhosComQuartos[posicao]) 
                    + "\nComida e bebidas: R$" + String.format("%.2f", ganhosComComidaEBebidas[posicao])
                    + "\nConveniências: R$" + String.format("%.2f", ganhosComConveniencias[posicao])
                    + "\nServiços extras prestado: R$" + String.format("%.2f", ganhosComServicosExtras[posicao])
                    + "\nAluguéis: R$" + String.format("%.2f", ganhosComAlugueis[posicao])
                    + "\nEventos: R$" + String.format("%.2f", ganhosComEventos[posicao])
                    + "\nReceita do mês: R$" + String.format("%.2f", totalMes)
                    + "\nLucro do mês: R$" + String.format("%.2f", lucroMes)
                    + "\nMargem de lucro: R$" + String.format("%.2f", margemDeLucro)  + "%");
    }
    public void solicitarInformacao(int posicao){
         ganhosComQuartos[posicao] = 0;
         int tenteNovamente = 0;
          while (ganhosComQuartos[posicao] == 0) {
              try { 
                  if (tenteNovamente == 0) {
                     ganhosComQuartos[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe os ganhos com quartos", 
                    ganhosComQuartos[posicao] != 0 ? ganhosComQuartos[posicao] : 0)
                .replace(" ", "").replace("RS", "")
                .replace(".", "").replace(",", ".")
         );
                     } else {
                       ganhosComQuartos[posicao] = Integer.parseInt(JOptionPane.showInputDialog("Por gentileza, insira somente números"));
                           }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
         ganhosComQuartos[posicao] = 0;
         tenteNovamente = 1;
                      
                  }
              }
         tenteNovamente = 0;
        
        
         ganhosComComidaEBebidas[posicao] = 0;
         tenteNovamente = 0;
          while (ganhosComComidaEBebidas[posicao] == 0) {
              try { 
                  if (tenteNovamente == 0) {
                   ganhosComComidaEBebidas[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe os ganhos com comida e bebidas",
                     ganhosComComidaEBebidas[posicao] != 0 ? ganhosComComidaEBebidas[posicao] : 0)
                .replace(" ", "").replace("RS", "")
                .replace(".", "").replace(",", ".")
         );
                     } else {
                       ganhosComComidaEBebidas[posicao] = Integer.parseInt(JOptionPane.showInputDialog("Por gentileza, insira somente números"));
                           }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
         ganhosComComidaEBebidas[posicao] = 0;
         tenteNovamente = 1;
                      
                  }
              }
         tenteNovamente = 0;
            
                         
          
         ganhosComConveniencias[posicao] = 0;
         tenteNovamente = 0;
          while (ganhosComConveniencias[posicao] == 0) {
              try { 
                  if (tenteNovamente == 0) {
                  ganhosComConveniencias[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe os ganhos com conveniências",
                     ganhosComConveniencias[posicao] != 0 ? ganhosComConveniencias[posicao] : 0)
                .replace(" ", "").replace("RS", "")
                .replace(".", "").replace(",", ".")
         );
                     } else {
                       ganhosComConveniencias[posicao] = Integer.parseInt(JOptionPane.showInputDialog("Por gentileza, insira somente números"));
                           }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
         ganhosComConveniencias[posicao] = 0;
         tenteNovamente = 1;
                      
                  }
              }
         tenteNovamente = 0;
        
          
         ganhosComServicosExtras[posicao] = 0;
         tenteNovamente = 0;
          while (ganhosComServicosExtras[posicao] == 0) {
              try { 
                  if (tenteNovamente == 0) {
                 ganhosComServicosExtras[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe os ganhos com serviços extras prestados",
                     ganhosComServicosExtras[posicao] != 0 ? ganhosComServicosExtras[posicao] : 0)
                .replace(" ", "").replace("RS", "")
                .replace(".", "").replace(",", ".")
        );
                     } else {
                       ganhosComServicosExtras[posicao] = Integer.parseInt(JOptionPane.showInputDialog("Por gentileza, insira somente números"));
                           }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
         ganhosComServicosExtras[posicao] = 0;
         tenteNovamente = 1;
                      
                  }
              }
         tenteNovamente = 0;
        
          
         ganhosComAlugueis[posicao] = 0;
         tenteNovamente = 0;
          while (ganhosComAlugueis[posicao] == 0) {
              try { 
                  if (tenteNovamente == 0) {
                ganhosComAlugueis[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe os ganhos com aluguéis",
                     ganhosComAlugueis[posicao] != 0 ? ganhosComAlugueis[posicao] : 0)
                .replace(" ", "").replace("RS", "")
                .replace(".", "").replace(",", ".")
        );
                     } else {
                       ganhosComAlugueis[posicao] = Integer.parseInt(JOptionPane.showInputDialog("Por gentileza, insira somente números"));
                           }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
         ganhosComAlugueis[posicao] = 0;
         tenteNovamente = 1;
                      
                  }
              }
         tenteNovamente = 0;
        
          
         ganhosComEventos[posicao] = 0;
         tenteNovamente = 0;
          while (ganhosComEventos[posicao] == 0) {
              try { 
                  if (tenteNovamente == 0) {
               ganhosComEventos[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe os ganhos com eventos",
                     ganhosComEventos[posicao] != 0 ? ganhosComEventos[posicao] : 0)
                .replace(" ", "").replace("RS", "")
                .replace(".", "").replace(",", ".")
        );
                     } else {
                       ganhosComEventos[posicao] = Integer.parseInt(JOptionPane.showInputDialog("Por gentileza, insira somente números"));
                           }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
         ganhosComEventos[posicao] = 0;
         tenteNovamente = 1;
                      
                  }
              }
         tenteNovamente = 0;
  
    }
}
