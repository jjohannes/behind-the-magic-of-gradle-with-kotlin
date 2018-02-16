apply {
    plugin("base")
}

task("listThings") {
    doLast {
        (1..20).forEach {
            println(it)
            Thread.sleep(200)
        }
    }
}
