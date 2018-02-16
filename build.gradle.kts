apply {
    plugin("base")
    plugin<CountAllTheThingsPlugin>()
}

dependencies {
    "allThings"(project(":moreThings"))
}

val listThings by tasks.getting(ListAllThingsTask::class) {
    list = (1..20).toList()
}
