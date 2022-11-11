package com.it_academy.onliner;

import com.it_academy.onliner.pageobject.CatalogPage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OnlinerTest extends BaseTest {

    @Test
    public void test1() {
        CatalogPage catalogPage = new CatalogPage();
                assertThat(catalogPage.checkElementsFromCatalogClassifier())
                .as("Elements don't match")
                .containsExactly("Onlíner Prime", "Электроника", "Компьютеры и сети", "Бытовая техника",
                        "Стройка и ремонт", "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам",
                        "Работа и офис");
    }

    @Test
    public void test2() {
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.clickOnCatalogNavigationClassifierLink("Компьютеры");
        catalogPage.navigateToCatalogElements(" Комплектующие ");
        assertThat(catalogPage.checkElementsFromCatalogAsideList())
                .as("Elements don't match")
                .containsExactly("Ноутбуки, компьютеры, мониторы",
                        "Комплектующие", "Техника для печати и дизайна", "Манипуляторы и устройства ввода",
                        "Хранение данных", "Мультимедиа периферия", "Сетевое оборудование",
                        "Аксессуары к ноутбукам и компьютерам", "Электропитание", "Игры и программное обеспечение");
    }

    @Test
    public void test3() {
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.clickOnCatalogNavigationClassifierLink("Компьютеры");
        catalogPage.navigateToCatalogElements(" Комплектующие ");
        assertThat(catalogPage.checkElementsFromCatalogDropdownList())
                .as("Elements don't match")
                .containsExactly("Видеокарты", "Процессоры", "Материнские платы", "Оперативная память",
                        "Системы охлаждения", "SSD", "Жесткие диски", "Корпуса", "Блоки питания", "Звуковые карты",
                        "Сетевые адаптеры", "Оптические приводы", "ТВ-тюнеры и карты видеозахвата",
                        "Аксессуары для майнинга");

        assertThat(catalogPage.checkPriceQuantityDropdownList())
                .as("Elements do not contain quantity or price")
                .isNotEmpty()
                .isNotNull();
    }

}
