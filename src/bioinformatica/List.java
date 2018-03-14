package bioinformatica;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author Estudiante
 */
public class List 
{

    Node head = null;

    public boolean isEmpty() 
    {
        return head == null ? true : false;
    }

    public void printList() throws IOException 
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node temp = head;

        try {
            bw.write("Grades: \n");
            while (temp != null) 
            {
                bw.write(temp.ToString());
                temp = temp.next;

            }
            bw.flush();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }

    }

    public void insertAtBegin(Node newNode) {
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(Node newNode) {
        if (isEmpty()) 
        {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;

        }
    }

    public void insertAtPosition(Node newNode, int position) 
    {
        Node prev = head;
        for (int i = 0; i < position - 1; i++) 
        {
            prev = prev.next;
        }
        
        newNode.next = prev.next;
        prev.next = newNode;        
    }

    public void deleteAtPosition(int position) 
    {
        Node prev = head;
        for (int i = 0; i < position - 1; i++) 
        {
            prev = prev.next;
        }
        Node temp = prev.next;
        Node aft = temp.next;
        prev.next = aft;
        temp = null;
        System.gc();

    }

    public void deleteAtBegin() 
    {
        Node temp = head;
        head = head.next;
        temp = null;
        System.gc();
    }

    public void deleteAtEnd() 
    {
        Node temp = head;

        while (temp.next.next != null)
        {
            temp = temp.next;
        }
        temp.next = null;
        System.gc();
    }
    
    public Node searchByPosition(int position)
    {
        Node temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        return temp.next;
    }
    
//    public Node searchByValue(List lista,double value)
//    {
//        Node temp = head;
//        for (int i = 0; i < lista.; i++) 
//        {
//            temp = temp.next;
//        }
//    }

    
    public static void invertirLista(List lista)
    {
        Stack inversa = new Stack();
        Node temp = new Node();
        temp = lista.head;
            while (temp.next != null) {
                temp = temp.next;
                inversa.push(temp);
            }
            inversa.toString();
    }
    
    public void reverse()
    {
        Stack tempStack = new Stack();
        Node temp = head;
        while(temp!= null)
        {
            tempStack.push(temp.clone());
            temp=temp.next;
        }
        head=tempStack.head;
    }
    
    public static void main(String[] args) throws IOException 
    {

        List grades = new List();

        grades.insertAtBegin(new Node("Task 1", 3.5));
        grades.insertAtBegin(new Node("Quiz 1", 1.5));
        grades.insertAtBegin(new Node("Test1", 0.5));
        grades.insertAtBegin(new Node("Hola", 0.2));
        grades.printList();
        invertirLista(grades);
        grades.reverse();
        grades.printList();
        //grades.deleteAtPosition(1);
        //grades.deleteAtEnd();


    }

}
