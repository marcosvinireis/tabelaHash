package tabelaHash;

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

    public TabelaHash(int tamanho){

        this.tabela = new ListaEncadeada[tamanho];
        this.tamanho = tamanho;
        for (int i = 0; i < tamanho; i++) tabela[i]  = null;
    }

    private int funcaoHash(T chave){
        return  chave.hashCode() % this.tamanho;
    }

    public void inserir(T item){
        int pos = funcaoHash(item);

        if (this.tabela[pos] == null){
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


}
