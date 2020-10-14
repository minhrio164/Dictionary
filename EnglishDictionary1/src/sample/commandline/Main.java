package sample.commandline;
public class Main {
    public static void main(String[] args) {
        DictionaryCommandline dic = new DictionaryCommandline();



        dic.insertFromFile();

        dic.add("100","19");
        dic.dictionaryExportToFile();
    }

}
