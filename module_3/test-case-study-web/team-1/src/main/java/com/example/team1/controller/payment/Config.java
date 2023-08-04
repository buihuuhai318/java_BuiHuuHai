package com.example.team1.controller.payment;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Config {
    public static final String vnp_Version = "2.1.0";
    public static final String vnp_Command = "pay";
    public static final String vnp_TmnCode = "P9UI0NFR"; // Mã website đăng ký tại VNPAY
    public static final String vnp_ReturnUrl = "http://localhost:8080/PaymentServlet"; // URL trả về sau khi thanh toán thành công hoặc thất bại
    public static final String vnp_PayUrl = " https://sandbox.vnpayment.vn/paymentv2/vpcpay.html"; // URL của cổng thanh toán VNPAY

    // Thông tin bảo mật, hãy thay thế bằng thông tin từ tài khoản đăng ký tại VNPAY
    public static final String vnp_HashSecret = "MBICGDRGOYFZGCXMIODYLVJRPJLKRPKB";

    public static String getRandomNumber(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static String hmacSHA512(String key, String data) {
        try {
            Mac sha512Hmac = Mac.getInstance("HmacSHA512");
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA512");
            sha512Hmac.init(secretKeySpec);
            byte[] hmacData = sha512Hmac.doFinal(data.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(hmacData.length * 2);
            for (byte b : hmacData) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
            return "";
        }
    }
}
