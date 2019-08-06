package br.com.infraestrutura.numero;

public class VerificadorNumerico {

	public static void verificarSeValorNumerico(String numero)  throws NumberFormatException {
		if (numero == null || numero.isEmpty()) {
			throw new NumberFormatException();
		}
		int i = 0;
		if (numero.charAt(0) == '-') {
			if (numero.length() > 1) {
				i++;
			} else {
				throw new NumberFormatException();
			}
		}
		for (; i < numero.length(); i++) {
			if (!Character.isDigit(numero.charAt(i))) {
				throw new NumberFormatException();
			}
		}
	}

}
