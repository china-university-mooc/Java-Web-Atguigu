import com.itutry.Book;
import java.util.ArrayList;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Assert;
import org.junit.Test;

/**
 * 用 dom4j 解析 books.xml 文件，并转换成Book对象列表。
 *
 * @author itutry
 * @create 2020-04-29_08:40
 */
public class Dom4jTest {

  @Test
  public void readXMLtoObject() throws DocumentException {
    final SAXReader saxReader = new SAXReader();
    final Document document = saxReader.read("src/books.xml");
    final Element rootEle = document.getRootElement();

    List<Book> books = new ArrayList<>();
    final List<Element> bookEles = (List<Element>)rootEle.elements("book");
    for (Element bookEle : bookEles) {
      final String sn = bookEle.attribute("sn").getValue();
      final Element nameEle = bookEle.element("name");
      final String name = nameEle.getText();
      final String author = bookEle.elementText("author");
      final String price = bookEle.elementText("price");

      final Book book = new Book(sn, name, author, Double.parseDouble(price));
      books.add(book);
    }

    books.forEach(System.out::println);
    Assert.assertEquals(2, books.size());
  }
}
