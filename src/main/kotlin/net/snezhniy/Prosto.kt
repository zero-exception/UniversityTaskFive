/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.snezhniy

open class Prosto(val s: String) {
    fun kolSimvolov(): Int {
        return s.length
    }

    fun kolSlov(): Int {
        return s.split("\\s+".toRegex()).size
    }


}