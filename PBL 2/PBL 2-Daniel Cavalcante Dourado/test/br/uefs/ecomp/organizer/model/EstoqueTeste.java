/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.organizer.model;
import br.uefs.ecomp.organizer.model.Sistema.Estoque;
import java.text.ParseException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author administrador1
 */
public class EstoqueTeste {
    Estoque estoque;
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
        
        
        BARCO= new Barco("MotorBarco 1","10/01/2018","MarcaBarco 1","ModeloBarco 1","CodigoBarco 1",250000,1000,0,"01/01/2018",4000);
        BARCO1= new Barco("MotorBarco 2","11/02/2018","MarcaBarco 2","ModeloBarco 2","CodigoBarco 2",280000,900,10,"02/02/2018",11000);
        
        MOTO = new Moto("MotorMoto 1","CombustivelMoto 1","11/03/2018","MarcaMoto 1","ModeloMoto 1","CodigoMoto 1",200000,650,20,"02/03/2018",105);
        MOTO1 = new Moto("MotorMoto 2","CombustivelMoto 2","12/04/2018","MarcaMoto 2","ModeloMoto 2","CodigoMoto 2",20000,600,30,"01/07/2018",75);
        
        CARRO = new Carro("CombustivelCarro 1","13/05/2018","MarcaCarro 1","ModeloCarro 1","CodigoCarro 1",250000,750,40,"01/03/2018",500);
        CARRO1 = new Carro("CombustivelCarro 2","14/05/2018","MarcaCarro 2","ModeloCarro 2","CodigoCarro 2",225000,800,40,"01/06/2018",750);
        CARRO2 = new Carro("CombustivelCarro 3","15/05/2018","MarcaCarro 3","ModeloCarro 3","CodigoCarro 3",215000,725,40,"01/09/2018",1500);
        CARRO3 = new Carro("CombustivelCarro 4","16/05/2018","MarcaCarro 4","ModeloCarro 4","CodigoCarro 4",190000,700,40,"02/09/2018",2000);
        

        JOIA = new Joia("PedraJoia 1",4,"CodigoJoia 1",300000,200,50,"01/04/2018",0.05);
        JOIA1 = new Joia("PedraJoia 2",5,"CodigoJoia 2",290000,175,50,"01/05/2018",0.07);
        JOIA2 = new Joia("PedraJoia 3",9,"CodigoJoia 3",295000,150,50,"01/10/2018",0.08);
        JOIA3 = new Joia("PedraJoia 4",7,"CodigoJoia 4",297500,125,50,"01/11/2018",0.09);
        

        QUADRO = new Quadro(1,45,"AutorQuadro 1",2,"CodigoQuadro 1",270000,100,60,"01/08/2018",10);
        QUADRO1 = new Quadro(1,45,"AutorQuadro 2",3,"CodigoQuadro 2",260000,75,60,"02/08/2018",7);
        QUADRO2 = new Quadro(1,45,"AutorQuadro 3",8,"CodigoQuadro 3",255000,50,60,"02/10/2018",8);
        QUADRO3 = new Quadro(1,45,"AutorQuadro 4",6,"CodigoQuadro 4",240000,30,60,"01/12/2018",9);
        
        estoque.adicionarItem(BARCO);
        estoque.adicionarItem(BARCO1);
        
        estoque.adicionarItem(MOTO);
        estoque.adicionarItem(MOTO1);
        
        estoque.adicionarItem(CARRO);
        estoque.adicionarItem(CARRO1);
        estoque.adicionarItem(CARRO2);
        estoque.adicionarItem(CARRO3);
        
        estoque.adicionarItem(QUADRO);
        estoque.adicionarItem(QUADRO1);
        estoque.adicionarItem(QUADRO2);
        estoque.adicionarItem(QUADRO3);
        
