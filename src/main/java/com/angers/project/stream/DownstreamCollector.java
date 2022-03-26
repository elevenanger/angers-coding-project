package com.angers.project.stream;

import com.angers.project.inheritance.Employee;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class DownstreamCollector {

    public static final String FILE_PATH = "/Users/liuanglin/data/welllist.txt";

    public static void main(String [] args) throws IOException {

        /*
        groupingBy 方法产生值为 list 的 map
        如果需要对这些值进行进一步的处理，可以使用下游收集器（downstream collector）机制
         */
        Stream<Locale> localeStream = Stream.of(Locale.getAvailableLocales());
        // 将 list 转换为 set
        Map<String, Set<Locale>> countryToLocaleSet = localeStream.collect(Collectors.
                groupingBy(Locale::getCountry,Collectors.toSet()));
        log.info(countryToLocaleSet.toString());

        /*
        减少 list 的元素为数字的下游收集器
         */
        localeStream = Stream.of(Locale.getAvailableLocales());
        // 对 list 中的元素计数
        Map<String,Long> countryToLocaleCounts = localeStream.collect(
                Collectors.groupingBy(Locale::getCountry,Collectors.counting()));
        log.info(countryToLocaleCounts.toString());

        /*
        对 Int | Double | Long 进行求和
         */
        Stream<Employee> employeeStream = Employee.initWellPaidInstance().createEmployeeStreamFromFile(FILE_PATH);
        Map<String,Double>stringDoubleMap = employeeStream.collect(
                Collectors.groupingBy(Employee::getName,Collectors.summingDouble(Employee::getSalary)));
        log.info(stringDoubleMap.toString());

        // maxBy 获取相同姓名中 salary 最大值 ，与之相对， minBy 可以获取最小值
        employeeStream = Employee.initWellPaidInstance().createEmployeeStreamFromFile(FILE_PATH);
        Map<String,Optional<Employee>> stringOptionalMap = employeeStream.collect(
                Collectors.groupingBy(Employee::getName,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        stringOptionalMap.forEach((k,v) -> log.info("name: "+ k + " salary: "+(v.isPresent()?v.get().getSalary():v)));

        /*
        collectingAndThen 在 Collectors 之前增加一个最终的处理步骤
        将相同姓名的 Employee 放到一个集合里面
        返回每个集合的大小
         */
        employeeStream = Employee.initWellPaidInstance().createEmployeeStreamFromFile(FILE_PATH);
        Map<String,Integer> employeesCountByStartingLetter = employeeStream.collect(
                Collectors.groupingBy(Employee::getName,
                        // 将相同的姓名的 Employee 归集到相同集合，计算每个集合的大小
                        Collectors.collectingAndThen(Collectors.toSet(),Set::size)));
        log.info(employeesCountByStartingLetter.toString());

        /*
        mapping 则相反
        将函数作用于每个元素上
        将及诶过传递给下游收集器
         */
        employeeStream = Employee.initWellPaidInstance().createEmployeeStreamFromFile(FILE_PATH);
        Map<String,Set<Double>> stringLengthsByStartLetter = employeeStream.collect(
                Collectors.groupingBy(Employee::getName,
                        Collectors.mapping(Employee::getSalary, // 将函数作用于每个元素上
                                Collectors.toSet()))); // 将结果传递给下游的收集器
        log.info(stringLengthsByStartLetter.toString());

        /*
        summarizingDouble 输出 Int | Double | Long ，可以将元素的统计结果对象
         */
        employeeStream = Employee.initWellPaidInstance().createEmployeeStreamFromFile(FILE_PATH);
        Map<String,DoubleSummaryStatistics> nameToSalarySummary = employeeStream.collect(
                Collectors.groupingBy(Employee::getName,Collectors.summarizingDouble(Employee::getSalary)));
        log.info(nameToSalarySummary.toString());

    }

}
