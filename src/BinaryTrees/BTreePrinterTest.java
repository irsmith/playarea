package binaryTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTreePrinterTest {

    private static Nod test1() {
        Nod root = new Nod(2);
        Nod n11 = new Nod(7);
        Nod n12 = new Nod(5);
        Nod n21 = new Nod(2);
        Nod n22 = new Nod(6);
        Nod n23 = new Nod(3);
        Nod n24 = new Nod(6);
        Nod n31 = new Nod(5);
        Nod n32 = new Nod(8);
        Nod n33 = new Nod(4);
        Nod n34 = new Nod(5);
        Nod n35 = new Nod(8);
        Nod n36 = new Nod(4);
        Nod n37 = new Nod(5);
        Nod n38 = new Nod(8);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;

        n21.left = n31;
        n21.right = n32;
        n22.left = n33;
        n22.right = n34;
        n23.left = n35;
        n23.right = n36;
        n24.left = n37;
        n24.right = n38;

        return root;
    }

    private static Nod test2() {
        Nod root = new Nod(2);
        Nod n11 = new Nod(7);
        Nod n12 = new Nod(5);
        Nod n21 = new Nod(2);
        Nod n22 = new Nod(6);
        Nod n23 = new Nod(9);
        Nod n31 = new Nod(5);
        Nod n32 = new Nod(8);
        Nod n33 = new Nod(4);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

        n12.right = n23;
        n22.left = n31;
        n22.right = n32;

        n23.left = n33;

        return root;
    }

    public static void main(String[] args) {

        Nod n32 = new Nod(8);
        Nod n33 = new Nod(4);
        System.err.println(n32.data < n33.data);
        
        BTreePrinter.printNode(test1());
        BTreePrinter.printNode(test2());

    }
}


class BTreePrinter {

    public static void printNode(Nod root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static  void printNodeInternal(List<Nod> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Nod> newNodes = new ArrayList<Nod>();
        for (Nod node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Nod node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static boolean isAllElementsNull(List<Nod> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
