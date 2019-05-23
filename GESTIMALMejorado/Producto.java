/**
 * Producto.java
 * Definicion de la clase Producto
 * @author Alvaro Garcia Fuentes
 * @author Rafael Jesus Nieto Cardador
 */
package GESTIMALMejorado;

public class Producto{
  
  //Atributos de instancia
  private int codigo;
  private String descripcion;
  private double precioCompra;
  private double precioVenta;
  private int stock;
  
  private String tipoDeIva;

  //Atributo de clase
  private static int cuentaProductos = 0;

  /**
   * Constructor parametrico
   * @param d
   * @param pC
   * @param pV
   * @param s
   * @param iva
   * @throws IvaInvalidoException 
   */
  public Producto( String d , double pC , double pV , int s, String iva ) throws IvaInvalidoException{
    cuentaProductos++;
    setCodigo();
    setDescripcion(d);
    setPrecioCompra(pC);
    setPrecioVenta(pV);
    setStock(s);
    setTipoDeIva(iva);
    }

  // Getters
  /**
   * getter para codigo
   * @return int
   * @see setCodigo
   */
  public int getCodigo(){
    return this.codigo;
    }
  
  /**
   * getter para descripcion
   * @return String
   * @see setDescripcion
   */
  public String getDescripcion(){
    return this.descripcion;
    }

  /**
   * getter para precioCompra
   * @return double
   * @see setPrecioCompra
   */
  public double getPrecioCompra(){
    return this.precioCompra;
    }
  
  /**
   * getter para precioVenta
   * @return double
   * @see setPrecioVenta
   */
  public double getPrecioVenta(){
    return this.precioVenta;
    }
  
  /**
   * getter para stock
   * @return int
   * @see setStock
   */
  public int getStock(){
    return this.stock;
    }
  
  /**
   * getter para el tipo de IVA
   * @return String (contiene el tipo de IVA)
   */
  public String getTipoDeIva() {
    return this.tipoDeIva;
  }
  
  //Setters
  /**
   * setter para codigo
   * @see getCodigo
   */
  private void setCodigo(){
    this.codigo = cuentaProductos;
    }

  /**
   * setter para descripcion
   * @param d
   * @see getDescripcion
   */
  public void setDescripcion( String d ){
    this.descripcion = d;
    }
  
  /**
   * setter para PrecioCompra
   * @param pc
   * @see getPrecioCompra
   */
  public void setPrecioCompra( double pc ){
    if( pc < 0 ){
      this.precioCompra = 0;
      System.out.println( "ERROR: El precio de compra no puede ser negativo" );
    }else
      this.precioCompra = pc;
    }
  
  /**
   * setter para precioVenta
   * @param pv
   * @see getPrecioVenta
   */
  public void setPrecioVenta( double pv ){
    if( pv < 0 ){
      this.precioVenta = 0;
      System.out.println( "ERROR: El precio de venta no puede ser negativo." );
    }else
      this.precioVenta = pv;
    }
  
  /**
   * setter para stock
   * @param s
   * @see getStock
   */
  public void setStock( int s ){
    if( s < 0 ){
      this.stock = 0;
      System.out.println( "ERROR: El stock no puede ser negativo" );
    }else
      this.stock = s; 
    }
  
  /**
   * setter para el tipo de IVA
   * @param iva
   */
  public void setTipoDeIva(String iva) throws IvaInvalidoException {
    if(iva == null) {
      throw new IvaInvalidoException();
    }
    this.tipoDeIva = iva;
  }
  
  //Metodos  
  
  /**
   * Incrementa el stock del producto
   * @param c Cantidad que se suma al stock
   * @see reducirExistencias
   */
  public void incrementarExistencias( int c ){
    if( c < 0 )
      System.out.println( "ERROR: No se puede decrementar el stock." );
      
    this.setStock( this.getStock() + c );
    }
  /**
   * Decrementa el stock del producto
   * @param c Cantidad que se resta al stock
   * @see incrementarExistencias
   */
  public void reducirExistencias( int c ){ 
    if( this.getStock() - c < 0 ){
      System.out.println( "ERROR: El stock no puede ser negativo" );
    }else
      this.setStock( this.getStock() - c );
    }

  /**
   * Metodo toString de la clase
   * @return String
   */
  public String toString(){
    return "\nCodigo - " + this.codigo
        + "\nDescripcion - " + this.descripcion
        + "\nPrecio de compra - " + this.precioCompra
        + "\nPrecio de venta - " + this.precioVenta
        + "\nStock - " + this.stock
        + "\nTipo de IVA - "+ this.tipoDeIva + "\n";
    }
  
} // Fin de la clase Producto