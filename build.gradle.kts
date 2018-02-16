apply {
    plugin("base")
    plugin<CountAllTheThingsPlugin>()
}

val listThings by tasks.getting(ListAllThingsTask::class) {
    list = (1..20).toList()
}
