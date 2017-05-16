package br.univel.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.univel.model.Aluno;

@Stateless
public class AlunoDao {

	@PersistenceContext(unitName = "AlunoServer-persistence-unit")
	EntityManager em;

	public Aluno salvar(Aluno aluno) {

		em.persist(aluno);

		return aluno;
	}

	public List<Aluno> getTodosAlunos() {

		Query q = em.createQuery("from Aluno");
		return q.getResultList();
	}

}
