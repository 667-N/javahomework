import java.util.*;
public class Main{
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<String>();
        colors.add("red");
        colors.add("blue");
        colors.add("yellow");
        colors.add("green");
        for (int i = 0; i < colors.size(); i++)
        {
            int j = colors.size() - i - 1;
            System.out.println(colors.get(j));
        }
    }
}


