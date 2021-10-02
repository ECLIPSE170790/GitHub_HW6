package sel_github_allure.examples_in_lesson;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.*;

public class DynamicLabelsTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static Integer ISSUE_NUMBER = 69;

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    @DisplayName("Проверка, что страница открылась")
    public void testGitHub() {
        feature("Issue");
        story("Поиск");
        label("owner", "Safronova");
        label("severity", SeverityLevel.BLOCKER.toString());
        link("Главная страница", "https://github.com");


        step("Открываем главную страницу", () -> {
            open("https://github.com");
            addAttachment("Hello!", "World");
        });
    }
}
