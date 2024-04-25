package tabelaHash;

import dados.Pessoa;
import listaEncadeada.ListaEncadeada;

/*
* inserir de arquivo
* inserir
* remover
* buscar
* imprimir
* */

public class TabelaHash<T> {

    private ListaEncadeada<T>[] tabela;
    private int tamanho;

    private final String ELEMENTO_NAO_EXISTE = "Esse elemento não existe";

    public TabelaHash(int tamanho){

        this.tabela = new ListaEncadeada[tamanho];
        this.tamanho = tamanho;
        for (int i = 0; i < tamanho; i++) tabela[i]  = null;
    }

    private int funcaoHash(T chave){
        return  chave.hashCode() % this.tamanho;
    }
    private boolean posicaoVazia(int pos){return this.tabela[pos] == null;}

    public void inserir(T item){
        int pos = funcaoHash(item);

        if (posicaoVazia(pos)){
            ListaEncadeada<T> bucket = new ListaEncadeada<>();
            bucket.adicionar(item);
            this.tabela[pos] = bucket;
        } else {
            if (this.tabela[pos].contains(item)){
                System.out.println("Item já cadastrado");
                return;
            }
            this.tabela[pos].adicionar(item);
        }
    }

    public void apagar(T item){
        int pos = this.funcaoHash(item);

        if (posicaoVazia(pos)) {
            System.out.println(ELEMENTO_NAO_EXISTE);
            return;
        }else {
            if (this.tabela[pos].contains(item)){
                int posLista = this.tabela[pos].buscaPorElemento(item);
                this.tabela[pos].remover(posLista);
            }else System.out.println(ELEMENTO_NAO_EXISTE);
        }
    }


}
