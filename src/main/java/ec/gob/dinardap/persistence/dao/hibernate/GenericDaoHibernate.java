package ec.gob.dinardap.persistence.dao.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import ec.gob.dinardap.persistence.constante.CriteriaTypeEnum;
import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.util.Criteria;
import ec.gob.dinardap.persistence.util.CriteriaInnerJoin;
import ec.gob.dinardap.persistence.util.GenericDaoUtil;

public abstract class GenericDaoHibernate<T, PK extends Serializable> extends
		HibernateDaoSupport implements GenericDao<T, PK> {

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public String getType() {
		return HIBERNATE;
	}

	private Class<T> type;

	public GenericDaoHibernate(Class<T> type) {
		this.type = type;
	}

	public void update(T o) {
		super.getHibernateTemplate().update(o);
	}

	public void save(T o) {
		super.getHibernateTemplate().save(o);
	}

	public void saveOrUpdate(T o) {
		super.getHibernateTemplate().saveOrUpdate(o);
	}

	public T load(PK id) {
		return (T) super.getHibernateTemplate().load(type, id);
	}

	public T get(PK id) {
		return (T) super.getHibernateTemplate().get(type, id);
	}

	public void delete(T o) {
		super.getHibernateTemplate().delete(o);
	}

	public List<T> findAll() {
		return super.getHibernateTemplate().loadAll(type);
	}

	@Override
	public void flush() {
		super.getHibernateTemplate().flush();
	}

	@Override
	public void clear() {
		super.getHibernateTemplate().clear();
	}

	public void refresh(T o) {
		super.getHibernateTemplate().refresh(o);
	}

	public List<T> findByCriterias(Criteria criteria) {
		if (criteria instanceof CriteriaInnerJoin) {
			CriteriaInnerJoin ci = (CriteriaInnerJoin) criteria;
			return this.findByCriterias(criteria.getCriteriasOr(),
					criteria.getTypesOr(), criteria.getValuesCriteriaOr(),
					criteria.getCriteriasAnd(), criteria.getTypesAnd(),
					criteria.getValuesCriteriaAnd(),
					criteria.getCriteriasOrderBy(), criteria.getAsc(),
					ci.getInnerJoinObject(), ci.getInnerJoinProperty(),
					ci.getInnerJoinValue(), ci.getInnerJoinOperator());

		} else {

			return this.findByCriterias(criteria.getCriteriasOr(),
					criteria.getTypesOr(), criteria.getValuesCriteriaOr(),
					criteria.getCriteriasAnd(), criteria.getTypesAnd(),
					criteria.getValuesCriteriaAnd(),
					criteria.getCriteriasOrderBy(), criteria.getAsc(), null,
					null, null);
		}
	}

	public List<T> findByCriterias(Criteria criteria, int firstRow,
			int totalRows) {
		if (criteria instanceof CriteriaInnerJoin) {
			CriteriaInnerJoin ci = (CriteriaInnerJoin) criteria;

			return this.findByCriterias(criteria.getCriteriasOr(),
					criteria.getTypesOr(), criteria.getValuesCriteriaOr(),
					criteria.getCriteriasAnd(), criteria.getTypesAnd(),
					criteria.getValuesCriteriaAnd(),
					criteria.getCriteriasOrderBy(), criteria.getAsc(),
					ci.getInnerJoinObject(), ci.getInnerJoinProperty(),
					ci.getInnerJoinValue(), ci.getInnerJoinOperator(),
					firstRow, totalRows);
		} else {

			return this.findByCriterias(criteria.getCriteriasOr(),
					criteria.getTypesOr(), criteria.getValuesCriteriaOr(),
					criteria.getCriteriasAnd(), criteria.getTypesAnd(),
					criteria.getValuesCriteriaAnd(),
					criteria.getCriteriasOrderBy(), criteria.getAsc(), null,
					null, null, firstRow, totalRows);
		}
	}

	public Long totalFindByCriterias(Criteria criteria) {
		if (criteria instanceof CriteriaInnerJoin) {
			CriteriaInnerJoin ci = (CriteriaInnerJoin) criteria;

			return this.totalFindByCriterias(criteria.getCriteriasOr(),
					criteria.getTypesOr(), criteria.getValuesCriteriaOr(),
					criteria.getCriteriasAnd(), criteria.getTypesAnd(),
					criteria.getValuesCriteriaAnd(), ci.getInnerJoinObject(),
					ci.getInnerJoinProperty(), ci.getInnerJoinValue(),
					ci.getInnerJoinOperator());
		} else {
			return this.totalFindByCriterias(criteria.getCriteriasOr(),
					criteria.getTypesOr(), criteria.getValuesCriteriaOr(),
					criteria.getCriteriasAnd(), criteria.getTypesAnd(),
					criteria.getValuesCriteriaAnd(), null, null, null);
		}
	}

	public List<T> findByCriterias(String[] criteriasOr,
			CriteriaTypeEnum[] typesOr, Object[] valuesCriteriaOr,
			String[] criteriasAnd, CriteriaTypeEnum[] typesAnd,
			Object[] valuesCriteriaAnd, String[] criteriasOrderBy,
			boolean[] asc, String innerJoinObject, String innerJoinProperty,
			Object innerJoinValue) {

		List<T> list = findByCriterias(criteriasOr, typesOr, valuesCriteriaOr,
				criteriasAnd, typesAnd, valuesCriteriaAnd, criteriasOrderBy,
				asc, innerJoinObject, innerJoinProperty, innerJoinValue, -1, -1);
		return list;
	}

	public List<T> findByCriterias(String[] criteriasOr,
			CriteriaTypeEnum[] typesOr, Object[] valuesCriteriaOr,
			String[] criteriasAnd, CriteriaTypeEnum[] typesAnd,
			Object[] valuesCriteriaAnd, String[] criteriasOrderBy,
			boolean[] asc, String innerJoinObject, String innerJoinProperty,
			Object innerJoinValue, int firstRow, int totalRows) {
		return findByCriterias(criteriasOr, typesOr, valuesCriteriaOr,
				criteriasAnd, typesAnd, valuesCriteriaAnd, criteriasOrderBy,
				asc, innerJoinObject, innerJoinProperty, innerJoinValue, null,
				firstRow, totalRows);
	}

	public Long totalFindByCriterias(String[] criteriasOr,
			CriteriaTypeEnum[] typesOr, Object[] valuesCriteriaOr,
			String[] criteriasAnd, CriteriaTypeEnum[] typesAnd,
			Object[] valuesCriteriaAnd, String innerJoinObject,
			String innerJoinProperty, Object innerJoinValue) {
		return totalFindByCriterias(criteriasOr, typesOr, valuesCriteriaOr,
				criteriasAnd, typesAnd, valuesCriteriaAnd, innerJoinObject,
				innerJoinProperty, innerJoinValue, null);
	}

	/*
	 * Con inner join operator
	 */
	@Override
	public List<T> findByCriterias(String[] criteriasOr,
			CriteriaTypeEnum[] typesOr, Object[] valuesCriteriaOr,
			String[] criteriasAnd, CriteriaTypeEnum[] typesAnd,
			Object[] valuesCriteriaAnd, String[] criteriasOrderBy,
			boolean[] asc, String innerJoinObject, String innerJoinProperty,
			Object innerJoinValue, CriteriaTypeEnum innerJoinOperator) {
		List<T> list = findByCriterias(criteriasOr, typesOr, valuesCriteriaOr,
				criteriasAnd, typesAnd, valuesCriteriaAnd, criteriasOrderBy,
				asc, innerJoinObject, innerJoinProperty, innerJoinValue,
				innerJoinOperator, -1, -1);
		return list;
	}

	/*
	 * Con inner join operator
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByCriterias(String[] criteriasOr,
			CriteriaTypeEnum[] typesOr, Object[] valuesCriteriaOr,
			String[] criteriasAnd, CriteriaTypeEnum[] typesAnd,
			Object[] valuesCriteriaAnd, String[] criteriasOrderBy,
			boolean[] asc, String innerJoinObject, String innerJoinProperty,
			Object innerJoinValue, CriteriaTypeEnum innerJoinOperator,
			int firstRow, int totalRows) {
		List<Object> parameters = new ArrayList<Object>();

		String inner = (innerJoinObject != null) ? ("inner join obj."
				+ innerJoinObject + " " + innerJoinObject) : "";

		StringBuffer hql = new StringBuffer("select obj from " + type.getName()
				+ " obj " + inner + " where (");

		GenericDaoUtil.buildQueryCriteria(hql, parameters, criteriasOr,
				typesOr, valuesCriteriaOr, criteriasAnd, typesAnd,
				valuesCriteriaAnd, criteriasOrderBy, asc, innerJoinObject,
				innerJoinProperty, innerJoinValue, innerJoinOperator);

		//org.hibernate.Query query = super.getSession().createQuery(hql.toString());
		org.hibernate.query.Query<T> query = super.getSessionFactory().getCurrentSession().
				createQuery(hql.toString());
		int positionParameter = 0;
		for (Object object : parameters) {
			query.setParameter(positionParameter, object);
			positionParameter++;
		}

		if (firstRow >= 0) {
			query.setFirstResult(firstRow);
			query.setMaxResults(totalRows);
		}
		List<T> list = query.list();
		return list;
	}

	/*
	 * Con innerjoin operator
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Long totalFindByCriterias(String[] criteriasOr,
			CriteriaTypeEnum[] typesOr, Object[] valuesCriteriaOr,
			String[] criteriasAnd, CriteriaTypeEnum[] typesAnd,
			Object[] valuesCriteriaAnd, String innerJoinObject,
			String innerJoinProperty, Object innerJoinValue,
			CriteriaTypeEnum innerJoinOperator) {
		List<Object> parameters = new ArrayList<Object>();

		String inner = (innerJoinObject != null) ? ("inner join obj."
				+ innerJoinObject + " " + innerJoinObject) : "";

		StringBuffer hql = new StringBuffer("select count(obj) from "
				+ type.getName() + " obj " + inner + " where (");

		GenericDaoUtil.buildQueryCriteria(hql, parameters, criteriasOr,
				typesOr, valuesCriteriaOr, criteriasAnd, typesAnd,
				valuesCriteriaAnd, null, null, innerJoinObject,
				innerJoinProperty, innerJoinValue, innerJoinOperator);

		//org.hibernate.Query query = super.getSession().createQuery(hql.toString());
		org.hibernate.query.Query<T> query = super.getSessionFactory().getCurrentSession().
				createQuery(hql.toString());

		int positionParameter = 0;
		for (Object object : parameters) {
			query.setParameter(positionParameter, object);
			positionParameter++;
		}

		Long total = (Long) query.uniqueResult();

		return total;
	}
}