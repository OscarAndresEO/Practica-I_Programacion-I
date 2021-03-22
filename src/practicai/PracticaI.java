package practicai;

import java.util.*;

public class PracticaI {

    public static String texto;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Dispositivos dispositivo[] = new Dispositivos[20];

        while (true) {
            System.out.println("\n-------------Ecosistema de Dispositivos-------------");
            System.out.println("\n1. Crear dispositivo\n2. Administrar dispositivo\n3. Acciones con dispositivos"
                    + "\n4. Acciones externas de dispositivos\n5. Cargas masivas\n6. Logs");

            System.out.print("\nSeleccione la opción a ejecutar: ");
            int respuesta = entrada.nextInt();

            switch (respuesta) {
                case 1:
                    System.out.println("\n-------------Crear Dispositivo-------------"
                            + "\n1. Computadora portátil\n2. Tablet\n3. SmartWatch\n4. SmartPhone\n5. Auriculares Inalámbricos");

                    System.out.print("Seleccione tipo de dispositivo a crear:");
                    int respuesta1 = entrada.nextInt();
                    String crear = null;

                    switch (respuesta1) {
                        case 1:
                            crear = "Computadora portátil";
                            break;
                        case 2:
                            crear = "Tablet";
                            break;
                        case 3:
                            crear = "SmartWatch";
                            break;
                        case 4:
                            crear = "SmartPhone";
                            break;
                        case 5:
                            crear = "Auriculares Inalámbricos";
                            break;
                    }
                    CrearDispositivo(dispositivo, crear);
                    break;

                case 2:
                    AdministrarDispositivo(dispositivo);
                    break;
                case 3:
                    AccionesDispositivos(dispositivo);
            }
        }
    }

    public static void CrearDispositivo(Dispositivos dispositivo[], String crear) {
        Scanner entrada = new Scanner(System.in);
        String correoElectronico, Nombre, tipo, conexion;
        boolean visible = false, encendido = true;
        boolean estadoControlador = false;
        int numero = 0, a = 0, c = 0;

        String b[] = new String[dispositivo.length];
        System.out.println("");
        if ("Auriculares Inalámbricos".equals(crear)) {

            System.out.println(
                    "-------------Creación de " + crear + "-------------");

            for (int i = 0; i < dispositivo.length; i++) {
                if (null == dispositivo[i]) {
                    break;
                } else if ((dispositivo[i].isEncendido() == true) && (dispositivo[i].isVisible() == true)
                        && (!"Auriculares Inalámbricos".equals(dispositivo[i].getTipo()))) {

                    System.out.println((a + 1) + ". " + dispositivo[i].getNombre());

                    b[a] = dispositivo[i].getNombre();
                    a++;
                }

            }

            for (int i = 0; i < dispositivo.length; i++) {
                if (dispositivo[i] == null) {
                    System.out.print("Seleccione un dispositivo para enlazar los auriculares: ");
                    int conexion1 = entrada.nextInt();

                    conexion = b[(conexion1 - 1)];

                    System.out.print("Nombre del dispositivo: ");
                    Nombre = entrada.nextLine();
                    Nombre = entrada.nextLine();
                    System.out.println("\nNota: El dispositivo será encendido por defecto.");
                    tipo = crear;
                    dispositivo[i] = new Dispositivos(tipo, conexion, Nombre, encendido);
                    break;

                }
            }
        } else {
            for (int i = 0; i < dispositivo.length; i++) {
                if (dispositivo[i] == null) {
                    System.out.println(
                            "-------------Creación de " + crear + "-------------");
                    tipo = crear;

                    System.out.print("\nCorreo electrónico: ");
                    correoElectronico = (entrada.nextLine());

                    System.out.print("Nombre del dispositivo: ");
                    Nombre = (entrada.nextLine());

                    System.out.print("Visible para conexión (s|n): ");
                    String visible1 = entrada.nextLine();

                    if (("s".equals(visible1)) || ("S".equals(visible1))) {
                        visible = (true);
                    } else if (("n".equals(visible1)) || ("S".equals(visible1))) {
                        visible = (false);
                    }
                    estadoControlador = (true);
                    if ("SmartPhone".equals(crear)) {
                        System.out.print("Número: ");
                        numero = (entrada.nextInt());
                        dispositivo[i] = new Dispositivos(correoElectronico, Nombre, tipo, visible, estadoControlador, numero, encendido);

                    } else {
                        dispositivo[i] = new Dispositivos(correoElectronico, Nombre, tipo, visible, estadoControlador, encendido);
                    }
                    System.out.println("\nNota: El dispositivo será encendido por defecto.");

                    break;
                }
            }
        }

    }

    public static void AdministrarDispositivo(Dispositivos dispositivo[]) {
        Scanner entrada = new Scanner(System.in);

        int seleccion, a = 0;
        String b[] = new String[dispositivo.length];
        String busqueda = null, encendido, d;

        System.out.println("\n-------------Administrar Dispositivos-------------\"");
        System.out.print("\n1. Computadora Pórtatil\n2. Tablet\n3. SmartWatch\n4. Smartphone"
                + "\n5. Auriculares inalámbricos\n\nSeleccione tipo de dispositivo a administrar:");
        seleccion = entrada.nextInt();

        System.out.println("");
        switch (seleccion) {
            case 1:
                busqueda = "Computadora portátil";
                System.out.println("------- Computadoras portátiles creardas-------");
                break;
            case 2:
                busqueda = "Tablet";
                System.out.println("-------Tablets creardos-------");
                break;
            case 3:
                busqueda = "SmartWatch";
                System.out.println("-------SmartWatch creardos-------");
                break;
            case 4:
                busqueda = "SmartPhone";
                System.out.println("-------SmartPhones creardos-------");
                break;
            case 5:
                busqueda = "Auriculares Inalámbricos";
                System.out.println("-------Auriculares Inalámbricos creardos-------");
                break;

        }
        for (int i = 0; i < dispositivo.length; i++) {
            if (null == dispositivo[i]) {
                break;
            } else if (busqueda.equals(dispositivo[i].getTipo())) {

                if (dispositivo[i].isEncendido()) {
                    encendido = "Encendido";
                } else {
                    encendido = "Apagado";
                }
                if (busqueda.equals("Auriculares Inalámbricos")) {
                    System.out.println((a + 1) + ". " + dispositivo[i].getNombre() + "      " + encendido + " estan conectados a " + dispositivo[i].getConexion());
                } else {
                    System.out.println((a + 1) + ". " + dispositivo[i].getNombre() + "      " + encendido);
                }

                b[a] = dispositivo[i].getNombre();
                a++;
            }

        }
        System.out.print("Seleccione un dispositivo para administrar:");
        int dispositivoEditar = entrada.nextInt();

        for (int i = 0; i < dispositivo.length; i++) {

            if (null == dispositivo[i]) {
                break;
            } else if (dispositivo[i].getNombre().equals(b[(dispositivoEditar - 1)])) {
                System.out.println("\n--------Administracion de " + busqueda + "--------");
                System.out.println("Nombre del dispositivo Seleccionado: " + dispositivo[i].getNombre());

                if (seleccion == 5) {
                    System.out.println("\n1. Editar nombre del dispositivo\n2. Eliminar dispositivo sincronizado");
                    if ((dispositivo[i].isEncendido())) {
                        System.out.println("3.. Apagar dispositivo");
                    } else {
                        System.out.println("3. Encender dispositivo");
                    }
                    System.out.print("Seleccione la propiedad a editar: ");
                    int editar = entrada.nextInt();

                    d = entrada.nextLine();
                    switch (editar) {
                        case 1:
                            System.out.print("Digite el nuevo Nombre: ");
                            dispositivo[i].setNombre(entrada.nextLine());
                            break;
                        case 2:
                            dispositivo[i].setConexion(null);
                            break;
                        case 3:
                            if (dispositivo[i].isEncendido()) {
                                dispositivo[i].setEncendido(false);
                            } else {
                                dispositivo[i].setEncendido(true);
                            }
                            break;
                    }
                    break;
                } else {
                    System.out.print("\n1. Editar correo electrónico\n2. Editar Nombre del dispositivos\n");
                    if (dispositivo[i].isEncendido()) {
                        System.out.println("3. Apagar visibilidad del dispositivo\"");
                    } else {
                        System.out.println("3. Encender visibilidad del dispositivo\"");
                    }
                    if ((dispositivo[i].isEncendido())) {
                        System.out.println("4. Apagar dispositivo");
                    } else {
                        System.out.println("4. Encender dispositivo");
                    }

                    System.out.print("\nSeleccione la propiedad a editar: ");
                    int editar = entrada.nextInt();

                    d = entrada.nextLine();
                    switch (editar) {
                        case 1:
                            System.out.print("Digite el nuevo correo electronico:");
                            dispositivo[i].setCorreoElectronico(entrada.nextLine());
                            break;
                        case 2:
                            System.out.print("Digite el nuevo Nombre: ");
                            dispositivo[i].setNombre(entrada.nextLine());
                            break;
                        case 3:
                            if (dispositivo[i].isVisible()) {
                                dispositivo[i].setVisible(false);
                            } else {
                                dispositivo[i].setVisible(true);
                            }
                            break;
                        case 4:
                            if (dispositivo[i].isEncendido()) {
                                dispositivo[i].setEncendido(false);
                            } else {
                                dispositivo[i].setEncendido(true);
                            }
                            break;
                    }
                    break;
                }
            }
        }
    }

    public static void AccionesDispositivos(Dispositivos dispositivo[]) {
        Scanner entrada = new Scanner(System.in);
        int a = 0, posicion = 0, desicion2 = 0;

        String b[] = new String[dispositivo.length];

        System.out.println("\n-------Acciones con Dispositivos-------");
        System.out.print("Seleccione tipo de dispositivo:\n\n1. Computadora portátil"
                + "\n2. Tablet\n3. SmartWatch\n4. Smartphone\n5. Auriculalres inalámbricos"
                + "\n\nSeleccione un tipo de dispositivo: ");
        int desicion = entrada.nextInt();

        switch (desicion) {
            case 1:
                for (int i = 0; i < dispositivo.length; i++) {
                    if (dispositivo[i] == null) {
                        break;
                    } else if (dispositivo[i].getTipo().equals("Computadora portátil")) {
                        System.out.println((a + 1) + ". " + dispositivo[i].getNombre());
                        b[a] = dispositivo[i].getNombre();
                        a++;
                    }
                }
                break;

            case 2:
                for (int i = 0; i < dispositivo.length; i++) {
                    if (dispositivo[i] == null) {
                        break;
                    } else if (dispositivo[i].getTipo().equals("Tablet")) {
                        System.out.println((a + 1) + ". " + dispositivo[i].getNombre());
                        b[a] = dispositivo[i].getNombre();
                        a++;
                    }
                }
                break;
            case 3:
                for (int i = 0; i < dispositivo.length; i++) {
                    if (dispositivo[i] == null) {
                        break;
                    } else if (dispositivo[i].getTipo().equals("SmartWatch")) {
                        System.out.println((a + 1) + ". " + dispositivo[i].getNombre());
                        b[a] = dispositivo[i].getNombre();
                        a++;
                    }
                }
                break;
            case 4:
                for (int i = 0; i < dispositivo.length; i++) {
                    if (dispositivo[i] == null) {
                        break;
                    } else if (dispositivo[i].getTipo().equals("SmartPhone")) {
                        System.out.println((a + 1) + ". " + dispositivo[i].getNombre());
                        b[a] = dispositivo[i].getNombre();
                        a++;
                    }
                }
                break;
            case 5:
                for (int i = 0; i < dispositivo.length; i++) {
                    if (dispositivo[i] == null) {
                        break;
                    } else if (dispositivo[i].getTipo().equals("Auriculares Inalámbricos")) {
                        System.out.println((a + 1) + ". " + dispositivo[i].getNombre());
                        b[a] = dispositivo[i].getNombre();
                        a++;
                    }
                }
                break;
        }
        System.out.println("Seleccione un dispositivo para activar la accion: ");
        int dispositi = entrada.nextInt();

        for (int i = 0; i < dispositivo.length; i++) {
            if (dispositivo[i] == null) {
                break;
            } else if (dispositivo[i].getNombre().equals(b[(dispositi - 1)])) {
                posicion = i;
            }
        }

        System.out.println("\n-------Acciones con Dispositivos-------");
        System.out.println("Tipo de Dispositivo: " + dispositivo[posicion].getTipo()
                + "\nNombre del dispositivo: " + dispositivo[posicion].getNombre());

        if ("SmartWatch".equals(dispositivo[posicion].getTipo())) {
            System.out.print("Seleccione el tipo de la acción a realizar:\n\n1. Tomar fotografia"
                    + "\n2. Copiar texto\n3. Compartir documentos\n\nSeleccione accion a realizar: ");
            desicion2 = entrada.nextInt();

        } else if ("Auriculares Inalámbricos".equals(dispositivo[posicion].getTipo())) {

            System.out.println("No se puede hacer ninguna accion con este tipo de dispositivos :(");
        } else {
            System.out.print("Seleccione el tipo de la acción a realizar:\n\n1. Tomar fotografia"
                    + "\n2. Copiar texto\n3. Pegar texto\n4. Compartir documentos\n5. Reproducir Musica"
                    + "\n\nSeleccione accion a realizar: ");
            desicion2 = entrada.nextInt();

            switch (desicion2) {
                case 1:
                    TomarFoto(dispositivo, posicion, dispositivo[posicion].getTipo());
                    break;
                case 2:
                    System.out.print("Digite texto para copear: ");
                    texto = entrada.nextLine();
                    texto = entrada.nextLine();
                    break;
                case 3:
                    System.out.println(texto);
                    break;
                case 4:
                    break;
                case 5:
                    for (int i = 0; i < dispositivo.length; i++) {
                        if (dispositivo[i] == null) {
                            break;
                        } else if (dispositivo[i].getConexion() == null) {
                            continue;
                        } else if (dispositivo[i].getConexion().equals(dispositivo[posicion].getNombre())) {
                            System.out.println("Desea que la musica se reproduzca en los auriculares '" + dispositivo[i].getNombre() + "' 1) Si   2) No");
                            int reproduccion = entrada.nextInt();

                            if (reproduccion == 1) {
                                System.out.println("La musica esta sonando en: " + dispositivo[i].getNombre());
                            } else {
                                System.out.println("La musica esta sonando en los altavoces del dispositivo actual");
                            }
                        }
                    }
                    break;
            }
        }
    }

    public static void TomarFoto(Dispositivos dispositivo[], int posicion, String tipo) {
        Scanner entrada = new Scanner(System.in);

        boolean accion = false;

        if (tipo == "SmartPhone") {
            System.out.print("Digite el nombre para la fotografía: ");
            String foto = entrada.nextLine();
            accion = true;
        }
        for (int i = 0; i < dispositivo.length; i++) {
            if (dispositivo[i] == null) {
                break;
            } else if ((dispositivo[i].getTipo().equals("SmartPhone"))) {
                if ((dispositivo[i].getCorreoElectronico().equals(dispositivo[posicion].getCorreoElectronico()))
                        && (dispositivo[i].isEncendido() == true)
                        && (dispositivo[i].isVisible() == true)) {
                    accion = true;

                    System.out.print("Digite el nombre para la fotografía: ");
                    String foto = entrada.nextLine();
                }
            }
        }

    }

}
