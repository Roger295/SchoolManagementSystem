/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

/**
 *
 * @author roger
 */
public class Curso {
    private int id;
    private String nombre;
    private String descripcion;
    private int numeroCreditos;
    private String version;

    public Curso(int id, String nombre, String descripcion, int numeroCreditos, String version) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.numeroCreditos = numeroCreditos;
        this.version = version;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getNumeroCreditos() {
        return numeroCreditos;
    }

    public String getVersion() {
        return version;
    }
}

