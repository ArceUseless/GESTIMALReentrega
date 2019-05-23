/**
 * pruebaProducto.java
 * Programa para gestionar un almacén
 * usando la clase Producto definida en el fichero Producto.java
 * @author Alvaro García Fuentes
 * @author Rafael Jesús Nieto Cardador
 */
package GESTIMALMejorado;

import java.util.InputMismatchException;

public class PruebaProducto {
  
	/**
	 * Programa principal
	 * @param args
	 */
	public static void main( String[] args ){
   
	  Almacen almacen = new Almacen();
	  Menu menuIva = new Menu("Elige uno de los siguientes tipos de IVA:", new String [] {"GENERAL", "REDUCIDO", "SUPER REDUCIDO"});
	  Menu menuGeneral = new Menu("Elige una de las opciones del almacén:",new String [] {"Mostrar Almacén", "Alta", "Baja", "Modificación", "Entrada de Mercancía", "Salida de Mercancía", "Salir"});
    
	  
	  int opcion = 0;
	  int indice;
	  String d = "";
	  double pC = 0;
	  double pV = 0;
	  int s = 0;
	  String iva = "";
	  boolean error = false;
	  int codigo;
		//boolean salir = false;
		
		//Men
			
			do {
			  opcion = menuGeneral.gestionMenu();

					//Estructura switch para manejar el menú
				switch( opcion ){
				//Mostrar almacén
				case 1:
					System.out.println(almacen);
					break;
				/*
				case 2:
					//Mostrar producto
					System.out.println( "\n======MOSTRAR PRODUCTO======" );
					
					try {
						System.out.println( "Introduzca el código del producto." );
						codigo = Teclado.tecladoInt();
						if(almacen.devolverArticulo(codigo ) == null) {
						  System.out.println( "Producto no encontrado." );
						}else {
						  System.out.println( almacen.devolverArticulo( codigo ) );
						}
					} catch ( NumberFormatException e ) {
						System.out.println( "ERROR: Formato numérico incorrecto." );
					} catch (ArrayIndexOutOfBoundsException  i) {
						System.out.println( "ERROR: Codigo incorrecto." );
					} catch ( InputMismatchException ime) {
					  System.out.println( "ERROR: Error en la entrada de datos." );
					}
					break;
				*/
				case 2:
					// Alta
					System.out.println( "\n======DAR DE ALTA PRODUCTO======" );

					try {
					  d = Teclado.tecladoString("Introduzca la descripción del producto.");
						
					  pC = Teclado.tecladoDouble("Introduzca el precio de compra del producto.");
						
					  pV = Teclado.tecladoDouble("Introduzca el precio de venta del producto.");
						
					  s = Teclado.tecladoInt("Introduzca el stock del producto.");

					  iva = Iva.devuelveIva(menuIva.gestionMenu());
					  
					} catch (Exception e ){
            System.out.println( "ERROR: Entrada incorrecta." );
            break;
            
          }
					
					try {
					  Producto producto = new Producto( d , pC , pV , s, iva );
					  almacen.anadirArticulo(producto);     
					}catch(IvaInvalidoException iie) {
					  System.out.println("\nIvaInvalidoException: Este tipo de IVA no existe.");
					  break;
					}				
					System.out.println( "Producto añadido con éxito." );
					
					break;	
				
				case 3:
					// Baja
					System.out.println( "\n======DAR DE BAJA PRODUCTO======" );
			
					try {
						almacen.retirarArticulo(Teclado.tecladoInt("Introduzca el código del producto a eliminar." ));        
					} catch (Exception e) {
						System.out.println( "ERROR: Entrada incorrecta." );
						}
					break;
				case 4:
					// Modificar
					System.out.println( "\n======MODIFICAR EL PRODUCTO======" );
					
					try {
						indice = almacen.devolverIndice(Teclado.tecladoInt("Introduzca el código del producto a modificar"));					
 
						System.out.println( "Descripción: " + almacen.almacen.get(indice).getDescripcion() );
						almacen.almacen.get(indice).setDescripcion( Teclado.tecladoString("Nueva descripción: ") );
						
						System.out.println( "Precio de compra: " + almacen.almacen.get(indice).getPrecioCompra() );
						almacen.almacen.get(indice).setPrecioCompra( Teclado.tecladoDouble("Nuevo precio de compra: ") );
						
						System.out.println( "Precio de venta: " + almacen.almacen.get(indice).getPrecioVenta() );
						almacen.almacen.get(indice).setPrecioVenta( Teclado.tecladoDouble("Nuevo precio de venta: ") );
						
						System.out.println( "Stock: "+almacen.almacen.get(indice).getStock() );
						almacen.almacen.get(indice).setStock( Teclado.tecladoInt("Nuevo stock: ") );
						
						System.out.println( "Tipo de IVA: "+almacen.almacen.get(indice).getTipoDeIva() );
	                    iva = Iva.devuelveIva(menuIva.gestionMenu());
                        almacen.almacen.get(indice).setTipoDeIva( iva);
            
					}catch (IvaInvalidoException iie) {
					  System.out.println("\nIvaInvalidoException: Este tipo de IVA no existe.");
					  break;
          }catch (Exception e) {
						System.out.println( "ERROR: entrada incorrecta." );
						break;
					}
					break;
					
				case 5:
					// Entrada de mercancia
					System.out.println( "\n======ENTRADA DE MERCANC�A======" );
				  
					try {
						indice = almacen.devolverIndice(Teclado.tecladoInt("Introduzca el código del producto" ));
            almacen.almacen.get(indice).incrementarExistencias(Teclado.tecladoInt("Introduzca la cantidad que desea sumar al stock"));
            System.out.println( "Stock actualizado" );
						
					} catch (Exception e) {
						System.out.println( "ERROR: entrada incorrecta." );
						}
					break;
				case 6:
					// Salida de mercancia
					System.out.println( "\n======SALIDA DE MERCANC�A======" );
					
					try {
						indice = almacen.devolverIndice(Teclado.tecladoInt("Introduzca el código del producto"));
						almacen.almacen.get(indice).reducirExistencias(Teclado.tecladoInt("Introduzca la cantidad que desea restar al stock"));
						System.out.println( "Stock actualizado" );
					}catch(Exception e) {
						System.out.println( "ERROR: entrada incorrecta." );
						}
					break;

				case 7:
					// Salir del menu
					System.out.println( "Saliendo..." );
					break;
				}
			}while(opcion != 7);				
}
}