apply {
    plugin("base")
}

val listTask = task<ListAllThingsTask>("listThings") {
    list = (1..20).toList()
}

task<CountAllThingsTask>("countThings") {
    listFile = listTask.outputs.files
}
