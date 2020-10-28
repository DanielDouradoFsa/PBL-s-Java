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
import br.uefs.ecomp.organizer.util.MyLinkedList;
import br.uefs.ecomp.organizer.model.Carro;
import br.uefs.ecomp.organizer.model.Moto;
import br.uefs.ecomp.organizer.model.Produto;
import br.uefs.ecomp.organizer.model.ProdutoFragel;
import Comparators.OrdenaPelaData;
import Comparators.OrdenaPorPeso;
import Comparators.OrdenaPorPrioridade;
import Comparators.OrdenaPorValor;
import java.util.Comparator;
import br.uefs.ecomp.organizer.util.Sort;

/**
 * @author Daniel Cavalcante Dourado
 */
public class OperacoesEstoque{
    double sobra=0;
    MyLinkedList list= new MyLinkedList();
    public OperacoesEstoque(MyLinkedList list) {
        this.list=list;
    }
    int cont;
    Produto castProduto;
    /**
     * Verifica no estoque a existencia de Produto e os adiciona até que a capacidade seja atingida
     * @param capacidade da carga
     * @return Plano de Carga Navio Container
     */
    public MyLinkedList planoContainers(double capacidade){
        if(capacidade==0){
            return null;
        }
        MyLinkedList listaOrdenadaPorValor = new MyLinkedList();
        MyLinkedList planoDeCargaContainer = new MyLinkedList();
        sobra=capacidade;

        for(cont=0; cont<list.size();cont++){
            if( ((Produto)list.get(cont)).getVendido()==0)
                listaOrdenadaPorValor.add(list.get(cont));
            /*Nao é necessario checar o "instanceof" pois, no estoque, só há produtos.
            O plano de container recebe todos os produtos*/
        }
        if(listaOrdenadaPorValor.isEmpty()){//Se não há produtos elegíveis ao plano de carga, retorna nulo
            return null;
        }
        Comparator comparatorValor=new OrdenaPorValor();
        Sort ordenaPorValor=new Sort(comparatorValor);
        listaOrdenadaPorValor.setReferenciaPrimeiro(ordenaPorValor.mergeSort(listaOrdenadaPorValor.getReferenciaPrimeiro()));
        
        for(cont=0;cont<listaOrdenadaPorValor.size();cont++){
            castProduto =(Produto)listaOrdenadaPorValor.get(cont);
            sobra=sobra-castProduto.getPeso();
            if(sobra>=0){
                castProduto.setVendido(1);
                castProduto.setMeioTransportado("Container");
                planoDeCargaContainer.add(castProduto);
            }
        }
        listaOrdenadaPorValor.setReferenciaPrimeiro(null);//Elimina lista auxiliar
        return planoDeCargaContainer;
    }
    /**
     * Verifica no estoque a existencia de Produtos, do tipo Moto ou Carro, e os
     * adiciona até que a capacidade seja atingida
     * @param capacidade de carga
     * @return Plano de Carga do Navio Balsa
     */
    public MyLinkedList planoBalsa(double capacidade){
        if(capacidade==0){
            return null;
        }
        MyLinkedList listaOrdenadaPorData = new MyLinkedList();
        MyLinkedList planoDeCargaBalsa= new MyLinkedList();
        sobra=capacidade;
        for(cont=0;cont<list.size();cont++){
            if(list.get(cont) instanceof Moto || list.get(cont) instanceof Carro){
                if(((Produto)list.get(cont)).getVendido()==0)
                    listaOrdenadaPorData.add(list.get(cont));
            }
        }
        if(listaOrdenadaPorData.isEmpty()){
            return null;
        }
        Comparator comparatorData=new OrdenaPelaData();
        Sort ordenaPorData=new Sort(comparatorData);
        listaOrdenadaPorData.setReferenciaPrimeiro(ordenaPorData.mergeSort(listaOrdenadaPorData.getReferenciaPrimeiro()));    
        
        for(cont=0;cont<listaOrdenadaPorData.size();cont++){    
            castProduto = (Produto)listaOrdenadaPorData.get(cont);
            sobra=sobra-castProduto.getPeso();
            if(sobra>=0){
                castProduto.setMeioTransportado("Navio Balsa");
                castProduto.setVendido(1);
                planoDeCargaBalsa.add(castProduto);    
            }
        }
        listaOrdenadaPorData.setReferenciaPrimeiro(null);
        return planoDeCargaBalsa;
    }
    /**
     * Verifica no estoque a existencia de Produtos, do tipo Carro, e os
     * adiciona até que a capacidade seja atingida
     * @param capacidade de carga
     * @return Plano de Carga Caminhão Cegonha
     */
    public MyLinkedList planoCaminhaoCegonha(double capacidade){
        if(capacidade==0){
            return null;
        }
        MyLinkedList listaOrdenadaPorPeso = new MyLinkedList();
        MyLinkedList planoDeCargaCegonha = new MyLinkedList();
        sobra=capacidade;
        for(cont=0;cont<list.size();cont++){
            if(list.get(cont) instanceof Carro && ((Produto)list.get(cont)).getVendido()==0)
                listaOrdenadaPorPeso.add(list.get(cont));
        }
        if(listaOrdenadaPorPeso.isEmpty()){
            return null;
        }
        Comparator comparatorPeso=new OrdenaPorPeso();
        Sort ordenaPorPeso=new Sort(comparatorPeso);
        listaOrdenadaPorPeso.setReferenciaPrimeiro(ordenaPorPeso.mergeSort(listaOrdenadaPorPeso.getReferenciaPrimeiro()));
                
        for(cont=0;cont<listaOrdenadaPorPeso.size();cont++){    
            castProduto = (Produto)listaOrdenadaPorPeso.get(cont);
            sobra=sobra-castProduto.getPeso();
            if(sobra>=0 ){
                castProduto.setVendido(1);
                castProduto.setMeioTransportado("Caminhao Cegonha");
                planoDeCargaCegonha.add(listaOrdenadaPorPeso.get(cont));   
            }
        }
        listaOrdenadaPorPeso.setReferenciaPrimeiro(null);
        return planoDeCargaCegonha;
    }
    /**
     * Verifica no estoque a existencia de Produtos Frágeis e os
     * adiciona até que a capacidade seja atingida
     * @param capacidade de carga
     * @return Plano de Carga Carro Forte
     */
    public MyLinkedList planoCarroForte(double capacidade){
        if(capacidade==0){
            return null;
        }
        MyLinkedList listaOrdenadaPorPrioridade = new MyLinkedList();
        MyLinkedList planoDeCargaCarroForte = new MyLinkedList();
        sobra=capacidade;

        for(cont=0;cont<list.size();cont++){
            if(list.get(cont) instanceof ProdutoFragel && ((Produto)list.get(cont)).getVendido()==0)
                listaOrdenadaPorPrioridade.add(list.get(cont));
        }
        if(listaOrdenadaPorPrioridade.isEmpty()){
            return null;
        }
        Comparator comparatorPrioridade=new OrdenaPorPrioridade();
        Sort ordenaPorPrioridade=new Sort(comparatorPrioridade);
        listaOrdenadaPorPrioridade.setReferenciaPrimeiro(ordenaPorPrioridade.mergeSort(listaOrdenadaPorPrioridade.getReferenciaPrimeiro()));
                
        for(cont=0;cont<listaOrdenadaPorPrioridade.size();cont++){    
            castProduto = (Produto)listaOrdenadaPorPrioridade.get(cont);
            sobra=sobra-castProduto.getPeso();
            if(sobra>=0){
                castProduto.setVendido(1);
                castProduto.setMeioTransportado("Carro Forte");
                planoDeCargaCarroForte.add(listaOrdenadaPorPrioridade.get(cont));   
            }
        }
        listaOrdenadaPorPrioridade.setReferenciaPrimeiro(null);
        return planoDeCargaCarroForte;
    }    
}

    
    
   

