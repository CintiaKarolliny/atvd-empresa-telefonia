package telefonia;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Recarga {
	private Date data;
	private float valor;
	
	public Recarga(Date data, float valor){
		this.data = data;
		this.valor = valor;
		
	}

	public Date getData() {
		return data;
	}

	public float getValor() {
		return valor;
	}

	public String toString() {
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		return "* Recarga: data: " + dataFormatada.format(data) + ", valor: " + valor;
	}

}
