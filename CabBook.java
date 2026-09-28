import java.util.*;


// =====================================================
// INTERFACE
// =====================================================

interface Bookable
{
    void bookCab();
    void cancelBooking();
}


// =====================================================
// ABSTRACT CLASS - PERSON
// =====================================================

abstract class Person
{
    private int id;
    private String name;
    private String phoneNumber;

    public Person(
        int id,
        String name,
        String phoneNumber
    )
    {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getter methods

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    // Abstract method

    public abstract void displayDetails();
}


// =====================================================
// CUSTOMER CLASS
// =====================================================

class Customer extends Person
{
    public Customer(
        int id,
        String name,
        String phoneNumber
    )
    {
        super(id, name, phoneNumber);
    }

    @Override
    public void displayDetails()
    {
        System.out.println("Customer ID   : " + getId());
        System.out.println("Customer Name : " + getName());
        System.out.println("Phone Number  : " + getPhoneNumber());
    }
}


// =====================================================
// DRIVER CLASS
// =====================================================

class Driver extends Person
{
    private String drivingLicense;
    private boolean available;

    public Driver(
        int id,
        String name,
        String phoneNumber,
        String drivingLicense
    )
    {
        super(id, name, phoneNumber);

        this.drivingLicense = drivingLicense;
        this.available = true;
    }

    public String getDrivingLicense()
    {
        return drivingLicense;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public void setAvailable(boolean available)
    {
        this.available = available;
    }

    @Override
    public void displayDetails()
    {
        System.out.println(
            "Driver ID      : " + getId()
        );

        System.out.println(
            "Driver Name    : " + getName()
        );

        System.out.println(
            "Phone Number   : " + getPhoneNumber()
        );

        System.out.println(
            "Driving License: " + drivingLicense
        );

        System.out.println(
            "Available      : " +
            (available ? "Yes" : "No")
        );
    }
}


// =====================================================
// ABSTRACT CLASS - CAB
// =====================================================

abstract class Cab
{
    private int cabId;
    private String cabNumber;
    private String cabModel;
    private boolean available;

    public Cab(
        int cabId,
        String cabNumber,
        String cabModel
    )
    {
        this.cabId = cabId;
        this.cabNumber = cabNumber;
        this.cabModel = cabModel;

        available = true;
    }

    // Getter methods

    public int getCabId()
    {
        return cabId;
    }

    public String getCabNumber()
    {
        return cabNumber;
    }

    public String getCabModel()
    {
        return cabModel;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public void setAvailable(boolean available)
    {
        this.available = available;
    }

    // Abstract method

    public abstract double calculateFare(
        double distance
    );

    public abstract String getCabType();

    // Display cab details

    public void displayDetails()
    {
        System.out.println(
            "Cab ID      : " + cabId
        );

        System.out.println(
            "Cab Number  : " + cabNumber
        );

        System.out.println(
            "Cab Model   : " + cabModel
        );

        System.out.println(
            "Cab Type    : " + getCabType()
        );

        System.out.println(
            "Available   : " +
            (available ? "Yes" : "No")
        );
    }
}


// =====================================================
// MINI CAB
// =====================================================

class MiniCab extends Cab
{
    public MiniCab(
        int cabId,
        String cabNumber,
        String cabModel
    )
    {
        super(
            cabId,
            cabNumber,
            cabModel
        );
    }

    @Override
    public double calculateFare(
        double distance
    )
    {
        return 50 + (distance * 12);
    }

    @Override
    public String getCabType()
    {
        return "Mini";
    }
}


// =====================================================
// SEDAN CAB
// =====================================================

class SedanCab extends Cab
{
    public SedanCab(
        int cabId,
        String cabNumber,
        String cabModel
    )
    {
        super(
            cabId,
            cabNumber,
            cabModel
        );
    }

    @Override
    public double calculateFare(
        double distance
    )
    {
        return 80 + (distance * 16);
    }

    @Override
    public String getCabType()
    {
        return "Sedan";
    }
}


// =====================================================
// SUV CAB
// =====================================================

class SUVCab extends Cab
{
    public SUVCab(
        int cabId,
        String cabNumber,
        String cabModel
    )
    {
        super(
            cabId,
            cabNumber,
            cabModel
        );
    }

    @Override
    public double calculateFare(
        double distance
    )
    {
        return 120 + (distance * 22);
    }

    @Override
    public String getCabType()
    {
        return "SUV";
    }
}


// =====================================================
// PAYMENT CLASS
// =====================================================

class Payment
{
    private double amount;
    private String paymentMethod;

