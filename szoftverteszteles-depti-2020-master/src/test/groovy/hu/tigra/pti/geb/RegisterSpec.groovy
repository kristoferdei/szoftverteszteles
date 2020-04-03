package hu.tigra.pti.geb

import hu.tigra.pti.geb.page.LoginPage
import hu.tigra.pti.geb.page.MyAccountPage
import hu.tigra.pti.geb.page.RegisterPage

class RegisterSpec extends BaseSpec {

    def 'Regisztráció'() {
        given: 'Bejelentkező felületre navigálok'
        def loginPage = to LoginPage

        when: 'Kitöltöm a "CREATE AN ACCOUNT" blokkban az "Email address" mezőt egy még nem regisztrált email címmel és a "Create an account" funkciógombra kattintok.'
        loginPage.registerEmailAddress = 'teszt3@email.hu'
        loginPage.registerButton.click()

        then: 'Megjelenik a "Create an account" űrlap.'
        def registerPage = waitFor { at RegisterPage }

        when: 'Kitöltöm a "Your personal information" blokkban az összes mezőt és a "Register" funkciógombra kattintok.'
        registerPage.gender.checked = 'Mr.'
        registerPage.firstName = 'Elek'
        registerPage.lastName = 'Teszt'
        registerPage.password = 'teszt123'
        registerPage.dateOfBirth.value('1990', 'May', '12')
        registerPage.newsletter.check()
        registerPage.offers.check()
        registerPage.firstName2 = 'Proba'
        registerPage.lastName2 = 'Cseresznye'
        registerPage.company = 'Jani vagyok Bt.'
        registerPage.address = 'Bánat utca'
        registerPage.address2 = '69/2'
        registerPage.city = 'Seváros'
        registerPage.state.value2('Montana')
        registerPage.postcode = '00700'
        registerPage.other = 'blablablaaaaaaaaaaaaaaaaaa'
        registerPage.homephone = '001500123'
        registerPage.mobile = '06205432198'
        registerPage.alias = 'címem'
        registerPage.registerButton.click()

        then: 'Megjelenik a felhasználó adatai felület: "My account".'
        def myAccountPage = waitFor { at MyAccountPage }
        myAccountPage.header.text() == "MY ACCOUNT"
    }
}
