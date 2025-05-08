package com.prep4faang.prep.dsa.twopointer;

/******************************************************************************
 *  Lowest Common Ancestor of a Binary Tree III
 *
 *  Problem Statement (LeetCode 1650 adapted)
 *  ----------------------------------------------------
 *  You are given two nodes p and q in a binary tree.  
 *  Each node has a reference to its **parent** as well as (optionally) to its
 *  left and right child. **The root node itself is *not* provided.**
 *
 *  Return the *lowest common ancestor* (LCA) of p and q.  
 *  A node x is the LCA of p and q if
 *      – x is an ancestor of p and of q, and  
 *      – no descendant of x has this property.
 *
 *  A node can be its own ancestor (so if one node lies on the other’s path
 *  to the root, that node is the answer).
 *
 *  Constraints
 *  ----------------------------------------------------
 *  • –10⁴ ≤ Node.val ≤ 10⁴ (all values unique)  
 *  • 2 ≤ number of nodes ≤ 500  
 *  • p ≠ q, and both nodes exist in the tree
 *
 *  --------------------------------------------------------------------------
 *  Time complexity : O(h)    (h = height of tree)  
 *  Space complexity: O(1)    (only a few pointers / counters)
 ******************************************************************************/
public class LowestCommonAncestorIII {

    /*----------------------------------------------------------
     *  Node definition with parent pointer
     *---------------------------------------------------------*/
    static class Node {
        int val;
        Node left;
        Node right;
        Node parent;

        Node(int val) { this.val = val; }
    }

    public Node lowestCommonAncestor(Node p, Node q) {
        Node p_ptr = p;
        Node q_ptr = q;
        while(p_ptr != q_ptr){
            if(p_ptr.parent != null) p_ptr = p_ptr.parent;
            else p_ptr = q;
            if(q_ptr.parent != null) q_ptr = q_ptr.parent;
            else q_ptr = p;
        }
        return p_ptr;
    }

    public Node lowestCommonAncestor_sol1(Node p, Node q) {
        int depthP = depth(p);
        int depthQ = depth(q);

        /* Step 1 – ascend the deeper node until both depths match */
        while (depthP > depthQ) { p = p.parent; depthP--; }
        while (depthQ > depthP) { q = q.parent; depthQ--; }

        /* Step 2 – climb together until we meet */
        while (p != q) {
            p = p.parent;
            q = q.parent;
        }
        return p;        // or q – they are equal here
    }

    /** Helper: distance (#edges) from node to root. */
    private int depth(Node node) {
        int d = 0;
        while (node != null) { node = node.parent; d++; }
        return d;
    }
}
