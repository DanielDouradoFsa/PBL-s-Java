/***
Autor: Daniel Cavalcante Dourado.
Componente Curricular: MI - Programação II
Concluido em: 02/10/2018
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum 
trecho de código de outro colega ou de outro autor, tais como provindos de livros e 
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
*/
package br.uefs.ecomp.organizer.util;

/**
 * @author Daniel Cavalcante Dourado.
 */
public class List {
    Object dados;
    List prox;
    /**
     * Retorna o dado contido no futuro "nó" da lista encadeada.
     * @return, dado do futuro "nó".
     */
    public Object getDados() {
        return dados;
    }
    /**
     * Altera o dado do futuro "nó" da lista encadeada.
     * @param dados, novo dado da classe.
     */
    public void setDados(Object dados) {
        this.dados = dados;
    }
    /**
     * Retorna a referência para o próximo "nó" da lista encadeade.
     * @return próximo elemento da lista
     */
    public List getProx() {
        return prox;
    }
    /**
     * Altera a referência para o próximo "nó" da lista encadeade.
     * @param prox, novo proximo "nó" da lista.
     */
    public void setProx(List prox) {
        this.prox =  prox;
    }
}
