/**
 * Created by Trevor Marsano on 11/1/2016.
 */
public class A1233TMarLN<AnyType extends Comparable<? super AnyType>> {
    public AnyType element;
    public A1233TMarLN<AnyType> next;

    public A1233TMarLN(AnyType var1) {
        this(var1,  null);
    }

    public A1233TMarLN(AnyType var1, A1233TMarLN<AnyType> var2) {
        element = var1;
        next = var2;
    }
}