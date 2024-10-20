
/**
 *
 * Nó a ser armazenado na árvore.
 *
 */
public class No {

    /**
     * Aponta para a subárvore da esquerda.
     */
    private No esquerda;
    /**
     * Dado a ser armazenado no nó.
     */
    private int dado;
    /**
     * Aponta para a subárvore da direita.
     */
    private No direita;

    /**
     * Construtor sem parâmetros.
     */
    public No() {
        this(null, 0, null);
    }

    /**
     * Construtor com parâmetros.
     *
     * @param esquerda subárvore da esquerda.
     * @param dado um valor do tipo inteiro.
     * @param direita subárvore da direita.
     */
    public No(No esquerda, int dado, No direita) {
        this.esquerda = esquerda;
        this.dado = dado;
        this.direita = direita;
    }

    /**
     * Recuperador da subárovre da esquerda.
     *
     * @return O nó de início da subárvore da esquerda.
     */
    public No getEsquerda() {
        return esquerda;
    }

    /**
     * Recuperador de dado.
     *
     * @return Um inteiro com o dado do nó.
     */
    public int getDado() {
        return dado;
    }

    /**
     * Recuperador da subárovre da direita.
     *
     * @return O nó de início da subárvore da direta.
     */
    public No getDireita() {
        return direita;
    }

    /**
     * Modificador da subárvore da esquerda.
     *
     * @param esquerda Uma subárvore para a esquerda.
     */
    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    /**
     * Modificador de dado.
     *
     * @param dado Um valor inteiro a ser atribuído para o dado.
     */
    public void setDado(int dado) {
        this.dado = dado;
    }

    /**
     * Modificador da subárvore da direita.
     *
     * @param direita Uma subárvore para a direita.
     */
    public void setDireita(No direita) {
        this.direita = direita;
    }

    /**
     * Retorna o valor em String do dado.
     *
     * @return Uma string com o valor do dado do nó.
     */
    public String paraString() {
        return "OID: " + this + " / dado: " + getDado();
    }
}//Fim No