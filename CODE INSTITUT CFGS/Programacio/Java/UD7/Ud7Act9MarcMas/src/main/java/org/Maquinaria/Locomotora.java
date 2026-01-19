/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Maquinaria;

import org.Personal.Mecanic;

/**
 *
 * @author Marc Mas
 */
public class Locomotora {

    String matricula;
    int potenciaMotors;
    int anyFabricacio;
    Mecanic encarregat;

    public Locomotora(String matricula, int potenciaMotors, int anyFabricacio, Mecanic encarregat) {
        this.matricula = matricula;
        this.potenciaMotors = potenciaMotors;
        this.anyFabricacio = anyFabricacio;
        this.encarregat = encarregat;
    }

}
