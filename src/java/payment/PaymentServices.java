/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import entity.InvoiceDetail;
import entity.ShopListItem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class PaymentServices {

    private static final String CLIENT_ID = "AVRBSJjqU1FUvrBbvth5vps4IVOtzEHl10PiO5SuC_aUPQYaxJ8IEIo5i9F6FXtDCH2UiUtYt-O-C8KY";
    private static final String CLIENT_SECRET = "EKe5YkHxSwN91CNMJxYrQsJKRBMGPn5Fn0DDQ8nc0FD_-KjNUHvOtjOgtiCVw--IgTrMJ_Xkk36IDK2Z";
    private static final String MODE = "sandbox";

    public String authorizePayment(ShopListItem orderDetail)
            throws PayPalRESTException {

        Payer payer = getPayerInformation();
        RedirectUrls redirectUrls = getRedirectURLs();
        List<Transaction> listTransaction = getTransactionInformation(orderDetail);

        Payment requestPayment = new Payment();
        requestPayment.setTransactions(listTransaction);
        requestPayment.setRedirectUrls(redirectUrls);
        requestPayment.setPayer(payer);
        requestPayment.setIntent("authorize");

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        Payment approvedPayment = requestPayment.create(apiContext);

        return getApprovalLink(approvedPayment);

    }

    private Payer getPayerInformation() {
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName("William")
                .setLastName("Peterson")
                .setEmail("william.peterson@company.com");

        payer.setPayerInfo(payerInfo);

        return payer;
    }

    private RedirectUrls getRedirectURLs() {
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8084/AssignmentPRJ301_RubikShop_Edited/ListItem.jsp");
        redirectUrls.setReturnUrl("http://localhost:8084/AssignmentPRJ301_RubikShop_Edited/review_payment");

        return redirectUrls;
    }

    private List<Transaction> getTransactionInformation(ShopListItem items) {
        Details details = new Details();
        details.setShipping("10");
        details.setSubtotal(items.getTotal()+"");
        details.setTax("0");

        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal((items.getTotal()+10)+"");
        amount.setDetails(details);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription("Rubik");
//------------------------------------------------
        ItemList itemList = new ItemList();
        List<Item> allitems = new ArrayList<>();
        List<entity.Item> listItem = items.getList();
        for (entity.Item allitem : listItem) {
            Item item = new Item();
            item.setCurrency("USD");
            item.setName(allitem.getProduct().getProductName());
            item.setPrice(""+allitem.getTotalPrice());
            item.setTax("0");
            item.setQuantity(""+allitem.getQuantity());
            allitems.add(item);
        }

        itemList.setItems(allitems);
        transaction.setItemList(itemList);

        List<Transaction> listTransaction = new ArrayList<>();
        listTransaction.add(transaction);

        return listTransaction;
    }

    private String getApprovalLink(Payment approvedPayment) {
        List<Links> links = approvedPayment.getLinks();
        String approvalLink = null;

        for (Links link : links) {
            if (link.getRel().equalsIgnoreCase("approval_url")) {
                approvalLink = link.getHref();
                break;
            }
        }

        return approvalLink;
    }

    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        return Payment.get(apiContext, paymentId);
    }

    public Payment executePayment(String paymentId, String payerId)
            throws PayPalRESTException {
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);

        Payment payment = new Payment().setId(paymentId);

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        return payment.execute(apiContext, paymentExecution);
    }
}
