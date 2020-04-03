package hu.tigra.pti.geb.page

import geb.Page
import geb.module.Checkbox
import geb.module.RadioButtons

import hu.tigra.pti.geb.module.Date
import hu.tigra.pti.geb.module.ErrorMessages
import hu.tigra.pti.geb.module.State

class RegisterPage extends Page {

    static url = 'index.php?controller=authentication&back=my-account#account-creation'

    static at = { header.text() == 'CREATE AN ACCOUNT' }

    static content = {
        header { $('h1[class="page-heading"]') }
        gender { $('input[type="radio"][name="id_gender"]').module(RadioButtons) }
        firstName { $('input[id="customer_firstname"]') }
        lastName { $('input[id="customer_lastname"]') }
        password { $('input[id="passwd"]') }
        dateOfBirth { module(Date) }
        newsletter { $('input[id="newsletter"]').module(Checkbox) }
        offers { $('input[id="optin"]').module(Checkbox) }
        registerButton { $('button[id="submitAccount"]') }
        errorMessages(required: false) { $('div[class="alert alert-danger"]:first-of-type').module ErrorMessages }
        firstName2 { $('input[id="firstname"]') }
        lastName2 { $('input[id="lastname"]') }
        company { $('input[id="company"]') }
        address { $('input[id="address1"]') }
        address2 { $('input[id="address2"]') }
        city { $('input[id="city"]') }
        state {(module(State))}
        postcode { $('input[id="postcode"]') }
        other { $('textarea[id="other"]') }
        homephone { $('input[id="phone"]') }
        mobile { $('input[id="phone_mobile"]') }
        alias { $('input[id="alias"]') }
    }
}
