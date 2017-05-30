package br.univel.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.univel.model.Aluno;

@Stateless
@Remote(AlunoDao.class)
public class AlunoDaoImpl implements AlunoDao {

	@PersistenceContext(unitName = "AlunoServer-persistence-unit")
	EntityManager em;

	/* (non-Javadoc)
	 * @see br.univel.dao.AlunoDaoIF#salvar(br.univel.model.Aluno)
	 */
	@Override
	public Aluno salvar(Aluno aluno) {

		em.persist(aluno);

		return aluno;
	}

	/* (non-Javadoc)
	 * @see br.univel.dao.AlunoDaoIF#getTodosAlunos()
	 */
	@Override
	public List<Aluno> getTodosAlunos() {

		Query q = em.createQuery("from Aluno");
		return q.getResultList();
	}

}
