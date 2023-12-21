package model;


public class Mascotas {
    
    int id;
    String nombre;
    String raza;

    public Mascotas() {
    }

    public Mascotas(String nombre, String raza) {
        this.nombre = nombre;
        this.raza = raza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
    
    
}
