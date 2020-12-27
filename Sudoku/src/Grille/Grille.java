package Grille;

public class Grille {

    private int [][] grille= new int[9][9];

    public Grille(){}

    public Grille(int[][] grille){
        this.grille=grille;
    }

    public String toString(){
        String str="";
        for (int i=0;i<3;i++) {
            str+=grille[i][0]+" "+grille[i][1]+" "+grille[i][2]+"|"+grille[i][3]+" "+grille[i][4]+" "+grille[i][5]+"|"+grille[i][6]+" "+grille[i][7]+" "+grille[i][8]+" "+"\n";
        }
        str+="-----------------\n";
        for (int i=3;i<6;i++) {
            str+=grille[i][0]+" "+grille[i][1]+" "+grille[i][2]+"|"+grille[i][3]+" "+grille[i][4]+" "+grille[i][5]+"|"+grille[i][6]+" "+grille[i][7]+" "+grille[i][8]+" "+"\n";
        }
        str+="-----------------\n";
        for (int i=6;i<9;i++) {
            str+=grille[i][0]+" "+grille[i][1]+" "+grille[i][2]+"|"+grille[i][3]+" "+grille[i][4]+" "+grille[i][5]+"|"+grille[i][6]+" "+grille[i][7]+" "+grille[i][8]+" "+"\n";
        }
        return str;
    }

    public int get(int i,int j){
        return grille[i][j];
    }

    public int getDim(){
        return 9;
    }

    public void set(int i,int j, int a){
        grille[i][j]=a;
    }

    public boolean TestLigne(int a){
        int[] test=new int[10];
        for (int j=0;j<9;j++){
            if(grille[a][j]<1 || grille[a][j]>9) return false;
            else if (test[grille[a][j]]==0) test[grille[a][j]]=1;
            else return false;
        }
        return true;
    }
    public boolean TestColonne(int a) {
        int[] test = new int[10];
        for (int i = 0; i < 9; i++) {
            if (grille[i][a] < 1 || grille[i][a] > 9) return false;
            else if (test[grille[i][a]] == 0) test[grille[i][a]] = 1;
            else return false;
        }
        return true;
    }

    public boolean TestCarre(int i,int j) {
        int[] test = new int[10];
        for (int k = 0; k < 9; k++) {
            if (grille[i+k%3][j+k/3] < 1 || grille[i+k%3][j+k/3] > 9) return false;
            else if (test[grille[i+k%3][j+k/3]] == 0) test[grille[i+k%3][j+k/3]] = 1;
            else return false;
        }
        return true;
    }

    public boolean TestGrille(){
        for (int i=0;i<9;i++){
            if(!TestLigne(i))return false;
        }
        for (int i=0;i<9;i++){
            if(!TestColonne(i)) return false;
        }
        for (int i=0;i<9;i+=3) {
            for (int j = 0; j < 9; j += 3) {
                if (!TestCarre(i, j)) return false;
            }
        }
        return true;
    }
}

