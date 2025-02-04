package animaciones;

public class Animacion {
/**
 * 
 * Método que muestra  a la mascota diciendo que no
 * @param objetoE
 */
	public static void no(String objetoE) {
		int i = 0;
		limpiarConsola();
		// Fotogramas de la animación
		String[] frames = { "   (\\_/)   \n" + "  (•_• )   \n" + "  / > " + objetoE + "   \n",

				"   (\\_/)   \n" + "  ( •_•)   \n" + "  / > " + objetoE + "   \n",

				"   (\\_/)   \n" + "  (•_• )   \n" + "  / > " + objetoE + "   \n",

				"   (\\_/)   \n" + "  ( •_•)   \n" + "  / > " + objetoE + "   \n" };

		while (i < frames.length) {
			for (String frame : frames) {
				System.out.println(frame);
				espera(500);
				limpiarConsola();
				i++;
			}
		}
	}
/**
 * Método que muestra a la mascota bañandose
 * 
 * @param objetoE
 */
	public static void bañar(String objetoE) {
		int i = 0;
		limpiarConsola();
		// Fotogramas de la animación
		String[] frames = { "       @@@@@                                     \n"
				+ "     @@@@  @@@@@@@@@@                            \n"
				+ "    @@@    @@@    @@@                            \n"
				+ "    @@%    @@@   @@@                             \n"
				+ "    @@%    @@  @@@ 							\n" + "    @@%    #@@@@#    						\n"
				+ "    @@%     -@#:								\n" + "    @@%      	     						\n"
				+ "    @@%		         (\\_/)	                    \n" + "    @@%		        ( -_- )  			\n"
				+ " %@@@@%++:=%@@@@@@@@@@@ / >" + objetoE + " @@@@@%*+=..+++:=\n"
				+ " @@@%%%%#*:+%%%%%%%%%%%%%%%%%%%%%#==.-=*...=:+%@ \n"
				+ "@@@=:::::+++-::::::::::::::::::::-=++:.-+-+==#@@@\n"
				+ " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%+-++::*@@@@ \n"
				+ "   @@#=--------------------------------====#@@   \n"
				+ "   @@*.....................................*@@   \n"
				+ "   @@*.....................................*@@   \n"
				+ "   @@#.....................................#@@   \n"
				+ "   @@@+...................................=@@@   \n"
				+ "    @@@%:...............................:%@@@    \n"
				+ "      @@@@@%#########################%@@@@@     \n"
				+ "         @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@         \n" + "         @@@@			    @@@@         \n"
				+ "         @@			      @@         \n",
				"       @@@@@                                     \n"
						+ "     @@@@  @@@@@@@@@@                            \n"
						+ "    @@@    @@@    @@@                            \n"
						+ "    @@%    @@@   @@@                             \n"
						+ "    @@%    @@  @@@* *%: 							\n"
						+ "    @@%    #@@@@#-:    						\n"
						+ "    @@%     -@#:								\n"
						+ "    @@%      	     						\n"
						+ "    @@%		         (\\_/)	                    \n"
						+ "    @@%		        ( •_• )  			\n" + " %@@@@%++:=%@@@@@@@@@@@ / >" + objetoE
						+ " @@@@@%*+=..+++:=\n" + " @@@%%%%#*:+%%%%%%%%%%%%%%%%%%%%%#==.-=*...=:+%@ \n"
						+ "@@@=:::::+++-::::::::::::::::::::-=++:.-+-+==#@@@\n"
						+ " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%+-++::*@@@@ \n"
						+ "   @@#=--------------------------------====#@@   \n"
						+ "   @@*.....................................*@@   \n"
						+ "   @@*.....................................*@@   \n"
						+ "   @@#.....................................#@@   \n"
						+ "   @@@+...................................=@@@   \n"
						+ "    @@@%:...............................:%@@@    \n"
						+ "      @@@@@%#########################%@@@@@     \n"
						+ "         @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@         \n"
						+ "         @@@@			    @@@@         \n" + "         @@			      @@         \n",
				"       @@@@@                                     \n"
						+ "     @@@@  @@@@@@@@@@                            \n"
						+ "    @@@    @@@    @@@                            \n"
						+ "    @@%    @@@   @@@                             \n"
						+ "    @@%    @@  @@@* *%: 							\n"
						+ "    @@%    #@@@@#-:    +*:						\n"
						+ "    @@%     -@#:								\n"
						+ "    @@%      	:*-:     						\n"
						+ "    @@%		         (\\_/)	                    \n"
						+ "    @@%		        ( -◡- )  			\n" + " %@@@@%++:=%@@@@@@@@@@@ / >" + objetoE
						+ " @@@@@%*+=..+++:=\n" + " @@@%%%%#*:+%%%%%%%%%%%%%%%%%%%%%#==.-=*...=:+%@ \n"
						+ "@@@=:::::+++-::::::::::::::::::::-=++:.-+-+==#@@@\n"
						+ " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%+-++::*@@@@ \n"
						+ "   @@#=--------------------------------====#@@   \n"
						+ "   @@*.....................................*@@   \n"
						+ "   @@*.....................................*@@   \n"
						+ "   @@#.....................................#@@   \n"
						+ "   @@@+...................................=@@@   \n"
						+ "    @@@%:...............................:%@@@    \n"
						+ "      @@@@@%#########################%@@@@@     \n"
						+ "         @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@         \n"
						+ "         @@@@			    @@@@         \n" + "         @@			      @@         \n",
				"       @@@@@                                     \n"
						+ "     @@@@  @@@@@@@@@@                            \n"
						+ "    @@@    @@@    @@@                            \n"
						+ "    @@%    @@@   @@@                             \n"
						+ "    @@%    @@  @@@* *%: 							\n"
						+ "    @@%    #@@@@#-:    +*:						\n"
						+ "    @@%     -@#:		@+.:						\n"
						+ "    @@%      	:*-:     						\n"
						+ "    @@%		   :=.:  (\\_/)	                    \n"
						+ "    @@%		        ( •◡• )  			\n" + " %@@@@%++:=%@@@@@@@@@@@ / >" + objetoE
						+ " @@@@@%*+=..+++:=\n" + " @@@%%%%#*:+%%%%%%%%%%%%%%%%%%%%%#==.-=*...=:+%@ \n"
						+ "@@@=:::::+++-::::::::::::::::::::-=++:.-+-+==#@@@\n"
						+ " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%+-++::*@@@@ \n"
						+ "   @@#=--------------------------------====#@@   \n"
						+ "   @@*.....................................*@@   \n"
						+ "   @@*.....................................*@@   \n"
						+ "   @@#.....................................#@@   \n"
						+ "   @@@+...................................=@@@   \n"
						+ "    @@@%:...............................:%@@@    \n"
						+ "      @@@@@%#########################%@@@@@     \n"
						+ "         @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@         \n"
						+ "         @@@@			    @@@@         \n" + "         @@			      @@         \n"

		};
		while (i < frames.length) {
			for (String frame : frames) {
				System.out.println(frame);
				espera(500);
				limpiarConsola();
				i++;
			}
		}
	}
/**
 * Método que muestra a la mascota durmiendo
 * 
 * @param objetoE
 */
	public static void dormir(String objetoE) {
		int i = 0;
		limpiarConsola();
		// Fotogramas de la animación
		String[] frames = { "   (\\_/)   \n" + "  ( •◡• )  \n" + "  / >" + objetoE + "    \n",

				"   (\\_/)   \n" + "  ( -◡- )  \n" + "  / >" + objetoE + "    \n",
				"	z	 \n" + "   (\\_/)   \n" + "  ( -◡- )  \n" + "  / >" + objetoE + "    \n",
				"	   z  \n" + "	z	 \n" + "   (\\_/)   \n" + "  ( -◡- )  \n" + "  / >" + objetoE + "    \n",
				"	z	 \n" + "   (\\_/)   \n" + "  ( -◡- )  \n" + "  / >" + objetoE + "    \n",
				"   (\\_/)   \n" + "  ( -◡- )  \n" + "  / >" + objetoE + "    \n",
				"   (\\_/)   \n" + "  ( •◡• )  \n" + "  / >" + objetoE + "    \n" };
		while (i < frames.length) {
			for (String frame : frames) {
				System.out.println(frame);
				espera(500);
				limpiarConsola();
				i++;
			}
		}
	}
	/**
	 * Método que muestra a la mascota comiendo
	 */
	public static void comer() {
		int i = 0;
		limpiarConsola();
		String[] frames = { "   (\\_/)   \n" + "  ( •◡• )  \n" + "  / >🍎    \n",

				"   (\\_/)   \n" + "  ( •o• )  \n" + "  / >🍎    \n",

				"   (\\_/)   \n" + "  ( •◡• )  \n" + "  / >      \n" };

		while (i < frames.length) {
			for (String frame : frames) {
				System.out.println(frame);
				espera(500);
				limpiarConsola();
				i++;
			}
		}
	}

