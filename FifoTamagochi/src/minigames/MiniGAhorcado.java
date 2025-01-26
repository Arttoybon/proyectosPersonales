package minigames;

import java.util.Arrays;
import java.util.Scanner;

import animaciones.Animacion;

public class MiniGAhorcado {
	/**
	 * Metodo de juego
	 * 
	 */
	public static long ahorcado(Scanner sc) {
		//varaibles que voy a usar
		char letra=' ';
		boolean ganador=false;
		String palabraAdivinar="";
		int intentos =0, indiceP=0;
		long premio=0;
		String[] palabras = {
			    "manzana", "pera", "uva", "fresa", "mango", "sandía", "durazno", "ciruela", "piña", "cereza",
			    "libro", "lápiz", "bolígrafo", "cuaderno", "hoja", "mesa", "silla", "sofá", "lámpara", "espejo",
			    "carro", "bicicleta", "camión", "tren", "avión", "barco", "moto", "patineta", "cohete", "helicóptero",
			    "perro", "gato", "pájaro", "pez", "caballo", "vaca", "oveja", "cerdo", "conejo", "ratón",
			    "rojo", "azul", "verde", "amarillo", "negro", "blanco", "naranja", "rosado", "morado", "marrón",
			    "feliz", "triste", "enojado", "emocionado", "cansado", "aburrido", "asustado", "nervioso", "tranquilo", "relajado",
			    "correr", "caminar", "saltar", "bailar", "cantar", "leer", "escribir", "dibujar", "pintar", "jugar",
			    "casa", "departamento", "cocina", "dormitorio", "baño", "jardín", "garaje", "sala", "techo", "puerta",
			    "computadora", "teléfono", "teclado", "pantalla", "ratón", "impresora", "cámara", "parlante", "micrófono", "reloj"
			};
		
		do {
			indiceP = (int)(Math.random() * palabras.length);//seleciona la palabra
			palabraAdivinar = palabras[indiceP];// la guardo 
			intentos = palabraAdivinar.length();// defino los intentos
			//creo una lista de caracteres y guardo en ella cada unode los caracteres de la 
			//palabra
			char palabraJ1[] = new char[palabraAdivinar.length()];
			palabraJ1=palabraAdivinar.toCharArray();
			
			//creo una lista de caracteres y la relleno de _
			char palabraJ2[] = new char[palabraAdivinar.length()];
			Arrays.fill(palabraJ2, '_');
			
			//bucle que se repite mientras el jugador B tenga intentos
			do {
				
				dibujarMono(intentos);
				//muestro la lista del jugador B
				imprimirAhorcado(palabraJ2);
				
				//Pido al jugador B el caracter
				System.out.println("\n Jugador B introduce una letra");
				letra = sc.next().toLowerCase().charAt(0);
				
				//gruardo la lista modificada
				palabraJ2 = modPalabaraj2(letra, palabraJ1, palabraJ2);
				
				if (coincidencia(letra, palabraJ1, palabraJ2)) {//si no encuentro la letra en array de jugadorA resto intentos
					intentos--;
				}
				
				//comparo las 2 listas y si son iguales
				if(Arrays.equals(palabraJ1, palabraJ2)) {
					//intentos igual a 0
					intentos=0;
					//cambio el valor de la variable bandera
					ganador=true;
					premio = 500;
					//muestro la lista del jugador B
					imprimirAhorcado(palabraJ2);
					//salto de linea
					System.out.println();
				}	
				
				Animacion.limpiarConsola();
				
			} while (intentos!=0);
			
			//Muestro quein ha ganado
			mostarGanador(ganador);
			
			
			do {//pregunto al usuario si quiere volver a jugar
				System.out.println();
				System.out.println("¿Desea jugar otra vez (s/n)?");
				letra = sc.next().toLowerCase().charAt(0);
			}while(letra!='s'&&letra!='n');

			
		}while(letra!='n');

		return premio;
	}
	
	
	
	/**
	 * Muestra en consola el mensaje para el ganador
	 * 
	 * @param ganador
	 */
	public static void mostarGanador(boolean ganador) {
		if (ganador) {
			System.out.println("Felicidades Jugador  has ganado");
		}else {
			System.out.println("Jugador haz perdido");
		}
	}
	
