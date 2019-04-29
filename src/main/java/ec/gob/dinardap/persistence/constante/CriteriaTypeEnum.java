/* 
 * CriteriaTypeEnum.java
 * Jan 12, 2010 
 * Copyright 2010 Saviasoft Cia. Ltda. 
 */
package ec.gob.dinardap.persistence.constante;

/**
 * @author Daniel Cardenas
 * 
 */
public enum CriteriaTypeEnum {

	/* texto */
	STRING_LIKE, STRING_STARTS_WITH, STRING_EQUALS, STRING_NOT_EQUALS, STRING_IS_NULL, STRING_IS_NOT_NULL, STRING_IN_LIST, STRING_NOT_IN_LIST,
	/*
	 * STRING_POSTGRES_ASCII sirve para buscar indiferentemente con tildes o sin
	 * tildes
	 */
	// STRING_LIKE_POSTGRES_ASCII,
	/* numericos */
	LONG_EQUALS, LONG_NOT_EQUALS, LONG_IS_NULL, INTEGER_EQUALS, INTEGER_NOT_EQUALS, DOUBLE_EQUALS, DOUBLE_NOT_EQUALS, SHORT_EQUALS, SHORT_NOT_EQUALS,
	/* booelan */
	BOOLEAN_POSTGRESQL,
	/* fecha */
	DATE_BETWEEN;
}