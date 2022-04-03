package PageObjects;

import FileIO.fileIO;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import WebPageObjects.*;
import webPageObjects.searchHotel;
import webPageObjects.seleHotel;
import webPageObjects.logout;
import webUtilities.webActions;


public class webFunctions extends webActions {
    String orderID;
    public void Login(WebDriver driver, String strUsername, String strPassword){
        loginAdactin log = new loginAdactin(driver);

        try {
            enterData(log.txtUsernme, driver ,strUsername);

            enterData(log.txtPassword, driver ,strPassword);

            clickObject(log.btnLogin,driver);

            if(!driver.getCurrentUrl().contains("SearchHotel")){
                System.out.println("Invalid Login details or Your Password might have expired.");
            }
            else {
                System.out.println("Logged In Successfully.");
            }

        }catch (Exception e) {
            System.out.println("Login unsuccessful,Errors"+e.getMessage());
            Assert.fail();
        }
    }

    public  void search (WebDriver driver, String strLocation,String strHotels,String strRoomType,String strNumberOfRooms,String strCheckInDate,String strCheckOutDate,String strAdultsPerRoom,String strChildrenPerRoom) {
        webPageObjects.searchHotel search = new webPageObjects.searchHotel(driver);
        webPageObjects.seleHotel selHotel = new webPageObjects.seleHotel(driver);

        try {

            //Thread.sleep(2000);
            selectObject(search.location,driver ,"selectByVisibleText", strLocation);
            selectObject(search.hotels, driver,"selectByVisibleText",strHotels);
            selectObject(search.room_type,driver, "selectByVisibleText",strRoomType);
            selectObject(search.room_no, driver,"selectByVisibleText", strNumberOfRooms);
            enterData(search.check_in_date, driver ,strCheckInDate);
            enterData(search.check_out_date, driver , strCheckOutDate);
            selectObject(search.adults, driver, "selectByVisibleText",strAdultsPerRoom);
            selectObject(search.children, driver, "selectByVisibleText",strChildrenPerRoom);
            clickObject(search.submit,driver);

            if(!driver.getCurrentUrl().contains("SelectHotel")){
                System.out.println("Invalid hotel search details.");
            }
            else {
                System.out.println("Searched Successfully.");
            }

        } catch (Exception e) {
            System.out.println("search was unsuccessful,Errors" + e.getMessage());
            Assert.fail();
        }
    }


    public  void select_Hotel (WebDriver driver) {
        seleHotel selHotel = new seleHotel(driver);

        try {

            clickObject(selHotel.sel_hotel, driver);
            clickObject(selHotel.contin, driver);

            if(!driver.getCurrentUrl().contains("BookHotel")){
                System.out.println("Invalid hotel search details.");
            }
            else {
                System.out.println("Selected Successfully.");
            }
        } catch (Exception e) {
            System.out.println("select hotel was unsuccessful,Errors" + e.getMessage());
            Assert.fail();
        }
    }

    public  void Book_hotel (WebDriver driver, String FirstName,String LastName,String BilingAddress,String CreditCardType,String CreditCardNumber,String ExpiryDateMonth,String ExpiryDateYear,String CVVNumber) {
        bookHotel bookHotel = new bookHotel(driver);

        try {
            enterData(bookHotel.firstname, driver , FirstName);
            enterData(bookHotel.surname, driver , LastName);
            enterData(bookHotel.billing, driver , BilingAddress);

            enterData(bookHotel.account, driver , CreditCardNumber);
            selectObject(bookHotel.account_type, driver, "selectByVisibleText", CreditCardType);
            selectObject(bookHotel.month, driver, "selectByVisibleText", ExpiryDateMonth);
            selectObject(bookHotel.year, driver, "selectByVisibleText", ExpiryDateYear);


            enterData(bookHotel.cvv, driver , CVVNumber);

            clickObject(bookHotel.book,driver);
            WebElement ordernumber =bookHotel.orderno;
            orderID = ordernumber.getAttribute("value");

            if(!driver.getCurrentUrl().contains("BookingConfirm")){
                System.out.println("Invalid hotel search details.");
            }
            else {
                System.out.println("Booked Successfully.");
            }
        } catch (Exception e) {
            System.out.println(" successfully booked,Errors" + e.getMessage());
            Assert.fail();
        }
    }

    public void validateOrderNum(WebDriver driver){
        bookHotel bookHotel = new bookHotel(driver);

        if(!driver.getCurrentUrl().contains("BookingConfirm")){
            System.out.println("Invalid Order Number.");
        }
        else {
            String strOrderNum = bookHotel.orderno.getDomAttribute("value");
            fileIO.WriteToFile(strOrderNum);
            System.out.println("Order Number : " + strOrderNum);
        }
    }

    public  void logout (WebDriver driver) {
        logout logout = new logout(driver);

        try {
            clickObject(logout.logout,driver);

            if(!driver.getCurrentUrl().contains("Logout")){
                System.out.println("Invalid hotel search details.");
            }else {
                System.out.println("Logged out Successful");
            }

            clickObject(logout.loginAgain,driver);
        } catch (Exception e) {
            System.out.println("exception : " + e.getMessage());
            Assert.fail();
        }
    }

    public void LoggedOutSuccessfully(WebDriver driver){
        if(!driver.getCurrentUrl().contains("index")){
            System.out.println("Invalid navigation.");
        }else {
            System.out.println("------Closing The Browser------");
            driver.close();
        }
    }
    public void BookedItinerary(WebDriver driver){
        menuItems MenuItems = new menuItems(driver);

        MenuItems.bookedItinerary.click();
    }

    public void SearchExistingOrder(WebDriver driver){
        searchBooking sb = new searchBooking(driver);

        String OrderNumber = fileIO.ReadFromFile();
        enterData(sb.txtsearchOrderID,driver, OrderNumber);
        clickObject(sb.btnSearchOrder,driver);
    }

    public void ConfirmsTheBooking(WebDriver driver){
        searchBooking sb = new searchBooking(driver);
        clickObject(sb.btnRadio,driver);
        if(sb.txtorderid.equals("OIP8765009")){
            System.out.println("Booking Successfully found");
        }
    }
    public void ClicksOnCancel(WebDriver driver){
        searchBooking sb = new searchBooking(driver);
        clickObject(sb.btnRadio,driver);
        clickObject(sb.btnDelete,driver);
    }
    public void PopupMessage(WebDriver driver){
        if(driver.switchTo().alert().getText().contains("Are you sure")){
            System.out.println("popup message appears");
        }

    }

    public void ClicksOnPopupOk(WebDriver driver){
        driver.switchTo().alert().accept();
    }

    public void SuccessfullyCancelled(WebDriver driver){
        confirmDelete cd = new confirmDelete(driver);

        if(cd.errDeleteConfirmation.isDisplayed()){
            System.out.println("Booking has been successfully cancelled.");
        }
    }

    public void CreditCardNumberValidation(WebDriver driver){
        bookHotel bh = new bookHotel(driver);

        if(bh.errCCNumber.isDisplayed()){
            System.out.println("Invalid Credit Card Number. ");
        }
    }
}
