package br.uefs.ecomp.organizer.util;

import Excecoes.NenhumElementoEncontradoException;
import Sistema.Musica;
import java.util.Comparator;

/**
 * @author Daniel Cavalcante Dourado
 */
public class Tree {

    public class Node {

        private Node esquerda;
        private Node direita;
        private Node pai;
        private Musica musica;
        private int balanceamento;

        public Node(Musica k) {
            setEsquerda(setDireita(setPai(null)));
            setBalanceamento(0);
            setMusica(k);
        }

        /**
         * Retorna a Música do no
         *
         * @return Música do no
         */
        public Musica getMusica() {
            return musica;
        }

        /**
         * Altera a musica de um no
         *
         * @param musica Nova musica do no
         */
        public void setMusica(Musica musica) {
            this.musica = musica;
        }

        /**
         * Retorna o fator de balanceamento de um No
         *
         * @return Fator de balanceamento
         */
        public int getBalanceamento() {
            return balanceamento;
        }

        /**
         * Altera o fator de balanceamento de um Nó
         *
         * @param balanceamento
         */
        public void setBalanceamento(int balanceamento) {
            this.balanceamento = balanceamento;
        }

        /**
         * Retorn o "pai" de um no
         *
         * @return "Pai" do no
         */
        public Node getPai() {
            return pai;
        }

        /**
         * Altera o "Pai" de um no
         *
         * @param pai Novo "Pai"
         * @return Novo "Pai"
         */
        public Node setPai(Node pai) {
            this.pai = pai;
            return pai;
        }

        /**
         * Retorna o no à direita
         *
         * @return No à direita
         */
        public Node getDireita() {
            return direita;
        }

        /**
         * Altera o no à direita
         *
         * @param direita Novo à direita
         * @return Novo à direita
         */
        public Node setDireita(Node direita) {
            this.direita = direita;
            return direita;
        }

        /**
         * Retorna o no à esquerda
         *
         * @return Nó à esquerda
         */
        public Node getEsquerda() {
            return esquerda;
        }

        /**
         * Altera o no à esquerda
         *
         * @param esquerda Novo nó à esquerda
         */
        public void setEsquerda(Node esquerda) {
            this.esquerda = esquerda;
        }
    }
    private Node raiz;

    public Tree() {
        raiz = null;
    }

    /**
     * Retorna a raiz da Árvore
     *
     * @return Raiz da Árvore
     */
    public Node getRaiz() {
        return raiz;
    }

    /**
     * Instancia um nó passando como parametro no construtor uma Musica a ser
     * inserida
     *
     * @param k Musica a ser inserida
     */
    public void inserir(Musica k) {
        Node n = new Node(k);
        inserirAVL(this.raiz, n);
    }

    /**
     * Insere Objetos na Àrvore, seguindo como padrão para inserção a ordem
     * alfabética entre eles
     *
     * @param aComparar Raiz da Árvore
     * @param aInserir Objeto que será inserido
     */
    public void inserirAVL(Node aComparar, Node aInserir) {
        if (aComparar == null) {
            this.raiz = aInserir;
        } else {
            if ((aInserir.getMusica()).comparaMusicas(aComparar.getMusica()) < 0) {
                if (aComparar.getEsquerda() == null) {
                    aComparar.setEsquerda(aInserir);
                    aInserir.setPai(aComparar);
                    verificarBalanceamento(aComparar);
                } else {
                    inserirAVL(aComparar.getEsquerda(), aInserir);
                }

            } else if (aInserir.getMusica().comparaMusicas(aComparar.getMusica()) > 0) {
                if (aComparar.getDireita() == null) {
                    aComparar.setDireita(aInserir);
                    aInserir.setPai(aComparar);
                } else {
                    inserirAVL(aComparar.getDireita(), aInserir);
                }
            } else {
                // O nó já existe
            }
        }
    }

