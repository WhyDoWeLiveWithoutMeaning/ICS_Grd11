package eric.projects.Dice;

class Dice {

    public static int roll(){
        return (int) (Math.random() * 6 + 1);
    }

    public static int roll(int rolls){
        int total = 0;
        for (int i = 0; i < rolls; i++){
            total += Math.random() * 6 + 1;
        }
        return total;
    }

    public static int roll(int rolls, int sides){
        int total = 0;
        for (int i = 0; i < rolls; i++){
            total += Math.random() * sides + 1;
        }
        return total;
    }
}
