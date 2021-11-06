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

    public void adicionarDisciplinas(HashSet<Disciplina> disciplinas) {
        this.disciplinas.addAll(disciplinas);
        atualizaHorariosDeDisciplinas(disciplinas);
    }

    public void removerDisciplinas(HashSet<Disciplina> disciplinas) {
        this.disciplinas.removeAll(disciplinas);
        for (Disciplina disciplina : disciplinas) {
            this.horarios.removeAll(disciplina.horarios);
        }
    }
}
