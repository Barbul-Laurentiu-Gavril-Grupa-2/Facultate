package isp.lab3.exercise1;

public class Tree {
    private int height;
    public Tree()
    {
        this.height=15;
    }
    public void grow(int meters)
    {
        if(meters>=1)
            this.height+=meters;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Exercise1{" +
                "height=" + height +
                '}';
    }
}
