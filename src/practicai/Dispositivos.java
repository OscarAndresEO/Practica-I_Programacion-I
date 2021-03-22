
package practicai;

import java.io.Serializable;

public final class Dispositivos implements Serializable {
    
    public String correoElectronico,Nombre , tipo, conexion;
    public boolean visible, encendido = true;
    public int numero;

    public Dispositivos(String correoElectronico, String Nombre, String tipo, String conexion, boolean visible, int numero) {
        this.correoElectronico = correoElectronico;
        this.Nombre = Nombre;
        this.tipo = tipo;
        this.conexion = conexion;
        this.visible = visible;
        this.numero = numero;
    }

    Dispositivos(String correoElectronico, String Nombre, String tipo, boolean visible, boolean estadoControlador, int numero, boolean encendido) {
        this.correoElectronico = correoElectronico;
        this.Nombre = Nombre;
        this.tipo = tipo;
        this.visible = visible;
        this.numero = numero;
        this.encendido = encendido;
    }

    Dispositivos(String correoElectronico, String Nombre, String tipo, boolean visible, boolean estadoControlador, boolean encendido) {
        this.correoElectronico = correoElectronico;
        this.Nombre = Nombre;
        this.tipo = tipo;
        this.visible = visible;
        this.encendido = encendido;
        
    }
    
    Dispositivos(String tipo, String conexion, String Nombre, boolean encendido) {
        this.tipo = tipo;
        this.conexion = conexion;
        this.Nombre = Nombre;
        this.encendido = encendido;
    }

    public String getConexion() {
        return conexion;
    }

    public void setConexion(String conexion) {
        this.conexion = conexion;
    }
    
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
}
