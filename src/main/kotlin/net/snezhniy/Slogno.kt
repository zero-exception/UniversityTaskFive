/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.snezhniy

class Slogno(s: String) : Prosto(s) {
    val nov: String? get() = s.split("\\s+".toRegex()).firstOrNull()
}