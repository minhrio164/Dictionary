package sample.commandline;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List ;

public class DictionaryManagement extends Dictionary {
    static Dictionary dictionary = new Dictionary();
    File fileDictionary = new File("/Users/apple/IdeaProjects/EnglishDictionary1/src/sample/Dictionary.txt");

    public static void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        String key = sc.nextLine();
        String value = sc.nextLine();
        dictionary.words.put(key, value);
    }

    public void insertFromFile() {
        if(!fileDictionary.exists()) {
            fileDictionary.mkdir();
        }
        try {
            Scanner sc = new Scanner(fileDictionary);
            String content = "";
            while (sc.hasNextLine()) {
                content = sc.nextLine();
                String[] w = content.split("\t",2);
                dictionary.words.put(w[0], w[1]);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("error");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error");
        }
    }

    public String dictionaryLookup(String a) {
        System.out.print("Enter the word you want to look up: ");

        String keyWord = a ;
        String Value = new String() ;
        boolean test = true;
        for (Map.Entry<String, String> entry: dictionary.words.entrySet()) {
            if (keyWord.equals(entry.getKey())) {
                Value = entry.getValue();
                test = false;
            }

            if (test == true) {
                Value = "";
            }
        }
        return Value;
    }

    public void add(String word, String mean) {
        String key = word;
        String value = mean;
        for (Map.Entry<String, String> entry: dictionary.words.entrySet()) {
            if (entry.getKey().equals(key)) {
                value += " || " + entry.getValue();
            }
        }
        System.out.println(value);
        dictionary.words.remove(key);
        dictionary.words.put(key, value);
    }

    public void remove(String a) {

        String key = a;
        for (Map.Entry<String, String> entry: dictionary.words.entrySet()) {
            if (key.equals(entry.getValue())) {
                key = entry.getKey();
            }
        }
        dictionary.words.remove(key);
    }

    public void change(String a , String b) {

        String editWord = a;

        String corretWord = b;
        String str = editWord;
        for (Map.Entry<String, String> entry: dictionary.words.entrySet()) {
            if (entry.getValue().equals(editWord)) {
                str = entry.getKey();
                String tg = editWord;
                editWord = corretWord;
                corretWord = tg;
            }
        }
        dictionary.words.remove(str);
        dictionary.words.put(editWord, corretWord);
    }

    public void dictionaryExportToFile() {
        try {
            File f = new File("/Users/apple/IdeaProjects/EnglishDictionary1/src/sample/Dictionary.txt");
            FileWriter fw = new FileWriter(f);
            for (Map.Entry<String, String> entry: dictionary.words.entrySet()) {
                fw.write(entry.getKey() + "\t" + entry.getValue() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e);
        }
    }
    public List<String> dictionarySeacher(String a) {
        List<String> newList = new ArrayList<>();
        String keyWord = a ;
        for (Map.Entry<String, String> entry: dictionary.words.entrySet()) {
            if (entry.getKey().contains(keyWord)) {
                String b = entry.getKey();
                newList.add(b+"\n");
                System.out.println(newList);
            }

        }
        newList.add(newList.size(),"ENGLISH DICTIONARY - LIST WORD ") ;
        return newList ;
    }

}
