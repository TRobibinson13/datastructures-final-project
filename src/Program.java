import Classes.*;
public class Program
{
    private boolean verifiedTestCases;
    private TestCases testCasesList = new TestCases();
    private HashMap userHashMap = new HashMap();

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

        generateTestCases(testCasesString);
        verifyTestCases(testCasesList);
        runTestCases();
    }


    public static void generateTestCases(String[] testCasesString)
    {

        for(String testCaseString :testCasesString)
        {
            TestCase testCase = new TestCase(testCaseString);
            Node newNode = new Node(testCase);
            this.testCasesList.add(newNode);
        }
    }

    public static boolean verifyTestCases(TestCases testCasesList)
    {
        this.verifiedTestCases = false;
        for (testCase:testCasesList)
        {
            if(testCase.getVerification == false)
            {
                return verifiedTestCases;
            }
        }
        verifiedTestCases = true;
        return verifiedTestCases;
    }

    public static void runTestCases()
    {
        Node testCase = testCasesList.firstNode;
        while(testCase != null)
        {
            switch(testCase.getTestCaseType())
            {
                case "Insert":
                    userHashMap.setValue(testCase.getUserName().hashCode(),new User(testCase.getFirstName(), testCase.getLastName(), testCase.getPhoneNumber(), testCase.getEmail()));
                    break;

                case "Lookup":
                    userHashMap.getValue(testCase.getUserName().hashCode());
                    break;

                case "Delete":
                    userHashMap.deleteEntry(testCase.getUserName().hashCode());
                    break;
            }

            testCase = testCase.getNodeAfter();
        }
    }
}
