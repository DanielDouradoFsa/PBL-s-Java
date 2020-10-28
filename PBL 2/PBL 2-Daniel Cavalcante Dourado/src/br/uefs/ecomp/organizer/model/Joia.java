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

/**
 * @author Daniel Cavalcante Dourado
 */
public class Joia extends ProdutoFragel{
    private String tipoPedraPreciosa;

    public Joia(String tipoPedraPreciosa,int grauPrioridade,String codigoIdentificador, int valorItem, int valorImposto, int custoFrete, String dataChegada, double peso) throws ParseException {
        super(grauPrioridade, codigoIdentificador, valorItem, valorImposto, custoFrete, dataChegada, peso);
        this.tipoPedraPreciosa=tipoPedraPreciosa;
    }

    /**
     * Retorna o tipo de pedra preciosa da Joia
     * @return tipoPedraPreciosa
     */
    public String getTipoPedraPreciosa() {
        return tipoPedraPreciosa;
    }

}
