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
import br.uefs.ecomp.organizer.model.Sistema.Entrega;
import br.uefs.ecomp.organizer.model.Sistema.Estoque;
import br.uefs.ecomp.organizer.model.Sistema.OperacoesEstoque;
import br.uefs.ecomp.organizer.model.Sistema.Sistema;
import br.uefs.ecomp.organizer.util.MyLinkedList;
import java.text.ParseException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
/**
 * @author Daniel Cavalcante Dourado
 */
public class DespachoTeste {
    Estoque estoque;
    OperacoesEstoque itensEstoque;
    Entrega entrega;
    Entrega entrega1;
    Entrega entrega2;
    Entrega entrega3;
    
    Sistema sistema;
    
    MyLinkedList balsa;
    MyLinkedList caminhaoCegonha;
    MyLinkedList carroForte;
    MyLinkedList navioContainer;
    
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
        
        BARCO= new Barco("MotorBarco","10/01/2018","MarcaBarco","ModeloBarco","CodigoBarco",250000,1000,1000,"01/01/2018",4000);
        BARCO1= new Barco("MotorBarco 1","11/02/2018","MarcaBarco 1","ModeloBarco 1","CodigoBarco 1",280000,900,900,"02/02/2018",11000);
        
        MOTO = new Moto("MotorMoto","CombustivelMoto","11/03/2018","MarcaMoto","ModeloMoto","CodigoMoto",200000,650,650,"02/03/2018",100);
        MOTO1 = new Moto("MotorMoto 1","CombustivelMoto 1","12/04/2018","MarcaMoto 1","ModeloMoto 1","CodigoMoto 1",20000,600,600,"01/07/2018",75);
        
        CARRO = new Carro("CombustivelCarro","13/05/2018","MarcaCarro","ModeloCarro","CodigoCarro",230000,750,750,"01/03/2018",500);
        CARRO1 = new Carro("CombustivelCarro 1","14/05/2018","MarcaCarro 1","ModeloCarro 1","CodigoCarro 1",225000,800,800,"01/06/2018",750);
        CARRO2 = new Carro("CombustivelCarro 2","15/05/2018","MarcaCarro 2","ModeloCarro 2","CodigoCarro 2",215000,725,725,"01/09/2018",1500);
        CARRO3 = new Carro("CombustivelCarro 3","16/05/2018","MarcaCarro 3","ModeloCarro 3","CodigoCarro 3",190000,700,700,"02/09/2018",2000);
        
        JOIA = new Joia("PedraJoia",4,"CodigoJoia",300000,200,200,"01/04/2018",1);
        JOIA1 = new Joia("PedraJoia 1",5,"CodigoJoia 1",290000,175,175,"01/05/2018",2);
        JOIA2 = new Joia("PedraJoia 2",9,"CodigoJoia 2",295000,150,150,"01/10/2018",3);
        JOIA3 = new Joia("PedraJoia 3",7,"CodigoJoia 3",297500,125,125,"01/11/2018",4);
        
        QUADRO = new Quadro(1,45,"AutorQuadro",2,"CodigoQuadro",270000,100,100,"01/08/2018",10);
        QUADRO1 = new Quadro(1,45,"AutorQuadro 1",3,"CodigoQuadro 1",260000,75,75,"02/08/2018",7);
        QUADRO2 = new Quadro(1,45,"AutorQuadro 2",8,"CodigoQuadro 2",255000,50,50,"02/10/2018",8);
        QUADRO3 = new Quadro(1,45,"AutorQuadro 3",6,"CodigoQuadro 3",240000,30,30,"01/12/2018",9);
        
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
        
