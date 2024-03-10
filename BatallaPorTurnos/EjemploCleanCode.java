/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BatallaporTurnos;

import java.util.Scanner;

/**
 *
 * @author user
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
        //Comprobacion de Contorno
        do{
            confirmacion = Batalla.nextLine();
            if( !("s".equalsIgnoreCase(confirmacion)) ){   
                System.out.println("*Reinicio del juego al no pulsar s o S*\nBatalla por turnos mediante Texto: Pulsa s o S para empezar");
            }    
        }while( !("s".equalsIgnoreCase(confirmacion)) );
        //Info Batalla
        System.out.println("... Batalla Cargada");
        Estadistica Jugador = new Estadistica(1000,200,20);
        System.out.println("Tus estadisticas:\n " + "\b" + Jugador);
        Estadistica Enemigo = new Estadistica(1900,10000,10);
        System.out.println("Las estadisticas de tu enemigo:\n" + "\b" + Enemigo);
        System.out.println("Se necesita un 100 en el medidor de Habilidad incrementoDefinitiva para activarla pero el Enemigo tambien puede activar la suya por lo cual ten cuidado");
        System.out.println("Si tus PS llegan a 0 o menos GAME OVER,si los de tu enemigo llegan a 0 o menos Ganas la Batalla");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Empieza la Batalla:");          
        //Codigo de la Batalla
        while(Enemigo.puntosDeVida > Estadistica.VACIO){    
            if( Jugador.puntosDeVida <= Estadistica.VACIO){    
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
                Enemigo.puntosDeVida = ataqueJugador;
                Enemigo.puntosDeVida = incrementoDefinitiva;
                System.out.println("Estadisticas Actuales del Enemigo: "+Enemigo);
                System.out.println("El enemigo Contrataca");
                int ataqueEnemigo = Enemigo.usaGolpesNormales(Jugador);
                incrementoDefinitiva = Jugador.aumentaMedidorHabilidadDefinitiva(Jugador);
                Jugador.puntosDeVida = ataqueEnemigo;
                Jugador.puntosDeVida = incrementoDefinitiva;
                System.out.println("Tus estadisticas actuales:" + Jugador);
            //Condiciones para el ataque magico    
            }else if( ataque.equals("Vacio Purpura")){
                if(Jugador.puntosDeMagia == Estadistica.VACIO){
                    System.out.println("No puedes usar Vacio Purpura si no te queda PM");    
                }else if(Enemigo.puntosDeMagia == Estadistica.VACIO){
                    System.out.println("Al enemigo no le queda PM para contratacar buena Jugada");
                    incrementoDefinitiva = Jugador.aumentaMedidorHabilidadDefinitiva(Jugador);
                    Jugador.puntosDeVida = incrementoDefinitiva;
                    desgastePuntosDeMagia = Jugador.desgastePM(Jugador);
                    Jugador.puntosDeMagia = desgastePuntosDeMagia;
                    System.out.println("Tus estadisticas actuales:" + Jugador);    
                    ataqueMagico_Jugador = Jugador.usaVacioPurpura(Enemigo);
                    incrementoDefinitiva = Enemigo.aumentaMedidorHabilidadDefinitiva(Enemigo);
                    Enemigo.puntosDeVida = ataqueMagico_Jugador;
                    Enemigo.puntosDeVida = incrementoDefinitiva;
                    System.out.println("Estadisticas Actuales del Enemigo: "+Enemigo);
                }else if(Enemigo.puntosDeMagia > Estadistica.VACIO){    
                ataqueMagico_Jugador = Jugador.usaVacioPurpura(Enemigo);
                desgastePuntosDeMagia = Enemigo.desgastePM(Enemigo);
                incrementoDefinitiva = Enemigo.aumentaMedidorHabilidadDefinitiva(Enemigo);
                Enemigo.puntosDeVida = ataqueMagico_Jugador;
                Enemigo.puntosDeMagia = desgastePuntosDeMagia;
                Enemigo.puntosDeVida = incrementoDefinitiva;
                System.out.println("Estadisticas Actuales del Enemigo: "+Enemigo);
                System.out.println("El enemigo Contrataca");
                int ataqueMagico_Enemigo = Enemigo.usaVacioPurpura(Jugador);
                desgastePuntosDeMagia = Jugador.desgastePM(Jugador);
                incrementoDefinitiva = Jugador.aumentaMedidorHabilidadDefinitiva(Jugador);
                Jugador.puntosDeVida = ataqueMagico_Enemigo;
                Jugador.puntosDeMagia = desgastePuntosDeMagia;
                Jugador.puntosDeVida = incrementoDefinitiva;
                System.out.println("Tus estadisticas actuales:" + Jugador);
                }
            //Condiciones para la Habilidad incrementoDefinitiva
            }else if( ataque.equals("Golpes Serios Serios Serie Consecutiva")){    
                 if(Jugador.medidorHabilidadDefinitiva != Estadistica.CAPACIDADSUFICIENTE_MEDIDORHABILIDAD_DEFINITIVA){    
                    System.out.println("No puedes usar la Habilidad incrementoDefinitiva si tu medidor no esta a 100");
                    if(Enemigo.medidorHabilidadDefinitiva == Estadistica.CAPACIDADSUFICIENTE_MEDIDORHABILIDAD_DEFINITIVA){
                        System.out.println("Aun asi El enemigo usa su Habilidad incrementoDefinitiva aprovechandose de tu error");
                        int ataqueEnemigoDefinitivo = Enemigo.usaHabilidadDefinitiva(Jugador);
                        Jugador.puntosDeVida = ataqueEnemigoDefinitivo;
                        System.out.println("Tus estadisticas actuales:" + Jugador);
                        reinicioHabilidadDefinitiva = Enemigo.desgasteUlti(Enemigo);
                        Enemigo.puntosDeVida = reinicioHabilidadDefinitiva;
                    }    
                }
                if(Jugador.medidorHabilidadDefinitiva == Estadistica.CAPACIDADSUFICIENTE_MEDIDORHABILIDAD_DEFINITIVA){
                    int ataqueJugadorDefinitivo = Jugador.usaHabilidadDefinitiva(Enemigo);
                    int ReinicioUltiJ = Jugador.desgasteUlti(Jugador);
                    Enemigo.puntosDeVida = ataqueJugadorDefinitivo;
                    Jugador.puntosDeVida = ReinicioUltiJ;
                    System.out.println("Estadisticas Actuales del Enemigo: "+Enemigo);
                    System.out.println("Tus estadisticas actuales:" + Jugador);           
                }    
                 if (Enemigo.medidorHabilidadDefinitiva == Estadistica.CAPACIDADSUFICIENTE_MEDIDORHABILIDAD_DEFINITIVA 
                    & Jugador.medidorHabilidadDefinitiva <= Estadistica.CAPACIDADSUFICIENTE_MEDIDORHABILIDAD_DEFINITIVA){    
                    System.out.println("El enemigo usa su Habilidad incrementoDefinitiva");
                    int ataqueEnemigoDefinitivo = Enemigo.usaHabilidadDefinitiva(Jugador);
                    Jugador.puntosDeVida = ataqueEnemigoDefinitivo;
                    System.out.println("Tus estadisticas actuales:" + Jugador);
                    reinicioHabilidadDefinitiva = Enemigo.desgasteUlti(Enemigo);
                    Enemigo.puntosDeVida = reinicioHabilidadDefinitiva;
                }           
            //Comprobacion de Contorno     
            }else{
                System.out.println("Incorrecto introduce uno de los 3 ataques mencionados");
            }   
            if(Enemigo.puntosDeVida <= Estadistica.VACIO){
                System.out.println("Has ganado la batalla");
                break;
            }
        }    
        //Impresion de pantalla usado para pruebas de esta Actividad Evaluable
        String Saludo = "Hola ¿que tal esta?";
        System.out.println(Saludo);
    }
    
}
