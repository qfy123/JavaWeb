package dom4j;


import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @author QFY
 * @Description
 * @create 2021-04-29 13:55
 */
public class Dom4jTest {
    @Test
    public void test1() throws Exception{
        //创建一个SAXReader输入流，去读取xml文件，生成dom对象
        SAXReader saxReader=new SAXReader();
        Document document = saxReader.read("src/books.xml");
        System.out.println(document);
    }

    /**
     * 读取books.xml文件生成Book类
     */
    @Test
    public void test2()throws Exception{
        //读取books.xml文件
        SAXReader saxReader=new SAXReader();
        Document document = saxReader.read("xml/books.xml");
        //通过dom对象获取根元素
        Element rootElement = document.getRootElement();
        System.out.println(rootElement);
        //通过根元素获取book标签对象
        List<Element> book = rootElement.elements("book");

        //遍历，处理每个book标签转换为Book类
        for (Element e:book){
            //asXML：把标签对象转换为标签字符串
//            Element name = e.element("name");//element:获取指定标签
//            String text = name.getText();//getText:获取标签内的文本
            //直接获取标签内的文本
            String name = e.elementText("name");
            String author = e.elementText("author");
            String price = e.elementText("price");
            String sn = e.attributeValue("sn");

            System.out.println(new Book(sn,name,Double.parseDouble(price),author));
        }
    }

}
