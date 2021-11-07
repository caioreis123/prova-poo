import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Digite a área do campo de futebol em metros quadrados\n");
        BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
        try {
            float metros = Float.parseFloat(leitor.readLine());
            float pes = ConversaoDeUnidadesDeArea.metroParaPe(metros);
            float centimetros = ConversaoDeUnidadesDeArea.peParaCentimetro(pes);
            float acres = ConversaoDeUnidadesDeArea.metroParaAcre(metros);
            System.out.printf("A área do campo de futebol é de: %f pes quadrados, %f acres quadrados e %f centimetros quadrados%n", pes, acres, centimetros);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
