package com.angers.project.onjava8.serialization;

import com.angers.project.onjava8.common.CommonUtils;
import nu.xom.*;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/6/7 10:17
 * @description : 将数据转换为 XML 格式
 */
class APerson {
    private String first;
    private String last;

    public APerson(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public Element getXML() {
        Element person = new Element("person");
        Element firstName = new Element("first");
        firstName.appendChild(first);
        Element lastName = new Element("last");
        lastName.appendChild(last);
        person.appendChild(firstName);
        person.appendChild(lastName);
        return person;
    }

    public APerson(Element person){
        first = person.getFirstChildElement("first").getValue();
        last = person.getFirstChildElement("last").getValue();
    }

    @Override
    public String toString() {
        return "APerson{" +
            "first='" + first + '\'' +
            ", last='" + last + '\'' +
            '}';
    }

    public static void format(OutputStream out, Document doc) throws Exception {
        Serializer serializer = new Serializer(out,"ISO-8859-1");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        serializer.flush();
    }
}
public class XMLTransInfo {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get(CommonUtils.FILE_PATH,"/serialization/APerson.xml");
        List<APerson> personList = Arrays.asList(
            new APerson("王","五"),
            new APerson("张","三"),
            new APerson("李","四")
        );
        personList.forEach(System.out::println);
        Element root = new Element("personList");
        personList.forEach(aPerson -> root.appendChild(aPerson.getXML()));
        Document document = new Document(root);
        APerson.format(System.out,document);
        APerson.format(new BufferedOutputStream(
            Files.newOutputStream(path)),document);
        // 反序列化
        List<APerson> aPersonList = new ArrayList<>();
        Document document1 = new Builder().build(path.toFile());
        Elements elements = document1.getRootElement().getChildElements();
        elements.forEach(element -> aPersonList.add(new APerson(element)));
        aPersonList.forEach(System.out::println);
    }
}
