/**
 * Define los atributos y funciones de cada familia.
 * 
 * @author (Dilian, Jose Alberto) 
 * @version (1)
 */
public class Familia
{
    boolean used;
    boolean activa;
    Persona cabeza;
    Persona asociado1;
    Persona asociado2;
    Persona hijos_Ambos;
    Persona hijos_Adoptados;     
    String cedulaFamiliar;
    Familia next;

    //Constructor que se utiliza cuando se crea una familia.
    public Familia(String cedulaFam,Persona per,Persona per2)
    {
        cedulaFamiliar = cedulaFam;
        used = true;
        activa = true;
        asociado1 = per;
        asociado2 = per2;
        //cabeza=per;
        hijos_Ambos=null;
        hijos_Adoptados=null;    
        next=null;
    }

    public Familia()
    {
        used = false;
        activa = true;
    }
    
    
      
     //Constructor que se utiliza cuando se crea una familia asociada.
    public Familia(String cedula, Persona head)
    {
        cedulaFamiliar = cedula;
        cabeza = head;
        used = true;
        activa = true;
        asociado1=null;
        asociado2 = null;
        hijos_Ambos=null;
        hijos_Adoptados=null;    
        next=null;
    }

    //Metodo que recibe un objeto de tipo persona y lo agrega al final de la lista de familiares.
    public void agregarFamiliar(Persona familiar){
        Persona ite;

        if(cabeza.next==null && used==true){
            cabeza.next = familiar;

        }else{
            ite=cabeza.next;
            while(ite.next!=null){
                ite=ite.next;
            }
            ite.next=familiar;
        }                  

    }

    //Metodo que recibe un objeto de tipo persona y lo agrega al final de la lista de hijos.
    public void agregarListHijos(Persona hijo){
        Persona ite;

        if(hijos_Ambos.nextHijo==null && used==true){
            hijos_Ambos.nextHijo = hijo;

        }else{
            ite=hijos_Ambos.nextHijo;
            while(ite.nextHijo!=null){
                ite=ite.nextHijo;
            }
            ite.nextHijo=hijo;
        }                  

    }

    public String getCedula(){
        return cedulaFamiliar;
    }

}
