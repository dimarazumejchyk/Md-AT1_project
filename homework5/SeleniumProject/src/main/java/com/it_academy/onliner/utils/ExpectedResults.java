package com.it_academy.onliner.utils;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class ExpectedResults {
    public static ArrayList<String> getStringValues(List<WebElement> webElements) {
        ArrayList<String> stringsValues = new ArrayList<>();
        webElements.stream().forEach((i) -> {
            stringsValues.add(i.getText());
            System.out.println(i.getText());
        });
        return stringsValues;
    }
    public static List<String> expectedElementsFromCatalogClassifier() {
        List<String> expectedElementsFromCatalogClassifier = new ArrayList<>();
        expectedElementsFromCatalogClassifier.add("Onlíner Prime");
        expectedElementsFromCatalogClassifier.add("Электроника");
        expectedElementsFromCatalogClassifier.add("Компьютеры и сети");
        expectedElementsFromCatalogClassifier.add("Бытовая техника");
        expectedElementsFromCatalogClassifier.add("Стройка и ремонт");
        expectedElementsFromCatalogClassifier.add("Дом и сад");
        expectedElementsFromCatalogClassifier.add("Авто и мото");
        expectedElementsFromCatalogClassifier.add("Красота и спорт");
        expectedElementsFromCatalogClassifier.add("Детям и мамам");
        expectedElementsFromCatalogClassifier.add("Работа и офис");
        return expectedElementsFromCatalogClassifier;
    }
    public static List<String> expectedElementsFromCatalogAsideList() {
        List<String> expectedElementsFromCatalogAsideList = new ArrayList<>();
        expectedElementsFromCatalogAsideList.add("Ноутбуки, компьютеры, мониторы");
        expectedElementsFromCatalogAsideList.add("Комплектующие");
        expectedElementsFromCatalogAsideList.add("Техника для печати и дизайна");
        expectedElementsFromCatalogAsideList.add("Манипуляторы и устройства ввода");
        expectedElementsFromCatalogAsideList.add("Хранение данных");
        expectedElementsFromCatalogAsideList.add("Мультимедиа периферия");
        expectedElementsFromCatalogAsideList.add("Сетевое оборудование");
        expectedElementsFromCatalogAsideList.add("Аксессуары к ноутбукам и компьютерам");
        expectedElementsFromCatalogAsideList.add("Электропитание");
        expectedElementsFromCatalogAsideList.add("Игры и программное обеспечение");
        return expectedElementsFromCatalogAsideList;
    }
    public static List<String> expectedElementsFromCatalogDropdownList() {
        List<String> expectedElementsFromCatalogDropdownList = new ArrayList<>();
        expectedElementsFromCatalogDropdownList.add("Видеокарты");
        expectedElementsFromCatalogDropdownList.add("Процессоры");
        expectedElementsFromCatalogDropdownList.add("Материнские платы");
        expectedElementsFromCatalogDropdownList.add("Оперативная память");
        expectedElementsFromCatalogDropdownList.add("Системы охлаждения");
        expectedElementsFromCatalogDropdownList.add("SSD");
        expectedElementsFromCatalogDropdownList.add("Жесткие диски");
        expectedElementsFromCatalogDropdownList.add("Корпуса");
        expectedElementsFromCatalogDropdownList.add("Блоки питания");
        expectedElementsFromCatalogDropdownList.add("Звуковые карты");
        expectedElementsFromCatalogDropdownList.add("Сетевые адаптеры");
        expectedElementsFromCatalogDropdownList.add("Оптические приводы");
        expectedElementsFromCatalogDropdownList.add("ТВ-тюнеры и карты видеозахвата");
        expectedElementsFromCatalogDropdownList.add("Аксессуары для майнинга");
        return expectedElementsFromCatalogDropdownList;
    }
}
