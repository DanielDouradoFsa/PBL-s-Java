/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.organizer.model;

import br.uefs.ecomp.organizer.model.Sistema.Estoque;
import br.uefs.ecomp.organizer.model.Sistema.OperacoesEstoque;
import br.uefs.ecomp.organizer.util.MyLinkedList;
import java.text.ParseException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author administrador1
 */
public class PlanoDeCargaTeste {
    Estoque estoque;
    OperacoesEstoque itensEstoque;
    OperacoesEstoque itensEstoqueAuxiliarContainer;
    OperacoesEstoque itensEstoqueAuxiliarBalsa;
    OperacoesEstoque itensEstoqueAuxiliarCegonha;
    OperacoesEstoque itensEstoqueAuxiliarCarrForte;
    
    Barco BARCO;
    Barco BARCO1;
    
    Moto MOTO;
    Moto MOTO1;
    
    Carro CARRO;
    Carro CARRO1;
    Carro CARRO2;
    Carro CARRO3;
    
    Joia JOIA;
    Joia JOIA1;
    Joia JOIA2;
    Joia JOIA3;
    
    Quadro QUADRO;
    Quadro QUADRO1;
    Quadro QUADRO2;
    Quadro QUADRO3;
    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que são utilizados nos testes.
     * @throws java.text.ParseException
     */
    @Before
    public void setUp() throws ParseException{
        estoque= new Estoque();
        
        BARCO= new Barco("MotorBarco","10/01/2018","MarcaBarco","ModeloBarco","CodigoBarco",250000,1000,0,"01/01/2018",4000);
        BARCO1= new Barco("MotorBarco 1","11/02/2018","MarcaBarco 1","ModeloBarco 1","CodigoBarco 1",280000,900,10,"02/02/2018",11000);
        
        MOTO = new Moto("MotorMoto","CombustivelMoto","11/03/2018","MarcaMoto","ModeloMoto","CodigoMoto",200000,650,20,"02/03/2018",100);
        MOTO1 = new Moto("MotorMoto 1","CombustivelMoto 1","12/04/2018","MarcaMoto 1","ModeloMoto 1","CodigoMoto 1",20000,600,30,"01/07/2018",75);
        
        CARRO = new Carro("CombustivelCarro","13/05/2018","MarcaCarro","ModeloCarro","CodigoCarro",230000,750,40,"01/03/2018",500);
        CARRO1 = new Carro("CombustivelCarro 1","14/05/2018","MarcaCarro 1","ModeloCarro 1","CodigoCarro 1",225000,800,40,"01/06/2018",750);
        CARRO2 = new Carro("CombustivelCarro 2","15/05/2018","MarcaCarro 2","ModeloCarro 2","CodigoCarro 2",215000,725,40,"01/09/2018",1500);
        CARRO3 = new Carro("CombustivelCarro 3","16/05/2018","MarcaCarro 3","ModeloCarro 3","CodigoCarro 3",190000,700,40,"02/09/2018",2000);
        

        JOIA = new Joia("PedraJoia",4,"CodigoJoia",300000,200,50,"01/04/2018",0.05);
        JOIA1 = new Joia("PedraJoia 1",5,"CodigoJoia 1",290000,175,50,"01/05/2018",0.07);
        JOIA2 = new Joia("PedraJoia 2",9,"CodigoJoia 2",295000,150,50,"01/10/2018",0.08);
        JOIA3 = new Joia("PedraJoia 3",7,"CodigoJoia 3",297500,125,50,"01/11/2018",0.09);
        

        QUADRO = new Quadro(1,45,"AutorQuadro",2,"CodigoQuadro",270000,100,60,"01/08/2018",10);
        QUADRO1 = new Quadro(1,45,"AutorQuadro 1",3,"CodigoQuadro 1",260000,75,60,"02/08/2018",7);
        QUADRO2 = new Quadro(1,45,"AutorQuadro 2",8,"CodigoQuadro 2",255000,50,60,"02/10/2018",8);
        QUADRO3 = new Quadro(1,45,"AutorQuadro 3",6,"CodigoQuadro 3",240000,30,60,"01/12/2018",9);
        
        estoque.adicionarItem(JOIA);
        estoque.adicionarItem(JOIA1);
        estoque.adicionarItem(JOIA2);
        estoque.adicionarItem(JOIA3);
        
        estoque.adicionarItem(QUADRO);
        estoque.adicionarItem(QUADRO1);
        estoque.adicionarItem(QUADRO2);
        estoque.adicionarItem(QUADRO3);
        
        estoque.adicionarItem(MOTO);
        estoque.adicionarItem(MOTO1);
        
        estoque.adicionarItem(CARRO);
        estoque.adicionarItem(CARRO1);
        estoque.adicionarItem(CARRO2);
        estoque.adicionarItem(CARRO3);
        
        estoque.adicionarItem(BARCO);
        estoque.adicionarItem(BARCO1);
         
        itensEstoque=new OperacoesEstoque(estoque.itensEstoque());
       
    }
    /**
     * Testa algumas operações do Plano de Carga do Navio Container
     */
    @Test
    public void testPlanoNavioContainer(){

        MyLinkedList navioContainerTeste1=itensEstoque.planoContainers(0);//Capacidade de carga=0, ou seja, nenhum item será transportado
        assertNull(navioContainerTeste1);
        
                
        MyLinkedList navioContainerTeste2=itensEstoque.planoContainers(11000.29);//Capacidade de carga suficiente para transportar os 5 itens mais valiosos
        assertFalse(navioContainerTeste2.isEmpty());
        assertEquals(JOIA,navioContainerTeste2.get(0));
        assertEquals(JOIA3,navioContainerTeste2.get(1));
        assertEquals(JOIA2,navioContainerTeste2.get(2));
        assertEquals(JOIA1,navioContainerTeste2.get(3));
        assertEquals(BARCO1,navioContainerTeste2.get(4));
        
        MyLinkedList navioContainerTeste3=itensEstoque.planoContainers(14000);//Capacidade de carga suficiente para carregar os produtos, mais valiosos, restantes do estoque
        assertEquals(QUADRO,navioContainerTeste3.get(0));
        assertEquals(QUADRO1,navioContainerTeste3.get(1));
        assertEquals(QUADRO2,navioContainerTeste3.get(2));
        assertEquals(BARCO,navioContainerTeste3.get(3));
        assertEquals(QUADRO3,navioContainerTeste3.get(4));
        assertEquals(CARRO,navioContainerTeste3.get(5));
        assertEquals(CARRO1,navioContainerTeste3.get(6));
        assertEquals(CARRO2,navioContainerTeste3.get(7));
        assertEquals(MOTO,navioContainerTeste3.get(8));
        assertEquals(CARRO3,navioContainerTeste3.get(9));
        assertEquals(MOTO1,navioContainerTeste3.get(10));
        
    }
    /**
     * Testa algumas operações do Plano de Carga do Navio Balsa
     */
     @Test
    public void testPlanoNavioBalsa(){
        MyLinkedList navioBalsa1=itensEstoque.planoBalsa(0);//Capacidade de carga=0, ou seja, nenhum item será transportado
        assertNull(navioBalsa1);
        
        MyLinkedList navioBalsa2=itensEstoque.planoBalsa(605);//Capacidade de carga suficiente para suportar apenas os dois primeiros itens
        assertEquals(CARRO,navioBalsa2.get(0));
        assertEquals(MOTO,navioBalsa2.get(1));
        
        MyLinkedList navioBalsa3=itensEstoque.planoBalsa(9000);
        assertEquals(CARRO1,navioBalsa3.get(0));
        assertEquals(MOTO1,navioBalsa3.get(1));
        assertEquals(CARRO2,navioBalsa3.get(2));
        assertEquals(CARRO3,navioBalsa3.get(3));
    }
    /**
     * Testa algumas operações do Plano de Carga do Caminhao Cegonha
     */
    @Test
    public void testPlanoCaminhaoCegonha(){
        MyLinkedList caminhaoCegonha=itensEstoque.planoCaminhaoCegonha(0);//Capacidade de carga=0, ou seja, nenhum item será transportado
        assertNull(caminhaoCegonha);
         
        MyLinkedList planoCegonha1=itensEstoque.planoBalsa(1350);//Utiliza o plano balsa para levar 2 carros
        assertEquals(CARRO,planoCegonha1.get(0));
        assertEquals(MOTO,planoCegonha1.get(1));
        assertEquals(CARRO1,planoCegonha1.get(2));
        
        MyLinkedList planoCegonha2=itensEstoque.planoCaminhaoCegonha(3500);//Utilizando o plano cegonha, leva os 2 carros restantes
        assertEquals(CARRO3,planoCegonha2.get(0));
        assertEquals(CARRO2,planoCegonha2.get(1));   
    }
    /**
     * Testa algumas operações do Plano de Carga do Carro Forte
     */
    @Test
    public void testPlanoCarroForte(){
        MyLinkedList carroForte=itensEstoque.planoCarroForte(0);//Capacidade de carga=0, ou seja, nenhum item será transportado
        assertNull(carroForte);
        
        MyLinkedList carroForte1=itensEstoque.planoCarroForte(8.08);//Utiliza plano Carro Forte para transportar apenas os 2 mais prioritários
        assertEquals(JOIA2,carroForte1.get(0));
        assertEquals(QUADRO2,carroForte1.get(1));
        
        MyLinkedList carroForte2=itensEstoque.planoCarroForte(26.21);//Utliza plano Carro forte para transportar os demais itens, ordenados por prioridade
        assertEquals(JOIA3,carroForte2.get(0));
        assertEquals(QUADRO3,carroForte2.get(1));
        assertEquals(JOIA1,carroForte2.get(2));
        assertEquals(JOIA,carroForte2.get(3));
        assertEquals(QUADRO1,carroForte2.get(4));
        assertEquals(QUADRO,carroForte2.get(5));
         
    }
}
