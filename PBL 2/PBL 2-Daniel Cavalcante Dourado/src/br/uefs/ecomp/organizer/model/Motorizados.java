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
public class Motorizados extends Produto{
    private Date anoFabricacao;
    private String marca;
    private String modelo;
    SimpleDateFormat DataMotorizados=new SimpleDateFormat("DD/MM/YYYY");
    public Motorizados(String anoFabricacao, String marca, String modelo, String codigoIdentificador, int valorItem, int valorImposto, int custoFrete, String dataChegada, double peso) throws ParseException {
        super(codigoIdentificador, valorItem, valorImposto, custoFrete, dataChegada, peso);
        this.anoFabricacao = DataMotorizados.parse(anoFabricacao);
        this.marca = marca;
        this.modelo = modelo;
    }
    /**
     * Retorna ano de Fabricação do Produto
     * @return anoFabricação
     */
    public Date getAnoFabricacao() {
        return anoFabricacao;
    }
    /**
     * Retorna a marca do Produto
     * @return marca
     */
    public String getMarca() {
        return marca;
    }
    /**
     * Retorna o modelo de um Produto
     * @return 
     */
    public String getModelo() {
        return modelo;
    }
}
