/**
 * Created by Trevor Marsano on 11/1/2016.
 */

public class A1233TMarLL<AnyType extends Comparable<? super AnyType>> {

    public A1233TMarLN<AnyType> header;

    public A1233TMarLL() {
        header = new A1233TMarLN (null);
    }

    public boolean isEmpty() {
        return header.next == null;
    }

    public void makeEmpty() {
        header.next = null;
    }

    public A1233TMarLI<AnyType> zeroth() {
        return new A1233TMarLI(header);
    }

    public A1233TMarLI<AnyType> first() {
        return new A1233TMarLI(header.next);
    }

    //Adds a new ListNode maintaining ascending order
    public void add( A1233TMarLN<AnyType> newNode ){
        A1233TMarLI<AnyType> itr = this.zeroth();

        //iterates over the linked list to find the insertion point that will maintain ascending order
        //breaks loop if it reaches the end of the list and inserts newNode there.
        while (itr.current.next != null && newNode.element.compareTo(itr.current.next.element) >= 0 ){
            itr.advance();
        }
        //Assigns newNode's .next to current.next before adding to the list so that link isn't broken
        newNode.next = itr.current.next;
        itr.current.next = newNode;
    }

    public <AnyType extends Comparable<? super AnyType>>
        boolean replace( A1233TMarLN<AnyType> oldNode, A1233TMarLN<AnyType> newNode){
        A1233TMarLI<AnyType> itr = new A1233TMarLI(header);


        while(itr.current.next != null){
            if(itr.current.next.element.equals(oldNode.element))
            {
                //ensures newNode's .next references oldNode's .next before re-assigning
                newNode.next = itr.current.next.next;
                itr.current.next = newNode;
                return true;
            }
            else
            {
               itr.advance();
            }
        }
        //item not found
        return false;
    }

    public void showList(){
        int count = 0;
        A1233TMarLI<AnyType> itr = this.first();

        if(this.isEmpty())
        {
            System.out.println("The list is currently empty");
        }

        else {
            while (itr.isValid()) {
                System.out.println(itr.retrieve());
                itr.advance();
                count++;
            }
        }
        System.out.println("There are " + count + " values in the list.\n");
    }

    //keeps track of how many prints have been done, and uses the count % num per line
    //to see if newline is needed avoiding nested for loop.
    public void showList( int num ){
        int count = 0;
        int modCount = 0;
        A1233TMarLI<AnyType> itr = this.first();

        if( this.isEmpty() )
        {
            System.out.println("The list is currently empty");
        }

        else {
            while (itr.isValid()) {
                    System.out.print(itr.retrieve() + " ");
                    itr.advance();
                    count++;
                    modCount++;

                if (modCount % num == 0){
                    System.out.println();
                }
            }
            //Formatting: makes sure last newline matches all other showList format possibilities
            if(count % num != 0)
            System.out.println();
        }
        System.out.println("There are " + count + " values in the list. \n");
    }

    public A1233TMarRe getMode(){
        return new A1233TMarRe();
    }


    private void insert(AnyType var1, A1233TMarLI<AnyType> var2) {
        if(var2 != null && var2.current != null) {
            var2.current.next = new A1233TMarLN(var1, var2.current.next);
        }
    }

    public A1233TMarLI<AnyType> find(AnyType var1) {
        A1233TMarLN var2;
        for(var2 = header.next; var2 != null && !var2.element.equals(var1); var2 = var2.next) {

        }

        return new A1233TMarLI(var2);
    }

    public A1233TMarLI<AnyType> findPrevious(AnyType var1) {
        A1233TMarLN var2;
        for(var2 = header; var2.next != null && !var2.next.element.equals(var1); var2 = var2.next) {

        }

        return new A1233TMarLI(var2);
    }

    public void remove(AnyType var1) {
        A1233TMarLI var2 = findPrevious(var1);
        if(var2.current.next != null) {
            var2.current.next = var2.current.next.next;
        }

    }

    public static <AnyType extends Comparable<? super AnyType>> void printList(A1233TMarLL<AnyType> var0) {
        if(var0.isEmpty()) {
            System.out.print("Empty list");
        } else {
            A1233TMarLI var1 = var0.first();

            while(var1.isValid()) {
                System.out.print(var1.retrieve() + " ");
                var1.advance();
            }
        }

        System.out.println();
    }

    public static <AnyType extends Comparable<? super AnyType>> int listSize(A1233TMarLL<AnyType> var0) {
        int var2 = 0;
        A1233TMarLI var1 = var0.first();

        while(var1.isValid()) {
            ++var2;
            var1.advance();
        }

        return var2;
    }

    public static void main(String[] var0) {

        A1233TMarLL myList = new A1233TMarLL();

        int var;

        for (var = 0 ; var < 10; var ++)
        {
            A1233TMarLN<Integer> var1 = new A1233TMarLN( var );
            myList.add(var1);
        }

        A1233TMarLN<Integer> var2 = new A1233TMarLN(5);
        A1233TMarLN<Integer> var3 = new A1233TMarLN(2);

        myList.showList();
        myList.showList(2);
        myList.showList(3);

        myList.replace( var3, var2);
        myList.showList(5);
    }
}
