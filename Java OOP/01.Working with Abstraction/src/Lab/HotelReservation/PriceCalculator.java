package Lab.HotelReservation;

public class PriceCalculator {

    public static double calculateHolidayPrice (double pricePerDay, int days, Season season, DiscountType discountType){
        //Сума за всички дни
        double priceForAllDays = pricePerDay * days;

        //умножение спрямо сезона
        priceForAllDays *= season.getMultiplyCoefficient();

        //отстъпка
        priceForAllDays = priceForAllDays - priceForAllDays * (discountType.getPercent() / 100);

        return priceForAllDays;
    }
}
