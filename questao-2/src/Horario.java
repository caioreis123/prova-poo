import java.util.Set;

public class Horario {
    private Integer horaInicio;
    private Integer duracao;
    private Dia dia;

    public Horario(Integer horaInicio, Integer duracao, Dia dia) {
        this.horaInicio = horaInicio;
        this.duracao = duracao;
        this.dia = dia;
    }
}
