/**
 * 
 */
package ec.gob.dinardap.util;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ec.gob.dinardap.persistence.exception.ValidarExpresionException;

/**
 * @author 
 *
 */
public class ExpresionRegularUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1077865647766029611L;

	/**
	 * 
	 */
	public ExpresionRegularUtil() {
		
	}
	
	
	/**
	 * @param input
	 * @throws ValidarExpresionException
	 */
	public static void validarEmail(String input) throws ValidarExpresionException {

		Pattern p = Pattern.compile("^\\.|^\\@|^\\www");
		Matcher m = p.matcher(input);
		if (m.find()) {
			throw new ValidarExpresionException(input +  ", no puede empezar con . @ www");
		}

		p = Pattern.compile("\\@");
		m = p.matcher(input);
		if (!m.find())
			throw new ValidarExpresionException(input +  ", no contiene @");

		// comprueba que no contenga caracteres prohibidos
		p = Pattern.compile("[^A-Za-z0-9\\-\\.\\@_\\-~#]+");
		m = p.matcher(input);
		StringBuffer sb = new StringBuffer();
		boolean resultado = m.find();
		boolean caracteresIlegales = false;

		while (resultado) {
			caracteresIlegales = true;
			m.appendReplacement(sb, "");
			resultado = m.find();
		}

		// AÒade el ultimo segmento de la entrada a la cadena
		m.appendTail(sb);

		input = sb.toString();

		if (caracteresIlegales) {
			throw new ValidarExpresionException(input +  ", contiene caracteres invalidos");
		}

	}
	
	/**
	 * @param input
	 * @throws ValidarExpresionException
	 */
	public static void validarSoloLetrasRayaBaja(String input)
			throws ValidarExpresionException {

		Pattern p = Pattern.compile("^([a-zA-ZñÑáéíóúÁÉÍÓÚ_])*$");
		Matcher m = p.matcher(input);
		if (!m.find()) {
			throw new ValidarExpresionException(
					"La cadena debe tener solo letras, raya baja, y no caracteres especiales.");
		}

	}
	
	
	/**
	 * @param input
	 * @throws ValidarExpresionException
	 */
	public static void validarSoloLetrasEspacio(String input)
			throws ValidarExpresionException {

		Pattern p = Pattern.compile("^([a-zA-ZñÑáéíóúÁÉÍÓÚ ])*$");
		Matcher m = p.matcher(input);
		if (!m.find()) {
			throw new ValidarExpresionException(
					"La cadena debe tener solo letras y espacio en blanco no caracteres especiales.");
		}

	}
	
	/**
	 * @param input
	 * @throws ValidarExpresionException
	 */
	public static void validarUrl(String input)
			throws ValidarExpresionException {
		Pattern p = Pattern.compile("^http(s)?://[a-z0-9-]+(.[a-z0-9-]+)*(:[0-9]+)?(/.*)?$");
		Matcher m = p.matcher(input);
		if (!m.find()) {
			throw new ValidarExpresionException(
					"No es un formato de URL valido.");
		}

	}
	
	/**
	 * @param input
	 * @throws ValidarExpresionException
	 */
	public static void validarSoloLetrasNumeros(String input)
			throws ValidarExpresionException {

		Pattern p = Pattern.compile("^([a-zA-ZñÑáéíóúÁÉÍÓÚ0-9])*$");
		Matcher m = p.matcher(input);
		if (!m.find()) {
			throw new ValidarExpresionException(
					"La cadena debe tener solo letras, números.");
		}

	}
	
	/**
	 * @param input
	 * @throws ValidarExpresionException
	 */
	public static void validarSoloNumeros(String input)
			throws ValidarExpresionException {

		Pattern p = Pattern.compile("^([0-9])*$");
		Matcher m = p.matcher(input);
		if (!m.find()) {
			throw new ValidarExpresionException(
					"La cadena debe tener solo numeros, no espacios.");
		}

	}

}
