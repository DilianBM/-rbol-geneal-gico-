/**
 * Contiene todos los metodos principales de la lista y se encarga de llamarlos a ejecucion. 
 * Comparte informacion con las clases Persona y Familia.
 * 
 * @author (Dilian, Jose Alberto) 
 * @version (1)
 */
import javax.swing.JOptionPane; 
public class Controlador
{
    Familia cabeza= new Familia();
    Persona Hijos=new Persona();
    Persona hijosadoptados=new Persona();
    int contadorFam=1;
    public Controlador()
    {

    }

    /*
     * este metodo no retorna nada y recibe una string la cual contiene imformacion para crear una familia y agregarles miembros y no retorna nada
     */
    public void crearFamilia(String fam){
        String vect[]=new String[100];
        vect=fam.split(",");
        Persona Per=new Persona();
        Persona ite;
        Familia iterador;
        int i=1;

        while(i<vect.length){
            if(cabeza.used==false){//caso en el nodo familiar no existe en la lista
                Per=new Persona(); 
                Per.setCed(""+contadorFam);
                contadorFam++;
                Per.cedufFam(vect[0]);
                Per.setNom(vect[i+1]);
                Per.setTipRol(vect[i]);
                Per.used=true;                
                cabeza = new Familia(vect[0], Per);
                i=i+2;
                if(cabeza.cabeza.next==null && Per.used==true && i<vect.length){//caso en el que ya exista un elemeto en la lista de mienbros, entonces lo coloca en el siguiente
                    Per=new Persona(vect[i+1]);  
                    Per.setCed(""+contadorFam);
                    contadorFam++;
                    Per.cedufFam(vect[0]);
                    Per.setTipRol(vect[i]);
                    cabeza.agregarFamiliar(Per);
                    i=i+2;
                }if(cabeza.cabeza.next!=null && i<vect.length){//caso en que hayan mas de dos miembros en la familia
                    ite=cabeza.cabeza;
                    while(ite.next!=null && ite.next.used!=false){
                        ite=ite.next;
                    }
                    Per=new Persona(vect[i+1]);
                    Per.setCed(""+contadorFam);
                    contadorFam++;
                    Per.cedufFam(vect[0]);
                    Per.setTipRol(vect[i]);
                    ite.next=Per;
                    i=i+2;
                }                  

            }else{
                if(cabeza.next==null && i<vect.length){//caso en el que ya exista una familia
                    Per=new Persona(); 
                    Per.setCed(""+contadorFam);
                    contadorFam++;
                    Per.cedufFam(vect[0]);
                    Per.setNom(vect[i+1]);
                    Per.setTipRol(vect[i]);
                    Per.used=true;                
                    cabeza.next = new Familia(vect[0], Per);
                    i=i+2;

                    if(cabeza.next.cabeza.next==null && Per.used==true && i<vect.length ){
                        Per=new Persona(vect[i+1]);  
                        Per.setCed(""+contadorFam);
                        contadorFam++;
                        Per.setTipRol(vect[i]);
                        Per.cedufFam(vect[0]);
                        cabeza.next.agregarFamiliar(Per);
                        i=i+2;
                    }else{
                        ite=cabeza.next.cabeza.next;
                        if(ite!=null && i<vect.length ){
                        while(ite!=null){
                            ite=ite.next;
                        }
                        Per=new Persona(vect[i+1]);
                        Per.setCed(""+contadorFam);
                        contadorFam++;
                        Per.setTipRol(vect[i]);
                        Per.cedufFam(vect[0]);
                        ite=Per;
                        i=i+2;
                    }  }   

                } else {// caso en el que hayan mas de dos familias
                    iterador=cabeza.next;
                    if(iterador!=null && i<vect.length ){
                    while(iterador.next!=null && i<vect.length){
                        iterador=iterador.next;
                    }
                    Per=new Persona(); 
                    Per.setCed(""+contadorFam);
                    contadorFam++;
                    Per.setNom(vect[i+1]);
                    Per.setTipRol(vect[i]);
                    Per.cedufFam(vect[0]);
                    Per.used=true;                
                    iterador.next= new Familia(vect[0], Per);
                    i=i+2;
                }
                    if(iterador.next.cabeza.next==null && i<vect.length ){
                        Per=new Persona(vect[i+1]);  
                        Per.setCed(""+contadorFam);
                        contadorFam++;
                        Per.setTipRol(vect[i]);
                        Per.cedufFam(vect[0]);
                        iterador.next.agregarFamiliar(Per);
                        i=i+2;
                    }else{
                        ite=cabeza.next.cabeza.next;
                        while(ite!=null && i<vect.length){
                            ite=ite.next;
                        }
                        Per=new Persona(vect[i+1]);
                        Per.setCed(""+contadorFam);
                        contadorFam++;
                        Per.setTipRol(vect[i]);
                        Per.cedufFam(vect[0]);
                        iterador.agregarFamiliar(Per);
                        i=i+2;
                    }

                }

            }                  

        }
    }

