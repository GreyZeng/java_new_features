package git.snippets.jdk24;

import module java.base;
import module java.sql;

/**
 * **模块导入声明（第二次预览）** 在 JDK 23 是第一次预览
 * since 24
 */
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
