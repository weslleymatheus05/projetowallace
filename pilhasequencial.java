import java.util.Scanner;

public class PilhaSequencial {

    //Instancia a classe de Utilidade
    static Util u = new Util();

    //Propriedades da Pilha
    Aluno[] alunos = new Aluno[10];
    int indiceAtual = 0; //Inicia 0

    public void Iniciar(Scanner sc){
        u.Escrever("• PILHA SEQUENCIAL até 10 Posicoes (1 a 10) •");
        
        boolean voltar = false;
        do{
            u.Escrever("\nEscolha uma função para ser executada:\n"
            +"1 - Inserir Aluno ('Nome do Aluno')\n"
            +"2 - Remover Aluno\n"
            +"3 - Exibir Alunos\n"
            +"4 - Voltar\n");
            
            String entrada;
            u.Escrever("FUNCAO:");
            entrada = sc.nextLine();

            switch(entrada){
                case "1":
                InserirElemento(sc);
                break;

                case "2":
                RemoverElemento(sc);
                break;

                case "3":
                ExibirElementos();
                break;

                case "4":
                voltar = true;
                break;
            }

            u.Esperar();

        } while (!voltar);
    }


    //Metodo de inserir elementos (PUSH)
    public void InserirElemento(Scanner sc){

        if(indiceAtual == 10){ //9 que representa a 10ª posicao
            u.Escrever("~ Esta pilha está Lotada. Remova algum(ns) para poder adicionar novamente.");
        } else {
            
            u.Escrever("NOME:");
            String nome = sc.nextLine();
            
            if(nome != ""){
                Aluno novoAluno = new Aluno(); //Cria um novo aluno
                novoAluno.setNome(nome); //Atribui novo nome para esse aluno.

                alunos[indiceAtual] = novoAluno; //Inclui o aluno no indice atual.
                u.Escrever("~ \""+ novoAluno.getNome()+"\" adicionado na posicao "+ (indiceAtual+1) +"");

                indiceAtual++; //Incrementa o Indice atual.

            } else {
                u.Escrever("~ Vazio não é valido!");
            }
        }
    }


    //Metodo de remover elementos (POP)
    public void RemoverElemento(Scanner sc){

        if(indiceAtual == 0){
            u.Escrever("~ Não temos ninguem na pilha.");
        } else {
            u.Escrever("~ Aluno \""+ alunos[indiceAtual -1].getNome() + "\" na posicao "+ indiceAtual  +" removido!");
            alunos[indiceAtual - 1] = null;
            indiceAtual--;
        }
    }

    //Metodo de exibir elementos.
    public void ExibirElementos(){
        u.Escrever("---- LISTA ----");
        //Mostrarei do maior para o menor, para ficar uma pilha graficamente kkk
        for(int i=alunos.length - 1; i>=0; i--){
            if(alunos[i] != null){
                u.Escrever("~ " + (i+1) + " - " + alunos[i].getNome());
            }
        }
        u.Escrever("---------------");
    }

}
