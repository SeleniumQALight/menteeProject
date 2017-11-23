package libs;
import java.util.ArrayList;

public class DataProvider {

    public String generateNewUniqueSpareName(ArrayList<String> list)
    {
        String newSparename;
        int i = 0;
        do {
            newSparename = Utils.GetCurrentDateTime() + " test spare" + i;
            i++;
        } while (isStringInList(list, newSparename));
        return newSparename;
    }

    public boolean isStringInList(ArrayList<String> list, String string) {
        for (String s : list) {
            String value = s;
            if (value.equals(string))
                return true;
        }
        return false;
    }
}