    /*
     * no retorna nada y recibe una string con informacion para añadir un hijo a la lista de hijos ambos  
     */
    public void nace(String per){
        String vect[]=new String[100];
        vect=per.split(",");

        Familia iterador = cabeza;
        Persona ite=iterador.hijos_Ambos;

        while(iterador.getCedula().equals((vect[0]))==false){// busca la familia en donde nace la persona
            iterador=iterador.next;
        }     

        if(iterador.hijos_Ambos==null){//caso en el que aun no hay hijos en la lista de hijos
            Hijos=new Persona(); 
            Hijos.setCed(""+contadorFam);
            contadorFam++;
            Hijos.setNom(vect[2]);
            Hijos.setTipRol(vect[1]);
            Hijos.cedufFam(vect[0]);
            Hijos.used=true;                
            iterador.hijos_Ambos = Hijos;

        }else{  if(iterador.hijos_Ambos.nextHijo==null){//caso en el que ya exista un hijo en lista de hijos
                Hijos=new Persona(vect[2]);  
                Hijos.setCed(""+contadorFam);
                contadorFam++;
                Hijos.setTipRol(vect[1]);
                Hijos.cedufFam(vect[0]);
                iterador.agregarListHijos(Hijos);

            }else{ // caso en el que ya exista mas de un hijo en lista de hijos          
                ite=iterador.hijos_Ambos;
                while(ite.nextHijo!=null && ite.nextHijo.used!=false){
                    ite=ite.nextHijo;
                }
                Hijos=new Persona(vect[2]);
                Hijos.setCed(""+contadorFam);
                contadorFam++;
                Hijos.setTipRol(vect[1]);
                Hijos.cedufFam(vect[0]);
                iterador.agregarListHijos(Hijos);;

            } 
        }  
    }

    /*
     * no retorna nada y recibe una string con informacion para añadir un hijo el cual va a la lista de hijos que ha adoptado   
     */
    public void adopta(String hijoAdop){
        String vect[]=new String[100];
        vect=hijoAdop.split(",");

        Familia iterador = cabeza;
        Persona ite=iterador.hijos_Adoptados;

        while(iterador.getCedula().equals((vect[0]))==false){//busca en que familia lo va a adoptar
            iterador=iterador.next;
        }     

        if(iterador.hijos_Adoptados==null){//caso en el que no hayan adoptado a nadie
            hijosadoptados=new Persona(); 
            hijosadoptados.setCed(""+contadorFam);
            contadorFam++;
            hijosadoptados.setNom(vect[2]);
            hijosadoptados.setTipRol(vect[1]);
            hijosadoptados.cedufFam(vect[0]);
            hijosadoptados.used=true;                
            iterador.hijos_Adoptados = hijosadoptados;

        }else{  if(iterador.hijos_Adoptados.nexthijo_Adoptados==null){// caso en el que ya se hubiera adoptado un hijo
                hijosadoptados=new Persona(vect[2]);  
                hijosadoptados.setCed(""+contadorFam);
                contadorFam++;
                hijosadoptados.setTipRol(vect[1]);
                hijosadoptados.cedufFam(vect[0]);
                iterador.hijos_Adoptados.nexthijo_Adoptados=hijosadoptados;

            }else{ //caso en el que ya se adopto mas de un hijo           
                ite=iterador.hijos_Adoptados.nexthijo_Adoptados;
                while(ite.nexthijo_Adoptados!=null && ite.nexthijo_Adoptados.used!=false){
                    ite=ite.nexthijo_Adoptados;
                }
                hijosadoptados=new Persona(vect[2]);
                hijosadoptados.setCed(""+contadorFam);
                contadorFam++;
                hijosadoptados.setTipRol(vect[1]);
                hijosadoptados.cedufFam(vect[0]);
                ite.nexthijo_Adoptados=hijosadoptados;

            } 
        }  

    }

