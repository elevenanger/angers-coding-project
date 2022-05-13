package com.angers.project.onjava8.enums;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/5/12 08:38
 * @description :枚举-状态机设计模式
 */
enum Category {
    MONEY(Input.NICKEL,Input.DIME,Input.QUARTER,Input.DOLLAR),
    ITEM_SELECTION(Input.TOOTHPASTE,Input.SOAP,Input.SODA,Input.CHIPS),
    QUIT_TRANSCTION(Input.ABORT_TRANSACTION),
    SHUT_DOWN(Input.STOP);
    private Input[] values;

    Category(Input ... values) {
        this.values = values;
    }
    /*
    定义 EnumMap ，对每个 Input 枚举和 Category 枚举中的分类进行映射
     */
    private static EnumMap<Input,Category> categories = new EnumMap<>(Input.class);
    static {
        for (Category c:Category.class.getEnumConstants()) {
            for (Input input:c.values) {
                categories.put(input,c);
            }
        }
    }

    /**
     * 通过 Input 类型返回对应 Category 类型
     * @param input Input 类型
     * @return 对应 Category 类型
     */
    public static Category categorize(Input input){
        return categories.get(input);
    }
}

public class VendingMachine{
    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;

    enum StateDuration{ TRANSIENT }
    enum State {
        RESTING{
            @Override
            void next(Input input) {
                switch (Category.categorize(input)){
                    case MONEY:
                        amount += input.amount();
                        state = ADDING_MONEY;
                        break;
                    case SHUT_DOWN:state = TERMINAL;
                    default:
                }
            }
        },
        ADDING_MONEY{
            @Override
            void next(Input input) {
                switch (Category.categorize(input)){
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if (amount < selection.amount()){
                            System.out.println("Insufficient money for selection : " + selection);
                        }else {
                            state = DISPENDING;
                        }
                        break;
                    case QUIT_TRANSCTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                        break;
                }
            }
        },
        DISPENDING(StateDuration.TRANSIENT){
            @Override
            void next() {
                System.out.println("here is your selection " + selection);
                amount -= selection.amount();
                state = GIVING_CHANGE;
            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT){
            @Override
            void next() {
                if (amount > 0) {
                    System.out.println("Your change : " + amount);
                    amount = 0;
                }
                state = RESTING;
            }
        },
        TERMINAL{
            @Override
            void output() {
                System.out.println("Halted");
            }
        };
        private boolean isTransient = false;
        State(){}
        State(StateDuration trans) {
            isTransient = true;
        }
        void next(Input input){
            throw new RuntimeException("Only call next(Input input) in non-transient state");
        }
        void next(){
            throw new RuntimeException("Only call next() in transient state");
        }
        void output(){
            System.out.println(amount);
        }
        static void run(Supplier<Input> gen) {
            while (state != State.TERMINAL) {
                state.next(gen.get());
                while (state.isTransient) state.next();
                state.output();
            }
        }
    }

    public static void main(String[] args) {
        Supplier<Input> gen = new RandomSupplier();
        gen = new FileInputSupplier("/Users/liuanglin/data/notice.txt");
        State.run(gen);
    }
}

class RandomSupplier implements Supplier<Input> {
    @Override
    public Input get() {
        return Input.randomSelection();
    }
}

class FileInputSupplier implements Supplier<Input>{
    private Iterator<String> input;

    public FileInputSupplier(String fileName) {
        try (Stream<String> fileInput = Files.lines(Paths.get(fileName))){
            input = fileInput
                    .skip(10)
                    .flatMap(s -> Arrays.stream(s.split(";")))
                    .map(String::trim)
                    .collect(Collectors.toList())
                    .iterator();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Input get() {
        if (input.hasNext()){
            return null;
        }
        return Enum.valueOf(Input.class,input.next().trim());
    }
}