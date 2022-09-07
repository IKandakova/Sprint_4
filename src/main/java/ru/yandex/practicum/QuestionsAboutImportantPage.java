package ru.yandex.practicum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class QuestionsAboutImportantPage {
    private WebDriver driver;

    //Первый вопрос в разделе "Вопросы о важном"
    By firstQuestion = By.id("accordion__heading-0");
    //Второй вопрос в разделе "Вопросы о важном"
    By secondQuestion = By.id("accordion__heading-1");
    //Третий вопрос в разделе "Вопросы о важном"
    By thirdQuestion = By.id("accordion__heading-2");
    //Четвертый вопрос в разделе "Вопросы о важном"
    By fourthQuestion = By.id("accordion__heading-3");
    //Пятый вопрос в разделе "Вопросы о важном"
    By fifthQuestion = By.id("accordion__heading-4");
    //Шестой вопрос в разделе "Вопросы о важном"
    By sixthQuestion = By.id("accordion__heading-5");
    //Седьмой вопрос в разделе "Вопросы о важном"
    By seventhQuestion = By.id("accordion__heading-6");
    //Восьмой вопрос в разделе "Вопросы о важном"
    By eighthQuestion = By.id("accordion__heading-7");

    //Ответ на первый вопрос в разделе "Вопросы о важном"
    By answerOfFirstQuestion = By.xpath("//div[@id='accordion__panel-0']/p");
    //Ответ на второй вопрос в разделе "Вопросы о важном"
    By answerOfSecondQuestion = By.xpath("//div[@id='accordion__panel-1']/p");
    //Ответ на третий вопрос в разделе "Вопросы о важном"
    By answerOfThirdQuestion = By.xpath("//div[@id='accordion__panel-2']/p");
    //Ответ на четвертый вопрос в разделе "Вопросы о важном"
    By answerOfFourthQuestion = By.xpath("//div[@id='accordion__panel-3']/p");
    //Ответ на пятый вопрос в разделе "Вопросы о важном"
    By answerOfFifthQuestion = By.xpath("//div[@id='accordion__panel-4']/p");
    //Ответ на шестой вопрос в разделе "Вопросы о важном"
    By answerOfSixthQuestion = By.xpath("//div[@id='accordion__panel-5']/p");
    //Ответ на седьмой вопрос в разделе "Вопросы о важном"
    By answerOfSeventhQuestion = By.xpath("//div[@id='accordion__panel-6']/p");
    //Ответ на восьмой вопрос в разделе "Вопросы о важном"
    By answerOfEighthQuestion = By.xpath("//div[@id='accordion__panel-7']/p");
    By cookieButton = By.id("rcc-confirm-button");

    public QuestionsAboutImportantPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnQuestion(By question) {
        driver.findElement(question).click();
    }

    public String getAnswerOfQuestion(By answer) {
        return driver.findElement(answer).getText();
    }

    public void clickCookieButton(){
        driver.findElement(cookieButton).click();
    }
}
