package jcmaccesscurso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class SQL {
    //conexion a la base de datos access
    Access_connection access = new Access_connection();
            
    public SQL(){}   
    
//                                     NUEVOS REGISTROS
/* ------------------------------------------------------------------------------------- */
   public boolean NuevoAlumno(String[] datos){
       boolean ok=false;
       String instruccion_sql = "insert into ALUMNO(a_cu, a_nombre, a_paterno, a_materno, a_direccion, a_fono )" +
                " values(?,?,?,?,?,?);";
        ok = Agregar_Registro(datos, instruccion_sql);
       return ok;
   }
   
   public boolean Nueva_Asignatura(String[] datos){
       boolean ok=false;
       String instruccion_sql = "insert into asignatura( as_id, as_nombre )" +
                " values(?,?);";
       ok = Agregar_Registro(datos, instruccion_sql);
       return ok;
   }
   
   public boolean Nueva_Matricula(String[] datos){
       boolean ok=false;
       //comprueba que el alumno ya este matriculado
       int res = Existen_Filas("total","select count(*) as total from matricula where m_cu='"+datos[0]+"' and m_as='"+datos[1]+"' and m_gestion='"+datos[2]+"' ;");
       if(res==0){
        String instruccion_sql = "insert into matricula( m_cu, m_as, m_gestion )" +
                " values(?,?,?);";       
        ok = Agregar_Registro(datos, instruccion_sql);
       }       
       return ok;
   }
   
   public boolean setNota(String[] datos){
       boolean ok=false;
       String instruccion_sql = "update matricula set examen1=?, examen2=?, notafinal=? where m_cu=? and m_as=? and m_gestion=? ;";                
       ok = Agregar_Registro(datos, instruccion_sql);       
       return ok;
   }
   
   
//                                     ACTUALAZACION DE REGISTROS
/* ------------------------------------------------------------------------------------- */
    public boolean Actualizar_Alumno(String[] datos,String cu){
        boolean ok=false;
        String instruccion_sql = "update ALUMNO set a_nombre=?, a_paterno=?, a_materno=?, a_direccion=?, a_fono=? " +
               " where a_cu='"+cu+"' ;";          
        ok = Actualizar_Registro(datos,instruccion_sql);
        return ok;
    }
   
    public boolean Actualizar_Asignatura(String[] datos,String codigo){
        boolean ok=false;
        String instruccion_sql = "update asignatura set as_nombre=? " +
               " where as_id='"+codigo+"' ;";          
        ok = Actualizar_Registro(datos,instruccion_sql);
        return ok;
    }

//                                     ELIMINACION DE REGISTROS
/* ------------------------------------------------------------------------------------- */    
  public boolean eliminar_alumno(String cu){
    boolean ok=false;
    ok = eliminar_registro("ALUMNO", "a_cu='"+cu+"'");
    return ok;
  }  
    
   public boolean eliminar_Asignatura(String codigo){
    boolean ok=false;
    ok = eliminar_registro("asignatura", "as_id='"+codigo+"'");
    return ok;
  }  
      
//                                     DATOS DE REGISTROS
/* ------------------------------------------------------------------------------------- */    
    public String[] getDatosAlumno(String cu){
      String instruccion_sql = "select a_cu, a_nombre, a_paterno, a_materno, a_direccion, a_fono" +
                    " from alumno where a_cu = '"+cu+"'; ";
            //columnas de la tabla que se
     String[] colName = {"a_cu","a_nombre","a_paterno","a_materno","a_direccion","a_fono"};
     //se realiza la consulta
     String[] data = GetRegistro(colName, instruccion_sql);
     return data;
    }
     
    public String[] getDatosAsignatura(String codigo){
      String instruccion_sql = "select as_id, as_nombre " +
                    " from asignatura where as_id = '"+codigo+"'; ";
            //columnas de la tabla que se
     String[] colName = {"as_id","as_nombre"};
     //se realiza la consulta
     String[] data = GetRegistro(colName, instruccion_sql);
     return data;
    }

    public String[] getDatosAlumno2(){
     String[] data = GetColumna("alumno","a_cu","select a_cu from alumno");    
     return data;
    }
    
    public String[] getDatosAsignatura2(){
     String[] data = GetColumna("asignatura","as_id","select as_id from asignatura");    
     return data;
    }
   
//                                     PROCEDIMIENTOS SQL
/* ------------------------------------------------------------------------------------- */    
  public boolean Agregar_Registro(String[] datos, String instruccion_sql){
       boolean ok=false;       
       try {            
            PreparedStatement pstm = access.getConnection().prepareStatement(instruccion_sql);            
            for(int i=0;i<datos.length;i++){
                pstm.setString(i+1, datos[i]);
            }
            pstm.execute();
            pstm.close();            
            ok=true;
         }catch(SQLException e){
         System.out.println(e);
      }
       return ok;
   }
         
   private  boolean Actualizar_Registro(String[] datos,String instruccion_sql){
        boolean ok=false;        
        try {            
            PreparedStatement pstm = access.getConnection().prepareStatement(instruccion_sql);            
            for(int i=0;i<datos.length;i++){
                pstm.setString(i+1, datos[i]);
            }
            pstm.execute();
            pstm.close();            
            ok=true;
         }catch(SQLException e){
         System.out.println(e);
      }
        return ok;
    }
   
  private boolean eliminar_registro(String tabla, String condicion){
        boolean ok=false;        
        String instruccion = "delete from "+tabla+" where " + condicion + " ;";
        try {                
                PreparedStatement pstm = access.getConnection().prepareStatement(instruccion);                                   
                pstm.execute();
                pstm.close();            
                ok=true;
            }catch(SQLException e){                
            System.out.println(e);            
        }     
        return ok;
  }
     
  
  
  private String[] GetRegistro(String colName[], String sql){     
    String[] data = new String[colName.length];     
      try{         
         PreparedStatement pstm = access.getConnection().prepareStatement(sql);
         ResultSet res = pstm.executeQuery();         
         while(res.next()){            
            for(int j=0; j<=colName.length-1;j++){
                data[j] = res.getString(colName[j]);     
            }               
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }  
    
  
  public DefaultTableModel getDatosMatricula(String asignatura, String gestion){
    DefaultTableModel datos ;
    String[] columNames = {"C.U.","Alumno"};          
    String colName[] = {"cu","name"};        
    String origen = " alumno INNER JOIN matricula ON alumno.a_cu = matricula.m_cu ";
    String condicion = " where matricula.m_as='"+asignatura+"' and matricula.m_gestion='"+gestion+"'; ";
    Object[][] dtDatos = GetTabla(colName, origen + condicion, "" +
            "select matricula.m_cu as cu, (alumno.a_nombre  & ' ' & alumno.a_paterno & ' ' & alumno.a_materno) as name " +
            "from " + origen + condicion);
    datos = new DefaultTableModel(dtDatos,columNames);                        
    return datos;
  }

  
  public DefaultTableModel getDatosNotas(String asignatura, String gestion){
    DefaultTableModel datos ;
    String[] columNames = {"C.U.","Alumno","1er Examen","2do Examen","Nota Final"};          
    String colName[] = {"cu","name","e1","e2","nt"};        
    String origen = " alumno INNER JOIN matricula ON alumno.a_cu = matricula.m_cu ";
    String condicion = " where matricula.m_as='"+asignatura+"' and matricula.m_gestion='"+gestion+"'; ";
    Object[][] dtDatos = GetTabla(colName, origen + condicion, "" +
            "SELECT matricula.m_cu AS cu, (alumno.a_nombre & ' ' & alumno.a_paterno & ' ' & alumno.a_materno) AS name, matricula.examen1 AS e1, matricula.examen2 AS e2, matricula.notafinal AS nt " +
            "from " + origen + condicion);
    datos = new DefaultTableModel(dtDatos,columNames);    
    return datos;
  }
  
/*  METODO PARA OBTENER TODOS LOS DATOS DE UNA TABLA
*  parametros (Un array con los nombres de las columnas, el nombre de la tabla, la instruccion sql)
*/
public Object [][] GetTabla(String colName[], String tabla, String sql){
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = access.getConnection().prepareStatement("SELECT count(*) as total FROM " + tabla);
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
      
    Object[][] data = new String[registros][colName.length];  
    String col[] = new String[colName.length];
    
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{         
         PreparedStatement pstm = access.getConnection().prepareStatement(sql);
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){            
            for(int j=0; j<=colName.length-1;j++){
                col[j] = res.getString(colName[j]);
                data[i][j] = col[j];            
            }          
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }  

/* METODO PARA TODOS LOS DATOS DE UNA COLUMNA
 * parametros (Nombre de la tabla, nombre columna, instruccion sql )
 */
public String [] GetColumna(String tabla, String colName, String sql){
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = access.getConnection().prepareStatement("SELECT count(*) as total FROM " + tabla);
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
      
    String[] data = new String[registros];    
      try{         
         PreparedStatement pstm = access.getConnection().prepareStatement(sql);
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){            
            data[i] = res.getString(colName);
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }  

/* metodo para determinar si un registro dado la tabla, columna y el valor de busqueda, existe*/
   public boolean existe(String tabla, String columna, String valor){    
    boolean si_existe=false;
    int data =0;
      try{                  
         String instruccion = "select count(*) as total from "+tabla+" WHERE "+columna+"='"+valor+"';";
         PreparedStatement pstm = access.getConnection().prepareStatement(instruccion);
         ResultSet res = pstm.executeQuery();         
         while(res.next()){                        
            data = res.getInt("total");
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    if(data>0) si_existe=true;
    return si_existe;
 }  

   public int Existen_Filas(String colName, String sql){
    int filas=0;    
      try{         
         PreparedStatement pstm = access.getConnection().prepareStatement(sql);
         ResultSet res = pstm.executeQuery();         
         while(res.next()){                        
            filas = res.getInt(colName);
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return filas;
 }  
   
   public void Cerrar_Access(){
            access.desconectar();
   }

}
