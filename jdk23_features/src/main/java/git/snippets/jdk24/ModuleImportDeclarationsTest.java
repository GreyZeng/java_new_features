package git.snippets.jdk24;

import module java.base;
import module java.sql;


public class ModuleImportDeclarationsTest {
    void main() throws ParserConfigurationException, SAXException {
        System.out.println(groupByFirstLetter("a", "abc", "bcd", "ddd", "dddc", "dfc", "bc"));

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
    }

    public static Map<Character, List<String>> groupByFirstLetter(String... values) {
        return Stream.of(values).collect(Collectors.groupingBy(s -> Character.toUpperCase(s.charAt(0))));
    }
}
