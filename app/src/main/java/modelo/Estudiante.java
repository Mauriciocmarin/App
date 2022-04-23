package modelo;

public class Estudiante {

    private long id;
    private String nombre ;
    private String apellido ;
    private String direccion ;
    private String telefono ;
    private int edad ;
    private String correo;
    private String clave;


    public Estudiante(){
        this.id=Long.valueOf(0);
        this.nombre = "";
        this.apellido = "";
        this.direccion = "";
        this.telefono = "";
        this.edad = 0;
        this.correo = "";
        this.clave = "";
    }

    public Estudiante(String nombre, String apellido, String direccion, String telefono, int edad , String correo , String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.edad = edad;
        this.correo = correo;
        this.clave = clave;
    }

    public Estudiante(long id, String nombre, String apellido, String direccion, String telefono, int edad , String clave) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.edad = edad;
        this.correo = correo;
        this.clave = clave;

    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
