package com.champ.issuemanagement.util;

//projemizdeki tüm apilere ait pathleri tek bi yerden kontrol ediyoruz.ilerde değişiklik yapmamızı kolaylasıtırır.
public final class ApiPaths {

    private static final String BASE_PATH= "/api";

    public static final class IssueCtrl{
        public static final String Ctrl = BASE_PATH+"/issue";
    }

    public static final class ProjectCtrl{
        public static final String Ctrl = BASE_PATH+"/project";
    }
}
