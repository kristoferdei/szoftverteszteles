package hu.tigra.pti.geb.page

import geb.Page
import geb.module.Checkbox
import hu.tigra.pti.geb.module.ProductRow

class OrderPage extends Page {

    static url = "/index.php?controller=order"

    static at = { title == 'Order - My Store' && header.displayed }

    static content = {
        header { $('h1[class="page-heading"]') }

        nextButton(required: false) { $('p.cart_navigation').$('.button.btn.btn-default.button-medium') }

        // 3. házi feladat
        // A summaryFirstRow a táblázat első sorát választja ki
        // A táblázat "tbody"-ában az első "tr"-t kell beadni a ProductRow modulba
        summaryFirstRow(required: false) { $('tbody tr:first-of-type').module(ProductRow) }

        shippingAgreeTerms(required: false) { $('input[id="cgv"]').module(Checkbox) }

        paymentCheckButton(required: false) { $('p[class="payment_module"] a[class="cheque"]') }

        message(required: false) { $('p[class="alert alert-success"]:first-of-type') }

        plusButton(required: false) { $('a[id="cart_quantity_up_7_34_0_279051"]') }

        ptc(required: false) { $('p[class="cart_navigation clearfix"] a:first-of-type') }

        processAddress(required: false) { $('p[class="cart_navigation clearfix"] button[class="button btn btn-default button-medium"]') }

        processCarrier(required: false) { $('p[class="cart_navigation clearfix"] button[class="button btn btn-default standard-checkout button-medium"]')}

        confirmOrder { $('p.cart_navigation').$('.button.btn.btn-default.button-medium') }
    }
}
