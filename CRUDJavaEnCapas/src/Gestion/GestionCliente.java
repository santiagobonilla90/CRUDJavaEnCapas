/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Gestion;

import CapaDatos.Conexion;
import Clases.Cliente;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author santiago
 */
public class GestionCliente implements IGestion{
    private Cliente cliente= new Cliente ("","","",0);

    public GestionCliente() {
        Conexion.setCadena("jdbc:mysql://localhost/facturacion");
        Conexion.setUsuario("root");
        Conexion.setClave("");        
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente (Cliente cliente){
        this.cliente=cliente;
    }
    
    public void Grabar() throws SQLException {        
        try{
        Conexion.GetInstancia().Conectar();
        Conexion.GetInstancia().Ejecutar("insert into cliente (cedula, nombre, direccion, cupo) values ('"+cliente.getCedula()+"','"+cliente.getNombre()+"','"+cliente.getDireccion()+"', "+cliente.getCupo()+")");
        Conexion.GetInstancia().Desconectar();    
        }
        catch(SQLException ex){
            throw ex;            
        }        
    }
    
    public void Modificar() throws SQLException {
       try{
        Conexion.GetInstancia().Conectar();
        Conexion.GetInstancia().Ejecutar("update cliente (cedula, nombre, direccion, cupo) values ('"+cliente.getCedula()+"','"+cliente.getNombre()+"','"+cliente.getDireccion()+"', "+cliente.getCupo()+")");
        Conexion.GetInstancia().Desconectar();    
        }
        catch(SQLException ex){
            throw ex;            
        }
    }
    
    public void Nuevo() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void Eliminar() throws SQLException {
        try{
        Conexion.GetInstancia().Conectar();
        Conexion.GetInstancia().Ejecutar("delete from cliente where cedula='"+cliente.getCedula()+"");
        Conexion.GetInstancia().Desconectar();    
        }
        catch(SQLException ex){
            throw ex;            
        } 
    }

    public void Consultar() throws SQLException {
         try{
        Conexion.GetInstancia().Conectar();
        Conexion.GetInstancia().Ejecutar("select * from  cliente");
        Conexion.GetInstancia().Desconectar();    
        }
        catch(SQLException ex){
            throw ex;
            
        }
    }    
}      