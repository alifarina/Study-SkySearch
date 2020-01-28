package com.book.skysearch.models;


/**
 * Created by Prashant Dhillon
 * This class take the user card information to process the payment.
 */
public class Payment {
    /**
     *
     * @param cardno This is user card no
     * @param expiredate This is user card's expire date
     * @param cvv User's card cvv no
     *
     *  This function takes user card information to process the payment by third party bank gateway.
     */

    private void AcceptPayment(String cardno, String expiredate, String cvv){
        System system = new System();
        system.AcceptPayment(cardno, expiredate, cvv)
    }

}
