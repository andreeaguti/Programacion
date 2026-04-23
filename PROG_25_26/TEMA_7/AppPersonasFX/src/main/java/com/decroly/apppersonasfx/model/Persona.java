package com.decroly.apppersonasfx.model;

/**
 * Clase de Modelo que representa a una Persona.
 * Esta clase mapea directamente los datos de la tabla de la base de datos.
 */
public class Persona {

    // 1. ATRIBUTOS (Privados para cumplir con el principio de encapsulamiento)
    private String dni;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String phone;

    /**
     * CONSTRUCTOR COMPLETO
     * Se usa cuando ya tenemos todos los datos y queremos crear el objeto rápidamente.
     */
    public Persona(String dni, String name, String surname,
                   int age, String email, String phone) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    /**
     * CONSTRUCTOR MEDIANTE BUILDER
     * Este constructor recibe el "ayudante" (PersonaBuilder) y copia sus datos.
     * Es la forma más limpia de crear objetos complejos.
     */
    public Persona(PersonaBuilder builder) {
        this.dni = builder.getDni();
        this.name = builder.getName();
        this.surname = builder.getSurname();
        this.age = builder.getAge();
        this.email = builder.getEmail();
        this.phone = builder.getPhone();
    }

    /**
     * CONSTRUCTOR VACÍO
     * Necesario para que algunos frameworks y librerías puedan crear
     * el objeto y luego rellenarlo poco a poco con los "setters".
     */
    public Persona() {}

    // 2. GETTERS (Para leer los datos desde fuera de la clase)
    public String getDni() { return dni; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    // 3. SETTERS (Para modificar los datos desde fuera de la clase)
    public void setDni(String dni) { this.dni = dni; }
    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setAge(int age) { this.age = age; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }

    /**
     * MÉTODO toString()
     * Sirve para que, si imprimes el objeto por consola, se vea la información
     * de la persona y no una dirección de memoria rara.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("dni='").append(dni).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", age=").append(age);
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /**
     * MÉTODO ESTÁTICO builder()
     * Es un "atajo" para no tener que hacer 'new PersonaBuilder()'.
     * Permite empezar a construir una persona escribiendo 'Persona.builder()...'
     */
    public static PersonaBuilder builder() {
        return new PersonaBuilder();
    }
}