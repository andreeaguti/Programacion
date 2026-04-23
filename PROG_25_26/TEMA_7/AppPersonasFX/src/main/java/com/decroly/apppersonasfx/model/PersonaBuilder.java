package com.decroly.apppersonasfx.model;

/**
 * Clase de soporte que implementa el Patrón de Diseño "Builder".
 * Sirve para construir objetos de la clase Persona de forma fluida y legible.
 */
public class PersonaBuilder {

    // 1. ATRIBUTOS: Copian la estructura de la clase Persona para ir guardando los valores temporalmente
    private String dni;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String phone;

    // 2. GETTERS: Permiten que la clase Persona lea los datos acumulados aquí
    public String getDni() { return dni; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    /**
     * MÉTODOS DE CONSTRUCCIÓN (Estilo Fluido)
     * En lugar de llamarse setDni, se llaman simplemente 'dni'.
     * La clave es que devuelven 'this' (el propio Builder), permitiendo encadenar puntos.
     */
    public PersonaBuilder dni(String dni) {
        this.dni = dni;
        return this; // Devuelve el constructor para seguir añadiendo datos
    }

    public PersonaBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PersonaBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonaBuilder age(int age) {
        this.age = age;
        return this;
    }

    public PersonaBuilder email(String email) {
        this.email = email;
        return this;
    }

    public PersonaBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * MÉTODO FINAL: build()
     * Es el que "cierra" la construcción.
     * Llama al constructor de Persona pasándole todos los datos recolectados.
     */
    public Persona build() {
        return new Persona(dni, name, surname, age, email, phone);
    }

    // Constructor vacío por defecto
    public PersonaBuilder() {}
}