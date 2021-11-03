/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.snezhniy

import java.io.File
import kotlin.system.exitProcess

/*
№1. Создать произвольный текстовый файл с названием vxod, содержащий 20
строк. В каждой строке – несколько слов.
Создать класс Prosto. В нем должен быть определен конструктор,
принимающий в качестве параметра текстовую строку. Внутри класса – 2
внутренние переменные целого типа: kolSlov, kolSimvolov. Кроме того, внутри
класса должны быть определены 2 метода – рассчитывающие количество слов
(kolSlov) и количество символов во входной строке конструктора
(KolSimvolov). Создать массив объектов Prosto по количеству строк в файле
vxod (20 элементов).
Создать класс потомок Slogno. В него добавить новую переменную типа
String nov. В эту переменную записывается первое слово входной строки
конструктора. Соответственно класс Slogno должен иметь дополнительный
метод Dop для этого действия. Создать массив объектов Slogno по количеству
строк в файле vxod (20 элементов).
Создать универсальную функцию Obr, принимающую в качестве параметра
массив объектов Prosto и/или Slogno.
Задача функции – выдать на экран параметры объектов:
kolSlov, kolSimvolov, nov.
*/

fun Obr(arr: Collection<Any>) {
    val template = "%0${arr.size.toString().length}d"

    arr.forEachIndexed { index, elem ->
        var msg = ""
        if (elem is Prosto) {
            msg += "#${template.format(index + 1)} | kolSlov: ${elem.kolSlov()}, kolSimvolov: ${elem.kolSimvolov()}"
        }

        if (elem is Slogno) {
            msg += ", nov: ${elem.nov}"
        }

        println(msg)
    }
}

fun main() {
    print("Укадите путь до текстового файла: ")
    val input = readLine().orEmpty().trim()
    val f = File(input)

    if (!f.exists()) {
        println("Указанный файл не существует.")
        exitProcess(1)
    }

    val lines = f.readLines()

    val prostoList = arrayListOf<Prosto>()
    val slognoList = arrayListOf<Slogno>()

    lines.forEach {
        prostoList.add(Prosto(it))
        slognoList.add(Slogno(it))
    }

    Obr(prostoList)
    Obr(slognoList)
}