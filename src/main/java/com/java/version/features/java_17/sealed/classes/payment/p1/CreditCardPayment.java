package com.java.version.features.java_17.sealed.classes.payment.p1;

import com.java.version.features.java_17.sealed.classes.payment.p2.HDFCCreditCard;

//public class CreditCardPayment extends Payment {
//public final class CreditCardPayment extends Payment {
//public sealed class CreditCardPayment extends Payment permits ICICCreditCard, HDFCCreditCard {
public sealed class CreditCardPayment extends Payment permits ICICCreditCard {
}
