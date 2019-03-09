package io.github.visitor;

import java.util.*;

//------ Interfaces
interface IShapeVisitor {
    void visit(Rectangle r);

    void visit(Circle c);
}

abstract class Shape {
    public abstract void accept(IShapeVisitor visitor);
}

//------ Shapes
class Rectangle extends Shape {
    public double height;
    public double width;

    Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public void accept(IShapeVisitor visitor) {
        visitor.visit(this);
    }
}

class Circle extends Shape {
    public double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void accept(IShapeVisitor visitor) {
        visitor.visit(this);
    }
}

//------ Visitors
class PerimeterVisitor implements IShapeVisitor {
    @Override
    public void visit(Rectangle r) {
        System.out.println((r.height + r.width) * 2);
    }

    @Override
    public void visit(Circle c) {
        System.out.println(2 * Math.PI * c.radius);
    }
}

class AreaVisitor implements IShapeVisitor {
    @Override
    public void visit(Rectangle r) {
        System.out.println(r.height * r.width);
    }

    @Override
    public void visit(Circle c) {
        System.out.println(Math.PI * Math.pow(c.radius, 2.));
    }
}

/**
 * visitor把结构和行为区分开，如果要为Shape增加action，只需要新增Visitor的实现类，然后通过accept传递即实现不同的处理方法
 */
public class VisitorTest {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(3, 4));
        shapes.add(new Circle(1));

        PerimeterVisitor perimeterVisitor = new PerimeterVisitor();
        shapes.forEach(x -> x.accept(perimeterVisitor));

        AreaVisitor areaVisitor = new AreaVisitor();
        shapes.forEach(x -> x.accept(areaVisitor));
    }
}