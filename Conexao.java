//-------------------------------------------------------------------------------------------------------------------------------------------//
// Projeto Megasoft 1 Versão 2.0 do Sistema de Tributos Municipais com Banco de Dados: IPTU. ITBI e ISS, com implementação básica do REFIS;
// Autor: Daniel Guedes Fukuyoshi Garcia;
//-------------------------------------------------------------------------------------------------------------------------------------------//
// Pacote DataAcessObject;
package DataAcessObject;
// Importações de códigos para implementação na Classe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//-------------------------------------------------------------------------------------------------------------------------------------------//
// Classe Conexao;
public class Conexao {
    //---------------------------------------------------------------------------------------------------------------------------------------//
    // Métodos
    public Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/arrecadacao", "postgres", "postgres");
        return conexao;
    }
    //---------------------------------------------------------------------------------------------------------------------------------------//
    // Fim da Classe Conexao;
}
//-------------------------------------------------------------------------------------------------------------------------------------------//