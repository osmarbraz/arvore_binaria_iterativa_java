
/**
 * Implementação de Árvore Binária Encadeada.
 */
import javax.swing.JOptionPane;

public class Principal {

    /**
     * Realiza a leitura dos dados dos nós.
     *
     * @return O valor lido.
     */
    public static int leitura() {
        return Integer.parseInt(JOptionPane.showInputDialog("Digite um valor:"));
    }

    /**
     * Árvore de exemplo.
     *
     * @param arvore Árvore a ser preenchida.
     */
    public static void arvoreExemplo(Arvore arvore) {
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);

        arvore.inserir(20);
        arvore.inserir(40);

        arvore.inserir(60);
        arvore.inserir(80);

        //		    50
        //          30              70
        //	20       40	60	80
    }

    /**
     * Método principal.
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Declara e instância da árvore.
         */
        Arvore ipe = new Arvore();

        // Controla o menu da lista
        int opcao = -1;

        //Laço do menu de opções
        while (opcao != 99) {
            //Monta o menu de opções
            opcao = Integer.parseInt(JOptionPane.showInputDialog("\t### Árvore Binária Iterativa ###\n"
                    + "Selecione a opção desejada:\n"
                    + " 1- Inserir \n"
                    + " 2- Excluir \n"
                    + " 3- Caminhar Pré (ED)\n"
                    + " 4- Caminhar Central (ED)\n"
                    + " 5- Caminhar Pós (ED)\n"
                    + " 6- Caminhar Pré (DE)\n"
                    + " 7- Caminhar Central (DE)\n"
                    + " 8- Caminhar Pós (DE)\n"
                    + " 9- Contar nós \n"
                    + "10- Localizar nó \n"
                    + "11- Mostrar folhas \n"
                    + "12- Altura da árvore\n"
                    + "99- Sair\n"));

            switch (opcao) {
                case 1: {
                    //Preenche o valor do dado
                    int dado = leitura();
                    //Insere o valor na árvore
                    ipe.inserir(dado);
                    break;
                }
                case 2: {
                    //Preenche o valor do dado                    
                    int valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser removido"));
                    //Remove o valor da árvore
                    ipe.setRaiz(ipe.remover(ipe.getRaiz(), valor));
                    break;
                }
                case 3: {
                    System.out.println(">> Caminhamento Pré Ordem ED");
                    ipe.caminharPre();
                    break;
                }
                case 4: {
                    System.out.println(">> Caminhamento Central ED");
                    ipe.caminharCentral();
                    break;
                }
                case 5: {
                    System.out.println(">> Caminhamento Pós Ordem ED");
                    ipe.caminharPos();
                    break;
                }
                case 6: {
                    System.out.println(">> Caminhamento Pré Ordem DE");
                    ipe.caminharPreInvertido();
                    break;
                }
                case 7: {
                    System.out.println(">> Caminhamento Central DE");
                    ipe.caminharCentralInvertido();
                    break;
                }
                case 8: {
                    System.out.println(">> Caminhamento Pós Ordem DE");
                    ipe.caminharPosInvertido();
                    break;
                }
                case 9: {
                    //Retorna a quantidade de nós
                    int qtde = ipe.contarNo(ipe.getRaiz());
                    System.out.println("Nós encontrados: " + qtde);
                    break;
                }
                case 10: {
                    //Preenche o valor do dado
                    int dado = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser procurado:"));
                    boolean encontrou = ipe.procurarValor(dado);
                    if (encontrou == true) {
                        JOptionPane.showMessageDialog(null, "O valor " + dado + " foi encontrado!");
                    } else {
                        JOptionPane.showMessageDialog(null, "O valor " + dado + " não foi encontrado!");
                    }
                    break;
                }
                case 11: {
                    System.out.println("Mostrar Folhas\n" + ipe.encontrarFolhas(ipe.getRaiz()));
                    break;
                }
                case 12: {
                    System.out.println("Altura árvore: " + ipe.getAltura(ipe.getRaiz()));
                    break;
                }
                //Preenche uma árvore com 7 nós
                case 98: {
                    arvoreExemplo(ipe);
                    break;
                }

                //Opção de saída do programa
                case 99: {
                    System.out.println("Saindo do programa!");
                    break;
                }
                //Opção inválida do menu
                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }//Fim switch   
        }//Fim while
    }//Fim main
}//Fim Principal
