/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BatallaporTurnos;

/**
 *
 * @author user
 */
public class Estadistica {
    //Atributos de los Personajes
    int puntosDeVida;
    int puntosDeMagia;
    int medidorHabilidadDefinitiva;
    //Constantes de Daño General
    final static int DANOFISICO = 100;
    final static int DANOMAGICO = 400;
    //Constante de Desgaste
    final static int DESGASTEMAGICO = 40;
    //Constantes de la Habilidad Definitiva
    final static int INCREMENTOMEDIDORHABILIDAD_DEFINITIVA = 10;
    final static int DANOHABILIDAD_DEFINITIVA = 1000;
    final static int CAPACIDADSUFICIENTE_MEDIDORHABILIDAD_DEFINITIVA = 100;
    //Constante para estadisticas Vacias
    final static int VACIO = 0;
    
    //Constructor Completo
    Estadistica(int Vida,int Magia,int Definitiva){
        puntosDeVida = Vida;
        puntosDeMagia = Magia;
        medidorHabilidadDefinitiva = Definitiva;
    }    
    
    //Constructor Vacio
    Estadistica(){
        puntosDeVida = 0;
        puntosDeMagia = 0;
        medidorHabilidadDefinitiva = 0;
    }    
    
    //toString de los atributos de los Personajes
    public String toString(){
        String estadisticas = "PS: " + puntosDeVida + " PM: " + puntosDeMagia + ",Medidor Habilidad Definitiva: " + medidorHabilidadDefinitiva;    
        return estadisticas;
    }    
    
    //Funciones
    int usaGolpesNormales(Estadistica Herida){
        int ataque = (Herida.puntosDeVida - DANOFISICO);
        return ataque;
    }    
    
    int usaVacioPurpura(Estadistica HeridaM){
        int ataqueM = (HeridaM.puntosDeVida - DANOMAGICO);
        return ataqueM;
    }    
    
    int desgastePM(Estadistica Potencia){
        int desgaste = (Potencia.puntosDeMagia - DESGASTEMAGICO);
        return desgaste;
    }    
    
    int aumentaMedidorHabilidadDefinitiva(Estadistica Aumento){
        int incremento = (Aumento.medidorHabilidadDefinitiva + 
        INCREMENTOMEDIDORHABILIDAD_DEFINITIVA);
        return incremento;
    }    
    
    int usaHabilidadDefinitiva(Estadistica Ultima){    
        int ataqueUlti = (Ultima.puntosDeVida - DANOHABILIDAD_DEFINITIVA);
        return ataqueUlti;
    }    
    
    int desgasteUlti(Estadistica Reinicio){
        int desgasteSupremo = Reinicio.medidorHabilidadDefinitiva = VACIO; 
        return desgasteSupremo;
    }          
}
