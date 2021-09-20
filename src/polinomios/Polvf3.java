
package polinomios;

import java.util.Scanner;

public class Polvf3 extends Nodo {
    Nodo Punta;
    public Polvf3(){
        Punta=null;
    }
    
    public int getExp2(){
        return (Punta.getExp());
    }
    public float getCoe2(){
        return (Punta.getCoe());
    }
    public Nodo getLiga(){
        return (Punta.getLiga());
    }
    public void ingresarPol(){
        int j=0,tamano=0;
        float mayor;
        Scanner objeto= new Scanner(System.in);
        System.out.print("Ingrese el polinomio: ");
        String sCadena=objeto.next(), s="";
        char [] Vc=sCadena.toCharArray();
        int dimension=Vc.length;
        if(dimension<4){
            dimension+=3;
        }               
        String Vs[]=new String[dimension];
        
        for(int i=0;i<Vc.length;i++){
            if (Character.isDigit(Vc[i])|| Vc[i]=='-'){
                    String cadena = Character.toString(Vc[i]);
                    while((i+1)<Vc.length && Character.isDigit(Vc[i+1])){
                        String cadena2=Character.toString(Vc[i+1]);
                        cadena=cadena.concat(cadena2);
                        i++;
                    }
                    if(cadena.equals("-")){
                        cadena="-1";
                    }
                    Vs[j]=cadena;
                    j++;
                    //aqui pongo el numero de control
                    if(i==(Vc.length-1)&& Vc[i-1]!='^'){
                        Vs[j]="0";//el ultimo
                        j++;        
                    }else if((i+1)<Vc.length && i!=0){
                        if(Vc[i+1]!='x' && Vc[i-1]!='^'){
                            Vs[j]="0";
                            j++;
                        }
                    }else if(i==0 && Vc[i+1]!='x'){
                        Vs[j]="0";
                        j++;//este es para el primero
                    }
                    if((i+1)<Vc.length && Vc[i+1]=='x'){
                        if((i+2)<Vc.length){
                            if(!Character.isDigit(Vc[i+2]) && Vc[i+2]!='^'){
                                Vs[j]="1";
                                j++;   
                            }
                        }else{
                            Vs[j]="1";
                            j++;
                        }   
                    }
            }else if(Vc[i]=='+' && (i+1)<Vc.length){
                if(Vc[i+1]=='x'){
                    Vs[j]="1";
                    j++;
                    if((i+1)<Vc.length){
                        if(Vc[i+1]!='^'){
                             Vs[j]="1";
                            j++;
                        }
                    }else{
                        Vs[j]="1";
                        j++;
                        
                    }  
                } 
            }else if(i==0){
                if(Vc[i]=='x'){
                    Vs[j]="1";
                    j++;
                    if((i+1)<Vc.length){
                        if(Vc[i+1]!='^'){
                             Vs[j]="1";
                            j++;
                        }
                    }else{
                        Vs[j]="1";
                        j++;
                        
                    }
                }
                
            }
            
            
        }
        mayor=Float.parseFloat(Vs[1]);
        int n=0;
        for(int i=1;i<Vc.length;i+=2){
            if(Vs[i]!=null){
                n++;
                float  aux=Float.parseFloat(Vs[i]);
                if(aux>mayor){
                    mayor=aux;
                }
            }
        }
        n*=2;
        float vector[]=new float[n+6];
        int k=0;
        j=0;
        while(mayor>=0 && Vs[j]!=null){
            for(int i=1;i<Vs.length;i+=2){
                    if(Vs[i]!=null){
                        float aux=Float.parseFloat(Vs[i]);
                        if(mayor==aux){
                            float aux2=Float.parseFloat(Vs[i-1]);
                            vector[k]=aux2;
                            k++;
                            float aux3=Float.parseFloat(Vs[i]);
                            vector[k]=aux3;
                            k++;
                        }       
                    }
            }    
            mayor--;
        }
        for(int i=(vector.length-1);i>0;i-=2){
            float num=vector[i-1];
            if(num!=0){
                int exp=(int)vector[i];
                Nodo x;
                x= new Nodo(num,exp,Punta);
                x.setLiga(Punta);
                Punta=x;
            }
            
        }
        Nodo x;
        x= new Nodo(0,0,Punta);
        x.setLiga(Punta);
        Punta=x;
    }
    public void mostrar(){
        Nodo q= new Nodo();
        q=Punta;
        int condicion=0;
        
        while(q!=null){
            int exp=q.getExp();
            float num=q.getCoe();
            if(num!=0){
                if(num>0 && condicion!=0){
                    System.out.print("+");
                }
                if(num==1 && exp>0){
                    System.out.print("");
                }else if(num==-1 && exp!=0){
                    System.out.print("-");
                }else{
                    if(num==(int)num){
                       System.out.print((int)num);
                    }else{
                        System.out.print(num);
                    }        
                }
                if(exp==1){
                    System.out.print("x");
                }else if(exp==0){
                    System.out.print("");
                }else{
                    System.out.print("x^"+exp);
                }
                condicion=1;
            }
            q=q.getLiga();
        }
            
    }

    
    public void evaluar(float num){
        float total=0;
        Nodo q= new Nodo();
        q=Punta;
        while(q!=null){
             float coe=q.getCoe();
             int exp=q.getExp();
             float operacion=0;
             if(exp>0){
                operacion=num;
                int j=1;        
                while(j<exp){
                    operacion*=num; 
                    j++;
                }
            }else{
                operacion=1;
            }
            operacion*=coe;
            total+=operacion;
            q=q.getLiga();
        }
        if(total==(int)total){
            System.out.println("El total es: "+(int)total);
        }else{
            System.out.println("El total es: "+total);
        }
        
    }

    
    
