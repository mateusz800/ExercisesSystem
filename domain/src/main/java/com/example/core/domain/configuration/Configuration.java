package com.example.core.domain.configuration;

public class Configuration {
    /**
     * Private key, which is used to authorization
     */
    private static final String AUTH_KEY = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAMng33fVqt+1vUCurYOmBbAXdBRlc9PZ\n" +
            "3bxICEqG02T/Y5NO/0XWldMj363q9ocE24Ik1SVDnzn6I5RnCvUqW7ECAwEAAQ==";

    public static String getAuthKey(){
        return AUTH_KEY;
    }
}
