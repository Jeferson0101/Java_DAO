package interfaces;

import java.util.List;

import classes.Aluno;

public interface IAlunoDAO {
	public void create(Aluno a);
	public boolean delete(Aluno a); 
	public List<Aluno> retrieveAll();
	public Aluno retrieve(Aluno a);
	public boolean update(int matricula,Aluno a);
}
