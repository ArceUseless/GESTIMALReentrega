package GESTIMALMejorado;

import java.util.Scanner;

public class Teclado {
  
  /**
   * Funcion para leer un double por teclado
   * @return double
   * @see tecladoInt, tecladoString
   */
  public static double tecladoDouble(String titulo){
    System.out.println(titulo);
    @SuppressWarnings("resource")
    Scanner teclado = new Scanner( System.in );   
    return teclado.nextDouble();
  }
  
  /**
   * Funcion para leer un entero por teclado
   * @return int
   * @see tecladoDouble, tecladoString
   */
  public static int tecladoInt(String titulo){
    System.out.println(titulo);
    @SuppressWarnings("resource")
    Scanner teclado = new Scanner( System.in );   
    return teclado.nextInt();
  }
  
  /**
   * Funcion para leer una cadena por teclado
   * @return String
   * @see tecladoDouble, tecladoInt
   */
  public static String tecladoString(String titulo){
    System.out.println(titulo);
    @SuppressWarnings("resource")
    Scanner teclado = new Scanner( System.in );   
    return teclado.nextLine();
  }

}
