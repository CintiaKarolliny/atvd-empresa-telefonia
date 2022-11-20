package telefonia;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Recarga {
	private Date data;
	private float valor;
	
	public Recarga(Date data, float valor){
		this.data = data;
		this.valor = valor;
		
	}
	
	public Date getDate() {
		return data;
	}
	
	public float getValor() {
		return valor;
	}
	
	public String toString() {
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		return dataFormatada.format(data) + valor;
	}
	

	public void main(String[] args) {
		Recarga teste = new Recarga(data, valor);
	}

}