    public Payment(
        double amount,
        String paymentMethod
    )
    {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public void makePayment()
    {
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("             PAYMENT");
        System.out.println("----------------------------------------");

        System.out.println(
            "Amount         : Rs. " + amount
        );

        System.out.println(
            "Payment Method : " + paymentMethod
        );

        System.out.println(
            "Payment Status : Successful"
        );
    }
}


// =====================================================
// BOOKING CLASS
// =====================================================

class Booking implements Bookable
{
    private int bookingId;
    private Customer customer;
    private Driver driver;
    private Cab cab;

    private String pickupLocation;
    private String destination;

    private double distance;
    private double totalFare;

    private String status;

    public Booking(
        int bookingId,
        Customer customer,
        Driver driver,
        Cab cab,
        String pickupLocation,
        String destination,
        double distance
    )
    {
        this.bookingId = bookingId;
        this.customer = customer;
        this.driver = driver;
        this.cab = cab;

        this.pickupLocation = pickupLocation;
        this.destination = destination;

        this.distance = distance;

        totalFare =
            cab.calculateFare(distance);

        status = "Pending";
    }


    public int getBookingId()
    {
        return bookingId;
    }

    public Cab getCab()
    {
        return cab;
    }

    public Driver getDriver()
    {
        return driver;
    }

    public double getTotalFare()
    {
        return totalFare;
    }

    public String getStatus()
    {
        return status;
    }


    // Book cab

    @Override
    public void bookCab()
    {
        if(cab.isAvailable() &&
           driver.isAvailable())
        {
            cab.setAvailable(false);
            driver.setAvailable(false);

            status = "Confirmed";

            System.out.println();
            System.out.println(
                "Cab booked successfully!"
            );
        }
        else
        {
            System.out.println();
            System.out.println(
                "Cab or driver is not available."
            );
        }
    }


    // Cancel booking

    @Override
    public void cancelBooking()
    {
        if(status.equals("Confirmed"))
        {
            cab.setAvailable(true);
            driver.setAvailable(true);

            status = "Cancelled";

            System.out.println(
                "Booking cancelled successfully."
            );
        }
        else
        {
            System.out.println(
                "Booking cannot be cancelled."
            );
        }
    }


    // Complete ride

    public void completeRide()
    {
        if(status.equals("Confirmed"))
        {
            cab.setAvailable(true);
            driver.setAvailable(true);

            status = "Completed";

            System.out.println();
            System.out.println(
                "Ride completed successfully."
            );
        }
        else
        {
            System.out.println();
            System.out.println(
                "Ride cannot be completed."
            );
        }
    }


    // Display booking details

    public void displayBooking()
    {
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println(
            "Booking ID      : " + bookingId
        );

        System.out.println(
            "Customer Name   : " + customer.getName()
        );

        System.out.println(
            "Driver Name     : " + driver.getName()
        );

        System.out.println(
            "Cab Number      : " + cab.getCabNumber()
        );

        System.out.println(
            "Cab Type        : " + cab.getCabType()
        );

        System.out.println(
            "Pickup Location : " + pickupLocation
        );

        System.out.println(
            "Destination     : " + destination
        );

        System.out.println(
            "Distance        : " + distance + " km"
        );

        System.out.println(
            "Total Fare      : Rs. " + totalFare
        );

        System.out.println(
            "Status          : " + status
        );

        System.out.println("----------------------------------------");
    }
}


// =====================================================
// MAIN CLASS
// FILE NAME: CabBook.java
// =====================================================

public class CabBook
{
    static Scanner sc = new Scanner(System.in);

    static ArrayList<Cab> cabs =
        new ArrayList<>();

    static ArrayList<Driver> drivers =
        new ArrayList<>();

    static ArrayList<Booking> bookings =
        new ArrayList<>();


    static int nextBookingId = 1001;


    // =================================================
    // ADD DEFAULT CABS
    // =================================================

    public static void addCabs()
    {
        cabs.add(
            new MiniCab(
                1,
                "RJ14AB1234",
                "Maruti WagonR"
            )
        );

        cabs.add(
            new SedanCab(
                2,
                "RJ14CD5678",
                "Honda City"
            )
        );

        cabs.add(
            new SUVCab(
                3,
                "RJ14EF9012",
                "Toyota Innova"
            )
        );
    }


    // =================================================
    // ADD DEFAULT DRIVERS
    // =================================================

