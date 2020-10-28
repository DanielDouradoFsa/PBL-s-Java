/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedados;



/**
 *
 * @author administrador1
 */
public class Banco {
    private Conta[] contas;
     private int prox;
     public Banco(int tam){
        contas = new Conta[tam];
     }
     public void add(Conta c){
        contas[prox++]=c;
     }
     public void debitar (int valor,String nome) throws SaldoInsuficiente, PessoaNaoEncontrada{
             try {int i=procuraConta(nome); 
                   contas[i].depositar(-(valor));
             } catch (PessoaNaoEncontrada ex) {
                 System.err.println("Pessoa nao encontrada");
             }
             catch(SaldoInsuficiente ex){
                 System.err.println("Saldo insuficiente");
             }
             catch(Exception ex){
                 System.err.println("PADRAO");
             }finally{
                 System.err.println("FINALLUY");
             }   
     }
     public void printarValor(){
         for(int a=0;a<prox;a++){
             System.err.println(contas[a].getSaldo());
         }
     }
     public int procuraConta(String nome) throws PessoaNaoEncontrada{
         for(int i=0;i<prox;i++){
             if(contas[i].getNumero().equals(nome))
                 return i;
         }
         PessoaNaoEncontrada se= new PessoaNaoEncontrada(nome);
         throw se;
     }
     public void depositar(String nome, int valor) throws SaldoInsuficiente, PessoaNaoEncontrada{
            int c=procuraConta(nome);
            contas[c].depositar(contas[c].getSaldo()*valor);
     }
     public static void main(String[] args) throws SaldoInsuficiente, PessoaNaoEncontrada{
         Banco b= new Banco(5);
         Conta a=new Conta("Daniel");
         Conta c=new Conta("Cavalcante");
         Conta d=new Conta("Dourado");
         Conta e=new Conta("Sergio");
         Conta f=new Conta("Romario");
         
         b.add(c);
         b.add(a);
         b.add(d);
         b.add(e);
         b.add(f);
         
         b.printarValor();
         
         b.debitar(10,"Daniel");
         b.depositar("Daniel", 10);
         b.debitar(10,"Daniel");
         
     }
}

