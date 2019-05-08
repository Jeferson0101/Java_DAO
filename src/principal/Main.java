package principal;

import java.util.List;
import interfaces.IAlunoDAO;
import classes.Aluno;
import classes.AlunoDAOPG;

public class Main {

	public static void main(String[] args) {
		IAlunoDAO alunoDAO = new AlunoDAOPG();
		
		
		// Criando os alunos no Data Base
		Aluno aluno1 = new Aluno(11067895, "Joaozinho");
		alunoDAO.create(aluno1);
		
		Aluno aluno2 = new Aluno(24357512, "Maria");
		alunoDAO.create(aluno2);

		// RetrieveAll
		List<Aluno> listaAluno = alunoDAO.retrieveAll();
		for (Aluno aluno : listaAluno) {
			System.out.println(aluno.getMatricula() + "=>" + aluno.getNome());
		}

		// Retrieve // ele ta pegando o jo�ozinho.. s� n�o sei pq nao est� mostrando :3
		Aluno resultado = alunoDAO.retrieve(aluno1);
		resultado.toString();

		// UPDATE
		Aluno aluno3 = new Aluno(11067895, "Arlindo");
		// Eu deixei para poder dar um update na matr�cula.. nao sei se era necess�rio. dai passo a matricula antiga
		// como o primeiro par�metro e depois att o aluno.		
		alunoDAO.update(11067895, aluno3);

		// Delete
		alunoDAO.delete(aluno1);
	}
}