    public static void addDrivers()
    {
        drivers.add(
            new Driver(
                101,
                "Rahul",
                "9876543210",
                "DL12345"
            )
        );

        drivers.add(
            new Driver(
                102,
                "Amit",
                "9876543211",
                "DL12346"
            )
        );

        drivers.add(
            new Driver(
                103,
                "Vikas",
                "9876543212",
                "DL12347"
            )
        );
    }


    // =================================================
    // DISPLAY AVAILABLE CABS
    // =================================================

    public static void showAvailableCabs()
    {
        System.out.println();
        System.out.println("========================================");
        System.out.println("          AVAILABLE CABS");
        System.out.println("========================================");

        boolean found = false;

        for(Cab cab : cabs)
        {
            if(cab.isAvailable())
            {
                cab.displayDetails();

                System.out.println("----------------------------------------");

                found = true;
            }
        }

        if(!found)
        {
            System.out.println(
                "No cabs are available."
            );
        }
    }


    // =================================================
    // DISPLAY ALL CABS
    // =================================================

    public static void showAllCabs()
    {
        System.out.println();
        System.out.println("========================================");
        System.out.println("              ALL CABS");
        System.out.println("========================================");

        for(Cab cab : cabs)
        {
            cab.displayDetails();

            System.out.println("----------------------------------------");
        }
    }


    // =================================================
    // BOOK CAB
    // =================================================

    public static void bookCab()
    {
        System.out.println();
        System.out.println("========================================");
        System.out.println("              BOOK CAB");
        System.out.println("========================================");


        // Customer details

        System.out.print(
            "Enter Customer Name: "
        );

        String customerName =
            sc.nextLine();


        System.out.print(
            "Enter Phone Number: "
        );

        String phoneNumber =
            sc.nextLine();


        Customer customer =
            new Customer(
                1,
                customerName,
                phoneNumber
            );


        // Pickup location

        System.out.print(
            "Enter Pickup Location: "
        );

        String pickupLocation =
            sc.nextLine();


        // Destination

        System.out.print(
            "Enter Destination: "
        );

        String destination =
            sc.nextLine();


        // Distance

        System.out.print(
            "Enter Distance in KM: "
        );

        double distance =
            Double.parseDouble(
                sc.nextLine()
            );


        if(distance <= 0)
        {
            System.out.println(
                "Distance must be greater than 0."
            );

            return;
        }


        // Show available cabs

        showAvailableCabs();


        System.out.print(
            "Enter Cab ID: "
        );

        int cabId =
            Integer.parseInt(
                sc.nextLine()
            );


        // Find selected cab

        Cab selectedCab = null;

        for(Cab cab : cabs)
        {
            if(cab.getCabId() == cabId &&
               cab.isAvailable())
            {
                selectedCab = cab;

                break;
            }
        }


        if(selectedCab == null)
        {
            System.out.println(
                "Invalid or unavailable cab."
            );

            return;
        }


        // Find available driver

        Driver selectedDriver = null;

        for(Driver driver : drivers)
        {
            if(driver.isAvailable())
            {
                selectedDriver = driver;

                break;
            }
        }


        if(selectedDriver == null)
        {
            System.out.println(
                "No driver is available."
            );

            return;
        }


        // Create booking

        Booking booking =
            new Booking(
                nextBookingId,
                customer,
                selectedDriver,
                selectedCab,
                pickupLocation,
                destination,
                distance
            );


        booking.bookCab();


        if(booking.getStatus().equals("Confirmed"))
        {
            bookings.add(booking);

            nextBookingId++;


            System.out.println();
            System.out.println("----------------------------------------");

            System.out.println(
                "Booking ID   : " +
                booking.getBookingId()
            );

            System.out.println(
                "Driver       : " +
                selectedDriver.getName()
            );

            System.out.println(
                "Cab          : " +
                selectedCab.getCabNumber()
            );

            System.out.println(
                "Cab Type     : " +
                selectedCab.getCabType()
            );

            System.out.println(
                "Total Fare   : Rs. " +
                booking.getTotalFare()
            );

            System.out.println("----------------------------------------");


            // Payment

            System.out.println();
            System.out.println(
                "Select Payment Method:"
            );

            System.out.println(
                "1. Cash"
            );

            System.out.println(
                "2. UPI"
            );

            System.out.println(
                "3. Card"
            );


            System.out.print(
                "Enter choice: "
            );


            int paymentChoice =
                Integer.parseInt(
                    sc.nextLine()
                );


            String paymentMethod;


            if(paymentChoice == 1)
            {
                paymentMethod = "Cash";
            }
            else if(paymentChoice == 2)
            {
                paymentMethod = "UPI";
            }
            else if(paymentChoice == 3)
            {
                paymentMethod = "Card";
            }
            else
            {
                paymentMethod = "Cash";

                System.out.println(
                    "Invalid choice. Cash selected."
                );
            }


            Payment payment =
                new Payment(
                    booking.getTotalFare(),
                    paymentMethod
                );


            payment.makePayment();
        }
    }


