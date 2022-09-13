package ru.yandex.practicum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class questionsAboutImportant {
    private  WebDriver driver;
    QuestionsAboutImportantPage questionsAboutImportantPage;
    @Before

    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        questionsAboutImportantPage = new QuestionsAboutImportantPage(driver);
        questionsAboutImportantPage.clickCookieButton();


    }
    @After
    public void leave(){
        driver.quit();
    }
    @Test
    public void checkTextAnswerOfFirstQuestions() {
        questionsAboutImportantPage.clickOnQuestion(questionsAboutImportantPage.firstQuestion);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(questionsAboutImportantPage.answerOfFirstQuestion));
        Assert.assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", questionsAboutImportantPage.getAnswerOfQuestion(questionsAboutImportantPage.answerOfFirstQuestion));
    }

    @Test
    public void checkTextAnswerOfSecondQuestions() {
        questionsAboutImportantPage.clickOnQuestion(questionsAboutImportantPage.secondQuestion);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(questionsAboutImportantPage.answerOfSecondQuestion));
        Assert.assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                questionsAboutImportantPage.getAnswerOfQuestion(questionsAboutImportantPage.answerOfSecondQuestion));
    }

    @Test
    public void checkTextAnswerOfThirdQuestions() {
        questionsAboutImportantPage.clickOnQuestion(questionsAboutImportantPage.thirdQuestion);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(questionsAboutImportantPage.answerOfThirdQuestion));
        Assert.assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                questionsAboutImportantPage.getAnswerOfQuestion(questionsAboutImportantPage.answerOfThirdQuestion));
    }
    @Test
    public void checkTextAnswerOfFourthQuestions() {
        questionsAboutImportantPage.clickOnQuestion(questionsAboutImportantPage.fourthQuestion);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(questionsAboutImportantPage.answerOfFourthQuestion));
        Assert.assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                questionsAboutImportantPage.getAnswerOfQuestion(questionsAboutImportantPage.answerOfFourthQuestion));
    }
    @Test
    public void checkTextAnswerOfFifthQuestions() {
        questionsAboutImportantPage.clickOnQuestion(questionsAboutImportantPage.fifthQuestion);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(questionsAboutImportantPage.answerOfFifthQuestion));
        Assert.assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                questionsAboutImportantPage.getAnswerOfQuestion(questionsAboutImportantPage.answerOfFifthQuestion));
    }
    @Test
    public void checkTextAnswerOfSixthQuestions() {
        questionsAboutImportantPage.clickOnQuestion(questionsAboutImportantPage.sixthQuestion);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(questionsAboutImportantPage.answerOfSixthQuestion));
        Assert.assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                questionsAboutImportantPage.getAnswerOfQuestion(questionsAboutImportantPage.answerOfSixthQuestion));
    }
    @Test
    public void checkTextAnswerOfSeventhQuestions() {
        questionsAboutImportantPage.clickOnQuestion(questionsAboutImportantPage.seventhQuestion);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(questionsAboutImportantPage.answerOfSeventhQuestion));
        Assert.assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                questionsAboutImportantPage.getAnswerOfQuestion(questionsAboutImportantPage.answerOfSeventhQuestion));
    }
    @Test
    public void checkTextAnswerOfEigthQuestions() {
        questionsAboutImportantPage.clickOnQuestion(questionsAboutImportantPage.eighthQuestion);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(questionsAboutImportantPage.answerOfEighthQuestion));
        Assert.assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.",
                questionsAboutImportantPage.getAnswerOfQuestion(questionsAboutImportantPage.answerOfEighthQuestion));
    }

}
