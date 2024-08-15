import java.util.Random;

public class Baralho {
    private Carta[] maço;
    private int topo;

    public Baralho() {
        maço = new Carta[56];
        String[] naipes = {"Coração", "Espada", "Ouro", "Zap"};
        String[] nomes = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Dama", "Valete", "Rei"};

        int cartinha = 0;

        for (String naipe : naipes) {
            for (String nome : nomes) {
                maço[cartinha++] = new Carta(nome, naipe);
            }
        }
        for (int crg = 0; crg < 4; crg++) {
            maço[cartinha++] = new Carta("Coringa", "Coringa");
        }
        topo = maço.length - 1;
        embaralha(10); // Embaralha o baralho 10 vezes
    }

    // Método para embaralhar o baralho 'total' vezes
    private void embaralha(int total) {
        Random random = new Random();
        for (int x = 0; x < total; x++) {
            for (int emb = maço.length - 1; emb > 0; emb--) {
                int sid = random.nextInt(emb + 1);
                Carta subs = maço[emb];
                maço[emb] = maço[sid];
                maço[sid] = subs;
            }
        }
    }

    // Método para distribuir uma carta do topo do baralho
    public Carta daCarta() {
        if (temCarta()) {
            return maço[topo--]; // Retorna a carta do topo e decrementa o índice do topo
        } else {
            return null; // Retorna null se não houver mais cartas
        }
    }

    // Método para verificar se ainda há cartas no baralho
    public boolean temCarta() {
        return topo >= 0;
    }

    // Método para imprimir as cartas do baralho
    public void imprimeBaralho() {
        for (int i = 0; i <= topo; i++) {
            System.out.println(maço[i]);
        }
    }

    public static void main(String[] args) {
        Baralho baralho = new Baralho();

        System.out.println("Baralho embaralhado:");
        baralho.imprimeBaralho();

        System.out.println("\nDistribuindo cartas:");
        while (baralho.temCarta()) {
            System.out.println("Carta retirada: " + baralho.daCarta());
        }

        System.out.println("\nAinda há cartas? " + baralho.temCarta());
    }
}
