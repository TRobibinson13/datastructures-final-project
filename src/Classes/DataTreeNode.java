package Classes;

public class DataTreeNode<T>
{
    private int key;
    private T value;

    DataTreeNode leftChild;
    DataTreeNode rightChild;

    DataTreeNode(int key, T value)
    {
        this.key = key;
        this.value = value;
    }

    public int getKey()
    {
        return key;
    }

    public T getValue()
    {
        return value;
    }

}
