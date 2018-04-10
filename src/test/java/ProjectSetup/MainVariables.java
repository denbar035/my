package ProjectSetup;

import Library.ConfigReader;

/**
 * Created by denys on 4/7/18.
 */
public class MainVariables {

    ConfigReader configReader = new ConfigReader();
    public MainVariables(){
        setVariables();
    }
    public String env = configReader.getConfValues("env");

    public String url;
    public String dbUrl;

    public void setVariables(){
        if(env.equalsIgnoreCase("prod")){
            url = "https://rozetka.com.ua";
            dbUrl = "jdbc:mysql://localhost:3306/rozetka_prod";
        }
        else if (env.equalsIgnoreCase("stage")){

        }
        else if (env.equalsIgnoreCase("dev")){

        }
    }
}
