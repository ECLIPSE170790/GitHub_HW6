package sel_github_allure.examples_in_lesson;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;

@Feature("Issue")
@Owner("Safronova")

public class AnnotatedLabelsTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static Integer ISSUE_NUMBER = 69;

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    @Story("Поиск")
    @Link(name = "Главная страница", url = "https://github.com")
    @DisplayName("Проверка, что страница открылась")
    @Severity(SeverityLevel.BLOCKER)
    public void testGitHub() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
            addAttachment("Hello!", "World");
        });
    }
}