        balsa=itensEstoque.planoBalsa(1435);
        caminhaoCegonha=itensEstoque.planoCaminhaoCegonha(3500);
        carroForte=itensEstoque.planoCarroForte(44);
        navioContainer=itensEstoque.planoContainers(15000);        
    }
    /*
     * Testa mais algumas possibilidades nos Planos de Carga
     */
    @Test
    public void inserirPlanosDeCarga(){  
          
        assertEquals(CARRO,balsa.get(0));
        assertEquals(MOTO,balsa.get(1));
        assertEquals(CARRO1,balsa.get(2));
        assertEquals(MOTO1,balsa.get(3));

        assertEquals(CARRO3,caminhaoCegonha.get(0));
        assertEquals(CARRO2,caminhaoCegonha.get(1));
         
        assertEquals(JOIA2,carroForte.get(0));
        assertEquals(QUADRO2,carroForte.get(1));
        assertEquals(JOIA3,carroForte.get(2));
        assertEquals(QUADRO3,carroForte.get(3));
        assertEquals(JOIA1,carroForte.get(4));
        assertEquals(JOIA,carroForte.get(5));
        assertEquals(QUADRO1,carroForte.get(6));
        assertEquals(QUADRO,carroForte.get(7));
        
        assertEquals(BARCO1,navioContainer.get(0));
        assertEquals(BARCO,navioContainer.get(1));
 
    }
    /**
     * Testa a entrega de cada Plano de Carga
     */
    @Test
    public void entregaTest(){
        
        entrega= new Entrega(balsa,"Balsa");
        entrega1= new Entrega(caminhaoCegonha,"Caminhao Cegonha");
        entrega2= new Entrega(navioContainer,"Navio Container");
        entrega3= new Entrega(carroForte,"CarroForte");
        
        assertEquals(CARRO1,entrega.getList().get(0));
        assertEquals(CARRO,entrega.getList().get(1));
        assertEquals(MOTO,entrega.getList().get(2));
        assertEquals(MOTO1,entrega.getList().get(3));
        
        assertEquals(CARRO2,entrega1.getList().get(0));
        assertEquals(CARRO3,entrega1.getList().get(1));
        
        assertEquals(BARCO,entrega2.getList().get(0));
        assertEquals(BARCO1,entrega2.getList().get(1));
        
        assertEquals(JOIA,entrega3.getList().get(0));
        assertEquals(JOIA1,entrega3.getList().get(1));
        assertEquals(JOIA2,entrega3.getList().get(2));
        assertEquals(JOIA3,entrega3.getList().get(3));
        assertEquals(QUADRO,entrega3.getList().get(4));
        assertEquals(QUADRO1,entrega3.getList().get(5));
        assertEquals(QUADRO2,entrega3.getList().get(6));
        assertEquals(QUADRO3,entrega3.getList().get(7));
            
    }
    /**
     * Testa o despacho das entregas
     */
    @Test
    public void sistemaTest(){
        entrega= new Entrega(balsa,"Balsa");
        entrega1= new Entrega(caminhaoCegonha,"Caminhao Cegonha");
        entrega2= new Entrega(navioContainer,"Navio Container");
        entrega3= new Entrega(carroForte,"CarroForte");
        
        sistema= new Sistema();
        sistema.add(entrega);
        sistema.add(entrega1);
        sistema.add(entrega2);
        sistema.add(entrega3);
        sistema.ordenaDespachos();
        
        assertTrue(entrega3.getPesoMaximo()==44.0);
        assertTrue(entrega3.getValorFreteMaximo()==905.0);
        assertTrue(entrega3.getValorMaximo()==2207500);
        
        assertTrue(entrega.getPesoMaximo()==1425.0);
        assertTrue(entrega.getValorFreteMaximo()==2800.0);
        assertTrue(entrega.getValorMaximo()==675000.0);
        
        assertTrue(entrega2.getPesoMaximo()==15000.0);
        assertTrue(entrega2.getValorFreteMaximo()==1900);
        assertTrue(entrega2.getValorMaximo()==530000);
        
        assertTrue(entrega1.getPesoMaximo()==3500.0);
        assertTrue(entrega1.getValorFreteMaximo()==1425.0);
        assertTrue(entrega1.getValorMaximo()==405000.0);
        
        assertEquals(entrega3,sistema.getDespachos().get(0));
        assertEquals(entrega,sistema.getDespachos().get(1));
        assertEquals(entrega2,sistema.getDespachos().get(2));
        assertEquals(entrega1,sistema.getDespachos().get(3));
        
        //Eliminando os itens de estoque que foram despachados
        assertFalse(estoque.itensEstoque()==null);
        sistema.atualizaEstoque(estoque.itensEstoque());
        assertTrue(estoque.itensEstoque()==null);
        
  
    }  
}
