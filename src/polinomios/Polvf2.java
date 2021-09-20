package polinomios;

import java.util.Scanner;

public class Polvf2 {
    float vec2[];

    public Polvf2(){
        float vec2[];
    }
    public float getDato(int pos){
        return (vec2[pos]);
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
        
        
        for(int i=0;i<Vs.length;i++){
            if(Vs[i]!=null){
                tamano++;
            }
        }
        tamano=tamano/2;
        vec2=new float[tamano*2+1];
        vec2[0]=(float)tamano;
        mayor=Float.parseFloat(Vs[1]);
        for(int i=1;i<Vc.length;i+=2){
            if(Vs[i]!=null){
                float  aux=Float.parseFloat(Vs[i]);
                if(aux>mayor){
                    mayor=aux;
                }
            }
        }
        int k=1;
        j=1;
        while(mayor>=0 && Vs[j]!=null){
            for(int i=1;i<Vs.length;i+=2){
                    if(Vs[i]!=null){
                        float aux=Float.parseFloat(Vs[i]);
                        if(mayor==aux){
                            float aux2=Float.parseFloat(Vs[i-1]);
                            vec2[k]=aux2;
                            k++;
                            float aux3=Float.parseFloat(Vs[i]);
                            vec2[k]=aux3;
                            k++;
                        }       
                    }
                    
                }    
                
            mayor--;
        }
        
    }
    
