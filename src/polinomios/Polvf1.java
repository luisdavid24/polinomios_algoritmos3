/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polinomios;

/**
 *
 * @author Anderson
 */

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Polvf1 {
    float vec[];
    int n;
    //Método constructor
    public Polvf1(){
        float vec[];
    }
    //Metodo de get dato
    public float getDato(int pos){
        return (vec[pos]);
    }
    //Metodo de set Dato
    public void setDato(float dato,int pos )
    {   vec[pos] = dato;
    }
    //metodo para ingresar los terminos
    public void ingresarPol(){
        int j=0,mayor;
        Scanner objeto= new Scanner(System.in);
        System.out.print("Ingrese el polinomio: ");
        String sCadena=objeto.next(), s="";
        char [] Vc=sCadena.toCharArray();
        int dimension=Vc.length;
        if(dimension<4){
            dimension+=3;
        }               
        String Vs[]=new String[dimension];
        int tamano=Vc.length;
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
        
        mayor=Integer.parseInt(Vs[1]);
        n=mayor;
        for(int i=1;i<Vc.length;i+=2){
            if(Vs[i]!=null){
                int aux=Integer.parseInt(Vs[i]);
                if(aux>mayor){
                    mayor=aux;
                }
            }
        }
        
        vec=new float[mayor+2];
        vec[0]=mayor;
        int k=1;
        j=1;
        
        while(mayor>=0 && Vs[j]!=null){
            if(Vs[j]!=null){
                int condicion=1;
                for(int i=1;i<Vs.length;i+=2){
                    if(Vs[i]!=null){
                        float aux=Float.parseFloat(Vs[i]);
                        if(mayor==aux){
                            float aux2=Float.parseFloat(Vs[i-1]);
                            vec[k]=aux2;
                            j+=2;
                            condicion=0;
                        }       
                    }
                    
                }    
                if(condicion==1){
                    vec[k]=0;
                }   
                k++;
                mayor--;
            }
        }
        
    }
    //Metodo de evaluar
    public void evaluar(float num){
        float total=0,operacion;
        for(int i=1;i<n+2;i++){
            float exp=n+1-i;
            if(exp>=1){
                operacion=num;
                int j=1;        
                while(j<exp){
                    operacion*=num; 
                    j++;
                }
            }else{
                operacion=1;
            }
            operacion*=vec[i];
            total+=operacion;
        }
        System.out.print("Resultado de la evaluación: "+total);
    }
    
    //metodo de sumar
    public void sumar(Polvf1 A,Polvf1 B){
        float expA,expB,posR;
        int k=1,j=1;
        int i=1;
        float my;
        if(A.getDato(0)>B.getDato(0)){
            my=A.getDato(0);
        }else{
            my=B.getDato(0);
        }
        //my=(int)my;
        int my2=(int)my;
        vec=new float[my2+2];
        vec[0]=my;
        while(k<A.getDato(0)+2 && j<B.getDato(0)+2){
            expA=A.getDato(0)+1-k;
            expB=B.getDato(0)+1-j;
            if(expA==expB){
                vec[i]=A.getDato(k)+B.getDato(j);
                k++;
                j++;
            }else if(expA>expB){
                vec[i]=A.getDato(k);
                k++;
            }else{
                vec[i]=B.getDato(j);
                j++;
            }
            i++;
        }
        this.ajustar();
        System.out.println("");
        
    }
    //Metodo redimensionar
    public void redimensionar(int exp)
    {
        int k=0, pos =exp+1, n=exp+2;
        float aux[] = new float[n];
        for (k=(int)vec[0]+1; k > 0; k--) {
            aux[pos] = vec[k];
            pos--;
        }
        vec = aux;
    }
    //Mostrar forma vector
    public void mostrarVec()
    {
        for (int i = 0; i < vec.length; i++) {
            System.out.print("[" +  vec[i] + "]");
        }
    }
    //Metodo de ingresar term
    public void IngresarTerm(int coef, int exp)
    {
        int pos = 0;
        if(exp < 0)
        {
            System.out.println("El exponente no es valido");
        }
        else
        {
            if(exp <= vec[0])
            {
                pos = (int)vec[0]+1-exp;
                if(vec[pos] == 0)
                {
                    vec[pos] = vec[pos]+coef;
                    this.ajustar();
                }
                else
                {
                    System.out.print("Ya existe un termino con este exponente.");
                }
            }
            else
            {
                this.redimensionar(exp);
                vec[0]=exp;
                vec[1]=coef;
            }
            for(int k=0;k<vec.length;k++)
            {
                System.out.print("[" + vec[k] + "]");
            }
        }
    }
    
    //Metodo de ajustar
    public void ajustar()
    {
        int cont = 0, j = 1;
        
        while(j < vec[0]+2 && vec[j] == 0)
        {
            cont++;
            j++;
        }
        float exp = vec[0]+1-j;
        for (int i = j; i < vec[0]+2; i++) {
            vec[i-cont] = vec[i];
        }
        vec[0] = exp;
    }
    //metodo de mostrar
    public void mostrar(){
        int condicion=0;
        for(int i=1;i<vec[0]+2;i++){
            float num=vec[i];
            if(num!=0){
                
                int exp=(int)vec[0]+1-i;
                if(i>1 && num>0 && condicion!=0){
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
            
        }
        
    }
    //Metodo de multiplicacion
    public void multiplicacion(Polvf1 A,Polvf1 B){
        float aux;
        int my,pos,expA,expB,grado;
        my=(int)A.getDato(0)+(int)B.getDato(0);
        vec=new float[my+2];
        vec[0]=my;
        for(int i=1;i<A.getDato(0)+2;i++){
            for(int j=1;j<B.getDato(0)+2;j++){
                expA=(int)A.getDato(0)+1-i;
                expB=(int)B.getDato(0)+1-j;
                aux=A.getDato(i)*B.getDato(j);
                grado=expA+expB;
                pos=(int)vec[0]+1-grado;
                vec[pos]+=aux;
            }
        }
    }
    //Metodo de hacer copia
    public void copia(Polvf1 A){
       int k,n;
       n=(int)A.getDato(0);
       vec=new float[n+2];
       for(k=0;k<n+2;k++){
            vec[k]=A.getDato(k);
       }
       
    }
    //Metodo de division 
    public void dividir(Polvf1 A,Polvf1 B){
        float expt,expa;
        float coet,coeA;
        if(A.getDato(0)>=B.getDato(0)){
            Polvf1 copia;  
            copia=new Polvf1();
            copia.copia(A);
            vec=new float[(int)A.getDato(0)-(int)B.getDato(0)+2];
            vec[0]=A.getDato(0)-B.getDato(0);
            
            while(copia.getDato(0)>=B.getDato(0)){
                expt=copia.getDato(0)-B.getDato(0);
                coet=copia.getDato(1)/B.getDato(1);
                int pos=(int)vec[0]+1-(int)expt;
                vec[pos]=coet;
                
                for(int k=1;k<(B.getDato(0)+2);k++){
                   expa=expt+B.getDato(0)+1-k;
                   coeA=coet*B.getDato(k);
                   coeA*=-1;
                   int pos2=(int)copia.getDato(0)+1-(int)expa;
                   copia.ingresar(pos2,coeA);
                   
                }
                copia.ajustar();
                
            }
        }else{
            System.out.print("No se puede dividir");
        }
       
    }
    
    public void ingresar(int pos, float num)
    {   vec[pos]+=num;
    }
}