    /*
     * recibe una string con imformacion de las personas a asociar y crea una nueva familia con los dos asociados y no retorna nada
     */
    public void asocie(String msg){
        Familia iterador=cabeza;
        String vect[]=new String[100];
        vect=msg.split(",");
        Familia ite=cabeza;
        Persona iterhijos=busquedaper(vect[1],vect[2]).cabezahijos;
        Persona iterahijopr=busquedaper(vect[3],vect[4]).cabezahijos;
        busquedaper(vect[1],vect[2]).setTipRol(vect[5]);//busca la primera persona a asociar
        busquedaper(vect[3],vect[4]).setTipRol(vect[5]);// busca la  segunda persona a asociar

        if((vect[1].equals(vect[3])==false) && (busquedaper(vect[1],vect[2]).vive==true) && (busquedaper(vect[3],vect[4]).vive==true) && (busquedaper(vect[3],vect[4]).pareja==null) && (busquedaper(vect[1],vect[2]).pareja==null)){
            while(iterador.next!=null){
                iterador=iterador.next;
            }
            busquedaper(vect[1],vect[2]).cedufFam(vect[0]);
            busquedaper(vect[3],vect[4]).cedufFam(vect[0]);
            iterador.next=new Familia(vect[0],busquedaper(vect[1],vect[2]),busquedaper(vect[3],vect[4]));
            busquedaper(vect[1],vect[2]).pareja=busquedaper(vect[3],vect[4]);
            busquedaper(vect[3],vect[4]).pareja=busquedaper(vect[1],vect[2]);

            while(iterhijos!=null){
                iterhijos.cedufFam(vect[0]);
                iterhijos=iterhijos.nexthijopro;
            }
            while(iterahijopr!=null){
                iterahijopr.cedufFam(vect[0]);
                iterahijopr=iterahijopr.nexthijopro;
            }

        }

    }

    /*
     * no retorna nada y recibe una string con la imformacion de las personas a desasociar y crea dos familias a partir de las dos personas desasociadas
     */
    public void desasocie(String msg){
        Familia iterador=cabeza;
        String vect[]=new String[100];
        vect=msg.split(",");

        int opcion;
        Persona itera;
        iterador.activa=false;
        if(busquedaper(vect[0],vect[1]).pareja!=null &&busquedaper(vect[0],vect[2]).pareja!=null ){//pregunta si esas dos personas si estan asociadas
            opcion=Integer.parseInt(JOptionPane.showInputDialog("1.si desea que persona:"+busquedaper(vect[0],vect[1]).getNom() + "tome los hijos como propios" +"/n2. si desea que persona:" + busquedaper(vect[0],vect[2]).nom + "tome los hijos como propios"));
            if(opcion==1){//la persona 1 toma los hijos como propios
                while(iterador.getCedula().equals(vect[0])==false){
                    iterador=iterador.next;
                }

                itera=iterador.hijos_Ambos;
                while(itera!=null){
                    busquedaper(vect[0],vect[1]).hijosPro(itera);
                    itera.cedufFam(busquedaper(vect[0],vect[1]).getCed());
                    itera=itera.nextHijo;
                }

                itera=iterador.hijos_Adoptados;
                while(itera!=null){
                    busquedaper(vect[0],vect[1]).hijosPro(itera);
                    itera.cedufFam(busquedaper(vect[0],vect[1]).getCed());
                    itera=itera.nextHijo;
                }

            } else {if(opcion==2){// la persona 2 toma los hijos como propios
                    while(iterador.getCedula().equals(vect[0])==false){
                        iterador=iterador.next;
                    }
                    itera=iterador.hijos_Ambos;
                    while(itera!=null){
                        busquedaper(vect[0],vect[2]).hijosPro(itera);
                        itera.cedufFam(busquedaper(vect[0],vect[2]).getCed());
                        itera=itera.nextHijo;
                    }     

                    itera=iterador.hijos_Adoptados;
                    while(itera!=null){
                        busquedaper(vect[0],vect[2]).hijosPro(itera);
                        itera.cedufFam(busquedaper(vect[0],vect[1]).getCed());
                        itera=itera.nextHijo;
                    }

                }
            }
            iterador=cabeza;
            while(iterador.next!=null){
                iterador=iterador.next;
            }

            iterador.next=new Familia(vect[3],(busquedaper(vect[0],vect[1])));
            iterador.next.next=new Familia(vect[4],(busquedaper(vect[0],vect[2])));
            busquedaper(vect[0],vect[1]).pareja=null;
            busquedaper(vect[0],vect[2]).pareja=null;
        }

    }

