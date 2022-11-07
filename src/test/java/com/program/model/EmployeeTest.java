package com.program.model;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeTest;

public class EmployeeTest {

    Employee employee = new Employee();

    @BeforeTest
    public void generateData() {
        Faker fakeData = new Faker();
        employee.setFirstName(fakeData.name().firstName());
        employee.setLastName(fakeData.name().lastName());
        employee.setInterests(fakeData.internet().domainWord());
        employee.setPhoneNumber(fakeData.phoneNumber().cellPhone());
        employee.setEmail(fakeData.internet().emailAddress());
        employee.setDesignation(fakeData.job().position());
    }

    @Test
    public void registerEmployee(){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.get("<https://sajithatharaka.github.io/employee_registration/default/basic_details.html>");
//        driver.findElement(By.id("fname")).sendKeys(employee.getFirstName());
//        driver.findElement(By.id("lname")).sendKeys(employee.getLastName());
//        driver.findElement(By.id("interest")).sendKeys(employee.getInterests());
//        driver.findElement(By.xpath("//a[text()='Next']")).click();
//        driver.findElement(By.id("phone")).sendKeys(employee.getPhoneNumber());
//        driver.findElement(By.id("email")).sendKeys(employee.getEmail());
//        driver.findElement(By.xpath("//a[text()='Next']")).click();
//        driver.findElement(By.id("designation")).sendKeys(employee.getDesignation());
//        driver.findElement(By.xpath("//a[text()='Next']")).click();
    }

}
