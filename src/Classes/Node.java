package Classes;
import java.lang.reflect.*;

public class Node<T>
{
    public T data;
    private Node nodeBefore;
    private Node nodeAfter;

    /**
     * T.R.
     * Constructor for a Node object that will be inserted into a CustomLinkedList
     * @param data the value(s) of the parsed object.
     */
    public Node(T data)
    {
        this(data,null, null);
    }

    public Node(T testCaseData,Node nodeBefore ,Node nodeAfter)
    {
        this.data = testCaseData;
        this.nodeBefore = nodeBefore;
        this.nodeAfter = nodeAfter;
    }

    public T getData()
    {
        return data;
    }

    public void getTestCaseData()
    {
        Field[] dataFields = this.data.getClass().getDeclaredFields();

        String[] results = new String[dataFields.length];

        int count = 0;
        for(Field field : dataFields)
        {
            System.out.println("The field is: ");
            System.out.println(field.getName());
            System.out.println();
        }
    }

    public void setData(T testCaseData)
    {
        this.data = testCaseData;
    }

    public Node getNodeBefore()
    {
        return this.nodeBefore;
    }

    public void setNodeBefore(Node nodeBefore)
    {
        this.nodeBefore = nodeBefore;
    }

    public Node getNodeAfter()
    {
        return this.nodeAfter;
    }

    public void setNodeAfter(Node nodeAfter)
    {
        this.nodeAfter = nodeAfter;
    }
}