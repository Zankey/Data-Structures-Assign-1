/**
 * Created by Trevor Marsano on 11/2/2016.
 */
public class A1233TMarRe<AnyType extends Comparable<? super AnyType>> implements Result{

    AnyType mode;
    int count = 0;

    public A1233TMarRe(){
        mode = this.mode();
        count = this.count();
    }

    public AnyType mode() {

        int count = 1;
        int count2 = 2;

        A1233TMarLI posItr = new A1233TMarLI(A1233TMarLL.header.next);
        A1233TMarLI travItr = new A1233TMarLI(posItr.current.next);
        A1233TMarLN<AnyType> newMode = posItr.current;

        while (posItr.isValid()) {
            while (travItr.isValid()) {
                if (travItr.current.element.equals(posItr.current.element)) {
                    count++;
                }

                travItr.advance();

                if (count > count2) {
                    newMode = travItr.current;
                    count2 = count;
                }
            }
        }
        return newMode.element;
    }

    public int count(){
        int count = 1;

        A1233TMarLI posItr;
        A1233TMarLI travItr = new A1233TMarLI(posItr.current.next);

        while ( posItr.isValid()) {
            while (travItr.isValid()) {
                if (travItr.current.element.equals(posItr.current.element)) {
                    count++;
                }
            }
        }
        return count;
    }
}

