package com.angers.project.corejava.stream;

import com.angers.project.corejava.inheritance.Employee;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class CreateStream {

    public static Stream<String> codePoints(String code){
        ArrayList<String> result = new ArrayList<>();
        int i = 0;
        while (i<code.length()){
            int j = code.offsetByCodePoints(i,1);
            result.add(code.substring(i,j));
            i = j;
        }
        return result.stream();
    }

    public static void main (String [] args){
        /*
        集合可以通过 Collection 接口中的方法转换为 stream
        数组也可以通过 Arrays.stream() 方法转换为 stream
         */
        String [] strings = {"and","bad","cad"};
        Stream<String> wordsStream = Arrays.stream(strings);
        log.info(Long.toString(wordsStream.count()));

        // 使用 empty 方法创建一个空 stream
        Stream<String> empty = Stream.empty();

        /*
        stream 有两种方式创建无限流
        generate 方法采用一个没有参数的函数（Supplier<T>）
        每当需要 stream 的值时，会调用该函数生成一个值
        可以用一下方法获得一个常量的值的stream
         */
        Stream<String> cons = Stream.generate(() -> "CONSTANT");
        // List<String> consList = cons.collect(Collectors.toList()); // 使用 collect方法，对stream进行转换
        //log.info(consList.toString());

        // 或者一个随机数 stream
        Stream<Double> randomNumber =
                Stream.generate(Math::random)
                        .limit(100); // 使用 limit 进行限制
        /*
         使用 collect方法，对stream进行转换
         collector 是聚集 stream 中的元素，并产生结果
         Collectors 类提供大量常用集合的工厂方法
         */
        // TreeSet<Double> randomNumberSet = randomNumber.collect(Collectors.toCollection(TreeSet::new));
        // log.info(randomNumberSet.toString());

        /*
        产生一个类似于 0,1,2,3，... 这样的序列
        使用 iterate 方法
        它使用一个 seed 值，以及一个函数（UnaryOperator<T>）
        反复执行函数，应用于上一次执行的结果
        在这个例子中，序列的第一个元素是 seed ，值为 BigInteger.ZERO
        第二个元素为 f(seed)
        第三个元素 f(f(seed))
        以此类推
         */
        Stream<BigInteger> integers =
                Stream.iterate(BigInteger.ZERO,number -> number.add(BigInteger.ONE))
                        // peek 类似于懒加载的模式，生成一个与源 stream 相同元素的新 stream，只有在元素被使用的时候才调用该函数
                        .peek(number -> number.add(BigInteger.TEN))
                        .limit(1000);
        integers.forEach(v-> log.info(v.toString())); // 对 stream 中的每个元素进行操作

        String [] words = {"some","but","and"};

        Stream <String> flatResult = Arrays.stream(words)
                .flatMap(CreateStream::codePoints)
                .distinct() // 对 stream 进行转换，剔除重复项
                .sorted(Comparator.comparing(String::length).reversed()); // 对 stream 中的元素进行排序转换

        // 连接两个 stream , 第一个 stream 不能是无限 stream
        Stream<String> combinedStream = Stream.concat(codePoints("hello"),codePoints("world"));

        /*
        将 stream 转换成数组
         */
        String [] alphabets = combinedStream.toArray(String[]::new);
        log.info(Arrays.toString(alphabets));

        /*
        终止操作，将 stream 转换为可以在程序中使用的非 stream 值
        输出字典序最大的字母
        Optional<T> 是 T 类型对象或者无对象的包装器
        使用 Optional 的主要意图是使用一个方法，当该方法不存在返回值时，使用另外的值作为替代
        或者仅当方法存在返回值时消费该值
         */
        Optional<String> maxString = flatResult.max(String::compareToIgnoreCase);
        log.info("maxString:"+maxString.orElse("")); // 当值不存在时，使用空字符串作为替代
        maxString.filter(value -> value.length()==1) // 同样可以使用 filter 判断 Optional 的值是否满足某条件
                .map(String::toUpperCase) // 对 Optional 进行转换，如果为空，则会返回空
                .ifPresent(log::info); // 值存在时，消费该值

        Optional<String> wordStartWithA = Arrays.stream(words)
                .map(String::toUpperCase)
                .filter(word -> word.startsWith("A"))
                .findFirst(); // 输出第一个符合条件的元素
        log.info(wordStartWithA.orElse(""));

        Employee an = new Employee(100);
        Stream<Employee> employeeStream = Stream.of(an);
        // 将 stream 转换成 map
        Map<Integer,Double> idToSalary = employeeStream.collect(
                Collectors.toMap(Employee::getId,Employee::getSalary));
        log.info(idToSalary.toString());

        Stream<Locale> localeStream = Stream.of(Locale.getAvailableLocales());
        // map 中，如果一个 key 对应多个元素，则会报错，可以通过第三个函数作为参数，对于这种情况进行处理
        Map<String,String> languageNames = localeStream.collect(
                Collectors.toMap(Locale::getDisplayLanguage,
                        loc -> loc.getDisplayLanguage(loc),
                        (existingValue,newValue) -> existingValue)); // 如果一个 key 对应多个元素，则保持当前元素
        log.info(languageNames.toString());

        // 将 stream 转换为 map<T,Set<T>>
        localeStream = Stream.of(Locale.getAvailableLocales());
        Map<String,Set<String>> countryLanguagesSet = localeStream.collect(
                Collectors.toMap(
                        Locale::getDisplayCountry,
                        l -> Collections.singleton(l.getDisplayLanguage()),
                        (a,b) -> {
                            HashSet<String> union = new HashSet<>(a);
                            union.addAll(b);
                            return union;}));
        log.info(countryLanguagesSet.toString());

        // 将 stream 转换为 TreeMap
        employeeStream = Stream.of(Employee.getWellPaidInstance("boss"));
        TreeMap<Integer,Employee> idToEmployee = employeeStream.collect(
                Collectors.toMap(
                        Employee::getId,
                        Function.identity(),
                        (existingValue,newValue) -> {throw new IllegalStateException();},
                        TreeMap::new
                ));
        log.info(idToEmployee.toString());

        // 使用 groupingBy 将具有相同特征的数值组合在一起，返回 Map<T,List<T>>
        localeStream = Stream.of(Locale.getAvailableLocales());
        Map<String,List<Locale>> countryToLocales = localeStream.collect(
                Collectors.groupingBy(Locale::getCountry));
        log.info(countryToLocales.toString());

        /*
        当分类器是谓词函数（即返回布尔值的函数）
        stream 中的元素被分成两个 list ，返回 true 的函数元素列表和返回 false 的函数元素列表
        这种情况下，使用 partitioningBy 会更有效
         */
        localeStream = Stream.of(Locale.getAvailableLocales());
        Map<Boolean,List<Locale>> englishAndOtherLocales = localeStream.collect(
                Collectors.partitioningBy( l -> l.getLanguage().equals("en")));
        log.info(englishAndOtherLocales.toString());
        List<Locale> englishLocales = englishAndOtherLocales.get(true);
        log.info(englishLocales.toString());
    }
}