    /*
     * recibe una cedula familiar y una cedula personal y busca a la persona con esa informacion en la lista de familias y retonrna esa persona
     */
    public Persona busquedaper(String cedfam,String cedper){
        Familia iterador=cabeza;
        boolean encontrado=false;

        while(iterador.getCedula().equals(cedfam)==false){// itera hasta que encuentre la familia con la cedula familiar correspondiente
            iterador=iterador.next;
        }
        if(iterador.asociado1!=null){
            if(iterador.asociado1.getCed().equals(cedper)==true){
                return iterador.asociado1;

            }
            if(iterador.asociado2!=null){
                if(iterador.asociado2.getCed().equals(cedper)==true){
                    return iterador.asociado2;

                }}}

        Persona iteper=iterador.hijos_Ambos;
        if(iteper!=null){// rrecorre y pregunta si esa cedula personal correponde a la lista hijos ambos de esa familia
            while(iteper.nextHijo!=null){        
                if(iteper.getCed().equals(cedper)==true){
                    return iteper;
                }
                iteper=iteper.nextHijo;
            }
        }
        iteper=iterador.hijos_Adoptados;
        if(iteper!=null){// rrecorre y pregunta si esa cedula personal correponde a la lista hijos adoptados de esa familia
            while(iteper.nexthijo_Adoptados!=null){        
                if(iteper.getCed().equals(cedper)==true){
                    return iteper;
                }
                iteper=iteper.nexthijo_Adoptados;
            }
        }
        iteper=iterador.cabeza;
        Persona per=iteper.cabezahijos;

        while(iteper.next!=null){   
            if(iteper.getCed().equals(cedper)==true){
                return iteper;
            }
            if(per!=null){
                while(per.nexthijopro!=null){ 
                    if(per.getCed().equals(cedper)==true){
                        return per;
                    }
                    per=per.nexthijopro;
                }
            }

            iteper=iteper.next;

        }
        return iteper;

    }

    /*
     * recibe una string con la informacion de la persona que muere y no retorna nada
     */
    public void muerte(String muerto){
        Familia iterador=cabeza;
        String vect[]=new String[100];
        vect=muerto.split(",");
        Persona itera;
        if( busquedaper(vect[0],vect[1]).pareja!=null){

            while(iterador.getCedula().equals(vect[0])==false){
                iterador=iterador.next;
            }
            itera=iterador.hijos_Ambos;
            while(itera!=null){
                busquedaper(vect[0],vect[1]).pareja.hijosPro(itera);
                itera=itera.nextHijo;
            }     

            itera=iterador.hijos_Adoptados;
            while(itera!=null){
                busquedaper(vect[0],vect[1]).pareja.hijosPro(itera);
                itera=itera.nextHijo;
            }
            busquedaper(vect[0],vect[1]).pareja.pareja=null;//si esta asociado  desasocia la pareja
            busquedaper(vect[0],vect[1]).pareja=null;
            iterador.activa=false;//desactiva la familia
            busquedaper(vect[0],vect[1]).vive=false;

        }else{// sino si el no esta emparejado no desactiva la familia
            busquedaper(vect[0],vect[1]).vive=false;
        }

    }

