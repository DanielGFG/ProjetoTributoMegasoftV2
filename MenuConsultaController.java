//-------------------------------------------------------------------------------------------------------------------------------------------//
// Projeto Megasoft 1 Versão 2.0 do Sistema de Tributos Municipais com Banco de Dados: IPTU. ITBI e ISS, com implementação básica do REFIS;
// Autor: Daniel Guedes Fukuyoshi Garcia;
//-------------------------------------------------------------------------------------------------------------------------------------------//
// Pacote Controller;
package Controller;
// Importações de códigos para implementação na Classe;
import DataAcessObject.Conexao;
import View.MenuConsultaView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//-------------------------------------------------------------------------------------------------------------------------------------------//
// Classe MenuConsultaController;
public class MenuConsultaController {
    //---------------------------------------------------------------------------------------------------------------------------------------//
    // Atributos
    // Cria um atributo view do tipo MenuConsultaView
    private final MenuConsultaView view;
    
    //---------------------------------------------------------------------------------------------------------------------------------------//
    // Métodos Especiais
    // Construtor da Classe MenuConsultaController
    public MenuConsultaController(MenuConsultaView view) {
        this.view = view;
    }
    
    //---------------------------------------------------------------------------------------------------------------------------------------//
    // Métodos
    // Função de Consultar DUAM
    public void ConsultaDuam(){
        // Tratamento de execeção para campos input vazios
        if ( view.getConsultaNome().getText().isEmpty() && view.getConsultaCpfCnpj().getText().isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Erro!\nAtenção, informe nome ou CPF/CNPJ para executar a consulta!");
        }
        // Try-Catch da execução de consulta java-sql
        try{
            // Função de apagar a tabela de resultados
            ((DefaultTableModel) view.getTabelaConsulta().getModel()).setRowCount(0);
            // Codificação sql
            String sql = "SELECT d.id_duam, d.valor_duam, d.data_vencimento_duam, "
                    + "d.cod_barra_duam, e.sigla_tributo FROM duam d JOIN tributo e "
                    + "ON d.id_tributo = e.id_tributo JOIN contribuinte c "
                    + "ON d.id_inscricao_municipal = c.id_inscricao_municipal "
                    + "WHERE c.nome_razao_social = '" + view.getConsultaNome().getText()
                    + "' OR c.cpf_cnpj = '" + view.getConsultaCpfCnpj().getText() + "';";
            // Criando conexão com banco de dados e executando codificação sql
            Connection conexao = new Conexao().getConnection();
            Statement estado = conexao.createStatement();
            ResultSet resultado = estado.executeQuery(sql);
            // While para exibir resultado da codificação sql no jTable-SwingNetbeans-Java
            while ( resultado.next() ) {
                DefaultTableModel tm = (DefaultTableModel) view.getTabelaConsulta().getModel();
                String dados[] = { resultado.getString( (String) "id_duam"),
                                   resultado.getString( (String) "valor_duam"),
                                   resultado.getString("data_vencimento_duam"),
                                   resultado.getString("sigla_tributo"),
                                   resultado.getString("cod_barra_duam")
                };
                tm.addRow(dados);
            }          
        } catch (SQLException ex) {
            Logger.getLogger(MenuConsultaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Função de Consultar Pessoa
    public void ConsultaPessoa(){
        // Tratamento de execeção para campos input vazios
        if ( view.getConsultaNome().getText().isEmpty() && view.getConsultaCpfCnpj().getText().isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Erro!\nAtenção, informe nome ou CPF/CNPJ para executar a consulta!");
        }
        // Try-Catch da execução de consulta java-sql
        try{    
            // Codificação sql
            String sql = "SELECT c.cpf_cnpj, c.nome_razao_social, c.cep, c.cidade, "
                    + "c.estado, c.telefone, c.whatsapp, COUNT(d.id_duam), SUM(d.valor_duam) "
                    + "FROM duam d JOIN contribuinte c "
                    + "ON d.id_inscricao_municipal = c.id_inscricao_municipal "
                    + "WHERE c.nome_razao_social = '" + view.getConsultaNome().getText()
                    + "' OR c.cpf_cnpj = '" + view.getConsultaCpfCnpj().getText() + "' "
                    + "GROUP BY c.nome_razao_social, c.cpf_cnpj, c.cep, c.cidade, "
                    + "c.estado, c.telefone, c.whatsapp;";
            // Criando conexão com banco de dados e executando codificação sql
            Connection conexao = new Conexao().getConnection();
            Statement estado = conexao.createStatement();
            ResultSet resultado = estado.executeQuery(sql);
            // Declarando atributo String area_texto
            String area_texto = "";
            // While para exibir resultado da codificação sql no jTable-SwingNetbeans-Java
            while (resultado.next()) {
                area_texto = "Nome: " + resultado.getString("nome_razao_social")
                    + "\nCPF/CNPJ:  " + resultado.getString("cpf_cnpj") + "\nCEP: "
                    + resultado.getString("cep") + "\nCidade: " + resultado.getString("cidade")
                    + "\nEstado: " + resultado.getString("estado") + "\nTelefone: "
                    + resultado.getString("telefone") + "\nWhatsApp: " + resultado.getString("whatsapp")
                    + "\nQuantidade Total de DUAM's: " + resultado.getInt("COUNT") + "\nValor Total das DUAM's: " + resultado.getFloat("SUM");
            }
            // jTextArea recebendo o resultado do while
            view.getAreaTextoConsulta().setText(area_texto);            
        } catch (SQLException ex) {
            Logger.getLogger(MenuConsultaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------------------//
    // Fim da Classe MenuConsultaController;
}
//-------------------------------------------------------------------------------------------------------------------------------------------//