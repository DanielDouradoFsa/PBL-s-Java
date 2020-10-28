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
public class Conta{
    private String numero;
    private  int saldo;
    private  final int x=0;
    public Conta(String numero){
        this.numero = numero;
        saldo=x;
        //x=x+1;
    }
   public String getNumero(){
        return numero;
    }
    public int getSaldo(){
        return saldo;
    }
   public final void depositar(int valor)throws SaldoInsuficiente{
        if(valor<0 && valor>saldo){
            SaldoInsuficiente se= new SaldoInsuficiente();
            throw se;
        }
        else   
            saldo = getSaldo() + valor;
    }
}
