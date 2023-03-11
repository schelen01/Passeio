import java.io.Serializable;

/* O serializable permite que a classe possa ser salva como Objeto, e acessado em um arquivo externo */
public class Dog implements Serializable {
    private String nome;

    private String raca;
    private int idade;
    private String direcao;

    //CONSTRUTOR
    public Dog(String nome, String raca, int idade, String direcao) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.direcao = direcao;
    }

//getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

//toString

    @java.lang.Override
    public java.lang.String toString() {
        return "Dog{" +
                "nome='" + nome + '\'' +
                ", raca='" + raca + '\'' +
                ", idade=" + idade +
                ", direcao='" + direcao + '\'' +
                '}';
    }

}

/*Um passeador de cães deseja fazer o acompanhamento de sua semana de trabalho, de segunda a sexta-feira.

Cada cão tem um nome, raça, idade e endereço.

Devemos criar uma classe que registre os cinco cães que passearam em cada dia da semana e os registre
em um arquivo chamado “docs.dat”. Depois, temos que fazer com que leia os cinco dias do arquivo listando os cães.*/
