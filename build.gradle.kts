apply {
    plugin("base")
}

task<ListAllThingsTask>("listThings")

open class ListAllThingsTask : DefaultTask() {

    @Input
    val list = (1..20).toList()

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
