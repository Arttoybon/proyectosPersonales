package logica;

import java.util.Scanner;

import animaciones.Animacion;

public class Tamagochi {

	public static void miMascota() {
		String nombre = "unknown", tipoMascota = "unknown";
		int energia = 5, felicidad = 5, hambre = 5, edad = 0, salud = 100, opciones = 0, tamañoAlma=0;
		long monedas = 1000, premio, cofre = 0;
		String objetoE = "\u2728";
		boolean sucio = false;
		// energia 0(cansado) 10(descansado)
		// felicidad 0(triste) 10(feliz)
		// hambre 0(hambriento) 10(satisfecho)
		// sucio true(sucio) false(limpio)
		// edad 0(huevo) 5(niño) 15(adolenceste) 20(adulto)
		String[] mascotas = { "Perro", "Gato", "Elefante", "León", "Tigre", "Jirafa", "Oso", "Conejo" };

		String[][] tienda = new String[11][2];
		tienda = Funciones.nuevaTienda(tienda);
		String[] objetos = new String[1];
		objetos[0] = objetoE;

		Scanner sc = new Scanner(System.in);

		tipoMascota = Funciones.selecionaMascota(mascotas, tipoMascota, sc);//el usuario seleciona que tipo de mascota va a tener
		System.out.println("¿Nombre para tu " + tipoMascota + "?"); //le pone nombre a la mascota
		nombre = sc.next();

		do {
			tamañoAlma = objetos.length;//guardo el tamaño del almacen
			premio = 0;//reseteo premio
			salud = Funciones.salud(hambre, felicidad, salud);//miro si le resto salud a la mascota
			edad = Funciones.crecer();//actualizo la edad de la mascota
			if (!sucio) {//si la ascota no esta sucia
				sucio = Funciones.ensuciar(energia, sucio);//compruebo si se puede ensuciar
			}
			premio = Funciones.correo(edad);//compruebo si tengo un correo
			do {
				Funciones.menu(premio, energia, felicidad, hambre, sucio);//muestro al menu al usuario
				opciones = sc.nextInt();//espero a que el usuario selecione
				switch (opciones) {// depende de laseleción
				case 1:
					hambre = Funciones.alimentar(objetoE, hambre);//alimento a la mascota

					break;
				case 2:
					if (felicidad == 10) {//si ya esta contento 
						Animacion.no(objetoE);//mascota dice no
					} else {//si
						monedas += Funciones.miniJuegos(sc);//juega
						felicidad++;//actualizo valores
						energia--;
						hambre--;
						System.out.println("Saldo actual:"+monedas);
						Funciones.intro(sc);
					}

					break;
				case 3:
					energia = Funciones.dormir(objetoE, energia);//duerme la mascota
					felicidad--;//resto felicidad
					break;
				case 4:
					sucio = Funciones.bañar(objetoE, sucio);//bañaa la mascota
					felicidad--;//resto felicidad
					break;
				case 5:
					Funciones.mostrarEstado(nombre, edad, felicidad, energia, hambre, sucio, monedas);//muesro todo sobre la mascota
					Funciones.intro(sc);
					break;
				case 6:
					if (premio != 0) {//si premio es !=0, es decir hay un correo
						monedas += premio;// sumo el valor del correo a las onedas del usuario
						System.out.println("Felicidades has recibido " + premio + " monedas");// mensaje de cuanto es el correo
						Funciones.intro(sc);
					} else {
						Animacion.no(objetoE);// animación no hay correo
					}
					break;
				case 7:
					if (cofre == 0) { // si no  ha recibido la recompensa de cofre
						cofre = Funciones.abrirCofre(sc);//intenta abrir cofre
						monedas += cofre;
					} else {
						Animacion.no(objetoE);// si ya lo ha recibido, decir no
					}

					break;
				case 8:
					objetos = Funciones.comprar(tienda, sc, objetos, monedas);// añado el nuevo obejto a e array que almacena todos los objetos
					//si no ha comprado el tamaño del array no varia
					if(tamañoAlma!=objetos.length) {//compruebo si ha comprado
						monedas = Funciones.monedasTT(tienda, objetos, monedas);// resto lo que ha costado el objetoss
						objetoE = objetos[tamañoAlma-1];//equipo el objeto recién comprado
					}
					break;
				case 9:
					objetoE = Funciones.eqObjeto(objetos, objetoE, sc);//equipo un objeto
					break;
				case 10:
					Funciones.detener();
					break;
				}

			} while (opciones < 1 || opciones > 10);

		} while (opciones!=10);

		sc.close();

		System.out.println("bye");
	}

}
