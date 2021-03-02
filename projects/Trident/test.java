package eric.projects.Trident;

import java.util.Arrays;

public class test {
    public static void main(String[] args){
        Trident[] t = new Trident[100];

        for (int i = 0; i < 100; i++){
            t[i] = new Trident((int)(Math.random() * 100 + 1), (int)(Math.random() * 100 + 1), (int)(Math.random() * 100 + 1));
        }

        for(Trident p : t){
            System.out.println(p.getAsterisk());
        }

        System.out.println();

        Arrays.sort(t);

        for(Trident p : t){
            System.out.println(p.getAsterisk());
        }
    }
}
