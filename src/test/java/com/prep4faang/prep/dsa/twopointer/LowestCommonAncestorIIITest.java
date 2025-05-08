package com.prep4faang.prep.dsa.twopointer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LowestCommonAncestorIIITest {

    /* Utility method to wire parent pointers conveniently. */
    private static void link(LowestCommonAncestorIII.Node parent,
                             LowestCommonAncestorIII.Node left,
                             LowestCommonAncestorIII.Node right) {
        parent.left  = left;  if (left  != null) left.parent  = parent;
        parent.right = right; if (right != null) right.parent = parent;
    }

    @Test
    void sampleTreeTests() {
        // Build the following tree:
        //              3
        //          ┌───┴───┐
        //          5       1
        //       ┌──┴──┐ ┌──┴──┐
        //       6   2  0     8
        //          ┌┴┐
        //          7 4
        LowestCommonAncestorIII.Node n3 = new LowestCommonAncestorIII.Node(3);
        LowestCommonAncestorIII.Node n5 = new LowestCommonAncestorIII.Node(5);
        LowestCommonAncestorIII.Node n1 = new LowestCommonAncestorIII.Node(1);
        LowestCommonAncestorIII.Node n6 = new LowestCommonAncestorIII.Node(6);
        LowestCommonAncestorIII.Node n2 = new LowestCommonAncestorIII.Node(2);
        LowestCommonAncestorIII.Node n0 = new LowestCommonAncestorIII.Node(0);
        LowestCommonAncestorIII.Node n8 = new LowestCommonAncestorIII.Node(8);
        LowestCommonAncestorIII.Node n7 = new LowestCommonAncestorIII.Node(7);
        LowestCommonAncestorIII.Node n4 = new LowestCommonAncestorIII.Node(4);

        link(n3, n5, n1);
        link(n5, n6, n2);
        link(n1, n0, n8);
        link(n2, n7, n4);

        LowestCommonAncestorIII solver = new LowestCommonAncestorIII();

        // LCA(7,4) = 2
        assertEquals(n2, solver.lowestCommonAncestor(n7, n4));

        // LCA(6,4) = 5
        assertEquals(n5, solver.lowestCommonAncestor(n6, n4));

        // LCA(6,8) = 3
        assertEquals(n3, solver.lowestCommonAncestor(n6, n8));

        // LCA(5,5) = 5 (node is ancestor of itself)
        assertEquals(n5, solver.lowestCommonAncestor(n5, n5));
    }
}
