import java.util.Scanner;

public class ListaSequencial {

    //Instancia a classe de Utilidade
    static Util u = new Util();

    //Propriedades da Lista
    Aluno[] alunos = new Aluno[10];

    public void Iniciar(Scanner sc){
        u.Escrever("• LISTA SEQUENCIAL até 10 Posicoes (1 a 10) •");
        
        boolean voltar = false;
        do{
            u.Escrever("\nEscolha uma função para ser executada:\n"
            +"1 - Inserir Aluno ('Posicao' e  'Nome do Aluno')\n"
            +"2 - Remover Aluno ('Posicao') \n"
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


    //Metodo de inserir elementos.
    public void InserirElemento(Scanner sc){

        u.Escrever("POSICAO (1 a 10):");
        int posicao = Integer.parseInt(sc.nextLine());

        if(posicao > 10 || posicao < 1){
            u.Escrever("~ Só temos 10 posições. Use um valor válido de 1 a 10!");
        } else {

            u.Escrever("NOME:");
            String nome = sc.nextLine();
            
            if(nome != ""){
                
                
                Aluno novoAluno = new Aluno(); //Cria um novo aluno
                novoAluno.setNome(nome); //Atribui novo nome para esse aluno.

                //E joga esse aluno na lista sequencial (Array)
                alunos[posicao - 1] = novoAluno;

                u.Escrever("~ \""+ novoAluno.getNome()+"\" adicionado na posicao "+posicao+"");

            } else {
                u.Escrever("~ Vazio não é valido!");
            }
        }
    }

    //Metodo de remover elementos.
    public void RemoverElemento(Scanner sc){
        u.Escrever("POSICAO (1 a 10):");
        int posicao = Integer.parseInt(sc.nextLine());

        if(posicao > 10 || posicao < 1){
            u.Escrever("~ Só temos 10 posições. Use um valor válido de 1 a 10!");
        } else if(alunos[posicao - 1] == null){
            u.Escrever("~ Não tem ninguém nessa posição!");
        } else {
            u.Escrever("~ Aluno \""+ alunos[posicao-1].getNome() +"\" na posicao "+posicao+" removido!");
            alunos[posicao - 1] = null;
        }
    }

    //Metodo de exibir elementos.
    public void ExibirElementos(){
        u.Escrever("---- LISTA ----");
        for(int i=0; i<alunos.length; i++){
            if(alunos[i] != null){
                u.Escrever("~ " + (i+1) + " - " + alunos[i].getNome());
            }
        }
        u.Escrever("---------------");

    }

}
