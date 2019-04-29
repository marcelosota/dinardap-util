package ec.gob.dinardap.util.constante;

public enum EstadoEnum {
	INACTIVO((short) 0), ACTIVO((short) 1);
	
	private Short estado;
	
	private EstadoEnum(Short estado) {
		this.estado = estado;
	}

	public Short getEstado() {
		return estado;
	}

	public static EstadoEnum obtenerEstadoPorCodigo(Short estado) {
		EstadoEnum valor = null;
		for (EstadoEnum e : EstadoEnum.values()) {
			if (e.getEstado() == estado) {
				valor = e;
				break;
			}
		}
		return valor;
	}
}
