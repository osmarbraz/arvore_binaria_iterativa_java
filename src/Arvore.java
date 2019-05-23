
/**
 * Implementação de Árvore Binária Encadeada.
 *
 */
public class Arvore {

    /**
     * Nó de início da árvore.
     */
    private No raiz;

    /**
     * Construtor sem parâmetro.
     *
     */
    public Arvore() {
        this.raiz = null; //Inicializa a raiz da árvore com null
    }

    /**
     * Recuperador de início.
     *
     * @return O nó do início da árvore.
     */
    public No getRaiz() {
        return raiz;
    }

    /**
     * Modificador de início.
     *
     * @param raiz Um nó a ser atribuído ao início da árvore.
     */
    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    /**
     * Retorna o valor em String da árvore.
     *
     * @return Uma string com o valor do nós da árvore.
     */
    public String paraString() {
        return "OID: " + this + " / início: " + getRaiz();
    }

    /**
     * Insere um nó na árvore de forma ordenada.
     *
     * @param dado Um novo valor de um nó a ser inserido na árvore.
     * @return Verdadeiro se conseguiu incluir o nó na árvore.
     */
    public boolean inserir(int dado) {
        //Declara e instância um novo nó
        No novo = new No();
        novo.setEsquerda(null);
        //Seta o dado
        novo.setDado(dado);
        novo.setDireita(null);

        //Se _raiz está vazia
        if (getRaiz() == null) {
            //Insere no início
            setRaiz(novo);
        } else {
            No atual = getRaiz();
            No anterior = null;
            //Procura a posição
            while (atual != null) {
                //Guarda o nó anterior antes de avançar
                anterior = atual;
                //Verifica se é para ir para esquerda ou direita
                if (dado < atual.getDado()) {
                    //Percorre a subárvore da esquerda de atual
                    atual = atual.getEsquerda();
                } else {
                    //Percorre a subárvore da direta de atual
                    atual = atual.getDireita();
                }
            }
            //Verifica se é um nó da esquerda ou direita
            if (dado < anterior.getDado()) {
                anterior.setEsquerda(novo);
            } else {
                if (dado > anterior.getDado()) {
                    anterior.setDireita(novo);
                } else {
                    System.out.println("Valor já existe na arvore");
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Retorna o sucessor modificado de um nó de uma árvore binária.
     *
     * Falta converter para iterativo
     *
     * @param raiz Raiz da árvore.
     * @param sucessor Sucessor modificado.
     * @return A árvore com o novo sucessor.
     */
    private void sucessor(No raiz, No sucessor) {
        No anterior = raiz;
        //Verifica se a subárvore da esquerda é diferente de nula
        while (sucessor.getEsquerda() != null) {
            anterior = sucessor;
            //Continua a busca do sucessor
            sucessor = sucessor.getEsquerda();
        }
        //Encontrou o elemento altera do dado da subárvore com o balor do sucessor.
        raiz.setDado(sucessor.getDado());
        //Verifica de onde veio o sucessor
        if (anterior.getEsquerda() == sucessor) {
            //Puxa a subárvore da esquerda para assumir o lugar.
            anterior.setEsquerda(sucessor.getEsquerda());
        } else {
            //Puxa a subárvore da direita para assumir o lugar.
            anterior.setDireita(sucessor.getEsquerda());
        }
    }

    /**
     * Remove um nó de uma árvore binária.
     *
     * Falta converter para iterativo
     *
     * @param dado Valor a ser encontrado e excluído da árvore.
     * @return Retorna Verdadeiro se conseguir realizar a exclusão.
     */
    public boolean remover(int dado) {
        No atual = getRaiz();
        No anterior = null;
        //Percorre a árvore até o fim ou encontrar o valor
        while ((atual != null) && (atual.getDado() != dado)) {
            //Guarda o nó anterior
            anterior = atual;
            //Verifica se o valor é menor ou maior que o dado de atual
            if (dado < atual.getDado()) {
                //Percorre a subárvore da esquerda de atual
                atual = atual.getEsquerda();
            } else {
                //Percorre a subárvore da direta de atual
                atual = atual.getDireita();
            }
        }
        //Encontrou o nó a ser excluído
        if (atual != null) {
            No sucessor = null;
            //Se tem zero ou um filho
            if ((atual.getEsquerda() == null) || (atual.getDireita() == null)) {
                //Verifica se subárvore da esquerda é nula
                if (atual.getEsquerda() == null) {
                    //O sucessor está na subárvore da direita
                    sucessor = atual.getDireita();
                } else {
                    //Verifica se subárvore da direita é nula
                    if (atual.getDireita() == null) {
                        //O sucessor está na subárvore da esquerda
                        sucessor = atual.getEsquerda();
                    }
                }
                //Verifica onde deve ser inserido o sucessor na raiz, direita ou esquerda do anterior
                //Se anterior é nulo o elemento a ser excluído é a raiz
                if (anterior == null) {
                    //Define a raiz com o sucessor
                    setRaiz(sucessor);
                } else {
                    //Se o dado a ser excluído é menor que o anterior
                    if (dado < anterior.getDado()) {
                        //O sucessor dever ser colocado na esquerda
                        anterior.setEsquerda(sucessor);
                    } else {
                        //Caso contrário o sucessor dever ser colocado na direita
                        anterior.setDireita(sucessor);
                    }
                }
            } else { //Se o nó têm dois filhos
                //Busca o sucessor de atual apartir da subárvore da direita.
                sucessor(atual, atual.getDireita());
            }
        } else {
            System.out.println("Valor não existe na arvore");
            return false;
        }
        return true;
    }

    /**
     * Executa o caminhar pré ordem em árvore binária.
     *
     * Método recursivo que executa o caminhar pré ordem em árvore binária.
     * Utiliza o dado e depois visita a subárvore da esquerda e depois a
     * subárvore da direita.
     *
     */
    public void caminharPre() {
        //Declara e uma instância uma pilha
        Pilha pilha = new Pilha();
        No atual = getRaiz();
        pilha.empilhar(atual);
        while (pilha.eVazia() == false) {
            atual = pilha.acessarTopo();
            pilha.desempilhar();
            if (atual != null) {
                System.out.println("Dado=" + atual.getDado());
                pilha.empilhar(atual.getDireita());//Invertido com relacao ao recursivo
                pilha.empilhar(atual.getEsquerda());//Esquerdo será visitado primeiro na pilha				
            }
        }
    }

    /**
     * Retorna uma String com o caminhar pré ordem em árvore binária.
     *
     * Método recursivo que executa o caminhar pré ordem em árvore binária.
     * Utiliza o dado e depois visita a subárvore da esquerda e depois a
     * subárvore da direita.
     *
     * @return Uma String com os valores do caminho na árvore.
     */
    private String caminharPreString() {
        String str = "";
        //Declara e uma instância uma pilha
        Pilha pilha = new Pilha();
        No atual = getRaiz();
        pilha.empilhar(atual);
        while (pilha.eVazia() == false) {
            atual = pilha.acessarTopo();
            pilha.desempilhar();
            if (atual != null) {
                str = str + " " + atual.getDado() + " - ";
                pilha.empilhar(atual.getDireita());//Invertido com relacao ao recursivo
                pilha.empilhar(atual.getEsquerda());//Esquerdo será visitado primeiro na pilha				
            }
        }
        return str;
    }

    /**
     * Executa o caminhar central em árvore binária.
     *
     * Método recursivo que executa o caminhar central em árvore binária. Visita
     * a subárvore da esquerda, utiliza o dado e depois visita a subárvore da
     * direita.
     *
     */
    public void caminharCentral() {
        boolean fim = false;
        //Declara e uma instância uma pilha
        Pilha pilha = new Pilha();
        No atual = getRaiz();
        while (fim == false) {
            while (atual != null) {
                pilha.empilhar(atual);
                atual = atual.getEsquerda();
            }
            atual = pilha.acessarTopo();
            pilha.desempilhar();
            if (atual == null) {
                fim = true;
            } else {
                System.out.println("Dado=" + atual.getDado());
                atual = atual.getDireita();
            }
        }
    }

    /**
     * Retorna uma String com o caminhar central em árvore binária.
     *
     * Método recursivo que executa o caminhar central em árvore binária. Visita
     * a subárvore da esquerda, utiliza o dado e depois visita a subárvore da
     * direita.
     *
     * @param _raiz Raiz da subárvore.
     * @return Uma String com os valores do caminho na árvore.
     */
    private String caminharCentralString(No _raiz) {
        String str = "";
        boolean fim = false;
        //Declara e uma instância uma pilha
        Pilha pilha = new Pilha();
        No atual = getRaiz();
        while (fim == false) {
            while (atual != null) {
                pilha.empilhar(atual);
                atual = atual.getEsquerda();
            }
            atual = pilha.acessarTopo();
            pilha.desempilhar();
            if (atual == null) {
                fim = true;
            } else {
                str = str + " " + _raiz.getDado() + " - ";
                atual = atual.getDireita();
            }
        }
        return str;
    }

    /**
     * Executa o caminhar pós ordem em árvore binária.
     *
     * Método recursivo que executa o caminhar pós ordem em árvore binária.
     * Visita a subárvore da esquerda, visita a subárvore da direita e depois
     * utiliza o dado.
     *
     */
    public void caminharPos() {
        boolean fim = false;
        int vez = 0;
        //Declara e uma instância uma pilha
        Pilha pilha = new Pilha();
        No atual = getRaiz();
        while (fim == false) {
            while (atual != null) {
                pilha.empilhar(atual, 1);
                atual = atual.getEsquerda();
            }
            atual = pilha.acessarTopo();
            vez = pilha.acessarVezTopo();
            pilha.desempilhar();
            if (atual == null) {
                fim = true;
            } else {
                if (vez == 1) {
                    pilha.empilhar(atual, 2);
                    atual = atual.getDireita();
                } else {
                    System.out.println("Dado=" + atual.getDado());
                    atual = null;
                }
            }
        }
    }

    /**
     * Retorna uma String com o caminhar pós ordem em árvore binária.
     *
     * Método recursivo que executa o caminhar pós ordem em árvore binária.
     * Visita a subárvore da esquerda, visita a subárvore da direita e depois
     * utiliza o dado.
     *
     * @return Uma String com os valores do caminho na árvore.
     */
    private String caminharPosString() {
        String str = "";
        boolean fim = false;
        int vez = 0;
        //Declara e uma instância uma pilha
        Pilha pilha = new Pilha();
        No atual = getRaiz();
        while (fim == false) {
            while (atual != null) {
                pilha.empilhar(atual, 1);
                atual = atual.getEsquerda();
            }
            atual = pilha.acessarTopo();
            vez = pilha.acessarVezTopo();
            pilha.desempilhar();
            if (atual == null) {
                fim = true;
            } else {
                if (vez == 1) {
                    pilha.empilhar(atual, 2);
                    atual = atual.getDireita();
                } else {
                    str = str + " " + atual.getDado() + " - ";
                    atual = null;
                }
            }
        }
        return str;
    }

    /**
     * Executa o caminhar pré ordem invertido em árvore binária.
     *
     * Método recursivo que executa o caminhar pré ordem invertido em árvore
     * binária. Utiliza o dado, visita a subárvore da direta e depois a visita
     * subárvore da esquerda.
     *
     */
    public void caminharPreInvertido() {
        //Declara e uma instância uma pilha
        Pilha pilha = new Pilha();
        No atual = getRaiz();
        pilha.empilhar(atual);
        while (pilha.eVazia() == false) {
            atual = pilha.acessarTopo();
            pilha.desempilhar();
            if (atual != null) {
                System.out.println("Dado=" + atual.getDado());
                pilha.empilhar(atual.getEsquerda());//Invertido com relacao ao recursivo
                pilha.empilhar(atual.getDireita());//Esquerdo será visitado primeiro na pilha				
            }
        }
    }

    /**
     * Retorna uma String com o caminhar pré ordem invertido em árvore binária.
     *
     * Método recursivo que executa o caminhar pré ordem invertido em árvore
     * binária. Utiliza o dado, visita a subárvore da direta e depois visita a
     * subárvore da esquerda.
     *
     * @return Uma String com os valores do caminho na árvore.
     */
    private String caminharPreInvertidoString() {
        String str = "";
        //Declara e uma instância uma pilha
        Pilha pilha = new Pilha();
        No atual = getRaiz();
        pilha.empilhar(atual);
        while (pilha.eVazia() == false) {
            atual = pilha.acessarTopo();
            pilha.desempilhar();
            if (atual != null) {
                str = str + " " + atual.getDado() + " - ";
                pilha.empilhar(atual.getEsquerda());//Invertido com relacao ao recursivo
                pilha.empilhar(atual.getDireita());//Esquerdo será visitado primeiro na pilha				
            }
        }
        return str;
    }

    /**
     * Executa o caminhar central invertido em árvore binária.
     *
     * Método recursivo que executa o caminhar central invertido em árvore
     * binária. Visita a subárvore da direta, utiliza o dado e depois visita a
     * subárvore da esquerda.
     *
     */
    public void caminharCentralInvertido() {
        boolean fim = false;
        //Declara e uma instância uma pilha
        Pilha pilha = new Pilha();
        No atual = getRaiz();
        while (fim == false) {
            while (atual != null) {
                pilha.empilhar(atual);
                atual = atual.getDireita();
            }
            atual = pilha.acessarTopo();
            pilha.desempilhar();
            if (atual == null) {
                fim = true;
            } else {
                System.out.println("Dado=" + atual.getDado());
                atual = atual.getEsquerda();
            }
        }
    }

    /**
     * Retorna uma String com o caminhar central invertido em árvore binária.
     *
     * Método recursivo que executa o caminhar central invertido em árvore
     * binária. Visita a subárvore da direta, utiliza o dado e depois visita a
     * subárvore da esquerda.
     *
     * @return Uma String com os valores do caminho na árvore.
     */
    private String caminharCentralInvertidoString() {
        String str = "";
        boolean fim = false;
        //Declara e uma instância uma pilha
        Pilha pilha = new Pilha();
        No atual = getRaiz();
        while (fim == false) {
            while (atual != null) {
                pilha.empilhar(atual);
                atual = atual.getDireita();
            }
            atual = pilha.acessarTopo();
            pilha.desempilhar();
            if (atual == null) {
                fim = true;
            } else {
                str = str + " " + atual.getDado() + " - ";
                atual = atual.getEsquerda();
            }
        }
        return str;
    }

    /**
     * Executa o caminhar pós ordem invertido em árvore binária.
     *
     * Método recursivo que executa o caminhar pós invertido em árvore binária.
     * Visita a subárvore da direta, visita a subárvore da esquerda e depois
     * utiliza o dado.
     *
     */
    public void caminharPosInvertido() {
        boolean fim = false;
        int vez = 0;
        //Declara e uma instância uma pilha
        Pilha pilha = new Pilha();
        No atual = getRaiz();
        while (fim == false) {
            while (atual != null) {
                pilha.empilhar(atual, 1);
                atual = atual.getDireita();
            }
            atual = pilha.acessarTopo();
            vez = pilha.acessarVezTopo();
            pilha.desempilhar();
            if (atual == null) {
                fim = true;
            } else {
                if (vez == 1) {
                    pilha.empilhar(atual, 2);
                    atual = atual.getEsquerda();
                } else {
                    System.out.println("Dado=" + atual.getDado());
                    atual = null;
                }
            }
        }
    }

    /**
     * Retorna uma String com o caminhar pós ordem invertido em árvore binária.
     *
     * Método recursivo que executa o caminhar pós invertido em árvore binária.
     * Visita a subárvore da direta, visita a subárvore da esquerda e depois
     * utiliza o dado.
     *
     * @return Uma String com os valores do caminho na árvore.
     */
    private String caminharPosInvertidoString() {
        String str = "";
        boolean fim = false;
        int vez = 0;
        //Declara e uma instância uma pilha
        Pilha pilha = new Pilha();
        No atual = getRaiz();
        while (fim == false) {
            while (atual != null) {
                pilha.empilhar(atual, 1);
                atual = atual.getDireita();
            }
            atual = pilha.acessarTopo();
            vez = pilha.acessarVezTopo();
            pilha.desempilhar();
            if (atual == null) {
                fim = true;
            } else {
                if (vez == 1) {
                    pilha.empilhar(atual, 2);
                    atual = atual.getEsquerda();
                } else {
                    str = str + " " + atual.getDado() + " - ";
                    atual = null;
                }
            }
        }
        return str;
    }

    /**
     * Conta os nós de uma árvore binária.
     *
     * Utiliza o caminhar pré para contar os nós.
     *
     * @param _raiz
     * @return A quantidade de nós da árvore.
     */
    public int contarNo(No _raiz) {
        int cont = 0;
        //Declara e uma instância uma pilha
        Pilha pilha = new Pilha();
        No atual = getRaiz();
        pilha.empilhar(atual);
        while (pilha.eVazia() == false) {
            atual = pilha.acessarTopo();
            pilha.desempilhar();
            if (atual != null) {
                cont = cont + 1;
                pilha.empilhar(atual.getDireita());
                pilha.empilhar(atual.getEsquerda());
            }
        }
        return cont;
    }

    /**
     * Procura um dado na árvore binária.
     *
     * @param dado O valor de um nó a ser procurado na lista.
     *
     * @return Verdadeiro se encontrou o dado na árvore binária.
     */
    public boolean procurarValor(int dado) {
        //Considera a raiz como atual
        No atual = getRaiz();
        //Enquanto atual diferente de nulo e não encontrar o dado em um nó
        while ((atual != null) && (atual.getDado() != dado)) {
            //Se o dado é menor que o valor do nó atual
            if (dado < atual.getDado()) {
                //Procura na subárvore da esquerda
                atual = atual.getEsquerda();
            } else {
                //Caso contrário procura na subárvore da direita
                atual = atual.getDireita();
            }
        }
        if ((atual != null) && (dado == atual.getDado())) {
            return (true);
        } else {
            return false;
        }
    }

    /**
     * Retorna uma String com os valores dos nós folhas da árvore binária.
     *
     * Utiliza o caminhar pré para encontrar as folhas.
     *
     * @param _raiz Uma raiz de uma subárvore.
     *
     * @return Uma String com os valores dos nós folhas da árvore binária.
     */
    public String encontrarFolhas(No _raiz) {
        String str = "";
        //Declara e instância uma pilha        
        Pilha pilha = new Pilha();
        No atual = getRaiz();
        pilha.empilhar(atual);
        while (pilha.eVazia() == false) {
            atual = pilha.acessarTopo();
            pilha.desempilhar();
            if (atual != null) {
                if ((atual.getEsquerda() == null) && (atual.getDireita() == null)) {
                    str = str + " " + atual.getDado() + " - ";
                }
                pilha.empilhar(atual.getDireita());
                pilha.empilhar(atual.getEsquerda());
            }
        }
        return str;
    }

    /**
     * Encontra a getAltura da árvore binária.
     *
     * @param _raiz Raiz de uma subárvore.
     * @return A getAltura da árvore binária.
     */
    public int getAltura(No _raiz) {
        if (_raiz == null) {
            return 0;
        } else {
            int esquerda = getAltura(_raiz.getEsquerda());
            int direita = getAltura(_raiz.getDireita());
            if (esquerda > direita) {
                return 1 + esquerda;
            } else {
                return 1 + direita;
            }
        }
    }
}//Fim Arvore
