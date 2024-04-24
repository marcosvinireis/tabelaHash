package dados;

import listaEncadeada.ListaEncadeada;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
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

    public static ListaEncadeada<Pessoa> lerDeArquivo(String caminho) {
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

    @Override
    public String toString() {
        return "Pessoa{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
