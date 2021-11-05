import java.util.HashSet;
import java.util.Set;

public class Disciplina {
    private String codigo;
    private String sigla;
    private String nome;
    private HashSet<Aula> aulas;
    private Docente docente;
    public HashSet<Horario> horarios;
//    os horários são obtidos agregando os horários de cada aula
//    uma disciplina pode fazer parte de mais do que um horário

    public Disciplina(String codigo, String sigla, String nome, HashSet<Aula> aulas, Docente docente) {
        this.codigo = codigo;
        this.sigla = sigla;
        this.nome = nome;
        this.aulas = aulas;
        this.docente = docente;
        this.horarios = this.getHorarios(aulas);
    }

    private HashSet<Horario> getHorarios(HashSet<Aula> aulas) {
        for (Aula aula : aulas){
            horarios.addAll(aula.getHorarios());
        }
        return horarios;
    }
}

//podem existir disciplinas com o mesmo nome e o mesmo docente e datas a cursos
//diferentes, no entanto as disciplinas têm de ter códigos diferentes
