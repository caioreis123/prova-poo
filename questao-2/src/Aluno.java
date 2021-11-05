import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Aluno {
    public String nome;
    private Curso cursoMatriculado;
    private Set<Disciplina> disciplinasMatriculadas;
    private HashMap<Disciplina, Float>  disciplinasCursadasENotas;
    private Set<Disciplina>  disciplinasRestantes;
    private Set<Horario> horarios;
//    esses horários são agregados das disciplinas matriculadas
    private Boolean isExAluno;
//    Quando um aluno realiza todas as disciplinas do curso, deixa de ser aluno e passa a ser ex-aluno.

    public Aluno(Curso cursoMatriculado, String nome) {
        this.nome = nome;
        this.cursoMatriculado = cursoMatriculado;
        this.isExAluno = false;
        this.disciplinasRestantes.addAll(cursoMatriculado.disciplinas);
    }

    public void matricularAlunoEmDisciplina(Disciplina disciplina) {
        this.disciplinasMatriculadas.add(disciplina);
        atualizaHorarios();
    }

    public void lancarNota(Disciplina disciplina, Float nota) {
        this.disciplinasCursadasENotas.put(disciplina, nota);
        this.disciplinasMatriculadas.remove(disciplina);
        this.disciplinasRestantes.remove(disciplina);
        atualizaHorarios();
        if (this.disciplinasRestantes.isEmpty()) {
            this.isExAluno = true;
        }
    }

    public Set<Horario> getHorarios(){
        atualizaHorarios();
        return horarios;
    }

    private void atualizaHorarios() {
        horarios.clear();
        for (Disciplina disciplina : disciplinasMatriculadas){
            horarios.addAll(disciplina.horarios);
        }
    }
}
