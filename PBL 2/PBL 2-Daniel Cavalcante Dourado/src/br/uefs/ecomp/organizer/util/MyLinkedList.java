/***
Autor: Daniel Cavalcante Dourado.
Componente Curricular: MI - Programação II
Concluido em: 02/10/2018
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum 
trecho de código de outro colega ou de outro autor, tais como provindos de livros e 
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
**/
package br.uefs.ecomp.organizer.util;
import br.uefs.ecomp.organizer.model.Produto;
import java.util.Iterator;
/**
 * @author Daniel Cavalcante Dourado.
 */
/**
 * 
 * @see List
 */
public class MyLinkedList implements IList{
    private  List referenciaPrimeiro;
    private List referenciaUltimo;
    private int totalDeCelulas;
    
    public MyLinkedList(){
        referenciaPrimeiro=null;
        referenciaUltimo=null;
        totalDeCelulas=0;
    }
    /**
     * Retorna o numero de "nós" inseridos na lista encadeada.
     * @return totalDeCelulas Quantidade de nós.
     */
    @Override
    public int size() {
        return totalDeCelulas;
    }

    public List getReferenciaPrimeiro() {
        return referenciaPrimeiro;
    }

    public void setReferenciaPrimeiro(List referenciaPrimeiro) {
        this.referenciaPrimeiro = referenciaPrimeiro;
    }
    
    /**
     * Insere um objeto ao final da lista.
     * @param obj que será inserido.
     */
    @Override
    public void add(Object obj) {
        if(referenciaPrimeiro==null){
            referenciaPrimeiro = new List();
            referenciaPrimeiro.setDados(obj);
            referenciaUltimo=referenciaPrimeiro; 
        }
        else{
            List novo= new List();
            novo.setDados(obj);
            referenciaUltimo.setProx(novo);
            referenciaUltimo=novo;
        }
        totalDeCelulas++;
    }

    /**
     * Insere um objeto em uma determinada posição na lista.
     * @param pos que será inserido o objeto.
     * @param obj a ser inserido.
     * @return True, so foi inserido, False, se não foi.
     */
    @Override
    public boolean add(int pos, Object obj) {
        if(pos<0 || pos>totalDeCelulas) //posicao invalida
            return false;
        if(pos == totalDeCelulas){ //inserir no final, e tambem trata quando for lista vazia
            add(obj);
            return true;
        }
        List atual=referenciaPrimeiro;
        List anterior = null;
        List noInserido = new List();
        noInserido.setDados(obj);
        int posicao=0;
        while(atual.getProx()!=null && posicao<pos){
            anterior=atual;
            atual= atual.getProx();
            posicao++;
        }
        if(posicao == 0){//Inserindo na primeira posição.
            referenciaPrimeiro = noInserido;
            referenciaPrimeiro.setProx(atual);
        }else{
            if(atual.getProx()==null){ //Inserindo na última posição.
                referenciaUltimo=atual;
                referenciaUltimo.setProx(noInserido);
                referenciaUltimo=noInserido;//Alterando a referencia do ultimo.
            }
            else{//Inserindo no meio da lita.
                anterior.setProx(noInserido);
                noInserido.setProx(atual);
            }
        }
                
        totalDeCelulas++;
        return true;
    }

    /**
     * Remove o objeto que está no final da lista.
     * @return Elemento retirado.
     */
    @Override
    public Object remove() {
        return remove(totalDeCelulas-1);
    }

    /**
     * Remove o objeto em uma determinada posição da lista.
     * @param pos que está o elemento.
     * @return Dados do elemento retirado.
     */
    @Override
    public Object remove(int pos) {
        if(pos < 0 || pos >= totalDeCelulas) //posição inválida
            return null; 
        List anterior = null;
        List atual = referenciaPrimeiro;
       /*
        *Dois auxiliares que irão percorrer a lista, um seguindo na frente do outro.
        */
        int teste=0;
        while(teste != pos){
            anterior=atual;
            atual=atual.getProx();
            teste++;
        }
        if(anterior == null){ //removendo o primeiro.
            referenciaPrimeiro = referenciaPrimeiro.getProx();
        }else{//removendo demais posicoes.
            anterior.setProx(atual.getProx());
        }
        
        totalDeCelulas--;
        return atual.getDados();
    }
    /**
     * Retorna um objeto da lista em uma determinada posição.
     * @param index posição desejada.
     * @return Dados desses objeto.
     */
    @Override
    public Object get(int index) {
        if(totalDeCelulas==0 || index<0 || index >= totalDeCelulas)
            return null;
        List objeto=referenciaPrimeiro;
        int auxiliar=0;
        while(auxiliar < index){//Avançando na lista ate encontrar o "nó" desejado.
            objeto = objeto.getProx();
            auxiliar++;
        }//Encontrou
        return objeto.getDados();
    }
    
    /**
     * Verifica se a lista está vazia, ou seja, se nenhum elemento foi inserido.
     * @return True, se está vazia, False se não está.
     */
    @Override
    public boolean isEmpty() {
        return referenciaPrimeiro==null;
    }
    /**
     * Verifica se a lista está vazia, se estiver, torna nula as referências do começo
     * e do final da lista.
     */
    public void atualizaReferencias(){
        if(totalDeCelulas==0){
            referenciaPrimeiro=null;
            referenciaUltimo=null;
        }
    }
}
