package Classes;

public class Node<T>
{
    private T data;
    private Node nodeBefore;
    private Node nodeAfter;

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

    public T getTestCaseData()
    {
        return data;
    }

    public void setTestCaseData(T testCaseData)
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