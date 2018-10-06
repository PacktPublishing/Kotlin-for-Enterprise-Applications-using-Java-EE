package org.rao.kotlin.intro;

class Imperative
{

    public static void main(String[] args)
    {
        List<String> names =
                Arrays.asList(“Tina”, “Tom”, ”George”); String firstNameWith3LettersLong = “”;
        boolean found;	for (int i = 0; i < names.size(); i++)
    {
        if (names[i].length() == 3)
        {
            firstNameWith3LettersLong = name[i];
            found = true;
            break;
        }
    }
        if (found)
        {
            System.out.println(firstNameWith3LettersLong);
        }
        else
        {
            System.out.println(“No results”);
        }
    }
}

