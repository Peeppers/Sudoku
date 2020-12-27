package Grille;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        int[][] aux = {{1,0,3,8,6,0,5,7,4},{0,9,0,5,0,1,0,0,3},{0,0,0,0,0,0,1,8,0},{0,1,0,0,5,7,3,9,0},{0,7,0,2,0,6,0,1,0},{0,5,2,1,9,0,0,4,0},{0,6,4,0,0,0,0,0,0},{7,0,0,9,0,3,0,2,0},{9,3,1,0,2,4,7,0,8}};
        int[][] auxRes = {{1,2,3,8,6,9,5,7,4},{8,9,7,5,4,1,2,6,3},{5,4,6,3,7,2,1,8,9},
                        {6,1,8,4,5,7,3,9,2},{4,7,9,2,3,6,8,1,5},{3,5,2,1,9,8,6,4,7},
                        {2,6,4,7,8,5,9,3,1},{7,8,5,9,1,3,4,2,6},{9,3,1,6,2,4,7,5,8}};
        int[][] auxRe = {{0,2,3,8,6,9,5,7,4},{8,9,7,5,4,1,2,6,3},{5,4,6,3,7,2,1,8,9},
                {6,1,8,4,5,7,3,9,2},{4,7,9,2,3,6,8,1,5},{3,5,2,1,9,8,6,4,7},
                {2,6,4,7,8,5,9,3,1},{7,8,5,9,1,3,4,2,6},{9,3,1,6,2,4,7,5,8}};
        Grille a=new Grille(auxRe);
        Grille b=new Grille(auxRes);
        Grille c=new Grille(aux);
        Scanner i=new Scanner(System.in);
        int x,y,v;

        while (!a.TestGrille()){
            System.out.println(a.toString());
            System.out.println("Insérez la ligne a modifié : ");
            x=Integer.valueOf(i.nextLine());
            System.out.println("Insérez la colonne a modifié : ");
            y=Integer.valueOf(i.nextLine());
            System.out.println("Insérez la valeur a introduir : ");
            v=Integer.valueOf(i.nextLine());
            a.set(x-1,y-1,v);
        }
        System.out.println("Sudoku résolue !");

        System.out.println(a.isCorrect(0,1,2));
    }
}
