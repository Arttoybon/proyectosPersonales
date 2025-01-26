package logica;

import java.util.Arrays;
import java.util.Scanner;

import animaciones.Animacion;
import minigames.MiniGAhorcado;
import minigames.MiniGsimonDice;

public class Funciones {
	// varaibles para el metodo crecer
	private static Integer edad = 0;
	private static Boolean ejecutar = true;

	/**
	 * Método que hace crecer a la mascota, espera un día apra uamenar el contador
	 * 
	 * @return
	 */
	public static int crecer() {

		if (ejecutar) { // Verificamos si ya se está ejecutando

			new Thread(() -> {
				try {
					Thread.sleep(86400000); // Espera 1 dia
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt(); // Manejar la interrupción
				}
				edad++; // Incrementar el valor

			}).start();
		}

		return edad; // Retornar el valor actual, que aún no se ha incrementado
	}
	
	public static void detener() {
		ejecutar = false;
	}

	/**
	 * Metodo que ejecuta los minijuegos
	 * 
	 * @param sc
	 * @return monedas totales
	 */
	public static long miniJuegos(Scanner sc) {
		long monedasMg = 0;
		int opcion = 0;

		do {

			menuMiniGames();// muestro el menu
			opcion = sc.nextInt();// espero respuesta del usuario
			switch (opcion) {
			case 1:
				monedasMg += MiniGAhorcado.ahorcado(sc);
				break;
			case 2:
				monedasMg += MiniGsimonDice.simonDice(sc);
				break;
			case 3:
				break;

			default:// si la respuesta es inesperada mostar en consola el siguiente mensaje y
					// esperar intro
				System.out.println("\u001B[31m Juego no encotrado, porfaavor selecione uno del menú\u001B[0m");
				intro(sc);
				break;
			}

		} while (opcion != 3);
		System.out.println("Has ganado " + monedasMg + " monedas");
		
		return monedasMg;
	}

	/**
	 * Ménu de los minijuegos
	 */
	public static void menuMiniGames() {
		System.out.println("1. Ahorcado");
		System.out.println("2. Simon dice");
		System.out.println("3. Salir");
	}

	/**
	 * Metodo que espera el intro del usuario, asi controlo que el usuario vea los
	 * resultados en pantalla y no se vuelva a imprimir el menú directamente
	 *
	 * @param sc
	 */
	public static void intro(Scanner sc) {
		sc.nextLine();
		System.out.println("Pulse intro para continuar");
		sc.nextLine();
	}

	/**
	 * Método que rellena la teinda
	 * 
	 * @param tienda
	 * @return
	 */
	public static String[][] nuevaTienda(String[][] tienda) {

		// Llenar la matriz con emojis y precios
		tienda[0][0] = "\uD83D\uDCDD"; // 📝
		tienda[0][1] = "1000";
		tienda[1][0] = "\uD83D\uDCD8"; // 📘
		tienda[1][1] = "2000";
		tienda[2][0] = "\uD83D\uDEA9"; // 🚩
		tienda[2][1] = "3000";
		tienda[3][0] = "🌹"; // 🌹
		tienda[3][1] = "4000";
		tienda[4][0] = "🍓"; // 🍓
		tienda[4][1] = "5000";
		tienda[5][0] = "\uD83D\uDC96"; // 💖
		tienda[5][1] = "60000";
		tienda[6][0] = "\uD83C\uDF88"; // 🎈
		tienda[6][1] = "70000";
		tienda[7][0] = "🎩"; // 🎩
		tienda[7][1] = "80000";
		tienda[8][0] = "🎁"; // 🎁
		tienda[8][1] = "90000";
		tienda[9][0] = "\uD83D\uDC8E"; // 💎
		tienda[9][1] = "150000";
		tienda[10][0] = "🎒"; // 🎒
		tienda[10][1] = "5000";

		return tienda;
	}