	/**
	 * Método que muestra el cofre abriendose
	 */
	public static void abrirCofre() {
		limpiarConsola();
		System.out.println("      ..................................       \n"
				+ "      ..-+****+++++++++++++++++++++++++++++-..    \n"
				+ "      .:=++++++++++++++++++++++++++++++++++=-.    \n"
				+ "      .-====================================-.    \n"
				+ "       .-+********************************+-..    \n"
				+ "      .::-=::-===========++============::==::.    \n"
				+ "      .::--:-=+++++++++------=+++++++++-:--::.    \n"
				+ "       ::-==+++++++++++--++--=++++++++++==--:.    \n"
				+ "       ::=+++++++++++++=----=++++++++++++++:..    \n"
				+ "       .-=+++++++++++++++==+++++++++++++++=:..    \n"
				+ "       .-=++++++++++++++++++++++++++++++++-:..    \n"
				+ "       .--++++++++++++++++++++++++++++++++-:..    \n"
				+ "       .--++++++++++++++++++++++++++++++++-:      \n"
				+ "       .:-----++++++++++++++++++++++++=----:      \n"
				+ "       .:-=+--=+++++++++++++++++++++++--++-:      \n"
				+ "   .....:----------------------------------:..... \n"
				+ "   .............................................. \n"
				+ "         ...... ...... .....   .. .....  ..   ");
		espera(500);
		limpiarConsola();
		System.out.println("      ..................................       \n"
				+ "      ..-+****+++++++++++++++++++++++++++++-..    \n"
				+ "      .:=++++++++++++++++++++++++++++++++++=-.    \n"
				+ "      .-====================================-.    \n"
				+ "       .-+********************************+-..    \n"
				+ "       ..:+******************************+:.      \n"
				+ "      .::-=::-===========++============::==::.    \n"
				+ "      .::--:-=+++++++++------=+++++++++-:--::.    \n"
				+ "       ::-==+++++++++++--++--=++++++++++==--:.    \n"
				+ "       ::=+++++++++++++=----=++++++++++++++:..    \n"
				+ "       .-=+++++++++++++++==+++++++++++++++=:..    \n"
				+ "       .-=++++++++++++++++++++++++++++++++-:..    \n"
				+ "       .--++++++++++++++++++++++++++++++++-:..    \n"
				+ "       .--++++++++++++++++++++++++++++++++-:      \n"
				+ "       .:-----++++++++++++++++++++++++=----:      \n"
				+ "       .:-=+--=+++++++++++++++++++++++--++-:      \n"
				+ "   .....:----------------------------------:..... \n"
				+ "   .............................................. \n"
				+ "         ...... ...... .....   .. .....  ..   ");
		espera(500);
		limpiarConsola();
		System.out.println("      ..................................       \n"
				+ "      ..-+****+++++++++++++++++++++++++++++-..    \n"
				+ "      .:=++++++++++++++++++++++++++++++++++=-.    \n"
				+ "      .-====================================-.    \n"
				+ "       .-+********************************+-..    \n"
				+ "       ..:+******************************+:.      \n"
				+ "         ..-***************************+-..       \n"
				+ "      .::-=::-===========++============::==::.    \n"
				+ "      .::--:-=+++++++++------=+++++++++-:--::.    \n"
				+ "       ::-==+++++++++++--++--=++++++++++==--:.    \n"
				+ "       ::=+++++++++++++=----=++++++++++++++:..    \n"
				+ "       .-=+++++++++++++++==+++++++++++++++=:..    \n"
				+ "       .-=++++++++++++++++++++++++++++++++-:..    \n"
				+ "       .--++++++++++++++++++++++++++++++++-:..    \n"
				+ "       .--++++++++++++++++++++++++++++++++-:      \n"
				+ "       .:-----++++++++++++++++++++++++=----:      \n"
				+ "       .:-=+--=+++++++++++++++++++++++--++-:      \n"
				+ "   .....:----------------------------------:..... \n"
				+ "   .............................................. \n"
				+ "         ...... ...... .....   .. .....  ..   ");
		espera(500);
		limpiarConsola();
		System.out.println("      ..................................       \n"
				+ "      ..-+****+++++++++++++++++++++++++++++-..    \n"
				+ "      .:=++++++++++++++++++++++++++++++++++=-.    \n"
				+ "      .-====================================-.    \n"
				+ "       .-+********************************+-..    \n"
				+ "       ..:+******************************+:.      \n"
				+ "         ..-***************************+-..       \n"
				+ "          ..:+************************+...        \n"
				+ "      .::-=::-===========++============::==::.    \n"
				+ "      .::--:-=+++++++++------=+++++++++-:--::.    \n"
				+ "       ::-==+++++++++++--++--=++++++++++==--:.    \n"
				+ "       ::=+++++++++++++=----=++++++++++++++:..    \n"
				+ "       .-=+++++++++++++++==+++++++++++++++=:..    \n"
				+ "       .-=++++++++++++++++++++++++++++++++-:..    \n"
				+ "       .--++++++++++++++++++++++++++++++++-:..    \n"
				+ "       .--++++++++++++++++++++++++++++++++-:      \n"
				+ "       .:-----++++++++++++++++++++++++=----:      \n"
				+ "       .:-=+--=+++++++++++++++++++++++--++-:      \n"
				+ "   .....:----------------------------------:..... \n"
				+ "   .............................................. \n"
				+ "         ...... ...... .....   .. .....  ..   ");
		espera(500);
		limpiarConsola();
		System.out.println("      ..................................       \n"
				+ "      ..-+****+++++++++++++++++++++++++++++-..    \n"
				+ "      .:=++++++++++++++++++++++++++++++++++=-.    \n"
				+ "      .-====================================-.    \n"
				+ "       .-+********************************+-..    \n"
				+ "       ..:+******************************+:.      \n"
				+ "         ..-***************************+-..       \n"
				+ "          ..:+************************+...        \n"
				+ "         ...:=************************=:...       \n"
				+ "       ..:+******************************+-...    \n"
				+ "      .:------------------------------------:.    \n"
				+ "      .::-=::-===========++============::==::.    \n"
				+ "      .::--:-=+++++++++------=+++++++++-:--::.    \n"
				+ "       ::-==+++++++++++--++--=++++++++++==--:.    \n"
				+ "       ::=+++++++++++++=----=++++++++++++++:..    \n"
				+ "       .-=+++++++++++++++==+++++++++++++++=:..    \n"
				+ "       .-=++++++++++++++++++++++++++++++++-:..    \n"
				+ "       .--++++++++++++++++++++++++++++++++-:..    \n"
				+ "       .--++++++++++++++++++++++++++++++++-:      \n"
				+ "       .:-----++++++++++++++++++++++++=----:      \n"
				+ "       .:-=+--=+++++++++++++++++++++++--++-:      \n"
				+ "   .....:----------------------------------:..... \n"
				+ "   .............................................. \n"
				+ "         ...... ...... .....   .. .....  ..   ");
		limpiarConsola();

	}
	/**
	 * Metodo uestra el cofre cerrado
	 * 
	 */
	public static void cerraCofre() {
		limpiarConsola();
		System.out.println("      ..................................       \n"
				+ "      ..-+****+++++++++++++++++++++++++++++-..    \n"
				+ "      .:=++++++++++++++++++++++++++++++++++=-.    \n"
				+ "      .-====================================-.    \n"
				+ "      .::-=::-===========++============::==::.    \n"
				+ "      .::--:-=+++++++++------=+++++++++-:--::.    \n"
				+ "       ::-==+++++++++++--++--=++++++++++==--:.    \n"
				+ "       ::=+++++++++++++=----=++++++++++++++:..    \n"
				+ "       .-=+++++++++++++++==+++++++++++++++=:..    \n"
				+ "       .-=++++++++++++++++++++++++++++++++-:..    \n"
				+ "       .--++++++++++++++++++++++++++++++++-:..    \n"
				+ "       .--++++++++++++++++++++++++++++++++-:      \n"
				+ "       .:-----++++++++++++++++++++++++=----:      \n"
				+ "       .:-=+--=+++++++++++++++++++++++--++-:      \n"
				+ "   .....:----------------------------------:..... \n"
				+ "   .............................................. \n"
				+ "         ...... ...... .....   .. .....  ..   ");
	}
	/**
	 * Metodo que espera mils
	 * 
	 * @param mils
	 */
	public static void espera(int mils) {
		try {
			Thread.sleep(mils);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que limpia la consola
	 */
	public static void limpiarConsola() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}

}
