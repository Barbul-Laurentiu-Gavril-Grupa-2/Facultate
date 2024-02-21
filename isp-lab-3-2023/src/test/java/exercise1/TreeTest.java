package exercise1;

import isp.lab3.exercise1.Tree;
import org.junit.Assert;

public class TreeTest {
    public void treegrowtest() {
        Tree tree = new Tree();

        tree.grow(15);
        System.out.println(tree.toString());
        Assert.assertEquals(30, tree.height);
    }
}
