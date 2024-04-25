import dados.Pessoa;
import listaEncadeada.ListaEncadeada;
import tabelaHash.TabelaHash;
import tabelaHash.TabelaHashPessoa;

import java.io.File;
import java.lang.String;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Teste {
    public static void main(String[] args) {
        Path caminho = Paths.get("src/dados/entradaDados.txt");

        TabelaHashPessoa tabela = new TabelaHashPessoa(99);
        tabela.inserirDeArquivo(String.valueOf(caminho));


    }
}
