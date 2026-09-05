package sample.cafekiosk.unit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sample.cafekiosk.unit.beverage.Americano;
import sample.cafekiosk.unit.beverage.Latte;
import sample.cafekiosk.unit.order.Order;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CafekioskTest {




    @Test
    void add_manual_test(){
        Cafekiosk cafekiosk = new Cafekiosk();
        cafekiosk.add(new Americano());

        System.out.println(">>> 담긴 음료 수 : " + cafekiosk.getBeverages().size());
        System.out.println(">>> 담긴 음료 : " + cafekiosk.getBeverages().get(0).getName());

    }

    @Test
    void addServeralBeverages(){
        Cafekiosk cafekiosk = new Cafekiosk();
        Americano americano = new Americano();

        cafekiosk.add(americano,2);

        assertThat(cafekiosk.getBeverages().get(0)).isEqualTo(americano);
        assertThat(cafekiosk.getBeverages().get(1)).isEqualTo(americano);

    }

    @Test
    void addZeroBeverages(){

        Cafekiosk cafekiosk = new Cafekiosk();
        Americano americano = new Americano();

        assertThatThrownBy(() -> cafekiosk.add(americano,0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음료는 1잔 이상이어야 합니다.");
    }

    @DisplayName("음료 1개를 추가하면 주문 목록에 담긴다.")
    @Test
    void add(){

        Cafekiosk cafekiosk = new Cafekiosk();
        cafekiosk.add(new Americano());

        assertThat(cafekiosk.getBeverages()).hasSize(1);
        assertThat(cafekiosk.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }


    @Test
    void remove(){
        Cafekiosk cafekiosk = new Cafekiosk();
        Americano americano = new Americano();

        cafekiosk.add(americano);
        assertThat(cafekiosk.getBeverages()).hasSize(1);

        cafekiosk.remove(americano);
        assertThat(cafekiosk.getBeverages()).isEmpty();


    }


    @Test
    void clear(){
        Cafekiosk cafekiosk = new Cafekiosk();
        cafekiosk.add(new Americano());
        cafekiosk.add(new Latte());

        cafekiosk.clear();

        assertThat(cafekiosk.getBeverages()).isEmpty();
    }


    @DisplayName("주문 목록에 담긴 상품들의 총 금액을 계산할 수 있다.")
    @Test
    void calculateTotalPrice(){

        // given
        Cafekiosk cafekiosk = new Cafekiosk();
        Americano americano = new Americano();
        Latte latte = new Latte();
        cafekiosk.add(americano);
        cafekiosk.add(latte);

        // when (수행 메서드 호출) (보통 1줄)
        int totalPrice = cafekiosk.calculateTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(8500);
    }


    @Test
    void createOrderWithCurrentTime(){

        Cafekiosk cafekiosk = new Cafekiosk();
        Americano americano = new Americano();

        cafekiosk.add(americano);

        Order order = cafekiosk.createOrder(LocalDateTime.of(2023,1,17,10,0));



        assertThat(order.getBeverages()).hasSize(1);
        assertThat(order.getBeverages().get(0).getName()).isEqualTo("아메리카노");

    }

    @Test
    void createOrderWithOutsideOpenTime(){

        Cafekiosk cafekiosk = new Cafekiosk();
        Americano americano = new Americano();

        cafekiosk.add(americano);


        assertThatThrownBy(() -> cafekiosk.createOrder(LocalDateTime.of(2023,1,17,9,59)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("주문 시간이 아닙니다. 관리자에게 문의하세요.");



    }

}