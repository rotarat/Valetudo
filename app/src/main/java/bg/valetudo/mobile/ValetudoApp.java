package bg.valetudo.mobile;

import android.app.Application;

public class ValetudoApp extends Application {
    private static ValetudoApp singleton;

    public static ValetudoApp getInstance(){
        return singleton;
    }
    @Override
    public void onCreate() {

        super.onCreate();
        singleton = this;
    }
}
