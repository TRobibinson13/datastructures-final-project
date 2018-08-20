package Classes;


public class Program
{
    private static boolean verifiedTestCases;
    private static CustomLinkedList testCasesList = new CustomLinkedList();
    private static HashMap userHashMap = new HashMap();
    private static DataTree userDataTree = new DataTree();

    /**
     * T.R.
     * The main method begins the execution of Program based on the parsed Test Cases as an array of Strings.
     */
    public static void main(String[] args)
    {
        String [] testCasesString =
                {
                        "Test Case1: Insert Bob Smith 555-235-1111 bsmith@somewhere.com",
                        "Test Case2: Insert Jane Williams 555-235-1112 jw@something.com",
                        "Test Case4: Insert Pat Jones 555-235-1114 pjones@homesweethome.com",
                        "Test Case5: Insert Billy Kidd 555-235-1115 billy_the_kid@nowhere.com",
                        "Test Case6: Insert H. Houdini 555-235-1116 houdini@noplace.com",
                        "Test Case7: Insert Jack Jones 555-235-1117 jjones@hill.com",
                        "Test Case8: Insert Jill Jones 555-235-1118 jillj@hill.com",
                        "Test Case9: Insert John Doe 555-235-1119 jdoe@somedomain.com",
                        "Test Case10: Insert Jane Doe 555-235-1120 jdoe@somedomain.com",
                        "Test Case11: Lookup Pat Jones",
                        "Test Case12: Lookup Billy Kidd",
                        "Test Case13: Delete John Doe",
                        "Test Case14: Insert Test Case 555-235-1121 Test_Case@testcase.com",
                        "Test Case15: Insert Nadezhda Kanachekhovskaya 555-235-1122 dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru",
                        "Test Case16: Insert Jo Wu 555-235-1123 wu@h.com",
                        "Test Case17: Insert Millard Fillmore 555-235-1124 millard@theactualwhitehouse.us",
                        "Test Case18: Insert Bob vanDyke 555-235-1125 vandyke@nodomain.com",
                        "Test Case19: Insert Upside Down 555-235-1126 upsidedown@rightsideup.com",
                        "Test Case20: Lookup Jack Jones",
                        "Test Case21: Lookup Nadezhda Kanachekhovskaya",
                        "Test Case22: Delete Jill Jones",
                        "Test Case23: Delete John Doe",
                        "Test Case24: Lookup Jill Jones",
                        "Test Case25: Lookup John Doe"
                };

        //generateTestCases(testCasesString);

        //runTestCases();

        generateTestCasesDataTree(testCasesString);

        runTestCasesDataTree();

        System.out.println("Stop point");
    }

    /**
     * T.R.
     * For the HashMap Data Structure, Breaks apart an array of strings into individual strings.  Per string, it then creates a TestCase object via its values, and then adds the string
     * as a Node into a Linked list
     * @param testCasesAsStrings the Array of Strings that is to be broken apart.
     */
    public static void generateTestCases(String[] testCasesAsStrings)
    {
        verifiedTestCases = true;

        for(String testCaseString :testCasesAsStrings)
        {
            TestCase testCase = new TestCase(testCaseString);
            testCase.setTestCaseListIndex(testCasesList.getNumberOfEntries());
            Node newNode = new Node(testCase);
            testCasesList.add(newNode);

            String outputMessage = testCaseString + " has been added to the testCaseList at the index of " + testCase.getTestCaseListIndex();
            System.out.println(outputMessage);

            testCasesList.incrementNumberOfEntries();
            System.out.println("TestCase List Count: " + testCasesList.getNumberOfEntries());
            verifyTestCase(testCase);
            System.out.println();
        }

        if(testCasesList.getNumberOfEntries() > userHashMap.getTableSize())
        {
            userHashMap.increaseArraySize(testCasesList.getNumberOfEntries());
        }
    }

