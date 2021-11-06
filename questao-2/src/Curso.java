import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Curso {
    private String nome;
    public Set<Disciplina> disciplinas;
    private HashSet<String> horarios;
    public HashSet<Aluno> alunos;
    public StringBuilder exAlunos = new StringBuilder();

    public Curso(String nome, Set<Disciplina> disciplinas) {
        this.nome = nome;
        this.disciplinas = disciplinas;
        this.horarios = getHorarios(disciplinas);
        this.alunos = new HashSet<>();
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

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public String listarAlunos() {
        StringBuilder linhas = new StringBuilder();
        for (Aluno aluno : alunos) {
            String linha = String.format("%s: \n Disciplinas restantes: %s\n Disciplinas cursadas: %s \n", aluno.nome.toUpperCase(), aluno.disciplinasRestantes.toString(), aluno.disciplinasCursadasENotas.keySet().toString());
            linhas.append(linha);
        }
        return linhas.toString();
    }
}
