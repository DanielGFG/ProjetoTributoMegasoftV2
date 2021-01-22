//-------------------------------------------------------------------------------------------------------------------------------------------//
// Projeto Megasoft 1 Versão 2.0 do Sistema de Tributos Municipais com Banco de Dados: IPTU. ITBI e ISS, com implementação básica do REFIS;
// Autor: Daniel Guedes Fukuyoshi Garcia;
//-------------------------------------------------------------------------------------------------------------------------------------------//
// Pacote Model;
package Model;
// Importações de códigos para implementação na Classe;
import java.text.ParseException           ;
import java.time.LocalDate                ;
import java.time.format.DateTimeFormatter ;
import java.time.temporal.ChronoUnit      ;

//-------------------------------------------------------------------------------------------------------------------------------------------//
// Classe Tributo;
public class Tributo{
    //---------------------------------------------------------------------------------------------------------------------------------------//
    // Atributos
    private String contribuinte   ;    // Proprietário do DUAM;
    private String cnpj           ;    // CNPJ do Proprietário
    private String dataPagamento  ;    // Data de Pagamento do Tributo;
    private String dataVencimento ;    // Data de Vencimento do Tributo;
    private int    diferencaData  ;    // Diferença entre as datas de pagamento e vencimento em dias;
    private float  valor          ;    // Valor do tributo;
    private float  multa          ;    // Valor da multa efetuada sobre o tributo;
    private float  juros          ;    // Valor do juros efetuado sobre o tributo;
    private float  refis          ;    // Valor do Refis a ser descontado sobre a soma da multa e do juros;
    private int    porcento       ;    // Valor inteiro da % do Refis;
    private String tipoTributo    ;    // Tipo de Tributo escolhido;
    
    //---------------------------------------------------------------------------------------------------------------------------------------//
    // Métodos
    // Função que calcula a diferença entre as datas de pagamento e vencimento do tributo;
    public void CalculaDiferencaDatas() throws ParseException{
        // Criação de duas classes para transformar datas de formato String em LocalDates
        LocalDate date, date2;
        // LocalDates formatarão as datas recebidas em String no formato "dd/MM/yyyy(dia/mês/ano)";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ("dd/MM/yyyy"), formatter2 = DateTimeFormatter.ofPattern ("dd/MM/yyyy");
        date  = LocalDate.parse (this.getDataPagamento(),  formatter  );
        date2 = LocalDate.parse (this.getDataVencimento(), formatter2 );
        // Variável DiferencaData recebe via set a uma classe que calcula a diferença entre a LocalDate(vencimento) e a LocalDate(pagamento);
        this.setDiferencaData ( (int) ChronoUnit.DAYS.between (date2, date) );
    }
    // Função que calcula a multa efetuada sobre diferença entre as datas de pagamento e vencimento do tributo;
    public void CalculaMulta() {
        // Ponto flutuante para efetuar a porcentagem da multa sobre o valor do tributo;
        float porcentagemMulta = (float) (2.00 / 100);
        this.setMulta (this.valor * porcentagemMulta);
    }
    // Função que a calcula o juros efetuado por dia baseado no tipo de tributo;
    public void CalculaJuros(){
        // Variável que calcula o valor do juros por dia;
        double valorJurosDia;
        // Verificação pelo tipoTributo de qual tributo foi utilizado;
        if (this.getTipoTributo() == "IPTU") {
            valorJurosDia = this.getValor() * (0.20 / 100);
            // Variável Juros recebe via setter o valor do juros por dia e multiplica pela quantidade de dias recebida pelo atributo DiferencaData via getter;
            this.setJuros( (float) (valorJurosDia * this.getDiferencaData() ) );
        } else if (this.getTipoTributo() == "ITBI") {
            valorJurosDia = this.getValor() * (0.25 / 100);
            // Variável Juros recebe via setter o valor do juros por dia e multiplica pela quantidade de dias recebida pelo atributo DiferencaData via getter;
            this.setJuros( (float) (valorJurosDia * this.getDiferencaData() ) );
        } else if (this.getTipoTributo() == "ISS") {
            valorJurosDia = this.getValor() * (0.33 / 100);
            // Variável Juros recebe via setter o valor do juros por dia e multiplica pela quantidade de dias recebida pelo atributo DiferencaData via getter;
            this.setJuros( (float) (valorJurosDia * this.getDiferencaData() ) );
        }
    }
    // Função que calcula o Refis, caso tenha, a ser descontado na soma da multa com o juros;
    public void CalculaRefis() {
        // Variável Refis recebe via setter o valor a ser descontado entre a soma de multa e juros;
        this.setRefis ( ( (this.getMulta() + this.getJuros()) / 100) * this.getPorcento() );
    }
    
    //---------------------------------------------------------------------------------------------------------------------------------------//
    // Métodos Especiais
    // Construtor da Classe Tributo
    public Tributo(String pagador, String cnpj, String dataPagamento, String dataVencimento, float valor, int porcento, String tipoTributo) {
        this.contribuinte = pagador;
        this.cnpj = cnpj;
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.porcento = porcento;
        this.tipoTributo = tipoTributo;
    }
    // Todos os getters e setters dos atributos da Classe;
    // Pagador;
    public String getContribuinte() {
        return this.contribuinte;
    }
    public void setContribuinte(String contribuinte) {
        this.contribuinte = contribuinte;
    }
    // CNPJ
    public String getCnpj() {
        return this.cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    // DataPagamento
    public String getDataPagamento() {
        return this.dataPagamento;
    }
    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    // DataVencimento
    public String getDataVencimento() {
        return this.dataVencimento;
    }
    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    // DiferencaData
    public int getDiferencaData() {
        return this.diferencaData;
    }
    public void setDiferencaData(int diferencaData) {
        this.diferencaData = diferencaData;
    }
    // Valor
    public float getValor() {
        return this.valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    // Multa
    public float getMulta() {
        return this.multa;
    }
    public void setMulta(float multa) {
        this.multa = multa;
    }
    // Juros
    public float getJuros() {
        return this.juros;
    }
    public void setJuros(float juros) {
        this.juros = juros;
    }
    // Refis
    public float getRefis() {
        return this.refis;
    }
    public void setRefis(float refis) {
        this.refis = refis;
    }
    // Porcento
    public int getPorcento() {
        return this.porcento;
    }
    public void setPorcento(int porcento) {
        this.porcento = porcento;
    }
    // Tipo Tributo
    public String getTipoTributo() {
        return this.tipoTributo;
    }
    public void setTipoTributo(String tipoTributo) {
        this.tipoTributo = tipoTributo;
    }
    //---------------------------------------------------------------------------------------------------------------------------------------//
    // Fim da Classe Tributo;
}
//-------------------------------------------------------------------------------------------------------------------------------------------//