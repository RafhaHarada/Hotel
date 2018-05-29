import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author Cidmar
 */
public class Custos {
    
    String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}; 
    static double[] aguaCustos = new double[12];
    static double[] energiaCustos = new double[12];
    static double[] gastosComMantimentos = new double[12];
    static double[] gastosComManutencoes = new double[12];
    static double[] gastosComFuncionarios = new double[12];
    static double[] gastosComLimpezas = new double[12];
    static double[] gastosComTelefoneEInternets = new double[12];
    static double[] gastosComMarketings = new double[12];
    int atual = 0;
   
    
    
    
    public void menu(){
    Object[] options = {"Cadastrar", "Editar", "Listar", "Gastos do Ano", "Voltar"};
        int menu = 0;

        while (menu != 5) {
            menu = JOptionPane.showOptionDialog(
                    null,
                    "Tabela de custos"
                    + "Selecione uma das opções abaixo:",
                    "Administração de Custos",
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
                    gastoAnual();
                    break;
                case 4:
                    return;
                default:
                    return;
            }}}
    
    public void cadastrar() {
       solicitarInformacao(atual);
       atual++;
    }
    public void editar(){
       Object[] custos = new Object[atual];
        for (int i = 0; i < atual; i++) {
            custos[i] = meses[i];
        }

        int posicao = JOptionPane.showOptionDialog(null,
                atual > 0 ? "Selecione o mês para editar"
                        : "Nenhum mês cadastrado",
                "Aviso",
                0, JOptionPane.QUESTION_MESSAGE, null, custos, "");
        if (posicao != JOptionPane.CLOSED_OPTION) {
            solicitarInformacao(posicao);
            
        }
}
    public void listar(){
         Object[] custos = new Object[atual];
        for (int i = 0; i < atual; i++) {
            custos[i] = meses[i];
        }

        int posicao = JOptionPane.showOptionDialog(null,
                atual > 0 ? "Selecione o mês que deseja visualizar"
                        : "Nenhum mês cadastrado",
                "Aviso",
                0, JOptionPane.QUESTION_MESSAGE, null, custos, "");
        if (posicao != JOptionPane.CLOSED_OPTION) {
            apresentarInformacao(posicao);
            
        }

    }
    
    public void gastoAnual(){
        double total = 0;
        for(int i = 0; i < aguaCustos.length; i++)
            
            total += aguaCustos[i] + energiaCustos[i] + gastosComMantimentos[i]
                     + gastosComManutencoes[i] + gastosComFuncionarios[i]
                     + gastosComLimpezas[i] + gastosComTelefoneEInternets[i]
                     + gastosComMarketings[i];
        JOptionPane.showMessageDialog(null, "O total gasto no ano foi de: R$" + total);
    }
    
    public void apresentarInformacao(int posicao){
        double totalMes = 0;
        
        totalMes += aguaCustos[posicao] + energiaCustos[posicao] 
                    + gastosComMantimentos[posicao] + gastosComManutencoes[posicao]
                    + gastosComFuncionarios[posicao] + gastosComLimpezas[posicao] 
                    + gastosComTelefoneEInternets[posicao] + gastosComMarketings[posicao];
        
        JOptionPane.showMessageDialog(null, 
                "Lista de Custos"
                +"\nÁgua: R$" + String.format("%.2f", aguaCustos[posicao])
                + "\nEnergia: R$" + String.format("%.2f", energiaCustos[posicao])
                + "\nMantimentos: R$" + String.format("%.2f", gastosComMantimentos[posicao])
                + "\nManutenção: R$" + String.format("%.2f", gastosComManutencoes[posicao])
                + "\nFuncionários: R$" + String.format("%.2f", gastosComFuncionarios[posicao])
                + "\nLimpeza: R$" + String.format("%.2f", gastosComLimpezas[posicao])
                + "\nTelefone e Internet: R$" + String.format("%.2f", gastosComTelefoneEInternets[posicao])
                + "\nMarketing: R$" + String.format("%.2f", gastosComMarketings[posicao])
                + "\nTotal gasto no mês: R$" + String.format("%.2f", totalMes)
        );
    }
            
    public void solicitarInformacao(int posicao){
         aguaCustos[posicao] = 0;
         int tenteNovamente = 0;
          while (aguaCustos[posicao] == 0) {
              try { 
                  if (tenteNovamente == 0) {
                     aguaCustos[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe o valor gasto com água", 
                    aguaCustos[posicao] != 0 ? aguaCustos[posicao] : 0)
                .replace(" ", "").replace("RS", "")
                .replace(".", "").replace(",", ".")
         );
                     } else {
                       aguaCustos[posicao] = Double.parseDouble(JOptionPane.showInputDialog("Por gentileza, insira somente números"));
                           }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
         aguaCustos[posicao] = 0;
         tenteNovamente = 1;
                      
                  }
              }
         tenteNovamente = 0;
        
        
         energiaCustos[posicao] = 0;
         tenteNovamente = 0;
          while (energiaCustos[posicao] == 0) {
              try { 
                  if (tenteNovamente == 0) {
                   energiaCustos[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe o valor gasto com energia",
                     energiaCustos[posicao] != 0 ? energiaCustos[posicao] : 0)
                .replace(" ", "").replace("RS", "")
                .replace(".", "").replace(",", ".")
         );
                     } else {
                       energiaCustos[posicao] = Integer.parseInt(JOptionPane.showInputDialog("Por gentileza, insira somente números"));
                           }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
         energiaCustos[posicao] = 0;
         tenteNovamente = 1;
                      
                  }
              }
         tenteNovamente = 0;
            
                         
          
         gastosComMantimentos[posicao] = 0;
         tenteNovamente = 0;
          while (gastosComMantimentos[posicao] == 0) {
              try { 
                  if (tenteNovamente == 0) {
                  gastosComMantimentos[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe o valor gasto com mantimentos",
                     gastosComMantimentos[posicao] != 0 ? gastosComMantimentos[posicao] : 0)
                .replace(" ", "").replace("RS", "")
                .replace(".", "").replace(",", ".")
         );
                     } else {
                       gastosComMantimentos[posicao] = Integer.parseInt(JOptionPane.showInputDialog("Por gentileza, insira somente números"));
                           }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
         gastosComMantimentos[posicao] = 0;
         tenteNovamente = 1;
                      
                  }
              }
         tenteNovamente = 0;
        
          
         gastosComManutencoes[posicao] = 0;
         tenteNovamente = 0;
          while (gastosComManutencoes[posicao] == 0) {
              try { 
                  if (tenteNovamente == 0) {
                 gastosComManutencoes[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe o valor gasto com manutenção",
                     gastosComManutencoes[posicao] != 0 ? gastosComManutencoes[posicao] : 0)
                .replace(" ", "").replace("RS", "")
                .replace(".", "").replace(",", ".")
        );
                     } else {
                       gastosComManutencoes[posicao] = Integer.parseInt(JOptionPane.showInputDialog("Por gentileza, insira somente números"));
                           }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
         gastosComManutencoes[posicao] = 0;
         tenteNovamente = 1;
                      
                  }
              }
         tenteNovamente = 0;
        
          
         gastosComFuncionarios[posicao] = 0;
         tenteNovamente = 0;
          while (gastosComFuncionarios[posicao] == 0) {
              try { 
                  if (tenteNovamente == 0) {
                gastosComFuncionarios[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe o valor gasto com fucionários",
                     gastosComFuncionarios[posicao] != 0 ? gastosComFuncionarios[posicao] : 0)
                .replace(" ", "").replace("RS", "")
                .replace(".", "").replace(",", ".")
        );
                     } else {
                       gastosComFuncionarios[posicao] = Integer.parseInt(JOptionPane.showInputDialog("Por gentileza, insira somente números"));
                           }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
         gastosComFuncionarios[posicao] = 0;
         tenteNovamente = 1;
                      
                  }
              }
         tenteNovamente = 0;
        
          
         gastosComLimpezas[posicao] = 0;
         tenteNovamente = 0;
          while (gastosComLimpezas[posicao] == 0) {
              try { 
                  if (tenteNovamente == 0) {
               gastosComLimpezas[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe o valor gasto com limpeza",
                     gastosComLimpezas[posicao] != 0 ? gastosComLimpezas[posicao] : 0)
                .replace(" ", "").replace("RS", "")
                .replace(".", "").replace(",", ".")
        );
                     } else {
                       gastosComLimpezas[posicao] = Integer.parseInt(JOptionPane.showInputDialog("Por gentileza, insira somente números"));
                           }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
         gastosComLimpezas[posicao] = 0;
         tenteNovamente = 1;
                      
                  }
              }
         tenteNovamente = 0;
        
          
         gastosComTelefoneEInternets[posicao] = 0;
         tenteNovamente = 0;
          while (gastosComTelefoneEInternets[posicao] == 0) {
              try { 
                  if (tenteNovamente == 0) {
               gastosComTelefoneEInternets[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe o valor gasto com telefone e internet",
                     gastosComTelefoneEInternets[posicao] != 0 ? gastosComTelefoneEInternets[posicao] : 0)
                .replace(" ", "").replace("RS", "")
                .replace(".", "").replace(",", ".")
        );
                     } else {
                       gastosComTelefoneEInternets[posicao] = Integer.parseInt(JOptionPane.showInputDialog("Por gentileza, insira somente números"));
                           }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
         gastosComTelefoneEInternets[posicao] = 0;
         tenteNovamente = 1;
                      
                  }
              }
         tenteNovamente = 0;
        
        gastosComMarketings[posicao] = 0;
         tenteNovamente = 0;
          while (gastosComMarketings[posicao] == 0) {
              try { 
                  if (tenteNovamente == 0) {
               gastosComMarketings[posicao] = Double.parseDouble(
            JOptionPane.showInputDialog(
                "Informe o valor gasto com marketing",
                     gastosComMarketings[posicao] != 0 ? gastosComMarketings[posicao] : 0)
                .replace(" ", "").replace("RS", "")
                .replace(".", "").replace(",", ".")
        );
                     } else {
                       gastosComMarketings[posicao] = Integer.parseInt(JOptionPane.showInputDialog("Por gentileza, insira somente números"));
                           }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
         gastosComMarketings[posicao] = 0;
         tenteNovamente = 1;
                      
                  }
              }
         tenteNovamente = 0;
        
    }
}
