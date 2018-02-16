apply {
    plugin("base")
    plugin<CountAllTheThingsPlugin>()
}

val listThings by tasks.getting(ListAllThingsTask::class) {
    list = (1..11).toList()
}

artifacts {
    add("default", listThings.outputs.files.singleFile) {
        builtBy(listThings)
    }
}