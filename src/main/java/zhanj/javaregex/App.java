package zhanj.javaregex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    public static void main(String[] args) {
        // 查找数字
        Pattern numPat = Pattern.compile("\\d+");

        System.out.println("======== 使用Matcher查找所有匹配的字符串 =========");
        String text = "abc123 what 8391 ss";
        Matcher m1 = numPat.matcher(text);
        System.out.println("text: '" + text + "'\n");
        while (m1.find()) {
            String target = m1.group();
            System.out.println("matcher.group(): '" + target + "'");
            System.out.println("matcher.start(): " + m1.start());
            System.out.println("matcher.end(): " + m1.end());
        }

        System.out.println("\n\n======== 使用Matcher查找并替换所有匹配的字符串 =======");
        m1 = numPat.matcher(text);
        StringBuffer sb = new StringBuffer();
        while (m1.find()) {
            String target = m1.group();
            m1.appendReplacement(sb, "*");
            System.out.println("'" + target + "' => '*'");
            System.out.println("After appendReplacement: '" + sb + "'");
        }
        System.out.println("Before appendReplacement: '" + sb + "'");
        m1.appendTail(sb);
        System.out.println("After appendReplacement: '" + sb + "'");
    }
}
