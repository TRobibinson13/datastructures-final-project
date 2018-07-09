package Classes;

public class TestCaseList<T>
{
    public Node firstNode;
    private int numberOfEntries;

    public TestCaseList()
    {
        firstNode = null;
        this.numberOfEntries = 0;
    }

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

    /**
    public boolean remove(int index)
    {
        int count = 0;
        if (index > (numberOfEntries - 1) || index < 0)
        {
            return false;
        }

        Node currentNode = firstNode;
        while(count != index)
        {
            currentNode = currentNode.getNodeAfter();
            count++;
        }

        currentNode.getNodeBefore().setNodeAfter(currentNode.getNodeAfter());
        currentNode.getNodeAfter().setNodeBefore(currentNode.getNodeBefore());
        currentNode = null;
        numberOfEntries--;
        return true;
    }

    public void clear()
    {
        int count = 0;
        Node currentNode = firstNode;

        while(currentNode.getNodeAfter() != null)
        {
            Node nodeToMeetDaleks = currentNode;
            currentNode = currentNode.getNodeAfter();
            nodeToMeetDaleks = null;
            numberOfEntries--;
        }
        if(currentNode.getNodeBefore() == null)
        {
            currentNode = null;
            numberOfEntries--;
        }
    }

    public void replace(int index, Node newNode)
    {
        int count = 0;
        Node currentNode = firstNode;

        if(index < 0 || index >= numberOfEntries)
        {
            while (count != index)
            {
                currentNode = currentNode.getNodeAfter();
            }
            currentNode.getNodeBefore().setNodeAfter(newNode);
            currentNode.getNodeAfter().setNodeBefore(newNode);
            currentNode = newNode;
        }
    }



    public boolean contains(Node anEntry)

    public int getLength()
    {
        return numberOfEntries;
    }

    public boolean isEmpty()
    {
        if(this.firstNode == 0)
        {
            return true;
        }
        return false;
    }

    public Node[] toArray()
    {
        Node testCasesArray[] = new Node[numberOfEntries];
        Node currentNode = firstNode;
        int count = 0;

        while(count <= numberOfEntries)
        {
            testCasesArray[count] = currentNode;
            currentNode = currentNode.getNodeAfter();
        }
        return testCasesArray;
    }
  **/
}