    /**
     * Chega o fator de balanceamento de um No e verifica se é necessário
     * balancear a árvore
     *
     * @param atual No a ser avaliado
     */
    public void verificarBalanceamento(Node atual) {
        setBalanceamento(atual);
        int balanceamento = atual.getBalanceamento();

        if (balanceamento == -2) {
            if (altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita())) {
                atual = rotacaoDireita(atual);
            } else {
                atual = duplaRotacaoEsquerdaDireita(atual);
            }
        } else if (balanceamento == 2) {
            if (altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda())) {
                atual = rotacaoEsquerda(atual);
            } else {
                atual = duplaRotacaoDireitaEsquerda(atual);
            }
        }

        if (atual.getPai() != null) {
            verificarBalanceamento(atual.getPai());
        } else {
            this.raiz = atual;
        }
    }

    /**
     * Aplica uma rotação simples à esquerda em um No
     *
     * @param inicial No a ser rotacionado
     * @return No balanceado
     */
    public Node rotacaoEsquerda(Node inicial) {
        Node direita = inicial.getDireita();
        direita.setPai(inicial.getPai());

        inicial.setDireita(direita.getEsquerda());

        if (inicial.getDireita() != null) {
            inicial.getDireita().setPai(inicial);
        }
        direita.setEsquerda(inicial);

        inicial.setPai(direita);

        if (direita.getPai() != null) {
            if (direita.getPai().getDireita() == inicial) {
                direita.getPai().setDireita(direita);
            } else if (direita.getPai().getEsquerda() == inicial) {
                direita.getPai().setEsquerda(direita);
            }
        }
        setBalanceamento(inicial);
        setBalanceamento(direita);

        return direita;
    }

    /**
     * Aplica uma rotação simples à direita em um No
     *
     * @param inicial No a ser rotacionado
     * @return No balanceado
     */
    public Node rotacaoDireita(Node inicial) {

        Node esquerda = inicial.getEsquerda();
        esquerda.setPai(inicial.getPai());

        inicial.setEsquerda(esquerda.getDireita());

        if (inicial.getEsquerda() != null) {
            inicial.getEsquerda().setPai(inicial);
        }

        esquerda.setDireita(inicial);
        inicial.setPai(esquerda);

        if (esquerda.getPai() != null) {

            if (esquerda.getPai().getDireita() == inicial) {
                esquerda.getPai().setDireita(esquerda);

            } else if (esquerda.getPai().getEsquerda() == inicial) {
                esquerda.getPai().setEsquerda(esquerda);
            }
        }
        setBalanceamento(inicial);
        setBalanceamento(esquerda);

        return esquerda;
    }

    /**
     * Aplica uma rotação simples à esquerda em uma subÁrvore e em seguida uma
     * simpes à direita na Árvore maior
     *
     * @param inicial
     * @return
     */
    public Node duplaRotacaoEsquerdaDireita(Node inicial) {
        inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
        return rotacaoDireita(inicial);
    }

    /**
     * Aplica uma rotação simples à direita em uma subÁrvore e em seguida uma
     * simpes à esquerda na Árvore maior
     *
     * @param inicial No que sera balanceado
     * @return No balanceado
     */
    public Node duplaRotacaoDireitaEsquerda(Node inicial) {
        inicial.setDireita(rotacaoDireita(inicial.getDireita()));
        return rotacaoEsquerda(inicial);
    }

    /**
     * Calcula a altura de um No da árvore
     *
     * @param atual No que terá sua altura calculada
     * @return Altura do no
     */
    public int altura(Node atual) {
        if (atual == null) {
            return -1;
        }
        if (atual.getEsquerda() == null && atual.getDireita() == null) {
            return 0;

        } else if (atual.getEsquerda() == null) {
            return 1 + altura(atual.getDireita());

        } else if (atual.getDireita() == null) {
            return 1 + altura(atual.getEsquerda());

        } else {
            return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
        }
    }

    /**
     * Altera o fato de balancemento de um No
     *
     * @param no No que terá seu balanceamento alterado
     */
    private void setBalanceamento(Node no) {
        no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
    }

    public Musica find(String busca) throws NenhumElementoEncontradoException {
        Node pesquisa = raiz;
        Comparator comparatorString = new ComparatorString();
        while (!(pesquisa.musica.getNomeMusica().startsWith(busca))) {
            if (comparatorString.compare(pesquisa.musica.getNomeMusica(), busca) > 0) {
                pesquisa = pesquisa.esquerda;
            } else {
                pesquisa = pesquisa.direita;
            }
            if (pesquisa == null)//Chegou ao final da arvore e nao encontrou a musica desejada
            {
                throw new NenhumElementoEncontradoException();
            }
        }
        return pesquisa.getMusica();
    }
}