    // =================================================
    // SHOW ALL BOOKINGS
    // =================================================

    public static void showAllBookings()
    {
        System.out.println();
        System.out.println("========================================");
        System.out.println("           ALL BOOKINGS");
        System.out.println("========================================");


        if(bookings.isEmpty())
        {
            System.out.println(
                "No bookings found."
            );

            return;
        }


        for(Booking booking : bookings)
        {
            booking.displayBooking();
        }
    }


    // =================================================
    // COMPLETE RIDE
    // =================================================

    public static void completeRide()
    {
        System.out.println();
        System.out.println("========================================");
        System.out.println("           COMPLETE RIDE");
        System.out.println("========================================");


        if(bookings.isEmpty())
        {
            System.out.println(
                "No bookings found."
            );

            return;
        }


        System.out.print(
            "Enter Booking ID: "
        );


        int bookingId =
            Integer.parseInt(
                sc.nextLine()
            );


        for(Booking booking : bookings)
        {
            if(booking.getBookingId() == bookingId)
            {
                booking.completeRide();

                return;
            }
        }


        System.out.println(
            "Booking ID not found."
        );
    }


    // =================================================
    // CANCEL BOOKING
    // =================================================

    public static void cancelBooking()
    {
        System.out.println();
        System.out.println("========================================");
        System.out.println("          CANCEL BOOKING");
        System.out.println("========================================");


        if(bookings.isEmpty())
        {
            System.out.println(
                "No bookings found."
            );

            return;
        }


        System.out.print(
            "Enter Booking ID: "
        );


        int bookingId =
            Integer.parseInt(
                sc.nextLine()
            );


        for(Booking booking : bookings)
        {
            if(booking.getBookingId() == bookingId)
            {
                booking.cancelBooking();

                return;
            }
        }


        System.out.println(
            "Booking ID not found."
        );
    }


    // =================================================
    // MAIN METHOD
    // =================================================

    public static void main(String[] args)
    {
        addCabs();

        addDrivers();


        while(true)
        {
            try
            {
                System.out.println();
                System.out.println("========================================");
                System.out.println("       CAB BOOKING MANAGEMENT SYSTEM");
                System.out.println("========================================");


                System.out.println(
                    "1. Book Cab"
                );

                System.out.println(
                    "2. View Available Cabs"
                );

                System.out.println(
                    "3. View All Cabs"
                );

                System.out.println(
                    "4. View All Bookings"
                );

                System.out.println(
                    "5. Complete Ride"
                );

                System.out.println(
                    "6. Cancel Booking"
                );

                System.out.println(
                    "7. Exit"
                );


                System.out.print(
                    "Enter your choice: "
                );


                int choice =
                    Integer.parseInt(
                        sc.nextLine()
                    );


                if(choice == 1)
                {
                    bookCab();
                }
                else if(choice == 2)
                {
                    showAvailableCabs();
                }
                else if(choice == 3)
                {
                    showAllCabs();
                }
                else if(choice == 4)
                {
                    showAllBookings();
                }
                else if(choice == 5)
                {
                    completeRide();
                }
                else if(choice == 6)
                {
                    cancelBooking();
                }
                else if(choice == 7)
                {
                    System.out.println();
                    System.out.println(
                        "Thank you for using " +
                        "Cab Booking Management System!"
                    );

                    break;
                }
                else
                {
                    System.out.println(
                        "Invalid choice. Please try again."
                    );
                }
            }


            // =========================================
            // NUMBER FORMAT EXCEPTION
            // =========================================

            catch(NumberFormatException e)
            {
                System.out.println();

                System.out.println(
                    "Please enter a valid number."
                );
            }


            // =========================================
            // GENERAL EXCEPTION
            // =========================================

            catch(Exception e)
            {
                System.out.println();

                System.out.println(
                    "Something went wrong: " +
                    e.getMessage()
                );
            }
        }


        sc.close();
    }
}