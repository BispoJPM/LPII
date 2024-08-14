import java.util.Random;

public class Baralho {
    private Carta[] maço;

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

        int total = 10; // mudar aqui a quantidade de vezes que vai embaralhar
        int x = 0;

        Random random = new Random();

        while (x < total) { // enquanto x for menor que o total qe é a constante, o codigo vai coisar
            for (int emb = maço.length - 1; emb > 0; emb--) { // aqui vai começar do final e vai trocar as cartas (lenght é o comprimento do array)
                int sid = random.nextInt(emb + 1);  // vai gerar um numero aleatorio e vai somar no embaralhar
                Carta subs = maço[emb]; // vai guardar a carta aqui
                maço[emb] = maço[sid]; // depois vai passara pra ca
                maço[sid] = subs; // aqui vai ficar as cartas embalkarahadas 
            }
            x++; // no final de tudo, vai aumentar 1 no X e vai indo até ele superar o total e parar.
        }
    }
}


        //função pra imprimir o baralho 
//     public void imprimirCartas() {
//         for (Carta carta : maço) {
//             System.out.println(carta);
//         }
//     }
        // sem o psvm n tem como fazer executar, tem que fazer um novo objeto do que tu qr e puxar a função de imprimir.
//     public static void main(String[] args) {
//         Baralho baralho = new Baralho();
//         baralho.imprimirCartas();
//     }
// }



