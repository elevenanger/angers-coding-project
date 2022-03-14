package com.angers.project;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Slf4j
class MyCoreTester extends Tester{

    @Test
    void javaArray(){
        //声明一个 String 类型对象数组，并赋值
        String [] strArr  = {"123213","qwewqe"};
        log.info(Arrays.toString(strArr));
        for (String str:strArr){
            log.info(str);
        }
    }

    @Test
    void initialNewObject(){
        Date initialDate;//创建 Date 类型对象变量 initialDate 尚未完成初始化，还不是一个对象
        //初始化一个 Date 类型对象变量，引用 new 构造的 Date 类型对象 ，完成初始化
        //new Date() 创建一个类型为 Date 的对象，它的值是对于这个新创建的对象的引用
        //这个引用被存储在对象变量 now 中
        Date now = new Date();
        initialDate = now; // initialDate 引用已经存在的相同类型对象，完成初始化，现在两个变量都引用同一个对象
        log.info(initialDate.toString()); // 对象完成初始化之后则可以使用 Date 类封装的方法
        log.info("使用 == 判断两个对象变量指向的对象地址是否相等：" + String.valueOf(initialDate==now));
        log.info("使用equals判断值是否相同：" + String.valueOf(initialDate.equals(now)));
        String oriStr;
        String realString = "abc";
        String realString1 = "abc";
        // Java 的对象都存活在堆内存中
        //当一个对象包含另一个对象时，它只是包含一个指向另一个对象所在的堆内存地址的指针
        oriStr = realString;
        log.info("使用equals判断值是否相同：" + String.valueOf(oriStr.equals(realString)));
        log.info("使用equals判断值是否相同：" + String.valueOf(oriStr.equals(realString1)));
        log.info("使用 == 判断两个对象变量指向的对象地址是否相等：" + String.valueOf(oriStr==realString));
        //这个判断可能会输出为false，因为它们本质上不是指向同一个对象
        //需要注意的是，对象变量并不包含对象，它只是指向一个对象
        //在 Java 中，任何对象变量的值是对于存储在某处的一个对象的引用
        log.info("使用 == 判断两个对象变量指向的对象地址是否相等：" + String.valueOf(oriStr==realString1));
        oriStr = null; //显式的设置一个对象变量的值为null，表示它现在未引用任何对象
        log.info(String.valueOf(StringUtils.isBlank(oriStr)));
        //使用静态工厂方法创建对象实例，并将其引用存储到对象变量中
        LocalDate staticFacDate = LocalDate.now();
        log.info("年份："+staticFacDate.getYear());
    }

    @Test
    //修改器方法与访问器方法
    void mutatorAndAccessorMethods(){
        //初始化一个对象变量 local
        LocalDate local = LocalDate.now();
        //调用 plusDays 方法，local 引用的对象不会发生改变，而是会产生一个新的 LocalDate 对象，并赋值给 aThousandDaysLater 变量
        LocalDate aThousandDaysLater = local.plusDays(1000);
        log.info("原来 LocalDate 对象的年份：" + local.getYear() + "; 调用plusDays方法后的对象的年份：" + aThousandDaysLater.getYear());
        //构造一个 GregorianCalendar 对象
        GregorianCalendar greDate = new GregorianCalendar();
        //调用 add 方法，原对象发生的改变
        greDate.add(Calendar.DAY_OF_YEAR,1000);
        log.info("原来 GregorianCalendar 对象的年份:" + greDate.get(Calendar.YEAR));
        //调用 GregorianCalendar.add() 方法后，原来的对象发生了改变，这种方法称为 更改器方法（mutator method）
        //调用 LocalDate.plusDay() 方法后，原对象不发生变化，这种方法称为 访问器方法（accessor method）
    }

    @Test
    void printCalendar(){
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();
        //本月的第一天
        date = date.minusDays( today - 1 );
        DayOfWeek weekDay = date.getDayOfWeek();
        int value = weekDay.getValue();
        //打印首行
        System.out.println("Mon Tue Wen Thu Fri Sat Sun");
        //打印本月第一天
        for (int i = 1;i<value;i++){
            System.out.printf("    ");
        }
        //遍历本月所有日期进行打印
        while (date.getMonthValue() == month){
            //三个占位符，打印日期
            System.out.printf("%3d",date.getDayOfMonth());
            if (date.getDayOfMonth()==today){
                //当日则用 * 标记
                System.out.printf("*");
            } else {
                //其它日期空格隔开
                System.out.printf(" ");
            }
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1){
                //星期一换行
                System.out.println();
            }
        }
    }

    @Test
    void httpclientTest(){
        HttpClient httpClient = new DefaultHttpClient();

        HttpGet httpGet = null;

        try {
            httpGet = new HttpGet("https://channel.nhsa.gov.cn/ebus/channel/api/cfc/nationcfc/ec/ec_state");
            HttpResponse response = httpClient.execute(httpGet);
            int httpStatus = response.getStatusLine().getStatusCode();
            if(httpStatus == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                //to avoid throw exception when new json object, if the contentType is not json, .
                String contentType = ContentType.getOrDefault(entity).getMimeType();
                if(contentType.contains("application/json")) {
                    String getJson = EntityUtils.toString(entity);
                    JSONObject jsonObj = new JSONObject(getJson);
                    //the json obj should contains version key
                }
                //Consume response content
                EntityUtils.consume(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpGet.abort();
            httpClient.getConnectionManager().shutdown();
        }
    }

}
