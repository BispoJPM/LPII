import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Baralho {
    private List<Carta> maço;
    private int topo;

    public Baralho() {
        maço = new ArrayList<Carta>; // 52 cartas + 4 coringas (prof falou que era 56 no finalzin)
        String[] naipes = {"Coração", "Espada", "Ouro", "Zap"};
        String[] nomes = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Dama", "Valete", "Rei"};

        int cartinha = 0; 

        for (String naipe : naipes) { // aqui ele roda os naipe por naipe
            for (String nome : nomes) { // aqui é a mesma coisa
                maço.add(new Carta(nome, naipe)); // aqui ele pega o naipe e percorre as cartas
            }
        }
        for (int crg = 0; crg < 4; crg++) {
            maço[cartinha++] = new Carta("Coringa", "Coringa"); // nesse aqui, depois de todas as cartas com naipes, ele gera os 4 cofingas por ultimo
        }
        topo = maço.length - 1;
        embaralha(10); // Embaralha o baralho 10 vezes ou quantas eu quiser, mudando somente a constante.
    }

    // Embaralhar por quantas vezes a consoante tiver ali em cima
    private void embaralha(int total) {
        Random random = new Random();
        for (int x = 0; x < total; x++) { // x é 0, enquanto ele for menor que o total, vai rodar e acrescar +1 no X
            for (int emb = maço.size() - 1; emb > 0; emb--) { // length pega o comprimento geral do array, entao aqui é geralzao -1
                int sid = random.nextInt(emb + 1);
                Carta subs = maço.get(emb); // emb = embaralhar
                maço.set(emb, maço.get(sid)); // sid = sem ideia pra variavel
                maço.set(sid, subs);
            }
        }
    }

    // dar as cartas
    public Carta daCarta() {
        if (temCarta()) {
            return maço.remove(maço.size() - 1); // remove a carta do topo
        } else {
            return null;
        }
    }

    // Se ainda tiver carta ele mostra, se não tiver, mostra tbm
    public boolean temCarta() {
        return !maço.isEmpty(); // Verifica se a lista está vazia
    }

    // Imprimir o baralho
    public void imprimeBaralho() {
        for (Carta carta : maço) {
            System.out.println(carta);
        }
    }
}
