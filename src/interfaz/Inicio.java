package interfaz;

import entidad.Paciente;

public class Inicio {
    public static void main(String[] args) {

        //Controlar las opciones del menú
      //  Paciente paciente = null;
        String rut = null, nombre = null;
        int edad = 0;
        char sexo = 0;
        Paciente paciente = new Paciente(rut, nombre, edad, sexo);
        int opcion;
        do {
            opcion = menu();

            switch (opcion) {
                case 1:
                    // 1) Crear un objeto de tipo Paciente.
                    paciente = crearPaciente(rut,nombre,edad,sexo);
                    System.out.println("------Ingrese datos del paciente------");
                    System.out.println("Rut (con dígito verificador): " + paciente.getRut());
                    System.out.println("Nombre completo: " + paciente.getNombre());
                    System.out.println("Edad: " + paciente.getEdad());
                    System.out.println("Sexo (F/M): " + paciente.getSexo());
                    break;
                case 2:
                    // 2) Mostrar todos los atributos del paciente registrado (objeto).
                    System.out.println("Los siguientes son los datos del paciente: ");
                    System.out.println("Rut: " + paciente.getRut());
                    System.out.println("Nombre completo: " + paciente.getNombre());
                    System.out.println("Edad: " + paciente.getEdad());
                    System.out.println("Sexo: " + paciente.getSexo());
                    System.out.println("Pesos en kilos registrados para el paciente los últimos 12 meses: ");
                    int[] arreglo;
                    arreglo = paciente.getPesomensual();
                    for (int i = 0; i <= 11; i++) {
                        System.out.println("Mes " + (i + 1) + ":" + arreglo[i]);
                    }
                    break;
                case 3:
                    // 3) Mostrar el mes con menor peso del paciente registrado (objeto).
                    System.out.println("El mes (en número), con menor peso registrado para el paciente es: ");
                    int pesoMin;
                    pesoMin = paciente.menorPesoMensual();
                    System.out.println(pesoMin);
                    break;
                case 4:
                    // 4) Solicitar el ingreso de un peso para comparar y si el método menosDeXKilos retorna valor distinto de null, mostrar array con los meses
                    // en que el paciente pesó menos kilos que los ingresados por el usuario, de lo contrario dar mensaje adecuado.
                    System.out.println("Indique peso para comparar: ");
                    int pesoX = Leer.datoInt();
                    int menosXK[] = paciente.menosDeXKilos(pesoX);
                    for(int i =0; i<=menosXK.length-1; i++) {
                        System.out.println(menosXK[i]);
                    }
                    break;
                case 5:
                // 5) Dada la estatura, mostrar la condición del paciente en el mes de noviembre (normal, sobrepeso u obeso).
                    String resultado;
                    int mes = 0;
                    double estatura = 0;
                    resultado = paciente.pesoMesX(mes, estatura);
                    System.out.println("La condición del paciente es: " + resultado);
                    break;
            }
        } while (opcion != 4);
    }


            public static int menu () {
                System.out.println("---Información de pacientes de Clínica Contigo Aprendo---");
                System.out.println("--------------------------------------------");
                System.out.println("1.\tRegistrar nuevo paciente.");
                System.out.println("2.\tMostrar datos del paciente registrado");
                System.out.println("3.\tMes con menor peso del paciente");
                System.out.println("4.\tComparar peso actual");
                System.out.println("5.\tConsulta de condición del paciente");
                System.out.println("6.\tSalir");
                System.out.println("---------------------------------------------");
                System.out.println("Favor ingrese una opción para continuar...");
                return Leer.datoInt();
            }

            public static Paciente crearPaciente(String rutX, String nombreX, int edadX, char sexoX) {
                System.out.println("Por favor ingrese datos del paciente: ");
                System.out.println("Rut (con dígito verificador): ");
                rutX = Leer.dato();
                System.out.println("Nombre completo: ");
                nombreX = Leer.dato();
                System.out.println("Edad: ");
                edadX = Leer.datoInt();
                System.out.println("Sexo (F/M): ");
                sexoX = Leer.datoChar();
                return new Paciente(rutX,nombreX,edadX,sexoX);
            }
        }