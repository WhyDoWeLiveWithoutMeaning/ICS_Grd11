package eric.projects.Trident;

public class Trident implements Comparable<Trident>{
    private int tineHeight;
    private int tineSpaces;
    private int handleHeight;

    public Trident(int t, int s, int h){
        tineHeight = t;
        tineSpaces = s;
        handleHeight = h;
    }

    public Trident(){
        tineHeight = 3;
        tineSpaces = 2;
        handleHeight = 4;
    }

    public int getTineHeight(){
        return tineHeight;
    }

    public void setTineHeight(int t){
        tineHeight = t;
    }

    public int getTineSpaces(){
        return tineSpaces;
    }

    public void setTineSpaces(int s){
        tineSpaces = s;
    }

    public int getHandleHeight(){
        return handleHeight;
    }

    public void setHandleHeight(int h){
        handleHeight = h;
    }

    public int getAsterisk(){
        return updateAsterisk();
    }

    private int updateAsterisk(){
        return (tineHeight * 3) + (tineSpaces*2+3) + handleHeight;
    }

    @Override
    public String toString(){
        String triDent = "";
        for(int i = 0; i < tineHeight; i++){
            for(int j = 0; j < 2; j++) {
                triDent += "*";
                for (int k = 0; k < tineSpaces; k++) {
                    triDent += " ";
                }
            }
            triDent += "*\n";
        }

        //Pattern 2
        for(int i = 0; i < tineSpaces*2+3; i++)
            triDent += "*";
        triDent += "\n";

        //Pattern 3
        for(int i = 0; i < handleHeight; i++){
            for(int j = 0; j < tineSpaces+1; j++){
                triDent += " ";
            }
            triDent += "*\n";
        }
        return triDent;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(!(o instanceof Trident))
            return false;

        Trident t = (Trident) o;

        if (tineHeight == t.getTineHeight() && tineSpaces == t.getTineSpaces() && handleHeight == t.getHandleHeight()) return true;
        else return false;
    }

    @Override
    public int compareTo(Trident t){
        if(t.getAsterisk() == updateAsterisk()) return 0;
        else if(t.getAsterisk() < updateAsterisk()) return 1;
        else return -1;
    }
}
