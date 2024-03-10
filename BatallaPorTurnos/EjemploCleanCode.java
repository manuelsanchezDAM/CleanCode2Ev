/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package junit.batallaporturnos;

import java.util.Scanner;

/**
 *
 * @author alumnom
 */
public class EjemploCleanCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner Batalla = new Scanner(System.in);
        System.out.println("Batalla por turnos mediante Texto: Pulsa s o S para empezar");
        //Declaracion de Variables
        String confirmacion;
        String ataque;
        int incrementoDefinitiva;
        int reinicioHabilidadDefinitiva;
        int desgastePuntosDeMagia;
        int ataqueMagico_Jugador;
        //Excepcion try-catch-finally para Pruebas
        try {
            // Intenta realizar algunas operaciones con Estadistica
            Estadistica jugador = new Estadistica(-50, 30, 10);
            System.out.println("Estadísticas del jugador: " + jugador);
            // Intenta usar Vacío Purpura
            Estadistica enemigo = new Estadistica(200, 0, 10);
            jugador.usaVacioPurpura(enemigo);
        } catch (IllegalArgumentException e) {
            //Captura la excepción del constructor
            System.err.println("Error en la creación de estadísticas: " + e.getMessage());
        } catch (IllegalStateException e) {
            //Captura la excepción del ataque Vacío Purpura
            System.err.println("Error al usar Vacío Purpura: " + e.getMessage());
        } finally {
            // Bloque finally
            System.out.println("Fin del programa");
        }
        //Comprobacion de Contorno
        do{
            confirmacion = Batalla.nextLine();
            if( !("s".equalsIgnoreCase(confirmacion)) ){   
                System.out.println("*Reinicio del juego al no pulsar s o S*\nBatalla por turnos mediante Texto: Pulsa s o S para empezar");
            }    
        }while( !("s".equalsIgnoreCase(confirmacion)) );
        //Info Batalla
        System.out.println("... Batalla Cargada");
        Estadistica Jugador = new Estadistica(1000,200,10);
        System.out.println("Tus estadisticas:\n " + "\b" + Jugador);
        Estadistica Enemigo = new Estadistica(1900,10000,20);
        System.out.println("Las estadisticas de tu enemigo:\n" + "\b" + Enemigo);
        System.out.println("Se necesita un 100 en el medidor de Habilidad incrementoDefinitiva para activarla pero el Enemigo tambien puede activar la suya por lo cual ten cuidado");
        System.out.println("Si tus PS llegan a 0 o menos GAME OVER,si los de tu enemigo llegan a 0 o menos Ganas la Batalla");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Empieza la Batalla:");          
        //Codigo de la Batalla
        while(Enemigo.getPuntosDeVida() != Estadistica.getVacio()){    
            if( Jugador.getPuntosDeVida() == Estadistica.getVacio()){    
                System.out.println("GAME OVER");
                break;
            }
            System.out.println("Elige un Ataque:\n" + "\b" + "Golpes Normales,Vacio Purpura(Consume 40PM),Golpes Serios Serios Serie Consecutiva"
            + "(Habilidad incrementoDefinitiva solo se puede usar cuando el Medidor de esta misma llegue a 100).");
            ataque = Batalla.nextLine();
            //Condicion para el ataque fisico
            if( ataque.equals("Golpes Normales") ){
                int ataqueJugador = Jugador.usaGolpesNormales(Enemigo);
                incrementoDefinitiva = Enemigo.aumentaMedidorHabilidadDefinitiva(Enemigo);
                Enemigo.setPuntosDeVida(ataqueJugador);
                Enemigo.setMedidorHabilidadDefinitiva(incrementoDefinitiva);
                System.out.println("Estadisticas Actuales del Enemigo: "+Enemigo);
                if(Enemigo.getPuntosDeVida() == Estadistica.getVacio()){
                        System.out.println("Has ganado la batalla");
                        break;
                    }else{
                        System.out.println("El enemigo Contrataca");
                        int ataqueEnemigo = Enemigo.usaGolpesNormales(Jugador);
                        incrementoDefinitiva = Jugador.aumentaMedidorHabilidadDefinitiva(Jugador);
                        Jugador.setPuntosDeVida(ataqueEnemigo);
                        Jugador.setMedidorHabilidadDefinitiva(incrementoDefinitiva);
                        System.out.println("Tus estadisticas actuales:" + Jugador);
                    }
            //Condiciones para el ataque magico    
            }else if( ataque.equals("Vacio Purpura")){
                if(Jugador.getPuntosDeMagia() == Estadistica.getVacio() || Jugador.getPuntosDeMagia() < Estadistica.getDesgaste()){
                    System.out.println("No puedes usar Vacio Purpura si no te queda PM");    
                }else if(Enemigo.getPuntosDeMagia() == Estadistica.getVacio()){
                    System.out.println("Al enemigo no le queda PM para contratacar buena Jugada");
                    incrementoDefinitiva = Jugador.aumentaMedidorHabilidadDefinitiva(Jugador);
                    Jugador.setMedidorHabilidadDefinitiva(incrementoDefinitiva);
                    desgastePuntosDeMagia = Jugador.desgastePM(Jugador);
                    Jugador.setPuntosDeMagia(desgastePuntosDeMagia);
                    System.out.println("Tus estadisticas actuales:" + Jugador);
                }else if(Enemigo.getPuntosDeMagia() > Estadistica.getVacio()){    
                ataqueMagico_Jugador = Jugador.usaVacioPurpura(Enemigo);
                desgastePuntosDeMagia = Enemigo.desgastePM(Enemigo);
                incrementoDefinitiva = Enemigo.aumentaMedidorHabilidadDefinitiva(Enemigo);
                Enemigo.setPuntosDeVida(ataqueMagico_Jugador);
                Enemigo.setPuntosDeMagia(desgastePuntosDeMagia);
                Enemigo.setMedidorHabilidadDefinitiva(incrementoDefinitiva);
                System.out.println("Estadisticas Actuales del Enemigo: "+Enemigo);
                if(Enemigo.getPuntosDeVida() == Estadistica.getVacio()){
                        System.out.println("Has ganado la batalla");
                        break;
                    }else{
                        System.out.println("El enemigo Contrataca");
                        int ataqueMagico_Enemigo = Enemigo.usaVacioPurpura(Jugador);
                        desgastePuntosDeMagia = Jugador.desgastePM(Jugador);
                        incrementoDefinitiva = Jugador.aumentaMedidorHabilidadDefinitiva(Jugador);
                        Jugador.setPuntosDeVida(ataqueMagico_Enemigo);
                        Jugador.setPuntosDeMagia(desgastePuntosDeMagia);
                        Jugador.setMedidorHabilidadDefinitiva(incrementoDefinitiva);
                        System.out.println("Tus estadisticas actuales:" + Jugador);
                    }
                }
            //Condiciones para la Habilidad incrementoDefinitiva
            }else if( ataque.equals("Golpes Serios Serios Serie Consecutiva")){    
                 if(Jugador.getMedidorHabilidadDefinitiva() != Estadistica.getCapacidad()){    
                    System.out.println("No puedes usar la Habilidad incrementoDefinitiva si tu medidor no esta a 100");
                    if(Enemigo.getMedidorHabilidadDefinitiva() == Estadistica.getCapacidad()){
                        System.out.println("Aun asi El enemigo usa su Habilidad Definitiva aprovechandose de tu error");
                        int ataqueEnemigoDefinitivo = Enemigo.usaHabilidadDefinitiva(Jugador);
                        Jugador.setPuntosDeVida(ataqueEnemigoDefinitivo);
                        System.out.println("Tus estadisticas actuales:" + Jugador);
                        reinicioHabilidadDefinitiva = Enemigo.desgasteUlti(Enemigo);
                        Enemigo.setMedidorHabilidadDefinitiva(reinicioHabilidadDefinitiva);
                        System.out.println("Estadisticas Actuales del Enemigo: "+ Enemigo);
                    }    
                }
                if(Jugador.getMedidorHabilidadDefinitiva() == Estadistica.getCapacidad() & Enemigo.getMedidorHabilidadDefinitiva() != Estadistica.getCapacidad()){
                    int ataqueJugadorDefinitivo = Jugador.usaHabilidadDefinitiva(Enemigo);
                    int ReinicioUltiJ = Jugador.desgasteUlti(Jugador);
                    Enemigo.setPuntosDeVida(ataqueJugadorDefinitivo);
                    Jugador.setMedidorHabilidadDefinitiva(ReinicioUltiJ);
                    System.out.println("Estadisticas Actuales del Enemigo: "+Enemigo);
                    System.out.println("Tus estadisticas actuales:" + Jugador);           
                }    
                 if (Enemigo.getMedidorHabilidadDefinitiva() == Estadistica.getCapacidad() 
                    & Jugador.getMedidorHabilidadDefinitiva() == Estadistica.getCapacidad()){      
                     int ataqueJugadorDefinitivo = Jugador.usaHabilidadDefinitiva(Enemigo);
                     int ReinicioUltiJ = Jugador.desgasteUlti(Jugador);
                     Enemigo.setPuntosDeVida(ataqueJugadorDefinitivo);
                     Jugador.setMedidorHabilidadDefinitiva(ReinicioUltiJ);
                     System.out.println("Estadisticas Actuales del Enemigo: "+ Enemigo);
                    if(Enemigo.getPuntosDeVida() == Estadistica.getVacio()){
                        System.out.println("Has ganado la batalla");
                        break;
                    }else{
                        System.out.println("El enemigo usa su Habilidad Definitiva");
                        int ataqueEnemigoDefinitivo = Enemigo.usaHabilidadDefinitiva(Jugador);
                        Jugador.setPuntosDeVida(ataqueEnemigoDefinitivo);
                        System.out.println("Tus estadisticas actuales:" + Jugador);
                        reinicioHabilidadDefinitiva = Enemigo.desgasteUlti(Enemigo);
                        Enemigo.setMedidorHabilidadDefinitiva(reinicioHabilidadDefinitiva);
                    }    
                }           
            //Comprobacion de Contorno     
            }else{
                System.out.println("Incorrecto introduce uno de los 3 ataques mencionados");
            }
            if(Enemigo.getPuntosDeVida() == Estadistica.getVacio()){
                System.out.println("Has ganado la batalla");
                break;
            }
            
        }    
        //Impresion de pantalla usado para pruebas de esta Actividad Evaluable
        String Saludo = "Hola ¿que tal esta?";
        System.out.println(Saludo);
    }
    
}