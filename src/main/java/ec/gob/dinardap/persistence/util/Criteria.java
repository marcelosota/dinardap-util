/* 
 * Criteria.java
 * Mar 8, 2010 
 * Copyright 2010 Saviasoft Cia. Ltda. 
 */
package ec.gob.dinardap.persistence.util;

import java.io.Serializable;
import java.util.List;

import ec.gob.dinardap.persistence.constante.CriteriaTypeEnum;

/**
 * @author saviasoft4
 * 
 */
public class Criteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6589967430915183197L;
	private String[] criteriasOr;
	private CriteriaTypeEnum[] typesOr;
	private Object[] valuesCriteriaOr;
	private String[] criteriasAnd;
	private CriteriaTypeEnum[] typesAnd;
	private Object[] valuesCriteriaAnd;
	private String[] criteriasOrderBy;
	private boolean[] asc;

	private StringBuffer query;
	private StringBuffer orderBy;
	private List<Object> parameters;

	public Criteria(StringBuffer query, StringBuffer orderBy,
			List<Object> parameters) {
		this.query = query;
		this.orderBy=orderBy;
		this.parameters = parameters;
	}

	/**
	 * @param criteriasOr
	 * @param typesOr
	 * @param valuesCriteriaOr
	 * @param criteriasAnd
	 * @param typesAnd
	 * @param valuesCriteriaAnd
	 * @param criteriasOrderBy
	 * @param asc
	 */
	public Criteria(String[] criteriasOr, CriteriaTypeEnum[] typesOr,
			Object[] valuesCriteriaOr, String[] criteriasAnd,
			CriteriaTypeEnum[] typesAnd, Object[] valuesCriteriaAnd,
			String[] criteriasOrderBy, boolean[] asc) {
		super();
		this.criteriasOr = criteriasOr;
		this.typesOr = typesOr;
		this.valuesCriteriaOr = valuesCriteriaOr;
		this.criteriasAnd = criteriasAnd;
		this.typesAnd = typesAnd;
		this.valuesCriteriaAnd = valuesCriteriaAnd;
		this.criteriasOrderBy = criteriasOrderBy;
		this.asc = asc;
	}

	/**
	 * @param criteriasAnd
	 * @param typesAnd
	 * @param valuesCriteriaAnd
	 * @param criteriasOrderBy
	 * @param asc
	 */
	public Criteria(String[] criteriasAnd, CriteriaTypeEnum[] typesAnd,
			Object[] valuesCriteriaAnd, String[] criteriasOrderBy, boolean[] asc) {
		super();
		this.criteriasAnd = criteriasAnd;
		this.typesAnd = typesAnd;
		this.valuesCriteriaAnd = valuesCriteriaAnd;
		this.criteriasOrderBy = criteriasOrderBy;
		this.asc = asc;
	}

	/**
	 * @param criteriasAnd
	 * @param typesAnd
	 * @param valuesCriteriaAnd
	 */
	public Criteria(String[] criteriasAnd, CriteriaTypeEnum[] typesAnd,
			Object[] valuesCriteriaAnd) {
		super();
		this.criteriasAnd = criteriasAnd;
		this.typesAnd = typesAnd;
		this.valuesCriteriaAnd = valuesCriteriaAnd;
	}

	/**
	 * @return the criteriasOr
	 */
	public String[] getCriteriasOr() {
		return criteriasOr;
	}

	/**
	 * @param criteriasOr
	 *            the criteriasOr to set
	 */
	public void setCriteriasOr(String[] criteriasOr) {
		this.criteriasOr = criteriasOr;
	}

	/**
	 * @return the typesOr
	 */
	public CriteriaTypeEnum[] getTypesOr() {
		return typesOr;
	}

	/**
	 * @param typesOr
	 *            the typesOr to set
	 */
	public void setTypesOr(CriteriaTypeEnum[] typesOr) {
		this.typesOr = typesOr;
	}

	/**
	 * @return the valuesCriteriaOr
	 */
	public Object[] getValuesCriteriaOr() {
		return valuesCriteriaOr;
	}

	/**
	 * @param valuesCriteriaOr
	 *            the valuesCriteriaOr to set
	 */
	public void setValuesCriteriaOr(Object[] valuesCriteriaOr) {
		this.valuesCriteriaOr = valuesCriteriaOr;
	}

	/**
	 * @return the criteriasAnd
	 */
	public String[] getCriteriasAnd() {
		return criteriasAnd;
	}

	/**
	 * @param criteriasAnd
	 *            the criteriasAnd to set
	 */
	public void setCriteriasAnd(String[] criteriasAnd) {
		this.criteriasAnd = criteriasAnd;
	}

	/**
	 * @return the typesAnd
	 */
	public CriteriaTypeEnum[] getTypesAnd() {
		return typesAnd;
	}

	/**
	 * @param typesAnd
	 *            the typesAnd to set
	 */
	public void setTypesAnd(CriteriaTypeEnum[] typesAnd) {
		this.typesAnd = typesAnd;
	}

	/**
	 * @return the valuesCriteriaAnd
	 */
	public Object[] getValuesCriteriaAnd() {
		return valuesCriteriaAnd;
	}

	/**
	 * @param valuesCriteriaAnd
	 *            the valuesCriteriaAnd to set
	 */
	public void setValuesCriteriaAnd(Object[] valuesCriteriaAnd) {
		this.valuesCriteriaAnd = valuesCriteriaAnd;
	}

	/**
	 * @return the criteriasOrderBy
	 */
	public String[] getCriteriasOrderBy() {
		return criteriasOrderBy;
	}

	/**
	 * @param criteriasOrderBy
	 *            the criteriasOrderBy to set
	 */
	public void setCriteriasOrderBy(String[] criteriasOrderBy) {
		this.criteriasOrderBy = criteriasOrderBy;
	}

	/**
	 * @return the asc
	 */
	public boolean[] getAsc() {
		return asc;
	}

	/**
	 * @param asc
	 *            the asc to set
	 */
	public void setAsc(boolean[] asc) {
		this.asc = asc;
	}

	public StringBuffer getQuery() {
		return query;
	}

	public void setQuery(StringBuffer query) {
		this.query = query;
	}

	public List<Object> getParameters() {
		return parameters;
	}

	public void setParameters(List<Object> parameters) {
		this.parameters = parameters;
	}

	public StringBuffer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(StringBuffer orderBy) {
		this.orderBy = orderBy;
	}
}