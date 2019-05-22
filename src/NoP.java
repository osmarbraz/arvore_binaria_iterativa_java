
/**
 * No para uma pilha com Lista Simplesmente Encadeadada
 */
public class NoP {

    /**
     * Dado a ser armazenado no nó.
     */
    private No dado;
    /**
     * Aponta para o próximo da lista.
     */
    private NoP proximo;
    private int vez;

    /**
     * Construtor sem parâmetros.
     */
    public NoP() {
        this(null, null, 0);
    }

    /**
     * Construtor com parámetros.
     *
     * @param dado um valor do tipo No.
     * @param proximo o próximo da no da lista.
     * @param vez
     */
    public NoP(No dado, NoP proximo, int vez) {
        setDado(dado);
        setProximo(proximo);
        setVez(0);
    }

    /**
     * Recuperador de dado.
     *
     * @return Um No com o dado do nó.
     */
    public No getDado() {
        return dado;
    }

    /**
     * Recuperador do próximo nó.
     *
     * @return O próximo no da lista.
     */
    public NoP getProximo() {
        return proximo;
    }

    public int getVez() {
        return vez;
    }

    /**
     * Modificador de dado.
     *
     * @param dado Um valor No a ser atribuído para o dado.
     */
    public void setDado(No dado) {
        this.dado = dado;
    }

    /**
     * Modificador da subárvore da direita.
     *
     * @param proximo O próximo nó da lista.
     */
    public void setProximo(NoP proximo) {
        this.proximo = proximo;
    }

    public void setVez(int _vez) {
        vez = _vez;
    }

}
