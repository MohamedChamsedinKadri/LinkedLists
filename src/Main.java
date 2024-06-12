import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static  Scanner scanner = new Scanner(System.in);

    public static LinkedList<Character> Readstring(){
        System.out.println("Donner un string ");
        String input=scanner.nextLine();
        LinkedList<Character> list = new LinkedList<>();
        for (char ch : input.toCharArray()) {
            list.add(ch);
        }
        return list;
    }
    public static   void Writestring(LinkedList<Character> list){
        for (char c:list){
            System.out.print(c);

        }
        System.out.println();

    }
    public static void Clear(LinkedList<Character> list){
        list.clear();
    }
    public static int Len(LinkedList<Character> list){
        int length=0;
        Iterator<Character> iterator= list.iterator();
        while (iterator.hasNext()){length++;}
        return length;
    }
    public static boolean Equal(LinkedList<Character> list1, LinkedList<Character> list2){
        if (Len (list1)!=Len(list2)) return false;
        Iterator<Character> iterator1 = list1.iterator();
        Iterator<Character> iterator2 = list2.iterator();
        while (iterator1.hasNext() && iterator2.hasNext()) {
            if (!iterator1.next().equals(iterator2.next())) {
                return false;
            }
        }
        return true;

    }
    public static void Concatenate(LinkedList<Character> target, LinkedList<Character> list){
        target.addAll(list);
    }
    public static void Insert(LinkedList<Character> target, LinkedList<Character> list, int start){
        target.addAll(start, list);
    }

    public static int search(LinkedList<Character> target, LinkedList<Character> string, int start) {
        int targetLen = Len(target);
        int stringLen = Len(string);

        if (stringLen == 0 || targetLen == 0 || start >= targetLen) return -1;

        for (int i = start; i <= targetLen - stringLen; i++) {
            boolean found = true;
            for (int j = 0; j < stringLen; j++) {
                if (!target.get(i + j).equals(string.get(j))) {
                    found = false;
                    break;
                }
            }
            if (found) return i;
        }
        return -1;
    }
    public static void delete(LinkedList<Character> list, int start, int span) {
        for (int i = 0; i < span; i++) {
            if (start < Len(list)) {
                list.remove(start);
            }
        }
    }

    public static LinkedList<Character> substring(LinkedList<Character> list, int start, int span) {
        LinkedList<Character> sublist = new LinkedList<>();
        for (int i = start; i < start + span && i < Len(list); i++) {
            sublist.add(list.get(i));
        }
        return sublist;
    }



    public static void main(String[] args) {
        LinkedList<Character> A = new LinkedList<>();
        LinkedList<Character> B = new LinkedList<>();
        LinkedList<Character> C = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.print("Enter command->");
            command = scanner.nextLine().toUpperCase();

            switch (command) {
                case "R":
                    System.out.print("Enter string name ->");
                    String readName = scanner.nextLine().toUpperCase();
                    if (readName.equals("A")) {
                        A = Readstring();
                    } else if (readName.equals("B")) {
                        B = Readstring();
                    } else if (readName.equals("C")) {
                        C = Readstring();
                    }
                    break;
                case "W":
                    System.out.print("Enter string name ->");
                    String writeName = scanner.nextLine().toUpperCase();
                    if (writeName.equals("A")) {
                        Writestring(A);
                    } else if (writeName.equals("B")) {
                        Writestring(B);
                    } else if (writeName.equals("C")) {
                        Writestring(C);
                    }
                    break;
                case "C":
                    System.out.print("Enter target ->");
                    String targetName = scanner.nextLine().toUpperCase();
                    System.out.print("Enter string name ->");
                    String concatName = scanner.nextLine().toUpperCase();
                    if (targetName.equals("A")) {
                        if (concatName.equals("B")) {
                            Concatenate(A, B);
                        } else if (concatName.equals("C")) {
                            Concatenate(A, C);
                        }
                    } else if (targetName.equals("B")) {
                        if (concatName.equals("A")) {
                            Concatenate(B, A);
                        } else if (concatName.equals("C")) {
                            Concatenate(B, C);
                        }
                    } else if (targetName.equals("C")) {
                        if (concatName.equals("A")) {
                            Concatenate(C, A);
                        } else if (concatName.equals("B")) {
                            Concatenate(C, B);
                        }
                    }
                    break;
                case "Q":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }
}
