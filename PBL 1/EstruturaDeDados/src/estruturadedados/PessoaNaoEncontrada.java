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
class PessoaNaoEncontrada extends Exception {
    String pessoa;
    public PessoaNaoEncontrada( String pessoa){
        super("Pessoa nao encontrada");
        this.pessoa=pessoa;
    }
    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }
    
}
