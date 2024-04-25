package tabelaHash;

import dados.Pessoa;
import listaEncadeada.ListaEncadeada;

public class TabelaHashPessoa extends TabelaHash<Pessoa> {
    public TabelaHashPessoa(int tamanho) {
        super(tamanho);
    }

    public void inserirDeArquivo(String path){
        ListaEncadeada<Pessoa> dados = Pessoa.lerDeArquivo(path);
        for (int i = 0; i < dados.getTamanho(); i++) {
            Pessoa novoDado = dados.busca(i);
            this.inserir(novoDado);
        }
    }
}
