//this program includes all possible functions of singly linked list along with reversing a linked list
//all edge cases are handled and tested

class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }


}
class LL {
    Node head;
    Node tail;

    LL() {
        head = tail = null;
    }

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;

        }
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;    //previously i said it null which was a wrong thing to do
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (head == null) {   //insert at head
            head = tail = newNode;
        } else if (position < 0) {
            System.out.println("invalid position");
            return;
        } else {
            int i;
            Node temp = head;
            for (i = 0; i < position - 1; i++) {

                temp = temp.next;
                if (temp == null)   //see its placement
                {
                    System.out.println("invalid position");
                    return;
                }

            }
            newNode.next = temp.next;
            temp.next = newNode;
            if (newNode.next == null) {
                tail = newNode;
            }


        }
    }


    public void deleteAtHead() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
    }

    public void deleteAtTail() {

        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;

        while (temp.next != tail) {
            temp = temp.next;
        }
        tail = temp;
        tail.next = null;
    }

    public void deleteAtPosition(int position) {
        Node prev = null;
        Node curr = head;
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        if (position == 0) {
            deleteAtHead();
            return;
        }
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }
        int i;
        for (i = 0; i < position && curr != null; i++) {

            prev = curr;
            curr = curr.next;
        }
        if (curr == null) {
            System.out.println("out of bounds");
            return;
        }
        if (curr.next == null) {
            tail = prev;
            if (prev != null) {
                prev.next = null;


            } else {
                head = tail = null;
            }
        } else {
            prev.next = curr.next;
            curr.next = null; //optional cuz of presence of garbage collector
        }

    }

    void deletingThroughData(int data) {
        Node curr = head;
        Node prev = null;
        if (head == null)  //empty ll
        {
            System.out.println("linked list is empty");
            return;
        }

        while (curr != null && curr.data != data) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) {
            System.out.println("Node with " + data + "do not exists");
            return;
        }
        if (curr == head)  //deletion at head
        {
            deleteAtHead();
            return;
        }
        if (curr.next == null)  //deletion at tail
        {
            tail = prev;
            if (prev != null) {
                prev.next = null;
            } else {
                head = tail = null;
            }
            return;
        } else {
            prev.next = curr.next;
        }
    }

    void print() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next == null) {
                System.out.print("->null");
            } else {
                System.out.print("->");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public void reverseList() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }

        tail = head;
        Node curr = head;
        Node prev = null;
        Node front = null;
        while (curr != null) {
            front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }


        head = prev;



    }
    public void removeCycle()
    {
        Node slow = head;
        Node fast = head;
        Node prev = null;
        boolean hasCycle = false;

        while(fast != null && fast.next!= null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow)
            {
                hasCycle = true;
                break;
            }
        }
        if( hasCycle == false)
        {
            System.out.println("No cycle exists");
            return;
        }

        if(fast == head)
        {
            while(fast.next != head)
            {
                fast = fast.next;
            }
            fast.next = null;
            return;
        }
        slow = head;
        while(fast != slow)
        {
            slow = slow.next;
            prev = fast;
            fast = fast .next;
        }
        //removing cycle
        prev.next = null;
    }

}


    public class Main {
        public static void main(String[] args) {

            LL l1 = new LL();
            l1.insertAtHead(1);
            l1.insertAtTail(2);
            l1.insertAtTail(3);
            l1.insertAtTail(4);
            l1.print();
//l1.insertAtPosition(5,4);
            l1.insertAtPosition(6, 2);
            l1.print();
            l1.deleteAtTail();
            l1.deleteAtHead();
            l1.print();
            l1.deletingThroughData(2);
            l1.print();
            l1.reverseList();
            l1.print();
            l1.removeCycle();

        }
    }
