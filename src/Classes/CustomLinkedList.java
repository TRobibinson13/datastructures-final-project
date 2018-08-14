package Classes;

public class CustomLinkedList<T>
{
    public Node firstNode;
    private int numberOfEntries;

    /**
     * The Constructor for CustomLinkedList()
     */
    public CustomLinkedList()
    {
        firstNode = null;
        this.numberOfEntries = 0;
    }

    /**
     * Method to add a new Node to a CustomLinkedList() without specifying an index.
     * @param newNode the new node that is to be added to the list.
     */
    public void add(Node newNode)
    {
        if (firstNode == null)
        {
            firstNode = newNode;
        }

        else
        {
            Node currentNode = firstNode;
            while(currentNode.getNodeAfter() != null)
            {
                currentNode = currentNode.getNodeAfter();
            }
            currentNode.setNodeAfter(newNode);
            newNode.setNodeBefore(currentNode);
        }
        numberOfEntries++;
    }

    /**
     * Method to add a Node into the list at a specified index.
     * @param index the desired int index value for the newly added Node.
     * @param newNode The new Node that is to be created.
     * @return A boolean value of if the new node was successfully created.
     */
    public boolean add(int index, Node newNode)
    {
        if (index > (numberOfEntries +1) || index < 0)
        {
            return false;
        }

        else if(index == 0)
    {
        newNode.setNodeAfter(firstNode);
        firstNode.setNodeBefore(newNode);
        firstNode = newNode;
    }

    else if(index == numberOfEntries)
    {
        add(newNode);
        return true;
    }

    else
    {
        int count = 0;
        Node currentNode = firstNode;
        while(count != index)
        {
            currentNode = currentNode.getNodeAfter();
            count++;
        }
        newNode.setNodeBefore(currentNode.getNodeBefore());
        newNode.setNodeAfter(currentNode);
        currentNode.getNodeBefore().setNodeAfter(newNode);
        currentNode.setNodeBefore(newNode);
    }
        numberOfEntries++;
        return true;
    }

    public int getNumberOfEntries()
    {
        return numberOfEntries;
    }

    public void setNumberOfEntries(int index)
    {
        this.numberOfEntries = index;
    }

    /**
     * Increments the number of entries in the list @param numberOfEntries
     */
    public void incrementNumberOfEntries()
    {
        int index = getNumberOfEntries();
        setNumberOfEntries(index++);
    }

    public Node getNode(int index)
    {
        int count = 0;
        Node currentNode = firstNode;

        if(index < 0 || index >= numberOfEntries)
        {
            while (count != index)
            {
                currentNode = currentNode.getNodeAfter();
            }
            return currentNode;
        }
        return currentNode;
    }
}
