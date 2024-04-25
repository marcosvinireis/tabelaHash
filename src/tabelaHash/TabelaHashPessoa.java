package tabelaHash;

import dados.Pessoa;
import listaEncadeada.ListaEncadeada;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TabelaHashPessoa extends TabelaHash<Pessoa> {
    public TabelaHashPessoa(int tamanho) {
        super(tamanho);
    }

    public ListaEncadeada<Pessoa> lerDeArquivo(String caminho) {
        ListaEncadeada<Pessoa> dados = new ListaEncadeada<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(caminho));
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(" ");
                if (partes.length == 2) {
                    Pessoa pessoa = new Pessoa(partes[0], partes[1]);
                    dados.adicionar(pessoa);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dados;
    }

    public void inserirDeArquivo(String path){
        ListaEncadeada<Pessoa> dados = this.lerDeArquivo(path);
        for (int i = 0; i < dados.getTamanho(); i++) {
            Pessoa novoDado = dados.busca(i);
            this.inserir(novoDado);
        }
    }
}
