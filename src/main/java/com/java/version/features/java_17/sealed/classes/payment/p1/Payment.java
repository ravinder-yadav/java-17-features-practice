package com.java.version.features.java_17.sealed.classes.payment.p1;

/**
 * if we want to restrict the inheritance we can make the class as final
 * so that no other classes will be able to inherit
 *
 * even if we dont use the final and we move the class that we dont want to inherit to
 * different package then also it will not restrict it from inheritance
 * as the payment class is public
 * even if Payment class is package private (default) still it be restricted
 * but we won't able to access from Payment class from other packages
 * like we cann't create instance in PaymentTest class
 *
 * Top level class can only be Public or package-private
 *
 *
 Summary of Allowed Class Modifiers


 Class Type	                public	    protected	Package-Private (Default)	private
 Top-Level Class	        Yes	        No	        Yes	                        No
 Inner / Nested Class	    Yes	        Yes	        Yes	                        Yes

 *
 * but if we want to let inherit a specific set of classes it was not possible
 * before JDK 15.
 *
 * It was introduced as a preview feature in JDK 15 and made as a standard feature in JDK 17
 *
 * Rules 1:
 * All permitted sealed classes must be either final, sealed or non-sealed
 *
 * because the child will now decide whether it will
 * stop inheritance
 * continue controlled inheritance
 * open inheritance
 *
 *  Rules 2:
 *  Every permitted sub-class should explicitly extend or implement the sealed class
 *
 *   Rules 3:
 *   Every permitted sub-class must belong to same module as the sealed class
 *
 */
// public class Payment {
// public final class Payment {
// class Payment {

public sealed class Payment permits CashPayment, CreditCardPayment, UPIPayment {
}
