package ec.gob.dinardap.persistence.servicio.impl;

import java.io.Serializable;
import java.util.List;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.GenericService;
import ec.gob.dinardap.persistence.util.Criteria;

/**
 * @author 
 * 
 * @param <T>
 * @param <PK>
 */
public abstract class GenericServiceImpl<T, PK extends Serializable> implements
		GenericService<T, PK> {

	public abstract GenericDao<T, PK> getDao();

	@Override
	public List<T> findByCriterias(Criteria criteria, int firstRows,
			int totalRows) {
		return getDao().findByCriterias(criteria, firstRows, totalRows);
	}

	@Override
	public Long totalFindByCriterias(Criteria criteria) {
		return getDao().totalFindByCriterias(criteria);
	}

	@Override
	public List<T> findByCriterias(Criteria criteria) {
		return getDao().findByCriterias(criteria);
	}

	@Override
	public void create(T t) {
		getDao().save(t);
	}

	@Override
	public T findByPk(PK pk) {
		T r = null;
		if (getDao().getType().equals(GenericDao.HIBERNATE)) {
			r = getDao().get(pk);
		}
		if (getDao().getType().equals(GenericDao.EJB)) {
			r = getDao().load(pk);
		}
		return r;
	}

	public void update(T t) {
		getDao().update(t);

	}

	public void delete(PK pk) {
		getDao().delete(getDao().load(pk));
	}

	public List<T> findAll() {
		return getDao().findAll();
	}
}