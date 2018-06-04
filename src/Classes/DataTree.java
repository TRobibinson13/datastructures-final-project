package Classes;

public class DataTree<T>
{
    DataTreeNode root;

    public void addDataTreeNode(int key, T value)
    {
        DataTreeNode newDataTreeNode = new DataTreeNode(key, value);

        if(root == null)
        {
            root = newDataTreeNode;
        }
        else
        {
            DataTreeNode parent;
            DataTreeNode targetNode = root;

            while(true)
            {
                parent = targetNode;

                if(key < targetNode.getKey())
                {
                    targetNode = targetNode.leftChild;

                    if(targetNode == null)
                    {
                        parent.leftChild = newDataTreeNode;
                        return;
                    }
                }

                else if(key > targetNode.getKey())
                {
                    targetNode = targetNode.rightChild;

                    if(targetNode == null)
                    {
                        parent.rightChild = newDataTreeNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraverseTree(DataTreeNode targetNode)
    {
        if(targetNode != null)
        {
            inOrderTraverseTree(targetNode.leftChild);
            System.out.println(targetNode);
            inOrderTraverseTree(targetNode.rightChild);
        }
    }

    public void preOrderTraverseTree(DataTreeNode targetNode)
    {
        if(targetNode != null)
        {
            System.out.println(targetNode);
            preOrderTraverseTree(targetNode.leftChild);
            preOrderTraverseTree(targetNode.rightChild);
        }
    }

    public void postOrderTraverseTree(DataTreeNode targetNode)
    {
        if(targetNode != null)
        {
            postOrderTraverseTree(targetNode.leftChild);
            postOrderTraverseTree(targetNode.rightChild);
            System.out.println(targetNode);
        }
    }

    public DataTreeNode findNode(int key)
    {
        DataTreeNode targetNode = root;

        while(targetNode.getKey() != key)
        {
            if(key < targetNode.getKey())
            {
                targetNode = targetNode.leftChild;
            }
            else
            {
                targetNode = targetNode.rightChild;
            }

            if(targetNode == null){return null;}
        }
        return targetNode;
    }

    public boolean removeNode(int key)
    {
        DataTreeNode targetNode = root;
        DataTreeNode parent = root;

        boolean isALeftChild = true;

        while(targetNode.getKey() != key)
        {
            parent = targetNode;

            if(key < targetNode.getKey())
            {
                isALeftChild = true;
                targetNode = targetNode.leftChild;
            }
            else
            {
                isALeftChild = false;
                targetNode = targetNode.rightChild;
            }

            if(targetNode == null){return false;}
        }

        if(targetNode.leftChild == null && targetNode.rightChild == null)
        {
            if(targetNode == root)
            {
                root = null;
            }
            else if(isALeftChild)
            {
                parent.leftChild = null;
            }
            else
            {
                parent.rightChild = null;
            }
        }

        else if(targetNode.rightChild == null)
        {
            if(targetNode == root)
            {
                root = targetNode.leftChild;
            }
            else if(isALeftChild)
            {
                parent.leftChild = targetNode.leftChild;
            }
            else
            {
                parent.rightChild = targetNode.leftChild;
            }
        }

        else if(targetNode.leftChild == null)
        {
            if(targetNode == root)
            {
                root = targetNode.rightChild;
            }
            else if(isALeftChild)
            {
                parent.leftChild = targetNode.leftChild;
            }
            else
            {
                parent.rightChild = targetNode.leftChild;
                //Just set this to null?
            }
        }

        else
        {
            DataTreeNode replacement = getReplacementNode(targetNode);

            if(targetNode == root)
            {
                root = replacement;
            }
            else if(isALeftChild)
            {
                parent.leftChild = replacement;
            }
            else
            {
                parent.rightChild = replacement;
            }

            replacement.leftChild = targetNode.rightChild;
        }

        return true;
    }

    public DataTreeNode getReplacementNode(DataTreeNode replacedNode)
    {
        DataTreeNode replacementParent = replacedNode;
        DataTreeNode replacement = replacedNode;

        DataTreeNode targetNode = replacedNode.rightChild;

        while (targetNode != null)
        {
            replacementParent = replacement;
            replacement = targetNode;
            targetNode = targetNode.leftChild;
        }
        if(replacement != replacedNode.rightChild)
        {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }

        return replacement;
    }
}
