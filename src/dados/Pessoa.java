package dados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Pessoa {
    private String id;  // regra de formação: "[A-Z]{3}[0-9]{3}[A-Z]{1}[0-9]{1}"
    private String nome;

    public Pessoa(String id, String nome){
        //assumiremos por enquanto que todos os ids serão válidos
        this.id = id;
        this.nome = nome;
    }
    public Pessoa(){
        this.nome = null;
        this.id = null;
    }

    public Pessoa[] lerDeArquivo(String nomeArquivo) {
        Pessoa[] dados = new Pessoa[0]; //usar lista ao ivés de array
        try {
            BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            int qtLinhas = 0; //quantidade de linhas
            while ((linha = br.readLine()) != null) {
                qtLinhas++;
            }
            dados = new Pessoa[qtLinhas];
            int i = 0; //contador para o vetor de dados
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(" ");
                if (partes.length == 2) {
                    Pessoa pessoa = new Pessoa(partes[0], partes[1]);
                    dados[i] = pessoa;
                    i++;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        long somaHash = 0;
        for (int i = 0; i < this.id.length(); i++) {
            char caractere = this.id.charAt(i);
            int valorAscii = (int) caractere;
            somaHash += valorAscii*Math.pow(3, this.id.length()-i);
        }
        return (int) somaHash;
    }
}
