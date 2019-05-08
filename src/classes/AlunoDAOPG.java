package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import interfaces.IAlunoDAO;

public class AlunoDAOPG implements IAlunoDAO {
	
	
	
	public Aluno retrieve(Aluno a) {
		Aluno a1 = null;
		try {
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/aula", "postgres",
					"ArS227528");
			Statement stmt = c.createStatement();
			String sqlSelect = "SELECT * FROM aluno where matricula =" + a.getMatricula() + "limit 1" + ";";
			ResultSet resultSet = stmt.executeQuery(sqlSelect);

			while (resultSet.next()) {
				Integer matricula = resultSet.getInt("matricula");
				String nome = resultSet.getString("nome");
				a1 = new Aluno(matricula, nome);
			}
			resultSet.close();
			c.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não foi possível fazer a consulta");
			return a1;
		}
		return a1;
	}

	public boolean delete(Aluno a) {
		try {
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/aula", "postgres",
					"ArS227528");
			Statement stmt = c.createStatement();
			String sqlCreate = "DELETE from aluno where matricula = " + a.getMatricula() + ";";
			stmt.execute(sqlCreate);
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		System.out.println("O aluno foi removido com sucesso!");
		return true;
	}

	public boolean update(int matricula, Aluno a) {
		try {
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/aula", "postgres",
					"ArS227528");
			Statement stmt = c.createStatement();
			String sqlCreate = "UPDATE aluno set nome =" + "'"+a.getNome()+"'"+ ","+" matricula=" + a.getMatricula() + " where matricula= "+ matricula + ";";
			stmt.execute(sqlCreate);
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		System.out.println("O aluno foi editado com sucesso!");
		return true;
	}

	public List<Aluno> retrieveAll() {
		List<Aluno> listaAluno = new ArrayList<Aluno>();
		try {
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/aula", "postgres",
					"ArS227528");
			Statement stmt = c.createStatement();
			String sqlSelect = "SELECT * FROM aluno;";
			ResultSet resultSet = stmt.executeQuery(sqlSelect);
			while (resultSet.next()) {
				Integer matricula = resultSet.getInt("matricula");
				String nome = resultSet.getString("nome");
				listaAluno.add(new Aluno(matricula, nome));
			}
			resultSet.close();
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAluno;
	}

	public void create(Aluno a) {
		try {
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/aula", "postgres",
					"ArS227528");
			Statement stmt = c.createStatement();
			String sqlCreate = "INSERT INTO aluno VALUES(" + a.getMatricula() + ",'" + a.getNome() + "');";
			stmt.execute(sqlCreate);
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
