package Solver;

import Grille.Grille;

public class Solver {
    Grille grille;

    public Solver(Grille tab){
        this.grille=tab;
    }

    public boolean testLigne(int l, int num){
        for(int i=0;i< this.grille.getDim();i++) {
            if (this.grille.get(l,i)== num)return true;
        }
        return false;
    }

    public boolean testColonne(int col, int num){
        for(int i=0;i< this.grille.getDim();i++){
            if(this.grille.get(i,col)==num)return true;
        }
        return false;
    }

    public boolean testCarre(int l,int c, int num){
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                if (this.grille.get(i+l,j+c)== num) return true;
            }
        }
        return false;
    }

    public boolean testGrille(int l, int c, int num){
        return (!testLigne(l,num) && !testColonne(c,num)&& !testCarre(l-l%3,c-c%3,num));
    }

    public boolean res() {
        int[] pos = vNulle();
        if (pos[0] == -1) {
            return true;
        }
        int l = pos[0];
        int c = pos[1];
        for (int num = 1; num <= 9; num++) {
            if (testGrille(l, c, num)) {
                this.grille.set(l,c,num);
                boolean check = res();
                if (check == true) {
                    return true;
                }
                this.grille.set(l,c,0);
            }
        }
        return false;
    }

    public int[] vNulle(){
        int []pos=new int[2];
        pos[0]=-1;
        pos[1]=-1;

        for(int i=0;i<this.grille.getDim();i++){
            for (int j=0;j< this.grille.getDim();j++){
                if(this.grille.get(i,j)==0){
                    pos[0]=i;
                    pos[1]=j;
                    return pos;
                }
            }
        }
        return pos;
    }

    public String toString(){
        String str="";
        for (int i=0;i<3;i++) {
            str+=this.grille.get(i,0)+" "+this.grille.get(i,1)+" "+this.grille.get(i,2)+"|"+this.grille.get(i,3)+" "+this.grille.get(i,4)+" "+this.grille.get(i,5)+"|"+this.grille.get(i,6)+" "+this.grille.get(i,7)+" "+this.grille.get(i,8)+" "+"\n";
        }
        str+="-----------------\n";
        for (int i=3;i<6;i++) {
            str+=this.grille.get(i,0)+" "+this.grille.get(i,1)+" "+this.grille.get(i,2)+"|"+this.grille.get(i,3)+" "+this.grille.get(i,4)+" "+this.grille.get(i,5)+"|"+this.grille.get(i,6)+" "+this.grille.get(i,7)+" "+this.grille.get(i,8)+" "+"\n";
        }
        str+="-----------------\n";
        for (int i=6;i<9;i++) {
            str+=this.grille.get(i,0)+" "+this.grille.get(i,1)+" "+this.grille.get(i,2)+"|"+this.grille.get(i,3)+" "+this.grille.get(i,4)+" "+this.grille.get(i,5)+"|"+this.grille.get(i,6)+" "+this.grille.get(i,7)+" "+this.grille.get(i,8)+" "+"\n";
        }
        return str;
    }
}

