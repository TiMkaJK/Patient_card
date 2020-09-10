package com.pristavka.patient_card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientCardApplication
{
    //Карточка пациента хранит в себе информацию о пациенте:дата поступления, диагноз,аллергии,номер клиники, этаж, палату и т.д.
    public static void main(String[] args)
    {
        SpringApplication.run(PatientCardApplication.class, args);
    }


}
