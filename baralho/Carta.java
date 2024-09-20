public class Carta {
    private String nome;
    private String naipe;

    // Não substitui o método "set", é um construtor que faz com que crie outras coisas da classe Carta (puxei no baralho)
    public Carta(String nome, String naipe) {
        this.nome = nome;
        this.naipe = naipe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNaipe() {
        return naipe;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

    @Override // (Método para printar as cartas e ver se está correto)
    public String toString() {
        return "Carta: " + nome + " | Naipe: " + naipe;
    }
}