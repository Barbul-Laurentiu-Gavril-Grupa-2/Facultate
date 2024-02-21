package isp.lab3.exercise2;

public class Rectangle {
    private int length;
    private int width;
    private String color;
    public Rectangle(){
        this.length=2;
        this.width=1;
        this.color="red";
    }
    public Rectangle(int length,int width)
    {
        this.length=length;
        this.width=width;
        color = "red";
    }
    public Rectangle(int length,int width,String colors)
    {
        this.length=length;
        this.width=width;
        this.color=colors;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public String getColor() {
        return color;
    }

    public int getPerimeter() {
        return 2*(this.width+this.length);
    }
    public int getArea() {
        return this.width*this.length;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                ", color='" + color + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle(3 ,1);
        Rectangle rectangle3 = new Rectangle(3,6,"green");
    }
}
