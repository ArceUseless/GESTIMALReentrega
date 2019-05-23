package GESTIMALMejorado;
/**
 * Clase MenuIva cuyo estado es un men�. Esta clase se encarga de proporcionar al usuario
 * algunas opciones para escoger el IVA y recoger su elecc�n. 
 * 
 *   Atributos
 *     opcion: Entero que almacena la elecci�n del usuario
 * 
 * @author Rafael Jes�s Nieto Cardador
 *
 */
public class Iva{
  //Atributos
  private int opcion;
  
  //Metodos
  public static String devuelveIva(int opcion) {
    switch(opcion) {
      case 1:
        return "general";
      case 2:
        return "reducido";
      case 3:
        return "super reducido";
      default:
        return null;        
    }
  }

}
