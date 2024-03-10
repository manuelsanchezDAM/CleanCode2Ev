/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package junit.batallaporturnos;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alumn
 */
public class EstadisticaTest {
    //Test Normales
    @Test
    public void testConstructorDefault() {
        Estadistica estadistica = new Estadistica();
        //Aseguramos que los Valores esten vacios como por Defecto
        assertAll(
        () -> assertEquals(0, estadistica.getPuntosDeVida()),
        () -> assertEquals(0, estadistica.getPuntosDeMagia()), 
        () -> assertEquals(0, estadistica.getMedidorHabilidadDefinitiva())
        );
    }
    
    @Test
    public void testConstructorConValores() {
        Estadistica estadistica = new Estadistica(100, 50, 10);
        //Lo mismo que en el anterior Test pero con Valores Determinados
        assertAll(
        () -> assertEquals(100, estadistica.getPuntosDeVida()),
        () -> assertEquals(50, estadistica.getPuntosDeMagia()),
        () -> assertEquals(10, estadistica.getMedidorHabilidadDefinitiva())
        );
    }

    @Test
    public void testUsaGolpesNormales() {
        Estadistica jugador = new Estadistica(200, 0, 50);
        Estadistica enemigo = new Estadistica(500, 0, 20);
        int resultadoAtaque = jugador.usaGolpesNormales(enemigo);
        assertEquals(400, resultadoAtaque); //Vida Esperada del Enemigo despues del Ataque
    }

    @Test
    public void testUsaVacioPurpura() {
        Estadistica jugador = new Estadistica(300, 50, 30);
        Estadistica enemigo = new Estadistica(800, 200, 10);
        int resultadoAtaque = jugador.usaVacioPurpura(enemigo);
        assertEquals(400, resultadoAtaque); // Vida Esperada del Enemigo despues del Ataque
    }
    //Tareas Antes,Despues,etc...
    @BeforeAll
    public static void setUpClass() {
        Estadistica Jugador = new Estadistica(100, 50, 10);
        Estadistica Enemigo = new Estadistica(200, 100, 20);
        System.out.println("Inicializacion antes de todas las pruebas");
    }
    
    @AfterAll
    public static void tearDownClass() {
        System.out.println("Inicializacion despues de todas las pruebas");
    }
    
    @BeforeEach
    public void setUp() {
        System.out.println("Tareas de Limpieza antes de cada Prueba");
    }
    
    @AfterEach
    public void tearDown() {
        System.out.println("Tareas de Limpieza despues de cada Prueba");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
