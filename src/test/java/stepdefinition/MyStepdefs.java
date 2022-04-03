package stepdefinition;

import PageObjects.webFunctions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import data.data;
import data.Booking;
import webUtilities.webUtilities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyStepdefs {
    webUtilities web = new webUtilities();
    webFunctions adactin = new webFunctions();
    ResultSet bookingRS = null;

    @Before
    public void getBookingData(){
        System.out.println("------Connecting to the database------");
        bookingRS = data.loadfromDatabase();
    }

    @Given("^a user launches \"(.*?)\" and navigates to the Adactin web page \"(.*?)\"$")
    public void a_user_launches_and_navigates_to_the_Adactin_web_page(String arg1, String arg2) {
        web.initializeWebDriver(arg1);
        web.navigate(arg2);
    }

    @When("^a user enters the \"(.*?)\" and \"(.*?)\" and clicks login$")
    public void a_user_enters_the_and_and_clicks_login(String arg1, String arg2) {
        adactin.Login(web.getWebDriver(), arg1, arg2);
    }

    @When("^a user populates fields in the search page and clicks continue$")
    public void a_user_populates_fields_in_the_search_page_and_clicks_continue() {
        try {
            if(bookingRS.next()){
                adactin.search(web.getWebDriver(),bookingRS.getString("Location"), bookingRS.getString("Hotels"), bookingRS.getString("RoomType"),bookingRS.getString("NumberOfRooms"),bookingRS.getString("CheckInDate"),bookingRS.getString("CheckOutDate"),bookingRS.getString("AdultsPerRoom"),bookingRS.getString("ChildrenPerRoom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @When("^a user selects a hotel from the selection page and click continue$")
    public void a_user_selects_a_hotel_from_the_selection_page_and_click_continue() {
        adactin.select_Hotel(web.getWebDriver());
    }

    @When("^a user populates the book with valid data and clicks confirm$")
    public void a_user_populates_the_book_with_valid_data_and_clicks_confirm() {

        try {
            if(bookingRS != null){
                adactin.Book_hotel(web.getWebDriver(),bookingRS.getString("FirstName"),bookingRS.getString("LastName"),bookingRS.getString("BillingAddress"),bookingRS.getString("CreditCardType"),bookingRS.getString("CreditCardNumber"),bookingRS.getString("ExpiryDateMonth"),bookingRS.getString("ExpiryDateYear"),bookingRS.getString("CVVNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Then("^a order is generated and the booking is successful$")
    public void a_order_is_generated_and_the_booking_is_successful() {
        adactin.validateOrderNum(web.getWebDriver());
    }

    //@When("^a user clicks logout$")
    @After
    public void a_user_clicks_logout() {
        adactin.logout(web.getWebDriver());
    }

    //@Then("^a user is successfully logged out$")
    @After
    public void a_user_is_successfully_logged_out() {
        adactin.LoggedOutSuccessfully(web.getWebDriver());
        try {
            //running the next row on the database
            if(bookingRS.isLast()){
                a_user_launches_and_navigates_to_the_Adactin_web_page("chrome","http://adactinhotelapp.com");
                a_user_enters_the_and_and_clicks_login("AutoTestb","84JLRY");
                a_user_populates_fields_in_the_search_page_and_clicks_continue();
                a_user_selects_a_hotel_from_the_selection_page_and_click_continue();
                a_user_populates_the_book_with_valid_data_and_clicks_confirm();
                a_order_is_generated_and_the_booking_is_successful();
                a_user_clicks_logout();
                a_user_is_successfully_logged_out();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @When("^Clicks on Booked Itinerary$")
    public void clicks_on_Booked_Itinerary() {
        adactin.BookedItinerary(web.getWebDriver());
    }

    @When("^enters the \"(.*?)\" for an existing order and clicks on search$")
    public void enters_the_for_an_existing_order_and_clicks_on_search(String arg1) {
        //adactin.SearchExistingOrder(web.getWebDriver(),arg1);
    }

    @Then("^a user confirms the booking$")
    public void a_user_confirms_the_booking() {
        adactin.ConfirmsTheBooking(web.getWebDriver());
    }

    @When("^a user clicks on cancel$")
    public void a_user_clicks_on_cancel() {
        adactin.ClicksOnCancel(web.getWebDriver());
    }

    @Then("^a confirm cancel popup message appears$")
    public void a_confirm_cancel_popup_message_appears() {
        adactin.PopupMessage(web.getWebDriver());
    }

    @When("^a user clicks on ok$")
    public void a_user_clicks_on_ok() {
        adactin.ClicksOnPopupOk(web.getWebDriver());
    }

    @Then("^booking is successfully cancelled$")
    public void booking_is_successfully_cancelled() {
        adactin.SuccessfullyCancelled(web.getWebDriver());
    }

    @When("^a user populates the book with valid data except credit card number which is invalid and clicks confirm \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\"$")
    public void a_user_populates_the_book_with_valid_data_except_credit_card_number_which_is_invalid_and_clicks_confirm(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8) {
        adactin.Book_hotel(web.getWebDriver(),arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    }

    @When("^a user is notified of the invalid credit card number$")
    public void a_user_is_notified_of_the_invalid_credit_card_number() {
        adactin.CreditCardNumberValidation(web.getWebDriver());
    }

    @And("^User enters the Order number for an existing order and clicks on search$")
    public void userEntersTheOrderNumberForAnExistingOrderAndClicksOnSearch() {
        adactin.SearchExistingOrder(web.getWebDriver());
    }
}
