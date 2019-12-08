package com.groupproject.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GenerateAccountNumber {

    public static long getNewId() {
        StringBuilder sb = new StringBuilder();
        Random r = new Random();

        for (int i = 1; i <= 6; i++) {
            sb.append(Integer.toString(r.nextInt(10)));
        }

        DateFormat df = new SimpleDateFormat("YYMMdd");
        return Long.parseLong((df.format(new Date()) + sb.toString()));
    }
}
