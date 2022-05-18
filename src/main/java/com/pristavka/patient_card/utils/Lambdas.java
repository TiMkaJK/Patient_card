package com.pristavka.patient_card.utils;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Slf4j
public class Lambdas {

    public static void main(String[] args) {

//        Printable printable = log::info;
        Printable printable = System.out::println;
        printable.print("Hello world");

        Predicate<String> notNullPredicate = Objects::nonNull;
        log.info(notNullPredicate.test("12345") + "");

        Predicate<String> notBlankPredicate = StringUtils::isNotBlank;
        log.info(notBlankPredicate.test("") + "");

        log.info(notNullPredicate.and(notBlankPredicate).test("12345") + "");

        Predicate<String> startWith1 = v -> v.startsWith("J");
        Predicate<String> startWith2 = v -> v.startsWith("J");
        Predicate<String> endWith = v -> v.endsWith("D");

        startWith1.and(startWith2).and(endWith).test("J123435D");

        Consumer<HeavyBox> number61 = x -> System.out.printf("Отгрузили ящик с весом %d \n", x.getWeight());
        Consumer<HeavyBox> number62 = x -> System.out.printf("Отправляем ящик с весом %d \n", x.getWeight());
        number61.andThen(number62).accept(HeavyBox.builder().id(1L).name("Ящик обыкновенный").weight(25).build());
    }
}

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class HeavyBox {
    private Long id;
    private String name;
    private Integer weight;
}

interface Printable {
    void print(String line);
}