	/**
	 * Muestra en la consola la lista del jugador B
	 * 
	 * @param palabraJ2
	 */
	public static void imprimirAhorcado(char palabraJ2[]) {
		for (int i = 0; i < palabraJ2.length; i++) {
			System.out.print(palabraJ2[i]+" ");
			
		}
	}
	
	/**
	 * Metodo que busca la letra en la palabraJ1 y si la encuentra la alamcena en 
	 * al misma posicón que la encontro pero en plabraJ2
	 * 
	 * @param letra a buscar
	 * @param palabraJ1 lista de la palabra de jugador A
	 * @param palabraJ2 lista de la palabra de jugador B
	 * @return lista palabraJ2 modificada
	 */
	public static char[] modPalabaraj2(char letra,char palabraJ1[], char palabraJ2[]) {
		
		for (int i = 0; i < palabraJ1.length; i++) {
			if(palabraJ1[i]==letra) {
				palabraJ2[i]=letra;
			}
		}
		return palabraJ2;
	}
	public static boolean coincidencia(char letra,char palabraJ1[], char palabraJ2[]) {
		boolean siEsta= true;
			for (int i = 0; i < palabraJ1.length; i++) {
				if(palabraJ1[i]==letra) {
					siEsta=false;
				}
			}
			return siEsta;
		}

	/**
	 * Mtodo que muestra el muñeco según el nº de intentos
	 * 
	 * @param intentos
	 */
	public static void dibujarMono(int intentos) {
		String c="\\";
		
		switch (intentos) {
		case 9:
	        System.out.println("       ");
	        System.out.println("       ");
	        System.out.println(" ");
	        System.out.println(" ");
	        System.out.println(" ");
	        System.out.println(" ");
	        System.out.println(" ");
	        System.out.println("==========");
			break;
		case 8:
	        System.out.println("       ");
	        System.out.println("|      ");
	        System.out.println("|");
	        System.out.println("|");
	        System.out.println("|");
	        System.out.println("|");
	        System.out.println("|");
	        System.out.println("==========");
			break;
		case 7:
	        System.out.println("_________");
	        System.out.println("|/      ");
	        System.out.println("|");
	        System.out.println("|");
	        System.out.println("|");
	        System.out.println("|");
	        System.out.println("|");
	        System.out.println("==========");
			break;
		
		case 6:
			
	        System.out.println("_________");
	        System.out.println("|/      |");
	        System.out.println("|       ");
	        System.out.println("|");
	        System.out.println("|");
	        System.out.println("|");
	        System.out.println("|");
	        System.out.println("==========");
	        
	        break;
		case 5:
			
	        System.out.println("_________");
	        System.out.println("|/      |");
	        System.out.println("|       O");
	        System.out.println("|");
	        System.out.println("|");
	        System.out.println("|");
	        System.out.println("|");
	        System.out.println("==========");
	        
	        break;
	        
		case 4:
			
	        System.out.println("_________");
	        System.out.println("|/      |");
	        System.out.println("|       O");
	        System.out.println("|       |");
	        System.out.println("|       |");
	        System.out.println("|");
	        System.out.println("|");
	        System.out.println("==========");
	        
	        break;
	        
		case 3:
			
	        System.out.println("_________");
	        System.out.println("|/      |");
	        System.out.println("|       O");
	        System.out.println("|      /|");
	        System.out.println("|       |");
	        System.out.println("|");
	        System.out.println("|");
	        System.out.println("==========");
	        
	        break;
	        
		case 2:
			
	        System.out.println("_________");
	        System.out.println("|/      |");
	        System.out.println("|       O");
	        System.out.println("|      /|"+c);
	        System.out.println("|       |");
	        System.out.println("|");
	        System.out.println("|");
	        System.out.println("==========");
	        
	        break;
		case 1:
			
	        System.out.println("_________");
	        System.out.println("|/      |");
	        System.out.println("|       O");
	        System.out.println("|      /|"+c);
	        System.out.println("|       |");
	        System.out.println("|      /");
	        System.out.println("|");
	        System.out.println("==========");
	        
	        break;
		case 0:
			
	        System.out.println("_________");
	        System.out.println("|/      |");
	        System.out.println("|       O");
	        System.out.println("|      /|"+c);
	        System.out.println("|       |");
	        System.out.println("|      / "+c);
	        System.out.println("|");
	        System.out.println("==========");
	        
	        break;
	        
		}
	        
		
	}
}
