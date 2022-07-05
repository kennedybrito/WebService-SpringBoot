package com.brito.kennedy.entities.enums;

public enum StatusPedido {
	
	Pago (1),
	Aguardando_Pagamento(2),
	Enviado(3),
	Entregue(4),
	Cancelado(5);

	private int code;
	
	private StatusPedido(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static StatusPedido valueOf(int code) {
		for (StatusPedido value : StatusPedido.values()){
			if (value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("codigo do status invalido");
	}
}
