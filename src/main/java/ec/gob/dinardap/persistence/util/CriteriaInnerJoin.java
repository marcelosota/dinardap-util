/* 
 * CriteriaInnerJoin.java
 * Apr 29, 2010 
 * Copyright 2010 Saviasoft Cia. Ltda. 
 */
package ec.gob.dinardap.persistence.util;

import ec.gob.dinardap.persistence.constante.CriteriaTypeEnum;


/**
 * @author saviasoft1
 * 
 */
public class CriteriaInnerJoin extends Criteria {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2470857837771580511L;
	private String innerJoinObject;
	private String innerJoinProperty;
	private Object innerJoinValue;
	private CriteriaTypeEnum innerJoinOperator;

	public CriteriaInnerJoin(String[] criteriasAnd,
			CriteriaTypeEnum[] typesAnd, Object[] valuesCriteriaAnd,
			String[] criteriasOrderBy, boolean[] asc, String innerJoinObject,
			String innerJoinProperty, Object innerJoinValue) {
		super(criteriasAnd, typesAnd, valuesCriteriaAnd, criteriasOrderBy, asc);
		this.innerJoinObject = innerJoinObject;
		this.innerJoinProperty = innerJoinProperty;
		this.innerJoinValue = innerJoinValue;
	}

	public CriteriaInnerJoin(String[] criteriasAnd,
			CriteriaTypeEnum[] typesAnd, Object[] valuesCriteriaAnd,
			String[] criteriasOrderBy, boolean[] asc, String innerJoinObject,
			String innerJoinProperty, Object innerJoinValue,
			CriteriaTypeEnum innerJoinOperator) {
		super(criteriasAnd, typesAnd, valuesCriteriaAnd, criteriasOrderBy, asc);
		this.innerJoinObject = innerJoinObject;
		this.innerJoinProperty = innerJoinProperty;
		this.innerJoinValue = innerJoinValue;
		this.innerJoinOperator = innerJoinOperator;
	}

	public CriteriaInnerJoin(String[] criteriasOr, CriteriaTypeEnum[] typesOr,
			Object[] valuesCriteriaOr, String[] criteriasAnd,
			CriteriaTypeEnum[] typesAnd, Object[] valuesCriteriaAnd,
			String[] criteriasOrderBy, boolean[] asc, String innerJoinObject,
			String innerJoinProperty, Object innerJoinValue) {
		super(criteriasOr, typesOr, valuesCriteriaOr, criteriasAnd, typesAnd,
				valuesCriteriaAnd, criteriasOrderBy, asc);
		this.innerJoinObject = innerJoinObject;
		this.innerJoinProperty = innerJoinProperty;
		this.innerJoinValue = innerJoinValue;
	}

	public CriteriaInnerJoin(String[] criteriasAnd,
			CriteriaTypeEnum[] typesAnd, Object[] valuesCriteriaAnd,
			String innerJoinObject, String innerJoinProperty,
			Object innerJoinValue) {
		super(criteriasAnd, typesAnd, valuesCriteriaAnd);
		this.innerJoinObject = innerJoinObject;
		this.innerJoinProperty = innerJoinProperty;
		this.innerJoinValue = innerJoinValue;
	}

	/**
	 * @return the innerJoinObject
	 */
	public String getInnerJoinObject() {
		return innerJoinObject;
	}

	/**
	 * @param innerJoinObject
	 *            the innerJoinObject to set
	 */
	public void setInnerJoinObject(String innerJoinObject) {
		this.innerJoinObject = innerJoinObject;
	}

	/**
	 * @return the innerJoinProperty
	 */
	public String getInnerJoinProperty() {
		return innerJoinProperty;
	}

	/**
	 * @param innerJoinProperty
	 *            the innerJoinProperty to set
	 */
	public void setInnerJoinProperty(String innerJoinProperty) {
		this.innerJoinProperty = innerJoinProperty;
	}

	/**
	 * @return the innerJoinValue
	 */
	public Object getInnerJoinValue() {
		return innerJoinValue;
	}

	/**
	 * @param innerJoinValue
	 *            the innerJoinValue to set
	 */
	public void setInnerJoinValue(Object innerJoinValue) {
		this.innerJoinValue = innerJoinValue;
	}

	/**
	 * @return the innerJoinOperator
	 */
	public CriteriaTypeEnum getInnerJoinOperator() {
		return innerJoinOperator;
	}

	/**
	 * @param innerJoinOperator
	 *            the innerJoinOperator to set
	 */
	public void setInnerJoinOperator(CriteriaTypeEnum innerJoinOperator) {
		this.innerJoinOperator = innerJoinOperator;
	}

}