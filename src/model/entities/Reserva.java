package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		
	}
	
	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duracao() {
		long d = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(d, TimeUnit.MILLISECONDS);
	}
	
	public String atualizaData(Date checkIn, Date checkOut) {
		Date agora = new Date();
		if(checkIn.before(agora) || checkOut.before(agora)) {
			return "Erro: So pode usar uma data futura";
		}else if(!checkOut.after(checkIn)) {
			return "Erro: O check-Out não pode ser antes do check-In";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	
	@Override
	public String toString() {
		return "Número do quarto: "
				+ numeroQuarto
				+ ", Check-In: "
				+ sdf.format(checkIn)
				+ ", Check-Out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duracao()
				+ " Dias";
	}


	
}
