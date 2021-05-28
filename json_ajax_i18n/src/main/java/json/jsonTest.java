package json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import pojo.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author QFY
 * @Description
 * @create 2021-05-27 19:06
 */
public class jsonTest {
    //javaBean和json的转换
    @Test
    public void test1(){
        Person person = new Person(1, "芜湖");
        //创建gson对象实例
        Gson gson = new Gson();
        //把java对象转换成json字符串
        String json = gson.toJson(person);
        System.out.println(json);
        //把json字符串转换回json字符串，第一个参数是json字符串，第二个是转换回去的java对象类型
        Person person1 = gson.fromJson(json, Person.class);
        System.out.println(person1);
    }
    @Test
    public void test2(){
        //List和Json互转
        List<Person> list=new ArrayList<Person>();
        list.add(new Person(1,"2313"));
        list.add(new Person(2,"sdad"));
        list.add(new Person(3,"hgfdhfg"));
        Gson gson = new Gson();
        //把list集合转换为json字符串
        String json = gson.toJson(list);
        System.out.println(json);
        //把json字符串转换回json对象，第二个参数用type
        List<Person> list1 = gson.fromJson(json, new TypeToken<List<Person>>(){}.getType());
        System.out.println(list1);
        System.out.println(list1.get(0));
    }

    @Test
    public void test3(){
        //map和json转换
        Map<Integer, Person> map = new HashMap<>();
        map.put(1,new Person(1,"adadada"));
        map.put(2,new Person(2,"weqweqweqe"));
        Gson gson = new Gson();
        String json = gson.toJson(map);
        System.out.println(json);
        Map<Integer,Person> map1 = gson.fromJson(json, new TypeToken<Map<Integer,Person>>(){}.getType());
        System.out.println(map1);
        System.out.println(map1.get(1));
    }
}
