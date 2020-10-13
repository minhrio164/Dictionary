package sample.commandline;
import java.util.Map;

public class DictionaryCommandline extends DictionaryManagement {

    public void showAllWords() {
        int i = 1;
        for (Map.Entry<String, String> entry: dictionary.words.entrySet()) {
            System.out.println(i + "\t" + entry.getKey() + "\t" + entry.getValue());
            i++;
        }
    }

    public void dictionaryBasic() {

        showAllWords();
        add("18","19");
    }


}
