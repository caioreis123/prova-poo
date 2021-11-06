import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;

public class UserInterface {
    private JPanel panel1;
    private JTextField disciplinaDia1;
    private JTextField disciplinaDia2;
    private JTextField disciplinaDuracao2;
    private JTextField disciplinaHora1;
    private JTextField disciplinaNome;
    private JButton criarDisciplinaButton;
    private JTextField disciplinaHora2;
    private JTextField disciplinaDuracao1;
    private JTextField disciplinaCodigo;
    private JTextField disciplinaSigla;
    private JTextField docente;
    private JTextField disciplinasDoCurso;
    private JButton adicionarDisciplinasAoCursoButton;
    private JTextField alunoNome;
    private JTextField alunoCurso;
    private JButton matricularAlunoButton;
    private JTextField alunoDisciplinasParaMatricula;
    private JTextField cursoNome;
    private JButton removerDisciplinasDoCursoButton;
    private JButton lançarNotaButton;
    private JTextField alunoDisciplinaParaNota;
    private JTextField alunoNota;
    private JButton listarHoráriosDoAlunoButton;
    private JButton listarAlunosDoCursoButton;
    private JTextArea listagemDeAlunos;
    private JButton listarExAlunosButton;
    private HashMap<String, Disciplina> todasDisciplinas = new HashMap<>();
    private HashMap<String, Curso> todosCursos = new HashMap<>();
    private HashMap<String, Aluno> todosAlunos = new HashMap<>();

    public UserInterface() {

        criarDisciplinaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = disciplinaNome.getText();
                String codigo = disciplinaCodigo.getText();
                String sigla = disciplinaSigla.getText().toUpperCase();
                String hora1 = disciplinaHora1.getText();
                String hora2 = disciplinaHora2.getText();
                String duracao1 = disciplinaDuracao1.getText();
                String duracao2 = disciplinaDuracao2.getText();
                String professor = docente.getText();
                String dia1 = disciplinaDia1.getText();
                String dia2 = disciplinaDia2.getText();

                Aula aula1 = new Aula(hora1, duracao1, dia1);
                Aula aula2 = new Aula(hora2, duracao2, dia2);
                HashSet<Aula> aulas = new HashSet<>();
                aulas.add(aula1);
                aulas.add(aula2);
                Disciplina disciplina = new Disciplina(codigo, sigla, nome, aulas, professor);
                System.out.println(disciplina);
                todasDisciplinas.put(sigla, disciplina);
            }
        });
        adicionarDisciplinasAoCursoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HashSet<Disciplina> disciplinasASeremAdicionadasAoCurso = new HashSet<>();
                String nome = cursoNome.getText().toUpperCase();
                String[] siglas = disciplinasDoCurso.getText().split(",");
                for (String sigla : siglas) {
                    sigla = sigla.trim().toUpperCase();
                    Disciplina disciplina = todasDisciplinas.get(sigla);
                    disciplinasASeremAdicionadasAoCurso.add(disciplina);
                }
                if (todosCursos.containsKey(nome)) {
                    Curso curso = todosCursos.get(nome);
                    curso.adicionarDisciplinas(disciplinasASeremAdicionadasAoCurso);
                }
                else{
                    Curso curso = new Curso(nome, disciplinasASeremAdicionadasAoCurso);
                    todosCursos.put(nome, curso);
                }
            }
        });
        removerDisciplinasDoCursoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = cursoNome.getText();
                Curso curso = todosCursos.get(nome);
                String[] siglas = disciplinasDoCurso.getText().split(",");
                HashSet<Disciplina> disciplinasASeremRemovidasDoCurso = new HashSet<>();
                for (String sigla : siglas) {
                    sigla = sigla.trim().toUpperCase();
                    Disciplina disciplina = todasDisciplinas.get(sigla);
                    disciplinasASeremRemovidasDoCurso.add(disciplina);
                }
                curso.removerDisciplinas(disciplinasASeremRemovidasDoCurso);
                System.out.println(curso);
            }
        });
        listarAlunosDoCursoButton.addActionListener(new ActionListener() {
//            Listagem dos alunos de um dado curso, indicando para cada um deles as disciplinas
//            que já concluíram e as que lhe falta concluir.
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = cursoNome.getText();
                Curso curso = todosCursos.get(nome);
                listagemDeAlunos.setText("");
                listagemDeAlunos.setText(curso.listarAlunos());
            }
        });
        listarExAlunosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = cursoNome.getText();
                Curso curso = todosCursos.get(nome);
                listagemDeAlunos.setText("");
                listagemDeAlunos.setText(String.format("Ex-alunos: %s", curso.exAlunos.toString()));
            }
        });
        matricularAlunoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = cursoNome.getText();
                String nomeAluno = alunoNome.getText();
                String[] disciplinasNomes = alunoDisciplinasParaMatricula.getText().split(",");
                Curso curso = todosCursos.get(nome);
                Aluno aluno = new Aluno(curso, nomeAluno);
                HashSet<Disciplina> disciplinasASeremMatriculadas = new HashSet<>();
                for (String sigla : disciplinasNomes) {
                    sigla = sigla.trim().toUpperCase();
                    Disciplina disciplina = todasDisciplinas.get(sigla);
                    aluno.matricularAlunoEmDisciplina(disciplina);
                }
                todosAlunos.put(nomeAluno, aluno);
            }
        });
        lançarNotaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeAluno = alunoNome.getText();
                String sigla = alunoDisciplinaParaNota.getText();
                Aluno aluno = todosAlunos.get(nomeAluno);
                Disciplina disciplina = todasDisciplinas.get(sigla);
                aluno.lancarNota(disciplina, Float.parseFloat(alunoNota.getText()));
            }
        });
        listarHoráriosDoAlunoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeAluno = alunoNome.getText();
                Aluno aluno = todosAlunos.get(nomeAluno);
                listagemDeAlunos.setText(aluno.getHorarios());
            }
        });
    }

//        horario é horaInicio, duracao e dia da semana

//        alterar horário de aula
//        criar disciplina passando conjunto de aulas
//        criar curso passando lista de disciplinas
//        adicionar disciplina do curso
//        remover disciplina do curso

//        matricular aluno em disciplinas e em curso
//        listar horário do aluno
//        lançar notas de uma disciplina de um aluno em um curso

//        listar ex-alunos
//        listar alunos de um curso indicando as disciplinas que já concluiram e que faltam concluir

    public static void main(String[] args) {
        JFrame frame = new JFrame("UserInterface");
        frame.setContentPane(new UserInterface().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
