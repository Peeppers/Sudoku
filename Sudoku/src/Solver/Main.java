package Solver;

import Grille.Grille;

public class Main {
    public static void main(String args[]){
        int[][] exCours = {{1,0,3,8,6,0,5,7,4},
                       {0,9,0,5,0,1,0,0,3},
                       {0,0,0,0,0,0,1,8,0},
                       {0,1,0,0,5,7,3,9,0},
                       {0,7,0,2,0,6,0,1,0},
                       {0,5,2,1,9,0,0,4,0},
                       {0,6,4,0,0,0,0,0,0},
                       {7,0,0,9,0,3,0,2,0},
                       {9,3,1,0,2,4,7,0,8}};
        int[][] expert = {{5,0,0,0,0,4,0,7,2},
                        {0,0,0,0,0,0,0,0,0},
                        {0,0,0,6,1,3,0,0,0},
                        {0,0,0,3,7,8,0,0,0},
                        {0,0,0,4,0,0,0,6,3},
                        {0,0,4,0,0,0,9,0,0},
                        {0,9,6,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,0,4},
                        {0,1,0,0,0,5,3,9,0}};

        Grille a=new Grille(exCours);
        Solver b=new Solver(a);
        System.out.println(b.toString());
        long t0=System.nanoTime();
        b.res();                            //0.649 ms
        long t1=System.nanoTime();
        System.out.println("Exemple cours : "+(t1-t0));
        System.out.println(b.toString());

        Grille c=new Grille(expert);
        Solver d=new Solver(c);
        System.out.println(d.toString());
        t0=System.nanoTime();
        d.res();                            // 9.671 ms
        t1=System.nanoTime();
        System.out.println("Expert : "+(t1-t0));
        System.out.println(d.toString());
    }
}