    public void mostrarVec()
    {   Nodo q= new Nodo();
        q=Punta;
        while(q!=null){
            float coe=q.getCoe();
            int exp=q.getExp();
            if(coe!=0){
               System.out.print("["+coe+"]["+exp+"]");
               if(q.getLiga()!=null){
                    System.out.print("->");
               }
            }
            q=q.getLiga();
        }
    }

    
    public void sumar(Nodo A,Nodo B){
        Nodo q1= new Nodo();
        Nodo q2= new Nodo();
        q1=A.getLiga();
        q2=B.getLiga();
        int exp1,exp2,j=0,tamano;
        float num,num1,num2;
        float vector4[];
        if(q1.getExp()>=q2.getExp()){
            tamano=q1.getExp();
        }else{
            tamano=q2.getExp();
        }
        
        vector4=new float[tamano+4];
        
        while(q1!=null && q2!=null){
            num1=q1.getCoe();
            num2=q2.getCoe();
            exp1=q1.getExp();
            exp2=q2.getExp();
            float expF;
            if(exp1==exp2){
                num=num1+num2;
                q1=q1.getLiga();
                q2=q2.getLiga();
                expF=(float)exp1;
            }else if(exp1>exp2){
                num=num1;
                q1=q1.getLiga();
                expF=(float)exp1;
            }else{
                num=num2;
                expF=(float)exp2;
                q2=q2.getLiga();
            }
            vector4[j]=num;
            j++;
            vector4[j]=expF;
            j++;
            
        }
        if(q1!=null){
            while(q1!=null){
                num1=q1.getCoe();
                exp1=q1.getExp();
                vector4[j]=num1;
                j++;
                vector4[j]=exp1;
                j++;
                q1=q1.getLiga();
                
            }
        }else if(q2!=null){
            while(q2!=null){
                num2=q2.getCoe();
                exp2=q2.getExp();
                vector4[j]=num2;
                j++;
                vector4[j]=exp2;
                j++;
                q2=q2.getLiga();
            }
        }
        for(int i=(vector4.length-1);i>0;i-=2){
            float numFinal=vector4[i-1];
            if(numFinal!=0){
                int exp=(int)vector4[i];
                Nodo x;
                x= new Nodo(numFinal,exp,Punta);
                x.setLiga(Punta);
                Punta=x;
            }
        }
        Nodo x;
        x= new Nodo(0,0,Punta);
        x.setLiga(Punta);
        Punta=x;
    }
    public void dividir(Nodo A,Nodo B){
        Nodo q1= new Nodo();
        Nodo q2= new Nodo();
        q1=A.getLiga();
        q2=B.getLiga();
        int tamano=q1.getExp();
        int j=0;
        tamano*=2;
        tamano+=4;
        float vector[]=new float[tamano];
        boolean condicion=true;
        int condicion2;
        while(condicion==true){
            float num,num2;
            int exp,exp2;
            num=q1.getCoe()/q2.getCoe();
            exp=q1.getExp()-q2.getExp();
            vector[j]=num;
            j++;
            vector[j]=exp;
            j++;
            while(q2!=null){
              num2=q2.getCoe();
              exp2=q2.getExp();
              num2*=num;
              exp2+=exp;
              condicion2=operacion(num2,exp2,q1);
              q2=q2.getLiga();
              if(condicion2==1){
                q1=q1.getLiga();
              }else{
                Nodo y,q;
                y=buscarDondeInsertar(A,exp);
                num2*=(-1);
                Nodo x;
                x= new Nodo(num2,exp2,q1);
                if(y==null){
                    x.setLiga(q1);
                    q1=x;
                }else{
                    x.setLiga(y);
                    y.setLiga(x);
                }

              }
            }
            q2=B.getLiga();
            if(q1!=null){
               if(q1.getExp()<q2.getExp()){
                    condicion=false;
                 }
            }else{
                condicion=false;
            }
        }
        for(int i=(vector.length-1);i>0;i-=2){
            float numFinal=vector[i-1];
            if(numFinal!=0){
                int exp=(int)vector[i];
                Nodo x;
                x= new Nodo(numFinal,exp,Punta);
                x.setLiga(Punta);
                Punta=x;
            }
        }
        Nodo x;
        x= new Nodo(0,0,Punta);
        x.setLiga(Punta);
        Punta=x;
        
    }
    public int operacion(float num,int exp,Nodo A){
        Nodo q= new Nodo();
        q=A;
        int condicion2=0;
        while(q!=null){
            if(q.getExp()==exp){
                q.setCoe(-num);
                condicion2=1;
            }
            q=q.getLiga();
        }
        return condicion2;
        
    }
    
