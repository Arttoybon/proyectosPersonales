package minigames;

import java.util.Arrays;

import java.util.Scanner;

import animaciones.Animacion;

public class MiniGsimonDice {

	public static long simonDice(Scanner sc) {
		long premio = 0;
		int inetntos =10;
		String listaSecuencia []= {
				"a:a:a:a",
				"s:s:s:s",
				"d:d:d:d",
				"w:w:w:w",
				"a:s:d:w",
				"d:s:a:w",
				"w:s:d:a",
				"s:w:d:a",
				"a:w:d:s"
		};
		sc.nextLine();
		do {
			Animacion.limpiarConsola();
			String secuencia= listaSecuencia[(int)(Math.random() * listaSecuencia.length)];
			String seAleatoria []= secuencia.split(":");
			String caracUsu=" ";
			for (String caract : seAleatoria) {
				System.out.print(caract+" ");
				Animacion.espera(500);
			}
			Animacion.espera(900);
			Animacion.limpiarConsola();
			System.out.println("\u001B[34mIntroduce numeros para salir\u001B[0m");
			System.out.println("\u001B[34m¿Cual era la secuencia de caracteres?\u001B[0m");
			caracUsu = sc.nextLine();
			
			String seUsus [] = caracUsu.split(" ");
			
			if(contieneNumero(seUsus)) {
				break;
			}else {
				if (Arrays.equals(seAleatoria, seUsus)) {
					premio +=50;
				}else {
					Animacion.limpiarConsola();
					inetntos--;
					System.out.println("Te quedan "+inetntos+" intentos");
					System.out.println("La secuencia era ");
					for (String caract : seAleatoria) {
						System.out.print(caract+" ");
						Animacion.espera(500);
					}
					Animacion.espera(900);
				}
			}

		} while (inetntos!=0);
		

		
		return premio;
	}
	
	/**
	 * Métodos que compueba si el array tiene números
	 * 
	 * @param seUsu
	 * @return true/false
	 */
	public static boolean contieneNumero(String seUsu[]) {
		boolean numero=true;
		String se="";
		for (String c : seUsu) {
			se += c;
		}
		
		char[] scu = se.toCharArray();
		for (char c : scu ) {
			if(Character.isDigit(c)) {
				numero=true;
				break;
			}else {
				numero=false;
			}
		}
		
		return numero;
	}

	
	
}
