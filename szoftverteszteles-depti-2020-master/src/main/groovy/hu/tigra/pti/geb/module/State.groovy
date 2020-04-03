package hu.tigra.pti.geb.module

import geb.Module

class State extends Module {

    static content = {
        state { $('select[id="id_state"]') }
    }

    def value2(state) {
        this.state = state
    }

}
