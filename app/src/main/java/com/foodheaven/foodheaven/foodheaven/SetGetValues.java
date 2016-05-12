package com.foodheaven.foodheaven.foodheaven;

public class SetGetValues {


    private static String cuisineSelection = "";
    private static String PopulateTotalOrders = "";


    public static int getTotalprices() {
        return totalprices;
    }

    public static void setTotalprices(int totalprices) {


        SetGetValues.totalprices = SetGetValues.totalprices + totalprices;
    }

    private static int totalprices;

    public static String getPopulateTotalOrders() {
        return PopulateTotalOrders;
    }

    public static void setPopulateTotalOrders(String populateTotalOrders) {

        PopulateTotalOrders = PopulateTotalOrders +"\n"+ populateTotalOrders;
    }

    public static String getCuisineSelection() {
        return cuisineSelection;
    }

    public static void setCuisineSelection(String cuisineSelection) {
        SetGetValues.cuisineSelection = cuisineSelection;
    }
}
