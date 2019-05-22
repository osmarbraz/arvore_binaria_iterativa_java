
/**
 * Pilha com Lista Simplesmente Encadeadada
 */
public class Pilha {

    /**
     * Início da pilha.
     */
    private NoP inicio;

    /**
     * Construtor sem parâmetros.
     */
    public Pilha() {
        this(null); //Inicializa a pilha com null
    }

    /**
     * Construtor com parâmetros.
     *
     * @param inicio Início da pilha.
     */
    public Pilha(NoP inicio) {
        this.inicio = inicio; //Inicializa a pilha com argumento
    }

    /**
     * Recuperador de início.
     *
     * @return O nó do início da lista.
     */
    public NoP getInicio() {
        return inicio;
    }

    /**
     * Modificador de início.
     *
     * @param inicio Um nó a ser atribuído ao início da lista.
     */
    public void setInicio(NoP inicio) {
        this.inicio = inicio;
    }

    /**
     * Adiciona um novo nó no topo da pilha.
     *
     * Também chamado de push.
     *
     * @param dado Um novo valor de um nó a ser inserido na pilha.
     */
    public void empilhar(No dado) {
        NoP novo = new NoP(); //Instacia um novo no
        novo.setDado(dado); // Guarda o valor
        novo.setProximo(getInicio()); // Coloca o primeiro no proximo do novo
        setInicio(novo); // Coloca o novo no inicio
    }

    /**
     * Adiciona um novo nó no topo da pilha.
     *
     * Também chamado de push.
     *
     * @param dado Um novo valor de um nó a ser inserido na pilha.
     */
    public void empilhar(No dado, int vez) {
        NoP novo = new NoP(); //Instacia um novo no		
        novo.setDado(dado); // Guarda o valor
        novo.setVez(vez);
        novo.setProximo(getInicio()); // Coloca o primeiro no proximo do novo
        setInicio(novo); // Coloca o novo no inicio
    }

    /**
     * Remove um nó do topo da pilha.
     *
     * Também chamado de Pop.
     */
    public void desempilhar() {
        if (getInicio() != null) {//Verifica se a pilha nao esta vazia
            NoP temp = getInicio(); //Guarda o elemento a ser removido
            setInicio(getInicio().getProximo()); // pula o elemento a ser removido
            temp = null;
            System.gc(); //Desaloco o elemento
        }
    }

    /**
     * Retorna se a lista está vazia.
     *
     * @return Verdadeiro se a lista está vazia.
     */
    public boolean eVazia() {
        if (getInicio() == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Acessa o topo da pilha
     *
     * @return o no do topo da pilha.
     */
    public No acessarTopo() {
        if (getInicio() != null) {
            return getInicio().getDado();
        } else {
            return null;
        }
    }

    /**
     * Retorna o a vez do topo.
     * @return Um valor inteiro se é a vez.
     */
    public int acessarVezTopo() {
        if (getInicio() != null) {
            return getInicio().getVez();
        } else {
            return 0;
        }
    }

    /**
     * Retorna o valor em String do início da pilha.
     *
     * @return Uma string com o valor do inicio da pilha.
     */
    public String paraString() {
        return getInicio() + "";
    }

}
