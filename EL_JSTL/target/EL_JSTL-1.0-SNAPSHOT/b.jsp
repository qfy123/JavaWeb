<%@ page import="pojo.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Random
  Date: 2021/5/12
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Person person = new Person();
        person.setName("芜湖起飞");
        person.setPhones(new String[]{"12312312","54643534","546752888","99999999"});
        List<String> cities=new ArrayList<String>();
        cities.add("北京");
        cities.add("芜湖");
        cities.add("武汉");
        cities.add("南京");
        person.setCities(cities);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
        person.setMap(map);

        request.setAttribute("person",person);
    %>
    输出person：${person}<br/>
    输出person的name属性：${person.name}<br/>
    输出person的phones数组属性：${person.phones[3]}<br/>
    输出person的cities集合：${person.cities}<br/>
    输出person的cities个别元素：${person.cities[3]}<br/>
    输出person的map属性：${person.map}<br/>
    输出person的个别map：${person.map.key1}<br/>
-------------------------------------------------------------------------------------

</body>
</html>
