public class Controle {
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
