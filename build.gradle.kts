apply {
    plugin("base")
}

task("listThings") {
    doLast {
        val list = 1..20
        val listFile = File(buildDir, "listOfThings.txt")

        list.forEach {
            println(it)
            Thread.sleep(200)
        }
        listFile.writeText(list.joinToString())
    }
}