        estoque.adicionarItem(JOIA);
        estoque.adicionarItem(JOIA1);
        estoque.adicionarItem(JOIA2);
        estoque.adicionarItem(JOIA3);
    }
    /**
     * Teste unitário que avalia a adição dos itens do invetário
     */
    @Test
    public void testInsert(){
        assertFalse(estoque.adicionarItem(new Object()));
        
        assertEquals(BARCO,estoque.itensEstoque().get(0));
        assertEquals(BARCO1,estoque.itensEstoque().get(1));
        
        assertEquals(MOTO,estoque.itensEstoque().get(2));
        assertEquals(MOTO1,estoque.itensEstoque().get(3));
        
        assertEquals(CARRO,estoque.itensEstoque().get(4));
        assertEquals(CARRO1,estoque.itensEstoque().get(5));
        assertEquals(CARRO2,estoque.itensEstoque().get(6));
        assertEquals(CARRO3,estoque.itensEstoque().get(7));
        
        assertEquals(QUADRO,estoque.itensEstoque().get(8));
        assertEquals(QUADRO1,estoque.itensEstoque().get(9));
        assertEquals(QUADRO2,estoque.itensEstoque().get(10));
        assertEquals(QUADRO3,estoque.itensEstoque().get(11));
        
        assertEquals(JOIA,estoque.itensEstoque().get(12));
        assertEquals(JOIA1,estoque.itensEstoque().get(13));
        assertEquals(JOIA2,estoque.itensEstoque().get(14));
        assertEquals(JOIA3,estoque.itensEstoque().get(15));
        
    }
    /**
     * Teste unitário que avalia a ordenação por data feita nos itens do estoque
     */
    @Test
    public void testItensDeposito(){
     
        assertEquals(BARCO,estoque.inventarioDeposito().get(0));
        assertEquals(BARCO1,estoque.inventarioDeposito().get(1));
        
        assertEquals(CARRO,estoque.inventarioDeposito().get(2));
        assertEquals(MOTO,estoque.inventarioDeposito().get(3));
        
        assertEquals(JOIA,estoque.inventarioDeposito().get(4));
        assertEquals(JOIA1,estoque.inventarioDeposito().get(5));
        assertEquals(CARRO1,estoque.inventarioDeposito().get(6));
        assertEquals(MOTO1,estoque.inventarioDeposito().get(7));
        
        assertEquals(QUADRO,estoque.inventarioDeposito().get(8));
        assertEquals(QUADRO1,estoque.inventarioDeposito().get(9));
        assertEquals(CARRO2,estoque.inventarioDeposito().get(10));
        assertEquals(CARRO3,estoque.inventarioDeposito().get(11));
        
        assertEquals(JOIA2,estoque.inventarioDeposito().get(12));
        assertEquals(QUADRO2,estoque.inventarioDeposito().get(13));
        assertEquals(JOIA3,estoque.inventarioDeposito().get(14));
        assertEquals(QUADRO3,estoque.inventarioDeposito().get(15));
    }
    /**
     * Teste unitário que avalia a ordenação por valor do imposto feita nos itens do estoque
     */
    @Test
    public void testeItensTributacao(){   
        assertEquals(BARCO,estoque.relatorioTributacao().get(0));
        assertEquals(BARCO1,estoque.relatorioTributacao().get(1));
        
        assertEquals(CARRO1,estoque.relatorioTributacao().get(2));
        assertEquals(CARRO,estoque.relatorioTributacao().get(3));
        
        assertEquals(CARRO2,estoque.relatorioTributacao().get(4));
        assertEquals(CARRO3,estoque.relatorioTributacao().get(5));
        assertEquals(MOTO,estoque.relatorioTributacao().get(6));
        assertEquals(MOTO1,estoque.relatorioTributacao().get(7));
        
        assertEquals(JOIA,estoque.relatorioTributacao().get(8));
        assertEquals(JOIA1,estoque.relatorioTributacao().get(9));
        assertEquals(JOIA2,estoque.relatorioTributacao().get(10));
        assertEquals(JOIA3,estoque.relatorioTributacao().get(11));
        
        assertEquals(QUADRO,estoque.relatorioTributacao().get(12));
        assertEquals(QUADRO1,estoque.relatorioTributacao().get(13));
        assertEquals(QUADRO2,estoque.relatorioTributacao().get(14));
        assertEquals(QUADRO3,estoque.relatorioTributacao().get(15));
    }
}
