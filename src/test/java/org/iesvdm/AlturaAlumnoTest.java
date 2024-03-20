package org.iesvdm;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlturaAlumnoTest {
    @Test
    void verdadero(){
        assertTrue(1==1);}

    @Test
    void aniadeNombreTest1(){

        final String[] array = new String[10];
        array[0]="Jose";
        String nombre ="Maria";
        String[] arrayActual = AlturaAlumno.añadeNombre(array, nombre);

        assertTrue(arrayActual[arrayActual.length-1]
                .equals(nombre));
    }
    @Test
    void aniadeAlturaTest(){

        double[] array = {1,2,3,4};
        double[] nuevo = {1,2,3,4,1.5};

        assertArrayEquals(nuevo,AlturaAlumno.añadeAltura(array));

    }

    @Test
    void modificarAlturaTest(){
        //When
        double[] array = {1.6, 1.8, 1.7};
        double []aux= Arrays.copyOf(array,array.length);
        int posicion = 1;
        double altura = 1.9;

        //Do
        AlturaAlumno.modificaAltura(array,posicion,altura);

        //Then

        //altura esta en la posicion
        assertTrue(altura == array[posicion]);

        //todos los demas elementos no cambian

        for (int i = 0; i< array.length;i++){
            if (i != posicion){
                assertEquals(array[i],aux[i]);
            }
        }

    }
    @Test
    void buscaNombreTest1(){ // Devuelve la posicion del nombre que le pasamos
        String[] array = {"Juan","Ana","Luis"};
        String nombre = "Ana";

        assertEquals(1, AlturaAlumno.buscaNombre(array,nombre));
    }
    @Test
    void buscaNombreTest2(){ // Si no encuentra el nombre deberia devolver -1
        String[] array = {"Juan","Ana","Luis"};
        String nombre = "Cristina";

        assertEquals(-1, AlturaAlumno.buscaNombre(array,nombre));
    }

    @Test
    void mostrarTest(){

        String[] arrayNombre = {"Hugo","Ana","Ian"};
        double[] arrayAltura = {1,2,3};

       assertDoesNotThrow(() -> {
           AlturaAlumno.mostrar(arrayNombre, arrayAltura);
       });
    }

    @Test
    void calcularMaximoTest1(){ // Prueba si el funcionamiento es correcto

        double[] maximo= {1.1,5.87,8.5,3.6,4.1};
        double[] solucion = {2,8.5}; // Esto es lo que deberia de devolver el metodo
        assertArrayEquals(solucion,AlturaAlumno.calculaMaximo(maximo));
    }
    @Test
    void calcularMaximoTest2(){ // Prueba si le paso un array vacio, deberia devolver [0,0]

        double[] array= {};
        double[] solucion = {0,0}; // Esto es lo que deberia de devolver el metodo

        assertArrayEquals(solucion,AlturaAlumno.calculaMaximo(array));

    }

    @Test
    void calcularMediaTest1(){ // Prueba si funciona correctamente el metodo

        double[] array= {2,4,6,8,10};

        assertEquals(6,AlturaAlumno.calculaMedia(array));
    }
    @Test

    void calcularMediaTest2(){ // Prueba de si le mandamos un array vacio.

        double[] array= {};

        assertEquals(0,AlturaAlumno.calculaMedia(array));
    }
}
