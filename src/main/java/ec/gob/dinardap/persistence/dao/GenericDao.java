package ec.gob.dinardap.persistence.dao;

import java.io.Serializable;
import java.util.List;

import ec.gob.dinardap.persistence.constante.CriteriaTypeEnum;
import ec.gob.dinardap.persistence.util.Criteria;

/**
 * @author Daniel Cardenas
 * 
 * @param <T>
 * @param <PK>
 */
public interface GenericDao<T, PK extends Serializable> {

	public static String HIBERNATE = "H";
	public static String EJB = "E";

	String getType();// H - Hibernate or E - EJB

	void update(T o);

	void save(T o);

	void saveOrUpdate(T o);

	T load(PK id);

	T get(PK id);

	void delete(T o);

	List<T> findAll();

	void flush();
	
	void clear();

	void refresh(T o);

	/* criteria */
	List<T> findByCriterias(Criteria criteria);

	List<T> findByCriterias(Criteria criteria, int firstRow, int totalRows);

	Long totalFindByCriterias(Criteria criteria);

	// inner

	/**
	 * Devuelve los registros segun los parametros
	 * 
	 * @param criteriasOr
	 * @param typesOr
	 * @param valuesCriteriaOr
	 * @param criteriasAnd
	 * @param typesAnd
	 * @param valuesCriteriaAnd
	 * @param criteriasOrderBy
	 * @param asc
	 * @param innerJoinObject
	 * @param innerJoinProperty
	 * @param innerJoinValue
	 * @return
	 */
	List<T> findByCriterias(String[] criteriasOr, CriteriaTypeEnum[] typesOr,
			Object[] valuesCriteriaOr, String[] criteriasAnd,
			CriteriaTypeEnum[] typesAnd, Object[] valuesCriteriaAnd,
			String[] criteriasOrderBy, boolean[] asc, String innerJoinObject,
			String innerJoinProperty, Object innerJoinValue);

	/**
	 * Devuelve una lista de objetos segun los parametros
	 * 
	 * @param criteriasOr
	 * @param typesOr
	 * @param valuesCriteriaOr
	 * @param criteriasAnd
	 * @param typesAnd
	 * @param valuesCriteriaAnd
	 * @param criteriasOrderBy
	 * @param asc
	 * @param innerJoinObject
	 * @param innerJoinProperty
	 * @param innerJoinValue
	 * @param firstRow
	 * @param totalRows
	 * @return
	 */
	List<T> findByCriterias(String[] criteriasOr, CriteriaTypeEnum[] typesOr,
			Object[] valuesCriteriaOr, String[] criteriasAnd,
			CriteriaTypeEnum[] typesAnd, Object[] valuesCriteriaAnd,
			String[] criteriasOrderBy, boolean[] asc, String innerJoinObject,
			String innerJoinProperty, Object innerJoinValue, int firstRow,
			int totalRows);

	/**
	 * Devuelve el total de registros segun los parametros
	 * 
	 * @param criteriasOr
	 * @param typesOr
	 * @param valuesCriteriaOr
	 * @param criteriasAnd
	 * @param typesAnd
	 * @param valuesCriteriaAnd
	 * @param innerJoinObject
	 * @param innerJoinProperty
	 * @param innerJoinValue
	 * @return
	 */
	Long totalFindByCriterias(String[] criteriasOr, CriteriaTypeEnum[] typesOr,
			Object[] valuesCriteriaOr, String[] criteriasAnd,
			CriteriaTypeEnum[] typesAnd, Object[] valuesCriteriaAnd,
			String innerJoinObject, String innerJoinProperty,
			Object innerJoinValue);

	/**
	 * Devuelve los registros segun los parametros
	 * 
	 * @param criteriasOr
	 * @param typesOr
	 * @param valuesCriteriaOr
	 * @param criteriasAnd
	 * @param typesAnd
	 * @param valuesCriteriaAnd
	 * @param criteriasOrderBy
	 * @param asc
	 * @param innerJoinObject
	 * @param innerJoinProperty
	 * @param innerJoinValue
	 * @param innerJoinOperator
	 * @return
	 */
	List<T> findByCriterias(String[] criteriasOr, CriteriaTypeEnum[] typesOr,
			Object[] valuesCriteriaOr, String[] criteriasAnd,
			CriteriaTypeEnum[] typesAnd, Object[] valuesCriteriaAnd,
			String[] criteriasOrderBy, boolean[] asc, String innerJoinObject,
			String innerJoinProperty, Object innerJoinValue,
			CriteriaTypeEnum innerJoinOperator);

	/**
	 * Devuelve una lista de objetos segun los parametros
	 * 
	 * @param criteriasOr
	 * @param typesOr
	 * @param valuesCriteriaOr
	 * @param criteriasAnd
	 * @param typesAnd
	 * @param valuesCriteriaAnd
	 * @param criteriasOrderBy
	 * @param asc
	 * @param innerJoinObject
	 * @param innerJoinProperty
	 * @param innerJoinValue
	 * @param innerJoinOperator
	 * @param firstRow
	 * @param totalRows
	 * @return
	 */
	List<T> findByCriterias(String[] criteriasOr, CriteriaTypeEnum[] typesOr,
			Object[] valuesCriteriaOr, String[] criteriasAnd,
			CriteriaTypeEnum[] typesAnd, Object[] valuesCriteriaAnd,
			String[] criteriasOrderBy, boolean[] asc, String innerJoinObject,
			String innerJoinProperty, Object innerJoinValue,
			CriteriaTypeEnum innerJoinOperator, int firstRow, int totalRows);

	/**
	 * Devuelve el total de registros segun los parametros
	 * 
	 * @param criteriasOr
	 * @param typesOr
	 * @param valuesCriteriaOr
	 * @param criteriasAnd
	 * @param typesAnd
	 * @param valuesCriteriaAnd
	 * @param innerJoinObject
	 * @param innerJoinProperty
	 * @param innerJoinValue
	 * @param innerJoinOperator
	 * @return
	 */
	Long totalFindByCriterias(String[] criteriasOr, CriteriaTypeEnum[] typesOr,
			Object[] valuesCriteriaOr, String[] criteriasAnd,
			CriteriaTypeEnum[] typesAnd, Object[] valuesCriteriaAnd,
			String innerJoinObject, String innerJoinProperty,
			Object innerJoinValue, CriteriaTypeEnum innerJoinOperator);

}