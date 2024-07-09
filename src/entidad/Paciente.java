package entidad;

import javax.swing.*;

public class Paciente {

    //-----Atributos-----
    private String rut; //25574093-8
    private String nombre; //Lourdes Castillo
    private int edad; //43
    private char sexo; //F
    // private double estatura; //1,57
    private int[] pesomensual; //aleatorio

    //Accesadores y mutadores
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int[] getPesomensual() {
        return pesomensual;
    }

    public void setPesomensual(int[] pesomensual) {
        this.pesomensual = pesomensual;
    }

    //-----Métodos-----
    //Contructor con pase de parámetros
    public Paciente(String rut, String nombre, int edad, char sexo){
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.pesomensual = new int[12];
        for (int i = 0; i < this.pesomensual.length; i++) {
            pesomensual[i] = (int) (Math.random() * (250 - 70 + 1)) + 70;
        }
    }

    //menorPesoMensual: retorna el mes en que el paciente peso menos kilos.
    public int menorPesoMensual(){
        int pesoMenor = pesomensual[0], mes = 0;
        for(int i = 1; i < pesomensual.length-1; i++) {
            if (pesomensual[i] < pesoMenor) {
                pesoMenor = pesomensual[i];
                mes = (i + 1);
            }
        }
        return mes;
    }

    /*indiceMasaCorporal: retorna el índice de masa corporal del paciente, para un mes x.
     índice de masa corporal = peso/estatura2 */
    public double indiceMasaCorporal(int mes, double estatura){
        int peso = pesomensual[mes - 1];
        return peso / (estatura * estatura);
    }

    //menosDeXKilos: retorna un nuevo array en el que se almacenan los meses en que el paciente pesó menos de X kilos.
    // Si nunca lo hizo, retorna null.
    public int[] menosDeXKilos(int peso){
        int[] menosK = new int[12]; //nuevo array
        int cont = 0;
        for (int i = 0; i < pesomensual.length; i++){
            if (pesomensual[i] < peso){
                menosK[cont] = pesomensual[i];
                cont++;
            }
        }
        return menosK;
    }

    /*pesoMesX: retorna la palabra normal, sobrepeso u obeso de acuerdo con el índice de masa corporal (IMC) obtenido en el mes del año se indique.
    (Debe usar método indiceMasaCorporal)
        15 <= IMC < 20     Normal
        20 <= IMC < 28     Sobrepeso
        IMC >= 28     Obeso */
    public String pesoMesX(int mes, double estatura){
        double imc = indiceMasaCorporal(mes, estatura);
        String resultado = " ";
        if(imc >= 15 && imc < 20){
            resultado = "Normal";
        }else if(imc >= 20 && imc < 28){
            resultado = "Sobrepeso";
        }else if(imc >= 28){
            resultado = "Obeso";
        }
        return resultado;
    }
}
