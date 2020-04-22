import java.util.Scanner;

public class ListaEncadeada {

    // Instancia a classe de Utilidade
    static Util u = new Util();

    // Propriedades da Lista
    Aluno primeiroAluno, ultimoAluno;
    int qtdAlunos = 0; // Inicia 0

    public void Iniciar(Scanner sc) {
        u.Escrever("• LISTA ENCADEADA Pode ser infinita se tiver paciência •");

        boolean voltar = false;
        do {
            u.Escrever("\nEscolha uma função para ser executada:\n"
            + "1 - Inserir Aluno ('Nome do Aluno')\n"
            + "2 - Remover Aluno ('Posicao') \n"
            + "3 - Exibir Alunos\n"
            + "4 - Voltar\n");
            
            String entrada;
            u.Escrever("FUNCAO:");
            entrada = sc.nextLine();

            switch (entrada) {
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

        u.Escrever("NOME:");
        String nome = sc.nextLine();
        
        if(nome != ""){
            
            //Define o novo nome para esse aluno.
            Aluno novoAluno = new Aluno();
            novoAluno.setNome(nome);

            qtdAlunos++; //Incrementa a quantidade de Alunos
            
            if (primeiroAluno == null){
                //Define esse como primeiro e ultimo aluno
                //caso não exista nenhum
                primeiroAluno = novoAluno;
                ultimoAluno = novoAluno;

            } else {
                //Se já existir aluno, pega o ultimoAluno e
                //define quem será o proximo aluno em relação a ele.

                ultimoAluno.setProximo(novoAluno); //Definimos o novo 'proximo' do ultimo aluno
                novoAluno.setAnterior(ultimoAluno); //E definimos o novo 'anterior' do novo aluno
                
                ultimoAluno = novoAluno; //Finalmente atribuimos o novo aluno como ultimo
            }
            u.Escrever("~ \""+ novoAluno.getNome() + "\" adicionado na lista!");

            
        } else {
            u.Escrever("~ Vazio não é valido!");
        }
        
    }

    //Metodo de remover elementos.
    public void RemoverElemento(Scanner sc){
        u.Escrever("POSICAO:");
        int posicao = Integer.parseInt(sc.nextLine());

        if(posicao > qtdAlunos || posicao < 1){
            u.Escrever("~ Só temos "+qtdAlunos+" posições até o momento. Escolha um numero de 1 a "+qtdAlunos);
        } else {

            //Primeiro aluno como variavel auxiliar...
            Aluno aux = primeiroAluno;

            for(int i=0; i<posicao; i++){                

                if(i < posicao - 1){
                    //Vai percorrendo um por um, a partir do primeiro aluno
                    aux = aux.getProximo(); 
                
                } else if (i == posicao - 1) {
                    //Ao chegar na posicao desejada...
                    
                    if(i == 0) {
                    //Se FOR o primeiro ALUNO
                        
                        if(qtdAlunos > 1) { //Se existir MAIS de 1 aluno, faça...
                            aux.getProximo().setAnterior(null);
                            primeiroAluno = aux.getProximo();
                            //Pego o proximo aluno, e deixa o Anterior dele NULO
                        }
                        
                    } else if (i < qtdAlunos - 1){
                    //Se NÃO for o ultimo ALUNO da lista
                         
                        //Legenda para melhor entendimento desse processo:
                        //1 = Atual (aux);
                        //2 = Anterior do Atual;
                        //3 = Proximo do Atual;

                        aux.getAnterior().setProximo(aux.getProximo());
                        //Pego o anterior(2) do atual(1)
                        //e mudo o 'Proximo do anterior (2)', para ser o 'Proximo do atual'
                        
                        aux.getProximo().setAnterior(aux.getAnterior());
                        //Pego o proximo(3) do atual(1)
                        //e mudo o 'Anterior do proximo (3)', para ser o 'Anterior do atual'

                        //2 1 3
                        //• ◘ •
                        //|___| - Removemos a ligação (2 <> 1), para ser (2 <> 3)
                    
                    } else {
                    //Se for o ultimo ALUNO da lista
                    
                        ultimoAluno = aux.getAnterior();
                        //Atribui o ANTERIOR deste como ultimoAluno
                    }
                    
                    u.Escrever("~ "+(posicao)+" " + aux.getNome() + "REMOVIDO DA LISTA!");
                    aux = null; //LIMPA ESSA MEMORIA (?)
                    qtdAlunos--; //Decrementa do contador.
                }
            }

        }
    }

    //Metodo de exibir elementos.
    public void ExibirElementos(){
        u.Escrever("---- LISTA ----");
        Aluno aux = primeiroAluno;
        for(int i=0; i<qtdAlunos; i++){

            //Escreve o aluno atual
            u.Escrever("~ "+(i+1)+" " + aux.getNome());

            //Percorre pelos nós
            if(i < qtdAlunos)
                aux = aux.getProximo();
        }
        u.Escrever("---------------");

    }

}
