package date_time.fir;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class App {

    public static void main(String[] args) {

        //기계
        //사용자 친화적 ,UTC 기준
        Instant instant = Instant.now();
        System.out.println(instant);

        //현재 로컬 기준
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        System.out.println(zonedDateTime);
        System.out.println("===================");

        //사람
        //local이 붙어있음 -> 로컬 시간이 나타남
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);


        LocalDateTime birthDay = LocalDateTime.of(1996, Month.NOVEMBER, 19, 10, 0);

        //뉴욕 시간 알아내기
        ZonedDateTime nowInNewYork = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(nowInNewYork);

        System.out.println("=============");

        //기간 알아보기

        //사람용
        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthDay = LocalDate.of(2021,Month.NOVEMBER,19);

        Period between = Period.between(today, thisYearBirthDay);

        System.out.println(between);

        Period until = today.until(thisYearBirthDay);
        System.out.println(until);

        //기계용
        Instant now1 = Instant.now();
        Instant plus = now1.plus(10, ChronoUnit.SECONDS);
        Duration between1 = Duration.between(now1,plus);
        System.out.println(between1.getSeconds());

        System.out.println("================");
        //format
        LocalDateTime ld = LocalDateTime.now();
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(ld.format(MMddyyyy));

        //parsing
        LocalDate parse = LocalDate.parse("11/19/1996",MMddyyyy);
        System.out.println(parse);
    }
}

