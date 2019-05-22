
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
        //Seta o dado
        novo.setDado(dado);

        //Se _raiz está vazia
        if (getRaiz() == null) {
            //Insere no início
            setRaiz(novo);
        } else {
            No atual = getRaiz();
            No anterior = null;
            //Procura a posição
            while (atual != null) {
                anterior = atual;
                if (dado < atual.getDado()) {
                    atual = atual.getEsquerda();
                } else {
                    atual = atual.getDireita();
                }
            }
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
     * @param _raiz Raiz da árvore.
     * @param _sucessor Sucessor modificado.
     * @return A árvore com o novo sucessor.
     */
    private No sucessor(No _raiz, No _sucessor) {
        //Verifica se a subárvore da esquerda é diferente de nula
        if (_sucessor.getEsquerda() != null) {
            //Continua a busca do sucessor
            _sucessor.setEsquerda(sucessor(_raiz, _sucessor.getEsquerda()));
        } else {
            //Encontrou o elemento altera do dado da subárvore com o balor do sucessor.
            _raiz.setDado(_sucessor.getDado());
            //Puxa a subárvore da direita para assumir o lugar.
            _sucessor = _sucessor.getDireita();
        }
        return _sucessor;
    }

    /**
     * Remove um nó de uma árvore binária.
     *
     * Falta converter para iterativo
     *
     * @param _raiz Raiz da subárvore.
     * @param dado Valor a ser encontrado e excluído da árvore.
     * @return Retorna a árvore modificada.
     */
    public No remover(No _raiz, int dado) {
        //Verifica se a _raiz não está vazia.
        if (_raiz != null) {
            //Verifica se o valor é menor que o dado da _raiz
            if (dado < _raiz.getDado()) {
                //Percorre a subárvore da esquerda de _raiz
                _raiz.setEsquerda(this.remover(_raiz.getEsquerda(), dado));

            } else {
                //Verifica se o valor é maior que o dado da raiz
                if (dado > _raiz.getDado()) {
                    //Percorre a subárvore da direita de _raiz
                    _raiz.setDireita(this.remover(_raiz.getDireita(), dado));

                } else {
                    //Verifica se  subárvore da esquerda está nula
                    if (_raiz.getEsquerda() == null) {
                        //Puxa a subárvore da direita.
                        _raiz = _raiz.getDireita();
                    } else {
                        //Verifica se  subárvore da direta está nula
                        if (_raiz.getDireita() == null) {
                            //Puxa a subárvore da esquerda.
                            _raiz = _raiz.getEsquerda();
                        } else {
                            //Busca o sucessor da _raiz apartir da subárvore da direita.
                            _raiz.setDireita(sucessor(_raiz, _raiz.getDireita()));
                        }
                    }
                }
            }
        } else {
            System.out.println("Valor não existe na arvore");
        }
        return _raiz;
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
     * @param _raiz Raiz da subárvore.
     */
    public void caminharCentralInvertido() {
        boolean fim = false;
        Pilha pilha = new Pilha();
        No atual = raiz;
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
        Pilha pilha = new Pilha();
        No atual = raiz;
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
        Pilha pilha = new Pilha();
        No atual = raiz;
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
        Pilha pilha = new Pilha();
        No atual = raiz;
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
     * @param _raiz
     * @return A quantidade de nós da árvore.
     */
    public int contarNo(No _raiz) {
        int cont = 0;

        //Utiliza o caminhar pré para contar os nós
        Pilha pilha = new Pilha();
        No atual = getRaiz();
        pilha.empilhar(atual);
        while (pilha.eVazia() == false) {
            atual = pilha.acessarTopo();
            pilha.desempilhar();
            if (atual != null) {
                cont += 1;
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
     * @return Verdadeiro se encontrou o dado na árvore binária.
     */
    public boolean procurarValor(int dado) {
        No atual = getRaiz();
        while ((atual != null) && (atual.getDado() != dado)) {
            if (dado < atual.getDado()) {
                atual = atual.getEsquerda();
            } else {
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
     * @param _raiz Uma raiz de uma subárvore.
     * @return Uma String com os valores dos nós folhas da árvore binária.
     */
    public String encontrarFolhas(No _raiz) {
        String str = "";

        //Utiliza o caminhar pré para encontrar as folhas
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