	/**
	 * Método que recoge el objeto selecionado por el usuario y lo añade a su
	 * almacen de objetos
	 * 
	 * @param tienda
	 * @param sc
	 * @param objetos
	 * @param monedas
	 * @return objetos
	 */
	public static String[] comprar(String[][] tienda, Scanner sc, String[] objetos, long monedas) {
		int producto = 0;
		boolean comprar = true;
		do {
			// muestro al usuario la tienda
			Animacion.limpiarConsola();
			for (int i = 0; i < tienda.length; i++) {
				System.out.println(i + "ª Producto: " + tienda[i][0] + " | Precio: " + tienda[i][1]);
				System.out.println();
			}
			// pregunto al usuario que produco va a selecionar
			System.out.println("\u001B[34mIntrodice -1 para salir\u001B[0m");
			System.out.print("\u001B[34mSelecione un objeto:\u001B[0m");
			producto = sc.nextInt();
			// salir de la tienda al poner -1
			if (producto == -1) {
				comprar = false;// el usuario no ha comprado nada
				break;
			}

		} while (noComprar(tienda, producto, monedas));// compreubo si el usuario puede compara lo que ha selecionado

		if (comprar) {// si el usuario ha comprado
			objetos = Arrays.copyOf(objetos, objetos.length + 1);// agarnda la lista de objetos del usuarios
			objetos[objetos.length - 1] = tienda[producto][0];// guarda el producto selecionado
		}

		return objetos;
	}

	/**
	 * Metodo que define si el objeto se puede comprobara si la seleción no está
	 * feura de rango, si no lo tiene y si tiene suficientes monedas el usuario
	 * 
	 * @param tienda
	 * @param producto
	 * @param monedas
	 * @return
	 */
	public static boolean noComprar(String[][] tienda, int producto, long monedas) {
		boolean compra = true;

		if (producto < 11 && producto > -1) {// compruebo que no esté fuera de rango
			String precioO = tienda[producto][1];
			if (precioO != "Obtenido") {// compreubo que no lo haya comprado previamente el usuario
				int precioP = traducirPrecio(precioO);
				if (precioP <= monedas) {// compurebo si el usuario tiene para coprarlo
					compra = false;
				}
			}

		}
		return compra;
	}

	/**
	 * Método que resta las monedas y cambia el valor a obtenido
	 * 
	 * @param tienda
	 * @param objetos
	 * @param monedas
	 * @return
	 */
	public static long monedasTT(String[][] tienda, String[] objetos, long monedas) {
		String obj = objetos[objetos.length - 1], producto;
		for (int i = 0; i < tienda.length; i++) {
			producto = tienda[i][0];
			if (producto.equals(obj)) {
				monedas = monedas - traducirPrecio(tienda[i][1]);
				tienda[i][1] = "Obtenido";
				break;
			}
		}
		return monedas;
	}

	/**
	 * Comvierte una cadena de caracteres a números enteros
	 * 
	 * @param precio
	 * @return núemro entero
	 */
	public static int traducirPrecio(String precio) {
		int precioP = 0;
		char dig = ' ';

		for (int i = 0; i < precio.length(); i++) {
			dig = precio.charAt(i);
			switch (dig) {
			case 48:
				if (i == precio.length() - 1) {
					precioP = (precioP * 10);
				} else {
					precioP = (precioP * 10) + 0;
				}

				break;
			case 49:
				precioP = (precioP * 10) + 1;
				break;
			case 50:
				precioP = (precioP * 10) + 2;
				break;
			case 51:
				precioP = (precioP * 10) + 3;
				break;
			case 52:
				precioP = (precioP * 10) + 4;
				break;
			case 53:
				precioP = (precioP * 10) + 5;
				break;
			case 54:
				precioP = (precioP * 10) + 6;
				break;
			case 55:
				precioP = (precioP * 10) + 7;
				break;
			case 56:
				precioP = (precioP * 10) + 8;
				break;
			case 57:
				precioP = (precioP * 10) + 9;
				break;
			}
		}

		return precioP;
	}

	/**
	 * Según la etapa de vida recibes un correo
	 * 
	 * @param edad
	 * @return
	 */
	public static long correo(int edad) {
		long economia = 0;
		switch (edad) {
		case 5:
			economia = 500;
			break;
		case 15:
			economia = 1500;
			break;
		case 20:
			economia = 2000;
			break;
		}
		return economia;
	}

	/**
	 * Método apra abrir el cofre
	 * 
	 * @param sc
	 * @return
	 */
	public static int abrirCofre(Scanner sc) {
		int recompensa = 0, combincion = 2725, conmUsu = 0;

		do {
			Animacion.cerraCofre();// muestro al usuario el cofre cerrado
			System.out.println("\u001B[34mIntrodice 0000 para salir\u001B[0m");// pido al usuario la conbinación
			System.out.println("\u001B[34mPista la conbinación no cotiene 0\u001B[0m");
			System.out.print("\u001B[34m \n Introdice la combinación de 4 carcateres:\u001B[0m");
			conmUsu = sc.nextInt();

			if (conmUsu == 0000) {// el usuario no quiere abrir el cofre
				break;
			}
		} while (conmUsu != combincion);
		if (conmUsu == combincion) {// si el usuario adivina la combinación
			Animacion.abrirCofre();// muestro el cofre abreindose
			recompensa = 900000;// doy recompensa al usuario
		}

		return recompensa;
	}

