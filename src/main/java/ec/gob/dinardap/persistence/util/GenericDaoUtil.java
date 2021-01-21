/**
 * 
 */
package ec.gob.dinardap.persistence.util;

import java.util.List;

import ec.gob.dinardap.persistence.constante.CriteriaTypeEnum;

/**
 * @author 
 * 
 */
public class GenericDaoUtil {

	public static void buildQueryCriteria(StringBuffer hql,
			List<Object> parameters, String[] criteriasOr,
			CriteriaTypeEnum[] typesOr, Object[] valuesCriteriaOr,
			String[] criteriasAnd, CriteriaTypeEnum[] typesAnd,
			Object[] valuesCriteriaAnd, String[] criteriasOrderBy,
			boolean[] asc, String innerJoinObject, String innerJoinProperty,
			Object innerJoinValue, CriteriaTypeEnum innerJoinOperator) {

		int totalCriteriasOr = 0;
		/*if (criteriasOr == null) {
			hql.append(" 1=1 ");
		} else {
			totalCriteriasOr = criteriasOr.length;
		}*/
		
		if(criteriasOr != null) {
			totalCriteriasOr = criteriasOr.length;
			hql.append("where (");

			for (int i = 0; i < totalCriteriasOr; i++) {
	
				if (valuesCriteriaOr[i] == null) {
					if (!typesOr[i].equals(CriteriaTypeEnum.STRING_IS_NULL)
							&& !typesOr[i].equals(CriteriaTypeEnum.LONG_IS_NULL)) {
						continue;
					}
				}
	
				if (typesOr[i].equals(CriteriaTypeEnum.STRING_LIKE)) {
					String textSearch = valuesCriteriaOr[i].toString()
							.toLowerCase();
					hql.append("lower(obj." + criteriasOr[i] + ") like '%"
							+ textSearch + "%'");
				}
				if (typesOr[i].equals(CriteriaTypeEnum.STRING_STARTS_WITH)) {
					String textSearch = valuesCriteriaOr[i].toString()
							.toLowerCase();
					hql.append("lower(obj." + criteriasOr[i] + ") like '"
							+ textSearch + "%'");
				}
				if (typesOr[i].equals(CriteriaTypeEnum.STRING_EQUALS)) {
					hql.append("lower(obj." + criteriasOr[i] + ") = '"
							+ valuesCriteriaOr[i].toString().toLowerCase() + "'");
				}
				if (typesOr[i].equals(CriteriaTypeEnum.STRING_IS_NULL)) {
					hql.append("obj." + criteriasOr[i] + " IS NULL");
				}
				if (typesOr[i].equals(CriteriaTypeEnum.STRING_IS_NOT_NULL)) {
					hql.append("obj." + criteriasOr[i] + " IS NOT NULL");
				}
				if (typesOr[i].equals(CriteriaTypeEnum.STRING_NOT_EQUALS)) {
					hql.append("lower(obj." + criteriasOr[i] + ") != '"
							+ valuesCriteriaOr[i].toString().toLowerCase() + "'");
				}
				if (typesOr[i].equals(CriteriaTypeEnum.STRING_IN_LIST)) {
					String listString = obtainStringListForIn(valuesCriteriaOr[i]);
	
					hql.append("obj." + criteriasOr[i] + " IN (" + listString + ")");
				}
				if (typesOr[i].equals(CriteriaTypeEnum.STRING_NOT_IN_LIST)) {
					String listString = obtainStringListForIn(valuesCriteriaOr[i]);
	
					hql.append("obj." + criteriasOr[i] + " NOT IN (" + listString
							+ ")");
				}
	
				if (typesOr[i].equals(CriteriaTypeEnum.LONG_EQUALS)) {
					hql.append("obj." + criteriasOr[i] + " = "
							+ (Long) valuesCriteriaOr[i] + "");
				}
				if (typesOr[i].equals(CriteriaTypeEnum.LONG_NOT_EQUALS)) {
					hql.append("obj." + criteriasOr[i] + " != "
							+ (Long) valuesCriteriaOr[i] + "");
				}
				if (typesOr[i].equals(CriteriaTypeEnum.LONG_IS_NULL)) {
					hql.append("obj." + criteriasOr[i] + " IS NULL");
				}
				if (typesOr[i].equals(CriteriaTypeEnum.INTEGER_EQUALS)) {
					hql.append("obj." + criteriasOr[i] + " = "
							+ (Integer) valuesCriteriaOr[i] + "");
				}
				if (typesOr[i].equals(CriteriaTypeEnum.INTEGER_NOT_EQUALS)) {
					hql.append("obj." + criteriasOr[i] + " != "
							+ (Integer) valuesCriteriaOr[i] + "");
				}
				if (typesOr[i].equals(CriteriaTypeEnum.SHORT_EQUALS)) {
					hql.append("obj." + criteriasOr[i] + " = "
							+ (Short) valuesCriteriaOr[i] + "");
				}
				if (typesOr[i].equals(CriteriaTypeEnum.SHORT_NOT_EQUALS)) {
					hql.append("obj." + criteriasOr[i] + " != "
							+ (Short) valuesCriteriaOr[i] + "");
				}
				if (typesOr[i].equals(CriteriaTypeEnum.DOUBLE_EQUALS)) {
					hql.append("obj." + criteriasOr[i] + " = "
							+ (Double) valuesCriteriaOr[i] + "");
				}
				if (typesOr[i].equals(CriteriaTypeEnum.DOUBLE_NOT_EQUALS)) {
					hql.append("obj." + criteriasOr[i] + " != "
							+ (Double) valuesCriteriaOr[i] + "");
				}
				if (typesOr[i].equals(CriteriaTypeEnum.BOOLEAN_POSTGRESQL)) {
					hql.append("obj." + criteriasOr[i] + " = "
							+ Boolean.parseBoolean(valuesCriteriaOr[i].toString())
							+ "");
				}
				if (typesOr[i].equals(CriteriaTypeEnum.DATE_BETWEEN)) {
					hql.append("obj." + criteriasOr[i] + " between ?1 and ?2 ");
					DateBetween dateBetween = (DateBetween) valuesCriteriaOr[i];
					parameters.add(dateBetween.getFrom());
					parameters.add(dateBetween.getTo());
	
				}
				if ((i + 1) != totalCriteriasOr) {
					hql.append(" or ");
				}
			}
		}
		//hql.append(") ");

		// AND
		int totalCriteriasAnd = 0;
		boolean flag = true;
		/*if (criteriasAnd == null) {
			hql.append(" and 1=1 ");
		} else {
			totalCriteriasAnd = criteriasAnd.length;
		}*/

		if(criteriasAnd != null) {
			totalCriteriasAnd = criteriasAnd.length;
			if(totalCriteriasOr == 0) {
				hql.append("where ");
				flag = false;
			}else
				hql.append(") ");
			
			for (int i = 0; i < totalCriteriasAnd; i++) {
	
				if (valuesCriteriaAnd[i] == null) {
					if (!typesAnd[i].equals(CriteriaTypeEnum.STRING_IS_NULL)
							&& !typesAnd[i].equals(CriteriaTypeEnum.LONG_IS_NULL)) {
						continue;
					}
				}
	
				if(flag)
					hql.append(" and ");
				
				if (typesAnd[i].equals(CriteriaTypeEnum.STRING_LIKE)) {
					String textSearch = valuesCriteriaAnd[i].toString()
							.toLowerCase();
					hql.append("lower(obj." + criteriasAnd[i] + ") like '%"
							+ textSearch + "%'");
				}
				if (typesAnd[i].equals(CriteriaTypeEnum.STRING_STARTS_WITH)) {
					String textSearch = valuesCriteriaAnd[i].toString()
							.toLowerCase();
					hql.append("lower(obj." + criteriasAnd[i] + ") like '"
							+ textSearch + "%'");
				}
				if (typesAnd[i].equals(CriteriaTypeEnum.STRING_EQUALS)) {
					hql.append("lower(obj." + criteriasAnd[i] + ") = '"
							+ valuesCriteriaAnd[i].toString().toLowerCase() + "'");
				}
				if (typesAnd[i].equals(CriteriaTypeEnum.STRING_NOT_EQUALS)) {
					hql.append("lower(obj." + criteriasAnd[i] + ") != '"
							+ valuesCriteriaAnd[i].toString().toLowerCase() + "'");
				}
				if (typesAnd[i].equals(CriteriaTypeEnum.STRING_IS_NULL)) {
					hql.append("obj." + criteriasAnd[i] + " IS NULL");
				}
				if (typesAnd[i].equals(CriteriaTypeEnum.STRING_IS_NOT_NULL)) {
					hql.append("obj." + criteriasAnd[i] + " IS NOT NULL");
				}
				if (typesAnd[i].equals(CriteriaTypeEnum.STRING_IN_LIST)) {
					String listString = obtainStringListForIn(valuesCriteriaAnd[i]);
	
					hql.append("obj." + criteriasAnd[i] + " IN (" + listString
							+ ")");
				}
				if (typesAnd[i].equals(CriteriaTypeEnum.STRING_NOT_IN_LIST)) {
					String listString = obtainStringListForIn(valuesCriteriaAnd[i]);
	
					hql.append("obj." + criteriasAnd[i] + " NOT IN (" + listString
							+ ")");
				}
	
				if (typesAnd[i].equals(CriteriaTypeEnum.LONG_EQUALS)) {
					hql.append("obj." + criteriasAnd[i] + " = "
							+ (Long) valuesCriteriaAnd[i] + "");
				}
				if (typesAnd[i].equals(CriteriaTypeEnum.LONG_NOT_EQUALS)) {
					hql.append("obj." + criteriasAnd[i] + " != "
							+ (Long) valuesCriteriaAnd[i] + "");
				}
				if (typesAnd[i].equals(CriteriaTypeEnum.LONG_IS_NULL)) {
					hql.append("obj." + criteriasAnd[i] + " IS NULL");
				}
				if (typesAnd[i].equals(CriteriaTypeEnum.INTEGER_EQUALS)) {
					hql.append("obj." + criteriasAnd[i] + " = "
							+ (Integer) valuesCriteriaAnd[i] + "");
				}
				if (typesAnd[i].equals(CriteriaTypeEnum.INTEGER_NOT_EQUALS)) {
					hql.append("obj." + criteriasAnd[i] + " != "
							+ (Integer) valuesCriteriaAnd[i] + "");
				}
				if (typesAnd[i].equals(CriteriaTypeEnum.SHORT_EQUALS)) {
					hql.append("obj." + criteriasAnd[i] + " = "
							+ (Short) valuesCriteriaAnd[i] + "");
				}
				if (typesAnd[i].equals(CriteriaTypeEnum.SHORT_NOT_EQUALS)) {
					hql.append("obj." + criteriasAnd[i] + " != "
							+ (Short) valuesCriteriaAnd[i] + "");
				}
				if (typesAnd[i].equals(CriteriaTypeEnum.DOUBLE_EQUALS)) {
					hql.append("obj." + criteriasAnd[i] + " = "
							+ (Double) valuesCriteriaAnd[i] + "");
				}
				if (typesAnd[i].equals(CriteriaTypeEnum.DOUBLE_NOT_EQUALS)) {
					hql.append("obj." + criteriasAnd[i] + " != "
							+ (Double) valuesCriteriaAnd[i] + "");
				}
				if (typesAnd[i].equals(CriteriaTypeEnum.BOOLEAN_POSTGRESQL)) {
					hql.append("obj." + criteriasAnd[i] + " = "
							+ Boolean.parseBoolean(valuesCriteriaAnd[i].toString())
							+ "");
				}
				if (typesAnd[i].equals(CriteriaTypeEnum.DATE_BETWEEN)) {
					hql.append("obj." + criteriasAnd[i] + " between ?1 and ?2 ");
					DateBetween dateBetween = (DateBetween) valuesCriteriaAnd[i];
					parameters.add(dateBetween.getFrom());
					parameters.add(dateBetween.getTo());
	
				}
				flag = true;
			}
		}

		// inner join
		if (innerJoinObject != null) {
			hql.append(" and " + innerJoinObject + "." + innerJoinProperty);

			if (null == innerJoinOperator
					|| innerJoinOperator.equals(CriteriaTypeEnum.STRING_EQUALS)) {
				hql.append(" ='" + innerJoinValue + "'");
			} else {
				if (innerJoinOperator.equals(CriteriaTypeEnum.STRING_IN_LIST)) {
					String listString = obtainStringListForIn(innerJoinValue);
					hql.append(" IN (" + listString + ")");
				} else if (innerJoinOperator
						.equals(CriteriaTypeEnum.STRING_NOT_IN_LIST)) {
					String listString = obtainStringListForIn(innerJoinValue);
					hql.append(" NOT IN (" + listString + ")");
				}
			}
		}

		// ORDER BY

		if (criteriasOrderBy != null) {
			int totalCriteriasOrderBy = criteriasOrderBy.length;

			hql.append(" order by");
			for (int i = 0; i < totalCriteriasOrderBy; i++) {
				hql.append(" obj." + criteriasOrderBy[i]);
				if (asc[i] == false) {
					hql.append(" desc");
				}
				if ((i + 1) != totalCriteriasOrderBy) {
					hql.append(",");
				}
			}
		}
	}

	/**
	 * Se quitan los corchetes ubicados en la primera y ultima posicion del
	 * arreglo enviado.
	 * 
	 * @param param
	 * @return
	 */
	private static String obtainStringListForIn(Object param) {
		String resp = "";
		if (param instanceof List<?>) {
			String listString = param.toString();

			// Se quitan los corchetes
			listString = listString.substring(1, listString.length() - 1);

			resp = listString;
		} else if (param instanceof String) {
			resp = (String) param;
		}

		return resp;
	}
}
