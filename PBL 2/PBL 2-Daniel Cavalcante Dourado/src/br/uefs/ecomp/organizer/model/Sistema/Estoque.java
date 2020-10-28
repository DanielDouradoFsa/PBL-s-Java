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
import Comparators.OrdenaPelaData;
import br.uefs.ecomp.organizer.util.MyLinkedList;
import br.uefs.ecomp.organizer.util.Sort;
import Comparators.OrdenaValorImposto;
import br.uefs.ecomp.organizer.model.Produto;
import java.util.Comparator;

/**
 * @author Daniel Cavalcante Dourado
 */
public class Estoque {
    MyLinkedList list = new MyLinkedList();
    MyLinkedList retorno;
    /**
     * Adiciona apenas Produto no Estoque
     * @param item produto a ser inserido
     * @return boolean, se houve a inserção, false se não houve
     */
    public boolean adicionarItem(Object item){
        if(item instanceof Produto){
            list.add(item);
            return true;
        }
        return false;
         
    }
    /**
     * Retorna os itens do estoque
     * @return list
     */
    public MyLinkedList itensEstoque(){
        if(list.getReferenciaPrimeiro()!=null)
            return list;
        return null;
    }
    /**
     * Retorna os itens do estoque ordenados por valor do imposto
     * @return retorno
     */
    public MyLinkedList relatorioTributacao(){
        Comparator ordenaPorImposto= new OrdenaValorImposto();
        Sort ordenacaoImposto= new Sort(ordenaPorImposto);
        retorno=list;
        retorno.setReferenciaPrimeiro(ordenacaoImposto.mergeSort(retorno.getReferenciaPrimeiro()));
        return retorno;
    }
    /**
     * Retorna os itens do estoque ordenados por valor data de chegada 
     * @return retorno
     */
    public MyLinkedList inventarioDeposito(){
        Comparator ordenaPorData= new OrdenaPelaData();
        Sort ordenacaoData= new Sort(ordenaPorData);
        retorno=list;
        retorno.setReferenciaPrimeiro(ordenacaoData.mergeSort(retorno.getReferenciaPrimeiro()));
        return retorno;
    }
} 

