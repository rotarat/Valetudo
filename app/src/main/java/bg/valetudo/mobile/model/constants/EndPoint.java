package bg.valetudo.mobile.model.constants;

public class EndPoint {
    private static final String BASE_URL = "http://192.168.10.109:8080";

    // ##### LOGIN & REGISTRATION #####
    public static final String LOGIN = BASE_URL + "/login";
    public static final String REGISTER = BASE_URL + "/auth/register";

    // ##### USER DATA #####
    public static final String USER_DATA = BASE_URL + "/userData";

    // ##### DAILY #####
    public static final String DAILY_FOOD_INTAKE = BASE_URL + "/daily/foodIntake";
}
