/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junit.batallaporturnos;

/**
 *
 * @author user
 */
public class Estadistica {
    //Atributos de los Personajes
    private int puntosDeVida;
    private int puntosDeMagia;
    private int medidorHabilidadDefinitiva;
    //Constantes de Daño General
    private final static int DANOFISICO = 100;
    private final static int DANOMAGICO = 400;
    //Constante de Desgaste
    private final static int DESGASTEMAGICO = 40;
    //Constantes de la Habilidad Definitiva
    private final static int INCREMENTOMEDIDORHABILIDAD_DEFINITIVA = 10;
    private final static int DANOHABILIDAD_DEFINITIVA = 1000;
    private final static int CAPACIDADSUFICIENTE_MEDIDORHABILIDAD_DEFINITIVA = 100;
    //Constante para estadisticas Vacias
    private final static int VACIO = 0;
    
    //Constructor Completo
    Estadistica(int Vida,int Magia,int Definitiva){
        if (Vida < 0 || Magia < 0 || Definitiva < 0){
            throw new IllegalArgumentException("Los valores de vida, magia y definitiva no pueden ser negativos");
        }
        this.puntosDeVida = Vida;
        this.puntosDeMagia = Magia;
        this.medidorHabilidadDefinitiva = Definitiva;
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
        if(ataque < VACIO){
            ataque = VACIO;
        }
        return ataque;
    }    
    
    int usaVacioPurpura(Estadistica HeridaM){
        int ataqueM = (HeridaM.puntosDeVida - DANOMAGICO);
         if(ataqueM < VACIO){
            ataqueM = VACIO;
        }
        return ataqueM;
    }    
    
    int desgastePM(Estadistica Potencia){
        int desgaste = (Potencia.puntosDeMagia - DESGASTEMAGICO);
        if(desgaste < DESGASTEMAGICO){
            desgaste = VACIO;
        }
        return desgaste;
    }    
    
    int aumentaMedidorHabilidadDefinitiva(Estadistica Aumento){
        int incremento = (Aumento.medidorHabilidadDefinitiva + 
        INCREMENTOMEDIDORHABILIDAD_DEFINITIVA);
        if(incremento > CAPACIDADSUFICIENTE_MEDIDORHABILIDAD_DEFINITIVA){
            incremento = CAPACIDADSUFICIENTE_MEDIDORHABILIDAD_DEFINITIVA;
        }
        return incremento;
    }    
    
    int usaHabilidadDefinitiva(Estadistica Ultima){    
        int ataqueUlti = (Ultima.puntosDeVida - DANOHABILIDAD_DEFINITIVA);
        if(ataqueUlti < VACIO){
            ataqueUlti = VACIO;
        }
        return ataqueUlti;
    }    
    
    int desgasteUlti(Estadistica Reinicio){
        int desgasteSupremo = Reinicio.medidorHabilidadDefinitiva = VACIO; 
        return desgasteSupremo;
    }
    
    Estadistica CopiarObjeto(){
        Estadistica copia = new Estadistica();
        copia.puntosDeVida = this.puntosDeVida;
        copia.puntosDeMagia = this.puntosDeMagia;
        copia.medidorHabilidadDefinitiva = this.medidorHabilidadDefinitiva;
        return copia;
    }    

    public int getPuntosDeVida() {
        return puntosDeVida;
    }

    public void setPuntosDeVida(int puntosDeVida) {
        this.puntosDeVida = puntosDeVida;
    }

    public int getPuntosDeMagia() {
        return puntosDeMagia;
    }

    public void setPuntosDeMagia(int puntosDeMagia) {
        this.puntosDeMagia = puntosDeMagia;
    }

    public int getMedidorHabilidadDefinitiva() {
        return medidorHabilidadDefinitiva;
    }

    public void setMedidorHabilidadDefinitiva(int medidorHabilidadDefinitiva) {
        this.medidorHabilidadDefinitiva = medidorHabilidadDefinitiva;
    }
    
    public static int getCapacidad() {
        return CAPACIDADSUFICIENTE_MEDIDORHABILIDAD_DEFINITIVA;
    }
    
    public static int getVacio(){
        return VACIO;
    }
    
    public static int getDesgaste(){
        return DESGASTEMAGICO;
    }
}
