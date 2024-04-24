package dados;

import java.util.Objects;

public class Pessoa {
    private String id;  // regra de formação: "[A-Z]{3}[0-9]{3}[A-Z]{1}[0-9]{1}"
    private String nome;

    public Pessoa(String id, String nome){
        //assumiremos por enquanto que todos os ids serão válidos
        this.id = id;
        this.nome = nome;
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
        return Objects.hash(id);
    }
}
