package Classes;

public class TestCase
{
    private String testCaseType;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String userName;
    private int paramCount;
    private int verifiedParams;
    private boolean verification;
    private int testCaseListIndex;


    /**
     * Constructor for TestCase
     * @param testCase
     */
    public TestCase(String testCase)
    {
        String testCaseInfoString = new String(testCase.substring(testCase.indexOf(":") + 2));
        String testCaseType = new String(testCaseInfoString.substring(0, testCaseInfoString.indexOf(" ")));
        String[] testCaseInfo = testCaseInfoString.split(" ");
        this.testCaseType = testCaseInfo[0];
        this.firstName = testCaseInfo[1];
        this.lastName = testCaseInfo[2];

        for (String params:testCaseInfo)
        {
            this.paramCount ++;
        }

        if(testCaseType.matches("Insert"))
        {
            this.verifiedParams++;

            this.phoneNumber = testCaseInfo[3];
            this.email = testCaseInfo[4];

            verifyName(firstName);
            verifyName(lastName);

            if(phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}"))
            {
                this.verifiedParams++;
            }
            else
            {
                System.out.println("TestCase[" + getTestCaseListIndex() + "]'s PhoneNumber Couldn't be verified");
            }

            if(email.matches("(\\S+)@(\\S+)\\.(\\S+)"))
            {
                this.verifiedParams++;
            }
            else
            {
                System.out.println("TestCase[" + getTestCaseListIndex() + "]'s Email Couldn't be verified");

            }
        }

        else if(testCaseType.matches("Lookup"))
        {
            this.verifiedParams++;
            verifyName(firstName);
            verifyName(lastName);
        }

        else if(testCaseType.matches("Delete"))
        {
            this.verifiedParams++;
            verifyName(firstName);
            verifyName(lastName);
        }
        setUserName(firstName, lastName);
    }

    /**
     * T.R.
     * Verifies the parsed string meets the necessary criteria which determined by the functions Regex filter.
     * @param param the String that is to be analyzed.
     */
    public void verifyName(String param)
    {
        if(param.matches("\\D*"))
        {
            this.verifiedParams++;
        }
        else
        {
            System.out.println("Name was not Verified");
        }
    }

    /**
     * T.R.
     * Counts and compares a testCases's paramCount to its verifiedParams to ensure each field has met its necessary criteria.
     * @param testCase the test case that is to be inspected.
     */
    public void verifyTestCase(TestCase testCase)
    {
        if(this.verifiedParams == paramCount)
        {
            this.verification = true;
        }
    }

    public String getTestCaseType()
    {
        return this.testCaseType;
    }

    public void setTestCaseType(String testCaseType)
    {
        this.testCaseType = testCaseType;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public boolean getVerification(TestCase testCase)
    {
        verifyTestCase(testCase);
        return verification;
    }

    public void setVerification(boolean verification)
    {
        this.verification = verification;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String firstName, String lastName)
    {
            this.userName = (firstName + lastName).toUpperCase();
    }

    public int getTestCaseListIndex()
    {
        return testCaseListIndex;
    }

    public void setTestCaseListIndex(int index)
    {
        this.testCaseListIndex = index;
    }
}