    /*
     * recibe una string con la cedula de la familia a mostrar y retorna una string con todas las personas que personas que pertenecen a esa familia
     */
    public String show(String ced){
        Familia iterador =cabeza;
        Persona ite;
        String result="";
        while(iterador.getCedula().equals(ced)==false){//busca la familia a mostrar
            iterador=iterador.next;
        }

        if(iterador.hijos_Ambos!=null){//si hay hijos ambos los muestra
            ite=iterador.hijos_Ambos;
            while(ite!=null){
                result +="cedPersonal: "+ ite.cedu+" Rol: "+ite.tipo_rol+" Nom: "+ite.nom + " vive:"+ite.vive+"\n";
                ite=ite.nextHijo;
            } 
        }
        if(iterador.hijos_Adoptados!=null){// si hay hijos adoptados los mete en la string a imprimir
            ite =iterador.hijos_Adoptados;
            while(ite!=null){
                result += "cedPersonal: "+ite.cedu+" Rol: "+ite.tipo_rol+" Nom "+ite.nom+" vive:"+ite.vive+"\n";
                ite=ite.nexthijo_Adoptados;;
            } 
        }    

        Persona iteper=iterador.cabeza;
        Persona per=iteper.cabezahijos;

        while(iteper!=null){   
            result += "cedPersonal: "+iteper.cedu+" Rol: "+iteper.tipo_rol+" Nom: "+iteper.nom+" vive:"+iteper.vive+"\n";
            while(per!=null){//si hay hijos propios los mete en la string a retornar
                result += "cedPersonal: "+per.cedu+" Rol: "+per.tipo_rol+" Nom: "+per.nom+" vive:"+ per.vive+ "\n" ;
                per=per.nexthijopro;
            }

            iteper=iteper.next;

        }

        return result;

    }

    /*
     * no retorna nada y recibe la string con la ced familiar y la personal y imprime si esta viva y si esta asociada
     */
    public void consulta(String msg){
        Familia iterador=cabeza;
        String vect[]=new String[2];
        vect=msg.split(",");
        boolean vive=busquedaper(vect[0],vect[1]).vive;// busca la persona y averigua si vive o muere
        boolean asociado=false;
        if(busquedaper(vect[0],vect[1]).pareja!=null){
            asociado=true;

        }
        System.out.println("la persona esta viva? "+vive+" ,la persona esta asociada? "+asociado);
    }

    /*
     * no recibe y retorna una string de las personas no emparejadas en toda la familia
     */
    public String showSinEmparejar(){
        Familia iterador =cabeza;
        Persona ite;
        String result="";
        while(iterador!=null){
            if(iterador.hijos_Ambos!=null){
                ite=iterador.hijos_Ambos;
                while(ite!=null){
                    if(ite.pareja==null && ite.vive==true){
                        result += "cedPersonal: "+ite.cedu+" Rol: "+ite.tipo_rol+" Nom: "+ite.nom +"\n";
                    }
                    ite=ite.nextHijo;
                } 
            }
            if(iterador.hijos_Adoptados!=null){
                ite =iterador.hijos_Adoptados;
                while(ite!=null){
                    if(ite.pareja==null && ite.vive==true){
                        result += "cedPersonal: "+ite.cedu+" Rol: "+ite.tipo_rol+" Nom: "+ite.nom+"\n";
                    }
                    ite=ite.nexthijo_Adoptados;
                } 
            }    

            Persona iteper=iterador.cabeza;
            Persona per=null;
            if(iteper!=null){
                per=iteper.cabezahijos;
            }

            while(iteper!=null){  
                if(iteper.pareja==null && iteper.vive==true){
                    result += "cedPersonal: "+iteper.cedu+" Rol: "+iteper.tipo_rol+" Nom:"+iteper.nom+"\n";
                }
                while(per!=null){
                    if(per.pareja!=null && per.vive==true){
                        result += "cedPersonal: "+per.cedu+" Rol: "+per.tipo_rol+" Nom:"+per.nom+"\n";}
                    per=per.nexthijopro;
                }

                iteper=iteper.next;

            }
            iterador=iterador.next;
        }
        return result;

    }

