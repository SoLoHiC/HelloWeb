package commonmark;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.renderer.text.TextContentRenderer;

/**
 * @author chuck
 * @since 07/06/2017
 */
public class CommonMark {

  public static void main(String[] args) {
    Parser parser = Parser.builder().build();
    Node document = parser.parse("This is a *demo* commonMark parse");
    HtmlRenderer renderer = HtmlRenderer.builder().build();
    String html = renderer.render(document);
    System.out.println(html);

    TextContentRenderer renderer2 = TextContentRenderer.builder().build();
    String txt = renderer2.render(document);
    System.out.println(txt);
  }

}
