/**
 * Define los atributos y funciones de cada persona.
 * @author (Dilian, Jose Alberto) 
 * @version (1)
 */
public class Persona
{

    boolean vive;
    Persona pareja;
    String cedu;
    String tipo_rol;
    String cedufFamPer;
    String nom;
    Persona next; //puntero en la lista de familiares
    Persona nextHijo;//puntero a los hijos de ambos
    Persona nexthijopro;//puntero a los hijos propios
    Persona cabezahijos;//cabeza de hijos propios
    Persona nexthijo_Adoptados;//puntero al siguente en la lista de hijos adoptados
    boolean used;
    public Persona()
    {
        vive=true;
        used=false;
        pareja=null;
        cedu="";
        tipo_rol="";
        cedufFamPer="";
        nom="";
        next=null; //puntero en la lista de familiares
        nextHijo=null;//puntero a los hijos de ambos
        nexthijopro=null;//puntero a los hijos propios
        cabezahijos=null;//cabeza de hijos propios
        nexthijo_Adoptados=null;
    }

    public Persona(String n)
    {
        vive=true;
        nom=n;
        used=true;
        cedu="";
        tipo_rol="";
        cedufFamPer="";
        pareja=null;
        next=null; //puntero en la lista de familiares
        nextHijo=null;//puntero a los hijos de ambos
        nexthijopro=null;//puntero a los hijos propios
        cabezahijos=null;//cabeza de hijos propios
        nexthijo_Adoptados=null;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String n){
        nom=n;

    }

    public boolean getVive(){
        return vive;
    }

    public String getCed(){
        return cedu;
    }

    public String cedufFam(){
        return cedufFamPer;  
    }

    public void setCed(String ce){
        cedu=ce;
    }

    public void cedufFam(String ce){
        cedufFamPer=cedufFamPer+ce+",";
    }

    public void setTipRol(String tr){
        tipo_rol=tipo_rol+tr;
    }

    public String getTipRol(){
        return tipo_rol;
    }

    /*
     * recibe una persona y lo agrega a la lista de hijos propios y no retorna nada
     */
    public void hijosPro(Persona pers){
        Persona ite;
        if(cabezahijos==null){               
            cabezahijos = pers;

        }else{  
            if(cabezahijos.nexthijopro==null){
                cabezahijos.nexthijopro=pers;

            }else{            
                ite=cabezahijos.nexthijopro;
                while(ite.nexthijopro!=null){
                    ite=ite.nexthijopro;
                }
                ite.nexthijopro=pers;

            } 
        }  

    }

}
