package org.iesvdm;


import static org.junit.jupiter.api.Assertions.*;
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

        final double[] array = new double[10];
        array[0]=3.5;

        double[] arrayActual = AlturaAlumno.añadeAltura(array);


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
}
