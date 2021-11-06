import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Disciplina {
    private String codigo;
    private String sigla;
    private String nome;
    private HashSet<Aula> aulas;
    private String docente;
    public HashSet<String> horarios = new HashSet<String>();
//    os horários são obtidos agregando os horários de cada aula
//    uma disciplina pode fazer parte de mais do que um horário

    public Disciplina(String codigo, String sigla, String nome, HashSet<Aula> aulas, String docente) {
        this.codigo = codigo;
        this.sigla = sigla;
        this.nome = nome;
        this.aulas = aulas;
        this.docente = docente;
        this.horarios = getHorarios(aulas);
    }

    @Override
    public String toString(){
        return this.sigla;
    }

    private HashSet<String> getHorarios(HashSet<Aula> aulas) {
        for (Aula aula : aulas){
            horarios.add(aula.horaInicio);
        }
        return horarios;
    }
}

//podem existir disciplinas com o mesmo nome e o mesmo docente e datas a cursos
//diferentes, no entanto as disciplinas têm de ter códigos diferentes