    public Nodo buscarDondeInsertar(Nodo A,int exp){
        Nodo y,l;
        l=A;
        y=null;
        while(l!=null && l.getExp()>exp){
            y=l;
            l=l.getLiga();
        }
        return y;
    }
    public void copia(Nodo A){
        Nodo q1= new Nodo();
        float vector2[];
        int tamano,j=0;
        q1=A.getLiga();
        tamano=q1.getExp();
        vector2=new float[tamano+4];
        while(q1!=null){
            float num;
            int exp;
            num=q1.getCoe();
            exp=q1.getExp();
            vector2[j]=num;
            j++;
            vector2[j]=exp;
            j++;
            q1=q1.getLiga();
        }
        for(int i=(vector2.length-1);i>0;i-=2){
            float num=vector2[i-1];
            if(num!=0){
                int exp=(int)vector2[i];
                Nodo x;
                x= new Nodo(num,exp,Punta);
                x.setLiga(Punta);
                Punta=x;
            }
        }
        Nodo x;
        x= new Nodo(0,0,Punta);
        x.setLiga(Punta);
        Punta=x;
        
    }
    public void multiplicar(Nodo A,Nodo B){
        Nodo q1= new Nodo();
        Nodo q2= new Nodo();
        q1=A.getLiga();
        q2=B.getLiga();
        int tamano=q1.getExp(),j=0;
        tamano+=q2.getExp();
        tamano*=2;
        float vector[]=new float[tamano+4];
        float num,exp;
        while(q2!=null){
            while(q1!=null){
                exp=q1.getExp()+q2.getExp();
                num=q1.getCoe()*q2.getCoe();
                q1=q1.getLiga();
                j=introducirDatos(exp,num,vector,j);
            }
            q2=q2.getLiga();
            q1=A.getLiga();
        }
        ordenarVector(vector);
        for(int i=(vector.length-1);i>0;i-=2){
            float num2=vector[i-1];
            if(num2!=0){
                int exp2=(int)vector[i];
                Nodo x;
                x= new Nodo(num2,exp2,Punta);
                x.setLiga(Punta);
                Punta=x;
            }
        }
        Nodo x;
        x= new Nodo(0,0,Punta);
        x.setLiga(Punta);
        Punta=x;
        
    }
    public int introducirDatos(float exp,float num,float vector[],int j){
        boolean condicion=false;
        for(int i=1;i<vector.length;i+=2){
            if(exp==vector[i]){
                if(vector[i-1]!=0){
                    num+=vector[i-1];
                    condicion=true;
                    vector[i-1]=num;
                }
            }
        }
        if(condicion==false){
            vector[j]=num;
            j++;
            vector[j]=exp;
            j++;
        }
        return j;
    }
    public void ordenarVector(float vector[]){
        float mayor=vector[1];
        int k=0;
        for(int i=1;i<vector.length;i+=2){
            if(vector[i]>mayor){
                mayor=vector[i];
            }
        }
        float vector2[]=new float[vector.length];
        while(mayor>=0){
            for(int i=1;i<vector.length;i+=2){
                    if(vector[i-1]!=0){
                        if(mayor==vector[i]){
                            vector2[k]=vector[i-1];
                            k++;
                            vector2[k]=vector[i];
                            k++;
                        }       
                    }
            }    
            mayor--;
        }
        vector=vector2;
        
    }
}
