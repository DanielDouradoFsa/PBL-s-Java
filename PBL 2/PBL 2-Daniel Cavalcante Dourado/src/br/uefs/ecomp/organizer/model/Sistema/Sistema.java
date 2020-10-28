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
package br.uefs.ecomp.organizer.model.Sistema;

import Comparators.OrdenaPorValorDespacho;
import br.uefs.ecomp.organizer.model.Produto;
import br.uefs.ecomp.organizer.util.MyLinkedList;
import br.uefs.ecomp.organizer.util.Sort;

/**
 * @author Daniel Cavalcante Dourado
 */
public class Sistema {
    private MyLinkedList despachos=new MyLinkedList();

    public Sistema() {}
    
    /**
     * Remove os itens que ja foram vendidos do estoque
     * @param c Lista do estoque
     */
    public void atualizaEstoque(MyLinkedList c){
        int cont=0;
        while(cont<c.size()){
            if(((Produto)c.get(cont)).getVendido()==1){
                c.remove(cont);
                cont--;
            }
            cont++;
        }
        c.atualizaReferencias();
    }
    /**
     * Adiciona um despacho ao sistema
     * @param c Despacho qualquer
     */
    public void add(Entrega c){
        despachos.add(c);
    }
    /**
     * Ordena os despachos por valor Máximo de carga
     */
    public void ordenaDespachos(){
        Sort mergeSort= new Sort(new OrdenaPorValorDespacho());
        despachos.setReferenciaPrimeiro(mergeSort.mergeSort(despachos.getReferenciaPrimeiro()));
    }
    /**
     * Retorna lista de despachos
     * @return 
     */
    public MyLinkedList getDespachos() {
        return despachos;
    }
}
