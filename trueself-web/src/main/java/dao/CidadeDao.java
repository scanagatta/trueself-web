package dao;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Cidade;

@ApplicationScoped
public class CidadeDao extends GenericDAO<Cidade> {

	public CidadeDao() {
	}

	public String pesquisarPorEstado(String estado_codigo) {
		conectar();
		try {
			TypedQuery<String> tq = em.createNamedQuery(Cidade.PESQUISAR_POR_ESTADO, String.class);
			tq.setParameter(1, estado_codigo);
			return tq.getSingleResult();
		} catch (NoResultException e) {
			return null;

		} finally {
			desconectar();
		}
	}

	// metodo que descobre o codigo do usuario atraves do email dele
	// e procura esse usuario pelo codigo colocando no objeto com o find
	public Cidade pesquisarCidade(Integer codigo) {
		conectar();
		try {

			Cidade cidade = em.find(Cidade.class, codigo);

			return cidade;
		} catch (NoResultException e) {
			return null;
		} finally {
			desconectar();
		}
	}

}
