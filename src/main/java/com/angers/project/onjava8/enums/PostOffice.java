package com.angers.project.onjava8.enums;


import java.util.Iterator;

/**
 * @author : liuanglin
 * @date : 2022/5/11 11:18
 * @description : 枚举-责任链设计模式
 */
class Mail {
    enum GeneralDelivery {YES, NO1, NO2, NO3, NO4, NO5}

    enum Scannability {UNSCANNABLE, YES1, YES2, YES3, YES4}

    enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4}

    enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}

    enum ReturnAddress {MISSING, OK1, OK2, OK3, OK4, OK5}

    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;
    static long counter = 0;
    long id = counter ++ ;

    @Override
    public String toString() {
        return "Mail{" +
                "generalDelivery=" + generalDelivery +
                ", scannability=" + scannability +
                ", readability=" + readability +
                ", address=" + address +
                ", returnAddress=" + returnAddress +
                ", id=" + id +
                '}';
    }
    public static Mail randomMail(){
        Mail m = new Mail();
        m.generalDelivery = EnumsRandomSelection.random(GeneralDelivery.values());
        m.scannability = EnumsRandomSelection.random(Scannability.values());
        m.readability = EnumsRandomSelection.random(Readability.values());
        m.address = EnumsRandomSelection.random(Address.values());
        m.returnAddress = EnumsRandomSelection.random(ReturnAddress.values());
        return m;
    }

    public static Iterable<Mail> generator(final int count){
        return new Iterable<Mail>() {
            int n = count;
            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    @Override
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    @Override
                    public Mail next() {
                        return randomMail();
                    }
                };
            }
        };
    }
}

public class PostOffice {
    enum MailHandler{
        GENERAL_DELIVERY{
            @Override
            boolean handle(Mail m) {
                switch (m.generalDelivery) {
                    case YES:
                        System.out.println("use general delivery for " + m);
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHINE_SCAN{
            @Override
            boolean handle(Mail m) {
                switch (m.scannability) {
                    case UNSCANNABLE:return false;
                    default:
                        switch (m.address){
                            case INCORRECT:return false;
                            default:
                                System.out.println("Delivering " + m + " automatically");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION{
            @Override
            boolean handle(Mail m) {
                switch (m.readability) {
                    case ILLEGIBLE:return false;
                    default:
                        switch (m.address){
                            case INCORRECT:return false;
                            default:
                                System.out.println("Delivering " + m + " normally");
                                return true;
                        }
                }
            }
        },
        RETURN_TO_SENDER{
            @Override
            boolean handle(Mail m) {
                switch (m.returnAddress){
                    case MISSING:return false;
                    default:
                        System.out.println("Returning " + m + " to sender");
                        return true;
                }
            }
        };

        abstract boolean handle(Mail m);
    }
    static void handle(Mail mail) {
        for (MailHandler h:MailHandler.values()) {
            if (h.handle(mail)) return;
        }
        System.out.println(mail + " is a dead letter ");
    }

    public static void main(String[] args) {
        for (Mail mail : Mail.generator(10)){
            System.out.println(mail);
            handle(mail);
            System.out.println("----");
        }
    }
}