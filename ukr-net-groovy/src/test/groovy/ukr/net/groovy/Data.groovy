package ukr.net.groovy

import com.google.gson.annotations.SerializedName

class Url {
    String url

    Url(String url) {
        this.url = url
    }
}

class DesiredCapabilities {

    Capabilities desiredCapabilities;

    DesiredCapabilities(String browser) {
        desiredCapabilities = new Capabilities(browser);
    }

}

class Capabilities {
    String browserName;

    @SerializedName("goog:chromeOptions")
    ChromeOptions chromeOptions = new ChromeOptions();

    Capabilities(String browser) {
        browserName = browser
    }
}

class ChromeOptions {

    String[] args
    String[] extensions

    ChromeOptions() {
        args = []
        extensions = []
    }

    ChromeOptions(String[] args, String[] extensions) {
        this.args = args
        this.extensions = extensions
    }
}

class StringBodies {
    static String getCapabilitiesBody(String browser) {
        return '''
            {
              "desiredCapabilities": {
                    "browserName": "${browser}",
                    "goog:chromeOptions": {
                            "args": [],
                            "extensions": []
                            }
                    }
            }
            '''
    }
}