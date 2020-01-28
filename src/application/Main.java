package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Numero do quarto: ");
		int numero = sc.nextInt();
		System.out.print("Cleck-In (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Cleck-Out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro: O check-Out não pode ser antes do check-In");
		} else {
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			System.out.println();
			System.out.print("Cleck-In (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Cleck-Out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			String erro = reserva.atualizaData(checkIn, checkOut);
			if(erro != null) {
				System.out.println("Erro: " + erro);
			}else {
				System.out.print(reserva);
			}
			
			

		}

		sc.close();
	}

}