    public void evaluar(float num){
        float total=0,operacion;
        for(int i=2;i<vec2.length;i+=2){
            if(vec2[i]>0){
                operacion=num;
                int j=1;        
                while(j<vec2[i]){
                    operacion*=num; 
                    j++;
                }
            }else{
                operacion=1;
            }
            operacion*=vec2[i-1];
            total+=operacion;
        }
        if(total==(int)total){
            System.out.print("Resultado de la evaluaciÃ³n: "+(int)total);
        }else{
            System.out.print("Resultado de la evaluaciÃ³n: "+total);
        }
    }
    public void mostrarVec()
    {   int n=(int)vec2[0];
        for(int i=0;i<n*2+1;i++){
            if(vec2[i]==(int)vec2[i]){
                System.out.print("["+(int)vec2[i]+"]");
            }else{
                System.out.print("["+vec2[i]+"]");
            }
            
        }
    }
    public void mostrar(){
        int condicion=0;
        for(int i=2;i<vec2.length;i+=2){
            int exp=(int)vec2[i];
            float num=vec2[i-1];
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
    public void redimensionar()
    {
    	float n = vec2[0]*2+1;
    	n+=2;
    	float aux[] = new float[(int)n];
    	aux[0] = vec2[0]+1;
    	for (int i = 0; i < vec2[0]*2+1; i++) {
            aux[i] = vec2[i];
        }
    	
    	vec2 = aux;
    }
    public void InsertarTerm(float coef, float exp)
    {
    	int k=1,j;
    	while(k<vec2[0]*2+1 && vec2[k]>exp && vec2[k+1]!=0)
    	{
    		k=k+2;
    		
    	}
    	
    	if(k<vec2[0]*2+1 && vec2[k]==exp && vec2[k+1]!=0)
		{
    		if(vec2[k+1]+coef != 0)
        	{
        		vec2[k+1] = vec2[k+1]+coef;
        	}
        	else
        	{
        		for(j=k;j<vec2[0]*2-1;j+=2)
        		{
        			vec2[j] = vec2[j+2];
        			vec2[j+1] = vec2[j+3];
        		}
        		vec2[0] = vec2[0]-1;
        	}
		}
    	
    	else if(vec2[0]*2+1 == vec2[0]*2+1)
    	{
    		this.redimensionar();
    	}
    	
    	for(j= (int)vec2[0]*2; j>=k; j--)
    	{
    		vec2[j+2] = vec2[j];
    	}
    	vec2[k] = exp;
    	vec2[k+1] = coef;
    	vec2[0] = vec2[0]+1;
    }
    
    public void sumar(Polvf2 A,Polvf2 B){
        int tamano;
        if(A.getDato(0)>= B.getDato(0)){
            tamano=(int)A.getDato(0);
            for(int j=2;j<B.getDato(0);j+=2){
                int condicion=0;
                for(int i=1;i<A.getDato(0);i+=2){
                    if(B.getDato(j)==A.getDato(i)){
                        condicion=1;
                    }
                }
                if(condicion==0){
                    tamano+=2;
                }
            }
        }else{
            tamano=(int)B.getDato(0);
            for(int j=2;j<A.getDato(0);j+=2){
                int condicion=0;
                for(int i=2;i<B.getDato(0);i+=2){
                    if(B.getDato(j)==A.getDato(i)){
                        condicion=1;
                    }
                }
                if(condicion==0){
                    
                    tamano+=2;
                }
            }
        }
        vec2=new float[2*tamano+1];
        vec2[0]=(float)tamano/2;
        int m=1,j=2,i=2;
        while(j<((int)A.getDato(0)*2+1) && i<((int)B.getDato(0)*2+1)){
            float expA=A.getDato(j);
            float expB=B.getDato(i);
            float numA=A.getDato(j-1);
            float numB=B.getDato(i-1);
            if(expA==expB){
                vec2[m]=numA+numB;
                m++;
                vec2[m]=expA;
                j+=2;
                i+=2;
            }else if(expA>expB){
                vec2[m]=numA;
                m++;
                vec2[m]=expA;
                j+=2;
            }else{
                vec2[m]=numB;
                m++;
                vec2[m]=expB;
                i+=2;
            }
            m++;
        }
        if(i<B.getDato(0)+1){
            for(i=i;i<B.getDato(0)+1;i+=2){
                vec2[m]=B.getDato(i-1);
                m++;
                vec2[m]=B.getDato(i);
                m++;
            }
        }else if(j<A.getDato(0)+1){
            for(j=j;j<A.getDato(0)+1;j+=2){
                vec2[m]=A.getDato(j-1);
                m++;
                vec2[m]=A.getDato(j);
                m++;
                
            }
        }
    }
    public void multiplicar(Polvf2 A,Polvf2 B){
        int n=(int)A.getDato(2)+(int)B.getDato(2);
        int k=0;
        n=(n+1)*2;
        float vector2[]=new float[n];
        int nA=(int)A.getDato(0)*2+1;
        int nB=(int)B.getDato(0)*2+1;
        for(int i=1;i<nA;i+=2){
            float numA=A.getDato(i);
            float expA=A.getDato(i+1);
            for(int j=1;j<nB;j+=2){
                float numB=B.getDato(j);
                float expB=B.getDato(j+1);
                float numV=numA*numB;
                float expV=expA+expB;
                int condicion=0;
                
                for(int z=1;z<n;z+=2){
                    if(expV==vector2[z]){
                        if(vector2[z-1]!=0){
                            vector2[z-1]+=numV;
                            condicion=1;
                            
                        }
                    }
                }
                if(condicion==0){
                    vector2[k]=numV;
                    k++;
                    vector2[k]=expV;
                    k++;
                }
                
            }
        }
        int nv=0;
        for(int i=0;i<n;i+=2){
            if(vector2[i]!=0){
                nv++;
            }

        }
        vec2=new float[nv*2+2];
        vec2[0]=(float)nv;
        for(int i=0;i<(nv*2+1);i++){
            vec2[i+1]=vector2[i];
        }
        
        
    }
    
    public void dividir(Polvf2 A,Polvf2 B){
        if(A.getDato(2)>=B.getDato(2)){
            int n=(int)A.getDato(2)*2+1;
            int j=0;
            int nB=(int)B.getDato(0)*2+1;
            float vector2[]=new float[n];
            Polvf2 copia=new Polvf2();
            copia.copia(A);
            while(copia.getDato(2)>=B.getDato(2)){
                float exp,coe;
                exp=copia.getDato(2)-B.getDato(2);
                coe=copia.getDato(1)/B.getDato(1);
                vector2[j]=coe;
                vector2[j+1]=exp;
                j+=2;
                for(int i=1;i<nB;i+=2){
                    float coeA,expA;
                    coeA=coe*B.getDato(i);
                    expA=exp+B.getDato(i+1);
                    copia.operacion(coeA,expA);
                    copia.ajustar();
                    
                }
            }
            int nf=0;
            for(int i=0;i<n;i+=2){
                if(vector2[i]!=0){
                    nf++;
                }
            }
            vec2=new float[nf*2+1];
            vec2[0]=(float)nf;
            for(int i=1;i<(nf*2+1);i++){
                vec2[i]=vector2[i-1];
            }
            
        }else{
            System.out.print("No se puede dividir ");
        }
    }
    public void ajustar(){
        int cont = 0, j = 1;
        
        while(j < (int)vec2[0]*2+1 && vec2[j] == 0)
        {
            cont+=2;
            j+=2;
        }
        float datosUtiles =vec2[0]-(cont/2) ;
        for (int i = j; i < vec2[0]*2+1; i++) {
            vec2[i-cont] = vec2[i];
        }
        vec2[0] = datosUtiles;
    }
    public void operacion(float coeA,float expA){
        int condicion=0;
        for(int i=2;i<vec2[0]*2+1;i+=2){
            if(vec2[i]==expA){
                condicion=1;
                vec2[i-1]-=coeA;
            }
        }
        if(condicion==0){
            int n=(int)vec2[0]*2+3;
            float vector3[]=new float[n];
            vector3[0]=(int)vec2[0]+1;
            for(int i=2;i<vec2[0]*2+1;i+=2){
                if(vec2[i]>expA){
                   vector3[i]=vec2[i];
                   vector3[i-1]=vec2[i-1];
                }else{
                   vector3[i]=expA;
                   vector3[i-1]=coeA*(-1);
                   i+=2;
                   vector3[i]=vec2[i-2];
                   vector3[i-1]=vec2[i-3];
                }
            }
            vec2=vector3;
            
        }
        
    }
    public void copia(Polvf2 A){
        vec2=new float[(int)A.getDato(0)*2+1];
        for(int i=0;i<((int)A.getDato(0)*2+1);i++){
            vec2[i]=A.getDato(i);
        }
    }
        
    
}