	/**
	 * Método que muestra la seleción de cosas que puede hacer el usuario con su
	 * mascota, si la mascota necesita algo urgente se meustra de color rojo y si
	 * recibe un correo de color azul
	 * 
	 * @param economia
	 * @param energia
	 * @param felicidad
	 * @param hambre
	 * @param sucio
	 */
	public static void menu(Long economia, int energia, int felicidad, int hambre, boolean sucio) {
		String destacado;
		System.out.println("¿Qué quieres hacer?");
		destacado = (hambre < 0) ? "\u001B[31m1.  Alimentar\u001B[0m" : "1.  Alimentar";
		System.out.println(destacado);
		destacado = (felicidad < 0) ? "\u001B[31m2.  Jugar\u001B[0m" : "2.  Jugar";
		System.out.println(destacado);
		destacado = (energia < 0) ? "\u001B[31m3.  Dormir\u001B[0m" : "3.  Dormir";
		System.out.println(destacado);
		destacado = (sucio) ? "\u001B[31m4.  Limpiar\u001B[0m" : "4.  Limpiar";
		System.out.println(destacado);
		System.out.println("5.  Ver mascota");
		destacado = (economia != 0) ? "\u001B[34m6.  Correo\u001B[0m" : "6.  Correo";
		System.out.println(destacado);
		System.out.println("7.  Contraseña secreta");
		System.out.println("8.  Tienda");
		System.out.println("9.  Equipar un objeto");
		System.out.println("10. Salir");
	}

	/**
	 * Ensucia a la mascota si esta se encuentra muy cansada
	 * 
	 * @param energia
	 * @param sucio
	 * @return
	 */
	public static boolean ensuciar(int energia, boolean sucio) {

		if (energia < 3) {
			sucio = true;
		}

		return sucio;
	}

	/**
	 * Método encarado de selecioanr la mascota
	 * 
	 * @param mascotas
	 * @param selecionado
	 * @param sc
	 * @return
	 */
	public static String selecionaMascota(String[] mascotas, String selecionado, Scanner sc) {
		char opcion = ' ';

		do {

			for (int i = 0; i < mascotas.length; i++) {
				System.out.println(i + ") " + mascotas[i]);
			}

			System.out.println("¿Cúal va a ser tu mascota?");
			opcion = sc.next().charAt(0);
		} while (validarSelecion(opcion));

		selecionado = mascotas[traductor(opcion)];

		return selecionado;
	}

	/**
	 * Método qué comprueba que la seleción no sea una letra
	 * 
	 * @param ms
	 * @return
	 */
	public static boolean validarSelecion(char ms) {
		int unicod = ms;
		boolean noEix = true;
		if (Character.isLetter(ms)) {
		} else if (unicod > 47 && unicod < 56) {
			noEix = false;
		}
		return noEix;
	}

	/**
	 * Método ue traduce un char a un número
	 * 
	 * @param ms
	 * @return
	 */
	public static int traductor(char ms) {
		int unicod = ms, n = 0;
		switch (unicod) {
		case 48:
			n = 0;
			break;
		case 49:
			n = 1;
			break;
		case 50:
			n = 2;
			break;
		case 51:
			n = 3;
			break;
		case 52:
			n = 4;
			break;
		case 53:
			n = 5;
			break;
		case 54:
			n = 6;
			break;
		case 55:
			n = 7;
			break;

		}
		return n;
	}

	/**
	 * Metodo que muestra que tanta hambre tiene la mascota al usuario
	 * 
	 * @param hambre
	 * @return
	 */
	public static String hambre(int hambre) {
		String estHabre = "esta satisfecho";

		if (hambre < 5) {
			estHabre = "esta hambreinto";
		} else if (hambre < 8) {
			estHabre = "algo hambreinto";
		}

		return estHabre;
	}

