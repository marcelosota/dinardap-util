/* 
 * GenericService.java
 * Mar 8, 2010 
 * Copyright 2010 Saviasoft Cia. Ltda. 
 */
package ec.gob.dinardap.persistence.servicio;

import java.io.Serializable;
import java.util.List;

import ec.gob.dinardap.persistence.util.Criteria;

/**
 * @author 
 * 
 */
public interface GenericService<T, PK extends Serializable> {

	/**
	 * Devuelve una lista de registros segun los parametros
	 * 
	 * @param Criteria
	 * @param firstRow
	 * @param totalRows
	 * @return
	 */
	List<T> findByCriterias(Criteria criteria, int firstRows, int totalRows);

	/**
	 * Devuelve el total de registros segun los parametros
	 * 
	 * @param criteriasOr
	 *            - Ej. names,lastNames
	 * @param typesOr
	 *            - Ej. CriteriaTypeEnum.STRING,CriteriaTypeEnum.STRING
	 * @param valuesCriteriaOr
	 *            - Ej. '%','zurita'
	 * @param criteriasAnd
	 *            - Ej. names,lastNames
	 * @param typesAnd
	 *            - Ej. CriteriaTypeEnum.STRING,CriteriaTypeEnum.STRING
	 * @param valuesCriteriaAnd
	 *            - Ej. '%','zurita'
	 * @return
	 */
	Long totalFindByCriterias(Criteria criteria);

	/**
	 * Devuelve una lista de registros segun los parametros
	 * 
	 * @param criteriasOr
	 *            - Ej. names,lastNames
	 * @param typesOr
	 *            - Ej. CriteriaTypeEnum.STRING,CriteriaTypeEnum.STRING
	 * @param valuesCriteriaOr
	 *            - Ej. '%','zurita'
	 * @param criteriasAnd
	 *            - Ej. names,lastNames
	 * @param typesAnd
	 *            - Ej. CriteriaTypeEnum.STRING,CriteriaTypeEnum.STRING
	 * @param valuesCriteriaAnd
	 *            - Ej. '%','zurita'
	 * @param criteriasOrderBy
	 *            - Ej. lastNames, names
	 * @param asc
	 *            - Ej. true, true
	 * @return
	 */
	public List<T> findByCriterias(Criteria criteria);

	public T findByPk(PK pk);
	
	void create(T t);

	void update(T t);

	void delete(PK pk);
	
	public List<T> findAll();
}