    /**
     * T.R.
     * For the DataTree Data Structure, breaks apart an array of strings into individual strings.  Per string, it then creates a TestCase object via its values, and then adds the string
     * as a Node into a Linked list.
     * @param testCasesAsStrings the Array of Strings that is to be broken apart.
     */
    public static void generateTestCasesDataTree(String[] testCasesAsStrings)
    {
        verifiedTestCases = true;

        for(String testCaseString :testCasesAsStrings)
        {
            TestCase testCase = new TestCase(testCaseString);
            testCase.setTestCaseListIndex(testCasesList.getNumberOfEntries());
            Node newNode = new Node(testCase);
            testCasesList.add(newNode);

            String outputMessage = testCaseString + " has been added to the testCaseList at the index of " + testCase.getTestCaseListIndex();
            System.out.println(outputMessage);

            testCasesList.incrementNumberOfEntries();
            System.out.println("TestCase List Count: " + testCasesList.getNumberOfEntries());
            verifyTestCase(testCase);
            System.out.println();
        }
    }

    /**
     * T.R.
     * Verifies via a logical boolean operator that each field within a TestCase meets the necessary criteria.
     * @param testCase the TestCase the is to be verified
    */
    public static boolean verifyTestCase(TestCase testCase)
    {
        boolean verification = testCase.getVerification(testCase);

        if(verification && verifiedTestCases)
        {
            verifiedTestCases = true;
        }
        else
        {
            verifiedTestCases = false;
        }

        System.out.println("Verification of TestCase at the Index of " + testCase.getTestCaseListIndex() + " is " + verification);
        return verifiedTestCases;
    }

    /**
     * T.R.
     * For the HashMap Data Structure Runs the through each Node in testCaseList, which contains a linked list of TestCase's, and then performs the desired actions.
     */

    public static void runTestCases()
    {
        Node currentNodeTestCase = testCasesList.firstNode;

        while(currentNodeTestCase != null)
        {
            if(currentNodeTestCase.data instanceof TestCase)
            {
                TestCase testCase = (TestCase)currentNodeTestCase.data;
                switch (testCase.getTestCaseType())
                {
                    case "Insert":
                        userHashMap.setValue(testCase.getUserName().hashCode(), new User(testCase.getFirstName(), testCase.getLastName(), testCase.getPhoneNumber(), testCase.getEmail()));
                        System.out.println(testCase.getUserName()+ " is being Inserted");
                        break;

                    case "Lookup":

                        User lookedUpUser = (User)userHashMap.getValue(testCase.getUserName().hashCode());

                        if(lookedUpUser != null)
                        {
                            System.out.println(lookedUpUser.getUserName() + " has been looked up");
                            System.out.println(lookedUpUser.toString());
                        }
                        else
                        {
                            System.out.println(testCase.getUserName() + " has been looked up. User does not exist");
                        }
                        break;

                    case "Delete":
                        System.out.println(testCase.getUserName()+ " is being removed");
                        userHashMap.deleteEntry(testCase.getUserName().hashCode());
                        break;
                }
            }
            currentNodeTestCase = currentNodeTestCase.getNodeAfter();
        }
    }

    /**
     * T.R.
     * For the DataTree Data Structure Runs the through each Node in testCaseList, which contains a linked list of TestCase's, and then performs the desired actions.
     */

    public static void runTestCasesDataTree()
    {
        Node currentNodeTestCase = testCasesList.firstNode;

        while(currentNodeTestCase != null)
        {
            if(currentNodeTestCase.data instanceof TestCase)
            {
                TestCase testCase = (TestCase)currentNodeTestCase.data;
                switch (testCase.getTestCaseType())
                {
                    case "Insert":
                        userDataTree.addDataTreeNode(testCase.getUserName().hashCode(), new User(testCase.getFirstName(), testCase.getLastName(), testCase.getPhoneNumber(), testCase.getEmail()));
                        System.out.println(testCase.getUserName()+ " is being Inserted");
                        break;

                    case "Lookup":

                        User lookedUpUser = (User)userDataTree.findNode(testCase.getUserName().hashCode());

                        if(lookedUpUser != null)
                        {
                            System.out.println(lookedUpUser.getUserName() + " has been looked up");
                            System.out.println(lookedUpUser.toString());
                        }
                        else
                        {
                            System.out.println(testCase.getUserName() + " has been looked up. User does not exist");
                        }
                        break;

                    case "Delete":
                        System.out.println(testCase.getUserName()+ " is being removed");
                        userDataTree.removeNode(testCase.getUserName().hashCode());
                        break;
                }
            }
            currentNodeTestCase = currentNodeTestCase.getNodeAfter();
        }
    }
}
