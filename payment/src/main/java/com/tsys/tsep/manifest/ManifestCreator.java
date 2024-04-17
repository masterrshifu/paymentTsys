package com.tsys.tsep.manifest;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ManifestCreator {

    private static final int MERCHANT_ID_LENGTH = 20;
    private static final int DEVICE_ID_LENGTH = 24;
    private static final int AMOUNT_LENGTH = 12;
    private static final String DATE_FORMAT = "MMddyyyy";

    private static final String merchantId = "887000000352";
    private static final String deviceId = "88700000035204";
    private static final int amount = 0;




    public static String createManifestString(String merchantID, String deviceID, int amount) {

        String paddedMerchantID = padString(merchantID, MERCHANT_ID_LENGTH);
        String paddedDeviceID = padString(deviceID, DEVICE_ID_LENGTH);
        String paddedAmount = padWithZeroes(String.valueOf(amount), AMOUNT_LENGTH);
        String formattedDate = formatDate(new Date());

        String manifestString = paddedMerchantID + paddedDeviceID + paddedAmount + formattedDate;
        System.out.println(manifestString);

        return paddedMerchantID + paddedDeviceID + paddedAmount + formattedDate;
    }

    private static String padString(String input, int length) {
        if (input.length() >= length) {
            return input.substring(0, length);
        } else {
            return String.format("%-" + length + "s", input);
        }
    }

    private static String padWithZeroes(String original, int length) {

        // %0Nd means pad with zeroes to a width of N
        String formatString = "%0" + length + "d";

        // Assuming the original string represents a number
        int originalNumber = Integer.parseInt(original);

        // Format the number using the specified width and pad with zeroes
        return String.format(formatString, originalNumber);

    }

    private static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(date);
    }

    public static void main(String[] args) {
        // Example usage

        String manifestString = createManifestString(merchantId , deviceId , amount);
        System.out.println("Manifest String: " + manifestString);
    }
}
