package za.co.cascott.splashscreen;

public interface ISplashScreen {

    public void showSplashScreen();

    public void hideSplashScreen();

    public void setVersion(String version);

    public void setProgressBarText(String text);

    public void setCenter(Boolean center);

    public void setIndeterminate(boolean in);

    public void setProgressBarValue(int value);

}