    /*
     *  no recibe nada y retorna una string con las personas que estan emparejados en toda la familia
     */
    public String showEmparejados(){
        Familia iterador =cabeza;
        Persona ite;
        String result="";
        while(iterador!=null){
            if(iterador.hijos_Ambos!=null){
                ite=iterador.hijos_Ambos;
                while(ite!=null){
                    if(ite.pareja!=null){
                        result += "cedPersonal: "+ite.cedu+" Rol: "+ite.tipo_rol+" Nom: "+ite.nom +"\n";
                    }
                    ite=ite.nextHijo;
                } 
            }
            if(iterador.hijos_Adoptados!=null){
                ite =iterador.hijos_Adoptados;
                while(ite!=null){
                    if(ite.pareja!=null){
                        result += "cedPersonal: "+ite.cedu+" Rol: "+ite.tipo_rol+" Nom: "+ite.nom+"\n";
                    }
                    ite=ite.nexthijo_Adoptados;
                } 
            }    

            Persona iteper=iterador.cabeza;
            Persona per=null;
            if(iteper!=null){
                per=iteper.cabezahijos;
            }

            while(iteper!=null){  
                if(iteper.pareja!=null){
                    result += "cedPersonal: "+iteper.cedu+" Rol: "+iteper.tipo_rol+" Nom: "+iteper.nom+"\n";
                }
                while(per!=null){
                    if(per.pareja!=null){
                        result += "cedPersonal: "+per.cedu+" Rol: "+per.tipo_rol+" Nom: "+per.nom+"\n";}
                    per=per.nexthijopro;
                }

                iteper=iteper.next;

            }
            iterador=iterador.next;
        }
        return result;

    }

    /*
     * retorna una string con  todas las personas de todas las familias y no recibe nada
     */

    public String showpers(){
        Familia iterador =cabeza;
        Persona ite;
        String result="";
        while(iterador!=null){
            if(iterador.hijos_Ambos!=null){
                ite=iterador.hijos_Ambos;
                while(ite!=null){
                    result += "cedPersonal: "+ite.cedu+" Rol: "+ite.tipo_rol+" Nom "+ite.nom +" vive:"+ite.vive+"\n";                    
                    ite=ite.nextHijo;
                } 
            }
            if(iterador.hijos_Adoptados!=null){
                ite =iterador.hijos_Adoptados;
                while(ite!=null){
                    result += "cedPersonal: "+ite.cedu+" Rol: "+ite.tipo_rol+" Nom: "+ite.nom+" vive:"+ite.vive+"\n";
                }
                ite=ite.nexthijo_Adoptados;
            } 

            Persona iteper=iterador.cabeza;
            Persona per=null;
            if(iteper!=null){
                per=iteper.cabezahijos;
            }

            while(iteper!=null){                
                result += "cedPersonal: "+iteper.cedu+" Rol: "+iteper.tipo_rol+" Nom: "+iteper.nom+" vive:"+iteper.vive+"\n";                
                while(per!=null){
                    result += "cedPersonal: "+per.cedu+" Rol: "+per.tipo_rol+" Nom: "+per.nom+" vive:"+per.vive+"\n";
                    per=per.nexthijopro;
                }

                iteper=iteper.next;

            }
            iterador=iterador.next;
        }
        return result;

    }

