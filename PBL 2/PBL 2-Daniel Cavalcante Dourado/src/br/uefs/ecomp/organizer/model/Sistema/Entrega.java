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
import br.uefs.ecomp.organizer.model.Produto;
import br.uefs.ecomp.organizer.util.MyLinkedList;
import Comparators.OrdenaPeloFrete;
import br.uefs.ecomp.organizer.util.Sort;

/**
 * @author Daniel Cavalcante Dourado
 */
public class Entrega {
    private MyLinkedList list= new MyLinkedList();
    private double pesoMaximo;
    private double valorMaximo;
    private double valorFreteMaximo;
    private String meioTransportado;
    private static int variavelAuxiliar=1;
    private int codigoDespacho;
    private int cont=0;

    
    /**
     * Construtor recebendo lista e o nome de um Plano de Carga 
     * @param list do Plano de Carga
     * @param meioTransporte Transporte do Plano de Carga
     */
    public Entrega(MyLinkedList list,String meioTransporte) {
        if(list!=null){
            while(cont<list.size()){
                if(((Produto)list.get(cont)).getVendido()==1){
                    pesoMaximo=pesoMaximo+((Produto)list.get(cont)).getPeso();
                    valorMaximo=valorMaximo+((Produto)list.get(cont)).getValorItem();
                    valorFreteMaximo=valorFreteMaximo+((Produto)list.get(cont)).getCustoFrete();
                    this.list.add(list.remove(cont));
                    cont--;
                }
                cont++;
            }
            Sort mergeSort=new Sort(new OrdenaPeloFrete());
            this.list.setReferenciaPrimeiro(mergeSort.mergeSort(this.list.getReferenciaPrimeiro()));
            list.atualizaReferencias();//Verifica se a lista utilizada está vazia, se estiver, torna a referencia do final nula
            this.meioTransportado=meioTransporte;
            codigoDespacho=variavelAuxiliar;
            variavelAuxiliar++;
            }
        }
    /**
     * Retorna a lista de despacho único
     * @return list
     */
    public MyLinkedList getList() {
        return list;
    }
    /**
     * Retorna o Peso total dos itens do Plano de Carga inserido
     * @return pesoMaximo
     */
    public double getPesoMaximo() {
        return pesoMaximo;
    }
    /**
     * Retorna o Valor total dos itens do Plano de Carga inserido
     * @return pesoMaximo
     */
    public double getValorMaximo() {
        return valorMaximo;
    }
    /**
     * Retorna o Valor de Frete total dos itens do Plano de Carga inserido
     * @return pesoMaximo
     */
    public double getValorFreteMaximo() {
        return valorFreteMaximo;
    }
    /**
     * Retorna o meio de transporte do Plano de Carga inserido
     * @return meioTransportado
     */
    public String getMeioTransportado() {
        return meioTransportado;
    }
    /**
     * Retorna o número de Despacho
     * @return codigoDespacho
     */
    public int getCodigoDespacho() {
        return codigoDespacho;
    }
}
