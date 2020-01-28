package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exception.DomainException;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.print("Numero do quarto: ");
			int numero = sc.nextInt();
			System.out.print("Cleck-In (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Cleck-Out (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			System.out.println();
			System.out.print("Cleck-In (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Cleck-Out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
	
			reserva.atualizaData(checkIn, checkOut);
			System.out.print(reserva);
		}
		catch(ParseException e) {
			System.out.println("Formato de data invalido!");
		}
		catch(DomainException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		sc.close();
	}

}
