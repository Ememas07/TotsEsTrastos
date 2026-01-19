/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

/**
 * Hem rebut l'encàrrec d'un client per definir els paquets i les classes
 * necessàries (només implementar els atributs i els constructors) per gestionar
 * una empresa ferroviària, on es distingeixen dos grans grups: el personal i la
 * maquinària. ● Al primer s'ubiquen tots els empleats de l'empresa, que es
 * classifiquen en tres grups: els maquinistes, els mecànics i els caps
 * d'estació. De cadascun d'ells cal guardar:
 *
 * aquinistes: el nom, el DNI, el sou i el rang que tenen adquirit.
 *
 * Mecànics: el seu nom, telèfon (per contactar en cas d'urgència) i en quina
 * especialitat desenvolupen la feina (aquesta pot ser: frens, hidràulica,
 * electricitat o motor).
 *
 * Caps d'estació: el seu nom, DNI i la data en què va ser nomenat cap d'estació
 *
 * A la part de maquinària podem trobar trens, locomotores i vagons. De cada un
 * cal considerar:
 *
 * Vagons: tenen un número que els identifica, una càrrega màxima (en quilos),
 * la càrrega actual i el tipus de mercaderia amb què estan carregats.
 *
 *
 * Locomotores: disposen d'una matrícula (que les identifica), la potència dels
 * motors i una antiguitat (any de fabricació). A més, cada locomotora té
 * assignat un mecànic que se n'encarrega del manteniment.
 *
 *
 * Trens: estan formats per una locomotora i un màxim de 5 vagons. Cada tren té
 * assignat un maquinista que n'és responsable.
 *
 *
 * Totes les classes corresponent al personal (Maquinista, Mecanic i CapEstacio)
 * seran d'ús públic. Entre les classes relatives a la maquinària només podrà
 * ser possible construir des de classes externes, objectes de tipus Tren i de
 * tipus Locomotora. La classe Vago només serà visible per les classes veinades.
 *
 * @author Marc Mas
 */
public class Ud7Act9MarcMas {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
