import java.util.HashSet;
import java.util.Set;

public class Curso {
    private String nome;
    public Set<Disciplina> disciplinas;
    private HashSet<String> horarios;
    //    esse conjunto de horários é obtido agregando os horários de cada disciplina

    public Curso(String nome, Set<Disciplina> disciplinas) {
        this.nome = nome;
        this.disciplinas = disciplinas;
        this.horarios = getHorarios(disciplinas);
    }

    private HashSet<String> getHorarios(Set<Disciplina> disciplinas) {
        atualizaHorariosDeDisciplinas(disciplinas);
        return this.horarios;
    }

    private void atualizaHorariosDeDisciplinas(Set<Disciplina> disciplinas) {
        this.horarios = new HashSet<>();
        for (Disciplina disciplina : disciplinas) {
            this.horarios.addAll(disciplina.horarios);
        }
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
        atualizaHorariosDeDisciplinas(disciplinas);
    }

    public void removeDisciplina(Disciplina disciplina) {
        disciplinas.remove(disciplina);
        atualizaHorariosDeDisciplinas(disciplinas);
    }
}
