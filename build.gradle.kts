apply {
    plugin("base")
}

task<ListAllThingsTask>("listThings") {
    list = (1..20).toList()
}

open class ListAllThingsTask : DefaultTask() {

    @Input
    lateinit var list: Iterable<Any>

    @OutputFile
    val listFile = File(project.buildDir, "listOfThings.txt")

    @TaskAction
    fun listThings() {
        list.forEach {
            println(it)
            Thread.sleep(200)
        }
        listFile.writeText(list.joinToString())
    }
}
