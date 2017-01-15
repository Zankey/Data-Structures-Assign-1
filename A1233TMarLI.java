/**
 * Created by Trevor Marsano on 11/1/2016.
 */
public class A1233TMarLI<AnyType extends Comparable<? super AnyType>> {
    A1233TMarLN<AnyType> current;

    A1233TMarLI(A1233TMarLN<AnyType> var1) {
        current = var1;
    }

    public boolean isValid() {
        return current != null;
    }

    public AnyType retrieve() {
        return isValid()? current.element : null;
    }

    public void advance() {
        if(isValid()) {
            current = current.next;
        }

    }
}