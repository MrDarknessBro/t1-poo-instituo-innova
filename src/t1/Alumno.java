/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t1;

/**
 *
 * @author UCA40417
 */
public class Alumno {
   private String nombre;
    private String tipoDocumento; 
    private String numeroDocumento; 
    private char nivelSocioeconomico; 
    private String tipoBeca; 

    public Alumno() {}

    public Alumno(String nombre, String tipoDocumento, String numeroDocumento, char nivelSocioeconomico, String tipoBeca) {
        setTipoDocumento(tipoDocumento); 
        setNombre(nombre);
        setNumeroDocumento(numeroDocumento);
        setNivelSocioeconomico(nivelSocioeconomico);
        setTipoBeca(tipoBeca);
    }
}