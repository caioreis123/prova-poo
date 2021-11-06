import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Aluno {
    public String nome;
    private Curso cursoMatriculado;
    private Set<Disciplina> disciplinasMatriculadas;
    public HashMap<Disciplina, Float>  disciplinasCursadasENotas;
    public Set<Disciplina>  disciplinasRestantes;
    private HashSet<String> horarios;
//    esses horários são agregados das disciplinas matriculadas
    private Boolean isExAluno;
//    Quando um aluno realiza todas as disciplinas do curso, deixa de ser aluno e passa a ser ex-aluno.

    public Aluno(Curso cursoMatriculado, String nome) {
        this.nome = nome;
        this.cursoMatriculado = cursoMatriculado;
        this.isExAluno = false;
        this.disciplinasRestantes = new HashSet<>();
        this.disciplinasMatriculadas = new HashSet<>();
        this.disciplinasCursadasENotas = new HashMap<>();
        this.disciplinasRestantes.addAll(cursoMatriculado.disciplinas);
        cursoMatriculado.adicionarAluno(this);
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
            this.cursoMatriculado.exAlunos.append(this.nome + " ");
            this.cursoMatriculado.alunos.remove(this);
        }
    }

    public String getHorarios(){
        atualizaHorarios();
        return String.join(", ", horarios);
    }

    private HashSet<String> atualizaHorarios() {
        this.horarios = new HashSet<>();
        for (Disciplina disciplina : disciplinasMatriculadas){
            this.horarios.addAll(disciplina.horarios);
        }
        return this.horarios;
    }
}
