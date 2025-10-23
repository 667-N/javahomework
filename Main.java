import java.util.*;
public class Main{
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<String>();
        colors.add("red");
        colors.add("blue");
        colors.add("yellow");
        colors.add("green");
        colors.add(0,"purple");
        for (int i = 0; i < colors.size(); i++)
        {
            int j = colors.size() - i - 1;
            System.out.println(colors.get(j));
        }
        System.out.println(colors.get(0));;
        colors.remove(0);
        for (int i = 0; i < colors.size(); i++)
        {
            int j = colors.size() - i - 1;
            System.out.println(colors.get(j));
        }
        System.out.println(colors.contains("purple"));;
        System.out.println(colors.isEmpty());;
        System.out.println(colors.size());;
        colors.add("magenta");
        colors.add("cyan");
        for (int i = 0; i < colors.size(); i++)
        {
            int j = colors.size() - i - 1;
            System.out.println(colors.get(j));
        }
        System.out.println(colors.size());;
        colors.trimToSize();
        colors.set(0, "black");
        for (int i = 0; i < colors.size(); i++)
        {
            int j = colors.size() - i - 1;
            System.out.println(colors.get(j));
        }
    }
}


