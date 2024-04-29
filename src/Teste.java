import dados.Pessoa;
import tabelaHash.TabelaHash;
import java.lang.String;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Teste {
    public static void main(String[] args) {
        Path caminho = Paths.get("src/dados/entradaDados.txt");

        TabelaHash<String, Pessoa> tabela = new TabelaHash<>(100);
        Pessoa p = new Pessoa("ABC123Z1", "Marcos");
        tabela.inserir(p.getId(), p);
        tabela.remover(p.getId());

    }
}