    public static void main(String args[]){
        Controlador con=new Controlador();
        boolean seguir=true;
        do{
            int datos= Integer.parseInt(JOptionPane.showInputDialog("Escriba el numero del metodo que desea ejecutar Lea Recomendaciones \n 1.cree familia \n 2.nace\n 3.asocie\n 4.desasocie\n 5.adopta\n 6.muere\n 7.showfam \n 8.consultar(vive,estaAsociado)\n 9.para mostrar todas las personas  de todas las familias \n 10.salir\n  NOTA: \nRecuerde que para que una persona nazca debe existir una familia\n Recuerde que para asociar debe existir dos familias\n Recuerde que para desasociar dos personas deben existir al menos una pareja activa\n Recuerde que para muerte debe existir al menos una persona\n Recuerde que para poder adoptar debe existir una familia "));
            String info="";

            switch(datos){
                case 1:
                info=JOptionPane.showInputDialog("Ingrese datos: primer dato la cedula Familiar y luego con el siguiente patron  rol,nombre agregue las personas que desea. : \n cedula Familiar, rol en esa familia, nombre de la persona");
                System.out.println(info);
                con.crearFamilia(info);
                break;

                case 2:                
                info=JOptionPane.showInputDialog("Ingrese datos: cedula personal, rol en la familia, nombre de la persona"+"\n Recuerde que solo puede NACER en familias creadas");
                con.nace(info);
                break;

                case 3:
                System.out.println("lista de personas aptas para asociarse \n "+con.showSinEmparejar());
                info=JOptionPane.showInputDialog("Ingrese datos: cedula de la nueva familia, cedula familiar de la persona 1, cedula personal de "+
                    "la persona 1,cedula familiar de la persona 2, cedula personal de la persona 2, estado de la pareja");
                con.asocie(info);
                break;

                case 4:
                info=JOptionPane.showInputDialog("Ingrese datos: cedula familiar de la familia a desasociar,cedula de la persona 1,cedula de la persona 2, cedula de nueva familia "+
                    "persona 1, cedula de nueva familia de persona 2");
                con.desasocie(info);
                break;

                case 5:
                info=JOptionPane.showInputDialog("Ingrese datos: cedula de persona adoptada, rol en la familia, nombre de la persona"+"\n recuerde que para adoptar debe existir al menos UNA FAMILIA");
                con.adopta(info);
                break;

                case 6:
                info=JOptionPane.showInputDialog("Ingrese datos: cedula familiar, cedula personal");
                con.muerte(info);
                break;

                case 7:
                info=JOptionPane.showInputDialog("Ingrese la cedula de la familia que desea imprimir");
                System.out.println("Familia: "+info+ "\n"+con.show(info));
                break;

                case 8:
                con.showpers();
                info=JOptionPane.showInputDialog("Ingrese la cedula de la familiar y la cedula personal de la persona a consultar");
                con.consulta(info);

                break;

                case 9: 
                System.out.println("todas las personas: \n "+con.showpers());

                break;
                case 10: 
                seguir=false;	
                default: JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna opcion");

            }
        } while(seguir);

        //         con.crearFamilia("1,h,mar,c,andres,c,carlos");
        //         con.crearFamilia("3,h,andrea,c,pablo");
        //         con.crearFamilia("5,h,karla,c,lourdes");
        //         con.crearFamilia("6,c,lucia,h,an");
        //         con.nace("1,h,marcos");
        //         con.nace("1,h,al");
        //         con.nace("1,h,alejandra");
        //         con.nace("1,h,juan");
        //         con.nace("3,h,t");
        //         con.nace("3,h,ema");
        //         con.adopta("1,h,fabiola");
        //con.adopta("1,h,andres");
        //         con.adopta("1,h,kim");
        //         con.asocie("8,5,6,1,2,ul");
        //         con.nace("8,h,m");
        //         con.nace("8,h,pedro");
        //         con.nace("8,h,carla");
        //         con.adopta("8,h,k");
        //  con.muerte("8,2");//cedufam,cedpersonal
        //         System.out.println(con.showEmparejados());
        //         //con.asocie("9,7,1,5,7,ul");
        //         System.out.println();
        //con.desasocie("8,6,2,7,9");

    }
}
