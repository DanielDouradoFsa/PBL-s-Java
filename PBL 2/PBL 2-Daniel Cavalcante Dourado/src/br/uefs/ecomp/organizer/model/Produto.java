/***
Autor: Daniel Cavalcante Dourado.
Componente Curricular: MI - Programação II
Concluido em: 12/11/2018
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum 
trecho de código de outro colega ou de outro autor, tais como provindos de livros e 
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
*/
package br.uefs.ecomp.organizer.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Daniel Cavalcante Dourado
 */
public class Produto{
    private String codigoIdentificador;
    private double valorItem;
    private int valorImposto;
    private int custoFrete;
    private Date dataChegada;
    private double peso;
    private int vendido;
    private static int auxiliarDespacho=1;
    private int identificadorDeDespacho;
    private String meioTransportado;
    
    SimpleDateFormat Data=new SimpleDateFormat("dd/MM/yyyy");

    public Produto(String codigoIdentificador, int valorItem, int valorImposto, int custoFrete, String dataChegada, double peso) throws ParseException {
        this.codigoIdentificador = codigoIdentificador;
        this.valorItem = valorItem;
        this.valorImposto = valorImposto;
        this.custoFrete = custoFrete;
        this.dataChegada = Data.parse(dataChegada);
        this.peso = peso;
        this.vendido = 0;
        identificadorDeDespacho=auxiliarDespacho++;
    }
    /**
     * Retorna o codigoIdentificador do produto.
     * @return codigoIdentificador
     */
    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }
    /**
     * Retorna o valor do item.
     * @return valorItem
     */
    public double getValorItem() {
        return valorItem;
    }
    /**
     * Retorna o valor do imposto do item.
     * @return valorImposto
     */
    public int getValorImposto() {
        return valorImposto;
    }
    /**
     * Retorna o custo de frete do produto.
     * @return custoFrete
     */
    public int getCustoFrete() {
        return custoFrete;
    }
    /**
     * Retorna a data de chegada do produto.
     * @return dataChegada
     */
    public Date getDataChegada() {
        return dataChegada;
    }
    /**
     * Retorna o peso do produto.
     * @return peso
     */
    public double getPeso() {
        return peso;
    }
    /**
     * Retorna 0 se o item ainda não foi vendido e 1 se já foi vendido.
     * @return vendido
     */
    public int getVendido() {
        return vendido;
    }
    /**
     * Altera um item de não vendido para vendido.
     * @param vendido Valor diferente de 0, classificando o item como vendido
     */
    public void setVendido(int vendido) {
        this.vendido = vendido;
    }
    /**
     * Retorna o Identificador de despacho.
     * @return identificadorDeDespachos
     */
    public int getIdentificadorDeDespacho() {
        return identificadorDeDespacho;
    }
    /**
     * Retorna o meio de transporte que o item foi levado.
     * @return meioTransporte
     */
    public String getMeioTransportado() {
        return meioTransportado;
    }
    /**
     * Altera o meio de transporte de um item.
     * @param meioTrasportado Novo meio de transporte do item
     */
    public void setMeioTransportado(String meioTrasportado){
        this.meioTransportado=meioTrasportado;
    }

    
    
}
