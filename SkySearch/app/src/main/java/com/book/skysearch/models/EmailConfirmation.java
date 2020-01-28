package com.book.skysearch.models;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Prashant Dhillon
 * This is to send itinerary and email confirmation to user.
 * */
public class EmailConfirmation {

    /**
     * This function generate itinerary and send email to user registered address with itinerary.
     * @param context
     * @param email
     */
    public void sendEmail(Context context,String email){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto",email, null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your Ticket Has Been Booked");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Please find your itinerary in this mail");
        context.startActivity(Intent.createChooser(emailIntent, "Send email..."));

    }
}

