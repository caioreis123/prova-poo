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
    private JTextPane listagemDeHorarios;
    private JButton listarHoráriosDoAlunoButton;
    private JButton listarAlunosDoCursoButton;
    private JTextArea listagemDeAlunos;
    private JButton listarExAlunosButton;
    private HashMap<String, Disciplina> disciplinas = new HashMap<>();

    public UserInterface() {

        criarDisciplinaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = disciplinaNome.getText();
                String codigo = disciplinaCodigo.getText();
                String sigla = disciplinaSigla.getText();
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
                disciplinas.put(sigla, disciplina);
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