	/**
	 * Método que meustra en la etapa de la vida que se encutra la mascota
	 * 
	 * @param edad
	 * @return
	 */
	public static String etapaVida(int edad) {
		String etapa = "adulto";

		if (edad < 5) {
			etapa = "huevo";
		} else if (edad < 15) {
			etapa = "niño";
		} else if (edad < 20) {
			etapa = "adolescente";
		}

		return etapa;
	}

	/**
	 * Método que muestra ale usuario el estado de animo de la mascota
	 * 
	 * @param feli
	 * @return
	 */
	public static String estadoAnimo(int feli) {
		String animo = "feliz";

		if (feli < 5) {
			animo = "triste";
		} else if (feli < 8) {
			animo = "algo triste";
		}

		return animo;
	}

	/**
	 * Método paramostrar al usuario como de canasado esta la mascota
	 * 
	 * @param energia
	 * @return
	 */
	public static String lvlEnergia(int energia) {
		String lvl = "esta descansado";

		if (energia < 5) {
			lvl = "esta cansado";
		} else if (energia < 8) {
			lvl = "algo cansado";
		}

		return lvl;
	}

	/**
	 * Metodo usado en mostrarEstado para depedneideo de sucio mostrar la palra
	 * limpio o sucio
	 * 
	 * @param sucio
	 * @return
	 */
	public static String higiene(boolean sucio) {
		String higi = "limpio";

		if (sucio) {
			higi = "sucio";
		}

		return higi;
	}

	/**
	 * Método que muestra el estado de la mascota
	 * 
	 * @param nombre
	 * @param edad
	 * @param felicidad
	 * @param energia
	 * @param hambre
	 * @param sucio
	 * @param monedas
	 */
	public static void mostrarEstado(String nombre, int edad, int felicidad, int energia, int hambre, boolean sucio,
			long monedas) {
		System.out.println("\n" + nombre + " es un " + etapaVida(edad) + " se encuentra:");
		System.out.println(estadoAnimo(felicidad));
		System.out.println(higiene(sucio));
		System.out.println(hambre(hambre));
		System.out.println(lvlEnergia(energia));
		System.out.println("Saldo: " + monedas);
	}

	/**
	 * Método que le perimete equipar un objeto al tamagochi
	 * 
	 * @param objetos
	 * @param objeto
	 * @param sc
	 * @return
	 */
	public static String eqObjeto(String[] objetos, String objeto, Scanner sc) {
		int select = 0;

		do {
			for (int i = 0; i < objetos.length; i++) {
				System.out.println(i + "º" + objetos[i]);
			}
			System.out.println("\u001B[34mIntrodice -1 para salir\u001B[0m");
			System.out.print("\u001B[34mSelecione un objeto:\u001B[0m");
			select = sc.nextInt();
			if (select == -1) {
				break;
			}
		} while (select < 0 || select > objetos.length - 1);

		objeto = objetos[select];

		return objeto;
	}

	/**
	 * Metoodo que resta o incrementa la salud dependidendo de los parametros
	 * 
	 * @param hambre
	 * @param feliz
	 * @param salud
	 * @return salud
	 */
	public static int salud(int hambre, int feliz, int salud) {

		if (feliz <= 0) {
			salud--;
		}
		if (hambre <= 0) {
			salud--;
		}
		if (feliz > 0 && hambre > 0 && salud < 100) {
			salud++;
		}
		return salud;
	}

	/**
	 * Método que pone a dormir a la mascota si esta tiene sueño, si no tiene sueño
	 * la mascota dice no
	 * 
	 * @param objetoE
	 * @param energia
	 * @return
	 */
	public static int dormir(String objetoE, int energia) {
		if (energia == 10) {
			Animacion.no(objetoE);
		} else {
			energia = 10;
			Animacion.dormir(objetoE);
		}
		return energia;
	}

	/**
	 * Método que baña a la mascota, si no está sucia esta dice que no le hace falta
	 * un baño
	 * 
	 * @param objetoE
	 * @param sucio
	 * @return
	 */
	public static boolean bañar(String objetoE, boolean sucio) {
		if (sucio) {
			sucio = false;
			Animacion.bañar(objetoE);
		} else {
			Animacion.no(objetoE);
		}
		return sucio;
	}

	/**
	 * Método da de comer a la mascota y si esta no tien hhambre dice que no
	 * 
	 * @param objetoE
	 * @param hambre
	 * @return
	 */
	public static int alimentar(String objetoE, int hambre) {
		if (hambre == 10) {
			Animacion.no(objetoE);
		} else {
			Animacion.comer();
			hambre++;
		}
		return hambre;
	}
}
