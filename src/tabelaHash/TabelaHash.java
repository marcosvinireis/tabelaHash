package tabelaHash;

import listaEncadeada.ListaEncadeada;

public class TabelaHash<K, V> {

    private ListaEncadeada<Entrada<K, V>> [] tabela;
    private int tamanho;
    private int capacidade;

    private final String ELEMENTO_NAO_EXISTE = "Esse elemento não existe";

    public TabelaHash(int capacidade){

        this.tabela = new ListaEncadeada[capacidade];
        this.capacidade = capacidade;
        this.tamanho = 0;
        for (int i = 0; i < capacidade; i++) tabela[i]  = null;
    }

    private int funcaoHash(K chave){
        return  chave.hashCode() % this.capacidade;
    }
    private boolean posicaoVazia(int pos){
        return this.tabela[pos] == null;
    }

    public void inserir(K chave, V valor){
        int pos = funcaoHash(chave);
        Entrada<K, V> dado = new Entrada<>(chave, valor);

        if (posicaoVazia(pos)){
            ListaEncadeada<Entrada<K, V>> bucket = new ListaEncadeada<>();
            bucket.adicionar(dado);
            this.tabela[pos] = bucket;
        } else {
            if (this.tabela[pos].contains(dado)){
                System.out.println("Item já cadastrado");
                return;
            }
            this.tabela[pos].adicionar(dado);
        }
    }

    public void remover(K chave){
        int pos = this.funcaoHash(chave);

        if (posicaoVazia(pos)) {
            System.out.println(ELEMENTO_NAO_EXISTE);
            return;
        }else {
            int x = this.tabela[pos].getTamanho(); // tamanho da lista na posição
            for (int i = 0; i < x; i++) {
                if(this.tabela[pos].busca(i).getChave() == chave){
                    this.tabela[pos].remover(i);
                    return;
                }
            }
        }
        System.out.println(ELEMENTO_NAO_EXISTE);
    }

    private Entrada<K, V> buscarElemento(K chave){
        int pos = funcaoHash(chave);
        if (posicaoVazia(pos)) {
            System.out.println(ELEMENTO_NAO_EXISTE);
            return null;
        }else {
            int x = this.tabela[pos].getTamanho(); // tamanho da lista na posição
            for (int i = 0; i < x; i++) {
                if(this.tabela[pos].busca(i).getChave() == chave){
                    return this.tabela[pos].busca(i);
                }
            }
        }
        return null;
    }
    public V buscar(K chave){
        if (buscarElemento(chave) == null) {
            System.out.println(ELEMENTO_NAO_EXISTE);
            return null;
        }else
            return buscarElemento(chave).getValor();
    }
}
