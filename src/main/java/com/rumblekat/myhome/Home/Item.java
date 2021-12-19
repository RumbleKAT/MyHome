package com.rumblekat.myhome.Home;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Item {

    private String houseManageNo;
    private String pblancNo;
    private String bsnsMbyNm;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rceptBgnde;
    private int rcritPblancDe;
    private String rentSecdNm;
    private String sido;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate przwnerPresnatnDe;
    private String houseNm;
    private String houseDtlSecdNm;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rceptEndde;
}
