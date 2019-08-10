//package com.ifmo.lesson9;
//
//import java.util.*;
//
//enum MessagePriority {
//    LOW, MEDIUM, HIGH, URGENT;
//
//    public static MessagePriority getPriority (int ord) {
//        for (MessagePriority mp: values()) {
//            if (ord == mp.ordinal())
//                return mp;
//        }
//
//        throw new AssertionError("Wrong ordinal: " + ord);
//    }
//}
//
//public class Message {
//    private int code;
//    private MessagePriority priority;
//
//    public Message(MessagePriority priority, int code) {
//        this.code = code;
//        this.priority = priority;
//    }
//
//    public MessagePriority getPriority() {
//        return priority;
//    }
//
//    public void setPriority(MessagePriority priority) {
//        this.priority = priority;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(MessagePriority.HIGH);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Message message = (Message) o;
//        return code == message.code &&
//                priority == message.priority;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(code, priority);
//    }
//}
//
//class MessageGenerator {
//    public static List<Message> generate(int num){
//        if (num <= 0) {
//            return Collection.emptyList();
//        }
//
//        Random random = new Random();
//        List<Message> messages = new ArrayList<>(num);
//
//        int typesCount = MessagePriority.values().length - 1;
//
//        for (int i = 0; i < num; i++) {
//            messages.add(
//                    new Message(
//                            random.nextInt(10),
//                            MessagePriority.getPriority(random.nextInt(typesCount))));
//        }
//        return messages;
//    }
//}
