import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface {
    private JPanel panel1;
    private JTextField segundaTextField;
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

    public UserInterface() {

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
