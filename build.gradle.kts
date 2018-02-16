apply {
    plugin("base")
}

task<ListAllThingsTask>("listThings") {
    list = (1..20).toList()
}

task<CountAllThingsTask>("countThings")

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

open class CountAllThingsTask : DefaultTask() {

    @TaskAction
    fun countThings() {
        val count = File(project.buildDir, "listOfThings.txt").readText().split(",").size
        File(project.buildDir, "count.txt").writeText(count.toString())
    }
}