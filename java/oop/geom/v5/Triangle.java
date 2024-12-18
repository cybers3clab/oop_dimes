package oop.geom.v5;

public class Triangle implements Figure2D,Cloneable {
    private  CartesianPoint2D p1;
    private  CartesianPoint2D p2;
    private  CartesianPoint2D p3;


    public Triangle(Point2D p1, Point2D p2, Point2D p3) {
        if(Point2DUtil.aligned(p1,p2,p3))
            throw  new IllegalArgumentException();
        this.p1 = new CartesianPoint2D(p1.getX(),p1.getY());
        this.p2 = new CartesianPoint2D(p2.getX(),p2.getY());
        this.p3 = new CartesianPoint2D(p3.getX(),p3.getY());
    }


    public double area() {
        double l1 = p1.distance(p2);

        double l2 = p2.distance(p3);
        double l3 = p3.distance(p1);
        double s = (l1 + l2 + l3) * 0.5;

        return Math.sqrt(s * (s - l1) * (s - l2) * (s - l3));

    }

    public double perimeter() {
        return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
    }

    public Point2D getP1() {
        return p1;
    }

    public Point2D getP2() {
        return p2;
    }

    public Point2D getP3() {
        return p3;
    }

    /**
     * Creates and returns a copy of this object.  The precise meaning
     * of "copy" may depend on the class of the object. The general
     * intent is that, for any object {@code x}, the expression:
     * <blockquote>
     * <pre>
     * x.clone() != x</pre></blockquote>
     * will be true, and that the expression:
     * <blockquote>
     * <pre>
     * x.clone().getClass() == x.getClass()</pre></blockquote>
     * will be {@code true}, but these are not absolute requirements.
     * While it is typically the case that:
     * <blockquote>
     * <pre>
     * x.clone().equals(x)</pre></blockquote>
     * will be {@code true}, this is not an absolute requirement.
     * <p>
     * By convention, the returned object should be obtained by calling
     * {@code super.clone}.  If a class and all of its superclasses (except
     * {@code Object}) obey this convention, it will be the case that
     * {@code x.clone().getClass() == x.getClass()}.
     * <p>
     * By convention, the object returned by this method should be independent
     * of this object (which is being cloned).  To achieve this independence,
     * it may be necessary to modify one or more fields of the object returned
     * by {@code super.clone} before returning it.  Typically, this means
     * copying any mutable objects that comprise the internal "deep structure"
     * of the object being cloned and replacing the references to these
     * objects with references to the copies.  If a class contains only
     * primitive fields or references to immutable objects, then it is usually
     * the case that no fields in the object returned by {@code super.clone}
     * need to be modified.
     *
     * @return a clone of this instance.
     * @throws CloneNotSupportedException if the object's class does not
     *                                    support the {@code Cloneable} interface. Subclasses
     *                                    that override the {@code clone} method can also
     *                                    throw this exception to indicate that an instance cannot
     *                                    be cloned.
     * @implSpec The method {@code clone} for class {@code Object} performs a
     * specific cloning operation. First, if the class of this object does
     * not implement the interface {@code Cloneable}, then a
     * {@code CloneNotSupportedException} is thrown. Note that all arrays
     * are considered to implement the interface {@code Cloneable} and that
     * the return type of the {@code clone} method of an array type {@code T[]}
     * is {@code T[]} where T is any reference or primitive type.
     * Otherwise, this method creates a new instance of the class of this
     * object and initializes all its fields with exactly the contents of
     * the corresponding fields of this object, as if by assignment; the
     * contents of the fields are not themselves cloned. Thus, this method
     * performs a "shallow copy" of this object, not a "deep copy" operation.
     * <p>
     * The class {@code Object} does not itself implement the interface
     * {@code Cloneable}, so calling the {@code clone} method on an object
     * whose class is {@code Object} will result in throwing an
     * exception at run time.
     * @see Cloneable
     */
    @Override
    public Object clone()  {

        try {
            Triangle t=(Triangle) super.clone();
            t.p1=(CartesianPoint2D) p1.clone();
            t.p2=(CartesianPoint2D) p2.clone();
            t.p3=(CartesianPoint2D) p3.clone();
            return  t;
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }
}
