package com.assignment.intellify.network;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

class TokenCookieJar implements CookieJar {

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {

    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        Cookie cookie = new Cookie.Builder()
                .name("token")
                .domain("services.intellify.in")
                .value("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwaG9uZSI6ODM2ODgwNTkwM30.sQisPnG7Iorhdp-5i6wLpu4GZtedwaMbXtf2y6kcnEc")
                .build();
        ArrayList<Cookie> cookies = new ArrayList<>();
        cookies.add(cookie);
        return cookies;
    }
}
