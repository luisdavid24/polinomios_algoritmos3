package polinomios;

public class Nodo {
    private int Exp;
    private float Coe;
    Nodo Liga;
    
    public Nodo(){
        Coe=0;
        Exp=0;
        Liga=null;
    }
    public Nodo(float Coe,int Exp,Nodo liga){
        this.Liga=Liga;
        this.Coe=Coe;
        this.Exp=Exp;
        
    }
    public float getCoe(){
        return Coe;
    }
    public void setCoe(float Coe){
        this.Coe=Coe;
    }
    public int getExp(){
        return Exp;
    }
    public void setExp(int Exp){
        this.Exp=Exp;
    }
    public Nodo getLiga(){
        return Liga;
    }
    public void setLiga(Nodo Liga){
        this.Liga=Liga;
    }
}
