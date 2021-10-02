package sel_github_allure.examples_in_lesson;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.*;

@Feature("Issue")
@Owner("Safronova")

public class RegionsTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static Integer ISSUE_NUMBER = 69;

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @ParameterizedTest
    @ValueSource(strings = {"Москва", "Питер"})
    public void testGitHub(String region) {
        parameter("Регион", region);
        step("Открываем главную страницу в регионе "+ region, () -> {
            open("https://github.com");
            addAttachment("Hello!", "World");
        });
    }
}
