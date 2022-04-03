package data;

public class Booking {
    public String location;
    public String Hotels;
    public String RoomType;
    public String NumberOfRooms;
    public String CheckInDate;
    public String CheckOutDate;
    public String AdultsPerRoom;
    public String ChildrenPerRoom;
    public String FirstName;
    public String LastName;
    public String BilingAddress;
    public String CreditCardType;
    public String CreditCardNumber;
    public String ExpiryDateMonth;
    public String ExpiryDateYear;
    public String CVVNumber;

    public Booking(String location, String hotels, String roomType, String numberOfRooms, String checkInDate, String checkOutDate, String adultsPerRoom, String childrenPerRoom, String firstName, String lastName, String bilingAddress, String creditCardType, String creditCardNumber, String expiryDateMonth, String expiryDateYear, String CVVNumber) {
        this.location = location;
        Hotels = hotels;
        RoomType = roomType;
        NumberOfRooms = numberOfRooms;
        CheckInDate = checkInDate;
        CheckOutDate = checkOutDate;
        AdultsPerRoom = adultsPerRoom;
        ChildrenPerRoom = childrenPerRoom;
        FirstName = firstName;
        LastName = lastName;
        BilingAddress = bilingAddress;
        CreditCardType = creditCardType;
        CreditCardNumber = creditCardNumber;
        ExpiryDateMonth = expiryDateMonth;
        ExpiryDateYear = expiryDateYear;
        this.CVVNumber = CVVNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHotels() {
        return Hotels;
    }

    public void setHotels(String hotels) {
        Hotels = hotels;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String roomType) {
        RoomType = roomType;
    }

    public String getNumberOfRooms() {
        return NumberOfRooms;
    }

    public void setNumberOfRooms(String numberOfRooms) {
        NumberOfRooms = numberOfRooms;
    }

    public String getCheckInDate() {
        return CheckInDate;
    }

    public void setCheckInDate(String checkInDate) {
        CheckInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return CheckOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        CheckOutDate = checkOutDate;
    }

    public String getAdultsPerRoom() {
        return AdultsPerRoom;
    }

    public void setAdultsPerRoom(String adultsPerRoom) {
        AdultsPerRoom = adultsPerRoom;
    }

    public String getChildrenPerRoom() {
        return ChildrenPerRoom;
    }

    public void setChildrenPerRoom(String childrenPerRoom) {
        ChildrenPerRoom = childrenPerRoom;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getBilingAddress() {
        return BilingAddress;
    }

    public void setBilingAddress(String bilingAddress) {
        BilingAddress = bilingAddress;
    }

    public String getCreditCardType() {
        return CreditCardType;
    }

    public void setCreditCardType(String creditCardType) {
        CreditCardType = creditCardType;
    }

    public String getCreditCardNumber() {
        return CreditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        CreditCardNumber = creditCardNumber;
    }

    public String getExpiryDateMonth() {
        return ExpiryDateMonth;
    }

    public void setExpiryDateMonth(String expiryDateMonth) {
        ExpiryDateMonth = expiryDateMonth;
    }

    public String getExpiryDateYear() {
        return ExpiryDateYear;
    }

    public void setExpiryDateYear(String expiryDateYear) {
        ExpiryDateYear = expiryDateYear;
    }

    public String getCVVNumber() {
        return CVVNumber;
    }

    public void setCVVNumber(String CVVNumber) {
        this.CVVNumber = CVVNumber;
    }
}
