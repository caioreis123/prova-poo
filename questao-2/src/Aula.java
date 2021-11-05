import java.util.HashSet;

public class Aula{
    private HashSet<Horario> horarios;

    public Aula(HashSet<Horario> horarios){
        this.horarios = horarios;
    }

    public HashSet<Horario> getHorarios(){
        return horarios;
    }

    public HashSet<Horario> adicionarHorario(Horario horario){
        horarios.add(horario);
        return horarios;
    }

    public HashSet<Horario> removerHorario(Horario horario){
        horarios.remove(horario);
        return horarios;
    }
}
