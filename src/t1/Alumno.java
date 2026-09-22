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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || !nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            throw new IllegalArgumentException("El nombre no puede contener números ni caracteres especiales.");
        }
        this.nombre = nombre.trim();
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        if (tipoDocumento == null || (!tipoDocumento.equalsIgnoreCase("DNI") && !tipoDocumento.equalsIgnoreCase("Residencia"))) {
            throw new IllegalArgumentException("Tipo de documento inválido. Debe ser DNI o Residencia.");
        }
        this.tipoDocumento = tipoDocumento.equalsIgnoreCase("DNI") ? "DNI" : "Residencia";
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        if (numeroDocumento == null) {
            throw new IllegalArgumentException("El número de documento no puede estar vacío.");
        }

        if (this.tipoDocumento != null && this.tipoDocumento.equals("DNI")) {
            if (!numeroDocumento.matches("^\\d{8}$")) {
                throw new IllegalArgumentException("El DNI debe tener exactamente 8 dígitos numéricos.");
            }
        } else if (this.tipoDocumento != null && this.tipoDocumento.equals("Residencia")) {
            if (!numeroDocumento.matches("^\\d{11}$")) {
                throw new IllegalArgumentException("La Residencia debe tener exactamente 11 dígitos numéricos.");
            }
        }
        this.numeroDocumento = numeroDocumento;
    }

    public char getNivelSocioeconomico() {
        return nivelSocioeconomico;
    }

    public void setNivelSocioeconomico(char nivelSocioeconomico) {
        char upper = Character.toUpperCase(nivelSocioeconomico);
        if (upper != 'A' && upper != 'B' && upper != 'C') {
            throw new IllegalArgumentException("El nivel socioeconómico solo puede ser A, B o C.");
        }
        this.nivelSocioeconomico = upper;
    }

    public String getTipoBeca() {
        return tipoBeca;
    }

    public void setTipoBeca(String tipoBeca) {
        if (tipoBeca == null || (!tipoBeca.equalsIgnoreCase("Ninguna") && !tipoBeca.equalsIgnoreCase("Parcial") && !tipoBeca.equalsIgnoreCase("Total"))) {
            throw new IllegalArgumentException("Tipo de beca inválido.");
        }
        this.tipoBeca = tipoBeca.substring(0, 1).toUpperCase() + tipoBeca.substring(1).toLowerCase();
    }

    public double calcularPensionFinal() {
        double tarifaBase = 0.0;
        switch (this.nivelSocioeconomico) {
            case 'A': tarifaBase = 1200.00; break;
            case 'B': tarifaBase = 800.00; break;
            case 'C': tarifaBase = 500.00; break;
        }

        double descuento = 1.0; 
        if (this.tipoBeca.equals("Parcial")) {
            descuento = 0.50; 
        } else if (this.tipoBeca.equals("Total")) {
            descuento = 0.0; 
        }

        return tarifaBase * descuento;
    }

    @Override
    public String toString() {
        return "Alumno [Nombre=" + nombre + 
               ", Doc=" + tipoDocumento + " (" + numeroDocumento + ")" +
               ", Nivel=" + nivelSocioeconomico + 
               ", Beca=" + tipoBeca + 
               ", Pensión Final=$" + calcularPensionFinal() + "]";
    }
}